package krelox.gloves_for_all.mixin.common.galosphere;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.resources.ResourceLocation;
import net.orcinus.galosphere.Galosphere;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Galosphere.class)
public class GalosphereMixin {
    @WrapMethod(method = "id", remap = false)
    private static ResourceLocation aether_gloves_for_all$fixId(String path, Operation<ResourceLocation> original) {
        return new ResourceLocation(Galosphere.MODID, path);
    }

    private GalosphereMixin() {
    }
}
