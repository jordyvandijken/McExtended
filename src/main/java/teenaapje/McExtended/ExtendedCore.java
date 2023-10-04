package teenaapje.McExtended;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import teenaapje.McExtended.ExtendedDoor.AutoOpenDoor;
import teenaapje.McExtended.ExtendedFarming.FarmingInteraction;
import teenaapje.McExtended.ExtendedDispenser.DispenserMiner;
import teenaapje.McExtended.ExtendedCompost.MoreCompost;
import teenaapje.McExtended.ExtendedAXE.UnstripLogs;

import java.util.ArrayList;
import java.util.List;

public final class ExtendedCore extends JavaPlugin {
    private static ExtendedCore _instance;

    @Override
    public void onEnable() {
        _instance = this;

        getServer().getPluginManager().registerEvents(new FarmingInteraction(), this);
        getServer().getPluginManager().registerEvents(new AutoOpenDoor(), this);
        getServer().getPluginManager().registerEvents(new MoreCompost(), this);
        getServer().getPluginManager().registerEvents(new UnstripLogs(), this);

        setupMiners();

        // Register Enchants
        CustomEnchants.register();
        getServer().getPluginManager().registerEvents(new CustomEnchantmentListener(CustomEnchants.farmersFeet), this);

        for (Enchantment enchantment : Enchantment.values()) {
            getServer().getLogger().info(enchantment.getName() + " - " + enchantment.isDiscoverable() + " - " + enchantment);
        }
    }

    public void setupMiners () {
        List<Material> logTypes = new ArrayList<>();
        // types of logs
        logTypes.add(Material.ACACIA_LOG);
        logTypes.add(Material.BIRCH_LOG);
        logTypes.add(Material.CHERRY_LOG);
        logTypes.add(Material.JUNGLE_LOG);
        logTypes.add(Material.MANGROVE_LOG);
        logTypes.add(Material.DARK_OAK_LOG);
        logTypes.add(Material.OAK_LOG);
        logTypes.add(Material.SPRUCE_LOG);

        logTypes.add(Material.STRIPPED_ACACIA_LOG);
        logTypes.add(Material.STRIPPED_BIRCH_LOG);
        logTypes.add(Material.STRIPPED_CHERRY_LOG);
        logTypes.add(Material.STRIPPED_JUNGLE_LOG);
        logTypes.add(Material.STRIPPED_MANGROVE_LOG);
        logTypes.add(Material.STRIPPED_DARK_OAK_LOG);
        logTypes.add(Material.STRIPPED_OAK_LOG);
        logTypes.add(Material.STRIPPED_SPRUCE_LOG);

        List<Material> axeTypes = new ArrayList<>();
        // Axes
        axeTypes.add(Material.WOODEN_AXE);
        axeTypes.add(Material.STONE_AXE);
        axeTypes.add(Material.IRON_AXE);
        axeTypes.add(Material.GOLDEN_AXE);
        axeTypes.add(Material.DIAMOND_AXE);
        axeTypes.add(Material.NETHERITE_AXE);




        List<Material> stoneTypes = new ArrayList<>();
        // types of stones
        stoneTypes.add(Material.COBBLESTONE);
        stoneTypes.add(Material.STONE);

        List<Material> pickaxeTypes = new ArrayList<>();
        // Pickaxes
        pickaxeTypes.add(Material.WOODEN_PICKAXE);
        pickaxeTypes.add(Material.STONE_PICKAXE);
        pickaxeTypes.add(Material.IRON_PICKAXE);
        pickaxeTypes.add(Material.GOLDEN_PICKAXE);
        pickaxeTypes.add(Material.DIAMOND_PICKAXE);
        pickaxeTypes.add(Material.NETHERITE_PICKAXE);




        List<Material> farmlandTypes = new ArrayList<>();
        // types of farming crops
        farmlandTypes.add(Material.CARROTS);
        farmlandTypes.add(Material.POTATOES);
        farmlandTypes.add(Material.BEETROOTS);
        farmlandTypes.add(Material.WHEAT);
        farmlandTypes.add(Material.NETHER_WART);

        List<Material> hoeTypes = new ArrayList<>();
        // Hoes
        hoeTypes.add(Material.WOODEN_HOE);
        hoeTypes.add(Material.STONE_HOE);
        hoeTypes.add(Material.IRON_HOE);
        hoeTypes.add(Material.GOLDEN_HOE);
        hoeTypes.add(Material.DIAMOND_HOE);
        hoeTypes.add(Material.NETHERITE_HOE);


        getServer().getPluginManager().registerEvents(new DispenserMiner(logTypes       , axeTypes)     , this);
        getServer().getPluginManager().registerEvents(new DispenserMiner(stoneTypes     , pickaxeTypes) , this);
        getServer().getPluginManager().registerEvents(new DispenserMiner(farmlandTypes  , hoeTypes)     , this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ExtendedCore Instance () {
        return _instance;
    }
}
