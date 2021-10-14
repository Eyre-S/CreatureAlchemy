package cc.sukazyo.creaturealchemy.gameobj.item;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

/**
 * 注册物品的集合类
 *
 * 在注册每一个物品的时候，在这边声明后，在以下位置注册物品
 * {@link cc.sukazyo.creaturealchemy.event.EventGameObjectRegister#registerItems(RegistryEvent.Register)}
 * 在以下位置注册物品的材质模型
 * {@link cc.sukazyo.creaturealchemy.event.ModelMapper#onModelReg(ModelRegistryEvent)}
 */
public class CreatureAlchemyItems {
	
	public static final ItemMeatball MEATBALL = new ItemMeatball();
	public static final ItemExtractor EXTRACTOR = new ItemExtractor();
	
	public static final Item WOODEN_CHIP = new SimpleItem("wooden_chip");
	public static final Item EXTRACTOR_HEAD = new SimpleItem("extractor_head");
	public static final Item PEBBLE = new SimpleItem("pebble");
	public static final Item FLASH_CRYSTAL = new SimpleItem("flash_crystal");
	public static final Item MYSTERIOUS_COTTON = new SimpleItem("mysterious_cotton");
	public static final Item CRYSTAL = new SimpleItem("crystal");
//	public static final Item PEARL = new SimpleItem("pearl");
//	public static final Item PEARL_FRAGMENT = new SimpleItem("pearl_fragment");
//	public static final Item TIDE_GRANULE = new SimpleItem("tide_granule");
//	public static final Item TIDE_SLURRY = new SimpleItem("tide_slurry");
	
	public static final Item LAPIS_APPLE = new ItemLapisApple();
	public static final Item WOODEN_BARREL_RICE = null;
	
}
