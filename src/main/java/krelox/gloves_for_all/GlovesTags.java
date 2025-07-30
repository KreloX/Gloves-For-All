package krelox.gloves_for_all;

import krelox.gloves_for_all.item.CompatModule;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static krelox.gloves_for_all.item.CompatModule.*;

public class GlovesTags {
    public static class Items {
        private Items() {

        }

        // Caverns & Chasms
        public static final TagKey<Item> INGOTS_NECROMIUM = forgeTag("ingots/necromium");
        public static final TagKey<Item> INGOTS_SILVER = forgeTag("ingots/silver");
        // Oreganized
        public static final TagKey<Item> INGOTS_ELECTRUM = forgeTag("ingots/electrum");
        // Mekanism Tools
        public static final TagKey<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
        public static final TagKey<Item> INGOTS_OSMIUM = forgeTag("ingots/osmium");
        public static final TagKey<Item> INGOTS_REFINED_GLOWSTONE = forgeTag("ingots/refined_glowstone");
        public static final TagKey<Item> INGOTS_REFINED_OBSIDIAN = forgeTag("ingots/refined_obsidian");
        public static final TagKey<Item> INGOTS_STEEL = forgeTag("ingots/steel");
        // SimpleOres
        public static final TagKey<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final TagKey<Item> INGOTS_MYTHRIL = forgeTag("ingots/mythril");
        public static final TagKey<Item> INGOTS_ADAMANTIUM = forgeTag("ingots/adamantium");
        public static final TagKey<Item> GEMS_ONYX = forgeTag("gems/onyx");
        // Undergarden
        public static final TagKey<Item> INGOTS_CLOGGRUM = forgeTag("ingots/cloggrum");
        public static final TagKey<Item> INGOTS_FROSTSTEEL = forgeTag("ingots/froststeel");
        public static final TagKey<Item> INGOTS_UTHERIUM = forgeTag("ingots/utherium");
        // Blue Skies
        public static final TagKey<Item> GEMS_PYROPE = moduleTag(BLUE_SKIES, "gems/pyrope");
        public static final TagKey<Item> GEMS_AQUITE = moduleTag(BLUE_SKIES, "gems/aquite");
        public static final TagKey<Item> GEMS_DIOPSIDE = moduleTag(BLUE_SKIES, "gems/diopside");
        public static final TagKey<Item> GEMS_CHAROITE = moduleTag(BLUE_SKIES, "gems/charoite");
        public static final TagKey<Item> INGOTS_HORIZONITE = moduleTag(BLUE_SKIES, "ingots/horizonite");
        // Botania
        public static final TagKey<Item> INGOTS_MANASTEEL = forgeTag("ingots/manasteel");
        public static final TagKey<Item> INGOTS_ELEMENTIUM = forgeTag("ingots/elementium");
        public static final TagKey<Item> INGOTS_TERRASTEEL = forgeTag("ingots/terrasteel");

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        private static TagKey<Item> moduleTag(CompatModule module, String name) {
            return ItemTags.create(new ResourceLocation(module.getSourceModId(), name));
        }
    }

    private GlovesTags() {
    }
}
