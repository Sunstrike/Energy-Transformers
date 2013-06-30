package io.sunstrike.transformers.multiblock

import net.minecraft.tileentity.TileEntity
import io.sunstrike.transformers.multiblock.Component._

/*
 * ITransformerCore
 * io.sunstrike.transformers.multiblock
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
trait ITransformerCore extends TileEntity {

    /**
     * Triggered when a part of the structure is broken (for invalidation)
     *
     * @param comp The component type broken
     */
    def onComponentBreak(comp: Component)

    /**
     * Called by energy inputs (ITransformerEnergyIn) to send power to the core.
     *
     * @param nvChargable Value of Nv that could be produced
     * @return Value (in Nv) that was left over
     */
    def receiveEnergy(nvChargable:Int):Int

    /**
     * Called by liquid inputs (ITransformerValveIn) to send water to the core.
     *
     * @param input Value (in mB) to send
     * @return Value (in mB) that was left over
     */
    def receiveWater(input:Int):Int

    /**
     * Called by liquid inputs (ITransformerValveIn) to send Navitas to the core.
     *
     * @param input Value (in mB) to send
     * @return Value (in mB) that was left over
     */
    def receiveNv(input:Int):Int

    /**
     * Polled by output items (ITransformerValveOut/ITransformerEnergyOut) to drain Navitas from the core
     *
     * @param output Value (mB) to try and remove
     * @return Value (mB) drained
     */
    def getNv(output:Int):Int

}
