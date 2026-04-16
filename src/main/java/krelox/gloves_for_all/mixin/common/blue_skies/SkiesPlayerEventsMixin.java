package krelox.gloves_for_all.mixin.common.blue_skies;

import com.aetherteam.aether.item.EquipmentUtil;
import com.legacy.blue_skies.data.objects.tags.SkiesItemTags;
import com.legacy.blue_skies.events.SkiesPlayerEvents;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkiesPlayerEvents.class)
public class SkiesPlayerEventsMixin {
    @Inject(
            method = "attackEntity",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/event/entity/player/AttackEntityEvent;getTarget()Lnet/minecraft/world/entity/Entity;"
            ),
            remap = false
    )
    private static void aether_gloves_for_all$attackEntity(AttackEntityEvent event, CallbackInfo ci) {
        var player = event.getEntity();
        if (EquipmentUtil.hasCurio(player, GlovesItems.HORIZONITE_GLOVES.get())) {
            int seconds = 2;
            if (player.getMainHandItem().is(SkiesItemTags.HORIZONITE_TOOLS)) {
                seconds += 3;
            }
            event.getTarget().setSecondsOnFire(seconds);
        }
    }

    private SkiesPlayerEventsMixin() {
    }
}
