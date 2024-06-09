package cc.sukazyo.creature_alchemy.items;

import cc.sukazyo.creature_alchemy.tools.extractor.ExtractorRecipe;
import cc.sukazyo.creature_alchemy.tools.extractor.ExtractorRecipes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemExtractor extends CreatureAlchemyItemBase {
	
	
	public ItemExtractor (String id) {
		super(
				id,
				new FabricItemSettings()
						.maxDamage(288)
		);
	}
	
	@Override
	public boolean isSuitableFor (BlockState state) {
		return ExtractorRecipes.canMine(state.getBlock());
	}
	
	@Override
	public float getMiningSpeedMultiplier (ItemStack stack, BlockState state) {
		ExtractorRecipe recipe = ExtractorRecipes.getRecipe(state.getBlock());
		if (recipe != null)
			return recipe.miningSpeed;
		return super.getMiningSpeedMultiplier(stack, state);
	}
	
	@Override
	public boolean postMine (ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
		if (!state.isOf(Blocks.FIRE)) {
			stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
			return true;
		}
		return super.postMine(stack, world, state, pos, miner);
	}
	
}
