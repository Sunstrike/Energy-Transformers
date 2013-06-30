package io.sunstrike.transformers

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod
import io.sunstrike.transformers.network.PacketHandler
import cpw.mods.fml.common.Mod.{PostInit, Init, PreInit}
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import io.sunstrike.transformers.configuration.Config
import net.minecraftforge.common.Configuration
import io.sunstrike.transformers.helpers.Registrations
import io.sunstrike.transformers.lib.Constants._

/*
 * Transformers
 * io.sunstrike.transformers
 */

/**
 * Transformers FML container
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
object Transformers {

    /**
     * FML Preinit
     *
     * Loads configuration
     *
     * @param event FML event
     */
    @PreInit
    def preInit(event:FMLPreInitializationEvent) {
        Config.loadConfig(new Configuration(event.getSuggestedConfigurationFile))
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
