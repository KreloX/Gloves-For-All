package krelox.gloves_for_all.item;

import cofh.redstonearsenal.init.registries.ModItems;
import cofh.thermal.core.init.registries.TCoreItems;
import com.crypticmushroom.minecraft.midnight.common.misc.MnArmorMaterials;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.legacy.blue_skies.items.util.SkiesArmorMaterial;
import com.simibubi.create.content.equipment.armor.AllArmorMaterials;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers;
import com.teamabnormals.savage_and_ravage.core.other.SRTiers;
import dqu.additionaladditions.AdditionalRegistry;
import galena.oreganized.index.OArmorMaterials;
import mekanism.tools.common.registries.ToolsItems;
import mod.alexndr.simpleores.content.SimpleOresArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Lazy;
import net.orcinus.galosphere.init.GItems;
import quek.undergarden.registry.UGArmorMaterials;
import tamaized.voidscape.registry.ModArmors;
import vazkii.botania.api.BotaniaAPI;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

import static krelox.gloves_for_all.GlovesTags.Items.*;
import static krelox.gloves_for_all.item.CompatModule.*;
import static net.minecraft.sounds.SoundEvents.*;

public enum CompatArmorMaterial implements StringRepresentable, ArmorMaterial {
    // Caverns & Chasms
    SILVER(List.of(CAVERNS_AND_CHASMS, ICE_AND_FIRE), 17, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_SILVER), 157, module -> switch (module) {
        case CAVERNS_AND_CHASMS -> CCTiers.CCArmorMaterials.SILVER;
        case ICE_AND_FIRE -> IafItemRegistry.SILVER_ARMOR_MATERIAL;
        default -> throw new IllegalStateException("Unexpected module: " + module);
    }),
    NECROMIUM(CAVERNS_AND_CHASMS, 15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_NECROMIUM), Tiers.NETHERITE.getUses(), module -> CCTiers.CCArmorMaterials.NECROMIUM),
    SANGUINE(CAVERNS_AND_CHASMS, 17, ARMOR_EQUIP_IRON, Ingredient::of, 989, module -> CCTiers.CCArmorMaterials.SANGUINE),
    // Oreganized
    ELECTRUM(OREGANIZED, 20, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_ELECTRUM), Tiers.DIAMOND.getUses(), module -> OArmorMaterials.ELECTRUM),
    // Mekanism Tools
    BRONZE(MEKANISM_TOOLS, 10, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_BRONZE), 375, module -> ToolsItems.BRONZE_BOOTS.get().getMaterial()),
    LAPIS_LAZULI(MEKANISM_TOOLS, 32, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Tags.Items.GEMS_LAPIS), 128, module -> ToolsItems.LAPIS_LAZULI_BOOTS.get().getMaterial()),
    OSMIUM(MEKANISM_TOOLS, 14, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_OSMIUM), 1024, module -> ToolsItems.OSMIUM_BOOTS.get().getMaterial()),
    REFINED_GLOWSTONE(MEKANISM_TOOLS, 20, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_REFINED_GLOWSTONE), 384, module -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get().getMaterial()),
    REFINED_OBSIDIAN(MEKANISM_TOOLS, 18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_REFINED_OBSIDIAN), 4096, module -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get().getMaterial()),
    STEEL(MEKANISM_TOOLS, 16, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_STEEL), 500, module -> ToolsItems.STEEL_BOOTS.get().getMaterial()),
    // SimpleOres
    COPPER(List.of(SIMPLEORES, ICE_AND_FIRE), 8, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Tags.Items.INGOTS_COPPER), 185, module -> switch (module) {
        case SIMPLEORES -> SimpleOresArmorMaterial.COPPER;
        case ICE_AND_FIRE -> IafItemRegistry.COPPER_ARMOR_MATERIAL;
        default -> throw new IllegalStateException("Unexpected module: " + module);
    }),
    TIN(SIMPLEORES, 8, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_TIN), 220, module -> SimpleOresArmorMaterial.TIN),
    MYTHRIL(SIMPLEORES, 12, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_MYTHRIL), 800, module -> SimpleOresArmorMaterial.MYTHRIL),
    ADAMANTIUM(SIMPLEORES, 3, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ADAMANTIUM), 1150, module -> SimpleOresArmorMaterial.ADAMANTIUM),
    ONYX(SIMPLEORES, 15, ARMOR_EQUIP_GOLD, () -> Ingredient.of(GEMS_ONYX), 3280, module -> SimpleOresArmorMaterial.ONYX),
    // Ice and Fire
    SHEEP_DISGUISE(ICE_AND_FIRE, 15, ARMOR_EQUIP_LEATHER, Ingredient::of, Tiers.WOOD.getUses(), module -> IafItemRegistry.SHEEP_ARMOR_MATERIAL),
    FIRE_DRAGONSTEEL(ICE_AND_FIRE, 30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, module -> IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL),
    ICE_DRAGONSTEEL(ICE_AND_FIRE, 30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, module -> IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL),
    LIGHTNING_DRAGONSTEEL(ICE_AND_FIRE, 30, ARMOR_EQUIP_DIAMOND, Ingredient::of, 8000, module -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL),
    SEA_SERPENT_SCALE(ICE_AND_FIRE, 25, ARMOR_EQUIP_GOLD, Ingredient::of, 1279, module -> EnumSeaSerpent.BLUE.armorMaterial),
    // Thermal Extra
    SIGNALUM(THERMAL_EXTRA, 15, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_SIGNALUM), 1751, module -> ThermalExtraArmorMaterials.SIGNALUM),
    LUMIUM(THERMAL_EXTRA, 22, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_LUMIUM), 1751, module -> ThermalExtraArmorMaterials.LUMIUM),
    ENDERIUM(THERMAL_EXTRA, 15, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ENDERIUM), 1961, module -> ThermalExtraArmorMaterials.ENDERIUM),
    SOUL_INFUSED(THERMAL_EXTRA, 24, ARMOR_EQUIP_ELYTRA, () -> Ingredient.of(INGOTS_SOUL_INFUSED), 1751, module -> ThermalExtraArmorMaterials.SOUL_INFUSED),
    SHELLITE(THERMAL_EXTRA, 15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_SHELLITE), 2001, module -> ThermalExtraArmorMaterials.SHELLITE),
    TWINITE(THERMAL_EXTRA, 15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_TWINITE), 2001, module -> ThermalExtraArmorMaterials.TWINITE),
    DRAGONSTEEL(THERMAL_EXTRA, 15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_DRAGONSTEEL), 2001, module -> ThermalExtraArmorMaterials.DRAGONSTEEL),
    ABYSSAL(THERMAL_EXTRA, 15, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(INGOTS_ABYSSAL), 2001, module -> ThermalExtraArmorMaterials.ABYSSAL),
    // Additional Additions
    ROSE_GOLD(ADDITIONAL_ADDITIONS, 17, ARMOR_EQUIP_GOLD, () -> Ingredient.of(Tags.Items.INGOTS_COPPER), 900, module -> AdditionalRegistry.ROSE_GOLD_ARMOR_MATERIAL),
    GILDED_NETHERITE(ADDITIONAL_ADDITIONS, 20, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), 2031, module -> AdditionalRegistry.GILDED_NETHERITE_ARMOR_MATERIAL),
    // Redstone Arsenal
    FLUX(REDSTONE_ARSENAL, 18, ARMOR_EQUIP_GOLD, Ingredient::of, 0, module -> ModItems.FLUX_ARMOR),
    // Galosphere
    STERLING(GALOSPHERE, 9, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(INGOTS_SILVER), 163, module -> ((ArmorItem) GItems.STERLING_BOOTS.get()).getMaterial()),
    // Undergarden
    CLOGGRUM(UNDERGARDEN, 10, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_CLOGGRUM), 286, module -> UGArmorMaterials.CLOGGRUM),
    FROSTSTEEL(UNDERGARDEN, 15, ARMOR_EQUIP_GOLD, () -> Ingredient.of(INGOTS_FROSTSTEEL), 575, module -> UGArmorMaterials.FROSTSTEEL),
    UTHERIUM(UNDERGARDEN, 13, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(INGOTS_UTHERIUM), 1279, module -> UGArmorMaterials.UTHERIUM),
    // Blue Skies
    PYROPE(BLUE_SKIES, 12, ARMOR_EQUIP_IRON, () -> Ingredient.of(GEMS_PYROPE), 200, module -> SkiesArmorMaterial.PYROPE),
    AQUITE(BLUE_SKIES, 9, ARMOR_EQUIP_IRON, () -> Ingredient.of(GEMS_AQUITE), 270, module -> SkiesArmorMaterial.AQUITE),
    HORIZONITE(BLUE_SKIES, 12, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_HORIZONITE), 250, module -> SkiesArmorMaterial.HORIZONITE),
    DIOPSIDE(BLUE_SKIES, 9, ARMOR_EQUIP_GOLD, () -> Ingredient.of(GEMS_DIOPSIDE), 1661, module -> SkiesArmorMaterial.DIOPSIDE),
    CHAROITE(BLUE_SKIES, 10, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(GEMS_CHAROITE), Tiers.DIAMOND.getUses(), module -> SkiesArmorMaterial.CHAROITE),
    // Voidscape
    VOIDIC_CRYSTAL(VOIDSCAPE, 9, ARMOR_EQUIP_DIAMOND, Ingredient::of, 2538, module -> ((ArmorItem) ModArmors.VOIDIC_CRYSTAL_BOOTS.get()).getMaterial()),
    CORRUPT(VOIDSCAPE, 9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 3041, module -> ((ArmorItem) ModArmors.CORRUPT_BOOTS.get()).getMaterial()),
    TITANITE(VOIDSCAPE, 9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 3544, module -> ((ArmorItem) ModArmors.TITANITE_BOOTS.get()).getMaterial()),
    ICHOR(VOIDSCAPE, 9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 4047, module -> ((ArmorItem) ModArmors.ICHOR_BOOTS.get()).getMaterial()),
    ASTRAL(VOIDSCAPE, 9, ARMOR_EQUIP_DIAMOND, Ingredient::of, 4550, module -> ((ArmorItem) ModArmors.ASTRAL_BOOTS.get()).getMaterial()),
    // Midnight
    ROCKSHROOM(MIDNIGHT, 5, ARMOR_EQUIP_GENERIC, Ingredient::of, 250, module -> MnArmorMaterials.ROCKSHROOM.get()),
    TENEBRUM(MIDNIGHT, 9, ARMOR_EQUIP_NETHERITE, Ingredient::of, 1860, module -> MnArmorMaterials.TENEBRUM.get()),
    // Deeper and Darker
    RESONARIUM(DEEPER_AND_DARKER, 10, ARMOR_EQUIP_IRON, Ingredient::of, 1193, module -> DDArmorMaterials.RESONARIUM),
    WARDEN(DEEPER_AND_DARKER, 18, ARMOR_EQUIP_NETHERITE, Ingredient::of, 2519, module -> DDArmorMaterials.WARDEN),
    // Botania
    MANASTEEL(BOTANIA, 18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_MANASTEEL), 300, module -> BotaniaAPI.instance().getManasteelArmorMaterial()),
    ELEMENTIUM(BOTANIA, 18, ARMOR_EQUIP_IRON, () -> Ingredient.of(INGOTS_ELEMENTIUM), 720, module -> BotaniaAPI.instance().getElementiumArmorMaterial()),
    MANAWEAVE(BOTANIA, 18, ARMOR_EQUIP_LEATHER, Ingredient::of, 120, module -> BotaniaAPI.instance().getManaweaveArmorMaterial()),
    TERRASTEEL(BOTANIA, 26, ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(INGOTS_TERRASTEEL), 2300, module -> BotaniaAPI.instance().getTerrasteelArmorMaterial()),
    // Savage & Ravage
    GRIEFER(SAVAGE_AND_RAVAGE, 15, ARMOR_EQUIP_IRON, Ingredient::of, Tiers.IRON.getUses(), module -> SRTiers.GRIEFER),
    // Create
    CARDBOARD(CREATE, 25, ARMOR_EQUIP_LEATHER, Ingredient::of, 51, module -> AllArmorMaterials.CARDBOARD),
    // Thermal Core
    BEEKEEPER(THERMAL, 16, ARMOR_EQUIP_ELYTRA, Ingredient::of, 51, module -> TCoreItems.BEEKEEPER),
    DIVING(THERMAL, 20, ARMOR_EQUIP_CHAIN, Ingredient::of, 163, module -> TCoreItems.DIVING),
    HAZMAT(THERMAL, 15, ARMOR_EQUIP_LEATHER, Ingredient::of, 67, module -> TCoreItems.HAZMAT),
    ;
    @SuppressWarnings("deprecation")
    public static final EnumCodec<CompatArmorMaterial> CODEC = StringRepresentable.fromEnum(CompatArmorMaterial::values);
    private final CompatModule compatModule;
    private final String name;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final Lazy<Ingredient> repairIngredient;
    private final int uses;
    private final Lazy<ArmorMaterial> armorMaterial;

    CompatArmorMaterial(CompatModule compatModule, int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int uses, Function<CompatModule, ArmorMaterial> armorMaterial) {
        this.compatModule = compatModule;
        this.name = name().toLowerCase(Locale.ROOT);
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.repairIngredient = Lazy.of(repairIngredient);
        this.uses = uses;
        this.armorMaterial = Lazy.of(() -> armorMaterial.apply(compatModule));
    }

    CompatArmorMaterial(List<CompatModule> compatModules, int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repairIngredient, int uses, Function<CompatModule, ArmorMaterial> armorMaterial) {
        this(compatModules.stream().filter(CompatModule::isLoaded).findFirst().orElse(compatModules.get(0)), enchantmentValue, sound, repairIngredient, uses, armorMaterial);
    }

    public CompatModule getCompatModule() {
        return compatModule;
    }

    public int getUses() {
        return uses;
    }

    public ArmorMaterial getArmorMaterial() {
        return getCompatModule().isLoaded() ? armorMaterial.get() : this;
    }

    @Override
    public int getDurabilityForType(Type type) {
        return 0;
    }

    @Override
    public int getDefenseForType(Type type) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
