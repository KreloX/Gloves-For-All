package krelox.gloves_for_all.mixin.mixins.common.undergarden;

import com.aetherteam.aether.item.EquipmentUtil;
import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quek.undergarden.item.tool.UGToolEvents;
import quek.undergarden.network.CreateCritParticlePacket;
import quek.undergarden.network.UGPacketHandler;
import quek.undergarden.registry.UGItems;
import quek.undergarden.registry.UGParticleTypes;
import quek.undergarden.registry.UGTags;

@Mixin(UGToolEvents.class)
public class UGToolEventsMixin {
    @Inject(method = "utheriumAttackEvent", at = @At("HEAD"), cancellable = true, remap = false)
    private static void aether_gloves_for_all$utheriumAttackEvent(LivingHurtEvent event, CallbackInfo ci) {
        LivingEntity target = event.getEntity();
        if (event.getSource().getEntity() instanceof LivingEntity attacker && target.getType().is(UGTags.Entities.ROTSPAWN)) {
            double bonus = 0;

            var heldStack = attacker.getMainHandItem();
            if (heldStack.is(UGItems.UTHERIUM_SWORD.get()) && heldStack.getItem() instanceof SwordItem sword) {
                bonus += (1 + sword.getDamage() + EnchantmentHelper.getDamageBonus(heldStack, target.getMobType())) * 0.5;
            } else if (heldStack.is(UGItems.UTHERIUM_AXE.get()) && heldStack.getItem() instanceof AxeItem axe) {
                bonus += (1 + axe.getAttackDamage() + EnchantmentHelper.getDamageBonus(heldStack, target.getMobType())) * 0.5;
            }

            if (EquipmentUtil.hasCurio(attacker, GlovesItems.UTHERIUM_GLOVES.get()) && GlovesItems.UTHERIUM_GLOVES.get() instanceof GlovesItem gloves) {
                bonus += gloves.getDamage() * 0.5;
            }

            if (bonus > 0) {
                event.setAmount((float) (event.getAmount() + bonus));
                if (!target.level().isClientSide()) {
                    UGPacketHandler.CHANNEL.send(PacketDistributor.ALL.noArg(), new CreateCritParticlePacket(target.getId(), 2, UGParticleTypes.UTHERIUM_CRIT.get()));
                }
            }
        }
        ci.cancel();
    }

    @ModifyExpressionValue(
            method = "froststeelAttackEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z",
                    ordinal = 2,
                    remap = true
            ),
            remap = false
    )
    private static boolean aether_gloves_for_all$hasFroststeelGloves(boolean hasFroststeelPickaxe, @Local(name = "source") Entity source) {
        return hasFroststeelPickaxe || EquipmentUtil.hasCurio((LivingEntity) source, GlovesItems.FROSTSTEEL_GLOVES.get());
    }

    private UGToolEventsMixin() {
    }
}
