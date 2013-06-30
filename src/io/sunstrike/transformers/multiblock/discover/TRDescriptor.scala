package io.sunstrike.transformers.multiblock.discover

import io.sunstrike.corestrike.util.forge.Position
import scala.collection.mutable.ArrayBuffer

/*
 * TRDescriptor
 * io.sunstrike.transformers.multiblock.discover
 */

/**
 * Represents structures in memory
 *
 * @author Sunstrike
 */
class TRDescriptor {

}

/**
 * Companion - Special constructor
 *
 * @author Sunstrike
 */
object TRDescriptor {

    /**
     * Helper to verify and create a descriptor object
     *
     * @param tank The core tank position
     * @param output Position of output block
     * @param structures ArrayBuffer of Positions for structural blocks
     * @param inputs ArrayBuffer of Positions for input blocks
     * @return A descriptor if created or null
     */
    def createDescriptor(tank:Position, output:Position, structures:ArrayBuffer[Position], inputs:ArrayBuffer[Position]):TRDescriptor = {
        ???
    }

}
