package krelox.gloves_for_all.mixin;

import com.aetherteam.aether.item.EquipmentUtil;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalDoubleRef;
import com.teamabnormals.savage_and_ravage.core.other.SREvents;
import com.teamabnormals.savage_and_ravage.core.registry.SRAttributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

@Mixin(SREvents.class)
public class SREventsMixin {
    @Inject(
            method = "onLivingDamage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"
            ),
            remap = false
    )
    private static void gloves_for_all$injectGlovesModifiers(LivingDamageEvent event, CallbackInfo ci, @Local(name = "decrease") LocalDoubleRef decrease) {
        var target = event.getEntity();
        var slotResult = EquipmentUtil.getGloves(target);
        if (slotResult != null) {
            var stack = slotResult.stack();
            var curioItem = (ICurioItem) stack.getItem();
            var curioAttributeModifiers = curioItem.getAttributeModifiers(slotResult.slotContext(), UUID.randomUUID(), stack);
            var explosiveDamageReductionModifiers = curioAttributeModifiers.get(SRAttributes.EXPLOSIVE_DAMAGE_REDUCTION.get());
            if (!explosiveDamageReductionModifiers.isEmpty()) {
                decrease.set(decrease.get() + explosiveDamageReductionModifiers.stream().mapToDouble(AttributeModifier::getAmount).sum());
                slotResult.stack().hurtAndBreak(8, target, wearer -> CuriosApi.broadcastCurioBreakEvent(slotResult.slotContext()));
            }
        }
    }

    private SREventsMixin() {
    }
}
