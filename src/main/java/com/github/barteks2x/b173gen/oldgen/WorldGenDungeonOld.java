package com.github.barteks2x.b173gen.oldgen;

import com.github.barteks2x.b173gen.generator.WorldGenerator173;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

import java.util.Random;

public class WorldGenDungeonOld implements WorldGenerator173 {

    @Override
    public boolean generate(World w, Random random, int xPos, int yPos, int zPos) {
        byte ry = 3;
        int rx = random.nextInt(2) + 2;
        int rz = random.nextInt(2) + 2;
        int j1 = 0;

        int x;
        int y;
        int z;

        for (x = xPos - rx - 1; x <= xPos + rx + 1; ++x) {
            for (y = yPos - 1; y <= yPos + ry + 1; ++y) {
                for (z = zPos - rz - 1; z <= zPos + rz + 1; ++z) {

                    Material block = w.getBlockAt(x, y, z).getType();
                    if (y == yPos - 1 && !block.isSolid()) {
                        return false;
                    }

                    if (y == yPos + ry + 1 && !block.isSolid()) {
                        return false;
                    }

                    if ((x == xPos - rx - 1 || x == xPos + rx + 1 || z == zPos - rz - 1 || z == zPos + rz + 1) && y == yPos &&
                            w.getBlockAt(x, y, z).isEmpty() && w.getBlockAt(x, y + 1, z).isEmpty()) {
                        ++j1;
                    }
                }
            }
        }

        if (j1 < 1 || j1 > 5) {
            return false;
        }
        for (x = xPos - rx - 1; x <= xPos + rx + 1; ++x) {
            for (y = yPos + ry; y >= yPos - 1; --y) {
                for (z = zPos - rz - 1; z <= zPos + rz + 1; ++z) {
                    if (x == xPos - rx - 1 || y == yPos - 1 || z == zPos - rz - 1 ||
                            x == xPos + rx + 1 || y == yPos + ry + 1 || z == zPos + rz + 1) {
                        if (y >= 0 && !w.getBlockAt(x, y - 1, z).getType().isSolid()) {
                            w.getBlockAt(x, y, z).setType(Material.AIR);
                            continue;
                        }
                        if (!w.getBlockAt(x, y, z).getType().isSolid()) {
                            continue;
                        }
                        if (y == yPos - 1 && random.nextInt(4) != 0) {
                            w.getBlockAt(x, y, z).setType(Material.MOSSY_COBBLESTONE);
                        } else {
                            w.getBlockAt(x, y, z).setType(Material.COBBLESTONE);
                        }
                    } else {
                        w.getBlockAt(x, y, z).setType(Material.AIR);
                    }
                }
            }
        }

        for (int var1 = 0; var1 < 2; var1++) {
            for (int var2 = 0; var2 < 3; var2++) {
                int blockX = xPos + random.nextInt(rx * 2 + 1) - rx;
                int blockZ = zPos + random.nextInt(rz * 2 + 1) - rz;

                //search for empty block to place chest in, that is next to a wall
                if (!w.getBlockAt(blockX, yPos, blockZ).isEmpty()) {
                    continue;
                }
                int k2 = 0;

                if (w.getBlockAt(blockX - 1, yPos, blockZ).getType().isSolid()) {
                    ++k2;
                }

                if (w.getBlockAt(blockX + 1, yPos, blockZ).getType().isSolid()) {
                    ++k2;
                }

                if (w.getBlockAt(blockX, yPos, blockZ - 1).getType().isSolid()) {
                    ++k2;
                }

                if (w.getBlockAt(blockX, yPos, blockZ + 1).getType().isSolid()) {
                    ++k2;
                }

                if (k2 != 1) {
                    continue;
                }
                w.getBlockAt(blockX, yPos, blockZ).setType(Material.CHEST);
                Chest chest = (Chest) w.getBlockAt(blockX, yPos, blockZ).getState();
                Inventory inventory = chest.getInventory();
                for (int l2 = 0; l2 < 8; ++l2) {
                    ItemStack itemstack = this.getRandomItem(random);

                    if (itemstack != null) {
                        inventory.setItem(random.nextInt(inventory.getSize()), itemstack);
                    }
                }
                chest.update();
                break;
            }
        }

        w.getBlockAt(xPos, yPos, zPos).setType(Material.MOB_SPAWNER);
        CreatureSpawner tileentitymobspawner = (CreatureSpawner) w.getBlockAt(xPos, yPos, zPos).getState();

        tileentitymobspawner.setCreatureTypeByName(this.getRandomMob(random));
        return true;
    }

    public void scale(double d0, double d1, double d2) {
    }

    private ItemStack getRandomItem(Random random) {
        switch (random.nextInt(11)) {
            case 0:
                return new ItemStack(Material.SADDLE);
            case 1:
                return new ItemStack(Material.IRON_INGOT, random.nextInt(4) + 1);
            case 2:
                return new ItemStack(Material.BREAD);
            case 3:
                return new ItemStack(Material.WHEAT, random.nextInt(4) + 1);
            case 4:
                return new ItemStack(Material.SULPHUR, random.nextInt(4) + 1);
            case 5:
                return new ItemStack(Material.STRING, random.nextInt(4) + 1);
            case 6:
                return new ItemStack(Material.BUCKET);
            case 7:
                if (random.nextInt(100) == 0) {
                    return new ItemStack(Material.GOLDEN_APPLE);
                } else {
                    return null;
                }
            case 8:
                if (random.nextInt(2) == 0) {
                    return new ItemStack(Material.REDSTONE, random.nextInt(4) + 1);
                } else {
                    return null;
                }
            case 9:
                if (random.nextInt(10) == 0) {
                    if(random.nextInt(2) == 0) {
                        return new ItemStack(Material.GOLD_RECORD);
                    } else {
                        return new ItemStack(Material.GREEN_RECORD);
                    }
                } else {
                    return null;
                }
            case 10:
                return new Dye(DyeColor.BLACK).toItemStack();
            default:
                throw new AssertionError();
        }
    }

    private String getRandomMob(Random random) {
        switch (random.nextInt(4)) {
            case 0:
                return "Skeleton";
            case 1:
                return "Zombie";
            case 2:
                return "Zombie";
            case 3:
                return "Spider";
            default:
                return "";
        }
    }
}
