package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.struct.IMetasItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Objects;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = EntityAlchemy.MODID)
public final class ModelMapper {
	
	@SubscribeEvent
	public static void onModelReg(ModelRegistryEvent event) {
		
		registerItemWithMetaModel(event, EntityAlchemyItems.MATERIALS);
		registerItemModel(event, EntityAlchemyItems.MEATBALL);
		registerItemModel(event, EntityAlchemyItems.EXTRACTOR);
		
	}
	
	public static void registerItemModel (ModelRegistryEvent event, Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
	}
	
	public static <T extends Item & IMetasItem> void registerItemWithMetaModel (ModelRegistryEvent event, T item) {
		for (int i = 0; i < item.getSubtypeIDs().length; i++) {
			ModelLoader.setCustomModelResourceLocation(
					item,
					i,
					new ModelResourceLocation(
							EntityAlchemy.MODID + ":" + item.getSubtypeIDs()[i],
							"inventory"));
		}
	}
	
}
