package krelox.gloves_for_all.mixin.mixins.common.create;

import com.aetherteam.aether.item.EquipmentUtil;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.equipment.armor.CardboardArmorHandler;
import com.tterrag.registrate.util.entry.ItemEntry;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CardboardArmorHandler.class)
public class CardboardArmorHandlerMixin {
    @Redirect(
            method = "testForStealth",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/tterrag/registrate/util/entry/ItemEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z",
                    ordinal = 3,
                    remap = false
            ),
            remap = false
    )
    private static boolean aether_gloves_for_all$hasCardboardGloves(ItemEntry<?> itemEntry, ItemStack stack, @Local(name = "entity") LivingEntity entity) {
        return itemEntry.isIn(stack) && EquipmentUtil.hasCurio(entity, GlovesItems.CARDBOARD_GLOVES.get());
    }

    private CardboardArmorHandlerMixin() {
    }
}
