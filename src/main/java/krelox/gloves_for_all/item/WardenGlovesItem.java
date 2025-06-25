package krelox.gloves_for_all.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.CuriosApi;

public class WardenGlovesItem extends CompatGlovesItem {
    public WardenGlovesItem(CompatArmorMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof ServerPlayer player) {
            CuriosApi.getCuriosInventory(player).ifPresent(inventory ->
                    inventory.findFirstCurio(this).ifPresent(curio -> {
                        if (player.hasEffect(MobEffects.BLINDNESS)) {
                            player.removeEffect(MobEffects.BLINDNESS);
                        }
                        if (player.hasEffect(MobEffects.DARKNESS)) {
                            player.removeEffect(MobEffects.DARKNESS);
                        }
                    })
            );
        }
    }
}
