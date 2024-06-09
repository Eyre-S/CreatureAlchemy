package cc.sukazyo.creature_alchemy.tools.extractor;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.function.Supplier;

public class ExtractorRecipe {
	
	private final Collection<Block> blocks;
	private final Supplier<Collection<ItemStack>> dropsSupplier;
	public final float miningSpeed;
	
	public ExtractorRecipe(Collection<Block> blocks, Supplier<Collection<ItemStack>> droppedSupplier, float miningSpeed) {
		this.blocks = blocks;
		this.dropsSupplier = droppedSupplier;
		this.miningSpeed = miningSpeed;
	}
	
	public ExtractorRecipe(Collection<Block> blocks, Supplier<Collection<ItemStack>> droppedSupplier) {
		this(blocks, droppedSupplier, 1.0f);
	}
	
	public boolean isTargetBlock (Block block) {
		return blocks.contains(block);
	}
	
	public Collection<ItemStack> getDrops() {
		return dropsSupplier.get();
	}
	
	@Override
	public String toString () {
		return String.format(
				"{blocks: [%s]}",
				blocks
		);
	}
	
}
