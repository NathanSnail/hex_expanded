package io.github.nathansnail.hex_expanded.mixin;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MixinDamageAttribute {
    @Inject(method = "createMobAttributes", at = @At("RETURN"))
    private static void onCreateMobAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        AttributeSupplier.Builder return_v = cir.getReturnValue();
        return_v.add(Attributes.ATTACK_DAMAGE);
    }
}
