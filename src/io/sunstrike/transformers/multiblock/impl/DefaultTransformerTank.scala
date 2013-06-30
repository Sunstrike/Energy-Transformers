package io.sunstrike.transformers.multiblock.impl

import io.sunstrike.transformers.multiblock.ITransformerTank
import net.minecraftforge.liquids.{LiquidTank, LiquidStack}

/*
 * DefaultTransformerTank
 * io.sunstrike.transformers.multiblock.impl
 */

/**
 * Default implementation of a Transformer Tank.
 *
 * @author Sunstrike
 */
class DefaultTransformerTank extends ITransformerTank {

    private val tank = new LiquidTank(8000)

    /**
     * Adds a liquid to the tank, as in ITankContainers methods
     *
     * @param liquid LiquidStack to try and add
     * @return Amount left over in mB
     */
    def storeLiquid(liquid: LiquidStack, doFill:Boolean): Int = {
        tank.fill(liquid, doFill)
    }

    /**
     * Attempts to drain from the tanks
     *
     * @param amount Amount to try and drain (mB)
     * @return A liquidstack drained from the tank
     */
    def drainLiquid(amount: Int, doDrain:Boolean): LiquidStack = {
        tank.drain(amount, doDrain)
    }

}
