package io.sunstrike.transformers.multiblock

import net.minecraft.tileentity.TileEntity
import net.minecraftforge.liquids.LiquidStack

/*
 * ITransformerTank
 * io.sunstrike.transformers.multiblock
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
trait ITransformerTank extends TileEntity {

    /**
     * Adds a liquid to the tank, as in ITankContainers methods
     *
     * @param liquid LiquidStack to try and add
     * @return Amount left over in mB
     */
    def storeLiquid(liquid:LiquidStack, doFill:Boolean):Int

    /**
     * Attempts to drain from the tanks
     *
     * @param amount Amount to try and drain (mB)
     * @return A liquidstack drained from the tank
     */
    def drainLiquid(amount:Int, doDrain:Boolean):LiquidStack

}
