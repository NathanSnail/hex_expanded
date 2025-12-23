package io.github.nathansnail.hex_expanded.goals

import io.github.nathansnail.hex_expanded.HexExpanded
import net.minecraft.world.entity.Mob
import net.minecraft.world.phys.Vec3
import java.util.*

class GoToLocationGoal : TemporaryGoal {
    private var location: Vec3
    private var speedModifier: Double
    private var recalculatePathTicks: Int = 0
    private var acceptedDistance: Double

    constructor(
        location: Vec3,
        mob: Mob,
        speedModifier: Double,
        acceptedDistance: Double,
    ) : super(mob) {
        this.location = location
        this.speedModifier = speedModifier
        this.acceptedDistance = acceptedDistance
        this.flags = EnumSet.of<Flag?>(Flag.MOVE, Flag.JUMP)
    }

    override fun canUse(): Boolean {
        return true
    }

    private fun go() {
        if (this.mob.position().subtract(this.location).length() < this.acceptedDistance) {
            this.finish()
            return
        }
        if (this.recalculatePathTicks == 0) {
            this.mob.navigation.moveTo(location.x, location.y, location.z, speedModifier)
            this.recalculatePathTicks = 40
        }
        this.recalculatePathTicks--
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
