package com.mysteremdot.sistemaequis.enumerations;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NivelCompetenciaNombreConverter implements AttributeConverter<NivelCompetencia, String> {

	@Override
	public String convertToDatabaseColumn(NivelCompetencia attribute) {
		return attribute == null ? null : attribute.getNombre();
	}

	@Override
	public NivelCompetencia convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
        }
        for (NivelCompetencia nivelCompetencia : NivelCompetencia.values()) {
            if (nivelCompetencia.getNombre().equals(dbData)) {
                return nivelCompetencia;
            }
        }
        throw new IllegalArgumentException("Nombre desconocido para el nivel de competencia: " + dbData);
	}

}
