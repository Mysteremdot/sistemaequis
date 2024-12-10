package com.mysteremdot.sistemaequis.domain;

import com.mysteremdot.sistemaequis.enumerations.Especie;
import com.mysteremdot.sistemaequis.enumerations.EspecieNombreConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class EtiquetaDeEspecie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	@Convert(converter = EspecieNombreConverter.class)
    @Column(length = 12, nullable = false, updatable = false)
	private Especie especie;
	
	@Column(length = 50, unique = true, nullable = false, updatable = false)
	private String nombre;
	
}
