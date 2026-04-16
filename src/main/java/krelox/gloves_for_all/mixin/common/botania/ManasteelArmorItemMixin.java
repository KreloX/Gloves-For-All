package krelox.gloves_for_all.mixin.common.botania;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.item.EquipmentUtil;
import com.google.common.base.Suppliers;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.item.equipment.armor.manasteel.ManasteelArmorItem;
import vazkii.botania.common.proxy.Proxy;

import java.util.List;
import java.util.function.Supplier;

@Mixin(ManasteelArmorItem.class)
public class ManasteelArmorItemMixin extends ArmorItem {
    @Unique
    private final Supplier<Item> aether_gloves_for_all$gloves = Suppliers.memoize(() ->
            ForgeRegistries.ITEMS.getValue(GlovesForAll.modLoc(getMaterial().getName() + "_gloves")));

    @Inject(
            method = "addInformationAfterShift",
            at = @At(
                    value = "INVOKE",
                    target = "Lvazkii/botania/common/item/equipment/armor/manasteel/ManasteelArmorItem;hasPhantomInk(Lnet/minecraft/world/item/ItemStack;)Z"
            ),
            remap = false
    )
    private void aether_gloves_for_all$injectGlovesToTooltip(ItemStack stack, Level world, List<Component> list, TooltipFlag flags, CallbackInfo ci) {
        if (AetherConfig.SERVER.require_gloves.get() && aether_gloves_for_all$gloves.get() != Items.AIR) {
            var cmp = Component.literal(" - ").append(new ItemStack(aether_gloves_for_all$gloves.get()).getHoverName());
            cmp.withStyle(EquipmentUtil.hasCurio(Proxy.INSTANCE.getClientPlayer(), aether_gloves_for_all$gloves.get()) ? ChatFormatting.GREEN : ChatFormatting.GRAY);
            list.add(cmp);
        }
    }

    @ModifyReturnValue(method = "hasArmorSet", at = @At("RETURN"), remap = false)
    private boolean aether_gloves_for_all$hasGloves(boolean hasArmorSet, @Local(argsOnly = true) Player player) {
        if (AetherConfig.SERVER.require_gloves.get() && aether_gloves_for_all$gloves.get() != Items.AIR) {
            return hasArmorSet && EquipmentUtil.hasCurio(player, aether_gloves_for_all$gloves.get());
        }
        return hasArmorSet;
    }

    @ModifyReturnValue(method = "getSetPiecesEquipped", at = @At("RETURN"), remap = false)
    private int aether_gloves_for_all$modifySetPiecesEquipped(int pieces, @Local(argsOnly = true) Player player) {
        if (AetherConfig.SERVER.require_gloves.get() && aether_gloves_for_all$gloves.get() != Items.AIR && EquipmentUtil.hasCurio(player, aether_gloves_for_all$gloves.get())) {
            return pieces + 1;
        }
        return pieces;
    }

    @Definition(id = "getArmorSetStacks", method = "Lvazkii/botania/common/item/equipment/armor/manasteel/ManasteelArmorItem;getArmorSetStacks()[Lnet/minecraft/world/item/ItemStack;")
    @Expression("this.getArmorSetStacks().length")
    @ModifyExpressionValue(method = "getArmorSetTitle", at = @At("MIXINEXTRAS:EXPRESSION"), remap = false)
    private int aether_gloves_for_all$modifyArmorSetLength(int length) {
        if (AetherConfig.SERVER.require_gloves.get() && aether_gloves_for_all$gloves.get() != Items.AIR) {
            return length + 1;
        }
        return length;
    }

    ManasteelArmorItemMixin(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
}
