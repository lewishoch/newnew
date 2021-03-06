package service.impl;

import java.util.List;

import dao.DishDao;
import dao.impl.DishDaoImpl;
import po.Dish;
import service.DishManager;

public class DishManagerImpl implements DishManager {
	private DishDao dao = new DishDaoImpl();
	
	public Dish loadDish(long dishUuid) {
		return dao.loadDish(dishUuid);
	}
	
	public Dish loadDish(String dishName, long merchantId) {
		return dao.loadDish(dishName, merchantId);
	}

	public boolean addDish(Dish dish) {
		return dao.addDish(dish);
	}

	public boolean updateDish(Dish dish) {
		return dao.updateDish(dish);
	}

	public boolean deleteDish(long dishUuid) {
		return dao.deleteDish(dishUuid);
	}

	public List<Dish> findAllDishes() {
		return dao.findAllDishes();
	}
	
	public List<Dish> findDishesByMerchantUuid(long merchantUuid) {
		return dao.findDishesByMerchantUuid(merchantUuid);
	}

}
