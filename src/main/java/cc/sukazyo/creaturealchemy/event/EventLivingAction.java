package cc.sukazyo.creaturealchemy.event;

import cc.sukazyo.creaturealchemy.CreatureAlchemy;
import cc.sukazyo.creaturealchemy.struct.ItemSummonStack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CreatureAlchemy.MODID)
public class EventLivingAction {
	
	private static final ItemSummonStack largeAnimalBones = new ItemSummonStack(Items.BONE, 1, 3);
	private static final ItemSummonStack mediumAnimalBones = new ItemSummonStack(Items.BONE, 0, 2);
	private static final ItemSummonStack smallAnimalBones = new ItemSummonStack(Items.BONE, 0, 1);
	
	@SubscribeEvent
	public static void onPlayerKilledEntity (LivingDropsEvent event) {
		{
			if (
					event.getEntityLiving() instanceof EntityPolarBear ||
					event.getEntityLiving() instanceof EntityLlama
			) event.getDrops().add(new EntityItem(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, largeAnimalBones.summonWithExtraChance(event.getLootingLevel())));
			if (
					event.getEntityLiving() instanceof EntityCow ||
					event.getEntityLiving() instanceof EntitySheep ||
					event.getEntityLiving() instanceof EntityPig ||
					event.getEntityLiving() instanceof EntityHorse ||
					event.getEntityLiving() instanceof EntityDonkey ||
					event.getEntityLiving() instanceof EntityMule
			) event.getDrops().add(new EntityItem(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, mediumAnimalBones.summonWithExtraChance(event.getLootingLevel())));
			if (
					event.getEntityLiving() instanceof EntityChicken ||
					event.getEntityLiving() instanceof EntityRabbit ||
					event.getEntityLiving() instanceof EntityWolf ||
					event.getEntityLiving() instanceof EntityOcelot ||
					event.getEntityLiving() instanceof EntityParrot
			) event.getDrops().add(new EntityItem(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, smallAnimalBones.summonWithExtraChance(event.getLootingLevel())));
		}
	}
	
}
