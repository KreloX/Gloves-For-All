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
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Tiers;
import net.orcinus.galosphere.init.GItems;
import quek.undergarden.registry.UGArmorMaterials;
import quek.undergarden.registry.UGItemTiers;
import tamaized.voidscape.registry.ModArmors;
import tamaized.voidscape.registry.ModTools;
import vazkii.botania.api.BotaniaAPI;

import java.util.Locale;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static krelox.gloves_for_all.item.CompatModule.*;

public enum CompatArmorMaterial implements StringRepresentable {
    // Caverns & Chasms
    SILVER(CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.SILVER, () -> CCTiers.CCItemTiers.SILVER.getUses()),
    NECROMIUM(CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.NECROMIUM, () -> CCTiers.CCItemTiers.NECROMIUM.getUses()),
    SANGUINE(CAVERNS_AND_CHASMS, () -> CCTiers.CCArmorMaterials.SANGUINE, () -> 989),
    // Savage & Ravage
    GRIEFER(SAVAGE_AND_RAVAGE, () -> SRTiers.GRIEFER, () -> 250),
    // Oreganized
    ELECTRUM(OREGANIZED, () -> OArmorMaterials.ELECTRUM, () -> OItemTiers.ELECTRUM.getUses()),
    // Galosphere
    STERLING(GALOSPHERE, () -> ((ArmorItem) GItems.STERLING_BOOTS.get()).getMaterial(), () -> 163),
    // Additional Additions
    ROSE_GOLD(ADDITIONAL_ADDITIONS, () -> AdditionalRegistry.ROSE_GOLD_ARMOR_MATERIAL, () -> RoseGoldToolMaterial.MATERIAL.getUses()),
    GILDED_NETHERITE(ADDITIONAL_ADDITIONS, () -> AdditionalRegistry.GILDED_NETHERITE_ARMOR_MATERIAL, () -> GildedNetheriteToolMaterial.MATERIAL.getUses()),
    // SimpleOres
    COPPER(SIMPLEORES, () -> SimpleOresArmorMaterial.COPPER, () -> SimpleOresTiers.COPPER.getUses()),
    TIN(SIMPLEORES, () -> SimpleOresArmorMaterial.TIN, () -> SimpleOresTiers.TIN.getUses()),
    MYTHRIL(SIMPLEORES, () -> SimpleOresArmorMaterial.MYTHRIL, () -> SimpleOresTiers.MYTHRIL.getUses()),
    ADAMANTIUM(SIMPLEORES, () -> SimpleOresArmorMaterial.ADAMANTIUM, () -> SimpleOresTiers.ADAMANTIUM.getUses()),
    ONYX(SIMPLEORES, () -> SimpleOresArmorMaterial.ONYX, () -> SimpleOresTiers.ONYX.getUses()),

