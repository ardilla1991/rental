package by.htp.rental.interf;

import java.util.HashMap;

import by.htp.rental.entity.Equipment;

public interface IRentStation {

	void addEquipment(Equipment equipment);
	HashMap<Integer, Equipment> getSpareEquipments();
	HashMap<Integer, Equipment> getEngagedEquipments();
}
