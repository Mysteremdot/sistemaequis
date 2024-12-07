package com.mysteremdot.sistemaequis.domain;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
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

    
    private int fuerza;
    private int agilidad;
    private int inteligencia;
    
}
