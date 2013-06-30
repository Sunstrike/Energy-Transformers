package io.sunstrike.transformers.blocks

import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import io.sunstrike.transformers.multiblock.ITransformerValveIn
import net.minecraft.creativetab.CreativeTabs

/*
 * TransformerWaterIn
 * io.sunstrike.transformers.blocks
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerWaterIn(id:Int) extends Block(id, Material.anvil) {

    setCreativeTab(CreativeTabs.tabRedstone)
    setUnlocalizedName("TransformerWaterIn")

    override def createTileEntity(world: World, metadata: Int): TileEntity = new TransformerWaterInTile

    override def hasTileEntity(metadata: Int): Boolean = true

}

class TransformerWaterInTile extends ITransformerValveIn {

}