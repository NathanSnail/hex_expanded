package io.github.nathansnail.hex_expanded.goals

import io.github.nathansnail.hex_expanded.HexExpanded
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.ai.goal.Goal

abstract class TemporaryGoal : Goal {
    private var finished: Boolean = false
    protected var mob: Mob

    constructor(mob: Mob) {
        this.mob = mob
    }

    override fun canContinueToUse() = !finished

    fun finish() {
        this.finished = true
    }

    fun isFinished(): Boolean {
        if (finished) {
            HexExpanded.LOGGER.info("hi")
        }
        return finished
    }
}
