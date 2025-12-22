package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.HexExpandedClient
import net.fabricmc.api.ClientModInitializer

object FabricHexExpandedClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexExpandedClient.init()
    }
}
