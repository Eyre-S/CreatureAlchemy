package cc.sukazyo.entityalchemy.item;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.event.EventGameObjectRegister;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashSet;
import java.util.Set;

public class ItemExtractor extends ItemTool {
	
	public static final String ID = "extractor";
	
	@SuppressWarnings("all")
	public ItemExtractor () {
		super(EnumHelper.addToolMaterial("entity_alchemy_extractor", 2, 80, 5.0f, 1.5f, 1), getBreakable());
		this.setRegistryName(EntityAlchemy.MODID, ID);
		this.setCreativeTab(EventGameObjectRegister.itemTab);
		this.setTranslationKey(EntityAlchemy.MODID + '.' + ID);
	}
	
	public static Set<Block> getBreakable () {
		Set<Block> breakable = new HashSet<>();
		breakable.add(Blocks.STONE);
		breakable.add(Blocks.COBBLESTONE);
		return breakable;
	}
	
}
