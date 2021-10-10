package cc.sukazyo.creaturealchemy.gameobj.item;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.event.EventGameObjectRegister;
import net.minecraft.item.Item;

public class SimpleItem extends Item {
	
	public SimpleItem (String registryName) {
		
		setRegistryName(registryName);
		setUnlocalizedName(CreatureAlchemy.MODID + '.' + registryName);
		setCreativeTab(EventGameObjectRegister.itemTab);
		
	}
	
}
