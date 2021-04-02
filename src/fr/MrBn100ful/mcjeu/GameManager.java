package fr.MrBn100ful.mcjeu;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GameManager {
	@SuppressWarnings("deprecation")
	public static void SetPlayerConfig(Player player) {

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);

		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);

		player.getInventory().clear();

		player.getInventory().addItem(sword);

		player.setMaxHealth(40.0);

		player.setHealth(40.0);

		player.setGlowing(true);

	}
	
	@SuppressWarnings("deprecation")
	public static void RemovePlayerConfig(Player player) {
		
		player.getInventory().clear();

		player.setMaxHealth(20.0);

		player.setGlowing(false);
	}
}
