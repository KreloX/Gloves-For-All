package krelox.gloves_for_all.integration.rei;

import krelox.gloves_for_all.item.GlovesCreativeTabs;
import krelox.gloves_for_all.item.GlovesItems;
import me.shedaniel.rei.api.client.entry.filtering.base.BasicFilteringRule;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;

@REIPluginClient
public class GlovesREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerBasicEntryFiltering(BasicFilteringRule<?> rule) {
        rule.hide(() -> {
            var builder = EntryIngredient.builder();
            for (var item : GlovesItems.ITEMS.getEntries()) {
                if (GlovesCreativeTabs.shouldHide(item.get().getDefaultInstance())) {
                    builder.add(EntryStacks.of(item.get()));
                }
            }
            return builder.build();
        });
    }
}
