package krelox.gloves_for_all.item;

import cofh.thermal.lib.util.ThermalFlags;
import com.aetherteam.aether.item.AetherItems;
import dqu.additionaladditions.AdditionalRegistry;
import krelox.gloves_for_all.CompatModule;
import krelox.gloves_for_all.item.gloves.CompatGlovesItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiConsumer;

public class GlovesCreativeTabs {
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

            if (module.isLoaded() && module.getCreativeTabs().contains(tabKey.location())) {
                String materialPrefix = switch (material) {
                    case FLUX_INFUSED -> "flux";
                    case IAF_SILVER -> "armor_silver_metal";
                    case IAF_COPPER -> "armor_copper_metal";
                    case SHEEP_DISGUISE -> "sheep";
                    case FIRE_DRAGONSTEEL -> "dragonsteel_fire";
                    case ICE_DRAGONSTEEL -> "dragonsteel_ice";
                    case LIGHTNING_DRAGONSTEEL -> "dragonsteel_lightning";
                    case TIDE_GUARDIAN -> "tide_" + ForgeRegistries.ITEMS.getKey(gloves).getPath()
                            .replace(module.getSourceModId() + "/", "")
                            .replace("_" + CompatMaterial.TIDE_GUARDIAN.getName() + "_gloves", "");
                    default -> ForgeRegistries.ITEMS.getKey(gloves).getPath()
                            .replace(module.getSourceModId() + "/", "")
                            .replace("_gloves", "");
                };
                var boots = ForgeRegistries.ITEMS.getValue(new ResourceLocation(module.getSourceModId(), materialPrefix + "_boots"));
                if (entries.contains(boots.getDefaultInstance())) {
                    after.accept(boots, gloves);
                }
            }
        }
    }

    public static boolean shouldHide(ItemStack stack) {
        if (stack.getItem() instanceof CompatGlovesItem gloves && gloves.getCompatMaterial().getCompatModule().isLoaded()) {
            return switch (gloves.getCompatMaterial()) {
                case BEEKEEPER -> !ThermalFlags.getFlag(ThermalFlags.FLAG_BEEKEEPER_ARMOR).get();
                case DIVING -> !ThermalFlags.getFlag(ThermalFlags.FLAG_DIVING_ARMOR).get();
                case HAZMAT -> !ThermalFlags.getFlag(ThermalFlags.FLAG_HAZMAT_ARMOR).get();
                default -> false;
            };
        }
        return false;
    }

    private GlovesCreativeTabs() {
    }
}
