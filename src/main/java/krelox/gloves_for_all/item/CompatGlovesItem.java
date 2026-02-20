package krelox.gloves_for_all.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import krelox.gloves_for_all.GlovesForAll;

public class CompatGlovesItem extends GlovesItem {
    private final CompatArmorMaterial compatMaterial;
    private boolean isTrimmable = true;

    public CompatGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material.getArmorMaterial(), punchDamage, GlovesForAll.modLoc(material.getCompatModule().getSourceModId() + "/" + material.getSerializedName() + "_gloves"),
                material.getArmorMaterial()::getEquipSound, properties.durability(material.getUses()));
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
}
