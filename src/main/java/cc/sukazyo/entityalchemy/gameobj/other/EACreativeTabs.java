package cc.sukazyo.entityalchemy.gameobj.other;

import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.gameobj.item.ItemMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EACreativeTabs extends CreativeTabs {
	
	public EACreativeTabs() {
		super("entity_alchemy");
	}
	
	@Override
	@SuppressWarnings("all")
	public ItemStack createIcon() {
		return new ItemStack(EntityAlchemyItems.MEATBALL);
	}
	
}
