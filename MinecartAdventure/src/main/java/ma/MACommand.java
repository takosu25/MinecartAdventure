package ma;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MACommand implements CommandExecutor {

	Plugin plugin;
	MAGame mag;
	
	public MACommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(args[0].equals("newgame")) {
			mag = new MAGame(plugin);
		}else if(args[0].equals("join")) {
			if(sender instanceof Player) {
				mag.addPlayers((Player)sender);
			}
		}else if(args[0].equals("start")) {
			mag.start();
		}
		return true;
	}

}
