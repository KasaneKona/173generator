package com.github.barteks2x.b173gen;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;

public class BukkitSimpleWorldImpl implements ISimpleWorld {
	private final World world;

	public BukkitSimpleWorldImpl(World world) {
		this.world = world;
	}

	@Override public Material getType(int x, int y, int z) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Getting type in unready chunk!");
			// TODO - Check if this hack affects results
			return Material.AIR; // Hack to prevent recursive population
		}
		return world.getBlockAt(x, y, z).getType();
	}

	@Override public void setType(int x, int y, int z, Material material) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Setting type in unready chunk!");
			// TODO - Check if this hack affects results
			return; // Hack to prevent recursive population
		}
	    Block block = world.getBlockAt(x, y, z);
	    block.setType(material, false); // No block updates to prevent recursive population
	}

	@Override public boolean isEmpty(int x, int y, int z) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Checking empty in unready chunk!");
			return false; // TODO - test if should be true
		}
		return world.getBlockAt(x, y, z).isEmpty();
	}

	@Override public int getBlockLight(int x, int y, int z) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Getting block light in unready chunk!");
			return 0;
		}
		if(y < 0 || y > 255) {
			return 0;
		}
		return world.getBlockAt(x, y, z).getLightFromBlocks();
	}

	@Override public int getSkyLight(int x, int y, int z) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Getting sky light in unready chunk!");
			return 15;
		}
		if(y < 0) {
			return 0;
		}
		if(y > 255) {
			return 15;
		}
		return world.getBlockAt(x, y, z).getLightFromSky();
	}

	@Override public BlockState getBlockState(int x, int y, int z) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Getting block state in unready chunk!");
			return null; // Will this cause problems?
		}
		return world.getBlockAt(x, y, z).getState();
	}

	@Override public int getHighestBlockYAt(int x, int z) {
		if(!chunkReady(x, z)) {
			//Generator.logger().warning("Getting height map in unready chunk!");
			return 0;
		}
		return world.getHighestBlockYAt(x, z);
	}
	
	private boolean chunkReady(int blockX, int blockZ) {
		int chunkX = blockX >> 4;
		int chunkZ = blockZ >> 4;
		// Check if the chunk exists (if it does, ensure it's loaded)
		// but don't trigger recursive generation
		if(world.isChunkLoaded(chunkX, chunkZ)) return true;
		//return world.loadChunk(chunkX, chunkZ, false);
		return world.isChunkGenerated(chunkX, chunkZ);
	}
}
