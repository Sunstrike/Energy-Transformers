package io.sunstrike.transformers.blocks

import io.sunstrike.transformers.multiblock.{ITransformerTank, ITransformerCore}
import net.minecraftforge.liquids.LiquidStack
import io.sunstrike.transformers.multiblock.Component._
import net.minecraft.block.material.Material
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import io.sunstrike.corestrike.struts.forge.{IDebuggableTile, CSBlock}
import io.sunstrike.transformers.lib.Repo._
import net.minecraft.entity.player.EntityPlayer
import io.sunstrike.transformers.multiblock.discover.{TRDescriptor, TRDiscoveryAgent}
import io.sunstrike.corestrike.util.forge.Position
import net.minecraft.creativetab.CreativeTabs

/*
 * TransformerTank
 * io.sunstrike.transformers.blocks
 */
/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerTank(id:Int) extends CSBlock(id, Material.anvil) {

    setHardness(1.0f)
    setCreativeTab(CreativeTabs.tabRedstone)
    setUnlocalizedName("TransformerTank")

    override def createTileEntity(world: World, metadata: Int): TileEntity = new TransformerTankTile

    override def hasTileEntity(metadata: Int): Boolean = true

}

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerTankTile extends ITransformerCore with ITransformerTank with IDebuggableTile {

    //=== ITransformerCore ==========================
    /**
     * Triggered when a part of the structure is broken (for invalidation)
     *
     * @param comp The component type broken
     */
    def onComponentBreak(comp: Component) {}

    /**
     * Called by energy inputs (ITransformerEnergyIn) to send power to the core.
     *
     * @param nvChargable Value of Nv that could be produced
     * @return Value (in Nv) that was left over
     */
    def receiveEnergy(nvChargable: Int): Int = 0

    /**
     * Called by liquid inputs (ITransformerValveIn) to send water to the core.
     *
     * @param input Value (in mB) to send
     * @return Value (in mB) that was left over
     */
    def receiveWater(input: Int): Int = 0

    /**
     * Called by liquid inputs (ITransformerValveIn) to send Navitas to the core.
     *
     * @param input Value (in mB) to send
     * @return Value (in mB) that was left over
     */
    def receiveNv(input: Int): Int = 0

    /**
     * Polled by output items (ITransformerValveOut/ITransformerEnergyOut) to drain Navitas from the core
     *
     * @param output Value (mB) to try and remove
     * @return Value (mB) drained
     */
    def getNv(output: Int): Int = 0

    //=== ITransformerTank ==========================
    /**
     * Adds a liquid to the tank, as in ITankContainers methods
     *
     * @param liquid LiquidStack to try and add
     * @return Amount left over in mB
     */
    def storeLiquid(liquid: LiquidStack, doFill: Boolean): Int = 0

    /**
     * Attempts to drain from the tanks
     *
     * @param amount Amount to try and drain (mB)
     * @return A liquidstack drained from the tank
     */
    def drainLiquid(amount: Int, doDrain: Boolean): LiquidStack = null

    //=== IDebuggableTile ===========================
    /**
     * Debug hook for CSBlock.
     *
     * Used to send debugging information to the acting player. Send messages with player.addChatMessage, preferably in form "[TileClassName] Debug message".
     *
     * @param world World the player is in.
     * @param player The player acting to get debug info.
     */
    def sendDebugToPlayer(world: World, player: EntityPlayer) {
        val agent = new TRDiscoveryAgent
        val desc = agent.discover(new Position(worldObj, xCoord, yCoord, zCoord))
        player.addChatMessage("[TransformerTankTile] agent: " + agent + ", desc: " + desc)
    }

}
