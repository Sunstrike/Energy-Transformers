package io.sunstrike.transformers.configuration

import net.minecraftforge.common.Configuration
import cpw.mods.fml.common.FMLCommonHandler

/*
 * Config
 * io.sunstrike.transformers.configuration
 */

/**
 * Configuration support strut
 *
 * @author Sunstrike
 */
object Config {

    //=== Defaults ==================================
    var conversion_LossRate = 15

    var block_Structure_id = 1000
    var block_Tank_id = 1000
    var block_ValveOut_id = 1000
    var block_WaterIn_id = 1000
    var block_InputBC_id = 1000

    //=== Functions =================================
    def loadConfig(cfg:Configuration) {
        cfg.load()

        conversion_LossRate = cfg.get("Conversions", "lossRatePercent", conversion_LossRate).getInt
        if (0 > conversion_LossRate || conversion_LossRate > 99) {
            val ex = new RuntimeException("Invalid conversion_LossRate!")
            FMLCommonHandler.instance().raiseException(ex, "[LiqEn] Invalid loss rate configuration", true)
        }

        block_Structure_id = cfg.getBlock("structure", block_Structure_id).getInt
        block_Tank_id = cfg.getBlock("tank", block_Tank_id).getInt
        block_ValveOut_id = cfg.getBlock("valveOut", block_ValveOut_id).getInt
        block_WaterIn_id = cfg.getBlock("waterIn", block_WaterIn_id).getInt
        block_InputBC_id = cfg.getBlock("inputBC", block_InputBC_id).getInt

        cfg.save()
    }

}
