package cc.sukazyo.creature_alchemy.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;

public class CreatureAlchemyItems {
	
	public static final CreatureAlchemyItemBase MEATBALL =
			new CreatureAlchemyItemBase(
					"meatball",
					new FabricItemSettings()
							.food(new FoodComponent.Builder()
									.meat()
									.snack()
									.hunger(1)
									.saturationModifier(0.4f)
									.build()
							)
			).registerThis();
	public static final CreatureAlchemyItemBase PEBBLE =
			new CreatureAlchemyItemBase("pebble").registerThis();
	public static final CreatureAlchemyItemBase CRYSTAL =
			new CreatureAlchemyItemBase("crystal").registerThis();
	public static final CreatureAlchemyItemBase FLASH_CRYSTAL =
			new CreatureAlchemyItemBase("flash_crystal").registerThis();
	public static final CreatureAlchemyItemBase MYSTERIOUS_COTTON =
			new CreatureAlchemyItemBase("mysterious_cotton").registerThis();
	public static final CreatureAlchemyItemBase WOODEN_CHIP =
			new CreatureAlchemyItemBase("wooden_chip").registerThis();
	public static final CreatureAlchemyItemBase EXTRACTOR_HEAD =
			new CreatureAlchemyItemBase("extractor_head").registerThis();
	public static final CreatureAlchemyItemBase EXTRACTOR =
			new ItemExtractor("extractor").registerThis();
	public static final CreatureAlchemyItemBase LAPIS_APPLE =
			new ItemLapisApple("lapis_apple").registerThis();
	
	public static void onInitialize () {
	}
	
}
