package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.gameobj.item.ItemMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
		
		ModelLoader.setCustomModelResourceLocation(EntityAlchemyItems.EXTRACTOR, 0, new ModelResourceLocation(Objects.requireNonNull(EntityAlchemyItems.EXTRACTOR.getRegistryName()), "inventory"));
		
		for (int i = 0; i < ItemMaterials.subtypes.length && i < 3; i++) {
			ModelLoader.setCustomModelResourceLocation(
					EntityAlchemyItems.MATERIALS,
					i,
					new ModelResourceLocation(
							EntityAlchemy.MODID + ":" + ItemMaterials.subtypes[i],
							"inventory"));
		}
		
	}
	
}
