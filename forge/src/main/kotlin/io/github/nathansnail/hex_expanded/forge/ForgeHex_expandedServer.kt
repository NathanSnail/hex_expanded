package io.github.nathansnail.hex_expanded.forge

import io.github.nathansnail.hex_expanded.Hex_expanded
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHex_expandedServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Hex_expanded.initServer()
    }
}
