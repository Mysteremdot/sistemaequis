package com.mysteremdot.sistemaequis.enumerations;

public enum TipoCompetencia {

	COMUN		(1, "Común"),
	AVANZADA	(2, "Avanzada");

	private final Integer id;
    private final String nombre;

    TipoCompetencia(Integer id, String nombre) {
    	this.id = id;
        this.nombre = nombre;
    }

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

}
