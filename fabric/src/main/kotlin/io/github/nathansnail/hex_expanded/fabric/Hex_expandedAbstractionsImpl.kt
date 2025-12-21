@file:JvmName("Hex_expandedAbstractionsImpl")

package io.github.nathansnail.hex_expanded.fabric

import io.github.nathansnail.hex_expanded.registry.Hex_expandedRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: Hex_expandedRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
