package krelox.gloves_for_all.item;

import com.google.common.base.Suppliers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class FallbackArmorMaterial implements ArmorMaterial {
    private final String name;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final Supplier<Ingredient> repairIngredient;

    public FallbackArmorMaterial(String name, int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return 0;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
