package krelox.gloves_for_all.mixin;

import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;
import vazkii.botania.common.item.equipment.armor.manasteel.ManasteelArmorItem;
import vazkii.botania.common.proxy.Proxy;

import java.util.List;

@Mixin(ManasteelArmorItem.class)
public class ManasteelArmorItemMixin extends ArmorItem {
    @Unique
    protected final Lazy<Item> gloves_for_all$gloves = Lazy.of(() -> ForgeRegistries.ITEMS.getValue(GlovesForAll.modLoc(getMaterial().getName() + "_gloves")));

    public ManasteelArmorItemMixin(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Inject(
            method = "addInformationAfterShift",
            at = @At(
                    value = "INVOKE",
                    target = "Lvazkii/botania/common/item/equipment/armor/manasteel/ManasteelArmorItem;hasPhantomInk(Lnet/minecraft/world/item/ItemStack;)Z"
            ),
            remap = false
    )
    private void gloves_for_all$injectGlovesToTooltip(ItemStack stack, Level world, List<Component> list, TooltipFlag flags, CallbackInfo ci) {
        if (gloves_for_all$gloves.get() == Items.AIR) return;
        var cmp = Component.literal(" - ").append(new ItemStack(gloves_for_all$gloves.get()).getHoverName());
        CuriosApi.getCuriosInventory(Proxy.INSTANCE.getClientPlayer()).ifPresent(inventory ->
                cmp.withStyle(inventory.findFirstCurio(gloves_for_all$gloves.get()).isPresent() ? ChatFormatting.GREEN : ChatFormatting.GRAY));
        list.add(cmp);
    }

    @Inject(method = "hasArmorSet", at = @At("RETURN"), cancellable = true, remap = false)
    private void gloves_for_all$hasArmorSetWithGloves(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (gloves_for_all$gloves.get() == Items.AIR) return;
        CuriosApi.getCuriosInventory(player).ifPresent(inventory ->
                cir.setReturnValue(cir.getReturnValueZ() && inventory.findFirstCurio(gloves_for_all$gloves.get()).isPresent()));
    }

    @Inject(method = "getSetPiecesEquipped", at = @At("RETURN"), cancellable = true, remap = false)
    private void gloves_for_all$injectSetPiecesEquipped(Player player, CallbackInfoReturnable<Integer> cir) {
        if (gloves_for_all$gloves.get() == Items.AIR) return;
        CuriosApi.getCuriosInventory(player)
                .ifPresent(inventory -> inventory.findFirstCurio(gloves_for_all$gloves.get())
                        .ifPresent(stack -> cir.setReturnValue(cir.getReturnValue() + 1)));
    }

    @Redirect(
            method = "getArmorSetTitle",
            at = @At(
                    value = "INVOKE",
                    target = "Lvazkii/botania/common/item/equipment/armor/manasteel/ManasteelArmorItem;getArmorSetStacks()[Lnet/minecraft/world/item/ItemStack;",
                    remap = false
            ),
            remap = false
    )
    private ItemStack[] gloves_for_all$extendArmorSet(ManasteelArmorItem armorItem) {
        return gloves_for_all$gloves.get().equals(Items.AIR) ? armorItem.getArmorSetStacks() : new ItemStack[armorItem.getArmorSetStacks().length + 1];
    }
}
