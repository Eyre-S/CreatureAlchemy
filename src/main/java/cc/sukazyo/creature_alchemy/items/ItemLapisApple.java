package cc.sukazyo.creature_alchemy.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemLapisApple extends CreatureAlchemyItemBase {

	public ItemLapisApple (String name) {
		super(
				name,
				new FabricItemSettings()
						.food(new FoodComponent.Builder()
								.hunger(0)
								.saturationModifier(1f)
								.alwaysEdible()
								.build()
						)
		);
	}

	@Override
	public void appendTooltip (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable(this.getTranslationKey() + ".description_1"));
	}

}
