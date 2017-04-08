package binaryOneToOne;

import java.time.LocalDate;

public class IdCard {

	private Integer number;
	private LocalDate dateExpire;
	private Employee employee;
	
	public IdCard(Integer number, LocalDate dateExpire, Employee employee){
		this.number = number;
		this.dateExpire = dateExpire;
		setEmployee(employee);
		
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
		}else{
			throw new IllegalArgumentException("Employee can't be null");
		}
	}

	public void removeEmployee(){
		this.employee.setIdCard(null);
		this.employee = null;
		
	}
	
	public void setEmployeeNull(){ // needed for removeIdCard() method , as you can't create IdCard with null emp
		this.employee = null;
	}
	
	@Override
	public String toString() {
		return "IdCard [number=" + number + ", dateExpire=" + dateExpire + ", employee=" + employee + "]";
	}
	
}
