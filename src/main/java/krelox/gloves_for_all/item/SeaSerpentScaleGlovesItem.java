package krelox.gloves_for_all.item;

import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.Locale;

public class SeaSerpentScaleGlovesItem extends CompatGlovesItem {
    private final String color;

    public SeaSerpentScaleGlovesItem(CompatArmorMaterial material, double punchDamage, String color, Properties properties) {
        super(material, punchDamage, properties);
        this.color = color;
        setRenderTexture(GlovesForAll.MOD_ID, material.getCompatModule().getSourceModId() + "/" + color + "_tide_guardian_gloves");
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        slotContext.entity().addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 50, 0, false, false));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        if (CompatModule.ICE_AND_FIRE.isLoaded()) {
            tooltipComponents.add(Component.translatable("sea_serpent." + color).withStyle(EnumSeaSerpent.valueOf(color.toUpperCase(Locale.ROOT)).color));
            tooltipComponents.add(Component.translatable("item.iceandfire.sea_serpent_armor.desc_0").withStyle(ChatFormatting.GRAY));
        }
    }
}
