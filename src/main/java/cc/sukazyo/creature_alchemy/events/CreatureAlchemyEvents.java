package cc.sukazyo.creature_alchemy.events;

import cc.sukazyo.creature_alchemy.events.api.block.BlockGetDroppedStacksCallback;
import cc.sukazyo.creature_alchemy.events.api.init.ModInitializeCallback;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

public class CreatureAlchemyEvents {
	
	public static final List<Object> listeners = new ArrayList<>();
	static {
		listeners.add(
				new ExtractorsHandler()
		);
	}
	
	public static void onInitialize () {
		for (Object listener : listeners) {
			if (listener instanceof ModInitializeCallback modInitializeListener) {
				modInitializeListener.onInitialize();
			}
		}
	}
	
	public static void block_onGetDroppedStacks (
			BlockState state, LootContextParameterSet.Builder builder,
			CallbackInfoReturnable<List<ItemStack>> cir
	) {
		for (Object listener : listeners) {
			if (listener instanceof BlockGetDroppedStacksCallback blockGetDroppedStacksListener) {
				blockGetDroppedStacksListener.onBlockGetDroppedStacks(state, builder, cir);
			}
		}
	}
	
}
