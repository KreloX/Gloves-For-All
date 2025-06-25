package krelox.gloves_for_all.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tamaized.voidscape.Voidscape;
import tamaized.voidscape.registry.ModAttributes;
import tamaized.voidscape.regutil.RegUtil;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.UUID;

public class VoidscapeGlovesItem extends CompatGlovesItem {
    protected final double voidicDamage;

    public VoidscapeGlovesItem(CompatArmorMaterial material, double punchDamage, double voidicDamage, Properties properties) {
        super(material, punchDamage, properties);
        this.voidicDamage = voidicDamage;
    }

    public static boolean isBroken(ItemStack stack) {
        return CompatModule.VOIDSCAPE.isLoaded() && RegUtil.ToolAndArmorHelper.isBroken(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (isBroken(stack)) {
            tooltipComponents.add(Component.translatable(Voidscape.MODID + ".tooltip.broken").withStyle(ChatFormatting.DARK_RED));
        }
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        var builder = new ImmutableMultimap.Builder<Attribute, AttributeModifier>();
        if (!isBroken(stack)) {
            builder.putAll(super.getAttributeModifiers(slotContext, uuid, stack));
            if (CompatModule.VOIDSCAPE.isLoaded()) {
                builder.put(ModAttributes.VOIDIC_DMG.get(), new AttributeModifier(uuid, "Voidic damage", voidicDamage, AttributeModifier.Operation.ADDITION));
            }
        }
        return builder.build();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (isBroken(stack)) {
            var entity = slotContext.entity();
            if (slotContext.entity() instanceof Player player && player.addItem(stack)) {
                stack.shrink(1);
            } else {
                Containers.dropItemStack(entity.level(), entity.position().x(), entity.position().y(), entity.position().z(), stack);
            }
        }
    }
}
