@file:JvmName("Hex_expandedAbstractionsImpl")

package io.github.nathansnail.hex_expanded.forge

import io.github.nathansnail.hex_expanded.registry.Hex_expandedRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: Hex_expandedRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
