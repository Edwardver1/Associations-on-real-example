package binaryManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Pizza {
	
	private String name ;
    private String size;
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
    
    public Pizza (String name, String size, Ingredient ingredient){
    	this.name = name;
    	this.size = size;
    	addIngredient(ingredient);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null){
			this.name = name;
		}else{
			throw new IllegalArgumentException("Pizza's name can't be null");
		}
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		if(size != null){
			this.size = size;
		}else{
			throw new IllegalArgumentException("Pizza's name can't be null");
		}
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void addIngredient(Ingredient ingr) {
		if(ingr == null){
			throw new IllegalArgumentException("Ingredient can't be null");
		}else{
			if(!ingredients.contains(ingr)){
				ingredients.add(ingr);
				ingr.addPizza(this);
			}	
		 }
		
	}
	
	public void removeIngredient(Ingredient ingr){
		if (ingr == null){
			throw new IllegalArgumentException("Ingredient can't be null");
		}else{
			if(ingredients.contains(ingr)){
				ingredients.remove(ingr);
				ingr.removePizza(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", size=" + size + ", ingredients=" + getIngredients() + "]";
	}
	
    
}
