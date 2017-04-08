package exceptManyOne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private double power; //optional attribute
	private FuelType fuel_type; // required attribute,multi-value
	private List<FuelType> fuel_type_list = new ArrayList<>();
    private Double engine_displacement; //required attribute
	
	public Engine(double power, List<FuelType> fuel_type_list, Double engine_displacement ){
		this.power = power;
		this.fuel_type_list = fuel_type_list;
		this.engine_displacement = engine_displacement;
	}

	public double getPower() {
		return this.power;
	}
	

	public void setPower(int power) {
		this.power = power;
	}
	//method overloading
	public void setPower(double power) {
		int hp = (int) ( power * 1.3596); // converting kw to horsepower
		this.power = hp;
	}
	
	public void addFuelType(FuelType fuel){
		if (fuel_type_list.size() > 2 ){
			throw new IllegalArgumentException("Car can't contain more than 2 fuels");
		}else if (fuel_type_list.contains(fuel)){
			throw new IllegalArgumentException("fuel already exist");
		}else 
		fuel_type_list.add(fuel);
		
	}
	
	public void setFuel_type_list(List<FuelType> fuel_type_list) {
		if (fuel_type_list == null){
			throw new IllegalArgumentException("Fuel can't be null");
			
		}
		this.fuel_type_list = fuel_type_list;
	}

	public void deleteFuelType(FuelType fuel){
		
		fuel_type_list.remove(fuel);
		
	}
	
	public List<FuelType> getFuel_type_list() {
		return fuel_type_list;
	}
	


//	public FuelType getFuel_type() {
//		return fuel_type;
//	}
//
//	public void setFuel_type(FuelType fuel_type) {
//		if(fuel_type == null ){
//			throw new IllegalArgumentException("Fuel type must be provided");
//		}
//		this.fuel_type = fuel_type;
//	}



	public double getEngine_displacement() {
		return engine_displacement;
	}

	public void setEngine_displacement(Double engine_displacement) {
		if(engine_displacement == null){
			throw new IllegalArgumentException("Engine displacement can't be null");
		}
		this.engine_displacement = engine_displacement;
	}
	
	// method overriding
		public String toString(){
			String join = new String();
			join += "\nPower: ";
			if(power != 0){
				if (power == (int) power){
					join += (int) power + " hp";//optional
				}else
					join += power + " kw";
			}else
				join += "no data";
			
			join += "\nFuel type: " + getFuel_type_list() +
					"\nEngine displacement: " + getEngine_displacement();
				
			return join;
		}

	

}
