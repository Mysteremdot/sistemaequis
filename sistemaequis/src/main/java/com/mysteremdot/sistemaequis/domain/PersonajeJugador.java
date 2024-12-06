package com.mysteremdot.sistemaequis.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.mysteremdot.sistemaequis.enumerations.Especie;
import com.mysteremdot.sistemaequis.enumerations.EspecieNombreConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonajeJugador {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(value = SqlTypes.CHAR)
    @Column(columnDefinition = "varchar", length = 36, nullable = false, updatable = false)
	private UUID id;

	@Convert(converter = EspecieNombreConverter.class)
    @Column(length = 12, unique = true, nullable = false, updatable = false)
	private Especie especie;

	@ManyToMany
    @JoinTable(name = "personaje_rasgo", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "rasgo_id"))
	private List<Rasgo> rasgos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personaje_id")
	private List<Etiqueta> etiquetas;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personaje_id")
	private List<Competencia> competencias;

}
