package krelox.gloves_for_all.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CompatGlovesItem extends GlovesItem {
    private final CompatArmorMaterial compatMaterial;
    private boolean isTrimmable = true;

    public CompatGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(null, punchDamage, GlovesForAll.modLoc(material.getCompatModule().getSourceModId() + "/" + material.getSerializedName() + "_gloves"),
                null, properties.durability(material.getUses()));
        this.compatMaterial = material;
    }

    public CompatArmorMaterial getCompatMaterial() {
        return compatMaterial;
    }

    public CompatGlovesItem disableTrimming() {
        isTrimmable = false;
        return this;
    }

    public boolean isTrimmable() {
        return isTrimmable;
    }

    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(getMaterial().getEquipSound(), 1.0F, 1.0F);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getEnchantmentValue() {
        return getMaterial().getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack item, ItemStack material) {
        return getMaterial().getRepairIngredient().test(material) || super.isValidRepairItem(item, material);
    }

    @Override
    public ArmorMaterial getMaterial() {
        return getCompatMaterial().getArmorMaterial();
    }
}
