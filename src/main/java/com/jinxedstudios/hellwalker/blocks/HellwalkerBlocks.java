package com.jinxedstudios.hellwalker.blocks;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.items.HellwalkerItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class HellwalkerBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Hellwalker.MODID);


    public static final DeferredBlock<Block> ANCIENT_STONE_BRICKS =
            BLOCKS.registerSimpleBlock("ancient_stone_bricks",
                    BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE));

    public static final DeferredBlock<Block> MARS_SAND =
            BLOCKS.registerSimpleBlock("mars_sand",
                    BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.SAND));


    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);

    }

}
