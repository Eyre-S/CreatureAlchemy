package cc.sukazyo.creature_alchemy.item_groups;

import cc.sukazyo.creature_alchemy.items.CreatureAlchemyItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreatureAlchemyItemGroups {
	
	public static final CreatureAlchemyItemGroupBuilder creature_alchemy =
			new CreatureAlchemyItemGroupBuilder(
					"creature_alchemy",
					() -> new ItemStack(CreatureAlchemyItems.EXTRACTOR)
			);
	public static ItemGroup CREATURE_ALCHEMY;
	
	public static void onInitialize () {
		CREATURE_ALCHEMY = creature_alchemy.register();
	}
	
}
