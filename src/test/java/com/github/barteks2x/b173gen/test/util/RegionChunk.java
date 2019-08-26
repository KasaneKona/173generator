package com.github.barteks2x.b173gen.test.util;

import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.stream.NBTInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.bukkit.block.data.BlockData;

public class RegionChunk {
    private static final int SECTOR_BYTES = 4096;
    private final RegionFile regionFile;
    private final RegionChunkPosition regionChunkPosition;
    private final int offset;
    private final int count;

    public RegionChunk(RegionFile regionFile, RegionChunkPosition regionChunkPosition, int offset, int count) {

        this.regionFile = regionFile;
        this.regionChunkPosition = regionChunkPosition;
        this.offset = offset;
        this.count = count;
    }

    public ChunkData loadData() throws IOException, DataFormatException {
            RandomAccessFile raf = regionFile.getRandomAccessFile("r");
            int offsetBytes = offset * SECTOR_BYTES;
            int sizeBytes = count * SECTOR_BYTES;
            raf.seek(offsetBytes);
            byte[] data = new byte[sizeBytes];
            raf.read(data);
            raf.close();
            int dataLength =
                    ((data[0] & 0xFF) << 24) |
                            ((data[1] & 0xFF) << 16) |
                            ((data[2] & 0xFF) << 8) |
                            ((data[3] & 0xFF) << 0);
            byte[] compressedData = new byte[dataLength - 1];
            System.arraycopy(data, 5, compressedData, 0, dataLength - 1);
            byte[] uncompressed = decompress(compressedData);
            NBTInputStream nbtIn = new NBTInputStream(new ByteArrayInputStream(uncompressed), false);
            CompoundTag tag = (CompoundTag) nbtIn.readTag();
            nbtIn.close();
            CompoundTag level = (CompoundTag) tag.getValue().get("Level");

            ChunkData.Builder builder = ChunkData.builder();
            builder.setPosition(regionChunkPosition);
            byte[] blockIdsLsb = (byte[]) level.getValue().get("Blocks").getValue();
            byte[] metadata = (byte[]) level.getValue().get("Data").getValue();
            int expectedBlocks = 16*16*128;
            if(metadata.length != expectedBlocks/2) {
            	throw new UnsupportedOperationException(
            			"Block metadata in chunk "+regionChunkPosition.toString()+
            			" does not match block IDs length!"+
            			" Expected "+(expectedBlocks/2)+", got "+metadata.length);
            }
            if(blockIdsLsb.length != expectedBlocks) {
            	throw new UnsupportedOperationException(
            			"Block IDs in chunk "+regionChunkPosition.toString()+
            			" has wrong length!"+
            			" Expected "+expectedBlocks+", got "+blockIdsLsb.length);
            }
            // Lazily convert block ID and metadata to palette entries, then optimize afterwards
            int[] paletteIds = new int[blockIdsLsb.length];
            List<String> palette = Arrays.asList(new String[256*16]);
            for(int i = 0; i < blockIdsLsb.length; i++) {
            	int id = blockIdsLsb[i]&0xFF;
            	int meta = (metadata[i>>1]>>((i&1)<<2)) & 0x0F; // Low nybble for even blocks, high nybble for odd blocks;
            	int extendedId = BlockUtils.idMeta(id, meta);
            	paletteIds[i] = extendedId;
            	if(palette.get(extendedId) == null) {
            		palette.set(extendedId, BlockUtils.getStateForOldId(id, meta));
            	}
            }
            builder.setData(paletteIds, palette);
            return ChunkData.optimizePalette(builder.build());
    }

    private byte[] decompress(byte[] compressedData) throws DataFormatException, IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(compressedData);
        byte[] cache = new byte[4096];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (!inflater.finished()) {
            inflater.inflate(cache);
            out.write(cache);
        }
        return out.toByteArray();
    }
}
