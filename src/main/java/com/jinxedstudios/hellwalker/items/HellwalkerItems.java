package com.jinxedstudios.hellwalker.items;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.blocks.HellwalkerBlocks;
import com.jinxedstudios.hellwalker.entities.HellwalkerEntities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HellwalkerItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Hellwalker.MODID);

  //  public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
       //     .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static final DeferredItem<Item> BLUE_ACCESS_KEY = ITEMS.registerSimpleItem("blue_access_key", new Item.Properties());
    public static final DeferredItem<Item> YELLOW_ACCESS_KEY = ITEMS.registerSimpleItem("yellow_access_key", new Item.Properties());
    public static final DeferredItem<Item> PRAETOR_TOKEN = ITEMS.registerSimpleItem("praetor_token", new Item.Properties());
    public static final DeferredItem<Item> DATA_LOG = ITEMS.registerSimpleItem("data_log", new Item.Properties());
    public static final DeferredItem<Item> POSSESSED_SCIENTIST_SPAWN_EGG = ITEMS.registerItem("possessed_scientist_spawn_egg",
            (properties) -> new SpawnEggItem(HellwalkerEntities.POSSESSED_SCIENTIST.get(), properties));
    public static final DeferredItem<Item> UNWILLING_SPAWN_EGG = ITEMS.registerItem("unwilling_spawn_egg",
            (properties) -> new SpawnEggItem(HellwalkerEntities.UNWILLING.get(), properties));
    //public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);


    public static final DeferredItem<BlockItem> ANCIENT_STONE_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("ancient_stone_bricks", HellwalkerBlocks.ANCIENT_STONE_BRICKS);

    public static final DeferredItem<BlockItem> MARS_SAND_ITEM = ITEMS.registerSimpleBlockItem("mars_sand", HellwalkerBlocks.MARS_SAND);


    public static void register(IEventBus modEventBus) {
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

    }
}
