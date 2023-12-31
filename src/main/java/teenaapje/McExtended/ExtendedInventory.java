package teenaapje.McExtended;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


import java.util.Arrays;
import java.util.Comparator;
public class ExtendedInventory implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        // Check if the clicked inventory is and the middle mouse button was used.
        if (event.getClickedInventory() == null) return;
        if (!event.getClick().equals(ClickType.DOUBLE_CLICK)) return;

        if (event.getClickedInventory().getType() == InventoryType.PLAYER){
            sortPlayerInventory(player);
            event.setCancelled(true);
        } else if (event.getClickedInventory().getType() == InventoryType.CHEST ||
                   event.getClickedInventory().getType() == InventoryType.SHULKER_BOX ||
                   event.getClickedInventory().getType() == InventoryType.BARREL) {
            sortChestInventory(player, event.getClickedInventory());
            event.setCancelled(true);
        }
    }

    private void sortPlayerInventory (Player player) {
        PlayerInventory inventory = player.getInventory();
        ItemStack[] allContents = inventory.getContents();

        // Create a new array for the main inventory contents.
        ItemStack[] mainInventoryContents = new ItemStack[27];

        // Copy the main inventory slots to the new array.
        System.arraycopy(allContents, 9, mainInventoryContents, 0, 27);

        // Sort the array by the order of the material.
        Arrays.sort(mainInventoryContents, Comparator.comparing(item -> {
            if (item == null || item.getType() == Material.AIR) {
                // Treat null or Material.AIR items as larger than any other material.
                return Integer.MAX_VALUE;
            } else {
                // For other materials, return their ordinal.
                return item.getType().ordinal();
            }
        }));

        // Add the sorted items back to the main inventory.
        for (int i = 0; i < mainInventoryContents.length; i++) {
            player.getInventory().setItem(i + 9, mainInventoryContents[i]);
        }

        // Update the player's client to reflect the changes.
        player.updateInventory();
    }

    private void sortChestInventory(Player player, Inventory inv) {
        ItemStack[] contents = inv.getContents();

        // Remove empty slots and hotbar slots from the array.
        contents = Arrays.stream(contents)
                .filter(itemStack -> itemStack != null &&
                        itemStack.getType() != Material.AIR) // Exclude hotbar slots (0 to 8)
                .toArray(ItemStack[]::new);

        // Sort the array by the order of the material.
        Arrays.sort(contents, Comparator.comparing(itemStack -> itemStack.getType().ordinal()));

        // Clear the player's inventory.
        inv.clear();

        // Add the sorted items back to the inventory.
        for (int i = 0; i < contents.length; i++) {
            inv.setItem(i, contents[i]);
        }

        // Update the player's client to reflect the changes.
        player.updateInventory();
    }
}
