package ma;


import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;



public class MAPlayer {
	Player player;
	private int coin = 10;
	Plugin plugin;
	public MAPlayer(Player player, Plugin plugin) {
		this.player = player;
		this.plugin = plugin;
		earnMoney();
		displayCoin();
		
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
