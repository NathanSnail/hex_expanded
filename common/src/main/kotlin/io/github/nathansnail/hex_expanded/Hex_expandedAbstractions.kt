@file:JvmName("Hex_expandedAbstractions")

package io.github.nathansnail.hex_expanded

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.nathansnail.hex_expanded.registry.Hex_expandedRegistrar

fun initRegistries(vararg registries: Hex_expandedRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: Hex_expandedRegistrar<T>) {
    throw AssertionError()
}
