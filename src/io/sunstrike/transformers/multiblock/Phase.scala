package io.sunstrike.transformers.multiblock

/*
 * Phase
 * io.sunstrike.transformers.multiblock
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
object Phase extends Enumeration {

    type Phase = Value

    val FILLING = Value("FILLING")
    val CHARGING = Value("CHARGING")
    val DRAINING = Value("DRAINING")

}
