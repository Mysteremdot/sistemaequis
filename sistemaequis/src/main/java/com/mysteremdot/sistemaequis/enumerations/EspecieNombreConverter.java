package com.mysteremdot.sistemaequis.enumerations;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EspecieNombreConverter implements AttributeConverter<Especie, String> {

	@Override
	public String convertToDatabaseColumn(Especie attribute) {
		return attribute == null ? null : attribute.getNombre();
	}

	@Override
	public Especie convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
        }
        for (Especie especie : Especie.values()) {
            if (especie.getNombre().equals(dbData)) {
                return especie;
            }
        }
        throw new IllegalArgumentException("Nombre desconocido para la especie: " + dbData);
	}

}
