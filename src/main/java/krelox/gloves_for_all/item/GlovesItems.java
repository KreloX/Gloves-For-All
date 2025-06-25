package krelox.gloves_for_all.item;

import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vazkii.botania.common.item.BotaniaItems;

import java.util.function.Supplier;

import static krelox.gloves_for_all.item.CompatArmorMaterial.*;

@SuppressWarnings("unused")
public class GlovesItems {
    private GlovesItems() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlovesForAll.MOD_ID);

    // Caverns & Chasms
    public static final RegistryObject<Item> SILVER_GLOVES = registerGloves(SILVER, () -> new SilverGlovesItem(SILVER, 0.15, new Item.Properties()));
    public static final RegistryObject<Item> NECROMIUM_GLOVES = registerGloves(NECROMIUM, () -> new NecromiumGlovesItem(NECROMIUM, 0.75, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SANGUINE_GLOVES = registerGloves(SANGUINE, () -> new SanguineGlovesItem(SANGUINE, 0.65, new Item.Properties()));
    // Oreganized
    public static final RegistryObject<Item> ELECTRUM_GLOVES = registerGloves(ELECTRUM, () -> new ElectrumGlovesItem(ELECTRUM, 0.75, new Item.Properties()));
    // Mekanism Tools
    public static final RegistryObject<Item> BRONZE_GLOVES = registerGloves(BRONZE, 0.5);
    public static final RegistryObject<Item> LAPIS_LAZULI_GLOVES = registerGloves(LAPIS_LAZULI, 0.35);
    public static final RegistryObject<Item> OSMIUM_GLOVES = registerGloves(OSMIUM, 1.0);
    public static final RegistryObject<Item> REFINED_GLOWSTONE_GLOVES = registerGloves(REFINED_GLOWSTONE, 0.5);
    public static final RegistryObject<Item> REFINED_OBSIDIAN_GLOVES = registerGloves(REFINED_OBSIDIAN, 1.6);
    public static final RegistryObject<Item> STEEL_GLOVES = registerGloves(STEEL, 0.75);
    // SimpleOres
    public static final RegistryObject<Item> COPPER_GLOVES = registerGloves(COPPER, 0.25);
    public static final RegistryObject<Item> TIN_GLOVES = registerGloves(TIN, 0.25);
    public static final RegistryObject<Item> MYTHRIL_GLOVES = registerGloves(MYTHRIL, 0.75);
    public static final RegistryObject<Item> ADAMANTIUM_GLOVES = registerGloves(ADAMANTIUM, 0.75);
    public static final RegistryObject<Item> ONYX_GLOVES = registerGloves(ONYX, 1.25);
    // Additional Additions
    public static final RegistryObject<Item> ROSE_GOLD_GLOVES = registerGloves(ROSE_GOLD, 0.75);
    public static final RegistryObject<Item> GILDED_NETHERITE_GLOVES = registerGloves(GILDED_NETHERITE, 1.0);
    // Redstone Arsenal
    public static final RegistryObject<Item> FLUX_INFUSED_GLOVES = registerGloves(FLUX, () -> CompatModule.REDSTONE_ARSENAL.isLoaded()
            ? new FluxGlovesItem(FLUX, 0.85, 800000, 10000, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).setNoRepair()).disableTrimming()
            : new CompatGlovesItem(FLUX, 0.85, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).setNoRepair()).disableTrimming());
    // Galosphere
    public static final RegistryObject<Item> STERLING_GLOVES = registerGloves(STERLING, 0.35);
    // Undergarden
    public static final RegistryObject<Item> CLOGGRUM_GLOVES = registerGloves(CLOGGRUM, 0.75);
    public static final RegistryObject<Item> FROSTSTEEL_GLOVES = registerGloves(FROSTSTEEL, 0.5);
    public static final RegistryObject<Item> UTHERIUM_GLOVES = registerGloves(UTHERIUM, 0.85);
    // Blue Skies
    public static final RegistryObject<Item> PYROPE_GLOVES = registerGloves(PYROPE, 0.35);
    public static final RegistryObject<Item> AQUITE_GLOVES = registerGloves(AQUITE, 0.5);
    public static final RegistryObject<Item> HORIZONITE_GLOVES = registerGloves(HORIZONITE, 0.5);
    public static final RegistryObject<Item> DIOPSIDE_GLOVES = registerGloves(DIOPSIDE, 1.1);
    public static final RegistryObject<Item> CHAROITE_GLOVES = registerGloves(CHAROITE, 0.75);
    // Voidscape
    public static final RegistryObject<Item> VOIDIC_CRYSTAL_GLOVES = registerGloves(VOIDIC_CRYSTAL, () -> new VoidscapeGlovesItem(VOIDIC_CRYSTAL, 1.25, 0.1, new Item.Properties().fireResistant()).disableTrimming());
    public static final RegistryObject<Item> CORRUPT_GLOVES = registerGloves(CORRUPT, () -> new VoidscapeGlovesItem(CORRUPT, 1.35, 0.2, new Item.Properties().fireResistant()).disableTrimming());
    public static final RegistryObject<Item> TITANITE_GLOVES = registerGloves(TITANITE, () -> new VoidscapeGlovesItem(TITANITE, 1.5, 0.3, new Item.Properties().fireResistant()).disableTrimming());
    public static final RegistryObject<Item> ICHOR_GLOVES = registerGloves(ICHOR, () -> new VoidscapeGlovesItem(ICHOR, 1.6, 0.4, new Item.Properties().fireResistant()).disableTrimming());
    public static final RegistryObject<Item> ASTRAL_GLOVES = registerGloves(ASTRAL, () -> new VoidscapeGlovesItem(ASTRAL, 1.75, 0.5, new Item.Properties().fireResistant()).disableTrimming());
    // Deeper and Darker
    public static final RegistryObject<Item> RESONARIUM_GLOVES = registerGloves(RESONARIUM, 0.75);
    public static final RegistryObject<Item> WARDEN_GLOVES = registerGloves(WARDEN, () -> new WardenGlovesItem(WARDEN, 1.25, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    // Botania
    public static final RegistryObject<Item> MANASTEEL_GLOVES = registerGloves(MANASTEEL, () -> CompatModule.BOTANIA.isLoaded()
            ? new ManasteelGlovesItem(MANASTEEL, 0.5, () -> () -> BotaniaItems.manasteelBoots, new Item.Properties()).disableTrimming()
            : new CompatGlovesItem(MANASTEEL, 0.5, new Item.Properties()).disableTrimming());
    public static final RegistryObject<Item> ELEMENTIUM_GLOVES = registerGloves(ELEMENTIUM, () -> CompatModule.BOTANIA.isLoaded()
            ? new ElementiumGlovesItem(ELEMENTIUM, 0.5, () -> () -> BotaniaItems.elementiumBoots, new Item.Properties()).disableTrimming()
            : new CompatGlovesItem(ELEMENTIUM, 0.5, new Item.Properties()).disableTrimming());
    public static final RegistryObject<Item> MANAWEAVE_GLOVES = registerGloves(MANAWEAVE, () -> CompatModule.BOTANIA.isLoaded()
            ? new ManasteelGlovesItem(MANAWEAVE, 0.25, () -> () -> BotaniaItems.manaweaveBoots, new Item.Properties()).disableTrimming()
            : new CompatGlovesItem(MANAWEAVE, 0.25, new Item.Properties()).disableTrimming());
    public static final RegistryObject<Item> TERRASTEEL_GLOVES = registerGloves(TERRASTEEL, () -> CompatModule.BOTANIA.isLoaded()
            ? new ManasteelGlovesItem(TERRASTEEL, 1.0, () -> () -> BotaniaItems.terrasteelBoots, new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)).disableTrimming()
            : new CompatGlovesItem(TERRASTEEL, 1.0, new Item.Properties()).disableTrimming());
    // Savage & Ravage
    public static final RegistryObject<Item> GRIEFER_GLOVES = registerGloves(GRIEFER, () -> new GrieferGlovesItem(GRIEFER, 0.5, new Item.Properties()).disableTrimming());

    private static RegistryObject<Item> registerGloves(CompatArmorMaterial material, Supplier<CompatGlovesItem> itemSupplier) {
        return ITEMS.register(material.getName() + "_gloves", itemSupplier);
    }

    private static RegistryObject<Item> registerGloves(CompatArmorMaterial material, double punchDamage) {
        return registerGloves(material, () -> new CompatGlovesItem(material, punchDamage, new Item.Properties()));
    }
}
