package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.Hex_expanded
import net.fabricmc.api.ModInitializer

object FabricHex_expanded : ModInitializer {
    override fun onInitialize() {
        Hex_expanded.init()
    }
}
