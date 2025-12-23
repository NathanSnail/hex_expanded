package io.github.nathansnail.hex_expanded.mixin_impl

import io.github.nathansnail.hex_expanded.goals.TemporaryGoal
import net.minecraft.world.entity.ai.goal.Goal
import net.minecraft.world.entity.ai.goal.GoalSelector
import net.minecraft.world.entity.ai.goal.WrappedGoal
import java.util.function.Predicate

public fun tick(selector: GoalSelector) {
    selector.removeAllGoalsFixed { goal ->
        when (goal) {
            is TemporaryGoal -> goal.isFinished()
            else -> false
        }
    }
}

fun GoalSelector.removeAllGoalsFixed(predicate: Predicate<Goal>) {
    this.availableGoals.filter { goal ->
        predicate.test(goal.goal)
    }.toList().forEach { goal ->
        this.removeGoalFixed(goal)
    }
}

private fun GoalSelector.removeGoalFixed(goal: WrappedGoal) {
    this.availableGoals.filter { wrappedGoal -> wrappedGoal == goal }.forEach(WrappedGoal::stop)
    this.availableGoals.remove(goal)
    for (flag in goal.flags) {
        this.lockedFlags.remove(flag)
    }
}
