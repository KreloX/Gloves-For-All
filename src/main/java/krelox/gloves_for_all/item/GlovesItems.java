package krelox.gloves_for_all.item;

import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.function.TriFunction;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static krelox.gloves_for_all.item.CompatMaterial.*;

public class GlovesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlovesForAll.MOD_ID);

    // Caverns & Chasms
    public static final RegistryObject<Item> SILVER_GLOVES = registerGloves(SILVER, 0.15, SilverGlovesItem::new);
    public static final RegistryObject<Item> NECROMIUM_GLOVES = registerGloves(NECROMIUM, 0.75, NecromiumGlovesItem::new);
    public static final RegistryObject<Item> SANGUINE_GLOVES = registerGloves(SANGUINE, 0.65, SanguineGlovesItem::new);
    // Savage & Ravage
    public static final RegistryObject<Item> GRIEFER_GLOVES = registerGloves(GRIEFER, 0.5, GrieferGlovesItem::new);
    // Oreganized
    public static final RegistryObject<Item> ELECTRUM_GLOVES = registerGloves(ELECTRUM, 0.75, ElectrumGlovesItem::new);
    // Galosphere
    public static final RegistryObject<Item> STERLING_GLOVES = registerGloves(STERLING, 0.35);
    // Additional Additions
    public static final RegistryObject<Item> ROSE_GOLD_GLOVES = registerGloves(ROSE_GOLD, 0.75);
    public static final RegistryObject<Item> GILDED_NETHERITE_GLOVES = registerGloves(GILDED_NETHERITE, 1.0);
    // SimpleOres
    public static final RegistryObject<Item> COPPER_GLOVES = registerGloves(COPPER, 0.25);
    public static final RegistryObject<Item> TIN_GLOVES = registerGloves(TIN, 0.25);
    public static final RegistryObject<Item> MYTHRIL_GLOVES = registerGloves(MYTHRIL, 0.75);
    public static final RegistryObject<Item> ADAMANTIUM_GLOVES = registerGloves(ADAMANTIUM, 0.75);
    public static final RegistryObject<Item> ONYX_GLOVES = registerGloves(ONYX, 1.25);

    // Undergarden
    public static final RegistryObject<Item> CLOGGRUM_GLOVES = registerGloves(CLOGGRUM, 0.75);
    public static final RegistryObject<Item> FROSTSTEEL_GLOVES = registerGloves(FROSTSTEEL, 0.5, FroststeelGlovesItem::new);
    public static final RegistryObject<Item> UTHERIUM_GLOVES = registerGloves(UTHERIUM, 0.85, UtheriumGlovesItem::new);
    // Blue Skies
    public static final RegistryObject<Item> PYROPE_GLOVES = registerGloves(PYROPE, 0.35,
            CompatModule.BLUE_SKIES.isLoaded() ? BlueSkiesGlovesItem::new : CompatGlovesItem::new);
    public static final RegistryObject<Item> AQUITE_GLOVES = registerGloves(AQUITE, 0.5,
            CompatModule.BLUE_SKIES.isLoaded() ? BlueSkiesGlovesItem::new : CompatGlovesItem::new);
    public static final RegistryObject<Item> HORIZONITE_GLOVES = registerGloves(HORIZONITE, 0.5,
            CompatModule.BLUE_SKIES.isLoaded() ? HorizoniteGlovesItem::new : CompatGlovesItem::new);
    public static final RegistryObject<Item> DIOPSIDE_GLOVES = registerGloves(DIOPSIDE, 1.1,
            CompatModule.BLUE_SKIES.isLoaded() ? BlueSkiesGlovesItem::new : CompatGlovesItem::new);
    public static final RegistryObject<Item> CHAROITE_GLOVES = registerGloves(CHAROITE, 0.75,
            CompatModule.BLUE_SKIES.isLoaded() ? BlueSkiesGlovesItem::new : CompatGlovesItem::new);
    // Voidscape
    public static final RegistryObject<Item> VOIDIC_CRYSTAL_GLOVES = registerGloves(VOIDIC_CRYSTAL, 1.25,
            (material, punchDamage, properties) -> new VoidscapeGlovesItem(material, punchDamage, 0.1, properties));
    public static final RegistryObject<Item> CORRUPT_GLOVES = registerGloves(CORRUPT, 1.35,
            (material, punchDamage, properties) -> new VoidscapeGlovesItem(material, punchDamage, 0.2, properties));
    public static final RegistryObject<Item> TITANITE_GLOVES = registerGloves(TITANITE, 1.5,
            (material, punchDamage, properties) -> new VoidscapeGlovesItem(material, punchDamage, 0.3, properties));
    public static final RegistryObject<Item> ICHOR_GLOVES = registerGloves(ICHOR, 1.6,
            (material, punchDamage, properties) -> new VoidscapeGlovesItem(material, punchDamage, 0.4, properties));
    public static final RegistryObject<Item> ASTRAL_GLOVES = registerGloves(ASTRAL, 1.75,
            (material, punchDamage, properties) -> new VoidscapeGlovesItem(material, punchDamage, 0.5, properties));
    // Midnight
    public static final RegistryObject<Item> ROCKSHROOM_GLOVES = registerGloves(ROCKSHROOM, 0.35);
    public static final RegistryObject<Item> TENEBRUM_GLOVES = registerGloves(TENEBRUM, 0.85, TenebrumGlovesItem::new);
    // Deeper and Darker
    public static final RegistryObject<Item> RESONARIUM_GLOVES = registerGloves(RESONARIUM, 0.75);
    public static final RegistryObject<Item> WARDEN_GLOVES = registerGloves(WARDEN, 1.25, WardenGlovesItem::new);

    // Botania
    public static final RegistryObject<Item> MANASTEEL_GLOVES = registerGloves(MANASTEEL, 0.5, BotaniaGlovesItem::new);
    public static final RegistryObject<Item> ELEMENTIUM_GLOVES = registerGloves(ELEMENTIUM, 0.5, ElementiumGlovesItem::new);
    public static final RegistryObject<Item> MANAWEAVE_GLOVES = registerGloves(MANAWEAVE, 0.25, BotaniaGlovesItem::new);
    public static final RegistryObject<Item> TERRASTEEL_GLOVES = registerGloves(TERRASTEEL, 1.0, BotaniaGlovesItem::new);

    // Create
    public static final RegistryObject<Item> CARDBOARD_GLOVES = registerGloves(CARDBOARD, 0.25, CardboardGlovesItem::new);
    // Redstone Arsenal
    public static final RegistryObject<Item> FLUX_INFUSED_GLOVES = registerGloves(FLUX_INFUSED, 0.85,
            CompatModule.REDSTONE_ARSENAL.isLoaded() ? FluxInfusedGlovesItem::new : CompatGlovesItem::new);
    // Thermal Core
    public static final RegistryObject<Item> BEEKEEPER_GLOVES = registerGloves(BEEKEEPER, 0.25, TooltipGlovesItem::new);
    public static final RegistryObject<Item> DIVING_GLOVES = registerGloves(DIVING, 0.35, DivingGlovesItem::new);
    public static final RegistryObject<Item> HAZMAT_GLOVES = registerGloves(HAZMAT, 0.35, TooltipGlovesItem::new);
    // Thermal Extra
    public static final RegistryObject<Item> SIGNALUM_GLOVES = registerGloves(SIGNALUM, 0.85);
    public static final RegistryObject<Item> LUMIUM_GLOVES = registerGloves(LUMIUM, 0.85);
    public static final RegistryObject<Item> ENDERIUM_GLOVES = registerGloves(ENDERIUM, 1.1);
    public static final RegistryObject<Item> SOUL_INFUSED_GLOVES = registerGloves(SOUL_INFUSED, 0.85);
    public static final RegistryObject<Item> SHELLITE_GLOVES = registerGloves(SHELLITE, 1.35);
    public static final RegistryObject<Item> TWINITE_GLOVES = registerGloves(TWINITE, 1.25);
    public static final RegistryObject<Item> DRAGONSTEEL_GLOVES = registerGloves(DRAGONSTEEL, 1.35);
    public static final RegistryObject<Item> ABYSSAL_GLOVES = registerGloves(ABYSSAL, 1.5);
    // Mekanism Tools
    public static final RegistryObject<Item> BRONZE_GLOVES = registerGloves(BRONZE, 0.5, MekanismToolsGlovesItem::new);
    public static final RegistryObject<Item> LAPIS_LAZULI_GLOVES = registerGloves(LAPIS_LAZULI, 0.35, MekanismToolsGlovesItem::new);
    public static final RegistryObject<Item> OSMIUM_GLOVES = registerGloves(OSMIUM, 1.0, MekanismToolsGlovesItem::new);
    public static final RegistryObject<Item> REFINED_GLOWSTONE_GLOVES = registerGloves(REFINED_GLOWSTONE, 0.5, MekanismToolsGlovesItem::new);
    public static final RegistryObject<Item> REFINED_OBSIDIAN_GLOVES = registerGloves(REFINED_OBSIDIAN, 1.6, MekanismToolsGlovesItem::new);
    public static final RegistryObject<Item> STEEL_GLOVES = registerGloves(STEEL, 0.75, MekanismToolsGlovesItem::new);

    // Ice and Fire
    public static final RegistryObject<Item> IAF_SILVER_GLOVES = registerGloves(IAF_SILVER, 0.35);
    public static final RegistryObject<Item> IAF_COPPER_GLOVES = registerGloves(IAF_COPPER, 0.25);
    public static final RegistryObject<Item> SHEEP_DISGUISE_GLOVES = registerGloves(SHEEP_DISGUISE, 0.25);
    public static final RegistryObject<Item> FIRE_DRAGONSTEEL_GLOVES = registerGloves(FIRE_DRAGONSTEEL, 3.25);
    public static final RegistryObject<Item> ICE_DRAGONSTEEL_GLOVES = registerGloves(ICE_DRAGONSTEEL, 3.25);
    public static final RegistryObject<Item> LIGHTNING_DRAGONSTEEL_GLOVES = registerGloves(LIGHTNING_DRAGONSTEEL, 3.25);
    public static final Map<String, RegistryObject<Item>> TIDE_GUARDIAN_GLOVES_MAP =
            Stream.of("blue", "bronze", "deepblue", "green", "purple", "red", "teal")
                    .collect(Collectors.toUnmodifiableMap(
                            color -> color,
                            color -> ITEMS.register(
                                    TIDE_GUARDIAN.getSerializedName().replace("/", "/" + color + "_") + "_gloves",
                                    () -> new TideGuardianGlovesItem(TIDE_GUARDIAN, 1.1, color, TIDE_GUARDIAN.applyCompatProperties(new Item.Properties()))
                            )
                    ));

    private static RegistryObject<Item> registerGloves(CompatMaterial material, double punchDamage, TriFunction<CompatMaterial, Double, Item.Properties, CompatGlovesItem> glovesConstructor) {
        return ITEMS.register(material.getSerializedName() + "_gloves", () -> glovesConstructor.apply(material, punchDamage, material.applyCompatProperties(new Item.Properties())));
    }

    private static RegistryObject<Item> registerGloves(CompatMaterial material, double punchDamage) {
        return registerGloves(material, punchDamage, CompatGlovesItem::new);
    }

    private GlovesItems() {
    }
}
