package krelox.gloves_for_all.mixin;

import com.bawnorton.mixinsquared.adjuster.tools.AdjustableAnnotationNode;
import com.bawnorton.mixinsquared.adjuster.tools.AdjustableWrapOperationNode;
import com.bawnorton.mixinsquared.api.MixinAnnotationAdjuster;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class GlovesMixinAnnotationAdjuster implements MixinAnnotationAdjuster {
    @Override
    public @Nullable AdjustableAnnotationNode adjust(List<String> targetClassNames, String mixinClassName, MethodNode handler, AdjustableAnnotationNode annotation) {
        if (!FMLEnvironment.production && mixinClassName.equals("com.teamabnormals.caverns_and_chasms.core.mixin.client.ClientLevelMixin")
                && annotation.is(WrapOperation.class)) {
            var wrapOpNode = annotation.as(AdjustableWrapOperationNode.class);
            if (wrapOpNode.getMethod().get(0).equals("*(Lnet/minecraft/world/entity/Entity;)V")) {
                return wrapOpNode.withMethod(strings -> List.of("lambda$tickEntities$4"));
            }
        }
        return annotation;
    }
}
