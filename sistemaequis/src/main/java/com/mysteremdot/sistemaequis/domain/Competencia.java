package com.mysteremdot.sistemaequis.domain;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.mysteremdot.sistemaequis.enumerations.NivelCompetencia;
import com.mysteremdot.sistemaequis.enumerations.NivelCompetenciaNombreConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Competencia {
	
	@Id
	@JdbcTypeCode(value = SqlTypes.CHAR)
    @Column(columnDefinition = "varchar", length = 36, nullable = false, updatable = false)
    private UUID id; // Clave primaria compartida con PersonajeJugador

    //	////////////////////////////////////////
	//	////////// COMPETENCIAS COMUNES
	//	////////////////////////////////////////
	
	@Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia AGIlidad;
	
	@Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia ATLletismo;
	
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia AURa;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia AUTocontrol;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia CONviccion;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia COOrdinacion;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia EIDos;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia EMPatia;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia FORtaleza;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia FUErza;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia INTelecto;
    
    @Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia PERspicacia;
    
    //	////////////////////////////////////////
	//	////////// COMPETENCIAS AVANZADAS
	//	////////////////////////////////////////
    
}
