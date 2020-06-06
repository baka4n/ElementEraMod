package io.github.elementera.api.common.fluids;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

import static io.github.elementera.api.common.items.RegisterItem.fresh_bucket;

public abstract class ABaseFluid extends BaseFluid {
    public static final FlowableFluid FRESH_WATER, FLOWING_FRESH_WATER;

    static {
        FRESH_WATER = new Still() {
            @Override
            public Item getBucketItem() {
                return fresh_bucket;
            }
        };
        FLOWING_FRESH_WATER = new Flowing() {
            @Override
            public Item getBucketItem() {
                return fresh_bucket;
            }
        };
    }
    public static final Block FRESH = new FluidBlock(FRESH_WATER, FabricBlockSettings.copyOf(Blocks.WATER)){};
    public static void regF() {
        RegisterFluid.registerFluid("fresh_water", FRESH_WATER, FLOWING_FRESH_WATER, FRESH);
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState)
    {
        // method_15741 converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return ABaseFluid.FRESH.getDefaultState().with(Properties.LEVEL_15, method_15741(fluidState));
    }

    @Override
    public Fluid getFlowing()
    {
        return ABaseFluid.FLOWING_FRESH_WATER;
    }

    @Override
    public Fluid getStill()
    {
        return ABaseFluid.FRESH_WATER;
    }

    public abstract static class Flowing extends ABaseFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder)
        {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState)
        {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState)
        {
            return false;
        }
    }

    public abstract static class Still extends ABaseFluid {
        @Override
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState)
        {
            return true;
        }
    }
}
