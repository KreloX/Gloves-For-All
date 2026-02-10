package krelox.gloves_for_all.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.teamabnormals.savage_and_ravage.core.registry.SRAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class GrieferGlovesItem extends CompatGlovesItem {
    public GrieferGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        if (!CompatModule.SAVAGE_AND_RAVAGE.isLoaded()) {
            return super.getAttributeModifiers(slotContext, uuid, stack);
        }
        var builder = new ImmutableMultimap.Builder<Attribute, AttributeModifier>();
        builder.putAll(super.getAttributeModifiers(slotContext, uuid, stack));
        builder.put(SRAttributes.EXPLOSIVE_DAMAGE_REDUCTION.get(), new AttributeModifier(uuid, "Blast proof", 0.1, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }

    @Override
    public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
