package by.htp.rental.entity;

import java.util.Date;

public class Order {

	private Person person;
	private Equipment equipment;
	private Date rentDate;
	private int rentPeriod;

	public Order(Person person, Equipment equipment, int rentPeriod) {
		this.person = person;
		this.equipment = equipment;
		
		this.rentDate = new Date();
		this.rentPeriod = rentPeriod;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
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
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
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
}
