package krelox.gloves_for_all.item;

import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import vazkii.botania.common.handler.PixieHandler;

import java.util.UUID;

public class ElementiumGlovesItem extends ManasteelGlovesItem {
    public ElementiumGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        var modifierMultimap = super.getAttributeModifiers(slotContext, uuid, stack);
        if (CompatModule.BOTANIA.isLoaded()) {
            modifierMultimap.put(PixieHandler.PIXIE_SPAWN_CHANCE, new AttributeModifier(uuid, "Pixie spawn chance", 0.09, AttributeModifier.Operation.ADDITION));
        }
        return modifierMultimap;
    }
}
