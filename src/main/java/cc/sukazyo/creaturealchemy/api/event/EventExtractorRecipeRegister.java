package cc.sukazyo.creaturealchemy.api.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.api.recipe.ExtractorRecipe;
import cc.sukazyo.creaturealchemy.struct.ItemSummonTable;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.eventhandler.Event;

public class EventExtractorRecipeRegister extends Event {
	
	/**
	 * @see cc.sukazyo.creaturealchemy.api.recipe.ExtractorRecipe#addRecipe(Block, ItemSummonTable)
	 */
	public void addRecipe (Block target, ItemSummonTable drops) {
		CreatureAlchemy.logger.debug("Extractor recipe register for : " + target.getRegistryName());
		ExtractorRecipe.addRecipe(target, drops);
	}
	
}
