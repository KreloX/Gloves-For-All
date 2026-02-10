package krelox.gloves_for_all.mixin;

import com.teamabnormals.savage_and_ravage.common.item.BlastProofArmorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(BlastProofArmorType.class)
public class BlastProofArmorTypeMixin {
    @ModifyArg(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/teamabnormals/savage_and_ravage/common/item/BlastProofArmorType;<init>(Ljava/lang/String;ILjava/lang/String;Lnet/minecraft/world/entity/EquipmentSlot;I)V"
            ),
            index = 4,
            slice = @Slice(to = @At(
                    value = "INVOKE",
                    target = "Lcom/teamabnormals/savage_and_ravage/common/item/BlastProofArmorType;<init>(Ljava/lang/String;ILjava/lang/String;Lnet/minecraft/world/entity/EquipmentSlot;I)V",
                    ordinal = 1
            )),
            remap = false
    )
    private static int gloves_for_all$lowerReduction(int reduction) {
        return reduction - 5;
    }

    private BlastProofArmorTypeMixin() {
    }
}
