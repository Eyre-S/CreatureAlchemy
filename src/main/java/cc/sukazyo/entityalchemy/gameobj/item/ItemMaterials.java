package cc.sukazyo.entityalchemy.gameobj.item;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.event.EventGameObjectRegister;
import cc.sukazyo.entityalchemy.struct.IMetasItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMaterials extends Item implements IMetasItem {
	
	public static final String ID = "materials";
	
	public static final String[] subtypes = new String[] {
			"precision_component",
			"precision_unit",
			"pebble",
			"flash_crystal",
			"mysterious_cotton",
			"crystal"
	};
	public static final int PRECISION_COMPONENT = 0;
	public static final int PRECISION_UNIT = 1;
	public static final int PEBBLE = 2;
	public static final int FLASH_CRYSTAL = 3;
	public static final int MYSTERIOUS_COTTON = 4;
	public static final int CRYSTAL = 5;
	
	public ItemMaterials () {
		
		setHasSubtypes(true);
		setMaxDamage(0);
		setNoRepair();
		
		setRegistryName(EntityAlchemy.MODID, ID);
		setCreativeTab(EventGameObjectRegister.itemTab);
		
	}
	
	@Override
	@SuppressWarnings("all")
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < subtypes.length; i++) {
				list.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	@Override
	public String[] getSubtypeIDs () {
		return subtypes;
	}
	
	@Override
	@SuppressWarnings("all")
	public String getTranslationKey(ItemStack stack) {
		return "item." + EntityAlchemy.MODID + "." + subtypes[stack.getMetadata()];
	}
	
}
