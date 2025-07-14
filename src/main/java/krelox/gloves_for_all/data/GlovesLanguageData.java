package krelox.gloves_for_all.data;

import com.aetherteam.nitrogen.data.providers.NitrogenLanguageProvider;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import org.codehaus.plexus.util.StringUtils;

import java.util.function.Supplier;

public class GlovesLanguageData extends NitrogenLanguageProvider {
    public GlovesLanguageData(PackOutput output) {
        super(output, GlovesForAll.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        for (var item : GlovesItems.ITEMS.getEntries()) {
            addItem(item, StringUtils.capitaliseAllWords(item.getId().getPath().replace('_', ' ')));
        }

        for (var seaSerpentScaleGloves : GlovesItems.SEA_SERPENT_SCALE_GLOVES_MAP.values()) {
            overwriteItem(seaSerpentScaleGloves, "Tide Guardian Gloves");
        }
        overwriteItem(GlovesItems.FLUX_INFUSED_GLOVES, "Flux-Infused Gloves");

        addPackTitle("armor_overrides", "Aether Armor Overrides");

        addPackDescription("mod", "The Aether: Gloves For All Resources");
        addPackDescription("armor_overrides", "Removes glove parts of modded armor textures");
    }

    private void overwriteItem(Supplier<? extends Item> key, String name) {
        try {
            addItem(key, name);
        } catch (IllegalStateException ignored) {
            // ignore duplicate translation key
        }
    }
}
