package krelox.gloves_for_all.data;

import cofh.lib.init.tags.ItemTagsCoFH;
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
import com.legacy.blue_skies.registries.SkiesItems;
import com.simibubi.create.AllItems;
import com.teamabnormals.caverns_and_chasms.core.other.tags.CCItemTags;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.savage_and_ravage.core.registry.SRItems;
import dqu.additionaladditions.AdditionalRegistry;
import galena.oreganized.index.OItems;
import krelox.gloves_for_all.CompatModule;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.gloves.CompatGlovesItem;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.resource.ResourceType;
import mekanism.common.tags.MekanismTags;
import mod.alexndr.simplecorelib.api.config.FlagCondition;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModTags;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.orcinus.galosphere.compat.init.ForgeItemTags;
import quek.undergarden.registry.UGItems;
import tamaized.voidscape.registry.ModItems;
import vazkii.botania.common.crafting.recipe.ArmorUpgradeRecipe;
import vazkii.botania.common.item.BotaniaItems;
import vazkii.botania.common.lib.BotaniaTags;
import vazkii.botania.data.recipes.WrapperResult;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static krelox.gloves_for_all.item.GlovesItems.*;

public class GlovesRecipeData extends NitrogenRecipeProvider implements IConditionBuilder {
    public GlovesRecipeData(PackOutput output) {
        super(output, GlovesForAll.MOD_ID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Caverns & Chasms
        compatGlovesRecipe(consumer, COPPER_GLOVES, () -> Items.COPPER_BLOCK);
        compatGlovesRecipe(consumer, EXPOSED_COPPER_GLOVES, () -> Items.EXPOSED_COPPER);
        compatGlovesRecipe(consumer, WEATHERED_COPPER_GLOVES, () -> Items.WEATHERED_COPPER);
        compatGlovesRecipe(consumer, OXIDIZED_COPPER_GLOVES, () -> Items.OXIDIZED_COPPER);
        compatGlovesRecipe(consumer, WAXED_COPPER_GLOVES, () -> Items.WAXED_COPPER_BLOCK);
        compatGlovesRecipe(consumer, WAXED_EXPOSED_COPPER_GLOVES, () -> Items.WAXED_EXPOSED_COPPER);
        compatGlovesRecipe(consumer, WAXED_WEATHERED_COPPER_GLOVES, () -> Items.WAXED_WEATHERED_COPPER);
        compatGlovesRecipe(consumer, WAXED_OXIDIZED_COPPER_GLOVES, () -> Items.WAXED_OXIDIZED_COPPER);
        compatGlovesRecipeWithTag(consumer, SILVER_GLOVES, CCItemTags.INGOTS_SILVER);
        compatGlovesSmithingRecipeWithTag(consumer, NECROMIUM_GLOVES, () -> Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, AetherItems.DIAMOND_GLOVES, CCItemTags.INGOTS_NECROMIUM);
        compatGlovesRecipe(consumer, SANGUINE_GLOVES, CCItems.LIVING_FLESH);
        nuggetFromSmeltingGlovesRecipes(consumer, Items.COPPER_INGOT, COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.EXPOSED_COPPER_INGOT.get(), EXPOSED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.WEATHERED_COPPER_INGOT.get(), WEATHERED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.OXIDIZED_COPPER_INGOT.get(), OXIDIZED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.WAXED_COPPER_INGOT.get(), WAXED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.WAXED_EXPOSED_COPPER_INGOT.get(), WAXED_EXPOSED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.WAXED_WEATHERED_COPPER_INGOT.get(), WAXED_WEATHERED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.WAXED_OXIDIZED_COPPER_INGOT.get(), WAXED_OXIDIZED_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, CCItems.SILVER_NUGGET.get(), SILVER_GLOVES);
        // Savage & Ravage
        compatGlovesRecipe(consumer, GRIEFER_GLOVES, SRItems.BLAST_PROOF_PLATING);
        // Oreganized
        compatGlovesSmithingRecipe(consumer, ELECTRUM_GLOVES, OItems.ELECTRUM_UPGRADE_SMITHING_TEMPLATE, AetherItems.DIAMOND_GLOVES, OItems.ELECTRUM_INGOT);
        // Galosphere
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.GALOSPHERE.getSourceModId()))
                .addRecipe(consumer1 -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, STERLING_GLOVES.get())
                        .define('#', Ingredient.of(Items.LEATHER))
                        .define('S', Ingredient.of(ForgeItemTags.PALLADIUM_INGOT))
                        .pattern("S#S")
                        .unlockedBy("has_" + ForgeItemTags.PALLADIUM_INGOT.location().getPath().replace('/', '_'), has(ForgeItemTags.PALLADIUM_INGOT))
                        .save(consumer1, name(getItemName(STERLING_GLOVES))))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(STERLING_GLOVES)))
                .build(consumer, name(getItemName(STERLING_GLOVES)));
        // Additional Additions
        compatGlovesSmithingRecipe(consumer, ROSE_GOLD_GLOVES, AdditionalRegistry.ROSE_GOLD_UPGRADE, AetherItems.IRON_GLOVES, AdditionalRegistry.ROSE_GOLD_ALLOY);
        compatGlovesSmithingRecipe(consumer, GILDED_NETHERITE_GLOVES, AdditionalRegistry.GILDED_NETHERITE_UPGRADE, AetherItems.NETHERITE_GLOVES, AdditionalRegistry.GOLD_RING);
        // SimpleOres
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.SIMPLEORES.getSourceModId()))
                .addCondition(new FlagCondition(SimpleOresConfig.INSTANCE, "copper_armor", new ResourceLocation(CompatModule.SIMPLEORES.getSourceModId(), "flag")))
                .addRecipe(consumer1 -> makeGlovesWithTag(SO_COPPER_GLOVES, Tags.Items.INGOTS_COPPER, Tags.Items.INGOTS_COPPER.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(SO_COPPER_GLOVES)))
                .build(consumer, name(getItemName(SO_COPPER_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.SIMPLEORES.getSourceModId()))
                .addCondition(new FlagCondition(SimpleOresConfig.INSTANCE, "tin_armor", new ResourceLocation(CompatModule.SIMPLEORES.getSourceModId(), "flag")))
                .addRecipe(consumer1 -> makeGlovesWithTag(TIN_GLOVES, ModTags.Items.INGOTS_TIN, ModTags.Items.INGOTS_TIN.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(TIN_GLOVES)))
                .build(consumer, name(getItemName(TIN_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.SIMPLEORES.getSourceModId()))
                .addCondition(new FlagCondition(SimpleOresConfig.INSTANCE, "mythril_armor", new ResourceLocation(CompatModule.SIMPLEORES.getSourceModId(), "flag")))
                .addRecipe(consumer1 -> makeGlovesWithTag(MYTHRIL_GLOVES, ModTags.Items.INGOTS_MYTHRIL, ModTags.Items.INGOTS_MYTHRIL.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(MYTHRIL_GLOVES)))
                .build(consumer, name(getItemName(MYTHRIL_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.SIMPLEORES.getSourceModId()))
                .addCondition(new FlagCondition(SimpleOresConfig.INSTANCE, "adamantium_armor", new ResourceLocation(CompatModule.SIMPLEORES.getSourceModId(), "flag")))
                .addRecipe(consumer1 -> makeGlovesWithTag(ADAMANTIUM_GLOVES, ModTags.Items.INGOTS_ADAMANTIUM, ModTags.Items.INGOTS_ADAMANTIUM.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(ADAMANTIUM_GLOVES)))
                .build(consumer, name(getItemName(ADAMANTIUM_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.SIMPLEORES.getSourceModId()))
                .addCondition(new FlagCondition(SimpleOresConfig.INSTANCE, "onyx_armor", new ResourceLocation(CompatModule.SIMPLEORES.getSourceModId(), "flag")))
                .addRecipe(consumer1 -> makeGlovesWithTag(ONYX_GLOVES, ModTags.Items.GEMS_ONYX, ModTags.Items.GEMS_ONYX.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(ONYX_GLOVES)))
                .build(consumer, name(getItemName(ONYX_GLOVES)));
        nuggetFromSmeltingGlovesRecipes(consumer, mod.alexndr.simpleores.init.ModItems.copper_nugget.get(), SO_COPPER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, mod.alexndr.simpleores.init.ModItems.tin_nugget.get(), TIN_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, mod.alexndr.simpleores.init.ModItems.mythril_nugget.get(), MYTHRIL_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, mod.alexndr.simpleores.init.ModItems.adamantium_nugget.get(), ADAMANTIUM_GLOVES);

        // Undergarden
        compatGlovesRecipe(consumer, CLOGGRUM_GLOVES, UGItems.CLOGGRUM_INGOT);
        compatGlovesRecipe(consumer, FROSTSTEEL_GLOVES, UGItems.FROSTSTEEL_INGOT);
        compatGlovesRecipe(consumer, UTHERIUM_GLOVES, UGItems.UTHERIUM_CRYSTAL);
        nuggetFromSmeltingGlovesRecipes(consumer, UGItems.CLOGGRUM_NUGGET.get(), CLOGGRUM_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, UGItems.FROSTSTEEL_INGOT.get(), FROSTSTEEL_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, UGItems.UTHERIUM_CRYSTAL.get(), UTHERIUM_GLOVES);
        // Blue Skies
        compatGlovesRecipe(consumer, PYROPE_GLOVES, () -> SkiesItems.pyrope_gem);
        compatGlovesRecipe(consumer, AQUITE_GLOVES, () -> SkiesItems.aquite);
        compatGlovesRecipe(consumer, HORIZONITE_GLOVES, () -> SkiesItems.horizonite_ingot);
        compatGlovesRecipe(consumer, DIOPSIDE_GLOVES, () -> SkiesItems.diopside_gem);
        compatGlovesRecipe(consumer, CHAROITE_GLOVES, () -> SkiesItems.charoite);
        nuggetFromSmeltingGlovesRecipes(consumer, SkiesItems.horizonite_nugget, HORIZONITE_GLOVES);
        // Voidscape
        compatGlovesSmithingRecipe(consumer, VOIDIC_CRYSTAL_GLOVES, ModItems.VOIDIC_TEMPLATE, AetherItems.NETHERITE_GLOVES, ModItems.VOIDIC_CRYSTAL);
        compatGlovesSmithingRecipe(consumer, CORRUPT_GLOVES, ModItems.VOIDIC_TEMPLATE, VOIDIC_CRYSTAL_GLOVES, ModItems.TENDRIL);
        compatGlovesSmithingRecipe(consumer, TITANITE_GLOVES, ModItems.VOIDIC_TEMPLATE, CORRUPT_GLOVES, ModItems.TITANITE_SHARD);
        compatGlovesSmithingRecipe(consumer, ICHOR_GLOVES, ModItems.VOIDIC_TEMPLATE, TITANITE_GLOVES, ModItems.ICHOR);
        compatGlovesSmithingRecipe(consumer, ASTRAL_GLOVES, ModItems.VOIDIC_TEMPLATE, ICHOR_GLOVES, ModItems.ASTRAL_CRYSTAL);
        // Midnight
        compatGlovesRecipe(consumer, ROCKSHROOM_GLOVES, MnItems.ROCKSHROOM_CLUMP);
        compatGlovesRecipe(consumer, TENEBRUM_GLOVES, MnItems.TENEBRUM_INGOT);
        nuggetFromSmeltingGlovesRecipes(consumer, MnItems.TENEBRUM_NUGGET.get(), TENEBRUM_GLOVES);
        // Deeper and Darker
        compatGlovesSmithingRecipe(consumer, RESONARIUM_GLOVES, () -> Items.AIR, AetherItems.IRON_GLOVES, DDItems.RESONARIUM_PLATE);
        compatGlovesSmithingRecipe(consumer, WARDEN_GLOVES, DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, AetherItems.NETHERITE_GLOVES, DDItems.REINFORCED_ECHO_SHARD);

        // Botania
        compatGlovesRecipeWithTag(consumer, MANASTEEL_GLOVES, BotaniaTags.Items.INGOTS_MANASTEEL);
        compatGlovesRecipeWithTag(consumer, ELEMENTIUM_GLOVES, BotaniaTags.Items.INGOTS_ELEMENTIUM);
        compatGlovesRecipe(consumer, MANAWEAVE_GLOVES, () -> BotaniaItems.manaweaveCloth);
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.BOTANIA.getSourceModId()))
                .addRecipe(consumer1 -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TERRASTEEL_GLOVES.get())
                        .define('T', BotaniaItems.livingwoodTwig)
                        .define('S', BotaniaTags.Items.INGOTS_TERRASTEEL)
                        .define('R', Ingredient.of(BotaniaItems.runeSpring, BotaniaItems.runeSummer, BotaniaItems.runeAutumn, BotaniaItems.runeWinter))
                        .define('A', MANASTEEL_GLOVES.get())
                        .pattern("TRT")
                        .pattern("SAS")
                        .pattern(" S ")
                        .unlockedBy("has_item", has(BotaniaTags.Items.INGOTS_TERRASTEEL))
                        .unlockedBy("has_prev_tier", has(MANASTEEL_GLOVES.get()))
                        .save(WrapperResult.ofType(ArmorUpgradeRecipe.SERIALIZER, consumer1)))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(TERRASTEEL_GLOVES)))
                .build(consumer, name(getItemName(TERRASTEEL_GLOVES)));

        // Create
        compatGlovesRecipe(consumer, CARDBOARD_GLOVES, AllItems.CARDBOARD);
        // Redstone Arsenal
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.REDSTONE_ARSENAL.getSourceModId()))
                .addRecipe(consumer1 -> {
                    Item fluxPlating = RedstoneArsenal.ITEMS.get("flux_plating");
                    ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, FLUX_INFUSED_GLOVES.get())
                            .define('X', Ingredient.of(fluxPlating))
                            .define('#', Ingredient.of(RedstoneArsenal.ITEMS.get("flux_obsidian_rod")))
                            .pattern("X#X")
                            .unlockedBy(getHasName(fluxPlating), has(fluxPlating))
                            .save(consumer1, name(getItemName(FLUX_INFUSED_GLOVES)));
                })
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(FLUX_INFUSED_GLOVES)))
                .build(consumer, name(getItemName(FLUX_INFUSED_GLOVES)));
        // Tools Complement
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(Tags.Items.INGOTS_COPPER)))
                .addRecipe(consumer1 -> makeGlovesWithTag(TC_COPPER_GLOVES, Tags.Items.INGOTS_COPPER, Tags.Items.INGOTS_COPPER.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(TC_COPPER_GLOVES)))
                .build(consumer, name(getItemName(TC_COPPER_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_TIN)))
                .addRecipe(consumer1 -> makeGlovesWithTag(TC_TIN_GLOVES, ItemTagsCoFH.INGOTS_TIN, ItemTagsCoFH.INGOTS_TIN.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(TC_TIN_GLOVES)))
                .build(consumer, name(getItemName(TC_TIN_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_LEAD)))
                .addRecipe(consumer1 -> makeGlovesWithTag(LEAD_GLOVES, ItemTagsCoFH.INGOTS_LEAD, ItemTagsCoFH.INGOTS_LEAD.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(LEAD_GLOVES)))
                .build(consumer, name(getItemName(LEAD_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_SILVER)))
                .addRecipe(consumer1 -> makeGlovesWithTag(TC_SILVER_GLOVES, ItemTagsCoFH.INGOTS_SILVER, ItemTagsCoFH.INGOTS_SILVER.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(TC_SILVER_GLOVES)))
                .build(consumer, name(getItemName(TC_SILVER_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_NICKEL)))
                .addRecipe(consumer1 -> makeGlovesWithTag(NICKEL_GLOVES, ItemTagsCoFH.INGOTS_NICKEL, ItemTagsCoFH.INGOTS_NICKEL.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(NICKEL_GLOVES)))
                .build(consumer, name(getItemName(NICKEL_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_BRONZE)))
                .addRecipe(consumer1 -> makeGlovesWithTag(BRONZE_GLOVES, ItemTagsCoFH.INGOTS_BRONZE, ItemTagsCoFH.INGOTS_BRONZE.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(BRONZE_GLOVES)))
                .build(consumer, name(getItemName(BRONZE_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_ELECTRUM)))
                .addRecipe(consumer1 -> makeGlovesWithTag(TC_ELECTRUM_GLOVES, ItemTagsCoFH.INGOTS_ELECTRUM, ItemTagsCoFH.INGOTS_ELECTRUM.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(TC_ELECTRUM_GLOVES)))
                .build(consumer, name(getItemName(TC_ELECTRUM_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_INVAR)))
                .addRecipe(consumer1 -> makeGlovesWithTag(INVAR_GLOVES, ItemTagsCoFH.INGOTS_INVAR, ItemTagsCoFH.INGOTS_INVAR.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(INVAR_GLOVES)))
                .build(consumer, name(getItemName(INVAR_GLOVES)));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(CompatModule.TOOLS_COMPLEMENT.getSourceModId()))
                .addCondition(not(tagEmpty(ItemTagsCoFH.INGOTS_CONSTANTAN)))
                .addRecipe(consumer1 -> makeGlovesWithTag(CONSTANTAN_GLOVES, ItemTagsCoFH.INGOTS_CONSTANTAN, ItemTagsCoFH.INGOTS_CONSTANTAN.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(CONSTANTAN_GLOVES)))
                .build(consumer, name(getItemName(CONSTANTAN_GLOVES)));
        // Thermal Series
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
        // Thermal Extra
        compatGlovesRecipeWithTag(consumer, SIGNALUM_GLOVES, ItemTagsCoFH.INGOTS_SIGNALUM);
        compatGlovesRecipeWithTag(consumer, LUMIUM_GLOVES, ItemTagsCoFH.INGOTS_LUMIUM);
        compatGlovesRecipeWithTag(consumer, ENDERIUM_GLOVES, ItemTagsCoFH.INGOTS_ENDERIUM);
        compatGlovesRecipeWithTag(consumer, SOUL_INFUSED_GLOVES, ThermalExtraTags.Items.SOUL_INFUSED_INGOT);
        compatGlovesRecipeWithTag(consumer, TWINITE_GLOVES, ThermalExtraTags.Items.TWINITE_INGOT);
        compatGlovesRecipeWithTag(consumer, SHELLITE_GLOVES, ThermalExtraTags.Items.SHELLITE_INGOT);
        compatGlovesRecipeWithTag(consumer, DRAGONSTEEL_GLOVES, ThermalExtraTags.Items.DRAGONSTEEL_INGOT);
        compatGlovesRecipeWithTag(consumer, ABYSSAL_GLOVES, ThermalExtraTags.Items.ABYSSAL_INGOT);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalCore.ITEMS.get("signalum_nugget"), SIGNALUM_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalCore.ITEMS.get("lumium_nugget"), LUMIUM_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalCore.ITEMS.get("enderium_nugget"), ENDERIUM_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalExtraItems.SOUL_INFUSED_NUGGET.get(), SOUL_INFUSED_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalExtraItems.TWINITE_NUGGET.get(), TWINITE_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalExtraItems.SHELLITE_NUGGET.get(), SHELLITE_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalExtraItems.DRAGONSTEEL_NUGGET.get(), DRAGONSTEEL_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, ThermalExtraItems.ABYSSAL_NUGGET.get(), ABYSSAL_GLOVES);
        // Mekanism Tools
        compatGlovesRecipeWithTag(consumer, MEKANISM_BRONZE_GLOVES, MekanismTags.Items.INGOTS_BRONZE);
        compatGlovesRecipeWithTag(consumer, LAPIS_LAZULI_GLOVES, Tags.Items.GEMS_LAPIS);
        compatGlovesRecipeWithTag(consumer, OSMIUM_GLOVES, MekanismTags.Items.PROCESSED_RESOURCES.get(ResourceType.INGOT, PrimaryResource.OSMIUM));
        compatGlovesRecipeWithTag(consumer, REFINED_GLOWSTONE_GLOVES, MekanismTags.Items.INGOTS_REFINED_GLOWSTONE);
        compatGlovesRecipeWithTag(consumer, REFINED_OBSIDIAN_GLOVES, MekanismTags.Items.INGOTS_REFINED_OBSIDIAN);
        compatGlovesRecipeWithTag(consumer, STEEL_GLOVES, MekanismTags.Items.INGOTS_STEEL);
        nuggetFromSmeltingGlovesRecipes(consumer, MekanismItems.BRONZE_NUGGET.get(), MEKANISM_BRONZE_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, MekanismItems.PROCESSED_RESOURCES.get(ResourceType.NUGGET, PrimaryResource.OSMIUM).get(), OSMIUM_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, MekanismItems.REFINED_GLOWSTONE_NUGGET.get(), REFINED_GLOWSTONE_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, MekanismItems.REFINED_OBSIDIAN_NUGGET.get(), REFINED_OBSIDIAN_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, MekanismItems.STEEL_NUGGET.get(), STEEL_GLOVES);

        // Ice and Fire
        compatGlovesRecipeWithTag(consumer, IAF_SILVER_GLOVES, CCItemTags.INGOTS_SILVER);
        compatGlovesRecipeWithTag(consumer, IAF_COPPER_GLOVES, Tags.Items.INGOTS_COPPER);
        compatGlovesRecipe(consumer, SHEEP_DISGUISE_GLOVES, () -> Items.WHITE_WOOL);
        compatGlovesRecipe(consumer, FIRE_DRAGONSTEEL_GLOVES, IafItemRegistry.DRAGONSTEEL_FIRE_INGOT);
        compatGlovesRecipe(consumer, ICE_DRAGONSTEEL_GLOVES, IafItemRegistry.DRAGONSTEEL_ICE_INGOT);
        compatGlovesRecipe(consumer, LIGHTNING_DRAGONSTEEL_GLOVES, IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT);
        TIDE_GUARDIAN_GLOVES_MAP.forEach((color, glovesItem) -> compatGlovesRecipe(consumer, glovesItem, EnumSeaSerpent.valueOf(color.toUpperCase(Locale.ROOT)).scale));
        nuggetFromSmeltingGlovesRecipes(consumer, IafItemRegistry.SILVER_NUGGET.get(), IAF_SILVER_GLOVES);
        nuggetFromSmeltingGlovesRecipes(consumer, IafItemRegistry.COPPER_NUGGET.get(), IAF_COPPER_GLOVES);
    }

    public void compatGlovesRecipeWithTag(Consumer<FinishedRecipe> consumer, RegistryObject<Item> gloves, TagKey<Item> tag) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded(((CompatGlovesItem) gloves.get()).getCompatMaterial().getCompatModule().getSourceModId()))
                .addRecipe(consumer1 -> makeGlovesWithTag(gloves, tag, tag.location().getPath().replace('/', '_')).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(gloves)))
                .build(consumer, name(getItemName(gloves)));
    }

    public void compatGlovesRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item> gloves, Supplier<? extends Item> material) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded(((CompatGlovesItem) gloves.get()).getCompatMaterial().getCompatModule().getSourceModId()))
                .addRecipe(consumer1 -> makeGloves(gloves, material).save(consumer1))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + getItemName(gloves)))
                .build(consumer, name(getItemName(gloves)));
    }

    public void compatGlovesSmithingRecipeWithTag(Consumer<FinishedRecipe> consumer, RegistryObject<Item> gloves,
                                                  Supplier<Item> templateItem, Supplier<Item> input, TagKey<Item> upgradeTag) {
        ResourceLocation name = name(getItemName(gloves) + "_smithing");
        ConditionalRecipe.builder()
                .addCondition(modLoaded(((CompatGlovesItem) gloves.get()).getCompatMaterial().getCompatModule().getSourceModId()))
                .addRecipe(consumer1 -> SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(templateItem.get()),
                                Ingredient.of(input.get()),
                                Ingredient.of(upgradeTag),
                                RecipeCategory.COMBAT, gloves.get())
                        .unlocks("has_" + upgradeTag.location().getPath().replace('/', '_'), has(upgradeTag))
                        .save(consumer1, name))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + name.getPath()))
                .build(consumer, name);
    }

    public void compatGlovesSmithingRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item> gloves,
                                           Supplier<Item> templateItem, Supplier<Item> input, Supplier<Item> upgradeItem) {
        ResourceLocation name = name(getItemName(gloves) + "_smithing");
        ConditionalRecipe.builder()
                .addCondition(modLoaded(((CompatGlovesItem) gloves.get()).getCompatMaterial().getCompatModule().getSourceModId()))
                .addRecipe(consumer1 -> SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(templateItem.get()),
                                Ingredient.of(input.get()),
                                Ingredient.of(upgradeItem.get()),
                                RecipeCategory.COMBAT, gloves.get())
                        .unlocks(getHasName(upgradeItem.get()), has(upgradeItem.get()))
                        .save(consumer1, name))
                .generateAdvancement(name("recipes/" + RecipeCategory.COMBAT.getFolderName() + "/" + name.getPath()))
                .build(consumer, name);
    }

    public void nuggetFromSmeltingGlovesRecipes(Consumer<FinishedRecipe> consumer, Item nugget, RegistryObject<Item> gloves) {
        var glovesItem = (CompatGlovesItem) gloves.get();
        String hasName = "has_" + glovesItem.getCompatMaterial().getName() + "_gloves";
        String sourceModId = glovesItem.getCompatMaterial().getCompatModule().getSourceModId();

        ResourceLocation smeltingName = name(sourceModId + "/aether_" + getSmeltingRecipeName(nugget));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(sourceModId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder
                        .smelting(Ingredient.of(gloves.get()), RecipeCategory.MISC, nugget, 0.1F, 100)
                        .unlockedBy(hasName, has(gloves.get()))
                        .group(getSmeltingRecipeName(nugget))
                        .save(consumer1, smeltingName))
                .generateAdvancement(name("recipes/" + RecipeCategory.MISC.getFolderName() + "/" + smeltingName.getPath()))
                .build(consumer, smeltingName);

        ResourceLocation blastingName = name(sourceModId + "/aether_" + getBlastingRecipeName(nugget));
        ConditionalRecipe.builder()
                .addCondition(modLoaded(sourceModId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder
                        .blasting(Ingredient.of(gloves.get()), RecipeCategory.MISC, nugget, 0.1F, 100)
                        .unlockedBy(hasName, has(gloves.get()))
                        .group(getBlastingRecipeName(nugget))
                        .save(consumer1, blastingName))
                .generateAdvancement(name("recipes/" + RecipeCategory.MISC.getFolderName() + "/" + blastingName.getPath()))
                .build(consumer, blastingName);
    }

    protected static String getItemName(RegistryObject<Item> item) {
        return item.getId().getPath();
    }
}
