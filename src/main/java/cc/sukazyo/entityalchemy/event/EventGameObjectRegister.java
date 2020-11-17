package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.item.ItemExtractor;
import cc.sukazyo.entityalchemy.item.ItemMaterials;
import cc.sukazyo.entityalchemy.other.EACreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EntityAlchemy.MODID)
public class EventGameObjectRegister {
	
	public static final EACreativeTabs itemTab = new EACreativeTabs();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				EntityAlchemyItems.extractor = new ItemExtractor(),
				EntityAlchemyItems.materials = new ItemMaterials()
		);
	}
	
}
