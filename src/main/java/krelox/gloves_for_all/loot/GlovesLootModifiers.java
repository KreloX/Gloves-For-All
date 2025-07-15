package krelox.gloves_for_all.loot;

import com.mojang.serialization.Codec;
import krelox.gloves_for_all.GlovesForAll;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GlovesLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, GlovesForAll.MOD_ID);

    @SuppressWarnings("unused")
    public static final RegistryObject<Codec<CompatGlovesLootModifier>> GLOVES_LOOT = GLOBAL_LOOT_MODIFIERS.register("gloves_loot", () -> CompatGlovesLootModifier.CODEC);
    
    private GlovesLootModifiers() {
    }
}
