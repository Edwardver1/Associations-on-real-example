package binaryManyToMany;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ingredient bacon = new Ingredient ("bacon");
		Ingredient cheese = new Ingredient ("cheese");
		Ingredient pepperoni = new Ingredient ("pepperoni");
		
		Pizza piz1 = new Pizza("pizza1","small",bacon);
		
		System.out.println(piz1);
		System.out.println("Check addIngredient from pizza");
		piz1.addIngredient(cheese);
		System.out.println(piz1);
		System.out.println(cheese.getPizzaList());
		System.out.println("Check removeIngredient from pizza");
		piz1.removeIngredient(cheese);
		System.out.println(piz1);
		System.out.println(cheese.getPizzaList());
	}

}
