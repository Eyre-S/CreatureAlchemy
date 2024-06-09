package cc.sukazyo.creature_alchemy.events;

import cc.sukazyo.creature_alchemy.CreatureAlchemy;
import cc.sukazyo.creature_alchemy.events.api.block.BlockGetDroppedStacksCallback;
import cc.sukazyo.creature_alchemy.events.api.init.ModInitializeCallback;
import cc.sukazyo.creature_alchemy.items.CreatureAlchemyItems;
import cc.sukazyo.creature_alchemy.tools.extractor.ExtractorRecipe;
import cc.sukazyo.creature_alchemy.tools.extractor.ExtractorRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collections;
import java.util.List;

public class ExtractorsHandler implements
		ModInitializeCallback, BlockGetDroppedStacksCallback
{
	
	
	@Override
	public void onInitialize () {
		
		ExtractorRecipes.register(
				new ExtractorRecipe(
						List.of(
								Blocks.STONE, Blocks.COBBLESTONE, Blocks.BLACKSTONE,
								Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE
						),
						() -> List.of(new ItemStack(CreatureAlchemyItems.PEBBLE, 12)),
						2f
				),
				new ExtractorRecipe(
						List.of(
								Blocks.WHITE_WOOL, Blocks.BLACK_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.CYAN_WOOL,
								Blocks.GRAY_WOOL, Blocks.GREEN_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.LIME_WOOL, Blocks.MAGENTA_WOOL,
								Blocks.ORANGE_WOOL, Blocks.PINK_WOOL, Blocks.PURPLE_WOOL, Blocks.RED_WOOL, Blocks.YELLOW_WOOL
						),
						() -> List.of(new ItemStack(Items.STRING, 4)),
						2f
				),
				new ExtractorRecipe(
						Collections.singleton(Blocks.TNT),
						() -> List.of(
								new ItemStack(Items.GUNPOWDER, 4),
								new ItemStack(CreatureAlchemyItems.MYSTERIOUS_COTTON, 1)
						),
						0.1f
				)
		);
		CreatureAlchemy.logger.debug("registered all extractor recipes.");
		
	}
	
	@Override
	public void onBlockGetDroppedStacks (
			BlockState state, LootContextParameterSet.Builder builder,
			CallbackInfoReturnable<List<ItemStack>> cir
	) {
		LootContextParameterSet cxt = builder.add(LootContextParameters.BLOCK_STATE, state).build(LootContextTypes.BLOCK);
		if (cxt.contains(LootContextParameters.TOOL)) {
			ItemStack tool = cxt.get(LootContextParameters.TOOL);
			if (tool.isOf(CreatureAlchemyItems.EXTRACTOR)) {
				if (ExtractorRecipes.canMine(state.getBlock())) {
					cir.setReturnValue(ExtractorRecipes.getMiningDropped(state).stream().toList());
				}
			}
		}
	}
	
}
