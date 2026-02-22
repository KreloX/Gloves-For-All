package krelox.gloves_for_all.mixin;

import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class GlovesMixinPlugin implements IMixinConfigPlugin {
    public final Map<String, String> mixinToModMap = Map.ofEntries(
            entry("krelox.gloves_for_all.mixin.mixins.common.botania.ManasteelArmorItemMixin", "botania"),
            entry("krelox.gloves_for_all.mixin.mixins.common.caverns_and_chasms.CCEventsMixin", "caverns_and_chasms"),
            entry("krelox.gloves_for_all.mixin.mixins.common.caverns_and_chasms.EnchantmentHelperMixinMixin", "caverns_and_chasms"),
            entry("krelox.gloves_for_all.mixin.mixins.common.cofh_core.ArmorItemCoFHMixin", "cofh_core"),
            entry("krelox.gloves_for_all.mixin.mixins.common.create.CardboardArmorHandlerMixin", "create"),
            entry("krelox.gloves_for_all.mixin.mixins.common.savage_and_ravage.BlastProofArmorTypeMixin", "savage_and_ravage"),
            entry("krelox.gloves_for_all.mixin.mixins.common.savage_and_ravage.SREventsMixin", "savage_and_ravage"),
            entry("krelox.gloves_for_all.mixin.mixins.common.thermal.ArmorEventsMixin", "thermal"),
            entry("krelox.gloves_for_all.mixin.mixins.common.thermal.DivingArmorItemMixin", "thermal"),
            entry("krelox.gloves_for_all.mixin.mixins.common.thermal_extra.CommonEventsMixin", "thermal_extra")
    );

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinToModMap.containsKey(mixinClassName)) {
            return LoadingModList.get().getModFileById(mixinToModMap.get(mixinClassName)) != null;
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
