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

public enum CompatMaterial implements StringRepresentable {
    // Caverns & Chasms
    SILVER(CAVERNS_AND_CHASMS, true, () -> CCTiers.CCArmorMaterials.SILVER, () -> CCTiers.CCItemTiers.SILVER.getUses()),
    NECROMIUM(CAVERNS_AND_CHASMS, true, () -> CCTiers.CCArmorMaterials.NECROMIUM, () -> CCTiers.CCItemTiers.NECROMIUM.getUses()),
    SANGUINE(CAVERNS_AND_CHASMS, true, () -> CCTiers.CCArmorMaterials.SANGUINE, () -> 989),
    // Savage & Ravage
    GRIEFER(SAVAGE_AND_RAVAGE, false, () -> SRTiers.GRIEFER, () -> 250),
    // Oreganized
    ELECTRUM(OREGANIZED, true, () -> OArmorMaterials.ELECTRUM, () -> OItemTiers.ELECTRUM.getUses()),
    // Galosphere
    STERLING(GALOSPHERE, false, () -> ((ArmorItem) GItems.STERLING_BOOTS.get()).getMaterial(), () -> 163),
    // Additional Additions
    ROSE_GOLD(ADDITIONAL_ADDITIONS, true, () -> AdditionalRegistry.ROSE_GOLD_ARMOR_MATERIAL, () -> RoseGoldToolMaterial.MATERIAL.getUses()),
    GILDED_NETHERITE(ADDITIONAL_ADDITIONS, true, () -> AdditionalRegistry.GILDED_NETHERITE_ARMOR_MATERIAL, () -> GildedNetheriteToolMaterial.MATERIAL.getUses()),
    // SimpleOres
    COPPER(SIMPLEORES, true, () -> SimpleOresArmorMaterial.COPPER, () -> SimpleOresTiers.COPPER.getUses()),
    TIN(SIMPLEORES, true, () -> SimpleOresArmorMaterial.TIN, () -> SimpleOresTiers.TIN.getUses()),
    MYTHRIL(SIMPLEORES, true, () -> SimpleOresArmorMaterial.MYTHRIL, () -> SimpleOresTiers.MYTHRIL.getUses()),
    ADAMANTIUM(SIMPLEORES, true, () -> SimpleOresArmorMaterial.ADAMANTIUM, () -> SimpleOresTiers.ADAMANTIUM.getUses()),
    ONYX(SIMPLEORES, true, () -> SimpleOresArmorMaterial.ONYX, () -> SimpleOresTiers.ONYX.getUses()),

