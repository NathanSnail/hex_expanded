package io.github.nathansnail.hex_expanded.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.nathansnail.hex_expanded.Hex_expandedClient

object FabricHex_expandedModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(Hex_expandedClient::getConfigScreen)
}
