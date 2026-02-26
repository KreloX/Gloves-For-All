package krelox.gloves_for_all.item;

import com.legacy.blue_skies.util.StringUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HorizoniteGlovesItem extends BlueSkiesGlovesItem {
    public HorizoniteGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (CompatModule.BLUE_SKIES.isLoaded()) {
            tooltipComponents.add(Component.literal(StringUtil.getAbilityText("gui.blue_skies.item.ability.fire")));
        }
    }
}
