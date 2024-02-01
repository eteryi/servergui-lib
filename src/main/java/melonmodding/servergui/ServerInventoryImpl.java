package melonmodding.servergui;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.player.inventory.InventorySorter;
import net.minecraft.server.entity.player.EntityPlayerMP;

import java.lang.reflect.Field;


class ServerInventoryImpl implements IInventory {

	public ItemStack[] invItems;
	public String invName;
	public int invSize;

	private boolean interact;

	public ServerInventoryImpl(String name, int size){
		this.invName = name;
		this.invSize = size;
		this.interact = false;
		this.invItems = new ItemStack[invSize];
	}

	public void setInteract(boolean b) {
		this.interact = b;
	}

	@Override
	public int getSizeInventory() {
		return invSize;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return invItems[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (!this.interact) return null;
		if (this.invItems[i] != null) {
			ItemStack itemstack1;
			if (this.invItems[i].stackSize <= j) {
				itemstack1 = this.invItems[i];
				this.invItems[i] = null;
				this.onInventoryChanged();
				return itemstack1;
			} else {
				itemstack1 = this.invItems[i].splitStack(j);
				if (this.invItems[i].stackSize <= 0) {
					this.invItems[i] = null;
				}

				this.onInventoryChanged();
				return itemstack1;
			}
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		invItems[i] = itemStack;
	}

	@Override
	public String getInvName() {
		return invName;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {

	}

	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return this.interact;
	}

	@Override
	public void sortInventory() {
		if (!this.interact) return;
		InventorySorter.sortInventory(invItems);
	}
}
