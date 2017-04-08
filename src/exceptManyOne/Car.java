package exceptManyOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;






public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static File file = new File("./data.txt");
	
	private static List<Car> extent = new ArrayList<>(); // list for class extent 
	private String make; // required attributes
	private String model; // required attributes
	private LocalDate constraction_year; // complex attribute
	private String color;  // required attributes
	private static int cars_number = 0; // class  attribute 
	private Engine engine; // complex attribute
//	private int car_age; // Implement.derived attribute 
	
    private Owner owner; // binary association , card. 1
	private Set<BookingCar> booking_cars = new HashSet<BookingCar>();// association class set
    private Set<Feature> features = new HashSet<Car.Feature>();
	
	public Car (String make, String model, LocalDate constraction_year,String color,Engine engine,Owner owner){		
		this.make = make;
		this.model = model;
		this.constraction_year = constraction_year;
		this.color = color;
		this.engine = engine;
	    setOwner(owner);
		addCar(this);// add to the list 
		cars_number ++;
	}
	
	/*** Binary association  ***/
	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		if(owner == null){
			throw new IllegalArgumentException("Owner can't be null");
		}else{
			if(this.owner != owner){
				this.owner = owner;
				owner.addCar(this);//return information
			}
			
		}
		
	}
	
	public void removeOwner(){
		this.owner = null;
	}
	
		
	
	/*** End of binary association  ***/

	/*** Association with attribute ***/
	
	public Set<BookingCar> getBooking_car() {
		return booking_cars;
	}

	public void addBooking_car(BookingCar booking_car) {
		if(booking_car == null){
			throw new IllegalArgumentException("Booking car can't be null");
		}else{
			if(!this.booking_cars.contains(booking_car)){
				this.booking_cars.add(booking_car);
				booking_car.setCar(this);
			}
		}
	}
	
	public void removeBooking_car(BookingCar booking_car) {
		if(booking_car == null){
			throw new IllegalArgumentException("Booking car can't be null");
		}else{
			if( booking_cars.contains(booking_car)){
				booking_cars.remove(booking_car);
//				booking_car.removeCar();
//				booking_car.removeBooking();
				booking_car.removeReferences();
				booking_car.removeCar();
			}
//			}else{
//				throw new IllegalArgumentException("There is no such booking car");
//			}
		}
	}
	
	public void removeAllBooking_car() {
		for (BookingCar bookingCar : booking_cars){
			booking_cars.remove(bookingCar);
//			bookingCar.removeCar();
//			bookingCar.removeBooking();
			bookingCar.removeReferences();
		}
	}
	/*** End of association with attribute ***/
	
	/*** Composition ***/
	
	public void addFeature (String name){
		Feature feature = new Feature(name);
		if(features.contains(feature)){
			throw new IllegalArgumentException("This feature already added");
		}else{
			features.add(feature);
		}
	}
	
	public void removeFeature(String name){
		if(name != null){
			Iterator<Feature> iterator = features.iterator();
			while(iterator.hasNext()){
				Feature f = iterator.next();
				if(f.getName().equals(name)){
					iterator.remove();
				}
			}	
		}else{
			throw new IllegalArgumentException("Name should not be null");
		}
	}
	
	public void removeAllFeatures(){
		features.clear();
	}
	
	public List<String> getFeatures(){
		List<String> featureList = new ArrayList<String>();
		for(Feature feature: features){
			featureList.add(feature.getName());
		}
		return featureList;
		
	}
	
	/*** End of composition ***/
	
	
	// extent methods, class methods
	private static void addCar (Car car ){ 
		if (extent.contains(car)){
			throw new IllegalArgumentException("Such car already exist");
		}else
		extent.add(car);
	}
	
//	public int getAge() {
//		return car_age;
//	}

	public String getMake() {
		return make;
	}
    
	public void setMake(String make) {
		if (make == null ){ // cause required attribute
			throw new IllegalArgumentException("Producer can't be null");
		}
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if (model == null ){
			throw new IllegalArgumentException("Model can't be null");
		}
		this.model = model;
	}

	public LocalDate getConstraction_year() {
		return constraction_year;
	}

	public void setConstraction_year(LocalDate constraction_year) {
		if (constraction_year == null ){
			throw new IllegalArgumentException("Year can't be null");
		}
		this.constraction_year = constraction_year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color == null ){
			throw new IllegalArgumentException("Color can't be null");
		}
		this.color = color;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public static int getCarsNumber(){
		return cars_number;
	}
	//class method
	public static void getCars (){
	    List<Car> cars_list = new ArrayList<>(Car.extent);
		for (int i = 0 ; i < cars_list.size(); i++ ){
			System.out.println(cars_list.get(i));
		}
		
	}
	//class persistence
	public static void writeExtent() throws FileNotFoundException, IOException {
		try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)); ) {
			oos.writeObject(extent);
		} 
	}
	
	
	@SuppressWarnings("unchecked")
	public static void readExtent() throws FileNotFoundException, IOException, ClassNotFoundException {
		try ( ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file)); ) {
//			Car.extent.clear();
			Car.extent =  (List<Car>) oos.readObject();
		} 
	}
	
	
	// method overriding
	public String toString(){
		String join = new String();
		join += "Car:\nProducer: " +getMake() + 
				"\nModel: " + getModel() +
				"\nProduction Year: " +  getConstraction_year() +
//				"\nCar Age: " +  getAge() +
				"\nColor: " +  getColor() +
				"\nTechinal Characteristics: " +  getEngine() 
			 ;
			
		return join;
	}
	// for Main class to check if readExtent method works 
	public static int getExtentSize (){
		return Car.extent.size();
	}
	
	/*** Composition class  ***/
	
	private class Feature{
		
		String name;
		
		public  Feature(String name){
			setName(name);
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			if (name == null ){
				throw new IllegalArgumentException("Feature name can't be null");
			}else{
				this.name = name;
			}
			
		}
		
		
	}
	

}
