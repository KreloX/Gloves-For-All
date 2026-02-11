package krelox.gloves_for_all.item;

import cofh.core.common.config.CoreClientConfig;
import cofh.core.util.ProxyUtils;
import cofh.lib.util.helpers.StringHelper;
import cofh.redstonearsenal.common.capability.FluxShieldedEnergyItemWrapper;
import cofh.redstonearsenal.common.item.IFluxItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class FluxGlovesItem extends CompatGlovesItem implements IFluxItem {
    protected int maxEnergy;
    protected int extract;
    protected int receive;

    public FluxGlovesItem(CompatArmorMaterial material, double punchDamage, int maxEnergy, int maxTransfer, Properties properties) {
        super(material, punchDamage, properties);
        this.maxEnergy = maxEnergy;
        this.extract = maxTransfer;
        this.receive = maxTransfer;
        ProxyUtils.registerItemModelProperty(this, new ResourceLocation("charged"), this::getChargedModelProperty);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (Screen.hasShiftDown() || CoreClientConfig.alwaysShowDetails.get()) {
            tooltipDelegate(stack, worldIn, tooltip, flagIn);
        } else if (CoreClientConfig.holdShiftForDetails.get()) {
            tooltip.add(StringHelper.getTextComponent("info.cofh.hold_shift_for_details").withStyle(ChatFormatting.GRAY));
        }

    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getEnchantmentValue(stack) > 0;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new FluxShieldedEnergyItemWrapper(stack, getEnergyPerUse(true));
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        // do nothing
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        return hasEnergy(stack, false) ? super.getAttributeModifiers(slotContext, uuid, stack) : ImmutableMultimap.of();
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        useEnergy(stack, Math.min(getEnergyStored(stack), amount * getEnergyPerUse(false)), entity);
        return 0;
    }

    @Override
    public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    public FluxGlovesItem setModId(String modId) {
        return this;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return IFluxItem.super.isBarVisible(stack);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return IFluxItem.super.getBarColor(stack);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return IFluxItem.super.getBarWidth(stack);
    }

    @Override
    public int getExtract(ItemStack container) {
        return extract;
    }

    @Override
    public int getReceive(ItemStack container) {
        return receive;
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return getMaxStored(container, maxEnergy);
    }
}
