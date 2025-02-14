package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

public class GingerCropBlock extends CropBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 2.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 3.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 4.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 5.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 6.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 7.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 8.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 9.d, 16.d)
    };
    public GingerCropBlock() {
        super(FabricBlockSettings.copyOf(Blocks.WHEAT));
    }
    protected ItemConvertible getSeedsItem() {
        return ItemsRegistry.GINGER.get();
    }
    public VoxelShape getOutlineShape(BlockState state, net.minecraft.world.BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(getAgeProperty())];
    }
}
