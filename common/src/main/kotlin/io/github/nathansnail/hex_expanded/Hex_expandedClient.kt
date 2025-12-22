package io.github.nathansnail.hex_expanded

import io.github.nathansnail.hex_expanded.config.Hex_expandedClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object Hex_expandedClient {
    fun init() {
        Hex_expandedClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(Hex_expandedClientConfig.GlobalConfig::class.java, parent)
                .get()
    }
}
