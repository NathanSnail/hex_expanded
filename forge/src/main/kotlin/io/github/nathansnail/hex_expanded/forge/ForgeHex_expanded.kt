package io.github.nathansnail.hex_expanded.forge

import dev.architectury.platform.forge.EventBuses
import io.github.nathansnail.hex_expanded.HexExpanded
import io.github.nathansnail.hex_expanded.forge.datagen.ForgeHexExpandedDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(HexExpanded.MODID)
class ForgeHexExpanded {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HexExpanded.MODID, this)
            addListener(ForgeHexExpandedClient::init)
            addListener(ForgeHexExpandedDatagen::init)
            addListener(ForgeHexExpandedServer::init)
        }
        HexExpanded.init()
    }
}
