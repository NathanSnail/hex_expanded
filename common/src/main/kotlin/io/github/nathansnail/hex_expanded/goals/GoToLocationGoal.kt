package io.github.nathansnail.hex_expanded.goals

import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.ai.goal.Goal
import net.minecraft.world.phys.Vec3

class GoToLocationGoal : Goal {
    var location: Vec3
    var mob: Mob
    var speedModifier: Double

    constructor(
        location: Vec3,
        mob: Mob,
        speedModifier: Double,
    ) {
        this.location = location
        this.mob = mob
        this.speedModifier = speedModifier
    }

    override fun canUse(): Boolean {
        return true
    }

    private fun go() {
        this.mob.navigation.moveTo(location.x, location.y, location.z, speedModifier)
    }

    override fun start() {
        go()
    }

    override fun tick() {
        go()
    }
}
