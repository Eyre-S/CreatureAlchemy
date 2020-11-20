package cc.sukazyo.entityalchemy.struct;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemSummonTable {
	
	private final List<ItemSummonStack> table;
	
	public ItemSummonTable () { table = new ArrayList<>(); }
	
	public ItemSummonTable (Item item, int num) { this(item, num, num); }
	public ItemSummonTable (Item item, int numMin, int numMax) { this(item, numMin, numMax, 0); }
	public ItemSummonTable (Item item, int numMin, int numMax, int meta) {
		table = new ArrayList<>();
		table.add(new ItemSummonStack(item, numMin, numMax, meta));
	}
	
	public ItemSummonTable add (Item item, int num) { return add(item, num, num); }
	public ItemSummonTable add (Item item, int numMin, int numMax) { return add(item, numMin, numMax, 0); }
	public ItemSummonTable add (Item item, int numMin, int numMax, int meta) {
		table.add(new ItemSummonStack(item, numMin, numMax, meta));
		return this;
	}
	
	public List<ItemStack> summon () {
		List<ItemStack> results = new ArrayList<>();
		table.forEach((i) -> results.add(i.summon()));
		return results;
	}
	
}
