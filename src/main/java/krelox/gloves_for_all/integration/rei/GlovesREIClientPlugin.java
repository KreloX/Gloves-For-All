package krelox.gloves_for_all.integration.rei;

import krelox.gloves_for_all.item.GlovesItems;
import krelox.gloves_for_all.item.gloves.CompatGlovesItem;
import me.shedaniel.rei.api.client.entry.filtering.base.BasicFilteringRule;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;

@REIPluginClient
public class GlovesREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerBasicEntryFiltering(BasicFilteringRule<?> rule) {
        rule.hide(() -> GlovesItems.ITEMS.getEntries().stream()
                .filter(item -> item.get() instanceof CompatGlovesItem gloves
                        && !gloves.getCompatMaterial().getCompatModule().isLoaded())
                .map(item -> EntryStacks.of(item.get()))
                .collect(EntryIngredient.collector())
        );
    }
}
