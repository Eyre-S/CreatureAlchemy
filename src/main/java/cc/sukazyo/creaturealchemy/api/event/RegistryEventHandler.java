package cc.sukazyo.creaturealchemy.api.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class RegistryEventHandler {
	
	public static void pushFMLInitEvents (FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.post(new EventExtractorRecipeRegister());
	}
	
}
