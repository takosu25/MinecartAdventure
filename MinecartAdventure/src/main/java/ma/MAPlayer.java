package ma;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;



public class MAPlayer implements Listener{
	Player player;
	private int coin = 10;
	Plugin plugin;
	MAGame mag;
	public MAPlayer(Player player, Plugin plugin, MAGame mag) {
		this.player = player;
		this.plugin = plugin;
		this.mag = mag;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		earnMoney();
		displayCoin();
		player.setHealth(20);
		player.setFoodLevel(20);
		player.getInventory().clear();
		ItemStack shop = new ItemStack(Material.EMERALD);
		ItemMeta mshop = shop.getItemMeta();
		mshop.setDisplayName("ショップ");
		shop.setItemMeta(mshop);
		player.getInventory().addItem(shop);
	}
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		if(e.getPlayer() == player) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(player.getInventory().getItemInMainHand().getType() == Material.EMERALD) {
					new MAShop(player, plugin, mag);
				}
			}
		}
	}
	
	
	
	
	
	private void earnMoney() {
		new BukkitRunnable() {
			public void run() {
				addCoin(1);
			}
		}.runTaskTimer(plugin, 0, 20);
	}
	private void displayCoin() {
		new BukkitRunnable() {
			public void run() {
				BaseComponent[] component = TextComponent.fromLegacyText("所持コイン：" + coin);
				player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
			}
		}.runTaskTimer(plugin, 0, 5);
	}
	
	//getter&setter
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public void addCoin(int add) {
		coin = coin + add;
	}

}
