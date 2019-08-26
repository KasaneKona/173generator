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
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Getting type in unloaded chunk!");
			// TODO - Check if this hack affects results
			return Material.AIR; // Hack to prevent recursive population
		}
		return world.getBlockAt(x, y, z).getType();
	}

	@Override public void setType(int x, int y, int z, Material material) {
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Setting type in unloaded chunk!");
			// TODO - Check if this hack affects results
			return; // Hack to prevent recursive population
		}
	    Block block = world.getBlockAt(x, y, z);
	    block.setType(material, false); // No block updates
	}

	@Override public boolean isEmpty(int x, int y, int z) {
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Checking empty in unloaded chunk!");
			return false; // TODO - test if should be true
		}
		return world.getBlockAt(x, y, z).isEmpty();
	}

	@Override public int getBlockLight(int x, int y, int z) {
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Getting block light in unloaded chunk!");
			return 0;
		}
		if(y < 0 || y > 255) {
			return 0;
		}
		return world.getBlockAt(x, y, z).getLightFromBlocks();
	}

	@Override public int getSkyLight(int x, int y, int z) {
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Getting sky light in unloaded chunk!");
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
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Getting block state in unloaded chunk!");
			return null; // Will this cause problems?
		}
		return world.getBlockAt(x, y, z).getState();
	}

	@Override public int getHighestBlockYAt(int x, int z) {
		if(!world.isChunkLoaded(x>>4, z>>4)) {
			//Generator.logger().warning("Getting height map in unloaded chunk!");
			return 0;
		}
		return world.getHighestBlockYAt(x, z);
	}
}
