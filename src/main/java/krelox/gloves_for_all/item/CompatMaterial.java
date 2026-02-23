package krelox.gloves_for_all.item;

import cofh.redstonearsenal.RedstoneArsenal;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.lib.util.ThermalIDs;
import com.crypticmushroom.minecraft.midnight.common.misc.MnTiers;
import com.crypticmushroom.minecraft.midnight.common.registry.MnItems;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.item.DragonSteelTier;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTiers;
import com.legacy.blue_skies.items.util.SkiesItemTier;
import com.legacy.blue_skies.registries.SkiesItems;
import com.simibubi.create.AllItems;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.savage_and_ravage.core.registry.SRItems;
import dqu.additionaladditions.AdditionalRegistry;
import dqu.additionaladditions.material.GildedNetheriteToolMaterial;
import dqu.additionaladditions.material.RoseGoldToolMaterial;
import galena.oreganized.index.OItemTiers;
import galena.oreganized.index.OItems;
import mekanism.tools.common.registries.ToolsItems;
import mod.alexndr.simpleores.content.SimpleOresTiers;
import mod.alexndr.simpleores.init.ModItems;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTiers;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.*;
import net.orcinus.galosphere.init.GItems;
import quek.undergarden.registry.UGItemTiers;
import quek.undergarden.registry.UGItems;
import tamaized.voidscape.registry.ModArmors;
import tamaized.voidscape.registry.ModTools;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.BotaniaItems;

import java.util.Locale;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static krelox.gloves_for_all.item.CompatModule.*;

public enum CompatMaterial implements StringRepresentable {
    // Caverns & Chasms
    SILVER(CAVERNS_AND_CHASMS, true, () -> CCItems.SILVER_BOOTS.get(), () -> CCTiers.CCItemTiers.SILVER.getUses()),
    NECROMIUM(CAVERNS_AND_CHASMS, true, () -> CCItems.NECROMIUM_BOOTS.get(), () -> CCTiers.CCItemTiers.NECROMIUM.getUses()),
    SANGUINE(CAVERNS_AND_CHASMS, true, () -> CCItems.SANGUINE_BOOTS.get(), () -> 989),
    // Savage & Ravage
    GRIEFER(SAVAGE_AND_RAVAGE, false, () -> SRItems.GRIEFER_BOOTS.get(), () -> 250),
    // Oreganized
    ELECTRUM(OREGANIZED, true, () -> OItems.ELECTRUM_BOOTS.get(), () -> OItemTiers.ELECTRUM.getUses()),
    // Galosphere
    STERLING(GALOSPHERE, false, () -> GItems.STERLING_BOOTS.get(), () -> 163),
    // Additional Additions
    ROSE_GOLD(ADDITIONAL_ADDITIONS, true, () -> AdditionalRegistry.ROSE_GOLD_BOOTS.get(), () -> RoseGoldToolMaterial.MATERIAL.getUses()),
    GILDED_NETHERITE(ADDITIONAL_ADDITIONS, true, () -> AdditionalRegistry.GILDED_NETHERITE_BOOTS.get(), () -> GildedNetheriteToolMaterial.MATERIAL.getUses()),
    // SimpleOres
    COPPER(SIMPLEORES, true, () -> ModItems.copper_boots.get(), () -> SimpleOresTiers.COPPER.getUses()),
    TIN(SIMPLEORES, true, () -> ModItems.tin_boots.get(), () -> SimpleOresTiers.TIN.getUses()),
    MYTHRIL(SIMPLEORES, true, () -> ModItems.mythril_boots.get(), () -> SimpleOresTiers.MYTHRIL.getUses()),
    ADAMANTIUM(SIMPLEORES, true, () -> ModItems.adamantium_boots.get(), () -> SimpleOresTiers.ADAMANTIUM.getUses()),
    ONYX(SIMPLEORES, true, () -> ModItems.onyx_boots.get(), () -> SimpleOresTiers.ONYX.getUses()),

