package fr.MrBn100ful.mcjeu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsManagers implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("join")) {

			if (!StartLoop.gamestarted) {
				
				PlayersManager.AddParticipent((Player) sender, true, true);
				
			} else {
				
				Player player = (Player) sender;
				
				player.sendMessage("Le jeu est déja lancer !");
				
			}

			return true;
		}

		if (cmd.getName().equalsIgnoreCase("quit")) {

			PlayersManager.RemoveParticipent((Player) sender, true, 1);

			return true;
		}

		return true;

	}
}