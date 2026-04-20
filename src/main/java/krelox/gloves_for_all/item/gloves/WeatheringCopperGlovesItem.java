package krelox.gloves_for_all.item.gloves;

import com.teamabnormals.caverns_and_chasms.common.item.copper.WeatheringCopperItem;
import krelox.gloves_for_all.item.CompatMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.WeatheringCopper;
import top.theillusivec4.curios.api.SlotContext;

public class WeatheringCopperGlovesItem extends CopperGlovesItem implements WeatheringCopperItem {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperGlovesItem(WeatheringCopper.WeatherState weatherState, CompatMaterial material, double punchDamage, Properties properties) {
        super(material, punchDamage, properties);
        this.weatherState = weatherState;
    }

    public WeatheringCopperGlovesItem(CompatMaterial material, double punchDamage, Properties properties) {
        this(switch (material) {
            case COPPER -> WeatheringCopper.WeatherState.UNAFFECTED;
            case EXPOSED_COPPER -> WeatheringCopper.WeatherState.EXPOSED;
            case WEATHERED_COPPER -> WeatheringCopper.WeatherState.WEATHERED;
            case OXIDIZED_COPPER -> WeatheringCopper.WeatherState.OXIDIZED;
            default -> throw new IllegalArgumentException("Invalid material for weathering copper gloves: " + material);
        }, material, punchDamage, properties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        updateOxidation(stack, slotContext.entity().level());
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return weatherState;
    }
}
