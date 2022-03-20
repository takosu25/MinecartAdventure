package ma;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MAData {
	//0アイテムの見た目,1値段,2個数,3名前
	public static Object[][] shopItem = {
			{Material.RAIL, 5, 1},
			{Material.POWERED_RAIL, 20, 1}
			
	};
	public static List<ItemStack> getShopItems(){
		List<ItemStack> result = new ArrayList<ItemStack>();
		for(int i = 0; i < shopItem.length; i++) {
			ItemStack item = new ItemStack((Material)shopItem[i][0]);
			ItemMeta mitem = item.getItemMeta();
			List<String> lore = new ArrayList<String>();
			lore.add("値段" + (int)shopItem[i][1]);
			mitem.setLore(lore);
			item.setItemMeta(mitem);
			result.add(item);
		}
		return result;
	}
	public static int getPrice(int index) {
		return (int)shopItem[index][1];
	}

}
