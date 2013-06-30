package io.sunstrike.transformers.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import io.sunstrike.transformers.multiblock.ITransformerValveIn

/*
 * TransformerNvIn
 * io.sunstrike.transformers.blocks
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerNvIn(id:Int) extends Block(id, Material.anvil) {

    setCreativeTab(CreativeTabs.tabRedstone)
    setUnlocalizedName("TransformerNvIn")

    override def createTileEntity(world: World, metadata: Int): TileEntity = new TransformerNvInTile

    override def hasTileEntity(metadata: Int): Boolean = true

}

class TransformerNvInTile extends ITransformerValveIn {

}
