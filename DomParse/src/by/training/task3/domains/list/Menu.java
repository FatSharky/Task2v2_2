package by.training.task3.domains.list;

import java.util.ArrayList;
import java.util.List;

import by.training.task3.domains.Food;

public class Menu {
	private List<Food> food;

	public Menu() {
		food = new ArrayList<>();
	}

	public void addFood(Food food) {
		this.food.add(food);
	}

	public Menu(List<Food> food) {
		this.food = food;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}
}
