package io.sunstrike.liquidenergy.configuration

import net.minecraftforge.common.Configuration
import cpw.mods.fml.common.FMLCommonHandler

/*
 * LEConfig
 * io.sunstrike.liquidenergy.configuration
 */

/**
 * Configuration support strut
 *
 * @author Sunstrike
 */
object LEConfig {

    //=== Defaults ==================================
    var conversion_LossRate = 15

    //=== Functions =================================
    def loadConfig(cfg:Configuration) {
        cfg.load()

        conversion_LossRate = cfg.get("Conversions", "lossRatePercent", conversion_LossRate).getInt
        if (0 > conversion_LossRate || conversion_LossRate > 99) {
            val ex = new RuntimeException("Invalid conversion_LossRate!")
            FMLCommonHandler.instance().raiseException(ex, "[LiqEn] Invalid loss rate configuration", true)
        }

        cfg.save()
    }

}
