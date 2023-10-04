package teenaapje.McExtended.ExtendedDoor;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.scheduler.BukkitRunnable;

public class DoorCloseTask extends BukkitRunnable {

    private final Block doorBlock1;
    private final Block doorBlock2;

    public DoorCloseTask(Block doorBlock1, Block doorBlock2) {
        this.doorBlock1 = doorBlock1;
        this.doorBlock2 = doorBlock2;
    }

    @Override
    public void run() {
        closeDoor(doorBlock1);

        if (doorBlock2 != null) closeDoor(doorBlock2);
    }

    private void closeDoor(Block block) {
        BlockData blockData = block.getBlockData();

        if (blockData instanceof Door) {
            Door door = (Door) blockData;
            door.setOpen(false);
            block.setBlockData(door);

            Material type = block.getType();
            if (Material.IRON_DOOR == type) {
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_IRON_DOOR_CLOSE, 1.0f, 1.0f);
            } else if(Material.BAMBOO_DOOR == type) {
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_BAMBOO_WOOD_DOOR_CLOSE, 1.0f, 1.0f);
            } else if(Material.CHERRY_DOOR == type) {
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_CHERRY_WOOD_DOOR_CLOSE, 1.0f, 1.0f);
            } else if(Material.WARPED_DOOR == type) {
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_NETHER_WOOD_DOOR_CLOSE, 1.0f, 1.0f);
            } else if(Material.CRIMSON_DOOR == type) {
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_NETHER_WOOD_DOOR_CLOSE, 1.0f, 1.0f);
            } else {
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOODEN_DOOR_CLOSE, 1.0f, 1.0f);
            }
        }
    }
}
