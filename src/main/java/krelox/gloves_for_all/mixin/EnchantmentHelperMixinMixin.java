package krelox.gloves_for_all.mixin;

import com.aetherteam.aether.item.EquipmentUtil;
import com.bawnorton.mixinsquared.TargetHandler;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Mixin(value = EnchantmentHelper.class, priority = 1500)
public class EnchantmentHelperMixinMixin {
    @TargetHandler(
            mixin = "com.teamabnormals.caverns_and_chasms.core.mixin.EnchantmentHelperMixin",
            name = "doPostDamageEffects"
    )
    @Redirect(
            method = "@MixinSquared:Handler",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/Multimap;get(Ljava/lang/Object;)Ljava/util/Collection;",
                    remap = false
            )
    )
    private static <K> Collection<AttributeModifier> gloves_for_all$injectGlovesModifiers(Multimap<K, AttributeModifier> attributeModifiers, K attribute, LivingEntity attacker, Entity target) {
        var modifiers = new ArrayList<>(attributeModifiers.get(attribute));
        var slotResult = EquipmentUtil.getGloves(attacker);
        if (slotResult != null) {
            var curioItem = (ICurioItem) slotResult.stack().getItem();
            var curioAttributeModifiers = curioItem.getAttributeModifiers(slotResult.slotContext(), UUID.randomUUID(), slotResult.stack());
            modifiers.addAll(curioAttributeModifiers.get((Attribute) attribute));
        }
        return modifiers;
    }

    @TargetHandler(
            mixin = "com.teamabnormals.caverns_and_chasms.core.mixin.EnchantmentHelperMixin",
            name = "doPostDamageEffects"
    )
    @Redirect(
            method = "@MixinSquared:Handler",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
            )
    )
    private static boolean gloves_for_all$skipSilverPickaxeCheck(ItemStack stack, Item item) {
        return true;
    }

    private EnchantmentHelperMixinMixin() {
    }
}