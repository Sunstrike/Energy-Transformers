package io.sunstrike.liquidenergy

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod
import io.sunstrike.liquidenergy.network.PacketHandler
import cpw.mods.fml.common.Mod.{PostInit, Init, PreInit}
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import io.sunstrike.liquidenergy.configuration.LEConfig
import net.minecraftforge.common.Configuration
import io.sunstrike.liquidenergy.helpers.Registrations
import io.sunstrike.liquidenergy.lib.LEConstants._

/*
 * LiquidEnergy
 * io.sunstrike.liquidenergy
 */

/**
 * LE FML container
 *
 * @author Sunstrike
 */
@Mod(modid = modId,
    name = modName,
    version = version,
    dependencies = modDeps,
    modLanguage = modLang)
@NetworkMod(clientSideRequired = true,
    serverSideRequired = false,
    channels = Array(PacketHandler.channel),
    packetHandler = classOf[PacketHandler])
object LiquidEnergy {

    /**
     * FML Preinit
     *
     * Loads configuration
     *
     * @param event FML event
     */
    @PreInit
    def preInit(event:FMLPreInitializationEvent) {
        LEConfig.loadConfig(new Configuration(event.getSuggestedConfigurationFile))
    }

    /**
     * FML Init
     *
     * Registers blocks/items
     *
     * @param event FML event
     */
    @Init
    def init(event:FMLInitializationEvent) {
        Registrations.registerAll()
    }

    /**
     * FML Postinit
     *
     * @param event FML event
     */
    @PostInit
    def postInit(event:FMLPostInitializationEvent) {

    }

}
