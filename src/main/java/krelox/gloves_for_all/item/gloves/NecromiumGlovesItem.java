package krelox.gloves_for_all.item.gloves;

import com.google.common.collect.Multimap;
import com.teamabnormals.caverns_and_chasms.core.registry.CCAttributes;
import krelox.gloves_for_all.item.CompatMaterial;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class NecromiumGlovesItem extends CompatGlovesItem {
    public NecromiumGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        var modifierMultimap = super.getAttributeModifiers(slotContext, uuid, stack);
        modifierMultimap.put(CCAttributes.SLOWNESS_INFLICTION.get(), new AttributeModifier(uuid, "Slowness infliction", 1.0, AttributeModifier.Operation.ADDITION));
        return modifierMultimap;
    }
}
