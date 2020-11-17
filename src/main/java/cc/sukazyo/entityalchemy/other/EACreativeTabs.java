package cc.sukazyo.entityalchemy.other;

import cc.sukazyo.entityalchemy.item.EntityAlchemyItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EACreativeTabs extends CreativeTabs {
	
	public EACreativeTabs() {
		super("entity_alchemy");
	}
	
	@Override
	@SuppressWarnings("all")
	public ItemStack createIcon() {
		return new ItemStack(EntityAlchemyItems.materials, 1, 5);
	}
	
}
