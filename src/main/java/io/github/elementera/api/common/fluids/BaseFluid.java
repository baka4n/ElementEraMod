package io.github.elementera.api.common.fluids;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

/**
 * @author baka4n
 */
public abstract class BaseFluid extends FlowableFluid {

    /**
     * @param fluid getStill get getFlowing
     * @return fluid
     */
    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    /**
     * @return true
     */
    @Override
    protected boolean isInfinite() { return true; }

    /**
     * @param world worldAccess
     * @param pos blockPos
     * @param state blockState
     */
    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state)
    {
        final BlockEntity blockEntity = state.getBlock().hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world.getWorld(), pos, blockEntity);
    }

    /**
     * @param fluidState fluidState
     * @param blockView blockView
     * @param blockPos blockPos
     * @param fluid fluid
     * @param direction direction
     * @return false
     */
    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction)
    {
        return false;
    }

    /**
     * @param worldView worldView
     * @return 4
     */
    @Override
    protected int getFlowSpeed(WorldView worldView) { return 4; }

    /**
     * @param worldView worldView
     * @return 1
     */
    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView)
    {
        return 1;
    }

    /**
     * @param worldView worldView
     * @return 5
     */
    @Override
    public int getTickRate(WorldView worldView)
    {
        return 5;
    }

    /**
     * @return 100.0F
     */
    @Override
    protected float getBlastResistance()
    {
        return 100.0F;
    }
}
