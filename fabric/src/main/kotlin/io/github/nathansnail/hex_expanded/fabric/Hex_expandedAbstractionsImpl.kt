@file:JvmName("HexExpandedAbstractionsImpl")

package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.registry.HexExpandedRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexExpandedRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
