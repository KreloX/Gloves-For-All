package krelox.gloves_for_all.item.gloves;

import com.google.common.collect.Multimap;
import krelox.gloves_for_all.item.CompatMaterial;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class CopperGlovesItem extends CompatGlovesItem {
    public CopperGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        var modifierMultimap = super.getAttributeModifiers(slotContext, uuid, stack);
        modifierMultimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "Copper attack speed reduction", -0.2, AttributeModifier.Operation.ADDITION));
        return modifierMultimap;
    }
}
