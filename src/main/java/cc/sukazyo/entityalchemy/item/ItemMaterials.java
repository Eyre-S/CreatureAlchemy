package cc.sukazyo.entityalchemy.item;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.event.EventGameObjectRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMaterials extends Item {
	
	public static final String[] subtypes = new String[] {
			"component",
			"unit",
			"pebble",
			"light_crystal",
			"mystery_cotton",
			"meatball",
			"crystal"
	};
	
	public ItemMaterials () {
		
		setHasSubtypes(true);
		setMaxDamage(0);
		setNoRepair();
		
		setRegistryName(EntityAlchemy.MODID, "materials");
		setCreativeTab(EventGameObjectRegister.itemTab);
		
	}
	
	@Override
	@SuppressWarnings("all")
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < subtypes.length; i++) {
				list.add(new ItemStack(EntityAlchemyItems.materials, 1, i));
			}
		}
	}
	
	@Override
	@SuppressWarnings("all")
	public String getTranslationKey(ItemStack stack) {
		return "item." + EntityAlchemy.MODID + "." + subtypes[stack.getMetadata()];
	}
	
}
