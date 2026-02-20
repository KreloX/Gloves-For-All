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
import net.minecraft.world.item.*;
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
import java.util.Optional;
import java.util.function.Supplier;

import static krelox.gloves_for_all.GlovesTags.Items.*;
import static krelox.gloves_for_all.item.CompatModule.*;
import static net.minecraft.sounds.SoundEvents.*;

public enum CompatArmorMaterial implements StringRepresentable {
    // Caverns & Chasms
    SILVER(17, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_SILVER), 157, List.of(
            new CompatEntry(CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.SILVER, tier(() -> CCTiers.CCItemTiers.SILVER)),
            new CompatEntry(ICE_AND_FIRE, () -> IafItemRegistry.SILVER_ARMOR_MATERIAL, tier(() -> IafItemRegistry.SILVER_TOOL_MATERIAL)))),
    NECROMIUM(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_NECROMIUM), Tiers.NETHERITE.getUses(), CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.NECROMIUM, tier(() -> CCTiers.CCItemTiers.NECROMIUM)),
    SANGUINE(17, ARMOR_EQUIP_IRON, Ingredient::of, 989, CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.SANGUINE),
    // Savage & Ravage
    GRIEFER(15, ARMOR_EQUIP_IRON, Ingredient::of, Tiers.IRON.getUses(), SAVAGE_AND_RAVAGE, () -> SRTiers.GRIEFER),
    // Oreganized
    ELECTRUM(20, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_ELECTRUM), Tiers.DIAMOND.getUses(), OREGANIZED, () -> OArmorMaterials.ELECTRUM, tier(() -> OItemTiers.ELECTRUM)),
    // Galosphere
    STERLING(9, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_SILVER), 163, GALOSPHERE, () -> ((ArmorItem) GItems.STERLING_BOOTS.get()).getMaterial()),
    // Additional Additions
    ROSE_GOLD(17, ARMOR_EQUIP_GOLD, () -> Ingredient.of(Tags.Items.INGOTS_COPPER), 900, ADDITIONAL_ADDITIONS, () -> AdditionalRegistry.ROSE_GOLD_ARMOR_MATERIAL, tier(() -> RoseGoldToolMaterial.MATERIAL)),
    GILDED_NETHERITE(20, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), 2031, ADDITIONAL_ADDITIONS, () -> AdditionalRegistry.GILDED_NETHERITE_ARMOR_MATERIAL, tier(() -> GildedNetheriteToolMaterial.MATERIAL)),
    // SimpleOres
    COPPER(8, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Tags.Items.INGOTS_COPPER), 185, List.of(
            new CompatEntry(SIMPLEORES, () -> SimpleOresArmorMaterial.COPPER, tier(() -> SimpleOresTiers.COPPER)),
            new CompatEntry(ICE_AND_FIRE, () -> IafItemRegistry.COPPER_ARMOR_MATERIAL, tier(() -> IafItemRegistry.COPPER_TOOL_MATERIAL)))),
    TIN(8, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_TIN), 220, SIMPLEORES, () -> SimpleOresArmorMaterial.TIN, tier(() -> SimpleOresTiers.TIN)),
    MYTHRIL(12, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_MYTHRIL), 800, SIMPLEORES, () -> SimpleOresArmorMaterial.MYTHRIL, tier(() -> SimpleOresTiers.MYTHRIL)),
    ADAMANTIUM(3, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ADAMANTIUM), 1150, SIMPLEORES, () -> SimpleOresArmorMaterial.ADAMANTIUM, tier(() -> SimpleOresTiers.ADAMANTIUM)),
    ONYX(15, ARMOR_EQUIP_GOLD, () -> Ingredient.of(GEMS_ONYX), 3280, SIMPLEORES, () -> SimpleOresArmorMaterial.ONYX, tier(() -> SimpleOresTiers.ONYX)),

    // Undergarden
    CLOGGRUM(10, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_CLOGGRUM), 286, UNDERGARDEN, () -> UGArmorMaterials.CLOGGRUM, tier(() -> UGItemTiers.CLOGGRUM)),
    FROSTSTEEL(15, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_FROSTSTEEL), 575, UNDERGARDEN, () -> UGArmorMaterials.FROSTSTEEL, tier(() -> UGItemTiers.FROSTSTEEL)),
    UTHERIUM(13, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(INGOTS_UTHERIUM), 1279, UNDERGARDEN, () -> UGArmorMaterials.UTHERIUM, tier(() -> UGItemTiers.UTHERIUM)),
    // Blue Skies
    PYROPE(12, ARMOR_EQUIP_IRON, () -> Ingredient.of(GEMS_PYROPE), 200, BLUE_SKIES, () -> SkiesArmorMaterial.PYROPE, tier(() -> SkiesItemTier.PYROPE)),
    AQUITE(9, ARMOR_EQUIP_IRON, () -> Ingredient.of(GEMS_AQUITE), 270, BLUE_SKIES, () -> SkiesArmorMaterial.AQUITE, tier(() -> SkiesItemTier.AQUITE)),
    HORIZONITE(12, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_HORIZONITE), 250, BLUE_SKIES, () -> SkiesArmorMaterial.HORIZONITE, tier(() -> SkiesItemTier.HORIZONITE)),
    DIOPSIDE(9, ARMOR_EQUIP_GOLD, () -> Ingredient.of(GEMS_DIOPSIDE), 1661, BLUE_SKIES, () -> SkiesArmorMaterial.DIOPSIDE, tier(() -> SkiesItemTier.DIOPSIDE)),
    CHAROITE(10, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(GEMS_CHAROITE), Tiers.DIAMOND.getUses(), BLUE_SKIES, () -> SkiesArmorMaterial.CHAROITE, tier(() -> SkiesItemTier.CHAROITE)),
    // Voidscape
    VOIDIC_CRYSTAL(9, ARMOR_EQUIP_DIAMOND, Ingredient::of, 2538, VOIDSCAPE, () -> ((ArmorItem) ModArmors.VOIDIC_CRYSTAL_BOOTS.get()).getMaterial(), tier(() -> ((TieredItem) ModTools.VOIDIC_CRYSTAL_AXE.get()).getTier())),
    CORRUPT(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 3041, VOIDSCAPE, () -> ((ArmorItem) ModArmors.CORRUPT_BOOTS.get()).getMaterial(), tier(() -> ((TieredItem) ModTools.CORRUPT_AXE.get()).getTier())),
    TITANITE(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 3544, VOIDSCAPE, () -> ((ArmorItem) ModArmors.TITANITE_BOOTS.get()).getMaterial(), tier(() -> ((TieredItem) ModTools.TITANITE_AXE.get()).getTier())),
    ICHOR(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 4047, VOIDSCAPE, () -> ((ArmorItem) ModArmors.ICHOR_BOOTS.get()).getMaterial(), tier(() -> ((TieredItem) ModTools.ICHOR_AXE.get()).getTier())),
    ASTRAL(9, ARMOR_EQUIP_DIAMOND, Ingredient::of, 4550, VOIDSCAPE, () -> ((ArmorItem) ModArmors.ASTRAL_BOOTS.get()).getMaterial(), tier(() -> ((TieredItem) ModTools.ASTRAL_AXE.get()).getTier())),
    // Midnight
    ROCKSHROOM(5, ARMOR_EQUIP_GENERIC, Ingredient::of, 250, MIDNIGHT, () -> MnArmorMaterials.ROCKSHROOM.get()),
    TENEBRUM(9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 1860, MIDNIGHT, () -> MnArmorMaterials.TENEBRUM.get(), tier(() -> MnTiers.TENEBRUM)),
    // Deeper and Darker
    RESONARIUM(10, ARMOR_EQUIP_IRON, Ingredient::of, 1193, DEEPER_AND_DARKER, () -> DDArmorMaterials.RESONARIUM, tier(() -> DDTiers.RESONARIUM)),
    WARDEN(18, ARMOR_EQUIP_NETHERITE, Ingredient::of, 2519, DEEPER_AND_DARKER, () -> DDArmorMaterials.WARDEN, tier(() -> DDTiers.WARDEN)),

    // Botania
    MANASTEEL(18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_MANASTEEL), 300, BOTANIA, () -> BotaniaAPI.instance().getManasteelArmorMaterial(), tier(() -> BotaniaAPI.instance().getManasteelItemTier())),
    ELEMENTIUM(18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ELEMENTIUM), 720, BOTANIA, () -> BotaniaAPI.instance().getElementiumArmorMaterial(), tier(() -> BotaniaAPI.instance().getElementiumItemTier())),
    MANAWEAVE(18, ARMOR_EQUIP_LEATHER, Ingredient::of, 120, BOTANIA, () -> BotaniaAPI.instance().getManaweaveArmorMaterial()),
    TERRASTEEL(26, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(INGOTS_TERRASTEEL), 2300, BOTANIA, () -> BotaniaAPI.instance().getTerrasteelArmorMaterial(), tier(() -> BotaniaAPI.instance().getTerrasteelItemTier())),

    // Create
    CARDBOARD(25, ARMOR_EQUIP_LEATHER, Ingredient::of, 51, CREATE, () -> AllArmorMaterials.CARDBOARD),
    // Redstone Arsenal
    FLUX(18, ARMOR_EQUIP_GOLD, Ingredient::of, 0, REDSTONE_ARSENAL, () -> ModItems.FLUX_ARMOR, tier(() -> ModItems.MATERIAL_FLUX_METAL)),
    // Thermal Series
    BEEKEEPER(16, ARMOR_EQUIP_ELYTRA, Ingredient::of, 51, THERMAL, () -> TCoreItems.BEEKEEPER),
    DIVING(20, ARMOR_EQUIP_CHAIN, Ingredient::of, 163, THERMAL, () -> TCoreItems.DIVING),
    HAZMAT(15, ARMOR_EQUIP_LEATHER, Ingredient::of, 67, THERMAL, () -> TCoreItems.HAZMAT),
    // Thermal Extra
    SIGNALUM(15, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_SIGNALUM), 1751, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SIGNALUM, tier(() -> ThermalExtraTiers.SIGNALUM)),
    LUMIUM(22, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_LUMIUM), 1751, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.LUMIUM, tier(() -> ThermalExtraTiers.LUMIUM)),
    ENDERIUM(15, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ENDERIUM), 1961, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.ENDERIUM, tier(() -> ThermalExtraTiers.ENDERIUM)),
    SOUL_INFUSED(24, ARMOR_EQUIP_ELYTRA, () -> Ingredient.of(INGOTS_SOUL_INFUSED), 1751, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SOUL_INFUSED, tier(() -> ThermalExtraTiers.SOUL_INFUSED)),
    SHELLITE(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_SHELLITE), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SHELLITE, tier(() -> ThermalExtraTiers.SHELLITE)),
    TWINITE(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_TWINITE), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.TWINITE, tier(() -> ThermalExtraTiers.TWINITE)),
    DRAGONSTEEL(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_DRAGONSTEEL), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.DRAGONSTEEL, tier(() -> ThermalExtraTiers.DRAGONSTEEL)),
    ABYSSAL(15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_ABYSSAL), 2001, THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.ABYSSAL, tier(() -> ThermalExtraTiers.ABYSSAL)),
    // Mekanism Tools
    BRONZE(10, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_BRONZE), 375, MEKANISM_TOOLS, () -> ToolsItems.BRONZE_BOOTS.get().getMaterial(), tier(() -> ToolsItems.BRONZE_AXE.get().getTier())),
    LAPIS_LAZULI(32, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Tags.Items.GEMS_LAPIS), 128, MEKANISM_TOOLS, () -> ToolsItems.LAPIS_LAZULI_BOOTS.get().getMaterial(), tier(() -> ToolsItems.LAPIS_LAZULI_AXE.get().getTier())),
    OSMIUM(14, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_OSMIUM), 1024, MEKANISM_TOOLS, () -> ToolsItems.OSMIUM_BOOTS.get().getMaterial(), tier(() -> ToolsItems.OSMIUM_AXE.get().getTier())),
    REFINED_GLOWSTONE(20, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_REFINED_GLOWSTONE), 384, MEKANISM_TOOLS, () -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get().getMaterial(), tier(() -> ToolsItems.REFINED_GLOWSTONE_AXE.get().getTier())),
    REFINED_OBSIDIAN(18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_REFINED_OBSIDIAN), 4096, MEKANISM_TOOLS, () -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get().getMaterial(), tier(() -> ToolsItems.REFINED_OBSIDIAN_AXE.get().getTier())),
    STEEL(16, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_STEEL), 500, MEKANISM_TOOLS, () -> ToolsItems.STEEL_BOOTS.get().getMaterial()),

    // Ice and Fire
    SHEEP_DISGUISE(15, ARMOR_EQUIP_LEATHER, Ingredient::of, Tiers.WOOD.getUses(), ICE_AND_FIRE, () -> IafItemRegistry.SHEEP_ARMOR_MATERIAL),
    FIRE_DRAGONSTEEL(30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL, tier(() -> DragonSteelTier.DRAGONSTEEL_TIER_FIRE)),
    ICE_DRAGONSTEEL(30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL, tier(() -> DragonSteelTier.DRAGONSTEEL_TIER_ICE)),
    LIGHTNING_DRAGONSTEEL(30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, tier(() -> DragonSteelTier.DRAGONSTEEL_TIER_LIGHTNING)),
    SEA_SERPENT_SCALE(25, ARMOR_EQUIP_GOLD, Ingredient::of, 1279, ICE_AND_FIRE, () -> EnumSeaSerpent.BLUE.armorMaterial),
    ;
    @SuppressWarnings("deprecation")
    public static final EnumCodec<CompatArmorMaterial> CODEC = StringRepresentable.fromEnum(CompatArmorMaterial::values);
    private final String name = name().toLowerCase(Locale.ROOT);
    private final int uses;
    private final CompatModule compatModule;
    private final Supplier<ArmorMaterial> armorMaterial;
    private final Supplier<Optional<Tier>> itemTier;

    CompatArmorMaterial(int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int uses, List<CompatEntry> compatEntries) {
        this.uses = uses;
        var compatEntry = compatEntries.stream()
                .filter(entry -> entry.compatModule.isLoaded())
                .findFirst()
                .orElse(compatEntries.get(0));
        this.compatModule = compatEntry.compatModule;
        this.armorMaterial = compatModule.isLoaded()
                ? Suppliers.memoize(compatEntry.armorMaterial::get)
                : Suppliers.memoize(() -> new FallbackArmorMaterial(name, enchantmentValue, sound, repairIngredient));
        this.itemTier = compatModule.isLoaded() ? Suppliers.memoize(compatEntry.toolTier::get) : noTier();
    }

    CompatArmorMaterial(int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int uses, CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial, Supplier<Optional<Tier>> itemTier) {
        this(enchantmentValue, sound, repairIngredient, uses, List.of(new CompatEntry(compatModule, armorMaterial, itemTier)));
    }

    CompatArmorMaterial(int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int uses, CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial) {
        this(enchantmentValue, sound, repairIngredient, uses, compatModule, armorMaterial, noTier());
    }

    public int getUses() {
        return getItemTier().map(Tier::getUses).orElse(uses);
    }

    public CompatModule getCompatModule() {
        return compatModule;
    }

    public ArmorMaterial getArmorMaterial() {
        return armorMaterial.get();
    }

    public Optional<Tier> getItemTier() {
        return itemTier.get();
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    private static Supplier<Optional<Tier>> tier(Supplier<Tier> tier) {
        return () -> Optional.of(tier.get());
    }

    private static Supplier<Optional<Tier>> noTier() {
        return Optional::empty;
    }

    public record CompatEntry(CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial,
                              Supplier<Optional<Tier>> toolTier) {
    }
}
