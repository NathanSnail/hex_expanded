package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.HexExpanded
import net.fabricmc.api.ModInitializer

object FabricHexExpanded : ModInitializer {
    override fun onInitialize() {
        HexExpanded.init()
    }
}
