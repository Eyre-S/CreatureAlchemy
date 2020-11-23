package cc.sukazyo.creaturealchemy.struct;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemSummonStack {
	
	private final Item item;
	private final int meta;
	
	private final int numMax;
	private final int numMin;
	
	public ItemSummonStack(Item item, int num) { this(item, num, num); }
	public ItemSummonStack(Item item, int numMin, int numMax) { this(item, numMin, numMax, 0); }
	public ItemSummonStack(Item item, int numMin, int numMax, int meta) {
		this.item = item;
		this.meta = meta;
		this.numMin = numMin;
		this.numMax = numMax;
	}
	
	public ItemStack summon () {
		return new ItemStack(item, new Random().nextInt(numMax-numMin+1) + numMin, meta);
	}
	
	public ItemStack summonWithExtraChance (int extra) {
		return new ItemStack(item, new Random().nextInt(numMax - numMin + extra + 1) + numMin, meta);
	}
	
}
