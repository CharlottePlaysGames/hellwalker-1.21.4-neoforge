package com.jinxedstudios.hellwalker.creativeTabs;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.blocks.HellwalkerBlocks;
import com.jinxedstudios.hellwalker.items.HellwalkerItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HellwalkerCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hellwalker.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_ITEMS = CREATIVE_MODE_TABS.register("hellwalker_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_items")) //The language key for the title of your CreativeModeTab
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(HellwalkerItems.BLUE_ACCESS_KEY.get());
                output.accept(HellwalkerItems.YELLOW_ACCESS_KEY.get());
                output.accept(HellwalkerItems.PRAETOR_TOKEN.get());
                output.accept(HellwalkerItems.DATA_LOG.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_BLOCKS = CREATIVE_MODE_TABS.register("hellwalker_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_blocks")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "hellwalker_items"))
            .icon(() -> new ItemStack(HellwalkerBlocks.ANCIENT_STONE_BRICKS))
            .displayItems((parameters, output) -> {
                output.accept(HellwalkerItems.ANCIENT_STONE_BRICKS_ITEM.get());
                output.accept(HellwalkerItems.MARS_SAND_ITEM.get());
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_ENEMIES = CREATIVE_MODE_TABS.register("hellwalker_enemies", () -> CreativeModeTab.builder()
           .title(Component.translatable("itemGroup.hellwalker_enemies")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "hellwalker_blocks"))
            .icon(() -> HellwalkerItems.POSSESSED_SCIENTIST_SPAWN_EGG.get().getDefaultInstance())
           .displayItems((parameters, output) -> {
               output.accept(HellwalkerItems.POSSESSED_SCIENTIST_SPAWN_EGG.get());
    //            output.accept(HellwalkerItems.UNWILLING_SPAWN_EGG.get());
           }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_WEAPONS = CREATIVE_MODE_TABS.register("hellwalker_weapons", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_weapons")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HELLWALKER_ARMOR = CREATIVE_MODE_TABS.register("hellwalker_armor", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.hellwalker_armor")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
            .icon(() -> HellwalkerItems.BLUE_ACCESS_KEY.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());



    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);


    }
}
