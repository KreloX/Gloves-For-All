package krelox.gloves_for_all.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class TenebrumGlovesItem extends CompatGlovesItem {
    public TenebrumGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        var builder = new ImmutableMultimap.Builder<Attribute, AttributeModifier>();
        builder.putAll(super.getAttributeModifiers(slotContext, uuid, stack));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "Tenebrum attack speed reduction", -0.16, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }
}
