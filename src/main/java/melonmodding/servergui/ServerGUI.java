package melonmodding.servergui;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.server.entity.player.EntityPlayerMP;

import java.util.HashMap;

public class ServerGUI {
	private static final HashMap<EntityPlayerMP, Viewer> viewers = new HashMap<>();

	public static ServerInventory createInventory(String name, int size, boolean interact) {
		ServerInventory inventory = new ServerInventory(name, size);
		inventory.setInteract(interact);
		return inventory;
	}

	public static ServerInventory createInventory(String name, int size) {
		return createInventory(name, size, true);
	}

	protected static Viewer getViewer(EntityPlayerMP player) {
		viewers.putIfAbsent(player, new Viewer(player));
		return viewers.get(player);
	}
	public static void openInventory(EntityPlayerMP player, ServerInventory inventory) {
		Viewer viewer = getViewer(player);

	}


}
