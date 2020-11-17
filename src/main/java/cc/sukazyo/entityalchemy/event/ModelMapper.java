package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.item.ItemMaterials;
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
		
		ModelLoader.setCustomModelResourceLocation(EntityAlchemyItems.extractor, 0, new ModelResourceLocation(Objects.requireNonNull(EntityAlchemyItems.extractor.getRegistryName()), "inventory"));
		
		for (int i = 0; i < ItemMaterials.subtypes.length && i < 3; i++) {
			ModelLoader.setCustomModelResourceLocation(
					EntityAlchemyItems.materials,
					i,
					new ModelResourceLocation(
							EntityAlchemy.MODID + ":" + ItemMaterials.subtypes[i],
							"inventory"));
		}
		
	}
	
}
