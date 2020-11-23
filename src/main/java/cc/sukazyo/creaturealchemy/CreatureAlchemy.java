package cc.sukazyo.creaturealchemy;

import cc.sukazyo.creaturealchemy.event.EventRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
		modid = CreatureAlchemy.MODID,
		name = CreatureAlchemy.NAME,
		version = CreatureAlchemy.VERSION
) public class CreatureAlchemy {
	
	public static final String MODID = "creature_alchemy";
	public static final String NAME = "Creature Alchemy";
	public static final String VERSION = "0.1";
	
	public static Logger logger;
	
	@Mod.EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}
	
	@Mod.EventHandler
	public void init (FMLInitializationEvent event) {
		EventRecipeRegistry.registerCreatureAlchemyExtractorRecipe(event);
	}
	
}
