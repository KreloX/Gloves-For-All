package krelox.gloves_for_all.integration.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import krelox.gloves_for_all.item.GlovesCreativeTabs;

@EmiEntrypoint
public class GlovesEmiPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.removeEmiStacks(emiStack -> GlovesCreativeTabs.shouldHide(emiStack.getItemStack()));
    }
}
