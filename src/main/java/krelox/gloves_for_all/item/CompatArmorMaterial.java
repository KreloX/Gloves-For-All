package krelox.gloves_for_all.item;

import cofh.redstonearsenal.init.registries.ModItems;
import cofh.thermal.core.init.registries.TCoreItems;
import com.crypticmushroom.minecraft.midnight.common.misc.MnArmorMaterials;
import com.crypticmushroom.minecraft.midnight.common.misc.MnTiers;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.item.DragonSteelTier;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTiers;
import com.legacy.blue_skies.items.util.SkiesArmorMaterial;
import com.legacy.blue_skies.items.util.SkiesItemTier;
import com.simibubi.create.content.equipment.armor.AllArmorMaterials;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers;
import com.teamabnormals.savage_and_ravage.core.other.SRTiers;
import dqu.additionaladditions.AdditionalRegistry;
import dqu.additionaladditions.material.GildedNetheriteToolMaterial;
import dqu.additionaladditions.material.RoseGoldToolMaterial;
import galena.oreganized.index.OArmorMaterials;
import galena.oreganized.index.OItemTiers;
import mekanism.tools.common.registries.ToolsItems;
import mod.alexndr.simpleores.content.SimpleOresArmorMaterial;
import mod.alexndr.simpleores.content.SimpleOresTiers;
import mrthomas20121.thermal_extra.init.ThermalExtraArmorMaterials;
import mrthomas20121.thermal_extra.init.ThermalExtraTiers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.orcinus.galosphere.init.GItems;
import quek.undergarden.registry.UGArmorMaterials;
import quek.undergarden.registry.UGItemTiers;
import tamaized.voidscape.registry.ModArmors;
import tamaized.voidscape.registry.ModTools;
import vazkii.botania.api.BotaniaAPI;

import java.util.List;
import java.util.Locale;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static krelox.gloves_for_all.GlovesTags.Items.*;
import static krelox.gloves_for_all.item.CompatModule.*;
import static net.minecraft.sounds.SoundEvents.*;

