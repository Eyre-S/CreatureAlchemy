package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import cc.sukazyo.creaturealchemy.logic.recipe.ExtractorRecipe;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CreatureAlchemy.MODID)
public class EventPlayerAction {
	
	@SubscribeEvent
	public static void onHarvesting(BlockEvent.HarvestDropsEvent event) {
		if (event.getHarvester().getHeldItemMainhand().getItem() == CreatureAlchemyItems.EXTRACTOR) {
			ExtractorRecipe.extractAction(event);
		}
	}
	
}
