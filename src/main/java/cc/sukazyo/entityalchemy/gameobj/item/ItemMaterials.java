package cc.sukazyo.entityalchemy.gameobj.item;

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
	public static final int COMPONENT = 0;
	public static final int UNIT = 1;
	public static final int PEBBLE = 2;
	public static final int LIGHT_CRYSTAL = 3;
	public static final int MYSTERY_COTTON = 4;
	public static final int MEATBALL = 5;
	public static final int CRYSTAL = 6;
	
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
				list.add(new ItemStack(EntityAlchemyItems.MATERIALS, 1, i));
			}
		}
	}
	
	@Override
	@SuppressWarnings("all")
	public String getTranslationKey(ItemStack stack) {
		return "item." + EntityAlchemy.MODID + "." + subtypes[stack.getMetadata()];
	}
	
}
