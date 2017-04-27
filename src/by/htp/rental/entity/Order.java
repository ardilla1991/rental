package by.htp.rental.entity;

import java.util.Date;

public class Order {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + equipmentId;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((rentDate == null) ? 0 : rentDate.hashCode());
		result = prime * result + rentPeriod;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (equipmentId != other.equipmentId)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (rentDate == null) {
			if (other.rentDate != null)
				return false;
		} else if (!rentDate.equals(other.rentDate))
			return false;
		if (rentPeriod != other.rentPeriod)
			return false;
		return true;
	}

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
