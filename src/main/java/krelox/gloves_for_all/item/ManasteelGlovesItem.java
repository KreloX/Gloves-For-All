package krelox.gloves_for_all.item;

import com.aetherteam.aether.AetherConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ManasteelGlovesItem extends CompatGlovesItem {
    public ManasteelGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        getCompatMaterial().getArmorItem().inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return getCompatMaterial().getArmorItem().damageItem(stack, amount, entity, onBroken);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (AetherConfig.SERVER.require_gloves.get()) {
            getCompatMaterial().getArmorItem().appendHoverText(stack, level, tooltipComponents, isAdvanced);
        }
    }
}
