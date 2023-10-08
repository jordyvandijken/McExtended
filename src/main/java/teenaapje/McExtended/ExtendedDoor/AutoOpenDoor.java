package teenaapje.McExtended.ExtendedDoor;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import teenaapje.McExtended.ExtendedCore;
import teenaapje.McExtended.Utils.Util;

public class AutoOpenDoor implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getAction().isRightClick()) return;
        if (event.getPlayer().isSneaking()) return; // open single door on sneak
        if (event.getClickedBlock() == null) return;
        if (!isDoor(event.getClickedBlock())) return;

        Block doubleDoorBlock = isDoubleDoor(event.getClickedBlock());
        if (doubleDoorBlock == null) return;

        Door doorData = (Door) event.getClickedBlock().getBlockData();
        Door ddDoorData = (Door) doubleDoorBlock.getBlockData();

        if (!doorData.isOpen() && !ddDoorData.isOpen()) {
            openDoor(doubleDoorBlock);
        } else if (doorData.isOpen() && ddDoorData.isOpen()) {
            closeDoor(doubleDoorBlock);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Block block = calculateTargetBlock(player);

        if (isDoor(block) && isFacingDoor(player, block)) {
            Door doorData = (Door) block.getBlockData();
            if (!doorData.isOpen()) {
                openDoor(block);

                Block doubleDoor = isDoubleDoor(block);
                if (doubleDoor != null) {
                    openDoor(doubleDoor);
                }

                scheduleDoorClose(block, doubleDoor);
            }
        }
    }

    public boolean isFacingDoor(Player player, Block block) {
        BlockFace face = Util.getPlayerBlockFace(player, block);
        BlockFace doorFacing = Util.getBlockFace(block);

        if (doorFacing == null) return false;

        boolean isDoorX = (doorFacing == BlockFace.EAST || doorFacing == BlockFace.WEST);
        boolean isDoorZ = (doorFacing == BlockFace.NORTH || doorFacing == BlockFace.SOUTH);

        boolean isX = (face == BlockFace.EAST || face == BlockFace.WEST);
        boolean isZ = (face == BlockFace.NORTH || face == BlockFace.SOUTH);

        return (isDoorX && isX) || (isDoorZ && isZ);
    }


    private Block calculateTargetBlock(Player player) {
        Vector direction = player.getLocation().getDirection();
        double height = player.isSneaking() ? 0.5 : 0.8;
        return player.getWorld().getBlockAt(player.getLocation().add(direction).add(0, height, 0));
    }

    private void openDoor(Block block) {
        Door doorData = (Door) block.getBlockData();
        doorData.setOpen(true);
        block.setBlockData(doorData);

        Material type = block.getType();
        if (Material.IRON_DOOR == type) {
            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_IRON_DOOR_OPEN, 1.0f, 1.0f);
//        } else if(Material.BAMBOO_DOOR == type) {
//            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_BAMBOO_WOOD_DOOR_OPEN, 1.0f, 1.0f);
//        } else if(Material.CHERRY_DOOR == type) {
//            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_CHERRY_WOOD_DOOR_OPEN, 1.0f, 1.0f);
//        } else if(Material.WARPED_DOOR == type) {
//            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_NETHER_WOOD_DOOR_OPEN, 1.0f, 1.0f);
//        } else if(Material.CRIMSON_DOOR == type) {
//            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_NETHER_WOOD_DOOR_OPEN, 1.0f, 1.0f);
        } else {
            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOODEN_DOOR_OPEN, 1.0f, 1.0f);
        }
    }

    private void closeDoor(Block block) {
        Door doorData = (Door) block.getBlockData();
        doorData.setOpen(false);
        block.setBlockData(doorData);

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

    private void scheduleDoorClose(Block block, Block doubleDoor) {
        DoorCloseTask task = new DoorCloseTask(block, doubleDoor);
        task.runTaskLater(ExtendedCore.Instance(), 20L);
    }

    public Block isDoubleDoor(Block doorBlock) {
        if (!isDoor(doorBlock)) {
            return null;
        }

        BlockData blockData = doorBlock.getBlockData();

        Door door = (Door) blockData;
        BlockFace doorFacing = door.getFacing();
        BlockFace adjacentFace = getAdjacentFace(doorFacing);
        Block otherBlock = getAdjacentBlock(door, doorBlock, adjacentFace);

        if (isDoubleDoor(otherBlock, door)) {
            return otherBlock;
        }

        return null;
    }

    private BlockFace getAdjacentFace(BlockFace doorFacing) {
        switch (doorFacing) {
            case NORTH:
                return BlockFace.WEST;
            case SOUTH:
                return BlockFace.EAST;
            case WEST:
                return BlockFace.SOUTH;
            case EAST:
                return BlockFace.NORTH;
            default:
                return null;
        }
    }

    private Block getAdjacentBlock(Door door, Block doorBlock, BlockFace adjacentFace) {
        return door.getHinge() == Door.Hinge.LEFT ? doorBlock.getRelative(adjacentFace.getOppositeFace()) : doorBlock.getRelative(adjacentFace);
    }

    private boolean isDoubleDoor(Block otherBlock, Door door) {
        return otherBlock != null && isDoor(otherBlock) && ((Door) otherBlock.getBlockData()).getFacing() == door.getFacing() && door.getHinge() != ((Door) otherBlock.getBlockData()).getHinge();
    }

    public boolean isDoor(Block block) {
        //return (block instanceof Door);

        Material type = block.getType();
        return  type == Material.ACACIA_DOOR ||
                type == Material.BAMBOO_DOOR ||
                type == Material.BIRCH_DOOR ||
                type == Material.CHERRY_DOOR ||
               type == Material.CRIMSON_DOOR ||
                type == Material.IRON_DOOR ||
                type == Material.JUNGLE_DOOR ||
                type == Material.MANGROVE_DOOR ||
                type == Material.OAK_DOOR ||
                type == Material.SPRUCE_DOOR;
    }
}

