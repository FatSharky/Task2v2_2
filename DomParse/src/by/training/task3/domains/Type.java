package by.training.task3.domains;

import java.util.List;

public class Type {
	private String name;
	private List<Dish> dishes;

	public Type() {
		// TODO Auto-generated constructor stub
	}

	public Type(String name) {
		this.name = name;
	}

	public Type(String name, List<Dish> dishes) {
		this.name = name;
		this.dishes = dishes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishes == null) ? 0 : dishes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (dishes == null) {
			if (other.dishes != null)
				return false;
		} else if (!dishes.equals(other.dishes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
