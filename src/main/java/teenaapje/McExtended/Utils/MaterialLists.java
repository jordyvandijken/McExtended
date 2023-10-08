package teenaapje.McExtended.Utils;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class MaterialLists {

    public static class Farming {
        public static final List<Material> crops = Arrays.asList(
            Material.matchMaterial("CARROTS"),
            Material.matchMaterial("POTATOES"),
            Material.matchMaterial("BEETROOTS"),
            Material.matchMaterial("WHEAT"),
            Material.matchMaterial("NETHER_WART"),
            Material.matchMaterial("COCOA")
        );

        public static final List<Material> seeds = Arrays.asList(
            Material.matchMaterial("CARROT"),
            Material.matchMaterial("POTATO"),
            Material.matchMaterial("BEETROOT_SEEDS"),
            Material.matchMaterial("WHEAT_SEEDS"),
            Material.matchMaterial("NETHER_WART"),
            Material.matchMaterial("COCOA_BEANS")
        );
    }

    public static class Tools {
        public static final List<Material> axes = Arrays.asList(
            Material.matchMaterial("WOODEN_AXE"),
            Material.matchMaterial("STONE_AXE"),
            Material.matchMaterial("IRON_AXE"),
            Material.matchMaterial("GOLDEN_AXE"),
            Material.matchMaterial("DIAMOND_AXE"),
            Material.matchMaterial("NETHERITE_AXE")
        );

        public static final List<Material> pickaxes = Arrays.asList(
            Material.matchMaterial("WOODEN_PICKAXE"),
            Material.matchMaterial("STONE_PICKAXE"),
            Material.matchMaterial("IRON_PICKAXE"),
            Material.matchMaterial("GOLDEN_PICKAXE"),
            Material.matchMaterial("DIAMOND_PICKAXE"),
            Material.matchMaterial("NETHERITE_PICKAXE")
        );

        public static final List<Material> hoes = Arrays.asList(
            Material.matchMaterial("WOODEN_HOE"),
            Material.matchMaterial("STONE_HOE"),
            Material.matchMaterial("IRON_HOE"),
            Material.matchMaterial("GOLDEN_HOE"),
            Material.matchMaterial("DIAMOND_HOE"),
            Material.matchMaterial("NETHERITE_HOE")
        );

        public static final List<Material> swords = Arrays.asList(
            Material.matchMaterial("WOODEN_SWORD"),
            Material.matchMaterial("STONE_SWORD"),
            Material.matchMaterial("IRON_SWORD"),
            Material.matchMaterial("GOLDEN_SWORD"),
            Material.matchMaterial("DIAMOND_SWORD"),
            Material.matchMaterial("NETHERITE_SWORD")
        );

        public static final List<Material> shovels = Arrays.asList(
            Material.matchMaterial("WOODEN_SHOVEL"),
            Material.matchMaterial("STONE_SHOVEL"),
            Material.matchMaterial("IRON_SHOVEL"),
            Material.matchMaterial("GOLDEN_SHOVEL"),
            Material.matchMaterial("DIAMOND_SHOVEL"),
            Material.matchMaterial("NETHERITE_SHOVEL")
        );
    }

    public static class Blocks {
        public static final List<Material> logs = Arrays.asList(
            Material.matchMaterial("ACACIA_LOG"),
            Material.matchMaterial("BIRCH_LOG"),
            Material.matchMaterial("CHERRY_LOG"),
            Material.matchMaterial("JUNGLE_LOG"),
            Material.matchMaterial("DARK_OAK_LOG"),
            Material.matchMaterial("OAK_LOG"),
            Material.matchMaterial("SPRUCE_LOG"),
            Material.matchMaterial("CRIMSON_STEM"),
            Material.matchMaterial("WARPED_STEM"),
            Material.matchMaterial("STRIPPED_ACACIA_LOG"),
            Material.matchMaterial("STRIPPED_BIRCH_LOG"),
            Material.matchMaterial("STRIPPED_CHERRY_LOG"),
            Material.matchMaterial("STRIPPED_JUNGLE_LOG"),
            Material.matchMaterial("STRIPPED_MANGROVE_LOG"),
            Material.matchMaterial("STRIPPED_DARK_OAK_LOG"),
            Material.matchMaterial("STRIPPED_OAK_LOG"),
            Material.matchMaterial("STRIPPED_SPRUCE_LOG"),
            Material.matchMaterial("STRIPPED_CRIMSON_STEM"),
            Material.matchMaterial("STRIPPED_WARPED_STEM")
        );

        public static final List<Material> stone = Arrays.asList(
            Material.matchMaterial("STONE"),
            Material.matchMaterial("INFESTED_STONE"),
            Material.matchMaterial("STONE_STAIRS"),
            Material.matchMaterial("STONE_SLAB"),
            Material.matchMaterial("STONE_PRESSURE_PLATE"),
            Material.matchMaterial("STONE_BUTTON"),
            Material.matchMaterial("COBBLESTONE"),
            Material.matchMaterial("INFESTED_COBBLESTONE"),
            Material.matchMaterial("COBBLESTONE_STAIRS"),
            Material.matchMaterial("COBBLESTONE_SLAB"),
            Material.matchMaterial("COBBLESTONE_WALL"),
            Material.matchMaterial("MOSSY_COBBLESTONE"),
            Material.matchMaterial("MOSSY_COBBLESTONE_STAIRS"),
            Material.matchMaterial("MOSSY_COBBLESTONE_SLAB"),
            Material.matchMaterial("MOSSY_COBBLESTONE_WALL"),
            Material.matchMaterial("STONE_BRICKS"),
            Material.matchMaterial("INFESTED_STONE_BRICKS"),
            Material.matchMaterial("STONE_BRICK_STAIRS"),
            Material.matchMaterial("STONE_BRICK_SLAB"),
            Material.matchMaterial("STONE_BRICK_WALL"),
            Material.matchMaterial("MOSSY_STONE_BRICKS"),
            Material.matchMaterial("INFESTED_MOSSY_STONE_BRICKS"),
            Material.matchMaterial("MOSSY_STONE_BRICK_STAIRS"),
            Material.matchMaterial("MOSSY_STONE_BRICK_SLAB"),
            Material.matchMaterial("MOSSY_STONE_BRICK_WALL"),
            Material.matchMaterial("CRACKED_STONE_BRICKS"),
            Material.matchMaterial("INFESTED_CRACKED_STONE_BRICKS"),
            Material.matchMaterial("CHISELED_STONE_BRICKS"),
            Material.matchMaterial("INFESTED_CHISELED_STONE_BRICKS"),
            Material.matchMaterial("SMOOTH_STONE"),
            Material.matchMaterial("SMOOTH_STONE_SLAB"),
            Material.matchMaterial("SANDSTONE"),
            Material.matchMaterial("SANDSTONE_STAIRS"),
            Material.matchMaterial("SANDSTONE_SLAB"),
            Material.matchMaterial("SANDSTONE_WALL"),
            Material.matchMaterial("SMOOTH_SANDSTONE"),
            Material.matchMaterial("SMOOTH_SANDSTONE_STAIRS"),
            Material.matchMaterial("SMOOTH_SANDSTONE_SLAB"),
            Material.matchMaterial("CUT_SANDSTONE"),
            Material.matchMaterial("CUT_SANDSTONE_SLAB"),
            Material.matchMaterial("CHISELED_SANDSTONE"),
            Material.matchMaterial("RED_SANDSTONE"),
            Material.matchMaterial("RED_SANDSTONE_STAIRS"),
            Material.matchMaterial("RED_SANDSTONE_SLAB"),
            Material.matchMaterial("RED_SANDSTONE_WALL"),
            Material.matchMaterial("SMOOTH_RED_SANDSTONE"),
            Material.matchMaterial("SMOOTH_RED_SANDSTONE_STAIRS"),
            Material.matchMaterial("SMOOTH_RED_SANDSTONE_SLAB"),
            Material.matchMaterial("CUT_RED_SANDSTONE"),
            Material.matchMaterial("CUT_RED_SANDSTONE_SLAB"),
            Material.matchMaterial("CHISELED_RED_SANDSTONE"),
            Material.matchMaterial("DRIPSTONE_BLOCK"),
            Material.matchMaterial("POINTED_DRIPSTONE"),
            Material.matchMaterial("STONECUTTER"),
            Material.matchMaterial("LODESTONE"),
            Material.matchMaterial("ANDESITE"),
            Material.matchMaterial("ANDESITE_STAIRS"),
            Material.matchMaterial("ANDESITE_SLAB"),
            Material.matchMaterial("ANDESITE_WALL"),
            Material.matchMaterial("POLISHED_ANDESITE"),
            Material.matchMaterial("POLISHED_ANDESITE_STAIRS"),
            Material.matchMaterial("POLISHED_ANDESITE_SLAB"),
            Material.matchMaterial("GRANITE"),
            Material.matchMaterial("GRANITE_STAIRS"),
            Material.matchMaterial("GRANITE_SLAB"),
            Material.matchMaterial("GRANITE_WALL"),
            Material.matchMaterial("POLISHED_GRANITE"),
            Material.matchMaterial("POLISHED_GRANITE_STAIRS"),
            Material.matchMaterial("POLISHED_GRANITE_SLAB"),
            Material.matchMaterial("DIORITE"),
            Material.matchMaterial("DIORITE_STAIRS"),
            Material.matchMaterial("DIORITE_SLAB"),
            Material.matchMaterial("DIORITE_WALL"),
            Material.matchMaterial("POLISHED_DIORITE"),
            Material.matchMaterial("POLISHED_DIORITE_STAIRS"),
            Material.matchMaterial("POLISHED_DIORITE_SLAB"),
            Material.matchMaterial("CALCITE"),
            Material.matchMaterial("TUFF"),
            Material.matchMaterial("DEEPSLATE"),
            Material.matchMaterial("COBBLED_DEEPSLATE"),
            Material.matchMaterial("COBBLED_DEEPSLATE_STAIRS"),
            Material.matchMaterial("COBBLED_DEEPSLATE_SLAB"),
            Material.matchMaterial("COBBLED_DEEPSLATE_WALL"),
            Material.matchMaterial("POLISHED_DEEPSLATE"),
            Material.matchMaterial("POLISHED_DEEPSLATE_STAIRS"),
            Material.matchMaterial("POLISHED_DEEPSLATE_SLAB"),
            Material.matchMaterial("POLISHED_DEEPSLATE_WALL"),
            Material.matchMaterial("DEEPSLATE_BRICKS"),
            Material.matchMaterial("DEEPSLATE_BRICK_STAIRS"),
            Material.matchMaterial("DEEPSLATE_BRICK_SLAB"),
            Material.matchMaterial("DEEPSLATE_BRICK_WALL"),
            Material.matchMaterial("DEEPSLATE_TILES"),
            Material.matchMaterial("DEEPSLATE_TILE_STAIRS"),
            Material.matchMaterial("DEEPSLATE_TILE_SLAB"),
            Material.matchMaterial("DEEPSLATE_TILE_WALL"),
            Material.matchMaterial("CRACKED_DEEPSLATE_BRICKS"),
            Material.matchMaterial("CRACKED_DEEPSLATE_TILES"),
            Material.matchMaterial("CHISELED_DEEPSLATE"),
            Material.matchMaterial("NETHERRACK"),
            Material.matchMaterial("GLOWSTONE"),
            Material.matchMaterial("BLACKSTONE"),
            Material.matchMaterial("BLACKSTONE_STAIRS"),
            Material.matchMaterial("BLACKSTONE_SLAB"),
            Material.matchMaterial("BLACKSTONE_WALL"),
            Material.matchMaterial("POLISHED_BLACKSTONE"),
            Material.matchMaterial("POLISHED_BLACKSTONE_STAIRS"),
            Material.matchMaterial("POLISHED_BLACKSTONE_SLAB"),
            Material.matchMaterial("POLISHED_BLACKSTONE_WALL"),
            Material.matchMaterial("POLISHED_BLACKSTONE_BUTTON"),
            Material.matchMaterial("POLISHED_BLACKSTONE_PRESSURE_PLATE"),
            Material.matchMaterial("POLISHED_BLACKSTONE_BRICKS"),
            Material.matchMaterial("POLISHED_BLACKSTONE_BRICK_STAIRS"),
            Material.matchMaterial("POLISHED_BLACKSTONE_BRICK_SLAB"),
            Material.matchMaterial("POLISHED_BLACKSTONE_BRICK_WALL"),
            Material.matchMaterial("CHISELED_POLISHED_BLACKSTONE"),
            Material.matchMaterial("CRACKED_POLISHED_BLACKSTONE_BRICKS"),
            Material.matchMaterial("BASALT"),
            Material.matchMaterial("SMOOTH_BASALT"),
            Material.matchMaterial("POLISHED_BASALT"),
            Material.matchMaterial("END_STONE"),
            Material.matchMaterial("END_STONE_BRICKS"),
            Material.matchMaterial("END_STONE_BRICK_STAIRS"),
            Material.matchMaterial("END_STONE_BRICK_SLAB"),
            Material.matchMaterial("END_STONE_BRICK_WALL")
        );

        public static final List<Material> sand = Arrays.asList(
            Material.matchMaterial("CLAY"),
            Material.matchMaterial("DIRT"),
            Material.matchMaterial("COARSE_DIRT"),
            Material.matchMaterial("ROOTED_DIRT"),
            Material.matchMaterial("DIRT_PATH"),
            Material.matchMaterial("GRASS_BLOCK"),
            Material.matchMaterial("GRAVEL"),
            Material.matchMaterial("SUSPICIOUS_GRAVEL"),
            Material.matchMaterial("MUD"),
            Material.matchMaterial("MYCELIUM"),
            Material.matchMaterial("CRIMSON_NYLIUM"),
            Material.matchMaterial("WARPED_NYLIUM"),
            Material.matchMaterial("PODZOL"),
            Material.matchMaterial("SAND"),
            Material.matchMaterial("RED_SAND"),
            Material.matchMaterial("SUSPICIOUS_SAND"),
            Material.matchMaterial("SOUL_SAND"),
            Material.matchMaterial("SOUL_SOIL")
        );

    }
}
