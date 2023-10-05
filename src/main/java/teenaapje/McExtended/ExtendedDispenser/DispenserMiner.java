package teenaapje.McExtended.ExtendedDispenser;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;
import teenaapje.McExtended.ExtendedCore;
import teenaapje.McExtended.Utils.Util;

import java.util.List;

public class DispenserMiner implements Listener {
    private final List<Material> blockTypes;
    private final List<Material> toolTypes;

    public DispenserMiner(List<Material> _blockTypes, List<Material> _toolTypes) {
        this.blockTypes = _blockTypes;
        this.toolTypes = _toolTypes;
    }

    @EventHandler
    public void onDispenserDispense(BlockDispenseEvent event) {
        Block block = event.getBlock();

        if (!(block.getState() instanceof Dispenser)) return;

        Dispenser dispenser = (Dispenser) block.getState();
        ItemStack tool = event.getItem();

        if (!toolTypes.contains(tool.getType())) return;

        // Store a copy of the dispenser's inventory
        event.setCancelled(true);

        if (!mineBlockInFacingDirection(dispenser, tool)) return;

        updateInventory(dispenser, tool);
    }

    public void updateInventory (Dispenser dispenser, ItemStack tool) {
        int index = Util.findFirstNullIndex(dispenser.getInventory().getContents());
        if (index < 0) return;

        ItemStack[] newList = Util.setItemInItemStack(dispenser.getSnapshotInventory().getContents(), Util.reduceDurability(tool.clone(), 1, true), index);

        dispenser.getSnapshotInventory().setContents(newList);

        Bukkit.getScheduler().runTaskLater(ExtendedCore.Instance(), () -> dispenser.update(), 1L);
    }


    public boolean mineBlockInFacingDirection(Dispenser dispenser, ItemStack tool) {
        // Get the facing direction of the dispenser
        BlockFace facing = Util.getBlockFace(dispenser.getBlock());

        // Calculate the block in front of the dispenser
        assert facing != null;
        Block frontBlock = dispenser.getBlock().getRelative(facing);

        if (!blockTypes.contains(frontBlock.getType())) {
            return false;
        }

        return Util.mineBlock(frontBlock, tool);
    }

}