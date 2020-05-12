package io.github.elementera.fluids;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class FreshWaterFluid extends FlowableFluid {
    public FreshWaterFluid() {
    }

    public Fluid getFlowing() {
        return Fluids.FLOWING_WATER;
    }

    public Fluid getStill() {
        return Fluids.WATER;
    }

    public Item getBucketItem() {
        return Items.WATER_BUCKET;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!state.isStill() && !state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + (double)random.nextFloat(), (double)pos.getY() + (double)random.nextFloat(), (double)pos.getZ() + (double)random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }

    }

    @Nullable
    @Environment(EnvType.CLIENT)
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected boolean isInfinite() {
        return true;
    }

    protected void beforeBreakingBlock(IWorld world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.getBlock().hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world.getWorld(), pos, blockEntity);
    }

    public int getFlowSpeed(WorldView world) {
        return 4;
    }

    public BlockState toBlockState(FluidState state) {
        return Blocks.WATER.getDefaultState().with(FluidBlock.LEVEL, method_15741(state));
    }

    public boolean matchesType(Fluid fluid) {
        return fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER;
    }

    public int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    public int getTickRate(WorldView world) {
        return 5;
    }

    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
    }

    protected float getBlastResistance() {
        return 100.0F;
    }

    public static class Flowing extends net.minecraft.fluid.WaterFluid {
        public Flowing() {
        }

        protected void appendProperties(Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends net.minecraft.fluid.WaterFluid {
        public Still() {
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isStill(FluidState state) {
            return true;
        }
    }
}

