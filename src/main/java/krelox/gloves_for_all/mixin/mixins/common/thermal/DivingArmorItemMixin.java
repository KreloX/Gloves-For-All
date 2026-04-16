package krelox.gloves_for_all.mixin.mixins.common.thermal;

import cofh.thermal.core.common.item.DivingArmorItem;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DivingArmorItem.class)
public class DivingArmorItemMixin {
    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "CONSTANT", args = "doubleValue=0.30"), remap = false)
    private static double aether_gloves_for_all$lowerLeggingsSwimSpeed(double swimSpeed) {
        return swimSpeed - 0.10;
    }

    private DivingArmorItemMixin() {
    }
}
