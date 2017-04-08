package binaryAddtition;

import java.time.LocalDate;

public class IdCard {

	private Integer number;
	private LocalDate dateExpire;
	private Employee employee;
	
	public IdCard(Integer number, LocalDate dateExpire){
		this.number = number;
		this.dateExpire = dateExpire;
		
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		if(number == null ){
			throw new IllegalArgumentException("Idcard number can't be null");
		}else{
			this.number = number;
		}
	
	}

	public LocalDate getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(LocalDate dateExpire) {
		if (dateExpire == null){
			throw new IllegalArgumentException("Expire date can't be null");
		}else{
			this.dateExpire = dateExpire;
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		if(employee != null){
			if(this.employee != employee){
				this.employee = employee;
				this.employee.setIdCard(this);;
			}
		}
	}
	
	public void removeEmployee(){
		this.employee = null;
	}
	
	public void removeEmployee(Employee emp){
		this.employee = null;
		emp.removeIdCard();
	}
	
	
	
}
