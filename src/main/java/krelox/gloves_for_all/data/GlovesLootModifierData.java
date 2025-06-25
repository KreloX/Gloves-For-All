package krelox.gloves_for_all.data;

import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.CompatGlovesItem;
import krelox.gloves_for_all.loot.CompatGlovesLootModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import static krelox.gloves_for_all.item.GlovesItems.*;

public class GlovesLootModifierData extends GlobalLootModifierProvider {
    public GlovesLootModifierData(PackOutput output) {
        super(output, GlovesForAll.MOD_ID);
    }

    @Override
    protected void start() {
        Item[] lootGloves = {
                COPPER_GLOVES.get(),
                TIN_GLOVES.get(),
                ONYX_GLOVES.get(),
                PYROPE_GLOVES.get(),
                AQUITE_GLOVES.get(),
        };
        for (var item : lootGloves) {
            var gloves = (CompatGlovesItem) item;
            var compatMaterial = gloves.getCompatMaterial();
            add("gloves_loot_" + compatMaterial.getName(), new CompatGlovesLootModifier(new LootItemCondition[]{}, new ItemStack(gloves), compatMaterial));
        }
    }
}
