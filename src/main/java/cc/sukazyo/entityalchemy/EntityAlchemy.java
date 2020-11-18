package cc.sukazyo.entityalchemy;

import cc.sukazyo.entityalchemy.event.EventRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
		modid = EntityAlchemy.MODID,
		name = EntityAlchemy.NAME,
		version = EntityAlchemy.VERSION + "-build" + EntityAlchemy.BUILD
) public class EntityAlchemy {
	
	public static final String MODID = "entity_alchemy";
	public static final String NAME = "Entity Alchemy";
	public static final String VERSION = "0.1";
	public static final int BUILD = 2;
	
	public static Logger logger;
	
	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}
	
	@Mod.EventHandler
	public void init (FMLInitializationEvent event) {
		EventRecipeRegistry.registerEntityAlchemyExtractorRecipe(event);
	}
	
}
