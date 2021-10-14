package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import cc.sukazyo.creaturealchemy.gameobj.other.CACreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = CreatureAlchemy.MODID)
public class EventGameObjectRegister {
	
	public static final CACreativeTabs itemTab = new CACreativeTabs();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				CreatureAlchemyItems.MEATBALL,
				CreatureAlchemyItems.EXTRACTOR,
				CreatureAlchemyItems.WOODEN_CHIP,
				CreatureAlchemyItems.EXTRACTOR_HEAD,
				CreatureAlchemyItems.PEBBLE,
				CreatureAlchemyItems.FLASH_CRYSTAL,
				CreatureAlchemyItems.MYSTERIOUS_COTTON,
				CreatureAlchemyItems.CRYSTAL,
//				CreatureAlchemyItems.PEARL,
//				CreatureAlchemyItems.PEARL_FRAGMENT,
//				CreatureAlchemyItems.TIDE_GRANULE,
//				CreatureAlchemyItems.TIDE_SLURRY,
				CreatureAlchemyItems.LAPIS_APPLE
		);
		registerItemsOreDictionary();
	}
	
	public static void registerItemsOreDictionary () {
		OreDictionary.registerOre("pebble", new ItemStack(CreatureAlchemyItems.PEBBLE, 1));
	}
	
}