    // Undergarden
    CLOGGRUM(UNDERGARDEN, true, () -> UGItems.CLOGGRUM_BOOTS.get(), () -> UGItemTiers.CLOGGRUM.getUses()),
    FROSTSTEEL(UNDERGARDEN, true, () -> UGItems.FROSTSTEEL_BOOTS.get(), () -> UGItemTiers.FROSTSTEEL.getUses()),
    UTHERIUM(UNDERGARDEN, true, () -> UGItems.UTHERIUM_BOOTS.get(), () -> UGItemTiers.UTHERIUM.getUses()),
    // Blue Skies
    PYROPE(BLUE_SKIES, true, () -> SkiesItems.pyrope_boots, () -> SkiesItemTier.PYROPE.getUses()),
    AQUITE(BLUE_SKIES, true, () -> SkiesItems.aquite_boots, () -> SkiesItemTier.AQUITE.getUses()),
    HORIZONITE(BLUE_SKIES, true, () -> SkiesItems.horizonite_boots, () -> SkiesItemTier.HORIZONITE.getUses()),
    DIOPSIDE(BLUE_SKIES, true, () -> SkiesItems.diopside_boots, () -> SkiesItemTier.DIOPSIDE.getUses()),
    CHAROITE(BLUE_SKIES, true, () -> SkiesItems.charoite_boots, () -> SkiesItemTier.CHAROITE.getUses()),
    // Voidscape
    VOIDIC_CRYSTAL(VOIDSCAPE, false, () -> ModArmors.VOIDIC_CRYSTAL_BOOTS.get(), () -> ModTools.ItemTier.VOIDIC_CRYSTAL.getUses()),
    CORRUPT(VOIDSCAPE, false, () -> ModArmors.CORRUPT_BOOTS.get(), () -> ModTools.ItemTier.CORRUPT.getUses()),
    TITANITE(VOIDSCAPE, false, () -> ModArmors.TITANITE_BOOTS.get(), () -> ModTools.ItemTier.TITANITE.getUses()),
    ICHOR(VOIDSCAPE, false, () -> ModArmors.ICHOR_BOOTS.get(), () -> ModTools.ItemTier.ICHOR.getUses()),
    ASTRAL(VOIDSCAPE, false, () -> ModArmors.ASTRAL_BOOTS.get(), () -> ModTools.ItemTier.ASTRAL.getUses()),
    // Midnight
    ROCKSHROOM(MIDNIGHT, true, () -> MnItems.ROCKSHROOM_BOOTS.get(), () -> 250),
    TENEBRUM(MIDNIGHT, true, () -> MnItems.TENEBRUM_BOOTS.get(), () -> MnTiers.TENEBRUM.getUses()),
    // Deeper and Darker
    RESONARIUM(DEEPER_AND_DARKER, true, () -> DDItems.RESONARIUM_BOOTS.get(), () -> DDTiers.RESONARIUM.getUses()),
    WARDEN(DEEPER_AND_DARKER, true, () -> DDItems.WARDEN_BOOTS.get(), () -> DDTiers.WARDEN.getUses()),

    // Botania
    MANASTEEL(BOTANIA, false, () -> BotaniaItems.manasteelBoots, () -> BotaniaAPI.instance().getManasteelItemTier().getUses()),
    ELEMENTIUM(BOTANIA, false, () -> BotaniaItems.elementiumBoots, () -> BotaniaAPI.instance().getElementiumItemTier().getUses()),
    MANAWEAVE(BOTANIA, false, () -> BotaniaItems.manaweaveBoots, () -> 120),
    TERRASTEEL(BOTANIA, false, () -> BotaniaItems.terrasteelBoots, () -> BotaniaAPI.instance().getTerrasteelItemTier().getUses()),

