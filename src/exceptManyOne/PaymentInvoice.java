package exceptManyOne;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentInvoice {
	
	private String issueNo;
	private LocalDate paymentDate;
	private Integer paymentAmount;	
	private Map<String,Booking> bookings = new  HashMap<String,Booking>();// map for qualified association
	
	public PaymentInvoice (String issueNo, Integer paymentAmount){
		this.issueNo = issueNo;
		this.paymentDate = LocalDate.now();
		this.paymentAmount = paymentAmount;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		if(issueNo == null){
			throw new IllegalArgumentException("IssueNo can't be null");
		}else{
			this.issueNo = issueNo;
		}
		
	}

	@Override
	public String toString() {
		return "PaymentInvoice [issueNo=" + issueNo + ", paymentDate=" + paymentDate + ", paymentAmount="
				+ paymentAmount + ", bookings=" + bookings + "]";
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		if(paymentAmount == null){
			throw new IllegalArgumentException("Payment Amount can't be null");
		}else{
			this.paymentAmount = paymentAmount;
		}
	}
	
	/*** Qualified association ***/
	
	public Booking getBooking(String bookingId) throws Exception {
		if(!bookings.containsKey(bookingId)){
			throw new Exception("There is NO such BookingID");
		}
		return bookings.get(bookingId);
		
	}

	public void addBooking(Booking booking) {
		if( booking== null ){
			throw new IllegalArgumentException("Booking null is given");
		}else{
			if(!bookings.containsKey(booking.getBookingId())){
				bookings.put(booking.getBookingId(), booking);
				booking.setPaymentInvoice(this); // return information
			}
		}
	}
	
	public void removeBooking(Booking booking) {
		if( booking == null ){
			throw new IllegalArgumentException("Booking null is given");
		}else{
			if(bookings.containsKey(booking.getBookingId())){
				bookings.remove(booking.getBookingId());
				booking.removePaymentInvoice();
				
			}
		}
	}
	
	

}
