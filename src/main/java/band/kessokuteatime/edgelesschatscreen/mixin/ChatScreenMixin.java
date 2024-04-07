package band.kessokuteatime.edgelesschatscreen.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @ModifyArgs(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V"
            )
    )
    /* int x1, int x2, int y1, int y2, int color */
    private void fillEdgeless(Args args) {
        args.set(0, (int) args.get(0) - 2);
        args.set(2, (int) args.get(2) + 2);
        args.set(3, (int) args.get(3) + 2);
    }
}
