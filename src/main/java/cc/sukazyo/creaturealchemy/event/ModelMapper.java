package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Objects;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = CreatureAlchemy.MODID)
public final class ModelMapper {
	
	@SubscribeEvent
	public static void onModelReg(ModelRegistryEvent event) {
		
		registerItemModel(
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
		
	}
	
	public static void registerItemModel (Item... list) {
		for (Item item : list) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
		}
		
	}
	
}
