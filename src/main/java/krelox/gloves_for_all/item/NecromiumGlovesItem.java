package krelox.gloves_for_all.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.teamabnormals.caverns_and_chasms.core.registry.CCAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class NecromiumGlovesItem extends CompatGlovesItem {
    public NecromiumGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        if (!CompatModule.CAVERNS_AND_CHASMS.isLoaded()) {
            return super.getAttributeModifiers(slotContext, uuid, stack);
        }
        var builder = new ImmutableMultimap.Builder<Attribute, AttributeModifier>();
        builder.putAll(super.getAttributeModifiers(slotContext, uuid, stack));
        builder.put(CCAttributes.SLOWNESS_INFLICTION.get(), new AttributeModifier(uuid, "Slowness infliction", 1.0, AttributeModifier.Operation.ADDITION));
        builder.put(CCAttributes.WEAKNESS_AURA.get(), new AttributeModifier(uuid, "Weakness aura", 0.5, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }
}
