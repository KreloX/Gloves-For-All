package krelox.gloves_for_all.mixin;

import com.aetherteam.aether.item.EquipmentUtil;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import com.teamabnormals.caverns_and_chasms.core.other.CCEvents;
import com.teamabnormals.caverns_and_chasms.core.registry.CCAttributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

@Mixin(CCEvents.class)
public class CCEventsMixin {
    @Inject(
            method = "onLivingHurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;",
                    ordinal = 1
            ),
            remap = false
    )
    private static void gloves_for_all$injectGlovesModifiers(LivingHurtEvent event, CallbackInfo ci,
                                                             @Local(name = "weaknessAmount") LocalFloatRef weaknessAmount,
                                                             @Local(name = "lifeStealAmount") LocalFloatRef lifeStealAmount) {
        var target = event.getEntity();
        var targetGlovesSlot = EquipmentUtil.getGloves(target);
        if (targetGlovesSlot != null) {
            var curioItem = (ICurioItem) targetGlovesSlot.stack().getItem();
            var curioAttributeModifiers = curioItem.getAttributeModifiers(targetGlovesSlot.slotContext(), UUID.randomUUID(), targetGlovesSlot.stack());
            var weaknessModifiers = curioAttributeModifiers.get(CCAttributes.WEAKNESS_AURA.get());
            if (!weaknessModifiers.isEmpty()) {
                weaknessAmount.set(weaknessAmount.get() + (float) weaknessModifiers.stream().mapToDouble(AttributeModifier::getAmount).sum());
            }
        }

        var attackerGlovesSlot = EquipmentUtil.getGloves((LivingEntity) event.getSource().getEntity());
        if (attackerGlovesSlot != null) {
            var curioItem = (ICurioItem) attackerGlovesSlot.stack().getItem();
            var curioAttributeModifiers = curioItem.getAttributeModifiers(attackerGlovesSlot.slotContext(), UUID.randomUUID(), attackerGlovesSlot.stack());
            var lifeStealModifiers = curioAttributeModifiers.get(CCAttributes.LIFESTEAL.get());
            if (!lifeStealModifiers.isEmpty() && (target instanceof Enemy || target instanceof Player)) {
                lifeStealAmount.set(lifeStealAmount.get() + (float) lifeStealModifiers.stream().mapToDouble(AttributeModifier::getAmount).sum());
            }
        }
    }

    private CCEventsMixin() {
    }
}
