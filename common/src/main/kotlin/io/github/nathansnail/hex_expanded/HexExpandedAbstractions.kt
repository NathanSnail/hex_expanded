@file:JvmName("HexExpandedAbstractions")

package io.github.nathansnail.hex_expanded

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.nathansnail.hex_expanded.registry.HexExpandedRegistrar

fun initRegistries(vararg registries: HexExpandedRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexExpandedRegistrar<T>) {
    throw AssertionError()
}