    // Create
    CARDBOARD(CREATE, true, () -> AllItems.CARDBOARD_BOOTS.get(), () -> 51),
    // Redstone Arsenal
    FLUX(REDSTONE_ARSENAL, false, Suppliers.memoize(() -> RedstoneArsenal.ITEMS.get("flux_boots")), () -> cofh.redstonearsenal.init.registries.ModItems.MATERIAL_FLUX_METAL.getUses()),
    // Thermal Series
    BEEKEEPER(THERMAL, false, Suppliers.memoize(() -> ThermalCore.ITEMS.get(ThermalIDs.ID_BEEKEEPER_BOOTS)), () -> 51),
    DIVING(THERMAL, false, Suppliers.memoize(() -> ThermalCore.ITEMS.get(ThermalIDs.ID_DIVING_CHESTPLATE)), () -> 163),
    HAZMAT(THERMAL, false, Suppliers.memoize(() -> ThermalCore.ITEMS.get(ThermalIDs.ID_HAZMAT_CHESTPLATE)), () -> 67),
    // Thermal Extra
    SIGNALUM(THERMAL_EXTRA, true, () -> ThermalExtraItems.SIGNALUM_SET.boots().get(), () -> ThermalExtraTiers.SIGNALUM.getUses()),
    LUMIUM(THERMAL_EXTRA, true, () -> ThermalExtraItems.LUMIUM_SET.boots().get(), () -> ThermalExtraTiers.LUMIUM.getUses()),
    ENDERIUM(THERMAL_EXTRA, true, () -> ThermalExtraItems.ENDERIUM_SET.boots().get(), () -> ThermalExtraTiers.ENDERIUM.getUses()),
    SOUL_INFUSED(THERMAL_EXTRA, true, () -> ThermalExtraItems.SOUL_INFUSED_SET.boots().get(), () -> ThermalExtraTiers.SOUL_INFUSED.getUses()),
    SHELLITE(THERMAL_EXTRA, true, () -> ThermalExtraItems.SHELLITE_SET.boots().get(), () -> ThermalExtraTiers.SHELLITE.getUses()),
    TWINITE(THERMAL_EXTRA, true, () -> ThermalExtraItems.TWINITE_SET.boots().get(), () -> ThermalExtraTiers.TWINITE.getUses()),
    DRAGONSTEEL(THERMAL_EXTRA, true, () -> ThermalExtraItems.DRAGONSTEEL_SET.boots().get(), () -> ThermalExtraTiers.DRAGONSTEEL.getUses()),
    ABYSSAL(THERMAL_EXTRA, true, () -> ThermalExtraItems.ABYSSAL_SET.boots().get(), () -> ThermalExtraTiers.ABYSSAL.getUses()),
    // Mekanism Tools
    BRONZE(MEKANISM_TOOLS, true, () -> ToolsItems.BRONZE_BOOTS.get(), () -> ToolsItems.BRONZE_AXE.get().getTier().getUses()),
    LAPIS_LAZULI(MEKANISM_TOOLS, true, () -> ToolsItems.LAPIS_LAZULI_BOOTS.get(), () -> ToolsItems.LAPIS_LAZULI_AXE.get().getTier().getUses()),
    OSMIUM(MEKANISM_TOOLS, true, () -> ToolsItems.OSMIUM_BOOTS.get(), () -> ToolsItems.OSMIUM_AXE.get().getTier().getUses()),
    REFINED_GLOWSTONE(MEKANISM_TOOLS, true, () -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get(), () -> ToolsItems.REFINED_GLOWSTONE_AXE.get().getTier().getUses()),
    REFINED_OBSIDIAN(MEKANISM_TOOLS, true, () -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get(), () -> ToolsItems.REFINED_OBSIDIAN_AXE.get().getTier().getUses()),
    STEEL(MEKANISM_TOOLS, true, () -> ToolsItems.STEEL_BOOTS.get(), () -> ToolsItems.STEEL_AXE.get().getTier().getUses()),

