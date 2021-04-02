package fr.MrBn100ful.mcjeu;

import org.bukkit.Bukkit;

public class EndLoop {
	
	public void EndGameLoop() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(StartLoop.gamestarted) {
					
					Bukkit.broadcastMessage("test");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					
				}
				
			}
			
		}).start();
		
	}
}
