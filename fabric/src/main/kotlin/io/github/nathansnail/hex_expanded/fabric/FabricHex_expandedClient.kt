package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.Hex_expandedClient
import net.fabricmc.api.ClientModInitializer

object FabricHex_expandedClient : ClientModInitializer {
    override fun onInitializeClient() {
        Hex_expandedClient.init()
    }
}
