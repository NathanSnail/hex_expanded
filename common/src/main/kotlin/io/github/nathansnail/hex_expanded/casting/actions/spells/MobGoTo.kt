package io.github.nathansnail.hex_expanded.casting.actions.spells

import at.petrak.hexcasting.api.casting.ParticleSpray
import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getEntity
import at.petrak.hexcasting.api.casting.getVec3
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapImmuneEntity
import at.petrak.hexcasting.api.misc.MediaConstants
import io.github.nathansnail.hex_expanded.goals.GoToLocationGoal
import net.minecraft.world.entity.Mob
import net.minecraft.world.phys.Vec3

object MobGoTo : SpellAction {
    override val argc = 2

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val target = args.getEntity(0, argc)
        val pos = args.getVec3(1, argc)
        env.assertEntityInRange(target)
        env.assertVecInRange(pos)
        val mob =
            when (target) {
                is Mob -> target
                else -> throw MishapImmuneEntity(target)
            }

        return SpellAction.Result(
            Spell(mob, pos),
            (0.1 * MediaConstants.DUST_UNIT).toLong(),
            listOf(
                ParticleSpray.cloud(
                    target.position().add(0.0, target.eyeHeight / 2.0, 0.0),
                    1.0
                )
            )
        )
    }

    private data class Spell(val target: Mob, val pos: Vec3) : RenderedSpell {
        // IMPORTANT: do not throw mishaps in this method! mishaps should ONLY be thrown in
        // SpellAction.execute
        override fun cast(env: CastingEnvironment) {
            target.goalSelector.addGoal(
                0,
                GoToLocationGoal(pos, target, 1.0)
            )
        }
    }
}
