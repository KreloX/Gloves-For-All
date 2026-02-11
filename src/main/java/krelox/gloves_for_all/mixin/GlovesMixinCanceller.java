package krelox.gloves_for_all.mixin;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class GlovesMixinCanceller implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        return mixinClassName.equals("com.crypticmushroom.minecraft.registry.coremod.mixin.data.minecraft.VanillaRecipeBuilderMixin");
    }
}
