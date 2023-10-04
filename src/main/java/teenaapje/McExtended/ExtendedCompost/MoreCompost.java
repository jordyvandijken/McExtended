package teenaapje.McExtended.ExtendedCompost;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import teenaapje.McExtended.Utils.Util;

import java.util.Dictionary;
import java.util.Hashtable;

public class MoreCompost implements Listener {
    Dictionary<Material, Integer> compostableItems = new Hashtable<>();

    public MoreCompost() {
        // Food
        compostableItems.put(Material.GOLDEN_APPLE, 100);
        compostableItems.put(Material.ENCHANTED_GOLDEN_APPLE, 100);
        compostableItems.put(Material.CHORUS_FRUIT, 65);
        compostableItems.put(Material.GOLDEN_CARROT, 65);
        compostableItems.put(Material.POISONOUS_POTATO, 65);
        compostableItems.put(Material.BEEF, 65);
        compostableItems.put(Material.COOKED_BEEF, 65);
        compostableItems.put(Material.PORKCHOP, 65);
        compostableItems.put(Material.COOKED_PORKCHOP, 65);
        compostableItems.put(Material.MUTTON, 65);
        compostableItems.put(Material.COOKED_MUTTON, 65);
        compostableItems.put(Material.CHICKEN, 65);
        compostableItems.put(Material.COOKED_CHICKEN, 65);
        compostableItems.put(Material.RABBIT, 65);
        compostableItems.put(Material.COOKED_RABBIT, 65);
        compostableItems.put(Material.COD, 65);
        compostableItems.put(Material.COOKED_COD, 65);
        compostableItems.put(Material.SALMON, 65);
        compostableItems.put(Material.COOKED_SALMON, 65);
        compostableItems.put(Material.TROPICAL_FISH, 65);
        compostableItems.put(Material.PUFFERFISH, 65);
        compostableItems.put(Material.SPIDER_EYE, 65);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block.getType() != Material.COMPOSTER) return;

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (!Util.dictKeyContains(compostableItems, item.getType())) return;

        // item used
        if (!player.isOp() && player.getGameMode() != GameMode.CREATIVE) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        }

        placeParticles(block);

        if (increaseLevel(item.getType())) {
            playComposteFill(block);
            return;
        }

        Util.increaseCompostLevel(block, 1, true);
    }

    @EventHandler
    public void onItemMove(InventoryMoveItemEvent event) {
        Inventory sourceInventory = event.getSource();
        Inventory destinationInventory = event.getDestination();

        // Check if either the source or destination inventory is a hopper
        if (event.getSource().getType() != InventoryType.HOPPER) return;

        // Get hopperlocation
        Location compostLocation = event.getSource().getLocation();
        assert compostLocation != null;

        // below should be the compost
        compostLocation.setY(compostLocation.getY() - 1.0);
        Block block = compostLocation.getBlock();

        if (block.getType() != Material.COMPOSTER) return;

        ItemStack item = event.getItem();

        if (!Util.dictKeyContains(compostableItems, item.getType())) return;

        // item used
        event.setItem(new ItemStack(Material.AIR));
        placeParticles(block);

        if (increaseLevel(item.getType())) {
            playComposteFill(block);
            return;
        }

        Util.increaseCompostLevel(block, 1, true);
    }

    private boolean increaseLevel (Material item) {
        int chance = Util.randomInt(1,100);
        return compostableItems.get(item) > chance;
    }

    private void playComposteFill (Block block) {
        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_COMPOSTER_FILL, 1.0f, 1.0f);
    }

    private void placeParticles (Block block) {
        Levelled blockLevel = (Levelled) block.getBlockData();
        double fillPercentage = (double) blockLevel.getLevel() / (double) blockLevel.getMaximumLevel();
        double particleCount = fillPercentage * 10; // Adjust the particle count as needed

        block.getWorld().spawnParticle(Particle.COMPOSTER, block.getLocation().add(0.5, 0.5, 0.5), (int) particleCount, .25, .25, .25);
    }
}

