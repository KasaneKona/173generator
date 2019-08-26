package com.github.barteks2x.b173gen.test.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

import net.minecraft.server.v1_14_R1.Blocks;

import java.util.HashMap;
import java.util.Map;

public class BlockUtils {
    private static final Map<Material, Integer> opacityMap = new HashMap<>();
    private static final Map<Integer, String> oldIdStateMap = new HashMap<>();
    
    private static String[] normalRailShapes=new String[] {
		"north_south","east_west","ascending_east","ascending_west","ascending_north","ascending_south",
		"south_east","south_west","north_west","north_east"};
    private static String[] straightRailShapes=new String[] {
    		"north_south","east_west","ascending_east","ascending_west","ascending_north","ascending_south"};
    private static String[] directional6=new String[] {"down","up","north","south","west","east"};
    private static String[] stairTorchDirections=new String[] {"east","west","south","north"};
    private static String[] trapdoorDirections=new String[] {"north","south","west","east"};
    private static String[] leverFaces=new String[] {"ceiling","wall","wall","wall","wall","floor","floor","ceiling"};
    private static String[] leverDirections=new String[] {"west","east","west","south","north","north","west","north"};
    // Repeater 'facing' directions are the *input* side in 1.14
    private static String[] pumpkinRepeaterDirections=new String[] {"south","west","north","east"};
    private static String[] blockDyeColors=new String[] {
    	"white","orange","magenta","light_blue","yellow","lime","pink","gray",
    	"light_gray","cyan","purple","blue","brown","green","red","black"};
    // Recommend not using petrified oak slab
    private static String[] slabTypes=new String[] {
    	"smooth_stone","sandstone","petrified_oak","cobblestone"};
    private static String[] doorFacing=new String[] {
    		"east","south","west","north"};