public enum CompatArmorMaterial implements StringRepresentable {
    // Caverns & Chasms
    SILVER(17, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_SILVER), 157, List.of(
            new CompatEntry(CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.SILVER, () -> CCTiers.CCItemTiers.SILVER.getUses()),
            new CompatEntry(ICE_AND_FIRE, () -> IafItemRegistry.SILVER_ARMOR_MATERIAL, () -> IafItemRegistry.SILVER_TOOL_MATERIAL.getUses()))),
    NECROMIUM(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_NECROMIUM), Tiers.NETHERITE.getUses(), CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.NECROMIUM, () -> CCTiers.CCItemTiers.NECROMIUM.getUses()),
    SANGUINE(17, ARMOR_EQUIP_IRON, Ingredient::of, 989, CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.SANGUINE),
    // Savage & Ravage
    GRIEFER(15, ARMOR_EQUIP_IRON, Ingredient::of, Tiers.IRON.getUses(), SAVAGE_AND_RAVAGE, () -> SRTiers.GRIEFER),
    // Oreganized
    ELECTRUM(20, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_ELECTRUM), Tiers.DIAMOND.getUses(), OREGANIZED, () -> OArmorMaterials.ELECTRUM, () -> OItemTiers.ELECTRUM.getUses()),
    // Galosphere
    STERLING(9, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_SILVER), 163, GALOSPHERE, () -> ((ArmorItem) GItems.STERLING_BOOTS.get()).getMaterial()),
    // Additional Additions
    ROSE_GOLD(17, ARMOR_EQUIP_GOLD, () -> Ingredient.of(Tags.Items.INGOTS_COPPER), 900, ADDITIONAL_ADDITIONS, () -> AdditionalRegistry.ROSE_GOLD_ARMOR_MATERIAL, () -> RoseGoldToolMaterial.MATERIAL.getUses()),
    GILDED_NETHERITE(20, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), 2031, ADDITIONAL_ADDITIONS, () -> AdditionalRegistry.GILDED_NETHERITE_ARMOR_MATERIAL, () -> GildedNetheriteToolMaterial.MATERIAL.getUses()),
    // SimpleOres
    COPPER(8, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Tags.Items.INGOTS_COPPER), 185, List.of(
            new CompatEntry(SIMPLEORES, () -> SimpleOresArmorMaterial.COPPER, () -> SimpleOresTiers.COPPER.getUses()),
            new CompatEntry(ICE_AND_FIRE, () -> IafItemRegistry.COPPER_ARMOR_MATERIAL, () -> IafItemRegistry.COPPER_TOOL_MATERIAL.getUses()))),
    TIN(8, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_TIN), 220, SIMPLEORES, () -> SimpleOresArmorMaterial.TIN, () -> SimpleOresTiers.TIN.getUses()),
    MYTHRIL(12, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_MYTHRIL), 800, SIMPLEORES, () -> SimpleOresArmorMaterial.MYTHRIL, () -> SimpleOresTiers.MYTHRIL.getUses()),
    ADAMANTIUM(3, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ADAMANTIUM), 1150, SIMPLEORES, () -> SimpleOresArmorMaterial.ADAMANTIUM, () -> SimpleOresTiers.ADAMANTIUM.getUses()),
    ONYX(15, ARMOR_EQUIP_GOLD, () -> Ingredient.of(GEMS_ONYX), 3280, SIMPLEORES, () -> SimpleOresArmorMaterial.ONYX, () -> SimpleOresTiers.ONYX.getUses()),

    // Undergarden
    CLOGGRUM(10, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_CLOGGRUM), 286, UNDERGARDEN, () -> UGArmorMaterials.CLOGGRUM, () -> UGItemTiers.CLOGGRUM.getUses()),
    FROSTSTEEL(15, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_FROSTSTEEL), 575, UNDERGARDEN, () -> UGArmorMaterials.FROSTSTEEL, () -> UGItemTiers.FROSTSTEEL.getUses()),
    UTHERIUM(13, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(INGOTS_UTHERIUM), 1279, UNDERGARDEN, () -> UGArmorMaterials.UTHERIUM, () -> UGItemTiers.UTHERIUM.getUses()),
    // Blue Skies
    PYROPE(12, ARMOR_EQUIP_IRON, () -> Ingredient.of(GEMS_PYROPE), 200, BLUE_SKIES, () -> SkiesArmorMaterial.PYROPE, () -> SkiesItemTier.PYROPE.getUses()),
    AQUITE(9, ARMOR_EQUIP_IRON, () -> Ingredient.of(GEMS_AQUITE), 270, BLUE_SKIES, () -> SkiesArmorMaterial.AQUITE, () -> SkiesItemTier.AQUITE.getUses()),
    HORIZONITE(12, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_HORIZONITE), 250, BLUE_SKIES, () -> SkiesArmorMaterial.HORIZONITE, () -> SkiesItemTier.HORIZONITE.getUses()),
    DIOPSIDE(9, ARMOR_EQUIP_GOLD, () -> Ingredient.of(GEMS_DIOPSIDE), 1661, BLUE_SKIES, () -> SkiesArmorMaterial.DIOPSIDE, () -> SkiesItemTier.DIOPSIDE.getUses()),
    CHAROITE(10, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(GEMS_CHAROITE), Tiers.DIAMOND.getUses(), BLUE_SKIES, () -> SkiesArmorMaterial.CHAROITE, () -> SkiesItemTier.CHAROITE.getUses()),
    // Voidscape
    VOIDIC_CRYSTAL(9, ARMOR_EQUIP_DIAMOND, Ingredient::of, 2538, VOIDSCAPE, () -> ((ArmorItem) ModArmors.VOIDIC_CRYSTAL_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.VOIDIC_CRYSTAL.getUses()),
    CORRUPT(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 3041, VOIDSCAPE, () -> ((ArmorItem) ModArmors.CORRUPT_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.CORRUPT.getUses()),
    TITANITE(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 3544, VOIDSCAPE, () -> ((ArmorItem) ModArmors.TITANITE_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.TITANITE.getUses()),
    ICHOR(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 4047, VOIDSCAPE, () -> ((ArmorItem) ModArmors.ICHOR_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.ICHOR.getUses()),
    ASTRAL(9, ARMOR_EQUIP_DIAMOND, Ingredient::of, 4550, VOIDSCAPE, () -> ((ArmorItem) ModArmors.ASTRAL_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.ASTRAL.getUses()),
    // Midnight
    ROCKSHROOM(5, ARMOR_EQUIP_GENERIC, Ingredient::of, 250, MIDNIGHT, () -> MnArmorMaterials.ROCKSHROOM.get()),
    TENEBRUM(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 1860, MIDNIGHT, () -> MnArmorMaterials.TENEBRUM.get(), () -> MnTiers.TENEBRUM.getUses()),
    // Deeper and Darker
    RESONARIUM(10, ARMOR_EQUIP_IRON, Ingredient::of, 1193, DEEPER_AND_DARKER, () -> DDArmorMaterials.RESONARIUM, () -> DDTiers.RESONARIUM.getUses()),
    WARDEN(18, ARMOR_EQUIP_NETHERITE, Ingredient::of, 2519, DEEPER_AND_DARKER, () -> DDArmorMaterials.WARDEN, () -> DDTiers.WARDEN.getUses()),

    // Botania
    MANASTEEL(18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_MANASTEEL), 300, BOTANIA, () -> BotaniaAPI.instance().getManasteelArmorMaterial(), () -> BotaniaAPI.instance().getManasteelItemTier().getUses()),
    ELEMENTIUM(18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ELEMENTIUM), 720, BOTANIA, () -> BotaniaAPI.instance().getElementiumArmorMaterial(), () -> BotaniaAPI.instance().getElementiumItemTier().getUses()),
    MANAWEAVE(18, ARMOR_EQUIP_LEATHER, Ingredient::of, 120, BOTANIA, () -> BotaniaAPI.instance().getManaweaveArmorMaterial()),
    TERRASTEEL(26, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(INGOTS_TERRASTEEL), 2300, BOTANIA, () -> BotaniaAPI.instance().getTerrasteelArmorMaterial(), () -> BotaniaAPI.instance().getTerrasteelItemTier().getUses()),

    // Create
    CARDBOARD(25, ARMOR_EQUIP_LEATHER, Ingredient::of, 51, CREATE, () -> AllArmorMaterials.CARDBOARD),
    // Redstone Arsenal
    FLUX(18, ARMOR_EQUIP_GOLD, Ingredient::of, 0, REDSTONE_ARSENAL, () -> ModItems.FLUX_ARMOR, () -> ModItems.MATERIAL_FLUX_METAL.getUses()),
    // Thermal Series
    BEEKEEPER(16, ARMOR_EQUIP_ELYTRA, Ingredient::of, 51, THERMAL, () -> TCoreItems.BEEKEEPER),
    DIVING(20, ARMOR_EQUIP_CHAIN, Ingredient::of, 163, THERMAL, () -> TCoreItems.DIVING),
    HAZMAT(15, ARMOR_EQUIP_LEATHER, Ingredient::of, 67, THERMAL, () -> TCoreItems.HAZMAT),
    // Thermal Extra
    SIGNALUM(15, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_SIGNALUM), 1751, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SIGNALUM, () -> ThermalExtraTiers.SIGNALUM.getUses()),
    LUMIUM(22, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_LUMIUM), 1751, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.LUMIUM, () -> ThermalExtraTiers.LUMIUM.getUses()),
    ENDERIUM(15, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ENDERIUM), 1961, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.ENDERIUM, () -> ThermalExtraTiers.ENDERIUM.getUses()),
    SOUL_INFUSED(24, ARMOR_EQUIP_ELYTRA, () -> Ingredient.of(INGOTS_SOUL_INFUSED), 1751, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SOUL_INFUSED, () -> ThermalExtraTiers.SOUL_INFUSED.getUses()),
    SHELLITE(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_SHELLITE), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SHELLITE, () -> ThermalExtraTiers.SHELLITE.getUses()),
    TWINITE(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_TWINITE), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.TWINITE, () -> ThermalExtraTiers.TWINITE.getUses()),
    DRAGONSTEEL(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_DRAGONSTEEL), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.DRAGONSTEEL, () -> ThermalExtraTiers.DRAGONSTEEL.getUses()),
    ABYSSAL(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_ABYSSAL), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.ABYSSAL, () -> ThermalExtraTiers.ABYSSAL.getUses()),
    // Mekanism Tools
    BRONZE(10, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_BRONZE), 375, MEKANISM_TOOLS, () -> ToolsItems.BRONZE_BOOTS.get().getMaterial(), () -> ToolsItems.BRONZE_AXE.get().getTier().getUses()),
    LAPIS_LAZULI(32, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Tags.Items.GEMS_LAPIS), 128, MEKANISM_TOOLS, () -> ToolsItems.LAPIS_LAZULI_BOOTS.get().getMaterial(), () -> ToolsItems.LAPIS_LAZULI_AXE.get().getTier().getUses()),
    OSMIUM(14, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_OSMIUM), 1024, MEKANISM_TOOLS, () -> ToolsItems.OSMIUM_BOOTS.get().getMaterial(), () -> ToolsItems.OSMIUM_AXE.get().getTier().getUses()),
    REFINED_GLOWSTONE(20, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_REFINED_GLOWSTONE), 384, MEKANISM_TOOLS, () -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get().getMaterial(), () -> ToolsItems.REFINED_GLOWSTONE_AXE.get().getTier().getUses()),
    REFINED_OBSIDIAN(18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_REFINED_OBSIDIAN), 4096, MEKANISM_TOOLS, () -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get().getMaterial(), () -> ToolsItems.REFINED_OBSIDIAN_AXE.get().getTier().getUses()),
    STEEL(16, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_STEEL), 500, MEKANISM_TOOLS, () -> ToolsItems.STEEL_BOOTS.get().getMaterial(), () -> ToolsItems.STEEL_AXE.get().getTier().getUses()),

    // Ice and Fire
    SHEEP_DISGUISE(15, ARMOR_EQUIP_LEATHER, Ingredient::of, Tiers.WOOD.getUses(), ICE_AND_FIRE, () -> IafItemRegistry.SHEEP_ARMOR_MATERIAL),
    FIRE_DRAGONSTEEL(30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_FIRE.getUses()),
    ICE_DRAGONSTEEL(30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_ICE.getUses()),
    LIGHTNING_DRAGONSTEEL(30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_LIGHTNING.getUses()),
    SEA_SERPENT_SCALE(25, ARMOR_EQUIP_GOLD, Ingredient::of, 1279, ICE_AND_FIRE, () -> EnumSeaSerpent.BLUE.armorMaterial),
    ;
    @SuppressWarnings("deprecation")
    public static final EnumCodec<CompatArmorMaterial> CODEC = StringRepresentable.fromEnum(CompatArmorMaterial::values);
    private final String name = name().toLowerCase(Locale.ROOT);
    private final CompatModule compatModule;
    private final Supplier<ArmorMaterial> armorMaterial;
    private final IntSupplier uses;

    CompatArmorMaterial(int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int defaultUses, List<CompatEntry> compatEntries) {
        var compatEntry = compatEntries.stream()
                .filter(entry -> entry.compatModule.isLoaded())
                .findFirst()
                .orElse(compatEntries.get(0));
        this.compatModule = compatEntry.compatModule;
        this.armorMaterial = compatModule.isLoaded()
                ? Suppliers.memoize(compatEntry.armorMaterial::get)
                : Suppliers.memoize(() -> new FallbackArmorMaterial(name, enchantmentValue, sound, repairIngredient));
        this.uses = compatModule.isLoaded() ? compatEntry.uses : () -> defaultUses;
    }

    CompatArmorMaterial(int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int defaultUses, CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial, IntSupplier uses) {
        this(enchantmentValue, sound, repairIngredient, defaultUses, List.of(new CompatEntry(compatModule, armorMaterial, uses)));
    }

    CompatArmorMaterial(int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int uses, CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial) {
        this(enchantmentValue, sound, repairIngredient, uses, compatModule, armorMaterial, () -> uses);
    }

    public CompatModule getCompatModule() {
        return compatModule;
    }

    public ArmorMaterial getArmorMaterial() {
        return armorMaterial.get();
    }

    public int getUses() {
        return uses.getAsInt();
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    public record CompatEntry(CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial, IntSupplier uses) {
    }
}
