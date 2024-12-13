package com.mysteremdot.sistemaequis.enumerations;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoCompetenciaNombreConverter implements AttributeConverter<TipoCompetencia, String> {

	@Override
	public String convertToDatabaseColumn(TipoCompetencia attribute) {
		return attribute == null ? null : attribute.getNombre();
	}

	@Override
	public TipoCompetencia convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
        }
        for (TipoCompetencia tipoCompetencia : TipoCompetencia.values()) {
            if (tipoCompetencia.getNombre().equals(dbData)) {
                return tipoCompetencia;
            }
        }
        throw new IllegalArgumentException("Nombre desconocido para el tipo de competencia: " + dbData);
	}

}
