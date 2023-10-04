package teenaapje.McExtended.ExtendedFarming;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import teenaapje.McExtended.Utils.MaterialLists;

import java.util.ArrayList;
import java.util.List;

public class FarmingInteraction implements Listener {

    public FarmingInteraction() {  }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // TODO: drop a tiny amount of xp when farming crops
        if (event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        Block block = event.getClickedBlock();

        // Is using the right tool
        if (block == null) return;
        if (event.getItem() == null) return;
        if (!MaterialLists.Tools.hoes.contains(event.getItem().getType())) return;
        if (!MaterialLists.Farming.crops.contains(block.getType())) return;

        // convert to crop item
        Ageable crop = (Ageable) block.getBlockData();

        // Is crop right age
        if (crop.getAge() < crop.getMaximumAge()) {
            event.setCancelled(true);
            return;
        }

        for (ItemStack item : block.getDrops()) {
            if (MaterialLists.Farming.seeds.contains(item.getType()) && item.getAmount() > 1) {
                ItemStack reducedItem = new ItemStack(item.getType(), item.getAmount() - 1);
                block.getWorld().dropItemNaturally(block.getLocation(), reducedItem);
            } else {
                block.getWorld().dropItemNaturally(block.getLocation(), item);
            }
        }

        crop.setAge(0);
        block.setBlockData(crop);

        event.setCancelled(true);
    }
}