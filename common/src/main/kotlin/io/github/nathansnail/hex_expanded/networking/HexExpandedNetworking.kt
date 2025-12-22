package io.github.nathansnail.hex_expanded.networking

import dev.architectury.networking.NetworkChannel
import io.github.nathansnail.hex_expanded.HexExpanded
import io.github.nathansnail.hex_expanded.networking.msg.HexExpandedMessageCompanion

object HexExpandedNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(HexExpanded.id("networking_channel"))

    fun init() {
        for (subclass in HexExpandedMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
