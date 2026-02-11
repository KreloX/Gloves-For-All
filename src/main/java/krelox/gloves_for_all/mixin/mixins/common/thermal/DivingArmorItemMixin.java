package krelox.gloves_for_all.mixin.mixins.common.thermal;

import cofh.thermal.core.common.item.DivingArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DivingArmorItem.class)
public class DivingArmorItemMixin {
    @Shadow(remap = false)
    @Final
    protected static double[] SWIM_SPEED_BONUS;

    @Inject(method = "<clinit>", at = @At("TAIL"), remap = false)
    private static void aether_gloves_for_all$modifyResistanceRatio(CallbackInfo ci) {
        SWIM_SPEED_BONUS[1] = 0.20D;
    }

    private DivingArmorItemMixin() {
    }
}
