package cc.sukazyo.creaturealchemy.gameobj.other;

import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CACreativeTabs extends CreativeTabs {
	
	public CACreativeTabs() {
		super("creature_alchemy");
	}
	
	@Override
	@SuppressWarnings("all")
	public ItemStack createIcon() {
		return new ItemStack(CreatureAlchemyItems.MEATBALL);
	}
	
}
