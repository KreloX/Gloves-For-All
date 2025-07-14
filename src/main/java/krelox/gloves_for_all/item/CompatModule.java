package krelox.gloves_for_all.item;

import cofh.redstonearsenal.init.registries.ModItems;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.legacy.blue_skies.items.util.SkiesArmorMaterial;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers;
import com.teamabnormals.savage_and_ravage.core.other.SRTiers;
import dqu.additionaladditions.AdditionalRegistry;
import galena.oreganized.index.OArmorMaterials;
import mekanism.tools.common.registries.ToolsItems;
import mod.alexndr.simpleores.content.SimpleOresArmorMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.fml.ModList;
import net.orcinus.galosphere.init.GItems;
import quek.undergarden.registry.UGArmorMaterials;
import tamaized.voidscape.registry.ModArmors;
import vazkii.botania.api.BotaniaAPI;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// method references would try to reach potentially not loaded classes, causing crashes
@SuppressWarnings({"Convert2MethodRef", "java:S1612"})
public enum CompatModule {
    CAVERNS_AND_CHASMS("caverns_and_chasms", CreativeModeTabs.COMBAT.location().toString(), material -> switch (material) {
        case "SILVER" -> CCTiers.CCArmorMaterials.SILVER;
        case "NECROMIUM" -> CCTiers.CCArmorMaterials.NECROMIUM;
        case "SANGUINE" -> CCTiers.CCArmorMaterials.SANGUINE;
        default -> throw new IllegalStateException("Unexpected material name: " + material);
    }),
    OREGANIZED("oreganized", CreativeModeTabs.COMBAT.location().toString(), material -> OArmorMaterials.valueOf(material)),
    MEKANISM_TOOLS("mekanismtools", Set.of("mekanismtools", CreativeModeTabs.COMBAT.location().toString()), material -> switch (material) {
        case "BRONZE" -> ToolsItems.BRONZE_BOOTS.get().getMaterial();
        case "LAPIS_LAZULI" -> ToolsItems.LAPIS_LAZULI_BOOTS.get().getMaterial();
        case "OSMIUM" -> ToolsItems.OSMIUM_BOOTS.get().getMaterial();
        case "REFINED_GLOWSTONE" -> ToolsItems.REFINED_GLOWSTONE_BOOTS.get().getMaterial();
        case "REFINED_OBSIDIAN" -> ToolsItems.REFINED_OBSIDIAN_BOOTS.get().getMaterial();
        case "STEEL" -> ToolsItems.STEEL_BOOTS.get().getMaterial();
        default -> throw new IllegalStateException("Unexpected material name: " + material);
    }),
    SIMPLEORES("simpleores", "simplecore_tab", material -> SimpleOresArmorMaterial.valueOf(material)),
    ICE_AND_FIRE("iceandfire", "items", material -> switch (material) {
        case "SILVER" -> IafItemRegistry.SILVER_ARMOR_MATERIAL;
        case "COPPER" -> IafItemRegistry.COPPER_ARMOR_MATERIAL;
        case "SHEEP_DISGUISE" -> IafItemRegistry.SHEEP_ARMOR_MATERIAL;
        case "FIRE_DRAGONSTEEL" -> IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL;
        case "ICE_DRAGONSTEEL" -> IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL;
        case "LIGHTNING_DRAGONSTEEL" -> IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL;
        case "SEA_SERPENT_SCALE" -> EnumSeaSerpent.BLUE.armorMaterial;
        default -> throw new IllegalStateException("Unexpected material name: " + material);
    }),
    ADDITIONAL_ADDITIONS("additionaladditions", CreativeModeTabs.COMBAT.location().toString(), material -> switch (material) {
        case "ROSE_GOLD" -> AdditionalRegistry.ROSE_GOLD_ARMOR_MATERIAL;
        case "GILDED_NETHERITE" -> AdditionalRegistry.GILDED_NETHERITE_ARMOR_MATERIAL;
        default -> throw new IllegalStateException("Unexpected material name: " + material);
    }),
    REDSTONE_ARSENAL("redstone_arsenal", "redstone_arsenal", material -> ModItems.FLUX_ARMOR),
    GALOSPHERE("galosphere", Set.of("galosphere", CreativeModeTabs.COMBAT.location().toString()), material -> ((ArmorItem) GItems.STERLING_BOOTS.get()).getMaterial()),
    UNDERGARDEN("undergarden", "undergarden_group", material -> UGArmorMaterials.valueOf(material)),
    BLUE_SKIES("blue_skies", "all_items", material -> SkiesArmorMaterial.valueOf(material)),
    VOIDSCAPE("voidscape", "tab", material -> switch (material) {
        case "VOIDIC_CRYSTAL" -> ((ArmorItem) ModArmors.VOIDIC_CRYSTAL_BOOTS.get()).getMaterial();
        case "CORRUPT" -> ((ArmorItem) ModArmors.CORRUPT_BOOTS.get()).getMaterial();
        case "TITANITE" -> ((ArmorItem) ModArmors.TITANITE_BOOTS.get()).getMaterial();
        case "ICHOR" -> ((ArmorItem) ModArmors.ICHOR_BOOTS.get()).getMaterial();
        case "ASTRAL" -> ((ArmorItem) ModArmors.ASTRAL_BOOTS.get()).getMaterial();
        default -> throw new IllegalStateException("Unexpected material name: " + material);
    }),
    DEEPER_AND_DARKER("deeperdarker", "deeper_darker", material -> DDArmorMaterials.valueOf(material)),
    BOTANIA("botania", "botania", material -> switch (material) {
        case "MANASTEEL" -> BotaniaAPI.instance().getManasteelArmorMaterial();
        case "ELEMENTIUM" -> BotaniaAPI.instance().getElementiumArmorMaterial();
        case "MANAWEAVE" -> BotaniaAPI.instance().getManaweaveArmorMaterial();
        case "TERRASTEEL" -> BotaniaAPI.instance().getTerrasteelArmorMaterial();
        default -> throw new IllegalStateException("Unexpected material name: " + material);
    }),
    SAVAGE_AND_RAVAGE("savage_and_ravage", CreativeModeTabs.COMBAT.location().toString(), material -> SRTiers.GRIEFER),
    ;
    private final String sourceModId;
    private final boolean isLoaded;
    private final Set<ResourceLocation> creativeTabs;
    private final Function<String, ArmorMaterial> armorMaterial;

    CompatModule(String sourceModId, Set<String> creativeTabs, Function<String, ArmorMaterial> armorMaterial) {
        this.sourceModId = sourceModId;
        this.isLoaded = ModList.get().isLoaded(sourceModId);
        this.creativeTabs = creativeTabs.stream()
                .map(tab -> tab.contains(":")
                        ? new ResourceLocation(tab)
                        : new ResourceLocation(sourceModId, tab))
                .collect(Collectors.toSet());
        this.armorMaterial = armorMaterial;
    }

    CompatModule(String sourceModId, String creativeTab, Function<String, ArmorMaterial> armorMaterial) {
        this(sourceModId, Set.of(creativeTab), armorMaterial);
    }

    public String getSourceModId() {
        return sourceModId;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public Set<ResourceLocation> getCreativeTabs() {
        return creativeTabs;
    }

    public ArmorMaterial getArmorMaterial(CompatArmorMaterial material) {
        return armorMaterial.apply(material.name());
    }
}
