package exceptManyOne;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Booking {
	
	private String bookingId;
	private String pickUpLocation;
	private String returnLocation;
	private PaymentInvoice paymentInvoice;
    
	private Set<BookingCar> booking_cars = new HashSet<BookingCar>();//Set for association class 
	
	public Booking (String bookingId, String pickUpLocation, String returnLocation){
	    this.bookingId = bookingId;
		this.pickUpLocation = pickUpLocation;
		this.returnLocation = returnLocation;
		
	}	
	
	public String getBookingId() {
		return bookingId;
	}
	
	
	public void setBookingId(String bookingId){
		if (bookingId == null){
			throw new IllegalArgumentException("BookingId can't be null");
		}else{
			this.bookingId = bookingId;
		}
		
	}

	public String getPick_up_location() {
		return pickUpLocation;
	}

	public void setPick_up_location(String pick_up_location) {
		if (pick_up_location == null){
			throw new IllegalArgumentException("Pick up location can't be null");
		}else{
			this.pickUpLocation = pick_up_location;
		}
	}

	public String getReturn_location() {
		return returnLocation;
	}

	public void setReturn_location(String return_location) {
		if (return_location == null){
			throw new IllegalArgumentException("Return location can't be null");
		}else{
			this.returnLocation = return_location;
		}
	}

	
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
				booking_car.setBooking(this);
			}
		}
	}

	public void removeBooking_car(BookingCar booking_car) {
		if(booking_car == null){
			throw new IllegalArgumentException("Booking car can't be null");
		}else{
			if( this.booking_cars.contains(booking_car)){
				this.booking_cars.remove(booking_car);
				booking_car.removeReferences();
			}
		}
	}
	
	/*** Qualified association ***/
	
	public PaymentInvoice getPaymentInvoice() {
		return paymentInvoice;
	}

	public void setPaymentInvoice(PaymentInvoice paymentInvoice) {
		if (paymentInvoice == null){
			throw new IllegalArgumentException("Payment invoice can't be null");
		}else{
			this.paymentInvoice = paymentInvoice;
			this.paymentInvoice.addBooking(this);//return information
		}
	}
	
	
	public void removePaymentInvoice(){
		this.paymentInvoice = null;
	}
    
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", pickUpLocation=" + pickUpLocation + ", returnLocation="
				+ returnLocation + "]";
	}

	
	
	

}
