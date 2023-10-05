package teenaapje.McExtended.Utils;

import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Orientable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Dictionary;
import java.util.Enumeration;

public class Util {

    public static BlockFace getBlockFace(Block block) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Directional) {
            Directional directional = (Directional) blockData;
            return directional.getFacing();
        }
        return null;
    }

    public static ItemStack reduceDurability(ItemStack item, int amountDamage) {
        org.bukkit.inventory.meta.Damageable dMeta = (org.bukkit.inventory.meta.Damageable) item.getItemMeta();

        int damage = dMeta.getDamage();
        int maxDamage = item.getType().getMaxDurability();

        if(damage + amountDamage <= maxDamage) {
            dMeta.setDamage(damage + amountDamage);
            item.setItemMeta(dMeta);
        }
        else{
            item.setAmount(0);
        }

        return item;
    }

    public static int randomInt (int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    public static double randomDouble (double min, double max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static boolean dictKeyContains(Dictionary<Material, ?> dictionary, Material material) {
        Enumeration<Material> values = dictionary.keys();
        while (values.hasMoreElements()) {
            if (values.nextElement() == material) {
                return true;
            }
        }
        return false;
    }

    public static void increaseCompostLevel (Block block, int value, boolean playSound) {
        BlockState blockState = block.getState();
        BlockData blockData = block.getBlockData();
        Levelled blockLevel = (Levelled)blockData;

        blockLevel.setLevel(Math.max(1, Math.min(blockLevel.getLevel() + value, blockLevel.getMaximumLevel())));

        blockState.setBlockData(blockData);
        blockState.update();

        if (playSound) {
            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_COMPOSTER_FILL_SUCCESS, 1.0f, 1.0f);
        }
    }

    public static BlockFace getPlayerBlockFace(Player player, Block block) {
        // Get the player's location
        Location playerLocation = player.getLocation();

        // Get the block's location
        Location blockLocation = block.getLocation();

        // Calculate the differences in coordinates
        int dx = blockLocation.getBlockX() - playerLocation.getBlockX();
        int dy = blockLocation.getBlockY() - playerLocation.getBlockY();
        int dz = blockLocation.getBlockZ() - playerLocation.getBlockZ();

        // Determine the face based on the coordinate differences
        if (dx > 0) {
            return BlockFace.EAST;
        } else if (dx < 0) {
            return BlockFace.WEST;
        } else if (dy > 0) {
            return BlockFace.UP;
        } else if (dy < 0) {
            return BlockFace.DOWN;
        } else if (dz > 0) {
            return BlockFace.SOUTH;
        } else if (dz < 0) {
            return BlockFace.NORTH;
        } else {
            return null; // Block and player are at the same location
        }
    }


    public static int findItemIndex(Inventory inventory, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack slotItem = inventory.getItem(i);
            if (slotItem != null && slotItem.equals(itemStack)) {
                return i;
            }
        }
        return -1;
    }

    public static int findFirstNullIndex(ItemStack[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static ItemStack[] setItemInItemStack (ItemStack[] list, ItemStack item, int index) {
        list[index] = item;
        return list;
    }

    public static boolean mineBlock (Block block, ItemStack item) {
        boolean blockBroken;

        if (item == null) {
            blockBroken = block.breakNaturally();
        } else {
            blockBroken = block.breakNaturally(item);
        }

        return blockBroken;
    }
    
    public static void replaceBlock(Block block, Material material) {
        // Check if the block data is directional
        if (block.getBlockData() instanceof Directional) {
            BlockFace currentFace = getBlockFace(block);

            block.setType(material);
            Directional directional = (Directional) block.getBlockData();

            // Set the facing direction
            if (currentFace != null) directional.setFacing(currentFace);
            block.setBlockData(directional);

            //ExtendedCore.Instance().getLogger().info("replaced - directional data set: " + material);

        } else if (block.getBlockData() instanceof Orientable) {
            Axis currentAxis = ((Orientable) block.getBlockData()).getAxis();

            block.setType(material);
            Orientable orientation = (Orientable) block.getBlockData();

            // Set the orientation
            orientation.setAxis(currentAxis);
            block.setBlockData(orientation);
            //ExtendedCore.Instance().getLogger().info("replaced - orientation data set: " + material);

        } else {
            block.setType(material);
            //ExtendedCore.Instance().getLogger().info("replaced - no data set: " + material);
        }
    }

}
