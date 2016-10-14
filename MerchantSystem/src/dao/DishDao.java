package dao;

import java.util.List;

import po.Dish;

public interface DishDao {
	public Dish loadDish(long dishUuid);
	public boolean updateDish(Dish dish);
	public boolean deleteDish(long dishUuid);
	public List<Dish> findAllDishes(long merchantUuid);

	
}
