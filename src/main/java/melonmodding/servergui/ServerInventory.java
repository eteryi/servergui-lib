package melonmodding.servergui;

import net.minecraft.core.item.ItemStack;
import net.minecraft.server.entity.player.EntityPlayerMP;

import java.lang.reflect.Field;

public class ServerInventory {
	private final ServerInventoryImpl inventory;

	protected ServerInventory(String name, int size) {
		this.inventory = new ServerInventoryImpl(name, size);
	}

	public void setInteract(boolean interact) {
		this.inventory.setInteract(interact);
	}

	public void setItem(int i, ItemStack item) {
		inventory.setInventorySlotContents(i, item);
	}

	private int getCurrentWindowId(EntityPlayerMP playerMP) {
		Integer id;
		try {
			Field f = EntityPlayerMP.class.getDeclaredField("currentWindowId");
			f.setAccessible(true);
			id = (Integer) f.get(playerMP);
			f.setAccessible(false);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return id;
	}

	public void open(EntityPlayerMP player) {
		player.displayGUIChest(this.inventory);
		Viewer viewer = ServerGUI.getViewer(player);
		viewer.setCurrentInventory(this);
	}
}
