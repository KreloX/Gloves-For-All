package krelox.gloves_for_all.item;

import com.aetherteam.aether.AetherConfig;
import com.simibubi.create.foundation.item.TooltipHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardboardGlovesItem extends CompatGlovesItem {
    public CardboardGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (getCompatMaterial().getCompatModule().isLoaded()) {
            if (Screen.hasShiftDown()) {
                if (AetherConfig.SERVER.require_gloves.get()) {
                    tooltipComponents.addAll(1, TooltipHelper.cutTextComponent(Component.translatable("item.create.cardboard_armor.tooltip.behaviour1"), Style.EMPTY.withColor(0xC9974C), Style.EMPTY.withColor(0xF1DD79), 1));
                    tooltipComponents.add(1, Component.translatable("item.create.cardboard_armor.tooltip.condition1").withStyle(ChatFormatting.GRAY));
                    tooltipComponents.add(1, Component.empty());
                }
                tooltipComponents.addAll(1, TooltipHelper.cutTextComponent(Component.translatable("item.create.cardboard_armor.tooltip.summary"), Style.EMPTY.withColor(0xC9974C), Style.EMPTY.withColor(0xF1DD79)));
                tooltipComponents.add(1, Component.empty());
            }
            var keyShift = Component.translatable("create.tooltip.keyShift").withStyle(Screen.hasShiftDown() ? ChatFormatting.WHITE : ChatFormatting.GRAY);
            tooltipComponents.add(1, Component.translatable("create.tooltip.holdForDescription", keyShift).withStyle(ChatFormatting.DARK_GRAY));
        } else {
            super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        }
    }
}
