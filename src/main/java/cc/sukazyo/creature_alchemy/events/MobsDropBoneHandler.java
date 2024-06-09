package cc.sukazyo.creature_alchemy.events;

import cc.sukazyo.creature_alchemy.CreatureAlchemy;
import com.google.gson.Gson;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootGsons;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class MobsDropBoneHandler implements LootTableEvents.Modify {
	
	private record MobDropBoneProvider(
			LootNumberProvider rolls
	) {}
	private static final MobDropBoneProvider SMALL_ANIMAL = new MobDropBoneProvider(ConstantLootNumberProvider.create(1));
	private static final MobDropBoneProvider MEDIUM_ANIMAL = new MobDropBoneProvider(UniformLootNumberProvider.create(1, 3));
	private static final MobDropBoneProvider LARGE_ANIMAL = new MobDropBoneProvider(UniformLootNumberProvider.create(2, 3));
	private static final MobDropBoneProvider VERY_LARGE_ANIMAL = new MobDropBoneProvider(UniformLootNumberProvider.create(2, 5));
	private static final Map<Identifier, MobDropBoneProvider> MOBS_DROP_BONES = new HashMap<>();
	private static void registerMobDropBones (EntityType<?> entityType, MobDropBoneProvider provider) {
		MOBS_DROP_BONES.put(entityType.getLootTableId(), provider);
	}
	static {
		registerMobDropBones(EntityType.HOGLIN, VERY_LARGE_ANIMAL);
		registerMobDropBones(EntityType.ZOGLIN, VERY_LARGE_ANIMAL);
		registerMobDropBones(EntityType.SKELETON_HORSE, VERY_LARGE_ANIMAL);
		registerMobDropBones(EntityType.POLAR_BEAR, LARGE_ANIMAL);
		registerMobDropBones(EntityType.LLAMA, LARGE_ANIMAL);
		registerMobDropBones(EntityType.TRADER_LLAMA, LARGE_ANIMAL);
		registerMobDropBones(EntityType.PANDA, LARGE_ANIMAL);
		registerMobDropBones(EntityType.HORSE, LARGE_ANIMAL);
		registerMobDropBones(EntityType.DONKEY, LARGE_ANIMAL);
		registerMobDropBones(EntityType.MULE, LARGE_ANIMAL);
		registerMobDropBones(EntityType.COW, MEDIUM_ANIMAL);
		registerMobDropBones(EntityType.MOOSHROOM, MEDIUM_ANIMAL);
		registerMobDropBones(EntityType.SHEEP, MEDIUM_ANIMAL);
		registerMobDropBones(EntityType.PIG, MEDIUM_ANIMAL);
		registerMobDropBones(EntityType.CHICKEN, SMALL_ANIMAL);
		registerMobDropBones(EntityType.RABBIT, SMALL_ANIMAL);
		registerMobDropBones(EntityType.WOLF, SMALL_ANIMAL);
		registerMobDropBones(EntityType.OCELOT, SMALL_ANIMAL);
		registerMobDropBones(EntityType.PARROT, SMALL_ANIMAL);
	}
	
	@Override
	public void modifyLootTable (
			ResourceManager resourceManager, LootManager lootManager,
			Identifier id, LootTable.Builder tableBuilder, LootTableSource source
	) {
		MobDropBoneProvider dropBoneProvider = MOBS_DROP_BONES.get(id);
		if (dropBoneProvider != null) {
			LootPool.Builder dropBones = new LootPool.Builder()
					.rolls(dropBoneProvider.rolls)
					.with(ItemEntry.builder(Items.BONE));
			tableBuilder.pool(dropBones);
			CreatureAlchemy.logger.debug("modified loot table \"{}\" for mobs drop bones.", id);
			CreatureAlchemy.logger.trace("added loot pool:\n{}", LootGsons.getTableGsonBuilder().create().toJson(dropBones));
		}
	}
	
}
