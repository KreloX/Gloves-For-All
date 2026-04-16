package krelox.gloves_for_all.mixin.mixins.common.cofh_core;

import cofh.core.common.item.ArmorItemCoFH;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ArmorItemCoFH.class)
public class ArmorItemCoFHMixin {
    @ModifyExpressionValue(
            method = "<clinit>",
            at = {
                    @At(value = "CONSTANT", args = "doubleValue=0.40"),
                    @At(value = "CONSTANT", args = "doubleValue=0.25", ordinal = 1)
            },
            remap = false
    )
    private static double aether_gloves_for_all$lowerResistance(double resistance) {
        return resistance - 0.05;
    }

    private ArmorItemCoFHMixin() {
    }
}
