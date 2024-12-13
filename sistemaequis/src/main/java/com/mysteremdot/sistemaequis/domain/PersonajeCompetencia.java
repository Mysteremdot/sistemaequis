package com.mysteremdot.sistemaequis.domain;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.mysteremdot.sistemaequis.enumerations.NivelCompetencia;
import com.mysteremdot.sistemaequis.enumerations.NivelCompetenciaNombreConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonajeCompetencia {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(value = SqlTypes.CHAR)
    @Column(columnDefinition = "varchar", length = 36, nullable = false, updatable = false)
	private UUID id;

    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false, updatable = false)
    private PersonajeJugador personaje;

    @ManyToOne
    @JoinColumn(name = "competencia_id", nullable = false, updatable = false)
    private Competencia competencia;

	@Convert(converter = NivelCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private NivelCompetencia nivel;

}