    // Undergarden
    CLOGGRUM(UNDERGARDEN, true, () -> UGArmorMaterials.CLOGGRUM, () -> UGItemTiers.CLOGGRUM.getUses()),
    FROSTSTEEL(UNDERGARDEN, true, () -> UGArmorMaterials.FROSTSTEEL, () -> UGItemTiers.FROSTSTEEL.getUses()),
    UTHERIUM(UNDERGARDEN, true, () -> UGArmorMaterials.UTHERIUM, () -> UGItemTiers.UTHERIUM.getUses()),
    // Blue Skies
    PYROPE(BLUE_SKIES, true, () -> SkiesArmorMaterial.PYROPE, () -> SkiesItemTier.PYROPE.getUses()),
    AQUITE(BLUE_SKIES, true, () -> SkiesArmorMaterial.AQUITE, () -> SkiesItemTier.AQUITE.getUses()),
    HORIZONITE(BLUE_SKIES, true, () -> SkiesArmorMaterial.HORIZONITE, () -> SkiesItemTier.HORIZONITE.getUses()),
    DIOPSIDE(BLUE_SKIES, true, () -> SkiesArmorMaterial.DIOPSIDE, () -> SkiesItemTier.DIOPSIDE.getUses()),
    CHAROITE(BLUE_SKIES, true, () -> SkiesArmorMaterial.CHAROITE, () -> SkiesItemTier.CHAROITE.getUses()),
    // Voidscape
    VOIDIC_CRYSTAL(VOIDSCAPE, false, () -> ((ArmorItem) ModArmors.VOIDIC_CRYSTAL_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.VOIDIC_CRYSTAL.getUses()),
    CORRUPT(VOIDSCAPE, false, () -> ((ArmorItem) ModArmors.CORRUPT_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.CORRUPT.getUses()),
    TITANITE(VOIDSCAPE, false, () -> ((ArmorItem) ModArmors.TITANITE_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.TITANITE.getUses()),
    ICHOR(VOIDSCAPE, false, () -> ((ArmorItem) ModArmors.ICHOR_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.ICHOR.getUses()),
    ASTRAL(VOIDSCAPE, false, () -> ((ArmorItem) ModArmors.ASTRAL_BOOTS.get()).getMaterial(), () -> ModTools.ItemTier.ASTRAL.getUses()),
    // Midnight
    ROCKSHROOM(MIDNIGHT, true, () -> MnArmorMaterials.ROCKSHROOM.get(), () -> 250),
    TENEBRUM(MIDNIGHT, true, () -> MnArmorMaterials.TENEBRUM.get(), () -> MnTiers.TENEBRUM.getUses()),
    // Deeper and Darker
    RESONARIUM(DEEPER_AND_DARKER, true, () -> DDArmorMaterials.RESONARIUM, () -> DDTiers.RESONARIUM.getUses()),
    WARDEN(DEEPER_AND_DARKER, true, () -> DDArmorMaterials.WARDEN, () -> DDTiers.WARDEN.getUses()),

    // Botania
    MANASTEEL(BOTANIA, false, () -> BotaniaAPI.instance().getManasteelArmorMaterial(), () -> BotaniaAPI.instance().getManasteelItemTier().getUses()),
    ELEMENTIUM(BOTANIA, false, () -> BotaniaAPI.instance().getElementiumArmorMaterial(), () -> BotaniaAPI.instance().getElementiumItemTier().getUses()),
    MANAWEAVE(BOTANIA, false, () -> BotaniaAPI.instance().getManaweaveArmorMaterial(), () -> 120),
    TERRASTEEL(BOTANIA, false, () -> BotaniaAPI.instance().getTerrasteelArmorMaterial(), () -> BotaniaAPI.instance().getTerrasteelItemTier().getUses()),

    // Create
    CARDBOARD(CREATE, true, () -> AllArmorMaterials.CARDBOARD, () -> 51),
    // Redstone Arsenal
    FLUX(REDSTONE_ARSENAL, false, () -> ModItems.FLUX_ARMOR, () -> ModItems.MATERIAL_FLUX_METAL.getUses()),
    // Thermal Series
    BEEKEEPER(THERMAL, false, () -> TCoreItems.BEEKEEPER, () -> 51),
    DIVING(THERMAL, false, () -> TCoreItems.DIVING, () -> 163),
    HAZMAT(THERMAL, false, () -> TCoreItems.HAZMAT, () -> 67),
    // Thermal Extra
    SIGNALUM(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.SIGNALUM, () -> ThermalExtraTiers.SIGNALUM.getUses()),
    LUMIUM(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.LUMIUM, () -> ThermalExtraTiers.LUMIUM.getUses()),
    ENDERIUM(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.ENDERIUM, () -> ThermalExtraTiers.ENDERIUM.getUses()),
    SOUL_INFUSED(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.SOUL_INFUSED, () -> ThermalExtraTiers.SOUL_INFUSED.getUses()),
    SHELLITE(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.SHELLITE, () -> ThermalExtraTiers.SHELLITE.getUses()),
    TWINITE(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.TWINITE, () -> ThermalExtraTiers.TWINITE.getUses()),
    DRAGONSTEEL(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.DRAGONSTEEL, () -> ThermalExtraTiers.DRAGONSTEEL.getUses()),
    ABYSSAL(THERMAL_EXTRA, true, () -> ThermalExtraArmorMaterials.ABYSSAL, () -> ThermalExtraTiers.ABYSSAL.getUses()),
    // Mekanism Tools
    BRONZE(MEKANISM_TOOLS, true, () -> ToolsItems.BRONZE_BOOTS.get().getMaterial(), () -> ToolsItems.BRONZE_AXE.get().getTier().getUses()),
    LAPIS_LAZULI(MEKANISM_TOOLS, true, () -> ToolsItems.LAPIS_LAZULI_BOOTS.get().getMaterial(), () -> ToolsItems.LAPIS_LAZULI_AXE.get().getTier().getUses()),
    OSMIUM(MEKANISM_TOOLS, true, () -> ToolsItems.OSMIUM_BOOTS.get().getMaterial(), () -> ToolsItems.OSMIUM_AXE.get().getTier().getUses()),
    REFINED_GLOWSTONE(MEKANISM_TOOLS, true, () -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get().getMaterial(), () -> ToolsItems.REFINED_GLOWSTONE_AXE.get().getTier().getUses()),
    REFINED_OBSIDIAN(MEKANISM_TOOLS, true, () -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get().getMaterial(), () -> ToolsItems.REFINED_OBSIDIAN_AXE.get().getTier().getUses()),
    STEEL(MEKANISM_TOOLS, true, () -> ToolsItems.STEEL_BOOTS.get().getMaterial(), () -> ToolsItems.STEEL_AXE.get().getTier().getUses()),

    // Ice and Fire
    IAF_SILVER("silver", ICE_AND_FIRE, false, () -> IafItemRegistry.SILVER_ARMOR_MATERIAL, () -> IafItemRegistry.SILVER_TOOL_MATERIAL.getUses()),
    IAF_COPPER("copper", ICE_AND_FIRE, false, () -> IafItemRegistry.COPPER_ARMOR_MATERIAL, () -> IafItemRegistry.COPPER_TOOL_MATERIAL.getUses()),
    SHEEP_DISGUISE(ICE_AND_FIRE, false, () -> IafItemRegistry.SHEEP_ARMOR_MATERIAL, () -> 59),
    FIRE_DRAGONSTEEL(ICE_AND_FIRE, false, () -> IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_FIRE.getUses()),
    ICE_DRAGONSTEEL(ICE_AND_FIRE, false, () -> IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_ICE.getUses()),
    LIGHTNING_DRAGONSTEEL(ICE_AND_FIRE, false, () -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, () -> DragonSteelTier.DRAGONSTEEL_TIER_LIGHTNING.getUses()),
    SEA_SERPENT_SCALE(ICE_AND_FIRE, false, () -> EnumSeaSerpent.BLUE.armorMaterial, () -> 1279),
    ;
    @SuppressWarnings("deprecation")
    public static final EnumCodec<CompatMaterial> CODEC = StringRepresentable.fromEnum(CompatMaterial::values);
    private final String name;
    private final String uniqueName;
    private final CompatModule compatModule;
    private final boolean isTrimmable;
    private final Supplier<ArmorMaterial> armorMaterial;
    private final IntSupplier uses;

    CompatMaterial(String name, CompatModule compatModule, boolean isTrimmable, Supplier<ArmorMaterial> armorMaterial, IntSupplier uses) {
        this.name = name;
        this.uniqueName = compatModule.getSourceModId() + '/' + name;
        this.compatModule = compatModule;
        this.isTrimmable = isTrimmable;
        this.armorMaterial = compatModule.isLoaded() ? Suppliers.memoize(armorMaterial::get) : () -> ArmorMaterials.IRON;
        this.uses = compatModule.isLoaded() ? uses : Tiers.IRON::getUses;
    }

    CompatMaterial(CompatModule compatModule, boolean isTrimmable, Supplier<ArmorMaterial> armorMaterial, IntSupplier uses) {
        this.name = name().toLowerCase(Locale.ROOT);
        this.uniqueName = compatModule.getSourceModId() + '/' + name;
        this.compatModule = compatModule;
        this.isTrimmable = isTrimmable;
        this.armorMaterial = compatModule.isLoaded() ? Suppliers.memoize(armorMaterial::get) : () -> ArmorMaterials.IRON;
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
