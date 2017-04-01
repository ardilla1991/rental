package by.htp.rental.interf;

import by.htp.rental.entity.Equipment;

public interface IRentStation {

	void addEquipment(Equipment equipment);
	Equipment[] getSpareEquipments();
	Equipment[] getEngagedEquipments();
}
