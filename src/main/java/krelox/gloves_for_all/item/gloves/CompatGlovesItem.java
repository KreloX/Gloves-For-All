package krelox.gloves_for_all.item.gloves;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.CompatMaterial;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class CompatGlovesItem extends GlovesItem {
    private final CompatMaterial compatMaterial;

    public CompatGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material.getArmorMaterial(), punchDamage, GlovesForAll.modLoc(material.getSerializedName() + "_gloves"),
                material.getArmorMaterial()::getEquipSound, properties);
        this.compatMaterial = material;
    }

    public CompatMaterial getCompatMaterial() {
        return compatMaterial;
    }

    @Override
    public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
        return getCompatMaterial().getArmorItem().makesPiglinsNeutral(getCompatMaterial().getArmorItem().getDefaultInstance(), slotContext.entity());
    }
}
