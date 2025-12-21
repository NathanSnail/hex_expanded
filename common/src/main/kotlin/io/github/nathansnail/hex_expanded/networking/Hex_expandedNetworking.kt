package io.github.nathansnail.hex_expanded.networking

import dev.architectury.networking.NetworkChannel
import io.github.nathansnail.hex_expanded.Hex_expanded
import io.github.nathansnail.hex_expanded.networking.msg.Hex_expandedMessageCompanion

object Hex_expandedNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hex_expanded.id("networking_channel"))

    fun init() {
        for (subclass in Hex_expandedMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
