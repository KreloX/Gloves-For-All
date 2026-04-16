package krelox.gloves_for_all.mixin.mixins.common.savage_and_ravage;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.teamabnormals.savage_and_ravage.common.item.BlastProofArmorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlastProofArmorType.class)
public class BlastProofArmorTypeMixin {
    @ModifyExpressionValue(
            method = "<clinit>",
            at = {
                    @At(value = "CONSTANT", args = "intValue=25", ordinal = 0),
                    @At(value = "CONSTANT", args = "intValue=20")
            },
            remap = false
    )
    private static int aether_gloves_for_all$lowerReduction(int reduction) {
        return reduction - 5;
    }

    private BlastProofArmorTypeMixin() {
    }
}
