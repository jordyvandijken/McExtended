package teenaapje.McExtended.ExtendedAXE;

import org.bukkit.Material;
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
        strippedBlocks.put(Material.STRIPPED_ACACIA_LOG, Material.ACACIA_LOG);
        strippedBlocks.put(Material.STRIPPED_ACACIA_WOOD, Material.ACACIA_WOOD);
        strippedBlocks.put(Material.STRIPPED_BAMBOO_BLOCK, Material.BAMBOO_BLOCK);
        strippedBlocks.put(Material.STRIPPED_BIRCH_LOG, Material.BIRCH_LOG);
        strippedBlocks.put(Material.STRIPPED_BIRCH_WOOD, Material.BIRCH_WOOD);
        strippedBlocks.put(Material.STRIPPED_CHERRY_LOG, Material.CHERRY_LOG);
        strippedBlocks.put(Material.STRIPPED_CHERRY_WOOD, Material.CHERRY_WOOD);
        strippedBlocks.put(Material.STRIPPED_CRIMSON_HYPHAE, Material.CRIMSON_HYPHAE);
        strippedBlocks.put(Material.STRIPPED_CRIMSON_STEM, Material.CRIMSON_STEM);
        strippedBlocks.put(Material.STRIPPED_DARK_OAK_LOG, Material.DARK_OAK_LOG);
        strippedBlocks.put(Material.STRIPPED_DARK_OAK_WOOD, Material.DARK_OAK_WOOD);
        strippedBlocks.put(Material.STRIPPED_JUNGLE_LOG, Material.JUNGLE_LOG);
        strippedBlocks.put(Material.STRIPPED_JUNGLE_WOOD, Material.JUNGLE_WOOD);
        strippedBlocks.put(Material.STRIPPED_MANGROVE_LOG, Material.MANGROVE_LOG);
        strippedBlocks.put(Material.STRIPPED_MANGROVE_WOOD, Material.MANGROVE_WOOD);
        strippedBlocks.put(Material.STRIPPED_OAK_LOG, Material.OAK_LOG);
        strippedBlocks.put(Material.STRIPPED_OAK_WOOD, Material.OAK_WOOD);
        strippedBlocks.put(Material.STRIPPED_SPRUCE_LOG, Material.SPRUCE_LOG);
        strippedBlocks.put(Material.STRIPPED_SPRUCE_WOOD, Material.SPRUCE_WOOD);
        strippedBlocks.put(Material.STRIPPED_WARPED_HYPHAE, Material.WARPED_HYPHAE);
        strippedBlocks.put(Material.STRIPPED_WARPED_STEM, Material.WARPED_STEM);

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();
        if (!MaterialLists.Tools.axes.contains(player.getInventory().getItemInMainHand().getType())) return;

        Block clickedBlock = event.getClickedBlock();

        assert clickedBlock != null;
        Material type = clickedBlock.getType();

        if (Util.dictKeyContains(strippedBlocks, type)) {
            Util.replaceBlock(clickedBlock, strippedBlocks.get(type));
        }
        // no sounds
        // maybe wrong block data
    }
}
