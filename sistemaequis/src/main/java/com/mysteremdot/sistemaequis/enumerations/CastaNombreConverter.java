package com.mysteremdot.sistemaequis.enumerations;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CastaNombreConverter implements AttributeConverter<Casta, String> {

	@Override
	public String convertToDatabaseColumn(Casta attribute) {
		return attribute == null ? null : attribute.getNombre();
	}

	@Override
	public Casta convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
        }
        for (Casta especie : Casta.values()) {
            if (especie.getNombre().equals(dbData)) {
                return especie;
            }
        }
        throw new IllegalArgumentException("Nombre desconocido para la casta: " + dbData);
	}

}
