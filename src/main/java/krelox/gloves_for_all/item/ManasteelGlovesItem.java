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
import vazkii.botania.common.item.equipment.CustomDamageItem;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ManasteelGlovesItem extends TooltipGlovesItem implements CustomDamageItem {
    public static final int MANA_PER_DAMAGE = 70;

    public ManasteelGlovesItem(CompatArmorMaterial material, double punchDamage, Supplier<Item> tooltipSource, Properties properties) {
        super(material, punchDamage, tooltipSource, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        tooltipSource.get().inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
        return tooltipSource.get().makesPiglinsNeutral(stack, slotContext.entity());
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return ToolCommons.damageItemIfPossible(stack, amount, entity, MANA_PER_DAMAGE);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (AetherConfig.SERVER.require_gloves.get()) {
            super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        }
    }
}
