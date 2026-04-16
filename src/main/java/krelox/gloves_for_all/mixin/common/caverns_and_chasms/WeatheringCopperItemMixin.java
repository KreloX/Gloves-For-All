package krelox.gloves_for_all.mixin.common.caverns_and_chasms;

import com.google.common.collect.ImmutableBiMap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.teamabnormals.caverns_and_chasms.common.item.copper.WeatheringCopperItem;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WeatheringCopperItem.class)
public interface WeatheringCopperItemMixin {
    @ModifyExpressionValue(
            method = "lambda$static$0",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/ImmutableBiMap;builder()Lcom/google/common/collect/ImmutableBiMap$Builder;"
            ),
            remap = false
    )
    private static ImmutableBiMap.Builder<Item, Item> aether_gloves_for_all$injectNextByItem(ImmutableBiMap.Builder<Item, Item> original) {
        return original
                .put(GlovesItems.COPPER_GLOVES.get(), GlovesItems.EXPOSED_COPPER_GLOVES.get())
                .put(GlovesItems.EXPOSED_COPPER_GLOVES.get(), GlovesItems.WEATHERED_COPPER_GLOVES.get())
                .put(GlovesItems.WEATHERED_COPPER_GLOVES.get(), GlovesItems.OXIDIZED_COPPER_GLOVES.get());
    }

    @ModifyExpressionValue(
            method = "lambda$static$2",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/ImmutableBiMap;builder()Lcom/google/common/collect/ImmutableBiMap$Builder;"
            ),
            remap = false
    )
    private static ImmutableBiMap.Builder<Item, Item> aether_gloves_for_all$injectWaxables(ImmutableBiMap.Builder<Item, Item> original) {
        return original
                .put(GlovesItems.COPPER_GLOVES.get(), GlovesItems.WAXED_COPPER_GLOVES.get())
                .put(GlovesItems.EXPOSED_COPPER_GLOVES.get(), GlovesItems.WAXED_EXPOSED_COPPER_GLOVES.get())
                .put(GlovesItems.WEATHERED_COPPER_GLOVES.get(), GlovesItems.WAXED_WEATHERED_COPPER_GLOVES.get())
                .put(GlovesItems.OXIDIZED_COPPER_GLOVES.get(), GlovesItems.WAXED_OXIDIZED_COPPER_GLOVES.get());
    }
}
