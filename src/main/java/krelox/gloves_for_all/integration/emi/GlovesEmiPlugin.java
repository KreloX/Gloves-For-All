package krelox.gloves_for_all.integration.emi;

import cofh.thermal.lib.util.ThermalFlags;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiInitRegistry;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import krelox.gloves_for_all.item.GlovesItems;
import krelox.gloves_for_all.item.gloves.CompatGlovesItem;

@EmiEntrypoint
public class GlovesEmiPlugin implements EmiPlugin {
    @Override
    public void initialize(EmiInitRegistry registry) {
        registry.disableStacks(emiStack ->
                emiStack.getItemStack().getItem() instanceof CompatGlovesItem gloves
                        && !gloves.getCompatMaterial().getCompatModule().isLoaded()
        );
    }

    @Override
    public void register(EmiRegistry registry) {
        registry.removeEmiStacks(emiStack -> {
            if (!(emiStack.getItemStack().getItem() instanceof CompatGlovesItem gloves)) return false;

            if (!gloves.getCompatMaterial().getCompatModule().isLoaded()) return true;

            return switch (gloves.getCompatMaterial()) {
                case COPPER -> emiStack.getItemStack().is(GlovesItems.WAXED_COPPER_GLOVES.get());
                case EXPOSED_COPPER, WEATHERED_COPPER, OXIDIZED_COPPER -> true;
                case BEEKEEPER -> !ThermalFlags.getFlag(ThermalFlags.FLAG_BEEKEEPER_ARMOR).get();
                case DIVING -> !ThermalFlags.getFlag(ThermalFlags.FLAG_DIVING_ARMOR).get();
                case HAZMAT -> !ThermalFlags.getFlag(ThermalFlags.FLAG_HAZMAT_ARMOR).get();
                default -> false;
            };
        });
    }
}
