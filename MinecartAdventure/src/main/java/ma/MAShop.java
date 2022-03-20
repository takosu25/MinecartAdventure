package ma;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class MAShop implements Listener{
	Plugin plugin;
	Player player;
	MAGame mag;
	public MAShop(Player player, Plugin plugin, MAGame mag) {
		Inventory inv = Bukkit.createInventory(null, 54, "ショップ");
		for(ItemStack item:MAData.getShopItems()) {
			inv.addItem(item);
		}
		player.openInventory(inv);
		this.plugin = plugin;
		this.player = player;
		this.mag = mag;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	public void onLeftClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == player) {
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getType() != Material.AIR) {
					if(e.getRawSlot() < 54) {
						int index = e.getRawSlot();
						int price = MAData.getPrice(index);
						if(mag.getPlayerData(player).getCoin() >= price) {
							player.getInventory().addItem(e.getCurrentItem().clone());
							mag.getPlayerData(player).addCoin(-price);
						}
					}
				}
			}
		}
	}

}
