package by.htp.rental.entity;

import java.util.Arrays;

import by.htp.rental.interf.IRentStation;

public class RentStation implements IRentStation{

	public Equipment[] equipments = new Equipment[5];
	public Equipment[] spareEquipments = new Equipment[5];
	public Equipment[] engagedEquipments = new Equipment[5];
	
	public void addEquipment(Equipment equipment) {
		equipments = addEquipmentRecord(equipments, equipment);
		spareEquipments = addEquipmentRecord(spareEquipments, equipment);
	}
	
	public Equipment[] addEquipmentRecord(Equipment[] equipments, Equipment equipment) {
		int emptyIndex = -1;
		while ( (emptyIndex = getEmptyEquipmentIndex()) == -1 ) {
			Equipment[] serv = new Equipment[equipments.length + 5];
			for (int i = 0; i < equipments.length; i++){
				serv[i] = equipments[i];
			}
			equipments = serv;
		}
		equipments[emptyIndex] = equipment;
		
		return equipments;
	}
	
	private int getEmptyEquipmentIndex() {
		for ( int i = 0; i < equipments.length; i++ ) {
			if ( equipments[i] == null ) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int getEquipmentsArraySize() {
		for ( int i = 0; i < equipments.length; i++ ) {
			if ( equipments[i] == null) {
				return i;
			} else if ( i == equipments.length - 1 ) { // if the last element is full
				return i + 1;
			}
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "RentStation [equipments=" + Arrays.toString(equipments) + "]";
	}
	
	public Equipment[] getSpareEquipments() {
		return spareEquipments;
	}
	
	public Equipment[] getEngagedEquipments() {
		return engagedEquipments;
	}
	
	public Equipment[] getEquipments() {
		Equipment[] eq = new Equipment[getEquipmentsArraySize()];
		for ( int i = 0; i < equipments.length; i++ ) {
			eq[i] = equipments[i];
		}
		
		return eq;
	}

}
