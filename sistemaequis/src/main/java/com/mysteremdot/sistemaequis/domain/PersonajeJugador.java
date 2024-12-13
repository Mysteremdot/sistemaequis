package com.mysteremdot.sistemaequis.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.mysteremdot.sistemaequis.enumerations.Casta;
import com.mysteremdot.sistemaequis.enumerations.CastaNombreConverter;
import com.mysteremdot.sistemaequis.enumerations.Especie;
import com.mysteremdot.sistemaequis.enumerations.EspecieNombreConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
    @Column(length = 12, nullable = false, updatable = false)
	private Especie especie;
	
	@Convert(converter = CastaNombreConverter.class)
    @Column(length = 12, nullable = false, updatable = false)
	private Casta casta;

	@ManyToMany
    @JoinTable(name = "personaje_rasgo", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "rasgo_id"))
	private List<Rasgo> rasgos;
	
	@ManyToMany
    @JoinTable(name = "personaje_etiqueta_de_especie", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
	private List<EtiquetaDeEspecie> etiquetasDeEspecie;
	
	@ManyToMany
    @JoinTable(name = "personaje_merito", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "merito_id"))
	private List<Merito> meritos;
	
	@ManyToMany
    @JoinTable(name = "personaje_lacra", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "lacra_id"))
	private List<Lacra> lacras;
	
	@ManyToMany
    @JoinTable(name = "personaje_etiqueta_temporal", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
	private List<EtiquetaTemporal> etiquetasTemporales;

	@OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonajeCompetencia> competencias;

}
