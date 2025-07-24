package com.jinxedstudios.hellwalker.datagen;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.blocks.HellwalkerBlocks;
import com.jinxedstudios.hellwalker.items.HellwalkerItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class HellwalkerModelProvider {
    public HellwalkerModelProvider(PackOutput output) {
        super();
    }

    public void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(HellwalkerItems.BLUE_ACCESS_KEY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HellwalkerItems.YELLOW_ACCESS_KEY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HellwalkerItems.DATA_LOG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HellwalkerItems.PRAETOR_TOKEN.get(), ModelTemplates.FLAT_ITEM);


        itemModels.generateFlatItem(HellwalkerItems.POSSESSED_SCIENTIST_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);

        /* BLOCKS */
        blockModels.createTrivialCube(HellwalkerBlocks.ANCIENT_STONE_BRICKS.get());
        blockModels.createTrivialCube(HellwalkerBlocks.MARS_SAND.get());
    }

}
