package krelox.gloves_for_all;

import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import com.aetherteam.aether.item.AetherItems;
import com.teamabnormals.caverns_and_chasms.core.CCConfig;
import com.teamabnormals.caverns_and_chasms.core.registry.CCAttributes;
import krelox.gloves_for_all.data.GlovesItemModelData;
import krelox.gloves_for_all.data.GlovesLanguageData;
import krelox.gloves_for_all.data.GlovesLootModifierData;
import krelox.gloves_for_all.data.GlovesRecipeData;
import krelox.gloves_for_all.data.conditions.GenericItemExistsCondition;
import krelox.gloves_for_all.data.tags.GlovesBlockTagData;
import krelox.gloves_for_all.data.tags.GlovesItemTagData;
import krelox.gloves_for_all.item.CompatModule;
import krelox.gloves_for_all.item.GlovesCreativeTabs;
import krelox.gloves_for_all.item.GlovesItems;
import krelox.gloves_for_all.item.VoidscapeGlovesItem;
import krelox.gloves_for_all.loot.GlovesLootModifiers;
import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;

import java.util.Map;
import java.util.function.Consumer;

import static krelox.gloves_for_all.item.GlovesItems.*;

@Mod(GlovesForAll.MOD_ID)
public class GlovesForAll {
    public static final String MOD_ID = "aether_gloves_for_all";

    public GlovesForAll() {
        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CraftingHelper.register(new GenericItemExistsCondition.Serializer());

        MinecraftForge.EVENT_BUS.addListener(this::modifyCurioAttributes);
        modEventBus.addListener(GlovesCreativeTabs::buildCreativeModeTabContents);

        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::dataSetup);
        modEventBus.addListener(this::packSetup);

        GlovesItems.ITEMS.register(modEventBus);
        GlovesLootModifiers.GLOBAL_LOOT_MODIFIERS.register(modEventBus);
    }

    public static ResourceLocation modLoc(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public void modifyCurioAttributes(CurioAttributeModifierEvent event) {
        var stack = event.getItemStack();
        var uuid = event.getUuid();
        if (CompatModule.CAVERNS_AND_CHASMS.isLoaded() && stack.is(AetherItems.GOLDEN_GLOVES.get())) {
            if (CCConfig.COMMON.goldenArmorIncreasesSpeed.get()) {
                event.addModifier(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "Attack speed boost", 0.1, AttributeModifier.Operation.MULTIPLY_BASE));
            }
            event.addModifier(CCAttributes.EXPERIENCE_BOOST.get(), new AttributeModifier(uuid, "Experience boost", 0.25, AttributeModifier.Operation.MULTIPLY_BASE));
        }
    }

    public void clientSetup(FMLClientSetupEvent event) {
        for (var item : GlovesItems.ITEMS.getEntries()) {
            CuriosRendererRegistry.register(item.get(), GlovesRenderer::new);
        }
        event.enqueueWork(() -> {
            Item[] voidscapeGloves = {VOIDIC_CRYSTAL_GLOVES.get(), CORRUPT_GLOVES.get(),
                    TITANITE_GLOVES.get(), ICHOR_GLOVES.get(), ASTRAL_GLOVES.get()};
            for (Item item : voidscapeGloves) {
                ItemProperties.register(item, new ResourceLocation("broken"),
                        (stack, world, living, i) -> VoidscapeGlovesItem.isBroken(stack) ? 1F : 0F);
            }
        });
    }

    public void dataSetup(GatherDataEvent event) {
        var generator = event.getGenerator();
        var fileHelper = event.getExistingFileHelper();
        var lookupProvider = event.getLookupProvider();
        var packOutput = generator.getPackOutput();

        Consumer<DataProvider> client = provider -> generator.addProvider(event.includeClient(), provider);
        Consumer<DataProvider> server = provider -> generator.addProvider(event.includeServer(), provider);

        // Client Data
        client.accept(new GlovesItemModelData(packOutput, fileHelper));
        client.accept(new GlovesLanguageData(packOutput));

        // Server Data
        server.accept(new GlovesRecipeData(packOutput));
        server.accept(new GlovesLootModifierData(packOutput));
        var blockTags = new GlovesBlockTagData(packOutput, lookupProvider, fileHelper);
        server.accept(blockTags);
        server.accept(new GlovesItemTagData(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper));

        // pack.mcmeta
        var packMeta = new PackMetadataGenerator(packOutput);
        var packTypes = Map.of(PackType.SERVER_DATA, SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
        packMeta.add(PackMetadataSection.TYPE, new PackMetadataSection(Component.translatable("pack.%s.mod.description".formatted(MOD_ID)), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), packTypes));
        generator.addProvider(true, packMeta);
    }

    public void packSetup(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var modFile = ModList.get().getModFileById(MOD_ID).getFile();
            var resourcePath = modFile.findResource("packs/gloves_overrides");
            try (var pack = new PathPackResources(modFile.getFileName() + ":" + resourcePath, false, resourcePath)) {
                var metadata = new PackMetadataSection(Component.translatable("pack.aether_gloves_for_all.armor_overrides.description"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES));
                event.addRepositorySource(source ->
                        source.accept(Pack.create(
                                "builtin/gloves_overrides",
                                Component.translatable("pack.aether_gloves_for_all.armor_overrides.title"),
                                true,
                                string -> pack,
                                new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()),
                                PackType.CLIENT_RESOURCES,
                                Pack.Position.TOP,
                                false,
                                PackSource.BUILT_IN)
                        )
                );
            }
        }
    }
}