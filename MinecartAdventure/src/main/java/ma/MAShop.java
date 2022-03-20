package ma;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MAShop {
	public MAShop(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "ショップ");
		for(ItemStack item:MAData.getShopItems()) {
			inv.addItem(item);
		}
		player.openInventory(inv);
	}

}
