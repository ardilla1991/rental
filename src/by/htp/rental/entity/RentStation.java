package by.htp.rental.entity;

import java.util.Arrays;

import by.htp.rental.interf.IRentStation;

public class RentStation implements IRentStation{

	public Equipment[] equipments = new Equipment[5];
	public int[] spareEquipments = new int[5];
	public int[] engagedEquipments = new int[5];
	
	public void addEquipment(Equipment equipment) {
		equipments = addEquipmentRecord(equipments, equipment);
		spareEquipments = addSpareRecord(spareEquipments, equipment.getId());
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
	
	public int[] getSpareEquipments() {
		int[] eq = new int[getArraySize(spareEquipments)];
		for ( int i = 0; i < getArraySize(spareEquipments); i++ ) {
			eq[i] = spareEquipments[i];
		}
		
		return eq;
	}
	
	public int[] getEngagedEquipments() {
		int[] eq = new int[getArraySize(engagedEquipments)];
		for ( int i = 0; i < getArraySize(engagedEquipments); i++ ) {
			eq[i] = engagedEquipments[i];
		}
		
		return eq;
	}
	
	public Equipment[] getEquipments() {
		Equipment[] eq = new Equipment[getEquipmentsArraySize()];
		for ( int i = 0; i < getEquipmentsArraySize(); i++ ) {
			eq[i] = equipments[i];
		}
		
		return eq;
	}
	
	public int[] addSpareRecord(int[] spareEquipments, int id) {
		int emptyIndex = -1;
		while ( (emptyIndex = getEmptyArrayIndex(spareEquipments)) == -1 ) {
			int[] serv = new int[spareEquipments.length + 5];
			for (int i = 0; i < spareEquipments.length; i++){
				serv[i] = spareEquipments[i];
			}
			spareEquipments = serv;
		}
		spareEquipments[emptyIndex] = id;
		
		return spareEquipments;
	}
	
	private int getEmptyArrayIndex(int[] arrayEq) {
		for ( int i = 0; i < arrayEq.length; i++ ) {
			if ( arrayEq[i] == 0 ) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int getArraySize(int[] arr) {
		for ( int i = 0; i < arr.length; i++ ) {
			if ( arr[i] == 0) {
				return i;
			} else if ( i == arr.length - 1 ) { // if the last element is full
				return i + 1;
			}
		}
		
		return 0;
	}

}
