package io.github.nathansnail.hex_expanded.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.nathansnail.hex_expanded.config.HexExpandedServerConfig
import io.github.nathansnail.hex_expanded.networking.msg.*

fun HexExpandedMessageS2C.applyOnClient(ctx: PacketContext) =
        ctx.queue {
            when (this) {
                is MsgSyncConfigS2C -> {
                    HexExpandedServerConfig.onSyncConfig(serverConfig)
                }

            // add more client-side message handlers here
            }
        }
