package com.github.barteks2x.b173gen.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.BlockData;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.material.MaterialData;

public class ChunkData implements ChunkGenerator.ChunkData{
    private final RegionChunkPosition position;
    private final int[] paletteIds;
    private Map<String, Integer> paletteToId;
    private List<String> paletteFromId;
    private boolean populated;

    private ChunkData(Builder builder) {
        this.paletteIds = builder.paletteIds;
        this.paletteToId = builder.paletteToId;
        this.paletteFromId = builder.paletteFromId;
        this.position = builder.regionChunkPosition;
    }

    public static ChunkData.Builder builder() {
        return new Builder();
    }

    public static ChunkData empty(int x, int z) {
        return builder().setData(new int[16*16*128], new ArrayList<String>()).setPosition(RegionChunkPosition.fromChunkPos(x, z)).build();
    }

    public int getX() {
        return position.getChunkX();
    }

    public int getZ() {
        return position.getChunkZ();
    }

    public Material getBlock(int x, int y, int z) {
        if(y >= 128) {
            return Material.AIR;
        }
        //return getBlockData(x,y,z).getMaterial();
        int pos = y | z << 7 | x << 11;
        if(pos < 0 || pos >= paletteIds.length) return Material.AIR;
        String blockName = paletteFromId.get(paletteIds[pos]).toUpperCase();
        if(blockName.contains("[")) blockName = blockName.substring(0, blockName.indexOf("["));
        return Material.getMaterial(blockName);
    }

    public RegionChunkPosition getPosition() {
        return position;
    }

    @Override
    public int getMaxHeight() {
        return 128;
    }

    @Override
    public void setBlock(int x, int y, int z, Material material) {
        String dataString = material.getKey().getKey();
        setBlock(x, y, z, dataString);
    }
    
    public static ChunkData optimizePalette(ChunkData data) {
    	Map<String, Integer> newPaletteToId = new HashMap<String, Integer>();
    	List<String> newPaletteFromId = new ArrayList<String>();
    	for(int i = 0; i < data.paletteIds.length; i++) {
    		String blockData = data.paletteFromId.get(data.paletteIds[i]);
    		if(!newPaletteToId.containsKey(blockData)) {
    			Integer id = Integer.valueOf(newPaletteFromId.size());
    			newPaletteToId.put(blockData, id);
    			newPaletteFromId.add(id, blockData);
    			data.paletteIds[i] = id;
    		} else {
    			data.paletteIds[i] = newPaletteToId.get(blockData);
    		}
    	}
    	data.paletteToId=newPaletteToId;
    	data.paletteFromId=newPaletteFromId;
    	return data;
    }

    @Override
    public void setBlock(int x, int y, int z, MaterialData materialData) {
        setBlock(x, y, z, materialData.getItemType());
    }

    @Override
    public void setRegion(int i, int i1, int i2, int i3, int i4, int i5, Material material) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void setRegion(int i, int i1, int i2, int i3, int i4, int i5, MaterialData materialData) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Material getType(int i, int i1, int i2) {
        return getBlock(i, i1, i2);
    }

    @Override
    public MaterialData getTypeAndData(int i, int i1, int i2) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public byte getData(int i, int i1, int i2) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean isPopulated() {
        return populated;
    }

    public void setPopulated(boolean populated) {
        this.populated = populated;
    }

    public static class Builder {
        private RegionChunkPosition regionChunkPosition;
        private int[] paletteIds;
        private Map<String, Integer> paletteToId;
        private List<String> paletteFromId;

        public Builder setPosition(RegionChunkPosition regionChunkPosition) {
            this.regionChunkPosition = regionChunkPosition;
            return this;
        }
        public ChunkData build() {
            return new ChunkData(this);
        }

        public Builder setData(int[] paletteIds, List<String> paletteFromId) {
            this.paletteIds = paletteIds;
            this.paletteFromId = paletteFromId;
            this.paletteToId = new HashMap<String, Integer>();
            for(int id = 0; id < paletteFromId.size(); id++) {
            	String blockData = paletteFromId.get(id);
            	paletteFromId.set(id, blockData);
            }
            return this;
        }
    }

	@Override
	public void setBlock(int x, int y, int z, BlockData blockData) {
		String dataString = blockData.getAsString();
        setBlock(x,y,z,dataString);
	}
	
	private void setBlock(int x, int y, int z, String dataString) {
        int pos = y | z << 7 | x << 11;
        if(pos < 0 || pos >= paletteIds.length) return;
        Integer index = Integer.valueOf(paletteToId.size());
        if(!paletteToId.containsKey(dataString)) {
        	paletteToId.put(dataString, index);
        	paletteFromId.add(index, dataString);
        }
        if(paletteToId.size() > 256) { // Testing, is optimization ever needed or triggered?
        	//optimizePalette(this);
        }
        paletteIds[pos] = paletteToId.get(dataString);
	}

	@Override
	public void setRegion(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, BlockData blockData) {
        throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public BlockData getBlockData(int x, int y, int z) {
        int pos = y | z << 7 | x << 11;
        if(pos < 0 || pos >= paletteIds.length) return null;
		return Bukkit.getServer().createBlockData(paletteFromId.get(paletteIds[pos]));
	}
}
