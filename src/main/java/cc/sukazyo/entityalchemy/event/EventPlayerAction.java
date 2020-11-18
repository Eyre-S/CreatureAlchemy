package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.logic.recipe.ExtractorRecipe;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EntityAlchemy.MODID)
public class EventPlayerAction {
	
	@SubscribeEvent
	public static void onHarvesting(BlockEvent.HarvestDropsEvent event) {
		if (event.getHarvester().getHeldItemMainhand().getItem() == EntityAlchemyItems.EXTRACTOR) {
			ExtractorRecipe.extractAction(event);
		}
	}
	
}
