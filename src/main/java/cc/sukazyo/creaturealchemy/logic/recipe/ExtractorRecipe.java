package cc.sukazyo.creaturealchemy.logic.recipe;

import cc.sukazyo.creaturealchemy.struct.ItemSummonTable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractorRecipe {
	
	public static final Map<Block, ItemSummonTable> extractStack = new HashMap<>();
	
	public static void addRecipe (Block target, ItemSummonTable drops) {
		extractStack.put(target, drops);
	}
	
	public static List<ItemStack> getExtractDrops (IBlockState state) {
		return extractStack.containsKey(state.getBlock()) ? extractStack.get(state.getBlock()).summon() : null;
	}
	
	public static void extractAction (BlockEvent.HarvestDropsEvent event) {
		if (ExtractorRecipe.extractStack.containsKey(event.getState().getBlock())) {
			List<ItemStack> drops = getExtractDrops(event.getState());
			if (drops != null) {
				event.getDrops().clear();
				event.getDrops().addAll(drops);
			}
		}
	}
	
}
