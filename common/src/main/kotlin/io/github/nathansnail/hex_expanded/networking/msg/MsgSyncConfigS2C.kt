package io.github.nathansnail.hex_expanded.networking.msg

import io.github.nathansnail.hex_expanded.config.HexExpandedServerConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HexExpandedServerConfig.ServerConfig) :
        HexExpandedMessageS2C {
    companion object : HexExpandedMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) =
                MsgSyncConfigS2C(
                        serverConfig = HexExpandedServerConfig.ServerConfig().decode(buf),
                )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
