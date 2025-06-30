package krelox.gloves_for_all.data.conditions;

import com.google.gson.JsonObject;
import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.stream.Collectors;

public class ItemExistsCondition implements ICondition {
    private static final ResourceLocation NAME = GlovesForAll.modLoc("item_exists");
    private static final Lazy<Set<String>> ALL_ITEMS = Lazy.of(() ->
            ForgeRegistries.ITEMS.getKeys().stream()
                    .map(ResourceLocation::getPath)
                    .collect(Collectors.toSet()));
    private final String itemName;

    public ItemExistsCondition(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test(IContext iContext) {
        return ALL_ITEMS.get().contains(itemName);
    }

    public static class Serializer implements IConditionSerializer<ItemExistsCondition> {
        private static final String ITEM = "item";

        @Override
        public void write(JsonObject json, ItemExistsCondition value) {
            json.addProperty(ITEM, value.itemName);
        }

        @Override
        public ItemExistsCondition read(JsonObject json) {
            return new ItemExistsCondition(GsonHelper.getAsString(json, ITEM));
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}
