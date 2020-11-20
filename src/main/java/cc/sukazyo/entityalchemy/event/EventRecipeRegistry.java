package cc.sukazyo.entityalchemy.event;

import cc.sukazyo.entityalchemy.gameobj.item.EntityAlchemyItems;
import cc.sukazyo.entityalchemy.gameobj.item.ItemMaterials;
import cc.sukazyo.entityalchemy.logic.recipe.ExtractorRecipe;
import cc.sukazyo.entityalchemy.struct.ItemSummonTable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class EventRecipeRegistry {
	
	public static void registerEntityAlchemyExtractorRecipe(FMLInitializationEvent event) {
		ExtractorRecipe.addRecipe(Blocks.STONE, new ItemSummonTable(EntityAlchemyItems.MATERIALS, 12, 15, ItemMaterials.PEBBLE));
		ExtractorRecipe.addRecipe(Blocks.COBBLESTONE, new ItemSummonTable(EntityAlchemyItems.MATERIALS, 12, 15, ItemMaterials.PEBBLE));
		ExtractorRecipe.addRecipe(Blocks.WOOL, new ItemSummonTable(Items.STRING, 4));
		ExtractorRecipe.addRecipe(Blocks.TNT, new ItemSummonTable(Items.GUNPOWDER, 4).add(EntityAlchemyItems.MATERIALS, -1, 1, ItemMaterials.MYSTERIOUS_COTTON));
	}
	
}
