package by.htp.rental.logic;

import java.util.HashMap;

import by.htp.rental.entity.Equipment;
import by.htp.rental.interf.IRentStation;

public class RentStation implements IRentStation{

	private HashMap<Integer, Equipment> equipments = new HashMap<>();
	private HashMap<Integer, Equipment> spareEquipments = new HashMap<>();
	private HashMap<Integer, Equipment> engagedEquipments = new HashMap<>();
	
	public HashMap<Integer, Equipment> getSpareEquipments() {
		
		return spareEquipments;
	}
	
	public HashMap<Integer, Equipment> getEngagedEquipments() {
		
		return engagedEquipments;
	}
	
	public HashMap<Integer, Equipment> getEquipments() {
		
		return equipments;
	}
	
	public void addEquipment(Equipment equipment) {
		equipment.setId(generateIdOfEquipment());
		equipments.put(equipment.getId(), equipment);
		spareEquipments.put(equipment.getId(), equipment);
	}
	
	private int generateIdOfEquipment() {
		return (int) (Math.random() * 100000);
	}
	
	public void addEngagedEquipment(Equipment eq) {
		engagedEquipments.put(eq.getId(), eq);
	}
	
	public void addSpareEquipment(Equipment eq) {
		engagedEquipments.put(eq.getId(), eq);
	}	
	
	public void deleteSpareEquipment(Equipment eq) {
		spareEquipments.remove(eq.getId());
	}
	
	public void deleteEngagedEquipment(Equipment eq) {
		engagedEquipments.remove(eq.getId());
	}
	
	@Override
	public String toString() {
		return "RentStation [equipments=" + equipments + "]";
	}
	

}
