package exceptManyOne;

import java.util.HashSet;
import java.util.Set;

public class Owner {
	
	private String owner_name;

	private String notes;
	private Set<Car> car_list = new HashSet<Car>() ;
	
	public Owner(String owner_name, String notes){
		this.owner_name = owner_name;

		this.notes = notes;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		if (owner_name == null  ){
			throw new IllegalArgumentException("Name can't be null");
		}else{
			this.owner_name = owner_name;
				
		}
	}


	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set<Car> getCar_list() {
		return car_list;
	}

	

	public void addCar(Car car) {
		if (car == null){
			throw new IllegalArgumentException("Car can't be null");
		}else {
			if(!car_list.contains(car)){
				car_list.add(car);
				car.setOwner(this);
			}else{
				throw new IllegalArgumentException("Car already added");
			}
		}
	
	}
	
	public void removeCar(Car car) {
		if (car == null){
			throw new IllegalArgumentException("Car can't be null");
		}else {
			if(car_list.contains(car)){
				car_list.remove(car);
				car.removeOwner();//return information
				car.removeAllFeatures();// remove all features of the car 
			    car.removeAllBooking_car();//remove all bookingCars
			}else{
				throw new IllegalArgumentException("There is no such car");
			}
		}
	}

	@Override
	public String toString() {
		return "Owner [owner_name=" + owner_name + ", notes=" + notes + ", car_list=" + car_list + "]";
	}
	
	

}
