package com.github.barteks2x.b173gen.oldgen;

import com.github.barteks2x.b173gen.ISimpleWorld;
import org.bukkit.Material;

import static com.github.barteks2x.b173gen.oldgen.LightType.BLOCK;
import static org.bukkit.Material.*;

public class MinecraftMethods {
    public static boolean isLiquid(Material m) {
    	return (m == WATER) || (m == LAVA);
    }

    public static int World_getlightValue(ISimpleWorld w, int x, int y, int z, LightType type) {
        return type == BLOCK ?
                w.getBlockLight(x, y, z) :
                w.getSkyLight(x, y, z);
    }

    public static boolean Block_canPlace(Material block, ISimpleWorld w, int x, int y, int z) {
        if(!w.isEmpty(x, y, z)) {
            return false;
        }
        Material below = w.getType(x, y - 1, z);
        if(block == DANDELION
                || block == POPPY) {
            return below == DIRT || below == GRASS_BLOCK || below == FARMLAND;
        }
        if(block == DEAD_BUSH) {
            return below == SAND;
        }
        if(block == PUMPKIN || block == CARVED_PUMPKIN) {
            return below != AIR;
        }
        if(block == GRASS) {
            return below == DIRT || below == GRASS_BLOCK;
        }
        if(block == BROWN_MUSHROOM || block == RED_MUSHROOM) {
            int light = Math.max(w.getBlockLight(x, y, z), w.getSkyLight(x, y, z));
            return (below == DIRT || below == GRASS_BLOCK) && light < 13;
        }
        if(block == SUGAR_CANE) {
            Material x0z1 = w.getType(x, y - 1, z + 1);
            Material x0z_1 = w.getType(x, y - 1, z - 1);
            Material x1z0 = w.getType(x + 1, y - 1, z);
            Material x_1z0 = w.getType(x - 1, y - 1, z);
            return below == SUGAR_CANE
                    || ((below == DIRT || below == GRASS_BLOCK || below == SAND)
                    && (isLiquid(x1z0) || isLiquid(x_1z0) || isLiquid(x0z1) || isLiquid(x0z_1)));
        }
        throw new IllegalArgumentException(block.name());
    }

    public static boolean Material_isSolid(ISimpleWorld w, int x, int y, int z) {
    	return w.getType(x, y, z).isSolid();
    }

    private MinecraftMethods() {
        throw new IllegalStateException();
    }
}
