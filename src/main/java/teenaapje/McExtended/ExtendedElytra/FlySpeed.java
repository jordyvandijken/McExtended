package teenaapje.McExtended.ExtendedElytra;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class FlySpeed implements Listener {
    private final HashMap<UUID, BossBar> bossBars = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Vector velocity = player.getVelocity();
        double speed = velocity.length();
        double speedInBlocksPerSecond = speed * 20; // Because there are 20 ticks in a second

        if (player.isGliding()) {
            double fallDamage = calculateFallDamage(player);
            double maxFallDamage = maxHeightFallDamage(player);

            // Check if the fall damage is fatal (more than 20, as each heart represents 2 health points)
            BarColor barColor = BarColor.GREEN;
            if (fallDamage >= player.getHealth()) {
                barColor = BarColor.RED;
            } else if (fallDamage > 0) {
                barColor = BarColor.YELLOW;
            }

            // Get the boss bar for the player
            BossBar bossBar = bossBars.get(player.getUniqueId());
            if (bossBar == null) {
                bossBar = Bukkit.createBossBar("", barColor, BarStyle.SOLID);

                // Add the player to the boss bar
                bossBar.addPlayer(player);
                bossBars.put(player.getUniqueId(), bossBar);
            }

            bossBar.setColor(barColor);
            bossBar.setTitle(String.format("%.02f", speedInBlocksPerSecond) + " blocks/second");
            bossBar.setProgress(Math.max(0, Math.min(1, fallDamage/maxFallDamage)));

        } else if (bossBars.containsKey(player.getUniqueId())) {
            // If the player is not gliding and has a boss bar, remove the player from the boss bar
            BossBar bossBar = bossBars.get(player.getUniqueId());
            bossBar.removePlayer(player);

            // Remove the boss bar from the HashMap
            bossBars.remove(player.getUniqueId());
        }
    }

    public double calculateFallDamage(Player player) {
        // Check if the player has boots
        ItemStack boots = player.getInventory().getBoots();

        // If the player has boots, check for Feather Falling
        int featherFallingLevel = 0; // Default to no Feather Falling
        if (boots != null && boots.getType() != Material.AIR) {
            featherFallingLevel = boots.getEnchantmentLevel(Enchantment.PROTECTION_FALL);
        }

        // Calculate fall damage based on fall distance
        double fallDistance = player.getFallDistance();
        double damageReduction = 1.0; // Initial damage reduction factor

        // Apply Feather Falling reduction if the player has it
        if (featherFallingLevel > 0) {
            // Calculate the reduction factor based on Feather Falling level
            double reductionFactor = 0.125 * featherFallingLevel; // 12.5% reduction per level
            damageReduction -= reductionFactor;
        }

        // Calculate the final fall damage after applying Feather Falling
        return Math.max(0, (int) ((fallDistance - 3.0) / 2.0 * damageReduction));
    }

    public double maxHeightFallDamage(Player player) {
        int health = 20; // in half hearts

        // Check if the player has boots
        ItemStack boots = player.getInventory().getBoots();
        double BlockHeightIncrease = 1; // Default to no Feather Falling
        if (boots != null && boots.getType() != Material.AIR) {
            int featherFallingLevel = boots.getEnchantmentLevel(Enchantment.PROTECTION_FALL);
            if (featherFallingLevel > 0) {
                BlockHeightIncrease = 1 + (featherFallingLevel * .125);
            }
        }

        return (health * BlockHeightIncrease) / 2 + 3;
    }
}
