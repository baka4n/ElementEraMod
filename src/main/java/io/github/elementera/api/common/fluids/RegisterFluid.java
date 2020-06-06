package io.github.elementera.api.common.fluids;

import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterFluid {
    private RegisterFluid() {
    }

    public static void registerFluid(String fluidID, FlowableFluid s, FlowableFluid f, Block fb) {
        Registry.register(Registry.FLUID, new Identifier("elementera", fluidID), s);
        Registry.register(Registry.FLUID, new Identifier("ellementera", "flowing_" + fluidID), f);
        Registry.register(Registry.BLOCK, new Identifier("elementera", fluidID), fb);
    }
}
