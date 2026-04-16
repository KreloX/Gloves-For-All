package krelox.gloves_for_all.mixin.common.galosphere;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.orcinus.galosphere.init.GRegistries;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GRegistries.class)
public class GRegistriesMixin {
    @WrapMethod(method = "createRegistryKey", remap = false)
    private static <T> ResourceKey<Registry<T>> aether_gloves_for_all$fixCreateRegistryKey(String string, Operation<ResourceKey<Registry<T>>> original) {
        return ResourceKey.createRegistryKey(new ResourceLocation(string));
    }

    private GRegistriesMixin() {
    }
}
