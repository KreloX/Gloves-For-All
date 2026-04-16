package krelox.gloves_for_all.item.gloves;

import com.aetherteam.aether.AetherConfig;
import com.simibubi.create.foundation.item.TooltipHelper;
import krelox.gloves_for_all.item.CompatMaterial;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardboardGlovesItem extends CompatGlovesItem {
    public CardboardGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 1000;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        var keyShift = Component.translatable("create.tooltip.keyShift").withStyle(Screen.hasShiftDown() ? ChatFormatting.WHITE : ChatFormatting.GRAY);
        tooltipComponents.add(Component.translatable("create.tooltip.holdForDescription", keyShift).withStyle(ChatFormatting.DARK_GRAY));
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.empty());
            tooltipComponents.addAll(TooltipHelper.cutTextComponent(Component.translatable("item.create.cardboard_armor.tooltip.summary"), Style.EMPTY.withColor(0xC9974C), Style.EMPTY.withColor(0xF1DD79)));
            if (AetherConfig.SERVER.require_gloves.get()) {
                tooltipComponents.add(Component.empty());
                tooltipComponents.add(Component.translatable("item.create.cardboard_armor.tooltip.condition1").withStyle(ChatFormatting.GRAY));
                tooltipComponents.addAll(TooltipHelper.cutTextComponent(Component.translatable("item.create.cardboard_armor.tooltip.behaviour1"), Style.EMPTY.withColor(0xC9974C), Style.EMPTY.withColor(0xF1DD79), 1));
            }
        }
    }
}
