package krelox.gloves_for_all.mixin.mixins.common.caverns_and_chasms;

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
    private static void aether_gloves_for_all$injectGlovesModifiers(
            LivingHurtEvent event, CallbackInfo ci, @Local(name = "lifeStealAmount") LocalFloatRef lifeStealAmount) {
        var target = event.getEntity();
        var attackerGlovesSlotResult = EquipmentUtil.getGloves((LivingEntity) event.getSource().getEntity());
        if (attackerGlovesSlotResult != null) {
            var stack = attackerGlovesSlotResult.stack();
            var lifeStealModifiers = ((ICurioItem) stack.getItem())
                    .getAttributeModifiers(attackerGlovesSlotResult.slotContext(), UUID.randomUUID(), stack)
                    .get(CCAttributes.LIFESTEAL.get());
            if (!lifeStealModifiers.isEmpty() && (target instanceof Enemy || target instanceof Player)) {
                lifeStealAmount.set(lifeStealAmount.get() + (float) lifeStealModifiers.stream().mapToDouble(AttributeModifier::getAmount).sum());
            }
        }
    }

    private CCEventsMixin() {
    }
}
