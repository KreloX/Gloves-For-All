package krelox.gloves_for_all.mixin.common.savage_and_ravage;

import com.aetherteam.aether.item.EquipmentUtil;
import com.teamabnormals.savage_and_ravage.core.other.SREvents;
import com.teamabnormals.savage_and_ravage.core.registry.SRAttributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

@Mixin(SREvents.class)
public class SREventsMixin {
    @ModifyVariable(method = "onLivingDamage", at = @At(value = "STORE", ordinal = 0), name = "decrease", remap = false)
    private static double aether_gloves_for_all$addGlovesExplosiveDamageReduction(double decrease, LivingDamageEvent event) {
        var target = event.getEntity();
        var glovesSlotResult = EquipmentUtil.getGloves(target);
        if (glovesSlotResult != null) {
            var stack = glovesSlotResult.stack();
            var explosiveDamageReductionModifiers = ((ICurioItem) stack.getItem())
                    .getAttributeModifiers(glovesSlotResult.slotContext(), UUID.randomUUID(), stack)
                    .get(SRAttributes.EXPLOSIVE_DAMAGE_REDUCTION.get());
            if (!explosiveDamageReductionModifiers.isEmpty()) {
                decrease += explosiveDamageReductionModifiers.stream().mapToDouble(AttributeModifier::getAmount).sum();
                glovesSlotResult.stack().hurtAndBreak(8, target,
                        wearer -> CuriosApi.broadcastCurioBreakEvent(glovesSlotResult.slotContext()));
            }
        }
        return decrease;
    }

    private SREventsMixin() {
    }
}
