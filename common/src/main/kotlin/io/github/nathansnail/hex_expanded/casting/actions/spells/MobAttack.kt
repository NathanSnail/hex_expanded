package io.github.nathansnail.hex_expanded.casting.actions.spells

import at.petrak.hexcasting.api.casting.ParticleSpray
import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getEntity
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapImmuneEntity
import at.petrak.hexcasting.api.misc.MediaConstants
import io.github.nathansnail.hex_expanded.ext.stopAllGoals
import io.github.nathansnail.hex_expanded.goals.AttackTargetGoal
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.Mob

object MobAttack : SpellAction {
    override val argc = 2

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val mob = args.getEntity(0, argc)
        val target = args.getEntity(1, argc)
        env.assertEntityInRange(mob)
        env.assertEntityInRange(target)
        if (mob !is Mob) {
            throw MishapImmuneEntity(mob)
        }

        if (target !is LivingEntity) {
            throw MishapImmuneEntity(target)
        }

        return SpellAction.Result(
            Spell(mob, target),
            (0.1 * MediaConstants.DUST_UNIT).toLong(),
            listOf(
                ParticleSpray.cloud(
                    mob.position().add(0.0, mob.eyeHeight / 2.0, 0.0),
                    1.0
                ),
                ParticleSpray.cloud(
                    target.position().add(0.0, target.eyeHeight / 2.0, 0.0),
                    1.0
                ),
            )
        )
    }

    private data class Spell(val mob: Mob, val target: LivingEntity) : RenderedSpell {
        // IMPORTANT: do not throw mishaps in this method! mishaps should ONLY be thrown in
        // SpellAction.execute
        override fun cast(env: CastingEnvironment) {
            mob.goalSelector.stopAllGoals()
            mob.goalSelector.addGoal(
                0,
                AttackTargetGoal(mob, target)
            )
        }
    }
}
