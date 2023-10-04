package teenaapje.McExtended;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomEnchants {
    public static final Enchantment farmersFeet = new FarmersBoots(new NamespacedKey(ExtendedCore.getPlugin(ExtendedCore.class), FarmersBoots.echantmentID));

    public static void register() {
        if (!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(farmersFeet)) {
            registerEnchantment(farmersFeet);
        }
    }

    public static boolean registerEnchantment (Enchantment enchantment)
    {
        boolean registered = true;

        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        return registered;
    }

}
