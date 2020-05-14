/*
package io.github.elementera.fluids;

import io.github.elementera.ModFluids;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

import static io.github.elementera.ModFluids.*;
import static net.minecraft.block.Blocks.WATER;
import static net.minecraft.particle.ParticleTypes.*;
import static net.minecraft.sound.SoundCategory.BLOCKS;
import static net.minecraft.sound.SoundEvents.BLOCK_WATER_AMBIENT;
import static net.minecraft.util.math.Direction.DOWN;

public abstract class MyFluids extends WaterFluid {
    public MyFluids() {
    }

    public Fluid getFlowing() {
        return FLOWING_FRESH_WATER;
    }

    public Fluid getStill() {
        return FRESH_WATER;
    }

    public Item getBucketItem() {
        return ModFluids.BUCKET_FRESHWATER;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!state.isStill() && !state.get(FALLING)) {
            if (random.nextInt(64) == 0)
                world.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, BLOCK_WATER_AMBIENT, BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
        } else if (random.nextInt(10) == 0)
            world.addParticle(UNDERWATER, (double) pos.getX() + (double) random.nextFloat(), (double) pos.getY() + (double) random.nextFloat(), (double) pos.getZ() + (double) random.nextFloat(), 0.0D, 0.0D, 0.0D);
    }

    @Nullable
    @Environment(EnvType.CLIENT)
    public ParticleEffect getParticle() {
        return DRIPPING_WATER;
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
        return WATER.getDefaultState().with(FluidBlock.LEVEL, method_15741(state));
    }

    public boolean matchesType(Fluid fluid) {
        return fluid == FRESH_WATER || fluid == FLOWING_FRESH_WATER;
    }

    public int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    public int getTickRate(WorldView world) {
        return 5;
    }

    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == DOWN && !fluid.isIn(FluidTags.WATER);
    }

    protected float getBlastResistance() {
        return 100.0F;
    }

    public static class Flowing extends WaterFluid {
        public Flowing() {
        }

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
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

    public static class Still extends WaterFluid {
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
*/
