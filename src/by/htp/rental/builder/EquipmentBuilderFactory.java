package by.htp.rental.builder;

public class EquipmentBuilderFactory {
	
	private enum TypeParser {
		SAX, STAX, DOM
	}
	
	public AbstractEquipmentsBuilder createEquipmentBuilder(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
			case DOM:
				return new EquipmentDOMBuilder();
			case STAX:
				return new EquipmentStAXBuilder();
			case SAX:
				return new EquipmentSAXBuilder();
			default:
				throw new EnumConstantNotPresentException(
						type.getDeclaringClass(), type.name());
		}
	}
}
