package krelox.gloves_for_all.item;

import mekanism.tools.common.util.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MekanismToolsGlovesItem extends CompatGlovesItem {
    public MekanismToolsGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (CompatModule.MEKANISM_TOOLS.isLoaded()) {
            ToolsUtils.addDurability(tooltipComponents, stack);
        }
    }
}
