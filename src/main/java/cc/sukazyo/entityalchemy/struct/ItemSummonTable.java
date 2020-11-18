package cc.sukazyo.entityalchemy.struct;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemSummonTable {
	
	private final List<Stack> table;
	
	public static class Stack {
		
		private final Item item;
		private final int meta;
		
		private final int numMax;
		private final int numMin;
		
		Stack (Item item, int numMin, int numMax, int meta) {
			this.item = item;
			this.meta = meta;
			this.numMin = numMin;
			this.numMax = numMax;
		}
		
		private ItemStack summon () {
			return new ItemStack(item, new Random().nextInt(numMax-numMin+1) + numMin, meta);
		}
		
	}
	
	public ItemSummonTable () { table = new ArrayList<>(); }
	
	public ItemSummonTable (Item item, int num) { this(item, num, 0); }
	public ItemSummonTable (Item item, int num, int meta) { this(item, num, num, meta); }
	public ItemSummonTable (Item item, int numMin, int numMax, int meta) {
		table = new ArrayList<>();
		table.add(new Stack(item, numMin, numMax, meta));
	}
	
	public ItemSummonTable add (Item item, int num) { return add(item, num, 0); }
	public ItemSummonTable add (Item item, int num, int meta) { return add(item, num, num, meta); }
	public ItemSummonTable add (Item item, int numMin, int numMax, int meta) {
		table.add(new Stack(item, numMin, numMax, meta));
		return this;
	}
	
	public List<ItemStack> summon () {
		List<ItemStack> results = new ArrayList<>();
		table.forEach((i) -> results.add(i.summon()));
		return results;
	}
	
}
