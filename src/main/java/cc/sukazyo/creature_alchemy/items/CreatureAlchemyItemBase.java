package cc.sukazyo.creature_alchemy.items;

import cc.sukazyo.creature_alchemy.CreatureAlchemy;
import cc.sukazyo.creature_alchemy.item_groups.CreatureAlchemyItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CreatureAlchemyItemBase extends Item {
	
	public final Identifier identifier;
	
	public CreatureAlchemyItemBase (String id, FabricItemSettings settings) {
		super(settings);
		this.identifier = new Identifier(CreatureAlchemy.MOD_ID, id);
	}
	
	public CreatureAlchemyItemBase (String id) {
		this(id, new FabricItemSettings());
	}
	
	CreatureAlchemyItemBase registerThis () {
		CreatureAlchemyItemBase _this = Registry.register(Registries.ITEM, identifier, this);
		CreatureAlchemyItemGroups.creature_alchemy.registerItem(_this);
		CreatureAlchemy.logger.debug("registered Creature Alchemy item {}", _this);
		return _this;
	}
	
}
