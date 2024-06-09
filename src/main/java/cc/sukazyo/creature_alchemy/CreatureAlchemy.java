package cc.sukazyo.creature_alchemy;

import cc.sukazyo.creature_alchemy.events.CreatureAlchemyEvents;
import cc.sukazyo.creature_alchemy.item_groups.CreatureAlchemyItemGroups;
import cc.sukazyo.creature_alchemy.items.CreatureAlchemyItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatureAlchemy implements ModInitializer {
	
	public static final String MOD_ID = "creature_alchemy";
	public static final String NAME = "Creature Alchemy";
	private static String _version;
	public static String version () { return _version; }
	
	public static final Logger logger = LogManager.getLogger(NAME);
	
	public CreatureAlchemy () {}
	
	@Override
	public void onInitialize () {
		
		// Get version info of this mod
		_version =
				FabricLoader.getInstance()
						.getModContainer(MOD_ID).get()
						.getMetadata()
						.getVersion()
						.toString();
		
		logger.info("Hello, Creature Alchemy!");
		logger.debug("""
				You are seeing the debug message from mod Creature Alchemy!
				  Indicates that you enabled debugging log output from the mod.
				  Have fun with modding Creature Alchemy ~""");
		
		CreatureAlchemyItems.onInitialize();
		CreatureAlchemyItemGroups.onInitialize();
		
		logger.debug("Running all Creature Alchemy events listener initialization.");
		CreatureAlchemyEvents.onInitialize();
		logger.debug("Done all Creature Alchemy events listener initialization.");
		
	}
	
}
