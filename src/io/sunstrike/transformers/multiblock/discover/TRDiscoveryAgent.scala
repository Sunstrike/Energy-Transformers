package io.sunstrike.transformers.multiblock.discover

import net.minecraftforge.common.ForgeDirection
import io.sunstrike.corestrike.util.forge.Position
import io.sunstrike.transformers.multiblock._
import io.sunstrike.transformers.lib.Repo._
import io.sunstrike.transformers.multiblock.StructureType._
import scala.collection.mutable.ArrayBuffer

/*
 * TRDiscoveryAgent
 * io.sunstrike.transformers.multiblock.discover
 */

/**
 * Discovery util to detect structures and create descriptors.
 *
 * @author Sunstrike
 */
class TRDiscoveryAgent {

    def discover(pos:Position):TRDescriptor = {
        // Output
        val outs = searchOutputs(pos)
        logger.info("[DiscoveryAgent] outs:")
        for (i <- outs) {
            logger.info("[DiscoveryAgent]   -> " + i)
        }
        if (outs.length != 1) return null
        val out = outs(0)

        // Structure
        val structs = searchStructure(pos, out.dir)
        logger.info("[DiscoveryAgent] structs:")
        for (i <- structs) {
            logger.info("[DiscoveryAgent]   -> " + i)
        }
        if (structs.length != 2) return null

        val inputs = searchInputs(structs, out.dir.getOpposite)
        logger.info("[DiscoveryAgent] inputs:")
        for (i <- inputs) {
            logger.info("[DiscoveryAgent]   -> " + i)
        }
        if (inputs.length != 2) return null

        val structType = discoverType(pos, out, inputs)
        if (structType == null) return null

        TRDescriptor.createDescriptor(pos, out, structs, inputs)
    }

    private def searchOutputs(pos:Position): ArrayBuffer[Position] = {
        var out = ArrayBuffer[Position]()
        for (dir <- ForgeDirection.VALID_DIRECTIONS) {
            val x = pos.x + dir.offsetX
            val y = pos.y + dir.offsetY
            val z = pos.z + dir.offsetZ
            val te = pos.world.apply().getBlockTileEntity(x, y, z)
            if (te != null && te.isInstanceOf[ITransformerEnergyOut] || te.isInstanceOf[ITransformerValveOut]) {
                val p = new Position(pos.world.apply(), x, y, z, dir)
                out += p
            }
        }
        out
    }

    private def searchStructure(pos:Position, d:ForgeDirection): ArrayBuffer[Position] = {
        var out = ArrayBuffer[Position]()
        var validPos = ForgeDirection.VALID_DIRECTIONS
        validPos = validPos.filter(p => p != d && p != d.getOpposite)
        for (dir <- validPos) {
            val x = pos.x + dir.offsetX
            val y = pos.y + dir.offsetY
            val z = pos.z + dir.offsetZ
            val te = pos.world.apply().getBlockTileEntity(x, y, z)
            if (te != null && te.isInstanceOf[ITransformerStructure]) {
                val p = new Position(pos.world.apply(), x, y, z, dir)
                out += p
            }
        }
        out
    }

    private def searchInputs(pos:ArrayBuffer[Position], dir:ForgeDirection): ArrayBuffer[Position] = {
        var out = ArrayBuffer[Position]()
        for (p <- pos) {
            val x = p.x + dir.offsetX
            val y = p.y + dir.offsetY
            val z = p.z + dir.offsetZ
            val te = p.world.apply().getBlockTileEntity(x, y, z)
            if (te != null && te.isInstanceOf[ITransformerValveIn] || te.isInstanceOf[ITransformerEnergyIn]) {
                val newP = new Position(p.world.apply(), x, y, z, dir)
                out += newP
            }
        }
        out
    }

    private def discoverType(core:Position, output:Position, inputs:ArrayBuffer[Position]):Structure = {
        val outTE = output.world.apply().getBlockTileEntity(output.x, output.y, output.z)
        if (outTE == null) return null

        if (outTE.isInstanceOf[ITransformerValveOut]) {
            // So we're a liquid output; do we have an energy and water input?
        } else if (outTE.isInstanceOf[ITransformerEnergyOut]) {
            // So we're an energy output; do we have two liquid inputs, one for water, one for Nv?
        }

        ???
    }

}
