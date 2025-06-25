package krelox.gloves_for_all.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import krelox.gloves_for_all.GlovesForAll;
import mekanism.tools.common.util.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.List;

public class CompatGlovesItem extends GlovesItem {
    private final CompatArmorMaterial compatMaterial;
    private boolean isTrimmable = true;

    public CompatGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, GlovesForAll.modLoc(material.getCompatModule().getSourceModId() + "/" + material.getName() + "_gloves"),
                material::getEquipSound, properties.stacksTo(1));
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
    public int getMaxDamage() {
        maxDamage = getMaterial().getDurabilityForType(ArmorItem.Type.HELMET) / 11 * 12;
        return super.getMaxDamage();
    }

    @Override
    public boolean canBeDepleted() {
        return getMaxDamage() > 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (getCompatMaterial().getCompatModule() == CompatModule.MEKANISM_TOOLS && CompatModule.MEKANISM_TOOLS.isLoaded()) {
            ToolsUtils.addDurability(tooltipComponents, stack);
        }
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
        return getMaterial().getRepairIngredient().test(material);
    }

    @Override
    public ArmorMaterial getMaterial() {
        return getCompatMaterial().getArmorMaterial();
    }
}
