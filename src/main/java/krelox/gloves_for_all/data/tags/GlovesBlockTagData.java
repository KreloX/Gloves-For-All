package krelox.gloves_for_all.data.tags;

import krelox.gloves_for_all.GlovesForAll;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class GlovesBlockTagData extends BlockTagsProvider {
    public GlovesBlockTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper helper) {
        super(output, registries, GlovesForAll.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}
