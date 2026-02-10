
package krelox.gloves_for_all.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.teamabnormals.caverns_and_chasms.core.registry.CCAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class SilverGlovesItem extends CompatGlovesItem {
    public SilverGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        if (!CompatModule.CAVERNS_AND_CHASMS.isLoaded()) {
            return super.getAttributeModifiers(slotContext, uuid, stack);
        }
        var builder = new ImmutableMultimap.Builder<Attribute, AttributeModifier>();
        builder.putAll(super.getAttributeModifiers(slotContext, uuid, stack));
        builder.put(CCAttributes.MAGIC_DAMAGE.get(), new AttributeModifier(uuid, "Magic damage", 0.15, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }
}
