package exceptManyOne;

import java.time.LocalDate;

//Association class
public class BookingCar {
	// add method to delete all reference at once 
	private LocalDate start_date;
	private LocalDate end_date;
	private Car car;
	private Booking booking;
	
	public BookingCar(LocalDate start_date, LocalDate end_date, Car car, Booking booking){
		
		this.start_date = start_date;
		this.end_date = end_date;
		setCar(car);
		setBooking(booking);
		
	}

	

	public LocalDate getStart_date() {
		return start_date;
	}



	public void setStart_date(LocalDate start_date) {
		if(start_date == null){
			throw new IllegalArgumentException("Start date can't be null");
		}else{
			this.start_date = start_date;
		}
	}



	public LocalDate getEnd_date() {
		return end_date;
	}



	public void setEnd_date(LocalDate end_date) {
		if(end_date == null){
			throw new IllegalArgumentException("End date can't be null");
		}else{
			this.end_date = end_date;
		}
	}



	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		if (car == null){
			throw new IllegalArgumentException("Car can't be null");
		}else{
			if(this.car != car){
				this.car = car;
				this.car.addBooking_car(this); //return information
			}
		
		}
	}
	

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		if(booking == null){
			throw new IllegalArgumentException("Booking can't be null");
		}else{
			if(this.booking != booking){
				this.booking = booking;
				this.booking.addBooking_car(this);//return information
			}
			
		}
	
	}
	
	public void removeBooking(){
//		this.booking.removeBooking_car(this);
		this.booking = null;
	}
	
	public void removeCar(){
//		if(this.car != null){
//			this.car.removeBooking_car(this);
//		}

		this.car=null;
	}

	public void removeReferences(){
        this.booking.removeBooking_car(this);
        this.car.removeBooking_car(this);
	}


	@Override
	public String toString() {
		return "BookingCar [start_date=" + start_date + ", end_date=" + end_date + ", car=" + getCar() + ", booking="
				+ getBooking() + "]";
	}
	
	

}
