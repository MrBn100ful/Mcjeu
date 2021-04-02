package fr.MrBn100ful.mcjeu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayersManager {

	public static ArrayList<Player> listparticipents = new ArrayList<Player>();

	public static boolean AddParticipent(Player player, boolean m1, boolean m2) {

		if (listparticipents.contains(player)) {
			player.sendMessage(Main.nomdujeu + "vous �tes d�ja dans le mini jeu");
			return false;
		} else if (m2) {

			listparticipents.add(player);

			player.sendMessage(Main.nomdujeu + "Vous avez bien rejoint le mini jeu.");

			Bukkit.broadcastMessage(Main.nomdujeu + player.getName() + " a rejoint le mini jeu. "
					+ PlayersManager.NombreParticipents() + "/10");
		}

		return true;

	}

	public static boolean RemoveParticipent(Player player, boolean m1, int m2) {

		if (!listparticipents.contains(player))  {
			
			if (m1) {
				player.sendMessage(Main.nomdujeu + "Vous n'�tes pas dans le mini jeu");
			}
			
			return false;
		} else {

			listparticipents.remove(player);

			if (m2 == 1) {

				player.sendMessage(Main.nomdujeu + "Vous avez bien quitter le mini jeu.");

				Bukkit.broadcastMessage(
						Main.nomdujeu + player.getName() + " a quitter le mini jeu. " + NombreParticipents() + "/10");

			} else if (m2 == 2) {

				player.sendMessage(Main.nomdujeu + "Vous avez bien perdu le mini jeu.");

				Bukkit.broadcastMessage(Main.nomdujeu + player.getName() + " a perdu le mini jeu.");

			}

			return true;
		}
	}

	public static int NombreParticipents() {

		int nombre = listparticipents.size();

		return nombre;

	}

	public static ArrayList<Player> GetParticipent() {

		return listparticipents;
	}

}
