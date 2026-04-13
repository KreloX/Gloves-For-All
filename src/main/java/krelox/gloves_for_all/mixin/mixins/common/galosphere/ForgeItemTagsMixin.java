package krelox.gloves_for_all.mixin.mixins.common.galosphere;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resources.ResourceLocation;
import net.orcinus.galosphere.compat.init.ForgeItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ForgeItemTags.class)
public class ForgeItemTagsMixin {
    @WrapOperation(
            method = "bind",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/resources/ResourceLocation;fromNamespaceAndPath(Ljava/lang/String;Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;"
            ),
            remap = false
    )
    private static ResourceLocation aether_gloves_for_all$fixBind(String namespace, String path, Operation<ResourceLocation> original) {
        return new ResourceLocation(namespace, path);
    }

    private ForgeItemTagsMixin() {
    }
}