    // Ice and Fire
    IAF_SILVER("silver", ICE_AND_FIRE, false, () -> IafItemRegistry.SILVER_BOOTS.get(), () -> IafItemRegistry.SILVER_TOOL_MATERIAL.getUses()),
    IAF_COPPER("copper", ICE_AND_FIRE, false, () -> IafItemRegistry.COPPER_BOOTS.get(), () -> IafItemRegistry.COPPER_TOOL_MATERIAL.getUses()),
    SHEEP_DISGUISE(ICE_AND_FIRE, false, () -> IafItemRegistry.SHEEP_BOOTS.get(), () -> 59),
    FIRE_DRAGONSTEEL(ICE_AND_FIRE, false, () -> IafItemRegistry.DRAGONSTEEL_FIRE_BOOTS.get(), () -> DragonSteelTier.DRAGONSTEEL_TIER_FIRE.getUses()),
    ICE_DRAGONSTEEL(ICE_AND_FIRE, false, () -> IafItemRegistry.DRAGONSTEEL_ICE_BOOTS.get(), () -> DragonSteelTier.DRAGONSTEEL_TIER_ICE.getUses()),
    LIGHTNING_DRAGONSTEEL(ICE_AND_FIRE, false, () -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_BOOTS.get(), () -> DragonSteelTier.DRAGONSTEEL_TIER_LIGHTNING.getUses()),
    SEA_SERPENT_SCALE(ICE_AND_FIRE, false, () -> EnumSeaSerpent.BLUE.boots.get(), () -> 1279),
    ;
    @SuppressWarnings("deprecation")
    public static final EnumCodec<CompatMaterial> CODEC = StringRepresentable.fromEnum(CompatMaterial::values);
    private final String name;
    private final String uniqueName;
    private final CompatModule compatModule;
    private final boolean isTrimmable;
    private final Supplier<Item> armorItem;
    private final IntSupplier uses;

    CompatMaterial(String name, CompatModule compatModule, boolean isTrimmable, Supplier<Item> armorItem, IntSupplier uses) {
        this.name = name;
        this.uniqueName = compatModule.getSourceModId() + '/' + name;
        this.compatModule = compatModule;
        this.isTrimmable = isTrimmable;
        this.armorItem = compatModule.isLoaded() ? armorItem : () -> Items.IRON_BOOTS;
        this.uses = compatModule.isLoaded() ? uses : Tiers.IRON::getUses;
    }

    CompatMaterial(CompatModule compatModule, boolean isTrimmable, Supplier<Item> armorItem, IntSupplier uses) {
        this.name = name().toLowerCase(Locale.ROOT);
        this.uniqueName = compatModule.getSourceModId() + '/' + name;
        this.compatModule = compatModule;
        this.isTrimmable = isTrimmable;
        this.armorItem = compatModule.isLoaded() ? armorItem : () -> Items.IRON_BOOTS;
        this.uses = compatModule.isLoaded() ? uses : Tiers.IRON::getUses;
    }

    public String getName() {
        return name;
    }

    public CompatModule getCompatModule() {
        return compatModule;
    }

    public boolean isTrimmable() {
        return isTrimmable;
    }

    public ArmorItem getArmorItem() {
        return (ArmorItem) armorItem.get();
    }

    public ArmorMaterial getArmorMaterial() {
        return getArmorItem().getMaterial();
    }

    public int getUses() {
        return uses.getAsInt();
    }

    public Item.Properties applyCompatProperties(Item.Properties properties) {
        if (getArmorItem().isFireResistant()) {
            properties.fireResistant();
        }
        if (!getArmorItem().isRepairable(getArmorItem().getDefaultInstance())) {
            properties.setNoRepair();
        }
        return properties.defaultDurability(getUses()).rarity(getArmorItem().getRarity(getArmorItem().getDefaultInstance()));
    }

    @Override
    public String getSerializedName() {
        return uniqueName;
    }
}
