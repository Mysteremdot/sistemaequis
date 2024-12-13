package com.mysteremdot.sistemaequis.domain;

import java.util.List;

import com.mysteremdot.sistemaequis.enumerations.TipoCompetencia;
import com.mysteremdot.sistemaequis.enumerations.TipoCompetenciaNombreConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Competencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	@Column(length = 20, unique = true, nullable = false, updatable = false)
	private String nombre;
	
	@Convert(converter = TipoCompetenciaNombreConverter.class)
    @Column(length = 12, nullable = false)
    private TipoCompetencia tipo;
	
	// INICIO Relación jerárquica de la misma entidad.
	
	@ManyToOne
	@JoinColumn(name = "especializacion_de_id")
	private Competencia especializacionDe;
	
	@OneToMany(mappedBy = "especializacionDe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Competencia> especializaciones;
	
	// FIN Relación jerárquica de la misma entidad.
	
	@OneToMany(mappedBy = "competencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonajeCompetencia> personajes;

}
