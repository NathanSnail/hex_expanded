package io.github.nathansnail.hex_expanded.goals

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.Mob
import java.util.*

class AttackTargetGoal(mob: Mob, val target: LivingEntity) : TemporaryGoal(mob) {
    private fun go() {
        if (target.isDeadOrDying) {
            finish()
            return
        }
        mob.target = target
    }

    override fun start() {
        go()
    }

    override fun tick() {
        go()
    }

    override fun getFlags(): EnumSet<Flag?>? = EnumSet.of(Flag.TARGET)
}
