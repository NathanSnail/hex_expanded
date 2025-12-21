package io.github.nathansnail.hex_expanded.forge

import dev.architectury.platform.forge.EventBuses
import io.github.nathansnail.hex_expanded.Hex_expanded
import io.github.nathansnail.hex_expanded.forge.datagen.ForgeHex_expandedDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hex_expanded.MODID)
class ForgeHex_expanded {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hex_expanded.MODID, this)
            addListener(ForgeHex_expandedClient::init)
            addListener(ForgeHex_expandedDatagen::init)
            addListener(ForgeHex_expandedServer::init)
        }
        Hex_expanded.init()
    }
}
