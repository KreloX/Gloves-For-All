package krelox.gloves_for_all.item;

import com.google.common.collect.Multimap;
import galena.oreganized.index.OAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ElectrumGlovesItem extends CompatGlovesItem {
    public ElectrumGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        var modifierMultimap = super.getAttributeModifiers(slotContext, uuid, stack);
        modifierMultimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "Electrum attack speed boost", 0.1, AttributeModifier.Operation.ADDITION));
        modifierMultimap.put(OAttributes.KINETIC_DAMAGE.get(), new AttributeModifier(uuid, "Kinetic damage", getDamage() / 3.0F, AttributeModifier.Operation.ADDITION));
        return modifierMultimap;
    }
}
