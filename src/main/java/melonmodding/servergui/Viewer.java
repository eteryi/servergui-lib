package melonmodding.servergui;

import net.minecraft.server.entity.player.EntityPlayerMP;

public class Viewer {
	public final EntityPlayerMP player;
	private int windowID;
	private ServerInventory currentInventory;

	protected Viewer(EntityPlayerMP player) {
		this.player = player;
		this.windowID = -1;
		this.currentInventory = null;
	}

	public ServerInventory getCurrentInventory() {
		return currentInventory;
	}

	public void setCurrentInventory(ServerInventory currentInventory) {
		this.currentInventory = currentInventory;
	}

	public int getWindowID() {
		return windowID;
	}

	public void setWindowID(int windowID) {
		this.windowID = windowID;
	}
}
