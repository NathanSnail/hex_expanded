package io.github.nathansnail.hex_expanded

import io.github.nathansnail.hex_expanded.config.Hex_expandedServerConfig
import io.github.nathansnail.hex_expanded.networking.Hex_expandedNetworking
import io.github.nathansnail.hex_expanded.registry.Hex_expandedActions
import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Hex_expanded {
    const val MODID = "hex_expanded"

    @JvmField val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        Hex_expandedServerConfig.init()
        initRegistries(
                Hex_expandedActions,
        )
        Hex_expandedNetworking.init()
    }

    fun initServer() {
        Hex_expandedServerConfig.initServer()
    }
}
