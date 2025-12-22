package io.github.nathansnail.hex_expanded

import io.github.nathansnail.hex_expanded.config.HexExpandedClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexExpandedClient {
    fun init() {
        HexExpandedClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HexExpandedClientConfig.GlobalConfig::class.java, parent)
                .get()
    }
}
