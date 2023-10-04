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
}
