package service;

import java.util.List;

import po.Dish;

public interface DishManager {
	public Dish loadDish(long dishUuid);
	public boolean addDish(Dish dish);
	public boolean updateDish(Dish dish);
	public boolean deleteDish(long dishUuid);
	public List<Dish> findAllDishes();
	public List<Dish> findDishesByMerchantUuid(long merchantUuid);
}
