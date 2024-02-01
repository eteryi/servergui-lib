package melonmodding.servergui.mixin;


import net.minecraft.core.net.packet.Packet101CloseWindow;
import net.minecraft.core.net.packet.Packet102WindowClick;
import net.minecraft.server.net.handler.NetServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = NetServerHandler.class, remap = false)
public class WindowCloseMixin {

	@Inject(method = "handleCloseWindow", at = @At("TAIL"))
	public void handleCloseWindow(Packet101CloseWindow packet, CallbackInfo ci) {

	}

	@Inject(method = "handleWindowClick", at = @At("HEAD"))
	public void handleWindowClick(Packet102WindowClick packet, CallbackInfo ci) {

	}
}
