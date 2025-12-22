package io.github.nathansnail.hex_expanded.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.nathansnail.hex_expanded.config.Hex_expandedServerConfig
import io.github.nathansnail.hex_expanded.networking.msg.*

fun Hex_expandedMessageS2C.applyOnClient(ctx: PacketContext) =
        ctx.queue {
            when (this) {
                is MsgSyncConfigS2C -> {
                    Hex_expandedServerConfig.onSyncConfig(serverConfig)
                }

            // add more client-side message handlers here
            }
        }
