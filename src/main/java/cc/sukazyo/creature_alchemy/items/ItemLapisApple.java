package cc.sukazyo.creature_alchemy.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemLapisApple extends CreatureAlchemyItemBase {
	
	public ItemLapisApple (String name) {
		super(name);
	}
	
	@Override
	public void appendTooltip (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable(this.getTranslationKey() + ".description_1"));
	}
	
}
