package fr.MrBn100ful.mcjeu;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;

	static String nomdujeu = "[Jeu] ";

	FileConfiguration config = getConfig();

	public void onDisable() {

		getLogger().info("shutting down");

	}

	public void onEnable() {

		config.addDefault("NomDeJeu", "[Jeu] ");

		config.options().copyDefaults(true);

		saveConfig();

		getLogger().info("configs manager loaded");

		this.getCommand("join").setExecutor(new CommandsManagers());

		this.getCommand("quit").setExecutor(new CommandsManagers());

		getLogger().info("commands loaded");

		StartLoop classegame = new StartLoop();

		classegame.RunGameLoop();

		getLogger().info("loop running");

		getServer().getPluginManager().registerEvents(new EventManager(), this);

		getLogger().info("event manger started");

		getLogger().info(nomdujeu + "started");

	}

}
