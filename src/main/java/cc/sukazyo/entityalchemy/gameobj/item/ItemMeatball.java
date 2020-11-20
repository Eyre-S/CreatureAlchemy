package cc.sukazyo.entityalchemy.gameobj.item;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.event.EventGameObjectRegister;
import net.minecraft.item.ItemFood;

public class ItemMeatball extends ItemFood {
	
	public static final String ID = "meatball";
	
	public ItemMeatball () {
		super(1, 0.4f, true);
		this.setRegistryName(EntityAlchemy.MODID, ID);
		this.setTranslationKey(EntityAlchemy.MODID + '.' + ID);
		this.setCreativeTab(EventGameObjectRegister.itemTab);
	}
	
}
