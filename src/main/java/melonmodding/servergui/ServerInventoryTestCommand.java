package melonmodding.servergui;

import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.CommandSender;
import net.minecraft.server.entity.player.EntityPlayerMP;

public class ServerInventoryTestCommand extends Command {
	public ServerInventoryTestCommand() {
		super("window");
	}

	@Override
	public boolean execute(CommandHandler commandHandler, CommandSender commandSender, String[] strings) {
		if (commandSender.isPlayer()) {
			EntityPlayerMP playerMP = (EntityPlayerMP) commandSender.getPlayer();
			ServerInventory inventory = ServerGUI.createInventory("Games", 27);
			inventory.open(playerMP);

		}
		return true;
	}

	@Override
	public boolean opRequired(String[] strings) {
		return false;
	}

	@Override
	public void sendCommandSyntax(CommandHandler commandHandler, CommandSender commandSender) {
		commandHandler.sendCommandFeedback(commandSender, "/window");
	}
}
