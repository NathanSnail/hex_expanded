package io.github.nathansnail.hex_expanded.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.nathansnail.hex_expanded.Hex_expanded
import io.github.nathansnail.hex_expanded.networking.Hex_expandedNetworking
import io.github.nathansnail.hex_expanded.networking.handler.applyOnClient
import io.github.nathansnail.hex_expanded.networking.handler.applyOnServer
import java.util.function.Supplier
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer

sealed interface Hex_expandedMessage

sealed interface Hex_expandedMessageC2S : Hex_expandedMessage {
    fun sendToServer() {
        Hex_expandedNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface Hex_expandedMessageS2C : Hex_expandedMessage {
    fun sendToPlayer(player: ServerPlayer) {
        Hex_expandedNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        Hex_expandedNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface Hex_expandedMessageCompanion<T : Hex_expandedMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hex_expanded.LOGGER.debug(
                        "Server received packet from {}: {}",
                        ctx.player.name.string,
                        this
                )
                when (msg) {
                    is Hex_expandedMessageC2S -> msg.applyOnServer(ctx)
                    else ->
                            Hex_expanded.LOGGER.warn(
                                    "Message not handled on server: {}",
                                    msg::class
                            )
                }
            }
            EnvType.CLIENT -> {
                Hex_expanded.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is Hex_expandedMessageS2C -> msg.applyOnClient(ctx)
                    else ->
                            Hex_expanded.LOGGER.warn(
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
