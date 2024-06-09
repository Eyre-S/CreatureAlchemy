package cc.sukazyo.creature_alchemy.events.api.block;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@FunctionalInterface
public interface BlockGetDroppedStacksCallback {
	
	void onBlockGetDroppedStacks (
			BlockState state, LootContextParameterSet.Builder builder,
			CallbackInfoReturnable<List<ItemStack>> cir
	);
	
}
