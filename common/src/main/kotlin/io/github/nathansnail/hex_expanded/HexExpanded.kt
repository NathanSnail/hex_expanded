package io.github.nathansnail.hex_expanded

import io.github.nathansnail.hex_expanded.config.HexExpandedServerConfig
import io.github.nathansnail.hex_expanded.networking.HexExpandedNetworking
import io.github.nathansnail.hex_expanded.registry.HexExpandedActions
import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object HexExpanded {
    const val MODID = "hex_expanded"

    @JvmField val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexExpandedServerConfig.init()
        initRegistries(
                HexExpandedActions,
        )
        HexExpandedNetworking.init()
    }

    fun initServer() {
        HexExpandedServerConfig.initServer()
    }
}
