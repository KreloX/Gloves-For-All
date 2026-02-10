package krelox.gloves_for_all.data;

import cofh.lib.util.flags.FlagRecipeCondition;
import cofh.redstonearsenal.RedstoneArsenal;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.lib.util.ThermalFlags;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.nitrogen.data.providers.NitrogenRecipeProvider;
import com.crypticmushroom.minecraft.midnight.common.registry.MnItems;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.kyanite.deeperdarker.content.DDItems;
import com.simibubi.create.AllItems;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.savage_and_ravage.core.registry.SRItems;
import dqu.additionaladditions.AdditionalRegistry;
import galena.oreganized.index.OItems;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.data.conditions.GenericItemExistsCondition;
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
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.orcinus.galosphere.init.GItems;
import tamaized.voidscape.registry.ModItems;
import vazkii.botania.common.item.BotaniaItems;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static krelox.gloves_for_all.GlovesTags.Items.*;
import static krelox.gloves_for_all.item.GlovesItems.*;

public class GlovesRecipeData extends NitrogenRecipeProvider implements IConditionBuilder {
    public GlovesRecipeData(PackOutput output) {
        super(output, GlovesForAll.MOD_ID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Caverns & Chasms
        conditionalGlovesRecipe(consumer, or(new GenericItemExistsCondition("silver_boots"), itemExists(CompatModule.ICE_AND_FIRE.getSourceModId(), "armor_silver_metal_boots")), SILVER_GLOVES, INGOTS_SILVER);
        smithingRecipeWithTag(consumer, RecipeCategory.COMBAT, NECROMIUM_GLOVES, () -> Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, AetherItems.DIAMOND_GLOVES, INGOTS_NECROMIUM, CCItems.NECROMIUM_INGOT);
        uniqueGlovesRecipe(consumer, SANGUINE_GLOVES, CCItems.LIVING_FLESH);
        // Oreganized
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.OREGANIZED.getSourceModId()))
                .addRecipe(consumer1 -> smithingRecipeWithTag(consumer1, RecipeCategory.COMBAT, ELECTRUM_GLOVES, OItems.ELECTRUM_UPGRADE_SMITHING_TEMPLATE, AetherItems.DIAMOND_GLOVES, INGOTS_ELECTRUM, OItems.ELECTRUM_INGOT))
                .addCondition(new GenericItemExistsCondition("electrum_boots"))
                .addRecipe(consumer1 -> glovesRecipeWithTag(consumer1, ELECTRUM_GLOVES, INGOTS_ELECTRUM))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(ELECTRUM_GLOVES)))
                .build(consumer, name(getItemName(ELECTRUM_GLOVES)));
        // Mekanism Tools
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("bronze_boots"), BRONZE_GLOVES, INGOTS_BRONZE);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("lapis_lazuli_boots"), LAPIS_LAZULI_GLOVES, Tags.Items.GEMS_LAPIS);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("osmium_boots"), OSMIUM_GLOVES, INGOTS_OSMIUM);
        glovesRecipeWithTag(consumer, REFINED_GLOWSTONE_GLOVES, INGOTS_REFINED_GLOWSTONE);
        glovesRecipeWithTag(consumer, REFINED_OBSIDIAN_GLOVES, INGOTS_REFINED_OBSIDIAN);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("steel_boots"), STEEL_GLOVES, INGOTS_STEEL);
        // SimpleOres
        conditionalGlovesRecipe(consumer, or(new GenericItemExistsCondition("copper_boots"), itemExists(CompatModule.ICE_AND_FIRE.getSourceModId(), "armor_copper_metal_boots")), COPPER_GLOVES, Tags.Items.INGOTS_COPPER);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("tin_boots"), TIN_GLOVES, INGOTS_TIN);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("mythril_boots"), MYTHRIL_GLOVES, INGOTS_MYTHRIL);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("adamantium_boots"), ADAMANTIUM_GLOVES, INGOTS_ADAMANTIUM);
        conditionalGlovesRecipe(consumer, new GenericItemExistsCondition("onyx_boots"), ONYX_GLOVES, GEMS_ONYX);
        // Ice and Fire
        uniqueGlovesRecipe(consumer, SHEEP_DISGUISE_GLOVES, () -> Items.WHITE_WOOL);
        uniqueGlovesRecipe(consumer, DRAGONSTEEL_FIRE_GLOVES, IafItemRegistry.DRAGONSTEEL_FIRE_INGOT);
        uniqueGlovesRecipe(consumer, DRAGONSTEEL_ICE_GLOVES, IafItemRegistry.DRAGONSTEEL_ICE_INGOT);
        uniqueGlovesRecipe(consumer, DRAGONSTEEL_LIGHTNING_GLOVES, IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT);
        SEA_SERPENT_SCALE_GLOVES_MAP.forEach((color, glovesItem) -> uniqueGlovesRecipe(consumer, glovesItem, EnumSeaSerpent.valueOf(color.toUpperCase(Locale.ROOT)).scale));
        // Thermal Extra
        glovesRecipeWithTag(consumer, SIGNALUM_GLOVES, INGOTS_SIGNALUM);
        glovesRecipeWithTag(consumer, LUMIUM_GLOVES, INGOTS_LUMIUM);
        glovesRecipeWithTag(consumer, ENDERIUM_GLOVES, INGOTS_ENDERIUM);
        glovesRecipeWithTag(consumer, SOUL_INFUSED_GLOVES, INGOTS_SOUL_INFUSED);
        glovesRecipeWithTag(consumer, TWINITE_GLOVES, INGOTS_TWINITE);
        glovesRecipeWithTag(consumer, SHELLITE_GLOVES, INGOTS_SHELLITE);
        glovesRecipeWithTag(consumer, DRAGONSTEEL_GLOVES, INGOTS_DRAGONSTEEL);
        glovesRecipeWithTag(consumer, ABYSSAL_GLOVES, INGOTS_ABYSSAL);
        // Additional Additions
        uniqueGlovesSmithingRecipe(consumer, ROSE_GOLD_GLOVES, AdditionalRegistry.ROSE_GOLD_UPGRADE, AetherItems.IRON_GLOVES, AdditionalRegistry.ROSE_GOLD_ALLOY);
        uniqueGlovesSmithingRecipe(consumer, GILDED_NETHERITE_GLOVES, AdditionalRegistry.GILDED_NETHERITE_UPGRADE, AetherItems.NETHERITE_GLOVES, AdditionalRegistry.GOLD_RING);
        // Redstone Arsenal
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.REDSTONE_ARSENAL.getSourceModId()))
                .addRecipe(consumer1 -> {
                    Item fluxPlating = ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatModule.REDSTONE_ARSENAL.getSourceModId(), "flux_plating"));
                    ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FLUX_INFUSED_GLOVES.get())
                            .define('X', Ingredient.of(fluxPlating))
                            .define('#', Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatModule.REDSTONE_ARSENAL.getSourceModId(), "flux_obsidian_rod"))))
                            .pattern("X#X")
                            .unlockedBy(getHasName(fluxPlating), has(fluxPlating))
                            .save(consumer1, name(getItemName(FLUX_INFUSED_GLOVES)));
                })
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(FLUX_INFUSED_GLOVES)))
                .build(consumer, name(getItemName(FLUX_INFUSED_GLOVES)));
        // Galosphere
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.GALOSPHERE.getSourceModId()))
                .addRecipe(consumer1 -> smithingRecipeWithTag(consumer1, RecipeCategory.COMBAT, STERLING_GLOVES, GItems.SILVER_UPGRADE_SMITHING_TEMPLATE, AetherItems.LEATHER_GLOVES, INGOTS_SILVER, GItems.SILVER_INGOT))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(STERLING_GLOVES) + "_smithing"))
                .build(consumer, name(getItemName(STERLING_GLOVES) + "_smithing"));
        // Undergarden
        glovesRecipeWithTag(consumer, CLOGGRUM_GLOVES, INGOTS_CLOGGRUM);
        glovesRecipeWithTag(consumer, FROSTSTEEL_GLOVES, INGOTS_FROSTSTEEL);
        glovesRecipeWithTag(consumer, UTHERIUM_GLOVES, INGOTS_UTHERIUM);
        // Blue Skies
        glovesRecipeWithTag(consumer, PYROPE_GLOVES, GEMS_PYROPE);
        glovesRecipeWithTag(consumer, AQUITE_GLOVES, GEMS_AQUITE);
        glovesRecipeWithTag(consumer, HORIZONITE_GLOVES, INGOTS_HORIZONITE);
        glovesRecipeWithTag(consumer, DIOPSIDE_GLOVES, GEMS_DIOPSIDE);
        glovesRecipeWithTag(consumer, CHAROITE_GLOVES, GEMS_CHAROITE);
        // Voidscape
        uniqueGlovesSmithingRecipe(consumer, VOIDIC_CRYSTAL_GLOVES, ModItems.VOIDIC_TEMPLATE, AetherItems.NETHERITE_GLOVES, ModItems.VOIDIC_CRYSTAL);
        uniqueGlovesSmithingRecipe(consumer, CORRUPT_GLOVES, ModItems.VOIDIC_TEMPLATE, VOIDIC_CRYSTAL_GLOVES, ModItems.TENDRIL);
        uniqueGlovesSmithingRecipe(consumer, TITANITE_GLOVES, ModItems.VOIDIC_TEMPLATE, CORRUPT_GLOVES, ModItems.TITANITE_SHARD);
        uniqueGlovesSmithingRecipe(consumer, ICHOR_GLOVES, ModItems.VOIDIC_TEMPLATE, TITANITE_GLOVES, ModItems.ICHOR);
        uniqueGlovesSmithingRecipe(consumer, ASTRAL_GLOVES, ModItems.VOIDIC_TEMPLATE, ICHOR_GLOVES, ModItems.ASTRAL_CRYSTAL);
        // Midnight
        uniqueGlovesRecipe(consumer, ROCKSHROOM_GLOVES, MnItems.ROCKSHROOM_CLUMP);
        uniqueGlovesRecipe(consumer, TENEBRUM_GLOVES, MnItems.TENEBRUM_INGOT);
        // Deeper and Darker
        uniqueGlovesSmithingRecipe(consumer, RESONARIUM_GLOVES, () -> Items.AIR, AetherItems.IRON_GLOVES, DDItems.RESONARIUM_PLATE);
        uniqueGlovesSmithingRecipe(consumer, WARDEN_GLOVES, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, AetherItems.NETHERITE_GLOVES, DDItems.REINFORCED_ECHO_SHARD);
        // Botania
        glovesRecipeWithTag(consumer, MANASTEEL_GLOVES, INGOTS_MANASTEEL);
        glovesRecipeWithTag(consumer, ELEMENTIUM_GLOVES, INGOTS_ELEMENTIUM);
        uniqueGlovesRecipe(consumer, MANAWEAVE_GLOVES, () -> BotaniaItems.manaweaveCloth);
        glovesRecipeWithTag(consumer, TERRASTEEL_GLOVES, INGOTS_TERRASTEEL);
        // Savage & Ravage
        uniqueGlovesRecipe(consumer, GRIEFER_GLOVES, SRItems.BLAST_PROOF_PLATING);
        // Create
        uniqueGlovesRecipe(consumer, CARDBOARD_GLOVES, AllItems.CARDBOARD);
        // Thermal Core
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.THERMAL.getSourceModId()))
                .addCondition(new FlagRecipeCondition(ThermalFlags.manager(), ThermalFlags.FLAG_BEEKEEPER_ARMOR))
                .addRecipe(consumer1 -> makeGloves(BEEKEEPER_GLOVES, ThermalCore.ITEMS.getSup("beekeeper_fabric")).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(BEEKEEPER_GLOVES)))
                .build(consumer, name(getItemName(BEEKEEPER_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.THERMAL.getSourceModId()))
                .addCondition(new FlagRecipeCondition(ThermalFlags.manager(), ThermalFlags.FLAG_DIVING_ARMOR))
                .addRecipe(consumer1 -> {
                    Item divingFabric = ThermalCore.ITEMS.get("diving_fabric");
                    ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DIVING_GLOVES.get())
                            .define('X', Ingredient.of(divingFabric))
                            .define('I', Ingredient.of(Tags.Items.INGOTS_GOLD))
                            .pattern("XIX")
                            .unlockedBy(getHasName(divingFabric), has(divingFabric))
                            .save(consumer1, name(getItemName(DIVING_GLOVES)));
                })
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(DIVING_GLOVES)))
                .build(consumer, name(getItemName(DIVING_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.THERMAL.getSourceModId()))
                .addCondition(new FlagRecipeCondition(ThermalFlags.manager(), ThermalFlags.FLAG_HAZMAT_ARMOR))
                .addRecipe(consumer1 -> {
                    Item hazmatFabric = ThermalCore.ITEMS.get("hazmat_fabric");
                    ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HAZMAT_GLOVES.get())
                            .define('X', Ingredient.of(hazmatFabric))
                            .define('I', Ingredient.of(ThermalCore.ITEMS.get("cured_rubber")))
                            .pattern("XIX")
                            .unlockedBy(getHasName(hazmatFabric), has(hazmatFabric))
                            .save(consumer1, name(getItemName(HAZMAT_GLOVES)));
                })
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(HAZMAT_GLOVES)))
                .build(consumer, name(getItemName(HAZMAT_GLOVES)));
    }

    public void conditionalGlovesRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, RegistryObject<Item> gloves, TagKey<Item> tag) {
        ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(consumer1 -> glovesRecipeWithTag(consumer1, gloves, tag))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(gloves)))
                .build(consumer, name(getItemName(gloves)));
    }

    public void uniqueGlovesRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item> gloves, Supplier<? extends Item> material) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded(((CompatGlovesItem) gloves.get()).getCompatMaterial().getCompatModule().getSourceModId()))
                .addRecipe(consumer1 -> makeGloves(gloves, material).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(gloves)))
                .build(consumer, name(getItemName(gloves)));
    }

    public void glovesRecipeWithTag(Consumer<FinishedRecipe> consumer, Supplier<Item> gloves, TagKey<Item> tag) {
        makeGlovesWithTag(gloves, tag, ((CompatGlovesItem) gloves.get()).getCompatMaterial().getName()).save(consumer);
    }

    public void smithingRecipeWithTag(Consumer<FinishedRecipe> consumer, RecipeCategory category, RegistryObject<Item> result, Supplier<Item> templateItem,
                                      Supplier<Item> input, TagKey<Item> upgradeTag, Supplier<Item> upgradeItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(templateItem.get()),
                        Ingredient.of(input.get()),
                        Ingredient.of(upgradeTag),
                        category, result.get())
                .unlocks(getHasName(upgradeItem.get()), has(upgradeTag))
                .save(consumer, name(getItemName(result) + "_smithing"));
    }

    public void uniqueGlovesSmithingRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item> gloves, Supplier<Item> templateItem,
                                           Supplier<Item> input, Supplier<Item> upgradeItem) {
        String name = getItemName(gloves) + "_smithing";
        ConditionalRecipe.builder()
                .addCondition(modLoaded(((CompatGlovesItem) gloves.get()).getCompatMaterial().getCompatModule().getSourceModId()))
                .addRecipe(consumer1 -> SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(templateItem.get()),
                                Ingredient.of(input.get()),
                                Ingredient.of(upgradeItem.get()),
                                RecipeCategory.COMBAT, gloves.get())
                        .unlocks(getHasName(upgradeItem.get()), has(upgradeItem.get()))
                        .save(consumer1, name(name)))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + name))
                .build(consumer, name(name));
    }

    protected static String getItemName(RegistryObject<Item> item) {
        return item.getId().getPath();
    }
}
