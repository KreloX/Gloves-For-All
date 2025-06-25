package krelox.gloves_for_all.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Lazy;

import java.util.EnumMap;
import java.util.Locale;
import java.util.function.Supplier;

import static krelox.gloves_for_all.GlovesTags.Items.*;
import static krelox.gloves_for_all.item.CompatModule.*;
import static net.minecraft.sounds.SoundEvents.*;

public enum CompatArmorMaterial implements StringRepresentable, ArmorMaterial {
    // Caverns & Chasms
    SILVER(CAVERNS_AND_CHASMS, 11, intForType(2, 4, 5, 2),
            17, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_SILVER)),
    NECROMIUM(CAVERNS_AND_CHASMS, 37, intForType(3, 6, 8, 3),
            15, ARMOR_EQUIP_NETHERITE, 2.0F, 0.0F, () -> Ingredient.of(INGOTS_NECROMIUM)),
    SANGUINE(CAVERNS_AND_CHASMS, 23, intForType(2, 5, 7, 3),
            17, ARMOR_EQUIP_IRON, 1.0F, 0.0F, Ingredient::of),
    // Oreganized
    ELECTRUM(OREGANIZED, 33, intForType(3, 6, 8, 3),
            20, ARMOR_EQUIP_CHAIN, 2.0F, 0.0F, () -> Ingredient.of(INGOTS_ELECTRUM)),
    // Mekanism Tools
    BRONZE(MEKANISM_TOOLS, 18, intForType(2, 6, 7, 3),
            10, ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(INGOTS_BRONZE)),
    LAPIS_LAZULI(MEKANISM_TOOLS, 10, intForType(1, 3, 4, 1),
            32, ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_LAPIS)),
    OSMIUM(MEKANISM_TOOLS, 30, intForType(3, 6, 8, 4),
            14, ARMOR_EQUIP_IRON, 3.0F, 0.1F, () -> Ingredient.of(INGOTS_OSMIUM)),
    REFINED_GLOWSTONE(MEKANISM_TOOLS, 17, intForType(3, 6, 8, 3),
            20, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_REFINED_GLOWSTONE)),
    REFINED_OBSIDIAN(MEKANISM_TOOLS, 75, intForType(5, 8, 12, 6),
            18, ARMOR_EQUIP_IRON, 5.0F, 0.2F, () -> Ingredient.of(INGOTS_REFINED_OBSIDIAN)),
    STEEL(MEKANISM_TOOLS, 20, intForType(3, 6, 8, 3),
            16, ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> Ingredient.of(INGOTS_STEEL)),
    // SimpleOres
    COPPER(SIMPLEORES, 8, intForType(1, 2, 3, 2),
            8, ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)),
    TIN(SIMPLEORES, 9, intForType(1, 2, 3, 2),
            8, ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_TIN)),
    MYTHRIL(SIMPLEORES, 22, intForType(3, 4, 5, 3),
            12, ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_MYTHRIL)),
    ADAMANTIUM(SIMPLEORES, 28, intForType(2, 6, 8, 3),
            3, ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(INGOTS_ADAMANTIUM)),
    ONYX(SIMPLEORES, 45, intForType(5, 6, 8, 5),
            15, ARMOR_EQUIP_GOLD, 2.0F, 0.0F, () -> Ingredient.of(GEMS_ONYX)),
    // Additional Additions
    ROSE_GOLD(ADDITIONAL_ADDITIONS, 24, intForType(2, 6, 7, 2),
            17, ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)),
    GILDED_NETHERITE(ADDITIONAL_ADDITIONS, 37, intForType(3, 6, 8, 3),
            20, ARMOR_EQUIP_NETHERITE, 2.5F, 0.1F, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE)),
    // Redstone Arsenal
    FLUX(REDSTONE_ARSENAL, 0, intForType(3, 6, 8, 3),
            18, ARMOR_EQUIP_GOLD, 1.0F, 0.0F, Ingredient::of),
    // Galosphere
    STERLING(GALOSPHERE, 12, intForType(2, 5, 4, 1),
            9, ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_SILVER)),
    // Undergarden
    CLOGGRUM(UNDERGARDEN, 20, intForType(1, 5, 6, 2),
            10, ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(INGOTS_CLOGGRUM)),
    FROSTSTEEL(UNDERGARDEN, 25, intForType(2, 6, 7, 3),
            15, ARMOR_EQUIP_GOLD, 4.0F, 0.05F, () -> Ingredient.of(INGOTS_FROSTSTEEL)),
    UTHERIUM(UNDERGARDEN, 30, intForType(3, 6, 8, 3),
            13, ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.of(INGOTS_UTHERIUM)),
    // Blue Skies
    PYROPE(BLUE_SKIES, 15, intForType(1, 4, 5, 2),
            12, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(GEMS_PYROPE)),
    AQUITE(BLUE_SKIES, 15, intForType(2, 5, 6, 2),
            9, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(GEMS_AQUITE)),
    HORIZONITE(BLUE_SKIES, 15, intForType(1, 4, 5, 2),
            12, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_HORIZONITE)),
    DIOPSIDE(BLUE_SKIES, 36, intForType(2, 5, 7, 2),
            9, ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.of(GEMS_DIOPSIDE)),
    CHAROITE(BLUE_SKIES, 33, intForType(3, 6, 8, 3),
            10, ARMOR_EQUIP_DIAMOND, 4.5F, 0.0F, () -> Ingredient.of(GEMS_CHAROITE)),
    // Voidscape
    VOIDIC_CRYSTAL(VOIDSCAPE, 18, intForType(2, 5, 6, 2),
            9, ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(GEMS_VOIDIC_CRYSTAL)),
    CORRUPT(VOIDSCAPE, 18, intForType(2, 5, 6, 2),
            9, ARMOR_EQUIP_NETHERITE, 0.0F, 0.0F, Ingredient::of),
    TITANITE(VOIDSCAPE, 18, intForType(2, 5, 6, 2),
            9, ARMOR_EQUIP_NETHERITE, 0.0F, 0.0F, () -> Ingredient.of(GEMS_TITANITE)),
    ICHOR(VOIDSCAPE, 18, intForType(2, 5, 6, 2),
            9, ARMOR_EQUIP_NETHERITE, 0.0F, 0.0F, () -> Ingredient.of(GEMS_ICHOR)),
    ASTRAL(VOIDSCAPE, 18, intForType(2, 5, 6, 2),
            9, ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(GEMS_ASTRAL)),
    // Deeper and Darker
    RESONARIUM(DEEPER_AND_DARKER, 30, intForType(2, 6, 7, 3),
            10, ARMOR_EQUIP_IRON, 1.0F, 0.0F, Ingredient::of),
    WARDEN(DEEPER_AND_DARKER, 40, intForType(4, 7, 9, 4),
            18, ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, Ingredient::of),
    // Botania
    MANASTEEL(BOTANIA, 16, intForType(2, 5, 6, 2),
            18, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_MANASTEEL)),
    ELEMENTIUM(BOTANIA, 5, intForType(1, 2, 3, 1),
            18, ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(INGOTS_ELEMENTIUM)),
    MANAWEAVE(BOTANIA, 18, intForType(2, 5, 6, 2),
            18, ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, Ingredient::of),
    TERRASTEEL(BOTANIA, 34, intForType(3, 6, 8, 3),
            26, ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.of(INGOTS_TERRASTEEL)),
    // Savage & Ravage
    GRIEFER(SAVAGE_AND_RAVAGE, 15, intForType(2, 5, 6, 2),
            15, ARMOR_EQUIP_IRON, 1.0F, 0.0F, Ingredient::of),
    ;
    public static final EnumCodec<CompatArmorMaterial> CODEC = StringRepresentable.fromEnum(CompatArmorMaterial::values);
    private static final EnumMap<Type, Integer> HEALTH_FOR_TYPE = intForType(13, 15, 16, 11);
    private final CompatModule compatModule;
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;

    CompatArmorMaterial(CompatModule compatModule, int durabilityMultiplier, EnumMap<Type, Integer> protectionFunctionForType,
                        int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.compatModule = compatModule;
        this.name = name().toLowerCase(Locale.ROOT);
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Lazy.of(repairIngredient);
    }

    public CompatModule getCompatModule() {
        return compatModule;
    }

    public ArmorMaterial getArmorMaterial() {
        return getCompatModule().isLoaded() ? getCompatModule().getArmorMaterial(this) : this;
    }

    @Override
    public int getDurabilityForType(Type type) {
        return HEALTH_FOR_TYPE.get(type) * durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(Type type) {
        return protectionFunctionForType.get(type);
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
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    public static EnumMap<Type, Integer> intForType(int boots, int leggings, int chestplate, int helmet) {
        var map = new EnumMap<Type, Integer>(Type.class);
        map.put(Type.BOOTS, boots);
        map.put(Type.LEGGINGS, leggings);
        map.put(Type.CHESTPLATE, chestplate);
        map.put(Type.HELMET, helmet);
        return map;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
