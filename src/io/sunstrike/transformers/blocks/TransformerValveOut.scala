package io.sunstrike.transformers.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import io.sunstrike.transformers.multiblock.ITransformerValveOut
import net.minecraft.creativetab.CreativeTabs

/*
 * TransformerValveOut
 * io.sunstrike.transformers.blocks
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerValveOut(id:Int) extends Block(id, Material.anvil) {

    setCreativeTab(CreativeTabs.tabRedstone)
    setUnlocalizedName("TransformerValveOut")

    override def createTileEntity(world: World, metadata: Int): TileEntity = new TransformerValveOutTile

    override def hasTileEntity(metadata: Int): Boolean = true

}

class TransformerValveOutTile extends ITransformerValveOut {

}