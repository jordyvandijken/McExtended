package teenaapje.McExtended.Utils;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class MaterialLists {

    public static class Farming {
        public static final List<Material> crops = Arrays.asList(
            Material.CARROTS,
            Material.POTATOES,
            Material.BEETROOTS,
            Material.WHEAT,
            Material.NETHER_WART
        );

        public static final List<Material> seeds = Arrays.asList(
            Material.CARROTS,
            Material.POTATOES,
            Material.BEETROOT_SEEDS,
            Material.WHEAT_SEEDS,
            Material.NETHER_WART
        );
    }

    public static class Tools {
        public static final List<Material> axes = Arrays.asList(
            Material.WOODEN_AXE,
            Material.STONE_AXE,
            Material.IRON_AXE,
            Material.GOLDEN_AXE,
            Material.DIAMOND_AXE,
            Material.NETHERITE_AXE
        );

        public static final List<Material> pickaxes = Arrays.asList(
            Material.WOODEN_PICKAXE,
            Material.STONE_PICKAXE,
            Material.IRON_PICKAXE,
            Material.GOLDEN_PICKAXE,
            Material.DIAMOND_PICKAXE,
            Material.NETHERITE_PICKAXE
        );

        public static final List<Material> hoes = Arrays.asList(
            Material.WOODEN_HOE,
            Material.STONE_HOE,
            Material.IRON_HOE,
            Material.GOLDEN_HOE,
            Material.DIAMOND_HOE,
            Material.NETHERITE_HOE
        );

        public static final List<Material> swords = Arrays.asList(
            Material.WOODEN_SWORD,
            Material.STONE_SWORD,
            Material.IRON_SWORD,
            Material.GOLDEN_SWORD,
            Material.DIAMOND_SWORD,
            Material.NETHERITE_SWORD
        );

        public static final List<Material> shovels = Arrays.asList(
            Material.WOODEN_SHOVEL,
            Material.STONE_SHOVEL,
            Material.IRON_SHOVEL,
            Material.GOLDEN_SHOVEL,
            Material.DIAMOND_SHOVEL,
            Material.NETHERITE_SHOVEL
        );
    }

    public static class Blocks {
        public static final List<Material> logs = Arrays.asList(
            Material.ACACIA_LOG,
            Material.BIRCH_LOG,
            Material.CHERRY_LOG,
            Material.JUNGLE_LOG,
            Material.DARK_OAK_LOG,
            Material.OAK_LOG,
            Material.SPRUCE_LOG,
            Material.STRIPPED_ACACIA_LOG,
            Material.STRIPPED_BIRCH_LOG,
            Material.STRIPPED_CHERRY_LOG,
            Material.STRIPPED_JUNGLE_LOG,
            Material.STRIPPED_MANGROVE_LOG,
            Material.STRIPPED_DARK_OAK_LOG,
            Material.STRIPPED_OAK_LOG,
            Material.STRIPPED_SPRUCE_LOG
        );

        public static final List<Material> stone = Arrays.asList(
            Material.STONE,
            Material.INFESTED_STONE,
            Material.STONE_STAIRS,
            Material.STONE_SLAB,
            Material.STONE_PRESSURE_PLATE,
            Material.STONE_BUTTON,
            Material.COBBLESTONE,
            Material.INFESTED_COBBLESTONE,
            Material.COBBLESTONE_STAIRS,
            Material.COBBLESTONE_SLAB,
            Material.COBBLESTONE_WALL,
            Material.MOSSY_COBBLESTONE,
            Material.MOSSY_COBBLESTONE_STAIRS,
            Material.MOSSY_COBBLESTONE_SLAB,
            Material.MOSSY_COBBLESTONE_WALL,
            Material.STONE_BRICKS,
            Material.INFESTED_STONE_BRICKS,
            Material.STONE_BRICK_STAIRS,
            Material.STONE_BRICK_SLAB,
            Material.STONE_BRICK_WALL,
            Material.MOSSY_STONE_BRICKS,
            Material.INFESTED_MOSSY_STONE_BRICKS,
            Material.MOSSY_STONE_BRICK_STAIRS,
            Material.MOSSY_STONE_BRICK_SLAB,
            Material.MOSSY_STONE_BRICK_WALL,
            Material.CRACKED_STONE_BRICKS,
            Material.INFESTED_CRACKED_STONE_BRICKS,
            Material.CHISELED_STONE_BRICKS,
            Material.INFESTED_CHISELED_STONE_BRICKS,
            Material.SMOOTH_STONE,
            Material.SMOOTH_STONE_SLAB,
            Material.SANDSTONE,
            Material.SANDSTONE_STAIRS,
            Material.SANDSTONE_SLAB,
            Material.SANDSTONE_WALL,
            Material.SMOOTH_SANDSTONE,
            Material.SMOOTH_SANDSTONE_STAIRS,
            Material.SMOOTH_SANDSTONE_SLAB,
            Material.CUT_SANDSTONE,
            Material.CUT_SANDSTONE_SLAB,
            Material.CHISELED_SANDSTONE,
            Material.RED_SANDSTONE,
            Material.RED_SANDSTONE_STAIRS,
            Material.RED_SANDSTONE_SLAB,
            Material.RED_SANDSTONE_WALL,
            Material.SMOOTH_RED_SANDSTONE,
            Material.SMOOTH_RED_SANDSTONE_STAIRS,
            Material.SMOOTH_RED_SANDSTONE_SLAB,
            Material.CUT_RED_SANDSTONE,
            Material.CUT_RED_SANDSTONE_SLAB,
            Material.CHISELED_RED_SANDSTONE,
            Material.DRIPSTONE_BLOCK,
            Material.POINTED_DRIPSTONE,
            Material.STONECUTTER,
            Material.LODESTONE,
            Material.ANDESITE,
            Material.ANDESITE_STAIRS,
            Material.ANDESITE_SLAB,
            Material.ANDESITE_WALL,
            Material.POLISHED_ANDESITE,
            Material.POLISHED_ANDESITE_STAIRS,
            Material.POLISHED_ANDESITE_SLAB,
            Material.GRANITE,
            Material.GRANITE_STAIRS,
            Material.GRANITE_SLAB,
            Material.GRANITE_WALL,
            Material.POLISHED_GRANITE,
            Material.POLISHED_GRANITE_STAIRS,
            Material.POLISHED_GRANITE_SLAB,
            Material.DIORITE,
            Material.DIORITE_STAIRS,
            Material.DIORITE_SLAB,
            Material.DIORITE_WALL,
            Material.POLISHED_DIORITE,
            Material.POLISHED_DIORITE_STAIRS,
            Material.POLISHED_DIORITE_SLAB,
            Material.CALCITE,
            Material.TUFF,
            Material.DEEPSLATE,
            Material.COBBLED_DEEPSLATE,
            Material.COBBLED_DEEPSLATE_STAIRS,
            Material.COBBLED_DEEPSLATE_SLAB,
            Material.COBBLED_DEEPSLATE_WALL,
            Material.POLISHED_DEEPSLATE,
            Material.POLISHED_DEEPSLATE_STAIRS,
            Material.POLISHED_DEEPSLATE_SLAB,
            Material.POLISHED_DEEPSLATE_WALL,
            Material.DEEPSLATE_BRICKS,
            Material.DEEPSLATE_BRICK_STAIRS,
            Material.DEEPSLATE_BRICK_SLAB,
            Material.DEEPSLATE_BRICK_WALL,
            Material.DEEPSLATE_TILES,
            Material.DEEPSLATE_TILE_STAIRS,
            Material.DEEPSLATE_TILE_SLAB,
            Material.DEEPSLATE_TILE_WALL,
            Material.CRACKED_DEEPSLATE_BRICKS,
            Material.CRACKED_DEEPSLATE_TILES,
            Material.CHISELED_DEEPSLATE,
            Material.NETHERRACK,
            Material.GLOWSTONE,
            Material.BLACKSTONE,
            Material.BLACKSTONE_STAIRS,
            Material.BLACKSTONE_SLAB,
            Material.BLACKSTONE_WALL,
            Material.POLISHED_BLACKSTONE,
            Material.POLISHED_BLACKSTONE_STAIRS,
            Material.POLISHED_BLACKSTONE_SLAB,
            Material.POLISHED_BLACKSTONE_WALL,
            Material.POLISHED_BLACKSTONE_BUTTON,
            Material.POLISHED_BLACKSTONE_PRESSURE_PLATE,
            Material.POLISHED_BLACKSTONE_BRICKS,
            Material.POLISHED_BLACKSTONE_BRICK_STAIRS,
            Material.POLISHED_BLACKSTONE_BRICK_SLAB,
            Material.POLISHED_BLACKSTONE_BRICK_WALL,
            Material.CHISELED_POLISHED_BLACKSTONE,
            Material.CRACKED_POLISHED_BLACKSTONE_BRICKS,
            Material.BASALT,
            Material.SMOOTH_BASALT,
            Material.POLISHED_BASALT,
            Material.END_STONE,
            Material.END_STONE_BRICKS,
            Material.END_STONE_BRICK_STAIRS,
            Material.END_STONE_BRICK_SLAB,
            Material.END_STONE_BRICK_WALL
        );

        public static final List<Material> sand = Arrays.asList(
            Material.CLAY,
            Material.DIRT,
            Material.COARSE_DIRT,
            Material.ROOTED_DIRT,
            Material.DIRT_PATH,
            Material.GRASS_BLOCK,
            Material.GRAVEL,
            Material.SUSPICIOUS_GRAVEL,
            Material.MUD,
            Material.MYCELIUM,
            Material.CRIMSON_NYLIUM,
            Material.WARPED_NYLIUM,
            Material.PODZOL,
            Material.SAND,
            Material.RED_SAND,
            Material.SUSPICIOUS_SAND,
            Material.SOUL_SAND,
            Material.SOUL_SOIL
        );

    }
}
