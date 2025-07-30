package krelox.gloves_for_all.data.tags;

import com.aetherteam.aether.AetherTags;
import com.teamabnormals.savage_and_ravage.core.other.tags.SRItemTags;
import krelox.gloves_for_all.GlovesForAll;
import krelox.gloves_for_all.item.CompatGlovesItem;
import krelox.gloves_for_all.item.GlovesItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class GlovesItemTagData extends ItemTagsProvider {

    public GlovesItemTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper helper) {
        super(output, registries, blockTags, GlovesForAll.MOD_ID, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        for (var item : GlovesItems.ITEMS.getEntries()) {
            tag(AetherTags.Items.ACCESSORIES_GLOVES).add(item.get());
            if (((CompatGlovesItem) item.get()).isTrimmable()) tag(ItemTags.TRIMMABLE_ARMOR).add(item.get());
        }
        tag(SRItemTags.EXPLOSION_IMMUNE).add(GlovesItems.GRIEFER_GLOVES.get());
        tag(ItemTags.PIGLIN_LOVED).add(GlovesItems.FLUX_INFUSED_GLOVES.get(), GlovesItems.TERRASTEEL_GLOVES.get(), GlovesItems.GRIEFER_GLOVES.get());
    }
}
