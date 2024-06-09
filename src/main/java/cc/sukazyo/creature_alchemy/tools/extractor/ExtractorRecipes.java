package cc.sukazyo.creature_alchemy.tools.extractor;

import cc.sukazyo.creature_alchemy.CreatureAlchemy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

import java.util.*;

public class ExtractorRecipes {
	
	public static final List<ExtractorRecipe> recipes = new ArrayList<>();
	
	public static void register (ExtractorRecipe... recipes) {
		List<ExtractorRecipe> li = List.of(recipes);
		li.forEach(x -> CreatureAlchemy.logger.trace("registered new extractor recipe: {}", x));
		ExtractorRecipes.recipes.addAll(li);
	}
	
	public static ExtractorRecipe getRecipe (Block block) {
		return recipes.stream().filter(recipe -> recipe.isTargetBlock(block)).findFirst().orElse(null);
	}
	
	public static boolean canMine (Block block) {
		return getRecipe(block) != null;
	}
	
	public static Collection<ItemStack> getMiningDropped (BlockState block) {
		return getRecipe(block.getBlock())
				.getDrops();
	}
	
}
