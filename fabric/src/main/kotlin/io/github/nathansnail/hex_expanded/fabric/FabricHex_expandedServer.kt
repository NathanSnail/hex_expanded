package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.HexExpanded
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHexExpandedServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        HexExpanded.initServer()
    }
}
