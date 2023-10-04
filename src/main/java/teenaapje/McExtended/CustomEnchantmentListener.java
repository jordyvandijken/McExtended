package teenaapje.McExtended;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class CustomEnchantmentListener implements Listener {

    private Enchantment FarmersFeet;

    public CustomEnchantmentListener(Enchantment customEnchantment) {
        this.FarmersFeet = customEnchantment;
    }

    @EventHandler
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        ItemStack item = event.getItem();
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            for (Map.Entry<Enchantment, Integer> entry : meta.getEnchants().entrySet()) {
                System.out.println(entry.getKey().getName() + " " + entry.getValue());
            }
        }

    }
}
