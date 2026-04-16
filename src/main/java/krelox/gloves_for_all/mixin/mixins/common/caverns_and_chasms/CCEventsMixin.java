package krelox.gloves_for_all.mixin.mixins.common.caverns_and_chasms;

import com.aetherteam.aether.item.EquipmentUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.teamabnormals.caverns_and_chasms.core.other.CCEvents;
import com.teamabnormals.caverns_and_chasms.core.registry.CCAttributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

@Mixin(CCEvents.class)
public class CCEventsMixin {
    @WrapOperation(
            method = "onLightningStrike",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;getItemBySlot(Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;",
                    ordinal = 1,
                    remap = true
            ),
            remap = false
    )
    private static ItemStack aether_gloves_for_all$getStackToStrike(LivingEntity entity, EquipmentSlot equipmentSlot, Operation<ItemStack> original) {
        if (entity.getRandom().nextInt(4) != 0) return original.call(entity, equipmentSlot);
        var glovesSlotResult = EquipmentUtil.getGloves(entity);
        if (glovesSlotResult == null) return ItemStack.EMPTY;
        return glovesSlotResult.stack();
    }

    @ModifyVariable(
            method = "onLivingHurt",
            at = @At(value = "STORE", ordinal = 0),
            name = "lifeStealAmount",
            remap = false
    )
    private static float aether_gloves_for_all$addGlovesLifesteal(float lifeStealAmount, @Local(argsOnly = true) LivingHurtEvent event) {
        var target = event.getEntity();
        var attackerGlovesSlotResult = EquipmentUtil.getGloves((LivingEntity) event.getSource().getEntity());
        if (attackerGlovesSlotResult != null) {
            var stack = attackerGlovesSlotResult.stack();
            var lifeStealModifiers = ((ICurioItem) stack.getItem())
                    .getAttributeModifiers(attackerGlovesSlotResult.slotContext(), UUID.randomUUID(), stack)
                    .get(CCAttributes.LIFESTEAL.get());
            if (!lifeStealModifiers.isEmpty() && (target instanceof Enemy || target instanceof Player)) {
                lifeStealAmount += (float) lifeStealModifiers.stream().mapToDouble(AttributeModifier::getAmount).sum();
            }
        }
        return lifeStealAmount;
    }

    private CCEventsMixin() {
    }
}
