package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.gameobj.item.CreatureAlchemyItems;
import cc.sukazyo.creaturealchemy.gameobj.item.ItemMaterials;
import cc.sukazyo.creaturealchemy.logic.recipe.ExtractorRecipe;
import cc.sukazyo.creaturealchemy.struct.ItemSummonTable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class EventRecipeRegistry {
	
	public static void registerCreatureAlchemyExtractorRecipe(FMLInitializationEvent event) {
		ExtractorRecipe.addRecipe(Blocks.STONE, new ItemSummonTable(CreatureAlchemyItems.MATERIALS, 12, 15, ItemMaterials.PEBBLE));
		ExtractorRecipe.addRecipe(Blocks.COBBLESTONE, new ItemSummonTable(CreatureAlchemyItems.MATERIALS, 12, 15, ItemMaterials.PEBBLE));
		ExtractorRecipe.addRecipe(Blocks.WOOL, new ItemSummonTable(Items.STRING, 4));
		ExtractorRecipe.addRecipe(Blocks.TNT, new ItemSummonTable(Items.GUNPOWDER, 4).add(CreatureAlchemyItems.MATERIALS, -1, 1, ItemMaterials.MYSTERIOUS_COTTON));
	}
	
}
