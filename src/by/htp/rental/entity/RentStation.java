package by.htp.rental.entity;

import java.util.Arrays;
import by.htp.rental.interf.IRentStation;

public class RentStation implements IRentStation{

	public Equipment[] equipments = new Equipment[5];
	private int[] spareEquipments = new int[5];
	private int[] engagedEquipments = new int[5];

	public void addEquipment(Equipment equipment) {
		equipments = addEquipmentRecord(equipments, equipment);
		spareEquipments = addSpareRecord(spareEquipments, equipment.getId());
	}
	
	public Equipment[] addEquipmentRecord(Equipment[] equipments, Equipment equipment) {
		int emptyIndex = -1;
		System.out.println(emptyIndex = getEmptyEquipmentIndex(equipments));
		while ( (emptyIndex = getEmptyEquipmentIndex(equipments)) == -1 ) {
			Equipment[] serv = new Equipment[equipments.length + 5];
			for (int i = 0; i < equipments.length; i++){
				serv[i] = equipments[i];
			}
			equipments = serv;
		}
		equipments[emptyIndex] = equipment;
		
		return equipments;
	}
	
	private int getEmptyEquipmentIndex(Equipment[] equipments) {
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
		return "RentStation [equipments=" + Arrays.toString(getEquipments()) + "]";
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
	
	public int[] addSpareRecord(int[] equipments, int id) {
		equipments = addSpareOrEngagedRecord(equipments, id);
		
		return equipments;
	}
	
	public int[] addEngagedRecord(int[] equipments, int id) {
		/*System.out.println("engaged!");
		for ( int i = 0; i < equipments.length; i++ ) {
			System.out.println(equipments[i]);
		}*/
		equipments = addSpareOrEngagedRecord(equipments, id);
		return equipments;
	}
	
	private int[] addSpareOrEngagedRecord(int[] equipments, int id) {
		int emptyIndex = -1;
		while ( (emptyIndex = getEmptyArrayIndex(equipments)) == -1 ) {
			int[]  serv = new int[equipments.length + 5];
			for (int i = 0; i < equipments.length; i++){
				serv[i] = equipments[i];
			}
			equipments = serv;
		}
		equipments[emptyIndex] = id;

		return equipments;
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
	
	public int[] deleteSpareRecord(int[] equipments, int id) {
		equipments = deleteSpareOrEngagedRecord(equipments, id);
		
		return equipments;
	}
	
	public int[] deleteEngagedRecord(int[] equipments, int id) {
		equipments = deleteSpareOrEngagedRecord(equipments, id);
		
		return equipments;
	}
	
	private int[] deleteSpareOrEngagedRecord(int[] equipments, int id) {
		int listLength = equipments.length;
		
		for ( int i = 0; i < listLength; i++ ) {
			if ( equipments[i] == id) {
				int equipmentsServ[] = new int[equipments.length - 1];
				System.arraycopy(equipments, 0, equipmentsServ, 0, i);
				System.arraycopy(equipments, i+1, equipmentsServ, i, listLength - i - 1);
				listLength--;
				equipments = equipmentsServ;
				i--;
			}
		}
		
		return equipments;
	}

	public void setSpareEquipments(int[] spareEquipments) {
		this.spareEquipments = spareEquipments;
	}

	public void setEngagedEquipments(int[] engagedEquipments) {
		this.engagedEquipments = engagedEquipments;
	}
	
	///// find equipment by param
	public Equipment[] findEquipmentByParams(double price) {
		Equipment[] eq = new Equipment[5];
		for ( int i = 0; i < getEquipmentsArraySize(); i++ ) {
			if ( equipments[i].getPrice() < price && !Arrays.asList(getSpareEquipments()).contains(equipments[i].getId()) ) {
				eq = addEquipmentRecord(eq, equipments[i]);
			}
		}
		int emptyIndex = getEmptyEquipmentIndex(eq);
		Equipment[] res = new Equipment[emptyIndex];
		for ( int i = 0; i < emptyIndex ; i++ ) {
			res[i] = eq[i];
		}
			
		return res;
	}
	

}
