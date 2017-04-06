package by.htp.rental.interf;

import by.htp.rental.entity.Equipment;

public interface IRentStation {

	void addEquipment(Equipment equipment);
	int[] getSpareEquipments();
	int[] getEngagedEquipments();
}
