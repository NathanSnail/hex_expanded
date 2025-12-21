package io.github.nathansnail.hex_expanded.networking.msg

import io.github.nathansnail.hex_expanded.config.Hex_expandedServerConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: Hex_expandedServerConfig.ServerConfig) : Hex_expandedMessageS2C {
    companion object : Hex_expandedMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = Hex_expandedServerConfig.ServerConfig().decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
