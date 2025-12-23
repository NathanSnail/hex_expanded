package io.github.nathansnail.hex_expanded.goals

import io.github.nathansnail.hex_expanded.HexExpanded
import net.minecraft.world.entity.Mob
import net.minecraft.world.phys.Vec3

class GoToLocationGoal(mob: Mob, val location: Vec3, val speedModifier: Double, val acceptedDistance: Double) :
    TemporaryGoal(mob) {
    private var recalculatePathTicks: Int = 0

    private fun go() {
        if (recalculatePathTicks == 0) {
            mob.navigation.moveTo(location.x, location.y, location.z, speedModifier)
            recalculatePathTicks = 40
        }
        if (mob.navigation.path?.isDone ?: false) {
            finish()
            return
        }
        recalculatePathTicks--
    }

    override fun start() {
        go()
    }

    override fun stop() {
        HexExpanded.LOGGER.info("GoToLocationGoal stop")
    }

    override fun tick() {
        go()
    }

    override fun requiresUpdateEveryTick(): Boolean {
        return true
    }
}
