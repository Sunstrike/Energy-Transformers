package io.sunstrike.transformers.lib

import java.util.logging.Logger
import io.sunstrike.transformers.blocks._

/*
 * Repo
 * io.sunstrike.transformers.lib
 */

/**
 * Object store
 *
 * @author Sunstrike
 */
object Repo {

    val logger = Logger.getLogger("Transformers")

    var block_Structure:TransformerStructure = null
    var block_Tank:TransformerTank = null
    var block_WaterIn:TransformerWaterIn = null
    var block_ValveOut:TransformerValveOut = null
    var block_InputBC:TransformerInputBC = null

}
