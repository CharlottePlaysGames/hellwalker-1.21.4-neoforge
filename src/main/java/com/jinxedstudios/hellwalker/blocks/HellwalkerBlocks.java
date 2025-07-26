package com.jinxedstudios.hellwalker.blocks;

import com.jinxedstudios.hellwalker.Hellwalker;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

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
