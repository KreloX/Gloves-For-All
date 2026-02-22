package krelox.gloves_for_all.mixin.mixins.common.thermal;

import cofh.core.common.event.ArmorEvents;
import cofh.thermal.core.init.registries.TCoreItems;
import com.aetherteam.aether.item.EquipmentUtil;
import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(ArmorEvents.class)
public class ArmorEventsMixin {
    @ModifyReturnValue(method = "getHazardResistance", at = @At("RETURN"), remap = false)
    private static double aether_gloves_for_all$injectHazardResistance(double hazardResistance, @Local(argsOnly = true) Entity entity) {
        if (entity instanceof LivingEntity livingEntity && EquipmentUtil.hasCurio(livingEntity, GlovesItems.HAZMAT_GLOVES.get())) {
            return hazardResistance + 0.10D;
        }
        return hazardResistance;
    }

    @ModifyReturnValue(method = "getStingResistance", at = @At("RETURN"), remap = false)
    private static double aether_gloves_for_all$injectStingResistance(double stingResistance, @Local(argsOnly = true) Entity entity) {
        if (entity instanceof LivingEntity livingEntity && EquipmentUtil.hasCurio(livingEntity, GlovesItems.BEEKEEPER_GLOVES.get())) {
            return stingResistance + 0.10D;
        }
        return stingResistance;
    }

    @WrapOperation(
            method = "handleLivingAttackEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lcofh/core/common/event/ArmorEvents;attemptDamagePlayerArmor(Lnet/minecraft/world/entity/Entity;F)V",
                    ordinal = 0,
                    remap = false
            ),
            remap = false
    )
    private static void aether_gloves_for_all$redirectHazmatDamageAttempt(Entity entity, float amount, Operation<Void> original) {
        aether_gloves_for_all$attemptDamagePlayerArmorAndGloves(entity, amount, TCoreItems.HAZMAT);
    }

    @WrapOperation(
            method = "handleLivingAttackEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lcofh/core/common/event/ArmorEvents;attemptDamagePlayerArmor(Lnet/minecraft/world/entity/Entity;F)V",
                    ordinal = 1,
                    remap = false
            ),
            remap = false
    )
    private static void aether_gloves_for_all$redirectBeekeeperDamageAttempt(Entity entity, float amount, Operation<Void> original) {
        aether_gloves_for_all$attemptDamagePlayerArmorAndGloves(entity, amount, TCoreItems.BEEKEEPER);
    }

    @WrapOperation(
            method = "handlePotionApplicableEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lcofh/core/common/event/ArmorEvents;attemptDamagePlayerArmor(Lnet/minecraft/world/entity/Entity;F)V",
                    remap = false
            ),
            remap = false
    )
    private static void aether_gloves_for_all$redirectHazmatPotionDamageAttempt(Entity entity, float amount, Operation<Void> original) {
        aether_gloves_for_all$attemptDamagePlayerArmorAndGloves(entity, amount, TCoreItems.HAZMAT);
    }

    @Unique
    private static void aether_gloves_for_all$attemptDamagePlayerArmorAndGloves(Entity entity, float amount, ArmorMaterial material) {
        float random = 100 * entity.level().random.nextFloat();
        if (entity instanceof Player player && random < amount) {
            for (var stack : player.getArmorSlots()) {
                if (stack.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == material) {
                    player.getInventory().hurtArmor(entity.level().damageSources().generic(),
                            Math.min(20.0F, amount), new int[]{armorItem.getEquipmentSlot().getIndex()});
                }
            }

            var glovesSlotResult = EquipmentUtil.getGloves(player);
            if (glovesSlotResult != null && ((GlovesItem) glovesSlotResult.stack().getItem()).getMaterial() == material) {
                glovesSlotResult.stack().hurtAndBreak(Math.min(5, (int) (amount / 4)), player,
                        wearer -> CuriosApi.broadcastCurioBreakEvent(glovesSlotResult.slotContext()));
            }
        }
    }

    private ArmorEventsMixin() {
    }
}
