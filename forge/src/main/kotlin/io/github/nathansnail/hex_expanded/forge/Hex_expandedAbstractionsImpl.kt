@file:JvmName("HexExpandedAbstractionsImpl")

package io.github.nathansnail.hex_expanded.forge

import io.github.nathansnail.hex_expanded.registry.HexExpandedRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexExpandedRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
