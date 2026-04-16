package krelox.gloves_for_all.data;

import cofh.redstonearsenal.common.item.IFluxItem;
import com.aetherteam.aether.Aether;
import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import com.aetherteam.nitrogen.data.providers.NitrogenItemModelProvider;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.CompatGlovesItem;
import krelox.gloves_for_all.item.GlovesItems;
import krelox.gloves_for_all.item.VoidscapeGlovesItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GlovesItemModelData extends AetherItemModelProvider {
    public GlovesItemModelData(PackOutput output, ExistingFileHelper helper) {
        super(output, GlovesForAll.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        for (var item : GlovesItems.ITEMS.getEntries()) {
            compatGlovesItem((CompatGlovesItem) item.get());
        }
    }

    public void compatGlovesItem(CompatGlovesItem gloves) {
        String name = "item/" + itemName(gloves);
        var location = modLoc(name.replace("waxed_", ""));
        var builder = withExistingParent(name, mcLoc("item/generated")).texture("layer0", location);
        double index = 0.1;
        if (gloves.getCompatMaterial().isTrimmable()) {
            for (var trimMaterial : NitrogenItemModelProvider.VANILLA_TRIM_MATERIALS) {
                String material = trimMaterial.location().getPath();
                var trimmedModel = withExistingParent(name + "_" + material + "_trim", mcLoc("item/generated"))
                        .texture("layer0", location)
                        .texture("layer1", new ResourceLocation(Aether.MODID, "trims/items/gloves_trim_" + material));
                builder.override().predicate(mcLoc("trim_type"), (float) index).model(trimmedModel).end();
                index += 0.1;
            }
        } else if (gloves instanceof VoidscapeGlovesItem) {
            var brokenModel = withExistingParent(name + "_broken", mcLoc("item/generated"))
                    .texture("layer0", location.withSuffix("_broken"))
                    .customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0).end();
            builder.override().predicate(mcLoc("broken"), 1).model(brokenModel).end()
                    .customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0).end();
        } else if (gloves instanceof IFluxItem) {
            var chargedModel = withExistingParent(name + "_charged", mcLoc("item/generated"))
                    .texture("layer0", location.withSuffix("_charged"));
            builder.override().predicate(mcLoc("charged"), 1).model(chargedModel).end();
        }
    }
}
