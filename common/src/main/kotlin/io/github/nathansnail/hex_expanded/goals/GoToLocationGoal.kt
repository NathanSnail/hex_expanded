package io.github.nathansnail.hex_expanded.goals

import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.ai.goal.Goal
import net.minecraft.world.phys.Vec3

class GoToLocationGoal : Goal {
    var location: Vec3
    var mob: Mob
    var speedModifier: Double
    var recalculatePathTicks: Int = 0
    var acceptedDistance: Double

    constructor(
        location: Vec3,
        mob: Mob,
        speedModifier: Double,
        acceptedDistance: Double,
    ) {
        this.location = location
        this.mob = mob
        this.speedModifier = speedModifier
        this.acceptedDistance = acceptedDistance
    }

    override fun canUse(): Boolean {
        return true
    }

    private fun go() {
        if (this.mob.position().subtract(this.location).length() < this.acceptedDistance) {
            this.mob.removeAllGoals { goal -> goal == this }
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

    override fun tick() {
        go()
    }

    override fun requiresUpdateEveryTick(): Boolean {
        return true
    }
}
