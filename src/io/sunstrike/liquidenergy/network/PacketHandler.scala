package io.sunstrike.liquidenergy.network

import cpw.mods.fml.common.network.{Player, IPacketHandler}
import net.minecraft.network.INetworkManager
import net.minecraft.network.packet.Packet250CustomPayload
import java.io.{ByteArrayInputStream, DataInputStream}

/*
 * PacketHandler
 * io.sunstrike.liquidenergy.network
 */

/**
 * LE packet handler
 *
 * @author Sunstrike
 */
class PacketHandler extends IPacketHandler {

    def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: Player) {}

    private def parsePacketId(packet:Packet250CustomPayload):Int = {
        val bis = new DataInputStream(new ByteArrayInputStream(packet.data))
        var id = PacketHandler.netId_Invalid
        try {
            id = bis.readInt()
        } catch {
            case ex:Exception => ex.printStackTrace()
        }
        id
    }

}

object PacketHandler {

    final val channel = "LiqEn"

    final val netId_Invalid = -1

}