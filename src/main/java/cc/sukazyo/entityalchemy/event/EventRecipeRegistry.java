package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.gameobj.item.ItemMaterials;
import cc.sukazyo.entityalchemy.logic.recipe.ExtractorRecipe;
import cc.sukazyo.entityalchemy.struct.ItemSummonTable;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class EventRecipeRegistry {
	
	public static void registerEntityAlchemyExtractorRecipe(FMLInitializationEvent event) {
		ExtractorRecipe.addRecipe(Blocks.STONE, new ItemSummonTable(EntityAlchemyItems.MATERIALS, 12, 15, ItemMaterials.PEBBLE));
		ExtractorRecipe.addRecipe(Blocks.COBBLESTONE, new ItemSummonTable(EntityAlchemyItems.MATERIALS, 12, 15, ItemMaterials.PEBBLE));
	}
	
}
