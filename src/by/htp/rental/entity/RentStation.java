package by.htp.rental.entity;

import java.util.Arrays;
import java.util.HashMap;
import by.htp.rental.interf.IRentStation;

public class RentStation implements IRentStation{

	private HashMap<Integer, Equipment> equipments = new HashMap<>();
	private HashMap<Integer, Equipment> spareEquipments = new HashMap<>();
	private HashMap<Integer, Equipment> engagedEquipments = new HashMap<>();

	public void addEquipment(Equipment equipment) {
		int id = generateIdOfEquipment();
		equipments.put(id, equipment);
		equipment.setId(id);
		spareEquipments.put(id, equipment);
	}
	
	private int generateIdOfEquipment() {
		int id = (int) (Math.random()*100000); 
		
		return id;
	}

	@Override
	public String toString() {
		return "RentStation [equipments=" + equipments + "]";
	}
	
	public HashMap<Integer, Equipment> getSpareEquipments() {
		
		return spareEquipments;
	}
	
	public HashMap<Integer, Equipment> getEngagedEquipments() {
		
		return engagedEquipments;
	}
	
	public HashMap<Integer, Equipment> getEquipments() {
		
		return equipments;
	}
	
	public void addEngagedRecord(Equipment eq) {
		engagedEquipments.put(eq.getId(), eq);
	}
	
	public void addSpareRecord(Equipment eq) {
		engagedEquipments.put(eq.getId(), eq);
	}	
	
	public void deleteSpareRecord(Equipment eq) {
		spareEquipments.remove(eq.getId());
	}
	
	public void deleteEngagedRecord(Equipment eq) {
		engagedEquipments.remove(eq.getId());
	}
	
	///// find equipment by param
	public HashMap<Integer, Equipment> findEquipmentByParams(double price) {
		HashMap<Integer, Equipment> eq = new HashMap<>();
		for ( HashMap.Entry<Integer, Equipment> entry : equipments.entrySet()) {
			if ( entry.getValue().getPrice() < price && !Arrays.asList(getSpareEquipments()).contains(entry.getValue().getId()) ) {
				eq.put(entry.getKey(), entry.getValue());
			}
		}

		return eq;
	}
	
	public Equipment findSpareEquipmentByType(String type) throws ClassNotFoundException {
		for ( HashMap.Entry<Integer, Equipment> entry : spareEquipments.entrySet()) {
			if ( Class.forName("by.htp.rental.entity."+type).isInstance(entry.getValue())) {
				return entry.getValue();
			}
		}
		return null;
	}

}
