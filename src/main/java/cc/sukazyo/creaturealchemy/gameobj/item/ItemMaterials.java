package cc.sukazyo.creaturealchemy.gameobj.item;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.event.EventGameObjectRegister;
import cc.sukazyo.creaturealchemy.struct.IMetasItem;
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
		
		setRegistryName(CreatureAlchemy.MODID, ID);
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
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + CreatureAlchemy.MODID + "." + subtypes[stack.getMetadata()];
	}
	
}
