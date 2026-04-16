package krelox.gloves_for_all;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.fml.ModList;

import java.util.Set;
import java.util.stream.Collectors;

public enum CompatModule {
    CAVERNS_AND_CHASMS("caverns_and_chasms", CreativeModeTabs.COMBAT.location().toString()),
    SAVAGE_AND_RAVAGE("savage_and_ravage", CreativeModeTabs.COMBAT.location().toString()),
    OREGANIZED("oreganized", CreativeModeTabs.COMBAT.location().toString()),
    GALOSPHERE("galosphere", Set.of("galosphere", CreativeModeTabs.COMBAT.location().toString())),
    ADDITIONAL_ADDITIONS("additionaladditions", CreativeModeTabs.COMBAT.location().toString()),
    SIMPLEORES("simpleores", "simplecore_tab"),

    UNDERGARDEN("undergarden", "undergarden_group"),
    BLUE_SKIES("blue_skies", "all_items"),
    VOIDSCAPE("voidscape", "tab"),
    MIDNIGHT("midnight", "items"),
    DEEPER_AND_DARKER("deeperdarker", "deeper_darker"),

    BOTANIA("botania", "botania"),

    CREATE("create", "base"),
    REDSTONE_ARSENAL("redstone_arsenal", "redstone_arsenal"),
    THERMAL("thermal", "thermal.tools"),
    THERMAL_EXTRA("thermal_extra", "resources"),
    MEKANISM_TOOLS("mekanismtools", Set.of("mekanismtools", CreativeModeTabs.COMBAT.location().toString())),

    ICE_AND_FIRE("iceandfire", "items"),
    ;
    private final String sourceModId;
    private final boolean isLoaded;
    private final Set<ResourceLocation> creativeTabs;

    CompatModule(String sourceModId, Set<String> creativeTabs) {
        this.sourceModId = sourceModId;
        this.isLoaded = ModList.get().isLoaded(sourceModId);
        this.creativeTabs = creativeTabs.stream()
                .map(tab -> tab.contains(":")
                        ? new ResourceLocation(tab)
                        : new ResourceLocation(sourceModId, tab))
                .collect(Collectors.toSet());
    }

    CompatModule(String sourceModId, String creativeTab) {
        this(sourceModId, Set.of(creativeTab));
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
}
