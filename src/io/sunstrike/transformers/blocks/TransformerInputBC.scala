package io.sunstrike.transformers.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import io.sunstrike.transformers.multiblock.ITransformerEnergyIn
import net.minecraft.creativetab.CreativeTabs

/*
 * TransformerInputBC
 * io.sunstrike.transformers.blocks
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerInputBC(id:Int) extends Block(id, Material.anvil) {

    setCreativeTab(CreativeTabs.tabRedstone)
    setUnlocalizedName("TransformerInputBC")

    override def createTileEntity(world: World, metadata: Int): TileEntity = new TransformerInputBCTile

    override def hasTileEntity(metadata: Int): Boolean = true

}

class TransformerInputBCTile extends ITransformerEnergyIn {

}