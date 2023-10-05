package teenaapje.McExtended;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockDebug implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();

        if (block == null) return;
        BlockData blockData = block.getBlockData();

        ExtendedCore.Instance().getLogger().info(blockData.getAsString() + " at " + block.getLocation());
    }


}
