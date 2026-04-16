package krelox.gloves_for_all.mixin.mixins.common.thermal_extra;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.item.EquipmentUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import krelox.gloves_for_all.item.GlovesItems;
import mrthomas20121.thermal_extra.CommonEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CommonEvents.class)
public class CommonEventsMixin {
    @WrapOperation(
            method = "visibilityEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lmrthomas20121/thermal_extra/CommonEvents;isFullArmor(Lnet/minecraft/tags/TagKey;Lnet/minecraft/world/entity/LivingEntity;)Z"
            ),
            remap = false
    )
    private static boolean aether_gloves_for_all$hasFullTwiniteSet(TagKey<Item> armor, LivingEntity entity, Operation<Boolean> original) {
        return aether_gloves_for_all$hasFullSet(armor, entity, GlovesItems.TWINITE_GLOVES.get());
    }

    @WrapOperation(
            method = "enderPearlEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lmrthomas20121/thermal_extra/CommonEvents;isFullArmor(Lnet/minecraft/tags/TagKey;Lnet/minecraft/world/entity/LivingEntity;)Z"
            ),
            remap = false
    )
    private static boolean aether_gloves_for_all$hasFullEnderiumSet(TagKey<Item> armor, LivingEntity entity, Operation<Boolean> original) {
        return aether_gloves_for_all$hasFullSet(armor, entity, GlovesItems.ENDERIUM_GLOVES.get());
    }

    @WrapOperation(
            method = "takeDamage",
            at = @At(
                    value = "INVOKE",
                    target = "Lmrthomas20121/thermal_extra/CommonEvents;isFullArmor(Lnet/minecraft/tags/TagKey;Lnet/minecraft/world/entity/LivingEntity;)Z"
            ),
            remap = false
    )
    private static boolean aether_gloves_for_all$hasFullShelliteSet(TagKey<Item> armor, LivingEntity entity, Operation<Boolean> original) {
        return aether_gloves_for_all$hasFullSet(armor, entity, GlovesItems.SHELLITE_GLOVES.get());
    }

    @Unique
    private static boolean aether_gloves_for_all$hasFullSet(TagKey<Item> armor, LivingEntity entity, Item gloves) {
        for (int slotIndex : Inventory.ALL_ARMOR_SLOTS) {
            if (!entity.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, slotIndex)).is(armor)) {
                return false;
            }
        }
        if (AetherConfig.SERVER.require_gloves.get()) {
            return EquipmentUtil.hasCurio(entity, gloves);
        }
        return true;
    }

    private CommonEventsMixin() {
    }
}
