package io.github.nathansnail.hex_expanded.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.nathansnail.hex_expanded.HexExpanded
import io.github.nathansnail.hex_expanded.networking.HexExpandedNetworking
import io.github.nathansnail.hex_expanded.networking.handler.applyOnClient
import io.github.nathansnail.hex_expanded.networking.handler.applyOnServer
import java.util.function.Supplier
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer

sealed interface HexExpandedMessage

sealed interface HexExpandedMessageC2S : HexExpandedMessage {
    fun sendToServer() {
        HexExpandedNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexExpandedMessageS2C : HexExpandedMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexExpandedNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexExpandedNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexExpandedMessageCompanion<T : HexExpandedMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                HexExpanded.LOGGER.debug(
                        "Server received packet from {}: {}",
                        ctx.player.name.string,
                        this
                )
                when (msg) {
                    is HexExpandedMessageC2S -> msg.applyOnServer(ctx)
                    else ->
                            HexExpanded.LOGGER.warn(
                                    "Message not handled on server: {}",
                                    msg::class
                            )
                }
            }
            EnvType.CLIENT -> {
                HexExpanded.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexExpandedMessageS2C -> msg.applyOnClient(ctx)
                    else ->
                            HexExpanded.LOGGER.warn(
                                    "Message not handled on client: {}",
                                    msg::class
                            )
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
