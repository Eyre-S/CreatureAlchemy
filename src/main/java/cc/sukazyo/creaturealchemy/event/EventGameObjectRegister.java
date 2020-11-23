package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import cc.sukazyo.creaturealchemy.gameobj.item.ItemMaterials;
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
				CreatureAlchemyItems.MATERIALS,
				CreatureAlchemyItems.MEATBALL,
				CreatureAlchemyItems.EXTRACTOR
		);
		registerItemsOreDictionary(event);
	}
	
	public static void registerItemsOreDictionary (RegistryEvent.Register<Item> event) {
		OreDictionary.registerOre("pebble", new ItemStack(CreatureAlchemyItems.MATERIALS, 1, ItemMaterials.PEBBLE));
	}
	
}
