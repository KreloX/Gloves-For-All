package krelox.gloves_for_all.data.conditions;

import com.google.common.base.Suppliers;
import com.google.gson.JsonObject;
import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GenericItemExistsCondition implements ICondition {
    private static final ResourceLocation NAME = GlovesForAll.modLoc("item_exists");
    public static final Supplier<Set<String>> ALL_ITEMS = Suppliers.memoize(() ->
            ForgeRegistries.ITEMS.getKeys().stream()
                    .map(ResourceLocation::getPath)
                    .collect(Collectors.toSet()));
    private final String itemName;

    public GenericItemExistsCondition(String itemName) {
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

    public static class Serializer implements IConditionSerializer<GenericItemExistsCondition> {
        private static final String ITEM = "item";

        @Override
        public void write(JsonObject json, GenericItemExistsCondition value) {
            json.addProperty(ITEM, value.itemName);
        }

        @Override
        public GenericItemExistsCondition read(JsonObject json) {
            return new GenericItemExistsCondition(GsonHelper.getAsString(json, ITEM));
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}
