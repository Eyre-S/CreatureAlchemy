package cc.sukazyo.creaturealchemy.gameobj.item;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLapisApple extends ItemFood {
	
	public static final String ID = "lapis_apple";
	
	public ItemLapisApple () {
		super(0, 1f, false);
		this.setRegistryName(CreatureAlchemy.MODID, ID);
		this.setUnlocalizedName(CreatureAlchemy.MODID + '.' + ID);
	}
	
	@Override
	@SuppressWarnings("all")
	public void addInformation (ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("item." + CreatureAlchemy.MODID + "." + ID + ".description_1"));
	}
	
}
