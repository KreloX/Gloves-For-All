package krelox.gloves_for_all.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import krelox.gloves_for_all.item.CompatMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class CompatGlovesLootModifier extends LootModifier {
    public static final Codec<CompatGlovesLootModifier> CODEC = RecordCodecBuilder.create(instance -> codecStart(instance)
            .and(ItemStack.CODEC.fieldOf("gloves").forGetter(modifier -> modifier.glovesStack))
            .and(CompatMaterial.CODEC.fieldOf("compat_material").forGetter(modifier -> modifier.compatMaterial))
            .apply(instance, CompatGlovesLootModifier::new));

    public final ItemStack glovesStack;
    public final CompatMaterial compatMaterial;

    public CompatGlovesLootModifier(LootItemCondition[] conditionsIn, ItemStack glovesStack, CompatMaterial compatMaterial) {
        super(conditionsIn);
        this.glovesStack = glovesStack;
        this.compatMaterial = compatMaterial;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> lootStacks, LootContext context) {
        var vec3 = context.getParamOrNull(LootContextParams.ORIGIN);
        if (compatMaterial.getCompatModule().isLoaded() && vec3 != null && context.getLevel().getBlockEntity(BlockPos.containing(vec3)) instanceof BaseContainerBlockEntity) {
            var randomSource = context.getRandom();
            lootStacks.stream()
                    .filter(itemStack -> itemStack.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == compatMaterial.getArmorMaterial())
                    .forEach(armorStack -> {
                        if (randomSource.nextInt(4) < 1) {
                            ItemStack gloves = glovesStack.copy();
                            int cost = 0;
                            boolean isTreasure = false;
                            for (var enchantmentInfo : armorStack.getAllEnchantments().entrySet()) {
                                var enchantment = enchantmentInfo.getKey();
                                int level = enchantmentInfo.getValue();
                                cost = Math.max(cost, enchantment.getMinCost(level));
                                isTreasure = isTreasure || enchantment.isTreasureOnly();
                                if (gloves.canApplyAtEnchantingTable(enchantment)) {
                                    gloves.enchant(enchantment, enchantmentInfo.getValue());
                                }
                            }
                            if (!armorStack.getAllEnchantments().isEmpty() && gloves.getAllEnchantments().isEmpty()) {
                                EnchantmentHelper.enchantItem(randomSource, gloves, cost, isTreasure);
                            }
                            if (armorStack.getAllEnchantments().isEmpty() || !gloves.getAllEnchantments().isEmpty()) {
                                lootStacks.replaceAll(stack -> stack.equals(armorStack) ? gloves : stack);
                            }
                        }
                    });
        }
        return lootStacks;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
