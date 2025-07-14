package krelox.gloves_for_all.item;

import com.aetherteam.aether.item.AetherItems;
import dqu.additionaladditions.AdditionalRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiConsumer;

public class GlovesCreativeTabs {
    private GlovesCreativeTabs() {
    }

    public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        var tabKey = event.getTabKey();
        var entries = event.getEntries();
        BiConsumer<Item, Item> after = (item, toPut) -> entries.putAfter(item.getDefaultInstance(),
                toPut.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        if (tabKey == CreativeModeTabs.COMBAT) {
            if (CompatModule.ADDITIONAL_ADDITIONS.isLoaded()) {
                entries.remove(AdditionalRegistry.ROSE_GOLD_BOOTS.get().getDefaultInstance());
                entries.remove(AdditionalRegistry.ROSE_GOLD_LEGGINGS.get().getDefaultInstance());
                entries.remove(AdditionalRegistry.ROSE_GOLD_CHESTPLATE.get().getDefaultInstance());
                entries.remove(AdditionalRegistry.ROSE_GOLD_HELMET.get().getDefaultInstance());
                after.accept(Items.GOLDEN_BOOTS, AdditionalRegistry.ROSE_GOLD_BOOTS.get());
                after.accept(Items.GOLDEN_BOOTS, AdditionalRegistry.ROSE_GOLD_LEGGINGS.get());
                after.accept(Items.GOLDEN_BOOTS, AdditionalRegistry.ROSE_GOLD_CHESTPLATE.get());
                after.accept(Items.GOLDEN_BOOTS, AdditionalRegistry.ROSE_GOLD_HELMET.get());
                entries.remove(AdditionalRegistry.GILDED_NETHERITE_BOOTS.get().getDefaultInstance());
                entries.remove(AdditionalRegistry.GILDED_NETHERITE_LEGGINGS.get().getDefaultInstance());
                entries.remove(AdditionalRegistry.GILDED_NETHERITE_CHESTPLATE.get().getDefaultInstance());
                entries.remove(AdditionalRegistry.GILDED_NETHERITE_HELMET.get().getDefaultInstance());
                after.accept(Items.NETHERITE_BOOTS, AdditionalRegistry.GILDED_NETHERITE_BOOTS.get());
                after.accept(Items.NETHERITE_BOOTS, AdditionalRegistry.GILDED_NETHERITE_LEGGINGS.get());
                after.accept(Items.NETHERITE_BOOTS, AdditionalRegistry.GILDED_NETHERITE_CHESTPLATE.get());
                after.accept(Items.NETHERITE_BOOTS, AdditionalRegistry.GILDED_NETHERITE_HELMET.get());
            }
            entries.remove(AetherItems.CHAINMAIL_GLOVES.get().getDefaultInstance());
            after.accept(Items.CHAINMAIL_BOOTS, AetherItems.CHAINMAIL_GLOVES.get());
            entries.remove(AetherItems.IRON_GLOVES.get().getDefaultInstance());
            after.accept(Items.IRON_BOOTS, AetherItems.IRON_GLOVES.get());
            entries.remove(AetherItems.GOLDEN_GLOVES.get().getDefaultInstance());
            after.accept(Items.GOLDEN_BOOTS, AetherItems.GOLDEN_GLOVES.get());
            entries.remove(AetherItems.NETHERITE_GLOVES.get().getDefaultInstance());
            after.accept(Items.NETHERITE_BOOTS, AetherItems.NETHERITE_GLOVES.get());
        }
        for (var item : GlovesItems.ITEMS.getEntries()) {
            var gloves = (CompatGlovesItem) item.get();
            var material = gloves.getCompatMaterial();
            var module = material.getCompatModule();
            if (!module.getCreativeTabs().contains(tabKey.location())) continue;
            String bootsPath = material.getName() + "_boots";
            if (module == CompatModule.ICE_AND_FIRE) {
                bootsPath = switch (material) {
                    case SILVER -> "armor_silver_metal";
                    case COPPER -> "armor_copper_metal";
                    case SHEEP_DISGUISE -> "sheep";
                    case FIRE_DRAGONSTEEL -> "dragonsteel_fire";
                    case ICE_DRAGONSTEEL -> "dragonsteel_ice";
                    case LIGHTNING_DRAGONSTEEL -> "dragonsteel_lightning";
                    case SEA_SERPENT_SCALE -> "tide_" + ForgeRegistries.ITEMS.getKey(gloves).getPath().split("_")[0];
                    default -> material.getName();
                } + "_boots";
            }
            var boots = ForgeRegistries.ITEMS.getValue(new ResourceLocation(module.getSourceModId(), bootsPath));
            if (entries.contains(boots.getDefaultInstance())) after.accept(boots, gloves);
        }
    }
}
