package cc.sukazyo.creature_alchemy.events;

import cc.sukazyo.creature_alchemy.CreatureAlchemy;
import cc.sukazyo.creature_alchemy.events.api.block.BlockGetDroppedStacksCallback;
import cc.sukazyo.creature_alchemy.events.api.init.ModInitializeCallback;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

public class CreatureAlchemyEvents {
	
	public static final List<Object> listeners = new ArrayList<>();
	static {
		listeners.addAll(List.of(
				new ExtractorsHandler(),
				new MobsDropBoneHandler()
		));
	}
	
	private static void logListenerRegistry (Class<?> type, Object instance) {
		CreatureAlchemy.logger.debug(
				"Event {} have found a new listener {}, registered.",
				type.getName(),
				instance.getClass().getName()
		);
	}
	public static void onInitialize () {
		
		for (Object listener : listeners) {
			if (listener instanceof ModInitializeCallback modInitializeListener) {
				logListenerRegistry(ModInitializeCallback.class, modInitializeListener);
				modInitializeListener.onInitialize();
			}
		}
		for (Object listener : listeners) {
			if (listener instanceof LootTableEvents.Modify lootTableModifyListener) {
				logListenerRegistry(LootTableEvents.Modify.class, lootTableModifyListener);
				LootTableEvents.MODIFY.register(lootTableModifyListener);
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
