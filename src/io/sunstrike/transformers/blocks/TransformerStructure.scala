package io.sunstrike.transformers.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import io.sunstrike.transformers.multiblock.ITransformerStructure
import net.minecraft.creativetab.CreativeTabs

/*
 * TransformerStructure
 * io.sunstrike.transformers.blocks
 */

/**
 * Class description not provided.
 *
 * @author Sunstrike
 */
class TransformerStructure(id:Int) extends Block(id, Material.anvil) {

    setCreativeTab(CreativeTabs.tabRedstone)
    setUnlocalizedName("TransformerStructure")

    override def createTileEntity(world: World, metadata: Int): TileEntity = new TransformerStructureTile

    override def hasTileEntity(metadata: Int): Boolean = true

}

class TransformerStructureTile extends ITransformerStructure {

}
