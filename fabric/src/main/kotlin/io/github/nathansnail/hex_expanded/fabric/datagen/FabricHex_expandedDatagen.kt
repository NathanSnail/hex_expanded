package io.github.nathansnail.hex_expanded.fabric.datagen

import io.github.nathansnail.hex_expanded.datagen.HexExpandedActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricHexExpandedDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::HexExpandedActionTags)
    }
}
