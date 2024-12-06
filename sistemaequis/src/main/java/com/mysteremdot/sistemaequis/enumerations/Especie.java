package com.mysteremdot.sistemaequis.enumerations;

public enum Especie {

	HUMANA		(0, "Humana"),
	AR_SHAMBELI	(1, "Ar'shambeli"),
	CROULAMB	(2, "Croulamb"),
	GLABE_NAR	(3, "Glabe'nar"),
	PETI_SHAR	(4, "Peti'shar"),
	SH_MYRR		(5, "Sh'myrr"),
	VROGO		(6, "Vrogo");

	private final Integer id;
    private final String nombre;

    Especie(Integer id, String nombre) {
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
