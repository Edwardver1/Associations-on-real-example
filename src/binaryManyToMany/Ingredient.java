package binaryManyToMany;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
	
	private String name;
    
	private List<Pizza> pizzaList = new ArrayList<Pizza>();

	public Ingredient (String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null){
			this.name = name;
		}else{
			throw new IllegalArgumentException("Ingredient's name can't be null");
		}
	}

	public List<Pizza> getPizzaList() {
		return pizzaList;
	}

	public void addPizza(Pizza pizza) {
		if(pizza == null){
			throw new IllegalArgumentException("Pizza can't be null");
		}else{
			if(!pizzaList.contains(pizza)){
				pizzaList.add(pizza);
				pizza.addIngredient(this);
			}else{
				throw new IllegalArgumentException("Pizza already added");
			}	
		}
	}
	
	public void removePizza (Pizza pizza){
		if(pizza == null){
			throw new IllegalArgumentException("Pizza can't be null ");
		}else{
			if(pizzaList.contains(pizza)){
				pizzaList.remove(pizza);
				pizza.removeIngredient(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + "]";
	}

}
