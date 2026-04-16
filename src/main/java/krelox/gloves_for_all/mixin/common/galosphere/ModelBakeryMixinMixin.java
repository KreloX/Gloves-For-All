package krelox.gloves_for_all.mixin.common.galosphere;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ModelBakery.class, priority = 1500)
public class ModelBakeryMixinMixin {
    @TargetHandler(mixin = "net.orcinus.galosphere.mixin.client.ModelBakeryMixin", name = "G$loadBlockModel")
    @WrapOperation(
            method = "@MixinSquared:Handler",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/resources/ResourceLocation;withDefaultNamespace(Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;",
                    remap = false
            )
    )
    private static ResourceLocation aether_gloves_for_all$fixLoadBlockModel(String path, Operation<ResourceLocation> original) {
        return new ResourceLocation(path);
    }

    private ModelBakeryMixinMixin() {
    }
}
