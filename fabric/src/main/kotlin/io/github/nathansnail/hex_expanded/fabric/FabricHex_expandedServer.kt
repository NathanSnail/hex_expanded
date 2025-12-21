package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.Hex_expanded
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHex_expandedServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Hex_expanded.initServer()
    }
}
