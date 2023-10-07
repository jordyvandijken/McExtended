package teenaapje.McExtended;


import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import teenaapje.McExtended.ExtendedDoor.AutoOpenDoor;
import teenaapje.McExtended.ExtendedFarming.FarmingInteraction;
import teenaapje.McExtended.ExtendedDispenser.DispenserMiner;
import teenaapje.McExtended.ExtendedCompost.MoreCompost;
import teenaapje.McExtended.ExtendedAXE.UnstripLogs;
import teenaapje.McExtended.Utils.MaterialLists;

public final class ExtendedCore extends JavaPlugin {
    private static ExtendedCore _instance;

    @Override
    public void onEnable() {
        _instance = this;

        getServer().getPluginManager().registerEvents(new AutoOpenDoor(), this);
        getServer().getPluginManager().registerEvents(new ExtendedInventory(), this);

        getServer().getPluginManager().registerEvents(new FarmingInteraction(), this);
        getServer().getPluginManager().registerEvents(new MoreCompost(), this);
        getServer().getPluginManager().registerEvents(new UnstripLogs(), this);

        getServer().getPluginManager().registerEvents(new DispenserMiner(MaterialLists.Blocks.logs  , MaterialLists.Tools.axes)     , this);
        getServer().getPluginManager().registerEvents(new DispenserMiner(MaterialLists.Blocks.stone , MaterialLists.Tools.pickaxes) , this);
        getServer().getPluginManager().registerEvents(new DispenserMiner(MaterialLists.Blocks.sand  , MaterialLists.Tools.shovels)  , this);
        getServer().getPluginManager().registerEvents(new DispenserMiner(MaterialLists.Farming.crops, MaterialLists.Tools.hoes)     , this);


        getServer().getPluginManager().registerEvents(new BlockDebug(), this);

        // Register Enchants
        CustomEnchants.register();
        getServer().getPluginManager().registerEvents(new CustomEnchantmentListener(CustomEnchants.farmersFeet), this);

        for (Enchantment enchantment : Enchantment.values()) {
            getServer().getLogger().info(enchantment.getName() + " - " + enchantment.isDiscoverable() + " - " + enchantment);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ExtendedCore Instance () {
        return _instance;
    }
}
