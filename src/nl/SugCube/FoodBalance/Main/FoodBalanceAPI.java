package nl.SugCube.FoodBalance.Main;


import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class FoodBalanceAPI {

	public static FoodBalance p;
	private static int value;
	
	public FoodBalanceAPI(FoodBalance i) {
		p = i;
	}
	
	public static void reset(Player player) {
		value = 0;
		p.proteins.remove(player);
		p.proteins.put(player, value);
		p.vitamins.remove(player);
		p.vitamins.put(player, value);
		p.carbohydrates.remove(player);
		p.carbohydrates.put(player, value);
		p.hydration.remove(player);
		p.hydration.put(player, Const.HYDRATION_START);
	}
	
	public static void addHydration(Player player, int amount) {
		value = p.hydration.get(player);
		p.hydration.remove(player);
		if (value < 120) {
			player.removePotionEffect(PotionEffectType.SLOW);
			player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		}
		value += 400;
		if (value >= Const.HYDRATION_START) {
			value = Const.HYDRATION_START;
		}
		p.hydration.put(player, value);
	}
	
	public static void addCarbohydrates(Player player, int amount) {
		value = p.carbohydrates.get(player);
		value += amount;
		p.carbohydrates.remove(player);
		p.carbohydrates.put(player, value);
	}
	
	public static void addProteins(Player player, int amount) {
		value = p.proteins.get(player);
		value += amount;
		p.proteins.remove(player);
		p.proteins.put(player, value);
	}
	
	public static void addVitamins(Player player, int amount) {
		value = p.vitamins.get(player);
		value += amount;
		p.vitamins.remove(player);
		p.vitamins.put(player, value);
	}
	
}
