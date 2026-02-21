package krelox.gloves_for_all.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import krelox.gloves_for_all.GlovesForAll;

public class CompatGlovesItem extends GlovesItem {
    private final CompatMaterial compatMaterial;
    private boolean isTrimmable = true;

    public CompatGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material.getArmorMaterial(), punchDamage, GlovesForAll.modLoc(material.getSerializedName() + "_gloves"),
                material.getArmorMaterial()::getEquipSound, properties.durability(material.getUses()));
        this.compatMaterial = material;
    }

    public CompatMaterial getCompatMaterial() {
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
