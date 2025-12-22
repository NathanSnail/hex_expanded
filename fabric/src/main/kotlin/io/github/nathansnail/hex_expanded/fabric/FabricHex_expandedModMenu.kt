package io.github.nathansnail.hex_expanded.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.nathansnail.hex_expanded.HexExpandedClient

object FabricHexExpandedModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexExpandedClient::getConfigScreen)
}
