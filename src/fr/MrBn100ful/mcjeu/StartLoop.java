package fr.MrBn100ful.mcjeu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class StartLoop  {

	public static boolean gamestarted = false;

	boolean finalcountdown = false;

	public void RunGameLoop() {

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (!gamestarted) {

					int NombreParticipents = PlayersManager.NombreParticipents();

					if (NombreParticipents >= 10) {

						gamestart();

					} else if (NombreParticipents >= 2) {

						if (finalcountdown == false) {

							Bukkit.broadcastMessage(Main.nomdujeu + "D�but de la partie dans 30s");

							finalcountdown();

						}

					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}

				}

				Thread.currentThread().interrupt();
			}
		}).start();
	}

	public void finalcountdown() {

		new Thread(new Runnable() {

			@Override
			public void run() {

				finalcountdown = true;

				int i = 0;

				while (i <= 30) {

					int NombreParticipents = PlayersManager.NombreParticipents();

					if (NombreParticipents >= 10) {
						gamestart();
					}

					if (i == 30) {
						if (NombreParticipents >= 2) {
							gamestart();
						} else if (NombreParticipents < 2) {

							Bukkit.broadcastMessage(Main.nomdujeu + "Pas assez de joueur pour lancer le jeu");
						}
					}

					i++;

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}

				}

				finalcountdown = false;

				Thread.currentThread().interrupt();

			}

		}).start();

	}

	public void gamestart() {

		gamestarted = true;

		Bukkit.broadcastMessage(Main.nomdujeu + "D�but de la partie");

		ArrayList<Player> Participent = PlayersManager.GetParticipent();

		Participent.forEach((player) -> GameManager.SetPlayerConfig(player));
		
		EndLoop classeend = new EndLoop();

		classeend.EndGameLoop();

	}

}
