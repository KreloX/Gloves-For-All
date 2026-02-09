package krelox.gloves_for_all.mixin;

import cofh.core.common.item.ArmorItemCoFH;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorItemCoFH.class)
public class ArmorItemCoFHMixin {
    @Shadow(remap = false)
    @Final
    protected static double[] RESISTANCE_RATIO;

    @Inject(method = "<clinit>", at = @At("TAIL"), remap = false)
    private static void gloves_for_all$modifyResistanceRatio(CallbackInfo ci) {
        RESISTANCE_RATIO[2] = 0.35D;
        RESISTANCE_RATIO[3] = 0.20D;
    }

    private ArmorItemCoFHMixin() {
    }
}
