package binaryOneToOne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		String str = "2017-05-15";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(str, formatter);
		
		Employee emp = new Employee ("Serg", "Sokolov");
		IdCard card = new IdCard (123,date1,emp);
		
		System.out.println(card);
//		System.out.println("Check employee delete from card");
//		card.removeEmployee();
//		System.out.println(card.getEmployee());
//		System.out.println(emp.getIdCard());
//		System.out.println("Check card delete from employee");
//		emp.removeIdCard();
//		System.out.println(card.getEmployee());
//		System.out.println(emp.getIdCard());
		
//		card.setEmployee(null);
//		System.out.println();
		
		
		
		///dsfsdfsd
		
		
		


		
	}

}
