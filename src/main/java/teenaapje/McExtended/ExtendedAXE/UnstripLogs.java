package teenaapje.McExtended.ExtendedAXE;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import teenaapje.McExtended.Utils.MaterialLists;
import teenaapje.McExtended.Utils.Util;

import java.util.Dictionary;
import java.util.Hashtable;

public class UnstripLogs implements Listener {
    // No one like striping logs be accident
    Dictionary<Material, Material> strippedBlocks = new Hashtable<>();

    public UnstripLogs () {
        // The Stripped wood types
        addStippableItem(Material.matchMaterial("STRIPPED_ACACIA_LOG")      , Material.matchMaterial("ACACIA_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_ACACIA_WOOD")     , Material.matchMaterial("ACACIA_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_BAMBOO_BLOCK")    , Material.matchMaterial("BAMBOO_BLOCK"));
        addStippableItem(Material.matchMaterial("STRIPPED_BIRCH_LOG")       , Material.matchMaterial("BIRCH_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_BIRCH_WOOD")      , Material.matchMaterial("BIRCH_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_CHERRY_LOG")      , Material.matchMaterial("CHERRY_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_CHERRY_WOOD")     , Material.matchMaterial("CHERRY_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_CRIMSON_HYPHAE")  , Material.matchMaterial("CRIMSON_HYPHAE"));
        addStippableItem(Material.matchMaterial("STRIPPED_CRIMSON_STEM")    , Material.matchMaterial("CRIMSON_STEM"));
        addStippableItem(Material.matchMaterial("STRIPPED_DARK_OAK_LOG")    , Material.matchMaterial("DARK_OAK_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_DARK_OAK_WOOD")   , Material.matchMaterial("DARK_OAK_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_JUNGLE_LOG")      , Material.matchMaterial("JUNGLE_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_JUNGLE_WOOD")     , Material.matchMaterial("JUNGLE_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_MANGROVE_LOG")    , Material.matchMaterial("MANGROVE_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_MANGROVE_WOOD")   , Material.matchMaterial("MANGROVE_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_OAK_LOG")         , Material.matchMaterial("OAK_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_OAK_WOOD")        , Material.matchMaterial("OAK_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_SPRUCE_LOG")      , Material.matchMaterial("SPRUCE_LOG"));
        addStippableItem(Material.matchMaterial("STRIPPED_SPRUCE_WOOD")     , Material.matchMaterial("SPRUCE_WOOD"));
        addStippableItem(Material.matchMaterial("STRIPPED_WARPED_HYPHAE")   , Material.matchMaterial("WARPED_HYPHAE"));
        addStippableItem(Material.matchMaterial("STRIPPED_WARPED_STEM")     , Material.matchMaterial("WARPED_STEM"));
    }

    private void addStippableItem (Material stripableMat, Material originalMat) {
        if (stripableMat == null || originalMat == null) return;

        strippedBlocks.put(stripableMat, originalMat);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();
        if (!MaterialLists.Tools.axes.contains(player.getInventory().getItemInMainHand().getType())) return;

        Block block = event.getClickedBlock();

        assert block != null;
        Material type = block.getType();

        if (Util.dictKeyContains(strippedBlocks, type)) {
            Util.replaceBlock(block, strippedBlocks.get(type));

            block.getWorld().playSound(block.getLocation(), Sound.ITEM_AXE_STRIP, 1.0f, 1.0f);
        }
    }
}
