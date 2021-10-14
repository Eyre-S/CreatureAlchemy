package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.api.event.EventExtractorRecipeRegister;
import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import cc.sukazyo.creaturealchemy.struct.ItemSummonTable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CreatureAlchemy.MODID)
public class EventRecipeRegistry {
	
	@SubscribeEvent
	public static void registerExtractorRecipe(EventExtractorRecipeRegister event) {
		event.addRecipe(Blocks.STONE, new ItemSummonTable(
				CreatureAlchemyItems.PEBBLE,
				12,
				15
		));
		event.addRecipe(Blocks.COBBLESTONE, new ItemSummonTable(
				CreatureAlchemyItems.PEBBLE,
				12,
				15
		));
		event.addRecipe(Blocks.WOOL, new ItemSummonTable(Items.STRING, 4));
		event.addRecipe(Blocks.TNT,
				new ItemSummonTable(
						Items.GUNPOWDER,
						4
				).add(
						CreatureAlchemyItems.MYSTERIOUS_COTTON,
						-1,
						1
				)
		);
	}
	
}
