package exceptManyOne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    
	    String str = "2015-03-15";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTime = LocalDate.parse(str, formatter);
		List <FuelType> fuels = new ArrayList<FuelType>();
		Engine engine1 = new Engine(100, fuels, 1.6);
		Engine engine2 = new Engine(151, fuels, 2.0);
		
		Owner mike = new Owner("Mike", null);
		Owner kris = new Owner("Kris", null);
		
		Car car1 = new Car("BMW", "5" , dateTime, "black", engine1,mike);
	    car1.addFeature("ABS");
	    car1.addFeature("Bluetooth");
//	    Booking booking1 = new Booking ("1","Chopin Airport","Modlin airport");
//	    BookingCar bookingCar = new BookingCar(dateTime,dateTime,car1,booking1);
		Car car2 = new Car("Mercedes", "e220" , dateTime, "black", engine2,mike);
		
		/*** Binary association  ***/
		
//        System.out.println(mike);
//        mike.removeCar(car1); // checking for reference to be deleted
//        System.out.println("fdfd");
//        System.out.println(mike);
//        System.out.println(car1.getOwner());
//        System.out.println(car1.getFeatures()); // check if features deleted
//        System.out.println(car1.getBooking_car());//check if bookingCar deleted
//        System.out.println(bookingCar.getBooking());//check if booking Deleted
		
//        System.out.println(booking1.getBooking_car());
//        booking1.removeBooking_car(bookingCar); // check if bookingCar and car deleted on booking side
//        System.out.println(booking1.getBooking_car());
//        System.out.println(bookingCar.getCar());
		
//        kris.addCar(car2); // try to add exists car to another owner
//        System.out.println(mike);
//        System.out.println(kris);

		
		
        Booking booking1 = new Booking ("1","Chopin Airport","Modlin airport");	
	    BookingCar bookingCar = new BookingCar(dateTime,dateTime,car1,booking1);
  
	    System.out.println(bookingCar);
//	    bookingCar.removeReferences();
//	    bookingCar.setCar(car1);
	    car1.removeBooking_car(bookingCar);
	    System.out.println("Check from booking");
	    System.out.println(booking1.getBooking_car());
	    System.out.println("Check from car");
	    System.out.println(car1.getBooking_car());
	    System.out.println("Check from BookingCar");
	    System.out.println(bookingCar.getBooking());
	    System.out.println(bookingCar.getCar());
//	    bookingCar.setCar(car2);// check if changes
//	    System.out.println(car1.getBooking_car());
//	    car1.removeBooking_car(bookingCar);
//	    System.out.println("heelo");
//	    System.out.println(car1.getBooking_car());
//	    System.out.println(bookingCar.getCar());
	    
//	    PaymentInvoice invoice = new PaymentInvoice ("12", 230);
//	    System.out.println(invoice);
//	    invoice.addBooking(booking1); // check if add works
//	    System.out.println(invoice);
//	    System.out.println(invoice.getBooking("1"));//check if get works
//	    invoice.removeBooking(booking1);
//	    System.out.println(invoice);
//	    System.out.println(invoice.getBooking("1"));
	    
//	    car1.addFeature("ABS");
//	    car1.addFeature("Bluetooth");
//	    System.out.println(car1.getFeatures());
//	    car1.removeFeature("ABS");
//	    System.out.println(car1.getFeatures());
	    
  
	}

}
