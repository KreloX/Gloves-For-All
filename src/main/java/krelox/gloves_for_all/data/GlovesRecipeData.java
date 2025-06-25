package krelox.gloves_for_all.data;

import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.nitrogen.data.providers.NitrogenRecipeProvider;
import com.kyanite.deeperdarker.content.DDItems;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.savage_and_ravage.core.registry.SRItems;
import dqu.additionaladditions.AdditionalRegistry;
import galena.oreganized.index.OItems;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.CompatGlovesItem;
import krelox.gloves_for_all.item.CompatModule;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.orcinus.galosphere.init.GItems;
import tamaized.voidscape.registry.ModItems;
import vazkii.botania.common.item.BotaniaItems;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static krelox.gloves_for_all.GlovesTags.Items.*;
import static krelox.gloves_for_all.item.GlovesItems.*;

public class GlovesRecipeData extends NitrogenRecipeProvider {
    public GlovesRecipeData(PackOutput output) {
        super(output, GlovesForAll.MOD_ID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Caverns & Chasms
        makeGlovesWithTag(consumer, SILVER_GLOVES, INGOTS_SILVER);
        smithingRecipe(consumer, RecipeCategory.COMBAT, NECROMIUM_GLOVES, () -> Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, AetherItems.DIAMOND_GLOVES, INGOTS_NECROMIUM, CCItems.NECROMIUM_INGOT);
        makeGloves(SANGUINE_GLOVES, CCItems.LIVING_FLESH).save(consumer);
        // Oreganized
        smithingRecipe(consumer, RecipeCategory.COMBAT, ELECTRUM_GLOVES, OItems.ELECTRUM_UPGRADE_SMITHING_TEMPLATE, AetherItems.DIAMOND_GLOVES, INGOTS_ELECTRUM, OItems.ELECTRUM_INGOT);
        // Mekanism Tools
        makeGlovesWithTag(consumer, BRONZE_GLOVES, INGOTS_BRONZE);
        makeGlovesWithTag(consumer, LAPIS_LAZULI_GLOVES, Tags.Items.GEMS_LAPIS);
        makeGlovesWithTag(consumer, OSMIUM_GLOVES, INGOTS_OSMIUM);
        makeGlovesWithTag(consumer, REFINED_GLOWSTONE_GLOVES, INGOTS_REFINED_GLOWSTONE);
        makeGlovesWithTag(consumer, REFINED_OBSIDIAN_GLOVES, INGOTS_REFINED_OBSIDIAN);
        makeGlovesWithTag(consumer, STEEL_GLOVES, INGOTS_STEEL);
        // SimpleOres
        makeGlovesWithTag(consumer, COPPER_GLOVES, Tags.Items.INGOTS_COPPER);
        makeGlovesWithTag(consumer, TIN_GLOVES, INGOTS_TIN);
        makeGlovesWithTag(consumer, MYTHRIL_GLOVES, INGOTS_MYTHRIL);
        makeGlovesWithTag(consumer, ADAMANTIUM_GLOVES, INGOTS_ADAMANTIUM);
        makeGlovesWithTag(consumer, ONYX_GLOVES, GEMS_ONYX);
        // Additional Additions
        smithingRecipe(consumer, RecipeCategory.COMBAT, ROSE_GOLD_GLOVES, AdditionalRegistry.ROSE_GOLD_UPGRADE, AetherItems.IRON_GLOVES, AdditionalRegistry.ROSE_GOLD_ALLOY);
        smithingRecipe(consumer, RecipeCategory.COMBAT, GILDED_NETHERITE_GLOVES, AdditionalRegistry.GILDED_NETHERITE_UPGRADE, AetherItems.NETHERITE_GLOVES, AdditionalRegistry.GOLD_RING);
        // Redstone Arsenal
        Item fluxPlating = ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatModule.REDSTONE_ARSENAL.getSourceModId(), "flux_plating"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FLUX_INFUSED_GLOVES.get())
                .define('X', Ingredient.of(fluxPlating))
                .define('#', Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatModule.REDSTONE_ARSENAL.getSourceModId(), "flux_obsidian_rod"))))
                .pattern("X#X")
                .unlockedBy(getHasName(fluxPlating), has(fluxPlating))
                .save(consumer, name(getItemName(FLUX_INFUSED_GLOVES.get())));
        // Galosphere
        smithingRecipe(consumer, RecipeCategory.COMBAT, STERLING_GLOVES, GItems.SILVER_UPGRADE_SMITHING_TEMPLATE, AetherItems.LEATHER_GLOVES, INGOTS_SILVER, GItems.SILVER_INGOT);
        // Undergarden
        makeGlovesWithTag(consumer, CLOGGRUM_GLOVES, INGOTS_CLOGGRUM);
        makeGlovesWithTag(consumer, FROSTSTEEL_GLOVES, INGOTS_FROSTSTEEL);
        makeGlovesWithTag(consumer, UTHERIUM_GLOVES, INGOTS_UTHERIUM);
        // Blue Skies
        makeGlovesWithTag(consumer, PYROPE_GLOVES, GEMS_PYROPE);
        makeGlovesWithTag(consumer, AQUITE_GLOVES, GEMS_AQUITE);
        makeGlovesWithTag(consumer, HORIZONITE_GLOVES, INGOTS_HORIZONITE);
        makeGlovesWithTag(consumer, DIOPSIDE_GLOVES, GEMS_DIOPSIDE);
        makeGlovesWithTag(consumer, CHAROITE_GLOVES, GEMS_CHAROITE);
        // Voidscape
        smithingRecipe(consumer, RecipeCategory.COMBAT, VOIDIC_CRYSTAL_GLOVES, ModItems.VOIDIC_TEMPLATE, AetherItems.NETHERITE_GLOVES, GEMS_VOIDIC_CRYSTAL, ModItems.VOIDIC_CRYSTAL);
        smithingRecipe(consumer, RecipeCategory.COMBAT, CORRUPT_GLOVES, ModItems.VOIDIC_TEMPLATE, VOIDIC_CRYSTAL_GLOVES, ModItems.TENDRIL);
        smithingRecipe(consumer, RecipeCategory.COMBAT, TITANITE_GLOVES, ModItems.VOIDIC_TEMPLATE, CORRUPT_GLOVES, GEMS_TITANITE, ModItems.TITANITE_SHARD);
        smithingRecipe(consumer, RecipeCategory.COMBAT, ICHOR_GLOVES, ModItems.VOIDIC_TEMPLATE, TITANITE_GLOVES, GEMS_ICHOR, ModItems.ICHOR);
        smithingRecipe(consumer, RecipeCategory.COMBAT, ASTRAL_GLOVES, ModItems.VOIDIC_TEMPLATE, ICHOR_GLOVES, GEMS_ASTRAL, ModItems.ASTRAL_CRYSTAL);
        // Deeper and Darker
        smithingRecipe(consumer, RecipeCategory.COMBAT, RESONARIUM_GLOVES, () -> Items.AIR, AetherItems.IRON_GLOVES, DDItems.RESONARIUM_PLATE);
        smithingRecipe(consumer, RecipeCategory.COMBAT, WARDEN_GLOVES, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, AetherItems.NETHERITE_GLOVES, DDItems.REINFORCED_ECHO_SHARD);
        // Botania
        makeGlovesWithTag(consumer, MANASTEEL_GLOVES, INGOTS_MANASTEEL);
        makeGlovesWithTag(consumer, ELEMENTIUM_GLOVES, INGOTS_ELEMENTIUM);
        makeGloves(MANAWEAVE_GLOVES, () -> BotaniaItems.manaweaveCloth).save(consumer);
        makeGlovesWithTag(consumer, TERRASTEEL_GLOVES, INGOTS_TERRASTEEL);
        // Savage & Ravage
        makeGloves(GRIEFER_GLOVES, SRItems.BLAST_PROOF_PLATING).save(consumer);
    }

    public void makeGlovesWithTag(Consumer<FinishedRecipe> consumer, Supplier<Item> gloves, TagKey<Item> tag) {
        makeGlovesWithTag(gloves, tag, ((CompatGlovesItem) gloves.get()).getCompatMaterial().getName()).save(consumer);
    }

    public void smithingRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, Supplier<Item> result, Supplier<Item> templateItem,
                               Supplier<Item> input, TagKey<Item> upgradeTag, Supplier<Item> upgradeItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(templateItem.get()),
                        Ingredient.of(input.get()),
                        Ingredient.of(upgradeTag),
                        category, result.get())
                .unlocks(getHasName(upgradeItem.get()), has(upgradeTag))
                .save(consumer, name(getItemName(result.get()) + "_smithing"));
    }

    public void smithingRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, Supplier<Item> result, Supplier<Item> templateItem,
                               Supplier<Item> input, Supplier<Item> upgradeItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(templateItem.get()),
                        Ingredient.of(input.get()),
                        Ingredient.of(upgradeItem.get()),
                        category, result.get())
                .unlocks(getHasName(upgradeItem.get()), has(upgradeItem.get()))
                .save(consumer, name(getItemName(result.get()) + "_smithing"));
    }
}
