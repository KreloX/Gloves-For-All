package krelox.gloves_for_all.item;

import com.aetherteam.aether.AetherConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ManasteelGlovesItem extends TooltipGlovesItem {
    public ManasteelGlovesItem(CompatMaterial material, double punchDamage, Supplier<Item> tooltipSource, Properties properties) {
        super(material, punchDamage, tooltipSource, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (getCompatMaterial().getCompatModule().isLoaded()) {
            tooltipSource.get().inventoryTick(stack, level, entity, slotId, isSelected);
        } else {
            super.inventoryTick(stack, level, entity, slotId, isSelected);
        }
    }

    @Override
    public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
        if (getCompatMaterial().getCompatModule().isLoaded()) {
            return tooltipSource.get().makesPiglinsNeutral(stack, slotContext.entity());
        }
        return super.makesPiglinsNeutral(slotContext, stack);
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        if (getCompatMaterial().getCompatModule().isLoaded()) {
            return tooltipSource.get().damageItem(stack, amount, entity, onBroken);
        }
        return super.damageItem(stack, amount, entity, onBroken);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (AetherConfig.SERVER.require_gloves.get()) {
            super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        }
    }
}
