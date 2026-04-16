package krelox.gloves_for_all.item;

import com.google.common.collect.HashMultimap;
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
import tamaized.voidscape.regutil.RegUtil.ToolAndArmorHelper;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.UUID;

public class VoidscapeGlovesItem extends CompatGlovesItem {
    protected final double voidicDamage;

    public VoidscapeGlovesItem(double voidicDamage, CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
        this.voidicDamage = voidicDamage;
    }

    public VoidscapeGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        this(switch (material) {
            case VOIDIC_CRYSTAL -> 0.1;
            case CORRUPT -> 0.2;
            case TITANITE -> 0.3;
            case ICHOR -> 0.4;
            case ASTRAL -> 0.5;
            default -> throw new IllegalArgumentException("Invalid material for voidscape gloves: " + material);
        }, material, punchDamage, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        if (ToolAndArmorHelper.isBroken(stack)) return HashMultimap.create();

        var modifierMultimap = super.getAttributeModifiers(slotContext, uuid, stack);
        modifierMultimap.put(ModAttributes.VOIDIC_DMG.get(), new AttributeModifier(uuid, "Voidic damage", voidicDamage, AttributeModifier.Operation.ADDITION));
        return modifierMultimap;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        if (ToolAndArmorHelper.isBroken(stack)) {
            var entity = slotContext.entity();
            if (slotContext.entity() instanceof Player player && player.addItem(stack)) {
                stack.shrink(1);
            } else {
                Containers.dropItemStack(entity.level(), entity.position().x(), entity.position().y(), entity.position().z(), stack);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (ToolAndArmorHelper.isBroken(stack)) {
            tooltipComponents.add(Component.translatable(Voidscape.MODID + ".tooltip.broken").withStyle(ChatFormatting.DARK_RED));
        }
    }
}
