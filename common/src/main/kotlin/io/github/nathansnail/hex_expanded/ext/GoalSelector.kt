package io.github.nathansnail.hex_expanded.ext

import net.minecraft.world.entity.ai.goal.GoalSelector

public fun GoalSelector.stopAllGoals() {
    this.availableGoals.stream().forEach { goal -> goal.stop() }
}
