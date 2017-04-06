package by.htp.rental.entity;

import java.util.Date;

public class Order {
	
	private Person person;
	private int equipmentId;
	private Date rentDate;
	private int rentPeriod;

	public Order() {
		
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public void createOrder(Person person, Equipment equipment, int rentPeriod) {
		this.person = person;
		this.equipmentId = equipment.getId();
		this.rentDate = new Date();
		this.rentPeriod = rentPeriod;
	}
	
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	
	public int getRentPeriod() {
		return rentPeriod;
	}

	public void setRentPeriod(int rentPeriod) {
		this.rentPeriod = rentPeriod;
	}

}