    static {
    	opacityMap.put(Material.ACACIA_BUTTON, 0);
    	opacityMap.put(Material.ACACIA_DOOR, 0);
    	opacityMap.put(Material.ACACIA_FENCE, 0);
    	opacityMap.put(Material.ACACIA_FENCE_GATE, 0);
    	opacityMap.put(Material.ACACIA_LEAVES, 1);
    	opacityMap.put(Material.ACACIA_LOG, 255);
    	opacityMap.put(Material.ACACIA_PLANKS, 255);
    	opacityMap.put(Material.ACACIA_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.ACACIA_SAPLING, 0);
    	opacityMap.put(Material.ACACIA_SIGN, 0);
    	opacityMap.put(Material.ACACIA_SLAB, 255);
    	opacityMap.put(Material.ACACIA_STAIRS, 255);
    	opacityMap.put(Material.ACACIA_TRAPDOOR, 0);
    	opacityMap.put(Material.ACACIA_WALL_SIGN, 0);
    	opacityMap.put(Material.ACACIA_WOOD, 0);
    	opacityMap.put(Material.ACTIVATOR_RAIL, 0);
    	opacityMap.put(Material.AIR, 0);
    	opacityMap.put(Material.ALLIUM, 0);
    	opacityMap.put(Material.ANDESITE, 255);
    	opacityMap.put(Material.ANDESITE_SLAB, 255);
    	opacityMap.put(Material.ANDESITE_STAIRS, 255);
    	opacityMap.put(Material.ANDESITE_WALL, 0);
    	opacityMap.put(Material.ANVIL, 0);
    	opacityMap.put(Material.ATTACHED_MELON_STEM, 0);
    	opacityMap.put(Material.ATTACHED_PUMPKIN_STEM, 0);
    	opacityMap.put(Material.AZURE_BLUET, 0);
    	opacityMap.put(Material.BAMBOO, 0);
    	opacityMap.put(Material.BAMBOO_SAPLING, 0);
    	opacityMap.put(Material.BARREL, 255);
    	opacityMap.put(Material.BARRIER, 0);
    	opacityMap.put(Material.BEACON, 0);
    	opacityMap.put(Material.BEDROCK, 255);
    	opacityMap.put(Material.BEETROOTS, 0);
    	opacityMap.put(Material.BELL, 0);
    	opacityMap.put(Material.BIRCH_BUTTON, 0);
    	opacityMap.put(Material.BIRCH_DOOR, 0);
    	opacityMap.put(Material.BIRCH_FENCE, 0);
    	opacityMap.put(Material.BIRCH_FENCE_GATE, 0);
    	opacityMap.put(Material.BIRCH_LEAVES, 1);
    	opacityMap.put(Material.BIRCH_LOG, 255);
    	opacityMap.put(Material.BIRCH_PLANKS, 255);
    	opacityMap.put(Material.BIRCH_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.BIRCH_SAPLING, 0);
    	opacityMap.put(Material.BIRCH_SIGN, 0);
    	opacityMap.put(Material.BIRCH_SLAB, 255);
    	opacityMap.put(Material.BIRCH_STAIRS, 255);
    	opacityMap.put(Material.BIRCH_TRAPDOOR, 0);
    	opacityMap.put(Material.BIRCH_WALL_SIGN, 0);
    	opacityMap.put(Material.BIRCH_WOOD, 255);
    	opacityMap.put(Material.BLACK_BANNER, 0);
    	opacityMap.put(Material.BLACK_BED, 0);
    	opacityMap.put(Material.BLACK_CARPET, 0);
    	opacityMap.put(Material.BLACK_CONCRETE, 255);
    	opacityMap.put(Material.BLACK_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.BLACK_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.BLACK_SHULKER_BOX, 1);
    	opacityMap.put(Material.BLACK_STAINED_GLASS, 0);
    	opacityMap.put(Material.BLACK_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.BLACK_TERRACOTTA, 255);
    	opacityMap.put(Material.BLACK_WALL_BANNER, 0);
    	opacityMap.put(Material.BLACK_WOOL, 255);
    	opacityMap.put(Material.BLAST_FURNACE, 255);
    	opacityMap.put(Material.BLUE_BANNER, 0);
    	opacityMap.put(Material.BLUE_BED, 0);
    	opacityMap.put(Material.BLUE_CARPET, 0);
    	opacityMap.put(Material.BLUE_CONCRETE, 255);
    	opacityMap.put(Material.BLUE_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.BLUE_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.BLUE_ICE, 255);
    	opacityMap.put(Material.BLUE_ORCHID, 0);
    	opacityMap.put(Material.BLUE_SHULKER_BOX, 1);
    	opacityMap.put(Material.BLUE_STAINED_GLASS, 0);
    	opacityMap.put(Material.BLUE_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.BLUE_TERRACOTTA, 255);
    	opacityMap.put(Material.BLUE_WALL_BANNER, 0);
    	opacityMap.put(Material.BLUE_WOOL, 255);
    	opacityMap.put(Material.BONE_BLOCK, 255);
    	opacityMap.put(Material.BOOKSHELF, 255);
    	opacityMap.put(Material.BRAIN_CORAL, 0);
    	opacityMap.put(Material.BRAIN_CORAL_BLOCK, 255);
    	opacityMap.put(Material.BRAIN_CORAL_FAN, 0);
    	opacityMap.put(Material.BRAIN_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.BREWING_STAND, 0);
    	opacityMap.put(Material.BRICK_SLAB, 255);
    	opacityMap.put(Material.BRICK_STAIRS, 255);
    	opacityMap.put(Material.BRICK_WALL, 0);
    	opacityMap.put(Material.BRICKS, 255);
    	opacityMap.put(Material.BROWN_BANNER, 0);
    	opacityMap.put(Material.BROWN_BED, 0);
    	opacityMap.put(Material.BROWN_CARPET, 0);
    	opacityMap.put(Material.BROWN_CONCRETE, 255);
    	opacityMap.put(Material.BROWN_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.BROWN_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.BROWN_MUSHROOM, 0);
    	opacityMap.put(Material.BROWN_MUSHROOM_BLOCK, 255);
    	opacityMap.put(Material.BROWN_SHULKER_BOX, 1);
    	opacityMap.put(Material.BROWN_STAINED_GLASS, 0);
    	opacityMap.put(Material.BROWN_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.BROWN_TERRACOTTA, 255);
    	opacityMap.put(Material.BROWN_WALL_BANNER, 0);
    	opacityMap.put(Material.BROWN_WOOL, 255);
    	opacityMap.put(Material.BUBBLE_COLUMN, 1);
    	opacityMap.put(Material.BUBBLE_CORAL, 0);
    	opacityMap.put(Material.BUBBLE_CORAL_BLOCK, 255);
    	opacityMap.put(Material.BUBBLE_CORAL_FAN, 0);
    	opacityMap.put(Material.BUBBLE_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.CACTUS, 0);
    	opacityMap.put(Material.CAKE, 0);
    	opacityMap.put(Material.CAMPFIRE, 0);
    	opacityMap.put(Material.CARROTS, 0);
    	opacityMap.put(Material.CARTOGRAPHY_TABLE, 255);
    	opacityMap.put(Material.CARVED_PUMPKIN, 255);
    	opacityMap.put(Material.CAULDRON, 0);
    	opacityMap.put(Material.CAVE_AIR, 0);
    	opacityMap.put(Material.CHAIN_COMMAND_BLOCK, 255);
    	opacityMap.put(Material.CHEST, 0);
    	opacityMap.put(Material.CHIPPED_ANVIL, 0);
    	opacityMap.put(Material.CHISELED_QUARTZ_BLOCK, 255);
    	opacityMap.put(Material.CHISELED_RED_SANDSTONE, 255);
    	opacityMap.put(Material.CHISELED_SANDSTONE, 255);
    	opacityMap.put(Material.CHISELED_STONE_BRICKS, 255);
    	opacityMap.put(Material.CHORUS_FLOWER, 0);
    	opacityMap.put(Material.CHORUS_PLANT, 0);
    	opacityMap.put(Material.CLAY, 255);
    	opacityMap.put(Material.COAL_BLOCK, 255);
    	opacityMap.put(Material.COAL_ORE, 255);
    	opacityMap.put(Material.COARSE_DIRT, 255);
    	opacityMap.put(Material.COBBLESTONE, 255);
    	opacityMap.put(Material.COBBLESTONE_SLAB, 255);
    	opacityMap.put(Material.COBBLESTONE_STAIRS, 255);
    	opacityMap.put(Material.COBBLESTONE_WALL, 0);
    	opacityMap.put(Material.COBWEB, 1);
    	opacityMap.put(Material.COCOA, 0);
    	opacityMap.put(Material.COMMAND_BLOCK, 255);
    	opacityMap.put(Material.COMPARATOR, 0);
    	opacityMap.put(Material.COMPOSTER, 0);
    	opacityMap.put(Material.CONDUIT, 1);
    	opacityMap.put(Material.CORNFLOWER, 0);
    	opacityMap.put(Material.CRACKED_STONE_BRICKS, 255);
    	opacityMap.put(Material.CRAFTING_TABLE, 255);
    	opacityMap.put(Material.CREEPER_HEAD, 0);
    	opacityMap.put(Material.CREEPER_WALL_HEAD, 0);
    	opacityMap.put(Material.CUT_RED_SANDSTONE, 255);
    	opacityMap.put(Material.CUT_RED_SANDSTONE_SLAB, 255);
    	opacityMap.put(Material.CUT_SANDSTONE, 255);
    	opacityMap.put(Material.CUT_SANDSTONE_SLAB, 255);
    	opacityMap.put(Material.CYAN_BANNER, 0);
    	opacityMap.put(Material.CYAN_BED, 0);
    	opacityMap.put(Material.CYAN_CARPET, 0);
    	opacityMap.put(Material.CYAN_CONCRETE, 255);
    	opacityMap.put(Material.CYAN_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.CYAN_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.CYAN_SHULKER_BOX, 1);
    	opacityMap.put(Material.CYAN_STAINED_GLASS, 0);
    	opacityMap.put(Material.CYAN_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.CYAN_TERRACOTTA, 255);
    	opacityMap.put(Material.CYAN_WALL_BANNER, 0);
    	opacityMap.put(Material.CYAN_WOOL, 255);
    	opacityMap.put(Material.DAMAGED_ANVIL, 0);
    	opacityMap.put(Material.DANDELION, 0);
    	opacityMap.put(Material.DARK_OAK_BUTTON, 0);
    	opacityMap.put(Material.DARK_OAK_DOOR, 0);
    	opacityMap.put(Material.DARK_OAK_FENCE, 0);
    	opacityMap.put(Material.DARK_OAK_FENCE_GATE, 0);
    	opacityMap.put(Material.DARK_OAK_LEAVES, 1);
    	opacityMap.put(Material.DARK_OAK_LOG, 255);
    	opacityMap.put(Material.DARK_OAK_PLANKS, 255);
    	opacityMap.put(Material.DARK_OAK_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.DARK_OAK_SAPLING, 0);
    	opacityMap.put(Material.DARK_OAK_SIGN, 0);
    	opacityMap.put(Material.DARK_OAK_SLAB, 255);
    	opacityMap.put(Material.DARK_OAK_STAIRS, 255);
    	opacityMap.put(Material.DARK_OAK_TRAPDOOR, 0);
    	opacityMap.put(Material.DARK_OAK_WALL_SIGN, 0);
    	opacityMap.put(Material.DARK_OAK_WOOD, 255);
    	opacityMap.put(Material.DARK_PRISMARINE, 255);
    	opacityMap.put(Material.DARK_PRISMARINE_SLAB, 255);
    	opacityMap.put(Material.DARK_PRISMARINE_STAIRS, 255);
    	opacityMap.put(Material.DAYLIGHT_DETECTOR, 0);
    	opacityMap.put(Material.DEAD_BRAIN_CORAL, 0);
    	opacityMap.put(Material.DEAD_BRAIN_CORAL_BLOCK, 255);
    	opacityMap.put(Material.DEAD_BRAIN_CORAL_FAN, 0);
    	opacityMap.put(Material.DEAD_BRAIN_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.DEAD_BUBBLE_CORAL, 0);
    	opacityMap.put(Material.DEAD_BUBBLE_CORAL_BLOCK, 255);
    	opacityMap.put(Material.DEAD_BUBBLE_CORAL_FAN, 0);
    	opacityMap.put(Material.DEAD_BUBBLE_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.DEAD_BUSH, 0);
    	opacityMap.put(Material.DEAD_FIRE_CORAL, 0);
    	opacityMap.put(Material.DEAD_FIRE_CORAL_BLOCK, 255);
    	opacityMap.put(Material.DEAD_FIRE_CORAL_FAN, 0);
    	opacityMap.put(Material.DEAD_FIRE_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.DEAD_HORN_CORAL, 0);
    	opacityMap.put(Material.DEAD_HORN_CORAL_BLOCK, 255);
    	opacityMap.put(Material.DEAD_HORN_CORAL_FAN, 0);
    	opacityMap.put(Material.DEAD_HORN_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.DEAD_TUBE_CORAL, 0);
    	opacityMap.put(Material.DEAD_TUBE_CORAL_BLOCK, 255);
    	opacityMap.put(Material.DEAD_TUBE_CORAL_FAN, 0);
    	opacityMap.put(Material.DEAD_TUBE_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.DETECTOR_RAIL, 0);
    	opacityMap.put(Material.DIAMOND_BLOCK, 255);
    	opacityMap.put(Material.DIAMOND_ORE, 255);
    	opacityMap.put(Material.DIORITE, 255);
    	opacityMap.put(Material.DIORITE_SLAB, 255);
    	opacityMap.put(Material.DIORITE_STAIRS, 255);
    	opacityMap.put(Material.DIORITE_WALL, 0);
    	opacityMap.put(Material.DIRT, 255);
    	opacityMap.put(Material.DISPENSER, 255);
    	opacityMap.put(Material.DRAGON_EGG, 0);
    	opacityMap.put(Material.DRAGON_HEAD, 0);
    	opacityMap.put(Material.DRAGON_WALL_HEAD, 0);
    	opacityMap.put(Material.DRIED_KELP_BLOCK, 255);
    	opacityMap.put(Material.DROPPER, 255);
    	opacityMap.put(Material.EMERALD_BLOCK, 255);
    	opacityMap.put(Material.EMERALD_ORE, 255);
    	opacityMap.put(Material.ENCHANTING_TABLE, 0);
    	opacityMap.put(Material.END_GATEWAY, 0);
    	opacityMap.put(Material.END_PORTAL, 0);
    	opacityMap.put(Material.END_PORTAL_FRAME, 0);
    	opacityMap.put(Material.END_ROD, 0);
    	opacityMap.put(Material.END_STONE, 255);
    	opacityMap.put(Material.END_STONE_BRICK_SLAB, 255);
    	opacityMap.put(Material.END_STONE_BRICK_STAIRS, 255);
    	opacityMap.put(Material.END_STONE_BRICK_WALL, 0);
    	opacityMap.put(Material.END_STONE_BRICKS, 255);
    	opacityMap.put(Material.ENDER_CHEST, 0);
    	opacityMap.put(Material.FARMLAND, 255);
    	opacityMap.put(Material.FERN, 0);
    	opacityMap.put(Material.FIRE, 0);
    	opacityMap.put(Material.FIRE_CORAL, 0);
    	opacityMap.put(Material.FIRE_CORAL_BLOCK, 255);
    	opacityMap.put(Material.FIRE_CORAL_FAN, 0);
    	opacityMap.put(Material.FIRE_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.FLETCHING_TABLE, 255);
    	opacityMap.put(Material.FLOWER_POT, 0);
    	opacityMap.put(Material.FROSTED_ICE, 3);
    	opacityMap.put(Material.FURNACE, 255);
    	opacityMap.put(Material.GLASS, 0);
    	opacityMap.put(Material.GLASS_PANE, 0);
    	opacityMap.put(Material.GLOWSTONE, 255);
    	opacityMap.put(Material.GOLD_BLOCK, 255);
    	opacityMap.put(Material.GOLD_ORE, 255);
    	opacityMap.put(Material.GRANITE, 255);
    	opacityMap.put(Material.GRANITE_SLAB, 255);
    	opacityMap.put(Material.GRANITE_STAIRS, 255);
    	opacityMap.put(Material.GRANITE_WALL, 0);
    	opacityMap.put(Material.GRASS, 0);
    	opacityMap.put(Material.GRASS_BLOCK, 255);
    	opacityMap.put(Material.GRASS_PATH, 255);
    	opacityMap.put(Material.GRAVEL, 255);
    	opacityMap.put(Material.GRAY_BANNER, 0);
    	opacityMap.put(Material.GRAY_BED, 0);
    	opacityMap.put(Material.GRAY_CARPET, 0);
    	opacityMap.put(Material.GRAY_CONCRETE, 255);
    	opacityMap.put(Material.GRAY_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.GRAY_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.GRAY_SHULKER_BOX, 1);
    	opacityMap.put(Material.GRAY_STAINED_GLASS, 0);
    	opacityMap.put(Material.GRAY_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.GRAY_TERRACOTTA, 255);
    	opacityMap.put(Material.GRAY_WALL_BANNER, 0);
    	opacityMap.put(Material.GRAY_WOOL, 255);
    	opacityMap.put(Material.GREEN_BANNER, 0);
    	opacityMap.put(Material.GREEN_BED, 0);
    	opacityMap.put(Material.GREEN_CARPET, 0);
    	opacityMap.put(Material.GREEN_CONCRETE, 255);
    	opacityMap.put(Material.GREEN_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.GREEN_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.GREEN_SHULKER_BOX, 1);
    	opacityMap.put(Material.GREEN_STAINED_GLASS, 0);
    	opacityMap.put(Material.GREEN_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.GREEN_TERRACOTTA, 255);
    	opacityMap.put(Material.GREEN_WALL_BANNER, 0);
    	opacityMap.put(Material.GREEN_WOOL, 255);
    	opacityMap.put(Material.GRINDSTONE, 0);
    	opacityMap.put(Material.HAY_BLOCK, 255);
    	opacityMap.put(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.HOPPER, 0);
    	opacityMap.put(Material.HORN_CORAL, 0);
    	opacityMap.put(Material.HORN_CORAL_BLOCK, 255);
    	opacityMap.put(Material.HORN_CORAL_FAN, 0);
    	opacityMap.put(Material.HORN_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.ICE, 3);
    	opacityMap.put(Material.INFESTED_CHISELED_STONE_BRICKS, 255);
    	opacityMap.put(Material.INFESTED_COBBLESTONE, 255);
    	opacityMap.put(Material.INFESTED_CRACKED_STONE_BRICKS, 255);
    	opacityMap.put(Material.INFESTED_MOSSY_STONE_BRICKS, 255);
    	opacityMap.put(Material.INFESTED_STONE, 255);
    	opacityMap.put(Material.INFESTED_STONE_BRICKS, 255);
    	opacityMap.put(Material.IRON_BARS, 0);
    	opacityMap.put(Material.IRON_BLOCK, 255);
    	opacityMap.put(Material.IRON_DOOR, 0);
    	opacityMap.put(Material.IRON_ORE, 255);
    	opacityMap.put(Material.IRON_TRAPDOOR, 0);
    	opacityMap.put(Material.JACK_O_LANTERN, 255);
    	opacityMap.put(Material.JIGSAW, 255);
    	opacityMap.put(Material.JUKEBOX, 255);
    	opacityMap.put(Material.JUNGLE_BUTTON, 0);
    	opacityMap.put(Material.JUNGLE_DOOR, 0);
    	opacityMap.put(Material.JUNGLE_FENCE, 0);
    	opacityMap.put(Material.JUNGLE_FENCE_GATE, 0);
    	opacityMap.put(Material.JUNGLE_LEAVES, 1);
    	opacityMap.put(Material.JUNGLE_LOG, 255);
    	opacityMap.put(Material.JUNGLE_PLANKS, 255);
    	opacityMap.put(Material.JUNGLE_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.JUNGLE_SAPLING, 0);
    	opacityMap.put(Material.JUNGLE_SIGN, 0);
    	opacityMap.put(Material.JUNGLE_SLAB, 255);
    	opacityMap.put(Material.JUNGLE_STAIRS, 255);
    	opacityMap.put(Material.JUNGLE_TRAPDOOR, 0);
    	opacityMap.put(Material.JUNGLE_WALL_SIGN, 0);
    	opacityMap.put(Material.JUNGLE_WOOD, 255);
    	opacityMap.put(Material.KELP, 0);
    	opacityMap.put(Material.KELP_PLANT, 0);
    	opacityMap.put(Material.LADDER, 0);
    	opacityMap.put(Material.LANTERN, 0);
    	opacityMap.put(Material.LAPIS_BLOCK, 255);
    	opacityMap.put(Material.LAPIS_ORE, 255);
    	opacityMap.put(Material.LARGE_FERN, 0);
    	opacityMap.put(Material.LAVA, 1); // Changed from 0 to 1
    	opacityMap.put(Material.LECTERN, 255);
    	opacityMap.put(Material.LEVER, 0);
    	opacityMap.put(Material.LIGHT_BLUE_BANNER, 0);
    	opacityMap.put(Material.LIGHT_BLUE_BED, 0);
    	opacityMap.put(Material.LIGHT_BLUE_CARPET, 0);
    	opacityMap.put(Material.LIGHT_BLUE_CONCRETE, 255);
    	opacityMap.put(Material.LIGHT_BLUE_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.LIGHT_BLUE_SHULKER_BOX, 1);
    	opacityMap.put(Material.LIGHT_BLUE_STAINED_GLASS, 0);
    	opacityMap.put(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.LIGHT_BLUE_TERRACOTTA, 255);
    	opacityMap.put(Material.LIGHT_BLUE_WALL_BANNER, 0);
    	opacityMap.put(Material.LIGHT_BLUE_WOOL, 255);
    	opacityMap.put(Material.LIGHT_GRAY_BANNER, 0);
    	opacityMap.put(Material.LIGHT_GRAY_BED, 0);
    	opacityMap.put(Material.LIGHT_GRAY_CARPET, 0);
    	opacityMap.put(Material.LIGHT_GRAY_CONCRETE, 255);
    	opacityMap.put(Material.LIGHT_GRAY_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.LIGHT_GRAY_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.LIGHT_GRAY_SHULKER_BOX, 1);
    	opacityMap.put(Material.LIGHT_GRAY_STAINED_GLASS, 0);
    	opacityMap.put(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.LIGHT_GRAY_TERRACOTTA, 255);
    	opacityMap.put(Material.LIGHT_GRAY_WALL_BANNER, 0);
    	opacityMap.put(Material.LIGHT_GRAY_WOOL, 255);
    	opacityMap.put(Material.LIGHT_WEIGHTED_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.LILAC, 0);
    	opacityMap.put(Material.LILY_OF_THE_VALLEY, 0);
    	opacityMap.put(Material.LILY_PAD, 0);
    	opacityMap.put(Material.LIME_BANNER, 0);
    	opacityMap.put(Material.LIME_BED, 0);
    	opacityMap.put(Material.LIME_CARPET, 0);
    	opacityMap.put(Material.LIME_CONCRETE, 255);
    	opacityMap.put(Material.LIME_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.LIME_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.LIME_SHULKER_BOX, 1);
    	opacityMap.put(Material.LIME_STAINED_GLASS, 0);
    	opacityMap.put(Material.LIME_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.LIME_TERRACOTTA, 255);
    	opacityMap.put(Material.LIME_WALL_BANNER, 0);
    	opacityMap.put(Material.LIME_WOOL, 255);
    	opacityMap.put(Material.LOOM, 255);
    	opacityMap.put(Material.MAGENTA_BANNER, 0);
    	opacityMap.put(Material.MAGENTA_BED, 0);
    	opacityMap.put(Material.MAGENTA_CARPET, 0);
    	opacityMap.put(Material.MAGENTA_CONCRETE, 255);
    	opacityMap.put(Material.MAGENTA_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.MAGENTA_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.MAGENTA_SHULKER_BOX, 1);
    	opacityMap.put(Material.MAGENTA_STAINED_GLASS, 0);
    	opacityMap.put(Material.MAGENTA_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.MAGENTA_TERRACOTTA, 255);
    	opacityMap.put(Material.MAGENTA_WALL_BANNER, 0);
    	opacityMap.put(Material.MAGENTA_WOOL, 255);
    	opacityMap.put(Material.MAGMA_BLOCK, 255);
    	opacityMap.put(Material.MELON, 255);
    	opacityMap.put(Material.MELON_STEM, 0);
    	opacityMap.put(Material.MOSSY_COBBLESTONE, 255);
    	opacityMap.put(Material.MOSSY_COBBLESTONE_SLAB, 255);
    	opacityMap.put(Material.MOSSY_COBBLESTONE_STAIRS, 255);
    	opacityMap.put(Material.MOSSY_COBBLESTONE_WALL, 0);
    	opacityMap.put(Material.MOSSY_STONE_BRICK_SLAB, 255);
    	opacityMap.put(Material.MOSSY_STONE_BRICK_STAIRS, 255);
    	opacityMap.put(Material.MOSSY_STONE_BRICK_WALL, 0);
    	opacityMap.put(Material.MOSSY_STONE_BRICKS, 255);
    	opacityMap.put(Material.MOVING_PISTON, 0);
    	opacityMap.put(Material.MUSHROOM_STEM, 255);
    	opacityMap.put(Material.MYCELIUM, 255);
    	opacityMap.put(Material.NETHER_BRICK_FENCE, 0);
    	opacityMap.put(Material.NETHER_BRICK_SLAB, 255);
    	opacityMap.put(Material.NETHER_BRICK_STAIRS, 255);
    	opacityMap.put(Material.NETHER_BRICK_WALL, 0);
    	opacityMap.put(Material.NETHER_BRICKS, 255);
    	opacityMap.put(Material.NETHER_PORTAL, 0);
    	opacityMap.put(Material.NETHER_QUARTZ_ORE, 255);
    	opacityMap.put(Material.NETHER_WART, 0);
    	opacityMap.put(Material.NETHER_WART_BLOCK, 255);
    	opacityMap.put(Material.NETHERRACK, 255);
    	opacityMap.put(Material.NOTE_BLOCK, 255);
    	opacityMap.put(Material.OAK_BUTTON, 0);
    	opacityMap.put(Material.OAK_DOOR, 0);
    	opacityMap.put(Material.OAK_FENCE, 0);
    	opacityMap.put(Material.OAK_FENCE_GATE, 0);
    	opacityMap.put(Material.OAK_LEAVES, 1);
    	opacityMap.put(Material.OAK_LOG, 255);
    	opacityMap.put(Material.OAK_PLANKS, 255);
    	opacityMap.put(Material.OAK_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.OAK_SAPLING, 0);
    	opacityMap.put(Material.OAK_SIGN, 0);
    	opacityMap.put(Material.OAK_SLAB, 255);
    	opacityMap.put(Material.OAK_STAIRS, 255);
    	opacityMap.put(Material.OAK_TRAPDOOR, 0);
    	opacityMap.put(Material.OAK_WALL_SIGN, 0);
    	opacityMap.put(Material.OAK_WOOD, 255);
    	opacityMap.put(Material.OBSERVER, 255);
    	opacityMap.put(Material.OBSIDIAN, 255);
    	opacityMap.put(Material.ORANGE_BANNER, 0);
    	opacityMap.put(Material.ORANGE_BED, 0);
    	opacityMap.put(Material.ORANGE_CARPET, 0);
    	opacityMap.put(Material.ORANGE_CONCRETE, 255);
    	opacityMap.put(Material.ORANGE_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.ORANGE_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.ORANGE_SHULKER_BOX, 1);
    	opacityMap.put(Material.ORANGE_STAINED_GLASS, 0);
    	opacityMap.put(Material.ORANGE_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.ORANGE_TERRACOTTA, 255);
    	opacityMap.put(Material.ORANGE_TULIP, 0);
    	opacityMap.put(Material.ORANGE_WALL_BANNER, 0);
    	opacityMap.put(Material.ORANGE_WOOL, 255);
    	opacityMap.put(Material.OXEYE_DAISY, 0);
    	opacityMap.put(Material.PACKED_ICE, 255);
    	opacityMap.put(Material.PEONY, 0);
    	opacityMap.put(Material.PETRIFIED_OAK_SLAB, 255);
    	opacityMap.put(Material.PINK_BANNER, 0);
    	opacityMap.put(Material.PINK_BED, 0);
    	opacityMap.put(Material.PINK_CARPET, 0);
    	opacityMap.put(Material.PINK_CONCRETE, 255);
    	opacityMap.put(Material.PINK_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.PINK_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.PINK_SHULKER_BOX, 1);
    	opacityMap.put(Material.PINK_STAINED_GLASS, 0);
    	opacityMap.put(Material.PINK_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.PINK_TERRACOTTA, 255);
    	opacityMap.put(Material.PINK_TULIP, 0);
    	opacityMap.put(Material.PINK_WALL_BANNER, 0);
    	opacityMap.put(Material.PINK_WOOL, 255);
    	opacityMap.put(Material.PISTON, 0);
    	opacityMap.put(Material.PISTON_HEAD, 0);
    	opacityMap.put(Material.PLAYER_HEAD, 0);
    	opacityMap.put(Material.PLAYER_WALL_HEAD, 0);
    	opacityMap.put(Material.PODZOL, 255);
    	opacityMap.put(Material.POLISHED_ANDESITE, 255);
    	opacityMap.put(Material.POLISHED_ANDESITE_SLAB, 255);
    	opacityMap.put(Material.POLISHED_ANDESITE_STAIRS, 255);
    	opacityMap.put(Material.POLISHED_DIORITE, 255);
    	opacityMap.put(Material.POLISHED_DIORITE_SLAB, 255);
    	opacityMap.put(Material.POLISHED_DIORITE_STAIRS, 255);
    	opacityMap.put(Material.POLISHED_GRANITE, 255);
    	opacityMap.put(Material.POLISHED_GRANITE_SLAB, 255);
    	opacityMap.put(Material.POLISHED_GRANITE_STAIRS, 255);
    	opacityMap.put(Material.POPPY, 0);
    	opacityMap.put(Material.POTATOES, 0);
    	opacityMap.put(Material.POTTED_ACACIA_SAPLING, 0);
    	opacityMap.put(Material.POTTED_ALLIUM, 0);
    	opacityMap.put(Material.POTTED_AZURE_BLUET, 0);
    	opacityMap.put(Material.POTTED_BAMBOO, 0);
    	opacityMap.put(Material.POTTED_BIRCH_SAPLING, 0);
    	opacityMap.put(Material.POTTED_BLUE_ORCHID, 0);
    	opacityMap.put(Material.POTTED_BROWN_MUSHROOM, 0);
    	opacityMap.put(Material.POTTED_CACTUS, 0);
    	opacityMap.put(Material.POTTED_CORNFLOWER, 0);
    	opacityMap.put(Material.POTTED_DANDELION, 0);
    	opacityMap.put(Material.POTTED_DARK_OAK_SAPLING, 0);
    	opacityMap.put(Material.POTTED_DEAD_BUSH, 0);
    	opacityMap.put(Material.POTTED_FERN, 0);
    	opacityMap.put(Material.POTTED_JUNGLE_SAPLING, 0);
    	opacityMap.put(Material.POTTED_LILY_OF_THE_VALLEY, 0);
    	opacityMap.put(Material.POTTED_OAK_SAPLING, 0);
    	opacityMap.put(Material.POTTED_ORANGE_TULIP, 0);
    	opacityMap.put(Material.POTTED_OXEYE_DAISY, 0);
    	opacityMap.put(Material.POTTED_PINK_TULIP, 0);
    	opacityMap.put(Material.POTTED_POPPY, 0);
    	opacityMap.put(Material.POTTED_RED_MUSHROOM, 0);
    	opacityMap.put(Material.POTTED_RED_TULIP, 0);
    	opacityMap.put(Material.POTTED_SPRUCE_SAPLING, 0);
    	opacityMap.put(Material.POTTED_WHITE_TULIP, 0);
    	opacityMap.put(Material.POTTED_WITHER_ROSE, 0);
    	opacityMap.put(Material.POWERED_RAIL, 0);
    	opacityMap.put(Material.PRISMARINE, 255);
    	opacityMap.put(Material.PRISMARINE_BRICK_SLAB, 255);
    	opacityMap.put(Material.PRISMARINE_BRICK_STAIRS, 255);
    	opacityMap.put(Material.PRISMARINE_BRICKS, 255);
    	opacityMap.put(Material.PRISMARINE_SLAB, 255);
    	opacityMap.put(Material.PRISMARINE_STAIRS, 255);
    	opacityMap.put(Material.PRISMARINE_WALL, 0);
    	opacityMap.put(Material.PUMPKIN, 255);
    	opacityMap.put(Material.PUMPKIN_STEM, 0);
    	opacityMap.put(Material.PURPLE_BANNER, 0);
    	opacityMap.put(Material.PURPLE_BED, 0);
    	opacityMap.put(Material.PURPLE_CARPET, 0);
    	opacityMap.put(Material.PURPLE_CONCRETE, 255);
    	opacityMap.put(Material.PURPLE_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.PURPLE_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.PURPLE_SHULKER_BOX, 1);
    	opacityMap.put(Material.PURPLE_STAINED_GLASS, 0);
    	opacityMap.put(Material.PURPLE_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.PURPLE_TERRACOTTA, 255);
    	opacityMap.put(Material.PURPLE_WALL_BANNER, 0);
    	opacityMap.put(Material.PURPLE_WOOL, 255);
    	opacityMap.put(Material.PURPUR_BLOCK, 255);
    	opacityMap.put(Material.PURPUR_PILLAR, 255);
    	opacityMap.put(Material.PURPUR_SLAB, 255);
    	opacityMap.put(Material.PURPUR_STAIRS, 255);
    	opacityMap.put(Material.QUARTZ_BLOCK, 255);
    	opacityMap.put(Material.QUARTZ_PILLAR, 255);
    	opacityMap.put(Material.QUARTZ_SLAB, 255);
    	opacityMap.put(Material.QUARTZ_STAIRS, 255);
    	opacityMap.put(Material.RAIL, 0);
    	opacityMap.put(Material.RED_BANNER, 0);
    	opacityMap.put(Material.RED_BED, 0);
    	opacityMap.put(Material.RED_CARPET, 0);
    	opacityMap.put(Material.RED_CONCRETE, 255);
    	opacityMap.put(Material.RED_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.RED_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.RED_MUSHROOM, 0);
    	opacityMap.put(Material.RED_MUSHROOM_BLOCK, 255);
    	opacityMap.put(Material.RED_NETHER_BRICK_SLAB, 255);
    	opacityMap.put(Material.RED_NETHER_BRICK_STAIRS, 255);
    	opacityMap.put(Material.RED_NETHER_BRICK_WALL, 0);
    	opacityMap.put(Material.RED_NETHER_BRICKS, 255);
    	opacityMap.put(Material.RED_SAND, 255);
    	opacityMap.put(Material.RED_SANDSTONE, 255);
    	opacityMap.put(Material.RED_SANDSTONE_SLAB, 255);
    	opacityMap.put(Material.RED_SANDSTONE_STAIRS, 255);
    	opacityMap.put(Material.RED_SANDSTONE_WALL, 0);
    	opacityMap.put(Material.RED_SHULKER_BOX, 1);
    	opacityMap.put(Material.RED_STAINED_GLASS, 0);
    	opacityMap.put(Material.RED_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.RED_TERRACOTTA, 255);
    	opacityMap.put(Material.RED_TULIP, 0);
    	opacityMap.put(Material.RED_WALL_BANNER, 0);
    	opacityMap.put(Material.RED_WOOL, 255);
    	opacityMap.put(Material.REDSTONE_BLOCK, 255);
    	opacityMap.put(Material.REDSTONE_LAMP, 255);
    	opacityMap.put(Material.REDSTONE_ORE, 255);
    	opacityMap.put(Material.REDSTONE_TORCH, 0);
    	opacityMap.put(Material.REDSTONE_WALL_TORCH, 0);
    	opacityMap.put(Material.REDSTONE_WIRE, 0);
    	opacityMap.put(Material.REPEATER, 0);
    	opacityMap.put(Material.REPEATING_COMMAND_BLOCK, 255);
    	opacityMap.put(Material.ROSE_BUSH, 0);
    	opacityMap.put(Material.SAND, 255);
    	opacityMap.put(Material.SANDSTONE, 255);
    	opacityMap.put(Material.SANDSTONE_SLAB, 255);
    	opacityMap.put(Material.SANDSTONE_STAIRS, 255);
    	opacityMap.put(Material.SANDSTONE_WALL, 0);
    	opacityMap.put(Material.SCAFFOLDING, 0);
    	opacityMap.put(Material.SEA_LANTERN, 255);
    	opacityMap.put(Material.SEA_PICKLE, 0);
    	opacityMap.put(Material.SEAGRASS, 0);
    	opacityMap.put(Material.SHULKER_BOX, 1);
    	opacityMap.put(Material.SKELETON_SKULL, 0);
    	opacityMap.put(Material.SKELETON_WALL_SKULL, 0);
    	opacityMap.put(Material.SLIME_BLOCK, 1); // Changed from 0 to 1
    	opacityMap.put(Material.SMITHING_TABLE, 255);
    	opacityMap.put(Material.SMOKER, 255);
    	opacityMap.put(Material.SMOOTH_QUARTZ, 255);
    	opacityMap.put(Material.SMOOTH_QUARTZ_SLAB, 255);
    	opacityMap.put(Material.SMOOTH_QUARTZ_STAIRS, 255);
    	opacityMap.put(Material.SMOOTH_RED_SANDSTONE, 255);
    	opacityMap.put(Material.SMOOTH_RED_SANDSTONE_SLAB, 255);
    	opacityMap.put(Material.SMOOTH_RED_SANDSTONE_STAIRS, 255);
    	opacityMap.put(Material.SMOOTH_SANDSTONE, 255);
    	opacityMap.put(Material.SMOOTH_SANDSTONE_SLAB, 255);
    	opacityMap.put(Material.SMOOTH_SANDSTONE_STAIRS, 255);
    	opacityMap.put(Material.SMOOTH_STONE, 255);
    	opacityMap.put(Material.SMOOTH_STONE_SLAB, 255);
    	opacityMap.put(Material.SNOW, 0);
    	opacityMap.put(Material.SNOW_BLOCK, 255);
    	opacityMap.put(Material.SOUL_SAND, 255);
    	opacityMap.put(Material.SPAWNER, 0);
    	opacityMap.put(Material.SPONGE, 255);
    	opacityMap.put(Material.SPRUCE_BUTTON, 0);
    	opacityMap.put(Material.SPRUCE_DOOR, 0);
    	opacityMap.put(Material.SPRUCE_FENCE, 0);
    	opacityMap.put(Material.SPRUCE_FENCE_GATE, 0);
    	opacityMap.put(Material.SPRUCE_LEAVES, 1);
    	opacityMap.put(Material.SPRUCE_LOG, 255);
    	opacityMap.put(Material.SPRUCE_PLANKS, 255);
    	opacityMap.put(Material.SPRUCE_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.SPRUCE_SAPLING, 0);
    	opacityMap.put(Material.SPRUCE_SIGN, 0);
    	opacityMap.put(Material.SPRUCE_SLAB, 255);
    	opacityMap.put(Material.SPRUCE_STAIRS, 255);
    	opacityMap.put(Material.SPRUCE_TRAPDOOR, 0);
    	opacityMap.put(Material.SPRUCE_WALL_SIGN, 0);
    	opacityMap.put(Material.SPRUCE_WOOD, 255);
    	opacityMap.put(Material.STICKY_PISTON, 0);
    	opacityMap.put(Material.STONE, 255);
    	opacityMap.put(Material.STONE_BRICK_SLAB, 255);
    	opacityMap.put(Material.STONE_BRICK_STAIRS, 255);
    	opacityMap.put(Material.STONE_BRICK_WALL, 0);
    	opacityMap.put(Material.STONE_BRICKS, 255);
    	opacityMap.put(Material.STONE_BUTTON, 0);
    	opacityMap.put(Material.STONE_PRESSURE_PLATE, 0);
    	opacityMap.put(Material.STONE_SLAB, 255);
    	opacityMap.put(Material.STONE_STAIRS, 255);
    	opacityMap.put(Material.STONECUTTER, 1);
    	opacityMap.put(Material.STRIPPED_ACACIA_LOG, 255);
    	opacityMap.put(Material.STRIPPED_ACACIA_WOOD, 255);
    	opacityMap.put(Material.STRIPPED_BIRCH_LOG, 255);
    	opacityMap.put(Material.STRIPPED_BIRCH_WOOD, 255);
    	opacityMap.put(Material.STRIPPED_DARK_OAK_LOG, 255);
    	opacityMap.put(Material.STRIPPED_DARK_OAK_WOOD, 255);
    	opacityMap.put(Material.STRIPPED_JUNGLE_LOG, 255);
    	opacityMap.put(Material.STRIPPED_JUNGLE_WOOD, 255);
    	opacityMap.put(Material.STRIPPED_OAK_LOG, 255);
    	opacityMap.put(Material.STRIPPED_OAK_WOOD, 255);
    	opacityMap.put(Material.STRIPPED_SPRUCE_LOG, 255);
    	opacityMap.put(Material.STRIPPED_SPRUCE_WOOD, 255);
    	opacityMap.put(Material.STRUCTURE_BLOCK, 255);
    	opacityMap.put(Material.STRUCTURE_VOID, 0);
    	opacityMap.put(Material.SUGAR_CANE, 0);
    	opacityMap.put(Material.SUNFLOWER, 0);
    	opacityMap.put(Material.SWEET_BERRY_BUSH, 0);
    	opacityMap.put(Material.TALL_GRASS, 0);
    	opacityMap.put(Material.TALL_GRASS, 0);
    	opacityMap.put(Material.TERRACOTTA, 255);
    	opacityMap.put(Material.TNT, 255);
    	opacityMap.put(Material.TORCH, 0);
    	opacityMap.put(Material.TRAPPED_CHEST, 0);
    	opacityMap.put(Material.TRIPWIRE, 0);
    	opacityMap.put(Material.TRIPWIRE_HOOK, 0);
    	opacityMap.put(Material.TUBE_CORAL, 0);
    	opacityMap.put(Material.TUBE_CORAL_BLOCK, 255);
    	opacityMap.put(Material.TUBE_CORAL_FAN, 0);
    	opacityMap.put(Material.TUBE_CORAL_WALL_FAN, 0);
    	opacityMap.put(Material.TURTLE_EGG, 0);
    	opacityMap.put(Material.VINE, 0);
    	opacityMap.put(Material.VOID_AIR, 0);
    	opacityMap.put(Material.WALL_TORCH, 0);
    	opacityMap.put(Material.WATER, 1); // Changed from 3 to 1
    	opacityMap.put(Material.WET_SPONGE, 255);
    	opacityMap.put(Material.WHEAT, 0);
    	opacityMap.put(Material.WHITE_BANNER, 0);
    	opacityMap.put(Material.WHITE_BED, 0);
    	opacityMap.put(Material.WHITE_CARPET, 0);
    	opacityMap.put(Material.WHITE_CONCRETE, 255);
    	opacityMap.put(Material.WHITE_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.WHITE_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.WHITE_SHULKER_BOX, 1);
    	opacityMap.put(Material.WHITE_STAINED_GLASS, 0);
    	opacityMap.put(Material.WHITE_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.WHITE_TERRACOTTA, 255);
    	opacityMap.put(Material.WHITE_TULIP, 0);
    	opacityMap.put(Material.WHITE_WALL_BANNER, 0);
    	opacityMap.put(Material.WHITE_WOOL, 255);
    	opacityMap.put(Material.WITHER_ROSE, 0);
    	opacityMap.put(Material.WITHER_SKELETON_SKULL, 0);
    	opacityMap.put(Material.WITHER_SKELETON_WALL_SKULL, 0);
    	opacityMap.put(Material.YELLOW_BANNER, 0);
    	opacityMap.put(Material.YELLOW_BED, 0);
    	opacityMap.put(Material.YELLOW_CARPET, 0);
    	opacityMap.put(Material.YELLOW_CONCRETE, 255);
    	opacityMap.put(Material.YELLOW_CONCRETE_POWDER, 255);
    	opacityMap.put(Material.YELLOW_GLAZED_TERRACOTTA, 255);
    	opacityMap.put(Material.YELLOW_SHULKER_BOX, 1);
    	opacityMap.put(Material.YELLOW_STAINED_GLASS, 0);
    	opacityMap.put(Material.YELLOW_STAINED_GLASS_PANE, 0);
    	opacityMap.put(Material.YELLOW_TERRACOTTA, 255);
    	opacityMap.put(Material.YELLOW_WALL_BANNER, 0);
    	opacityMap.put(Material.YELLOW_WOOL, 255);
    	opacityMap.put(Material.ZOMBIE_HEAD, 0);
    	opacityMap.put(Material.ZOMBIE_WALL_HEAD, 0);
    	// Beta 1.7.3 block IDs to 1.14 block states
    	oldIdStateMap.put(0, "air");
    	oldIdStateMap.put(1, "stone");
    	oldIdStateMap.put(2, "grass_block");
    	oldIdStateMap.put(3, "dirt");
    	oldIdStateMap.put(4, "cobblestone");
    	oldIdStateMap.put(5, "oak_planks");
    	// Beta 1.7.3 uses only 2 bits for species
    	// Species 3 should be oak instead of jungle in b173
    	for(int flags=0; flags<15; flags+=4) {
    		int stage = flags>>3;
        	oldIdStateMap.put(idMeta(6,flags+0), "oak_sapling[stage="+stage+"]");
        	oldIdStateMap.put(idMeta(6,flags+1), "spruce_sapling[stage="+stage+"]");
        	oldIdStateMap.put(idMeta(6,flags+2), "birch_sapling[stage="+stage+"]");
        	oldIdStateMap.put(idMeta(6,flags+3), "jungle_sapling[stage="+stage+"]");
    		
    	}
    	oldIdStateMap.put(7, "bedrock");
    	// Based on 1.12.2 metadata, may not be 100% correct
    	for(int level=0;level<8;level++) {
    		oldIdStateMap.put(idMeta(8,level), "water[level="+level+"]");
    		oldIdStateMap.put(idMeta(9,level), "water[level="+level+"]");
    		oldIdStateMap.put(idMeta(10,level), "lava[level="+level+"]");
    		oldIdStateMap.put(idMeta(11,level), "lava[level="+level+"]");
    	}
    	oldIdStateMap.put(12, "sand");
    	oldIdStateMap.put(13, "gravel");
    	oldIdStateMap.put(14, "gold_ore");
    	oldIdStateMap.put(15, "iron_ore");
    	oldIdStateMap.put(16, "coal_ore");
    	oldIdStateMap.put(idMeta(17,0), "oak_log");
    	oldIdStateMap.put(idMeta(17,1), "spruce_log");
    	oldIdStateMap.put(idMeta(17,2), "birch_log");
    	for(int leafMeta=0;leafMeta<16;leafMeta+=4) {
    		boolean persistent = ((leafMeta>>2)&1) == 1;
    		//boolean checkDecay = ((leafMeta>>3)&1) == 1;
    		oldIdStateMap.put(idMeta(18,leafMeta+0), "oak_leaves[distance=1,persistent="+persistent+"]");
    		oldIdStateMap.put(idMeta(18,leafMeta+1), "spruce_leaves[distance=1,persistent="+persistent+"]");
    		oldIdStateMap.put(idMeta(18,leafMeta+2), "birch_leaves[distance=1,persistent="+persistent+"]");;
    		oldIdStateMap.put(idMeta(18,leafMeta+3), "jungle_leaves[distance=1,persistent="+persistent+"]");
    	}
    	oldIdStateMap.put(19, "sponge");
    	oldIdStateMap.put(20, "glass");
    	oldIdStateMap.put(21, "lapis_ore");
    	oldIdStateMap.put(22, "lapis_block");
    	// down/up dispensers unused
    	for(int i=0;i<16;i++) {
    		if((i&7) > 5) continue;
    		String facing = directional6[i&7];
    		boolean triggered = i>8;
        	oldIdStateMap.put(idMeta(23,i), "dispenser[facing="+facing+",triggered="+triggered+"]");
    	}
    	oldIdStateMap.put(24, "sandstone");
    	oldIdStateMap.put(25, "note_block");
    	for(int bedFlags=0;bedFlags<16;bedFlags+=4) {
    		String occupied=((bedFlags>>2)&1)==1?"true":"false";
    		String part=((bedFlags>>3)&1)==1?"head":"foot";
    		oldIdStateMap.put(idMeta(26,bedFlags+0), "red_bed[facing=south,occupied="+occupied+",part="+part+"]");
    		oldIdStateMap.put(idMeta(26,bedFlags+1), "red_bed[facing=west,occupied="+occupied+",part="+part+"]");
    		oldIdStateMap.put(idMeta(26,bedFlags+2), "red_bed[facing=north,occupied="+occupied+",part="+part+"]");
    		oldIdStateMap.put(idMeta(26,bedFlags+3), "red_bed[facing=east,occupied="+occupied+",part="+part+"]");
    	}
    	for(int i=0;i<16;i++) {
    		if((i&7) >= straightRailShapes.length) continue;
    		String shape=straightRailShapes[i&7];
    		boolean powered = i>8;
    		oldIdStateMap.put(idMeta(27,i), "powered_rail[powered="+powered+",shape="+shape+"]");
    		oldIdStateMap.put(idMeta(28,i), "detector_rail[powered="+powered+",shape="+shape+"]");
    	}
    	for(int i=0;i<16;i++) {
    		if((i&7) > 5) continue;
    		String facing = directional6[i&7];
    		boolean flag = i>8;
    		String headType = flag?"sticky":"normal";
    		oldIdStateMap.put(idMeta(29,i), "sticky_piston[facing="+facing+",extended="+flag+"]");
    		oldIdStateMap.put(idMeta(33,i), "piston[facing="+facing+",extended="+flag+"]");
    		oldIdStateMap.put(idMeta(34,i), "piston_head[facing="+facing+",type="+headType+"]");
    		oldIdStateMap.put(idMeta(36,i), "moving_piston[facing="+facing+",type="+headType+"]");
    	}
    	oldIdStateMap.put(30, "cobweb");
    	oldIdStateMap.put(idMeta(31,0), "dead_bush"); // this block will most likely 'pop off' when updated
    	oldIdStateMap.put(idMeta(31,1), "grass");
    	oldIdStateMap.put(idMeta(31,2), "fern");
    	oldIdStateMap.put(32, "dead_bush");
    	// 33/Piston set above
    	// 34/Piston Extension set above
    	for(int i=0;i<16;i++)
        	oldIdStateMap.put(idMeta(35,i), blockDyeColors[i]+"_wool");
    	// 36/Piston Moving set above
    	oldIdStateMap.put(37, "dandelion");
    	oldIdStateMap.put(38, "poppy");
    	oldIdStateMap.put(39, "brown_mushroom");
    	oldIdStateMap.put(40, "red_mushroom");
    	oldIdStateMap.put(41, "gold_block");
    	oldIdStateMap.put(42, "iron_block");
    	for(int slabType=0;slabType<slabTypes.length;slabType++) {
    		oldIdStateMap.put(idMeta(43,slabType), slabTypes[slabType]+"_slab[type=double]");
    		oldIdStateMap.put(idMeta(44,slabType), slabTypes[slabType]+"_slab[type=bottom]");
    	}
    	oldIdStateMap.put(45, "bricks");
    	oldIdStateMap.put(idMeta(46,0), "tnt");
    	oldIdStateMap.put(idMeta(46,1), "tnt[unstable=1]");
    	oldIdStateMap.put(47, "bookshelf");
    	oldIdStateMap.put(48, "mossy_cobblestone");
    	oldIdStateMap.put(49, "obsidian");
    	oldIdStateMap.put(idMeta(50,0), "torch"); // Illegal but read correctly by the game
    	oldIdStateMap.put(idMeta(75,0), "redstone_torch[lit=false]");
    	oldIdStateMap.put(idMeta(76,0), "redstone_torch[lit=true]");
    	oldIdStateMap.put(idMeta(50,5), "torch");
    	oldIdStateMap.put(idMeta(75,5), "redstone_torch[lit=false]");
    	oldIdStateMap.put(idMeta(76,5), "redstone_torch[lit=true]");
    	for(int i=1;i<5;i++) {
    		String facing=stairTorchDirections[i-1];
    		oldIdStateMap.put(idMeta(50,i), "wall_torch[facing="+facing+"]");
    		oldIdStateMap.put(idMeta(75,i), "redstone_wall_torch[facing="+facing+",lit=false]");
    		oldIdStateMap.put(idMeta(76,i), "redstone_wall_torch[facing="+facing+",lit=true]");
    	}
    	for(int i=0;i<16;i++)
    		oldIdStateMap.put(idMeta(51,i), "fire[age="+i+"]"); // default (faces)=false
    	oldIdStateMap.put(52, "spawner");
    	for(int i=0;i<3;i++) {
    		String facing = stairTorchDirections[i];
    		oldIdStateMap.put(idMeta(53,i), "oak_stairs[facing="+facing+"]"); // default half=bottom,shape=straight
    		oldIdStateMap.put(idMeta(67,i), "cobblestone_stairs[facing="+facing+"]");
    	}
    	for(int d=0;d<5;d++) { // Blocks using horizontal orientations of directional enum
    		if(d==1) continue; // Set states for 0, 2,3,4,5
    		int h = d;
    		if(h < 2) h = 2;
    		String facing = directional6[h];
    		oldIdStateMap.put(idMeta(54,d), "chest[facing="+facing+"]"); // Chest orientation not stored in 1.7.3
    		oldIdStateMap.put(idMeta(61,d), "furnace[facing="+facing+"]");
    		oldIdStateMap.put(idMeta(62,d), "furnace[facing="+facing+",lit=true]");
    		oldIdStateMap.put(idMeta(65,d), "ladder[facing="+facing+"]");
    		oldIdStateMap.put(idMeta(68,d), "oak_wall_sign[facing="+facing+"]");
    	}
    	for(int power=0;power<16;power++)
    		oldIdStateMap.put(idMeta(55,power), "redstone_wire[power="+power+"]");
    	oldIdStateMap.put(56, "diamond_ore");
    	oldIdStateMap.put(57, "diamond_block");
    	oldIdStateMap.put(58, "crafting_table");
    	for(int age=0;age<7;age++)
    		oldIdStateMap.put(idMeta(59,age), "wheat[age="+age+"]");
    	for(int moist=0;moist<7;moist++)
    		oldIdStateMap.put(idMeta(60,moist), "farmland[moisture="+moist+"]");
    	// 61/Furnace set above
    	// 62/Lit Furnace set above
    	for(int rotate=0;rotate<15;rotate++)
    		oldIdStateMap.put(idMeta(63,rotate), "oak_sign[rotation="+rotate+"]");
    	for(int door=0;door<15;door++) {
    		String half=door>8?"upper":"lower";
    		boolean open=(door&7)>4;
    		String facing=doorFacing[door&3];
    		oldIdStateMap.put(idMeta(64,door), "oak_door[facing="+facing+",half="+half+",hinge=left,open="+open+"]");
    		oldIdStateMap.put(idMeta(71,door), "iron_door[facing="+facing+",half="+half+",hinge=left,open="+open+"]");
    	}
    	// 65/Ladder set above
    	for(int i=0;i<normalRailShapes.length;i++) {
        	oldIdStateMap.put(idMeta(66,i), "rail[shape="+normalRailShapes[i]+"]");
    	}
    	// 67/Cobblestone Stairs set above
    	// 68/Wall Sign set above
    	for(int i=0;i<8;i++) {
    		String face = leverFaces[i];
    		String facing = leverDirections[i];
    		oldIdStateMap.put(idMeta(69,i+0), "lever[powered=false,face="+face+",facing="+facing+"]");
    		oldIdStateMap.put(idMeta(69,i+8), "lever[powered=true,face="+face+",facing="+facing+"]");
    	}
    	oldIdStateMap.put(idMeta(70,0), "stone_pressure_plate[powered=false]");
    	oldIdStateMap.put(idMeta(70,1), "stone_pressure_plate[powered=true]");
    	oldIdStateMap.put(idMeta(72,0), "oak_pressure_plate[powered=false]");
    	oldIdStateMap.put(idMeta(72,1), "oak_pressure_plate[powered=true]");
    	// 71/Iron Door set above
    	// 72/Wooden Pressure Plate set above
    	oldIdStateMap.put(73, "redstone_ore[lit=false]");
    	oldIdStateMap.put(74, "redstone_ore[lit=true]");
    	// 75/Unlit Redstone Torch set above
    	// 76/Lit Redstone Torch set above
    	for(int i=0;i<16;i+=8) { // TODO - simplify button state derivation
    		boolean powered=(i>8);
        	oldIdStateMap.put(idMeta(77,0+i), "stone_button[face=ceiling,facing=north,powered="+powered+"]");
        	oldIdStateMap.put(idMeta(77,1+i), "stone_button[face=wall,facing=east,powered="+powered+"]");
        	oldIdStateMap.put(idMeta(77,2+i), "stone_button[face=wall,facing=west,powered="+powered+"]");
        	oldIdStateMap.put(idMeta(77,3+i), "stone_button[face=wall,facing=south,powered="+powered+"]");
        	oldIdStateMap.put(idMeta(77,4+i), "stone_button[face=wall,facing=north,powered="+powered+"]");
        	oldIdStateMap.put(idMeta(77,5+i), "stone_button[face=floor,facing=south,powered="+powered+"]");
    	}
    	for(int level=0;level<8;level++) {
    		int layers=level+1;
    		oldIdStateMap.put(idMeta(78,level+0), "snow[layers="+layers+"]");
    		oldIdStateMap.put(idMeta(78,level+8), "snow[layers="+layers+"]");
    	}
    	oldIdStateMap.put(79, "ice");
    	oldIdStateMap.put(80, "snow_block");
    	for(int age=0;age<16;age++) {
        	oldIdStateMap.put(idMeta(81,age), "cactus[age="+age+"]");
    		oldIdStateMap.put(idMeta(83,age), "sugar_cane[age="+age+"]");
    	}
    	oldIdStateMap.put(82, "clay");
    	// 83/Sugar Cane set above
    	oldIdStateMap.put(idMeta(84,0), "jukebox[has_record=false]");
    	oldIdStateMap.put(idMeta(84,1), "jukebox[has_record=true]");
    	oldIdStateMap.put(85, "oak_fence");
    	for(int i=0;i<4;i++) {
    		String facing=pumpkinRepeaterDirections[i];
        	oldIdStateMap.put(idMeta(86,i), "carved_pumpkin[facing="+facing+"]");
        	oldIdStateMap.put(idMeta(91,i), "jack_o_lantern[facing="+facing+"]");
    	}
    	oldIdStateMap.put(idMeta(86,4), "pumpkin"); // Faceless pumpkin
    	oldIdStateMap.put(87, "netherrack");
    	oldIdStateMap.put(88, "soul_sand");
    	oldIdStateMap.put(89, "glowstone");
    	oldIdStateMap.put(idMeta(90,0), "nether_portal[axis=x]"); // TODO: Replace with fallback to meta 1
    	oldIdStateMap.put(idMeta(90,1), "nether_portal[axis=x]");
    	oldIdStateMap.put(idMeta(90,0), "nether_portal[axis=z]");
    	// 91/Jack o'Lantern set above
    	for(int bites=0;bites<7;bites++) {
    		oldIdStateMap.put(idMeta(92,bites), "cake[bites="+bites+"]");
    	}
    	for(int i=0;i<16;i++) {
    		String facing=pumpkinRepeaterDirections[i&3];
    		int delay=(i>>2)+1;
        	oldIdStateMap.put(idMeta(93,0), "repeater[delay="+delay+",facing="+facing+",powered=false]");
        	oldIdStateMap.put(idMeta(94,0), "repeater[delay="+delay+",facing="+facing+",powered=true]");
    	}
    	// 95/Locked Chest removed block, not mapped
    	for(int i=0;i<16;i++) { // Repeated meta unused but read correctly by the game
    		String facing=trapdoorDirections[i&3];
    		boolean open=(i&7)>4;
    		oldIdStateMap.put(idMeta(96,i), "oak_trapdoor[facing="+facing+",open="+open+"]");
    	}
    	
    	// Verify states
    	// Fails in non-bukkit environment, how can we run this check?
    	/*for(Integer idMeta : oldIdStateMap.keySet()) {
    		String state = oldIdStateMap.get(idMeta);
    		try {
    			Bukkit.getServer().createBlockData(state);
    		} catch(IllegalArgumentException e) {
    			throw new UnsupportedOperationException("Block ID " + idMetaString(idMeta) + "attempted to map to invalid state "+state);
    		}
    	}*/
    }
    public static int getOpacity(Material material) {
    	if(!opacityMap.containsKey(material))
    		//return 255;
    		throw new UnsupportedOperationException("Material "+material.name()+" has no assigned light opacity!");
        return opacityMap.get(material);
    }
    public static String getStateForOldId(int id, int meta) {
    	Integer key = Integer.valueOf(idMeta(id, meta));
		// Default to meta 0
    	if(!oldIdStateMap.containsKey(key)) key = Integer.valueOf(idMeta(id, 0));
    	if(!oldIdStateMap.containsKey(key)) {
            throw new UnsupportedOperationException("Block ID " + idMetaString(id, meta) + " has no assigned block state!");
    	}
    	return oldIdStateMap.get(key);
    }
    // Returns extended ID, in the form id + metadata*256
    // Assumes block IDs are no bigger than 255
    // For metadata 0, return value is the same as the ID
    public static int idMeta(int id, int meta) {
    	return (id&0xFF) | (meta<<8);
    }
    public static String idMetaString(int idMeta) {
    	int id = idMeta&0xFF;
    	int meta = idMeta>>8;
    	return idMetaString(id, meta);
    }
    public static String idMetaString(int id, int meta) {
    	return id+":"+meta;
    }
}
