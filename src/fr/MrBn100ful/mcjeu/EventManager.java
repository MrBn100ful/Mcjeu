package fr.MrBn100ful.mcjeu;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventManager implements Listener{
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		
		if (!StartLoop.gamestarted) {
			
			PlayersManager.RemoveParticipent(event.getPlayer(), false, 1);
		
		}else {
			
			ArrayList<Player> liste = PlayersManager.GetParticipent();
			
			if (liste.contains(event.getPlayer()))  {
			
				GameManager.RemovePlayerConfig(event.getPlayer());
				
			}

			PlayersManager.RemoveParticipent(event.getPlayer(), false, 2);
			
		}
		

	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		if (StartLoop.gamestarted) {
					
			ArrayList<Player> liste = PlayersManager.GetParticipent();
			
			if (liste.contains(event.getEntity().getPlayer()))  {
			
				GameManager.RemovePlayerConfig(event.getEntity().getPlayer());
				
			}
			
			PlayersManager.RemoveParticipent(event.getEntity().getPlayer(), false, 2);
	
		}
		
	}

}
