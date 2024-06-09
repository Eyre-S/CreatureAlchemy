package cc.sukazyo.creature_alchemy.mixins;

import cc.sukazyo.creature_alchemy.events.CreatureAlchemyEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = AbstractBlock.class)
public abstract class MixinAbstractBlock implements ToggleableFeature {
	
	@Inject(at = @At("HEAD"), method = "getDroppedStacks", cancellable = true)
	void getDroppedStacks_inject (
			BlockState state, LootContextParameterSet.Builder builder,
			CallbackInfoReturnable<List<ItemStack>> cir
	) {
		CreatureAlchemyEvents.block_onGetDroppedStacks(state, builder, cir);
	}
	
}
