package io.github.nathansnail.hex_expanded.forge

import io.github.nathansnail.hex_expanded.HexExpanded
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHexExpandedServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        HexExpanded.initServer()
    }
}
