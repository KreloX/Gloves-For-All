package krelox.gloves_for_all.mixin.common.create;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.item.EquipmentUtil;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.equipment.armor.CardboardArmorHandler;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CardboardArmorHandler.class)
public class CardboardArmorHandlerMixin {
    @ModifyReturnValue(method = "testForStealth", at = @At("RETURN"), remap = false)
    private static boolean aether_gloves_for_all$hasCardboardGloves(boolean hasFullCardboardSet, @Local(argsOnly = true) Entity entityIn) {
        if (AetherConfig.SERVER.require_gloves.get()) {
            return hasFullCardboardSet && EquipmentUtil.hasCurio((LivingEntity) entityIn, GlovesItems.CARDBOARD_GLOVES.get());
        }
        return hasFullCardboardSet;
    }

    private CardboardArmorHandlerMixin() {
    }
}
