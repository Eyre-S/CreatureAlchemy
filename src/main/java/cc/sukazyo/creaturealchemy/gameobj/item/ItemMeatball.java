package cc.sukazyo.creaturealchemy.gameobj.item;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.event.EventGameObjectRegister;
import net.minecraft.item.ItemFood;

public class ItemMeatball extends ItemFood {
	
	public static final String ID = "meatball";
	
	public ItemMeatball () {
		super(1, 0.4f, true);
		this.setRegistryName(CreatureAlchemy.MODID, ID);
		this.setUnlocalizedName(CreatureAlchemy.MODID + '.' + ID);
		this.setCreativeTab(EventGameObjectRegister.itemTab);
	}
	
}
