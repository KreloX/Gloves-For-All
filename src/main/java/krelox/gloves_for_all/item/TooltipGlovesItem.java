package krelox.gloves_for_all.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TooltipGlovesItem extends CompatGlovesItem {
    protected final Supplier<Item> tooltipSource;

    public TooltipGlovesItem(CompatMaterial material, double punchDamage, Supplier<Item> tooltipSource, Properties properties) {
        super(material, punchDamage, properties);
        this.tooltipSource = tooltipSource;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (getCompatMaterial().getCompatModule().isLoaded()) {
            tooltipSource.get().appendHoverText(stack, level, tooltipComponents, isAdvanced);
        }
    }
}
