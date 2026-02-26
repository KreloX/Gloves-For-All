package krelox.gloves_for_all.item;

import com.legacy.blue_skies.items.util.IFalsiteItem;
import net.minecraft.world.item.ItemStack;

public class BlueSkiesGlovesItem extends CompatGlovesItem implements IFalsiteItem {
    public BlueSkiesGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public boolean isFalsiteCompatible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return falsiteBarColor(stack, super.getBarColor(stack));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return falsiteBarVisible(stack, super.isBarVisible(stack));
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return falsiteBarWidth(stack, super.getBarWidth(stack));
    }
}
