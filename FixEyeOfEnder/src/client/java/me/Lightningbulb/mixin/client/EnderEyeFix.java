package me.Lightningbulb.mixin.client;


import net.minecraft.item.EnderEyeItem;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EnderEyeItem.class)
public abstract class EnderEyeFix {

    @ModifyVariable(method = "use", at = @At("STORE"), ordinal = 0)
    private BlockPos injected(BlockPos blockPos) {

        BlockPos correctedPos = new BlockPos(blockPos.getX()+4, 0, blockPos.getZ()+4);

        return correctedPos;
    }

}
