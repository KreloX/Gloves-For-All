package krelox.gloves_for_all.mixin.common.galosphere;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resources.ResourceLocation;
import net.orcinus.galosphere.items.PreservedSmithingTemplateItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PreservedSmithingTemplateItem.class)
public class PreservedSmithingTemplateItemMixin {
    @WrapOperation(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/resources/ResourceLocation;withDefaultNamespace(Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;",
                    remap = false
            )
    )
    private static ResourceLocation aether_gloves_for_all$fixClinit(String path, Operation<ResourceLocation> original) {
        return new ResourceLocation(path);
    }

    private PreservedSmithingTemplateItemMixin() {
    }
}
