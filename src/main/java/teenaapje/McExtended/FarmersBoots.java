package teenaapje.McExtended;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityCategory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FarmersBoots extends Enchantment {
    private final List<Material> enchantableItems = new ArrayList<>();

    public static String echantmentID = "FARMERS_BOOTS";

    public FarmersBoots(NamespacedKey key) {
        super(key);

        this.enchantableItems.add(Material.LEATHER_BOOTS);
        this.enchantableItems.add(Material.IRON_BOOTS);
        this.enchantableItems.add(Material.DIAMOND_BOOTS);
        this.enchantableItems.add(Material.GOLDEN_BOOTS);
        this.enchantableItems.add(Material.NETHERITE_BOOTS);

    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        // Define which items can be enchanted with your custom enchantment
        return  enchantableItems.contains(item.getType());
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        // Define any conflicting enchantments
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR_FEET;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        // Define the maximum level of your enchantment
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public String getName() {
        // Define the name of your enchantment
        return echantmentID;
    }

}