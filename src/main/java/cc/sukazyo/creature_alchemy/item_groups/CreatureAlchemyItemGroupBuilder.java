package cc.sukazyo.creature_alchemy.item_groups;

import cc.sukazyo.creature_alchemy.CreatureAlchemy;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreatureAlchemyItemGroupBuilder {
	
	private final ItemGroup.Builder builder;
	private final Identifier id;
	
	private final List<ItemStack> items = new ArrayList<>();
	
	public CreatureAlchemyItemGroupBuilder (String id, Supplier<ItemStack> icon) {
		this.id = new Identifier(CreatureAlchemy.MOD_ID, id);
		this.builder =
				FabricItemGroup.builder()
						.icon(icon)
						.displayName(Text.translatable("itemGroup.%s.%s".formatted(CreatureAlchemy.MOD_ID, id)));
	}
	
	public void registerItem (Item... item) {
		List<Item> li = List.of(item);
		li.forEach(x -> CreatureAlchemy.logger.debug("new item registered to item group {} : {}", this.id, x));
		items.addAll(
				li.stream().map(ItemStack::new).toList()
		);
	}
	
	public ItemGroup build () {
		return builder
				.entries((displayContext, entries) -> {
					entries.addAll(items);
				})
				.build();
	}
	
	public ItemGroup register () {
		try {
			return Registry.register(Registries.ITEM_GROUP, this.id, this.build());
		} finally {
			CreatureAlchemy.logger.debug("registered item group %s.".formatted(this.id));
		}
		
	}
	
}