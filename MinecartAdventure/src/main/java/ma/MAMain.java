package ma;

import org.bukkit.plugin.java.JavaPlugin;

public class MAMain extends JavaPlugin{

	@Override
	public void onEnable() {
		super.onEnable();
		getCommand("ma").setExecutor(new MACommand(this));
	}
}
