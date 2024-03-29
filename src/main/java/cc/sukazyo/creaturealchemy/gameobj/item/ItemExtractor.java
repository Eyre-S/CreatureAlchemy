package cc.sukazyo.creaturealchemy.gameobj.item;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.event.EventGameObjectRegister;
import cc.sukazyo.creaturealchemy.api.recipe.ExtractorRecipe;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nonnull;

public class ItemExtractor extends ItemTool {
	
	public static final String ID = "extractor";
	
	private static final ToolMaterial creature_alchemy_extractor = EnumHelper.addToolMaterial("creature_alchemy_extractor", 2, 80, 5.0f, 1.5f, 1);
	
	public ItemExtractor () {
		super(creature_alchemy_extractor, ExtractorRecipe.extractStack.keySet());
		this.setRegistryName(CreatureAlchemy.MODID, ID);
		this.setCreativeTab(EventGameObjectRegister.itemTab);
		this.setUnlocalizedName(CreatureAlchemy.MODID + '.' + ID);
	}
	
	@Override
	public float getDestroySpeed (@Nonnull ItemStack stack, IBlockState state) {
		return ExtractorRecipe.extractStack.containsKey(state.getBlock()) ? creature_alchemy_extractor.getEfficiency() : super.getDestroySpeed(stack, state);
	}
	
	@Override
	public boolean canHarvestBlock (IBlockState blockIn) {
		return ExtractorRecipe.extractStack.containsKey(blockIn.getBlock());
	}
	
}
