package io.sunstrike.transformers.helpers

import io.sunstrike.corestrike.util.forge.RegistrationHelper._
import io.sunstrike.transformers.blocks._
import io.sunstrike.transformers.lib.Repo._
import io.sunstrike.transformers.configuration.Config._
import cpw.mods.fml.common.registry.{LanguageRegistry, GameRegistry}

/*
 * Registrations
 * io.sunstrike.transformers.helpers
 */

/**
 * Forge registration handler
 *
 * @author Sunstrike
 */
object Registrations {

    private def registerBlocks() {
        registerTE(classOf[TransformerStructureTile], "structureTile")
        block_Structure = new TransformerStructure(block_Structure_id)
        GameRegistry.registerBlock(block_Structure, "structureBlock")
        LanguageRegistry.addName(block_Structure, "Transformer Structure")

        registerTE(classOf[TransformerTankTile], "tankTile")
        block_Tank = new TransformerTank(block_Tank_id)
        GameRegistry.registerBlock(block_Tank, "tankBlock")
        LanguageRegistry.addName(block_Tank, "Transformer Tank")

        registerTE(classOf[TransformerValveOutTile], "valveOutTile")
        block_ValveOut = new TransformerValveOut(block_ValveOut_id)
        GameRegistry.registerBlock(block_ValveOut, "valveOutBlock")
        LanguageRegistry.addName(block_ValveOut, "Transformer Output Valve")

        registerTE(classOf[TransformerWaterInTile], "waterInTile")
        block_WaterIn = new TransformerWaterIn(block_WaterIn_id)
        GameRegistry.registerBlock(block_WaterIn, "waterInBlock")
        LanguageRegistry.addName(block_WaterIn, "Transformer Water Input")

        registerTE(classOf[TransformerInputBCTile], "inputBCTile")
        block_InputBC = new TransformerInputBC(block_InputBC_id)
        GameRegistry.registerBlock(block_InputBC, "inputBCBlock")
        LanguageRegistry.addName(block_InputBC, "Transformer BuildCraft Input")
    }

    private def registerItems() {

    }

    def registerAll() {
        registerBlocks()
        registerItems()
    }

}