    // Undergarden
    CLOGGRUM(UNDERGARDEN, () -> UGArmorMaterials.CLOGGRUM, () -> UGItemTiers.CLOGGRUM.getUses()),
    FROSTSTEEL(UNDERGARDEN, () -> UGArmorMaterials.FROSTSTEEL, () -> UGItemTiers.FROSTSTEEL.getUses()),
    UTHERIUM(UNDERGARDEN, () -> UGArmorMaterials.UTHERIUM, () -> UGItemTiers.UTHERIUM.getUses()),
    // Blue Skies
    PYROPE(BLUE_SKIES, () -> SkiesArmorMaterial.PYROPE, () -> SkiesItemTier.PYROPE.getUses()),
    AQUITE(BLUE_SKIES, () -> SkiesArmorMaterial.AQUITE, () -> SkiesItemTier.AQUITE.getUses()),
    HORIZONITE(BLUE_SKIES, () -> SkiesArmorMaterial.HORIZONITE, () -> SkiesItemTier.HORIZONITE.getUses()),
    DIOPSIDE(BLUE_SKIES, () -> SkiesArmorMaterial.DIOPSIDE, () -> SkiesItemTier.DIOPSIDE.getUses()),
    CHAROITE(BLUE_SKIES, () -> SkiesArmorMaterial.CHAROITE, () -> SkiesItemTier.CHAROITE.getUses()),
    // Voidscape
    VOIDIC_CRYSTAL(VOIDSCAPE, () -> ((ArmorItem) ModArmors.VOIDIC_CRYSTAL_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.VOIDIC_CRYSTAL.getUses()),
    CORRUPT(VOIDSCAPE, () -> ((ArmorItem) ModArmors.CORRUPT_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.CORRUPT.getUses()),
    TITANITE(VOIDSCAPE, () -> ((ArmorItem) ModArmors.TITANITE_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.TITANITE.getUses()),
    ICHOR(VOIDSCAPE, () -> ((ArmorItem) ModArmors.ICHOR_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.ICHOR.getUses()),
    ASTRAL(VOIDSCAPE, () -> ((ArmorItem) ModArmors.ASTRAL_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.ASTRAL.getUses()),
    // Midnight
    ROCKSHROOM(MIDNIGHT, () -> MnArmorMaterials.ROCKSHROOM.get(), () -> 250),
    TENEBRUM(MIDNIGHT, () -> MnArmorMaterials.TENEBRUM.get(), () -> MnTiers.TENEBRUM.getUses()),
    // Deeper and Darker
    RESONARIUM(DEEPER_AND_DARKER, () -> DDArmorMaterials.RESONARIUM, () -> DDTiers.RESONARIUM.getUses()),
    WARDEN(DEEPER_AND_DARKER, () -> DDArmorMaterials.WARDEN, () -> DDTiers.WARDEN.getUses()),

    // Botania
    MANASTEEL(BOTANIA, () -> BotaniaAPI.instance().getManasteelArmorMaterial(), () -> BotaniaAPI.instance().getManasteelItemTier().getUses()),
    ELEMENTIUM(BOTANIA, () -> BotaniaAPI.instance().getElementiumArmorMaterial(), () -> BotaniaAPI.instance().getElementiumItemTier().getUses()),
    MANAWEAVE(BOTANIA, () -> BotaniaAPI.instance().getManaweaveArmorMaterial(), () -> 120),
    TERRASTEEL(BOTANIA, () -> BotaniaAPI.instance().getTerrasteelArmorMaterial(), () -> BotaniaAPI.instance().getTerrasteelItemTier().getUses()),

    // Create
    CARDBOARD(CREATE, () -> AllArmorMaterials.CARDBOARD, () -> 51),
    // Redstone Arsenal
    FLUX(REDSTONE_ARSENAL, () -> ModItems.FLUX_ARMOR, () -> ModItems.MATERIAL_FLUX_METAL.getUses()),
    // Thermal Series
    BEEKEEPER(THERMAL, () -> TCoreItems.BEEKEEPER, () -> 51),
    DIVING(THERMAL, () -> TCoreItems.DIVING, () -> 163),
    HAZMAT(THERMAL, () -> TCoreItems.HAZMAT, () -> 67),
    // Thermal Extra
    SIGNALUM(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SIGNALUM, () -> ThermalExtraTiers.SIGNALUM.getUses()),
    LUMIUM(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.LUMIUM, () -> ThermalExtraTiers.LUMIUM.getUses()),
    ENDERIUM(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.ENDERIUM, () -> ThermalExtraTiers.ENDERIUM.getUses()),
    SOUL_INFUSED(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SOUL_INFUSED, () -> ThermalExtraTiers.SOUL_INFUSED.getUses()),
    SHELLITE(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.SHELLITE, () -> ThermalExtraTiers.SHELLITE.getUses()),
    TWINITE(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.TWINITE, () -> ThermalExtraTiers.TWINITE.getUses()),
    DRAGONSTEEL(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.DRAGONSTEEL, () -> ThermalExtraTiers.DRAGONSTEEL.getUses()),
    ABYSSAL(THERMAL_EXTRA, () -> ThermalExtraArmorMaterials.ABYSSAL, () -> ThermalExtraTiers.ABYSSAL.getUses()),
    // Mekanism Tools
    BRONZE(MEKANISM_TOOLS, () -> ToolsItems.BRONZE_BOOTS.get().getMaterial(), () -> ToolsItems.BRONZE_AXE.get().getTier().getUses()),
    LAPIS_LAZULI(MEKANISM_TOOLS, () -> ToolsItems.LAPIS_LAZULI_BOOTS.get().getMaterial(), () -> ToolsItems.LAPIS_LAZULI_AXE.get().getTier().getUses()),
    OSMIUM(MEKANISM_TOOLS, () -> ToolsItems.OSMIUM_BOOTS.get().getMaterial(), () -> ToolsItems.OSMIUM_AXE.get().getTier().getUses()),
    REFINED_GLOWSTONE(MEKANISM_TOOLS, () -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get().getMaterial(), () -> ToolsItems.REFINED_GLOWSTONE_AXE.get().getTier().getUses()),
    REFINED_OBSIDIAN(MEKANISM_TOOLS, () -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get().getMaterial(), () -> ToolsItems.REFINED_OBSIDIAN_AXE.get().getTier().getUses()),
    STEEL(MEKANISM_TOOLS, () -> ToolsItems.STEEL_BOOTS.get().getMaterial(), () -> ToolsItems.STEEL_AXE.get().getTier().getUses()),

    // Ice and Fire
    IAF_SILVER("silver", ICE_AND_FIRE, () -> IafItemRegistry.SILVER_ARMOR_MATERIAL, () -> IafItemRegistry.SILVER_TOOL_MATERIAL.getUses()),
    IAF_COPPER("copper", ICE_AND_FIRE, () -> IafItemRegistry.COPPER_ARMOR_MATERIAL, () -> IafItemRegistry.COPPER_TOOL_MATERIAL.getUses()),
    SHEEP_DISGUISE(ICE_AND_FIRE, () -> IafItemRegistry.SHEEP_ARMOR_MATERIAL, () -> 59),
    FIRE_DRAGONSTEEL(ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_FIRE.getUses()),
    ICE_DRAGONSTEEL(ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_ICE.getUses()),
    LIGHTNING_DRAGONSTEEL(ICE_AND_FIRE, () -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_LIGHTNING.getUses()),
    SEA_SERPENT_SCALE(ICE_AND_FIRE, () -> EnumSeaSerpent.BLUE.armorMaterial, () -> 1279),
    ;
    @SuppressWarnings("deprecation")
    public static final EnumCodec<CompatArmorMaterial> CODEC = StringRepresentable.fromEnum(CompatArmorMaterial::values);
    private final String name;
    private final String uniqueName;
    private final CompatModule compatModule;
    private final Supplier<ArmorMaterial> armorMaterial;
    private final IntSupplier uses;

    CompatArmorMaterial(String name, CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial, IntSupplier uses) {
        this.name = name;
        this.uniqueName = compatModule.getSourceModId() + '/' + name;
        this.compatModule = compatModule;
        this.armorMaterial = compatModule.isLoaded() ? Suppliers.memoize(armorMaterial::get) : () -> ArmorMaterials.IRON;
        this.uses = compatModule.isLoaded() ? uses : Tiers.IRON::getUses;
    }

    CompatArmorMaterial(CompatModule compatModule, Supplier<ArmorMaterial> armorMaterial, IntSupplier uses) {
        this.name = name().toLowerCase(Locale.ROOT);
        this.uniqueName = compatModule.getSourceModId() + '/' + name;
        this.compatModule = compatModule;
        this.armorMaterial = compatModule.isLoaded() ? Suppliers.memoize(armorMaterial::get) : () -> ArmorMaterials.IRON;
        this.uses = compatModule.isLoaded() ? uses : Tiers.IRON::getUses;
    }

    public String getName() {
        return name;
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
        return uniqueName;
    }
}
