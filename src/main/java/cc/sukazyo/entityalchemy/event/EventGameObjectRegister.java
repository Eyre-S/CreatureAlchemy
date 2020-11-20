package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.gameobj.item.ItemMaterials;
import cc.sukazyo.entityalchemy.gameobj.other.EACreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = EntityAlchemy.MODID)
public class EventGameObjectRegister {
	
	public static final EACreativeTabs itemTab = new EACreativeTabs();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				EntityAlchemyItems.MATERIALS,
				EntityAlchemyItems.MEATBALL,
				EntityAlchemyItems.EXTRACTOR
		);
		registerItemsOreDictionary(event);
	}
	
	public static void registerItemsOreDictionary (RegistryEvent.Register<Item> event) {
		OreDictionary.registerOre("pebble", new ItemStack(EntityAlchemyItems.MATERIALS, 1, ItemMaterials.PEBBLE));
	}
	
}
