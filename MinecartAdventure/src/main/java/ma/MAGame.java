package ma;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class MAGame {
	private List<Player> players = new ArrayList<Player>();
	private World world;
	private Vector[] spawnStation = {new Vector(-30.5, -60, 29.5), new Vector(-105.5, -60, 32.5)};
	
	
	
	public MAGame() {
		world = Bukkit.getWorld("MAWorld");
	}
	public void start() {
		for(int i = 0; i < spawnStation.length; i++) {
			Minecart cart = (Minecart)world.spawnEntity(spawnStation[i].toLocation(world), EntityType.MINECART);
			cart.addPassenger(players.get(i));
		}
	}
	
	//getterとsetter
	public List<Player> getPlayers() {
		return players;
	}
	public void addPlayers(Player player) {
		players.add(player);
	}

}
