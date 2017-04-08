package binaryAddtition;

public class Employee {
	 
	private String name;
	private String surname;
	private IdCard idCard;
	
	public Employee (String name, String surname, IdCard idCard){
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null){
			throw new IllegalArgumentException("Employee name can't be null");
		}else{
			this.name = name;
		}
		
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(surname == null){
			throw new IllegalArgumentException("Employee surname can't be null");
		}else{
			this.surname = surname;
		}
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		if(idCard != null){
			if(this.idCard != idCard){
				this.idCard = idCard;
				this.idCard.setEmployee(this);
			}
		}
	}
	
	public void removeIdCard(){
		this.idCard = null;
	}
	
	
	

}