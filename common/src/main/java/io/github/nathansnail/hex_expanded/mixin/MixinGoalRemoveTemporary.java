package io.github.nathansnail.hex_expanded.mixin;

import io.github.nathansnail.hex_expanded.mixin_impl.GoalRemoveTemporaryKt;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GoalSelector.class)
public abstract class MixinGoalRemoveTemporary {
    @Inject(method = "tick", at = @At("TAIL"))
    protected void onTick(CallbackInfo ci) {
        GoalRemoveTemporaryKt.tick((GoalSelector) (Object) this);
    }
}
