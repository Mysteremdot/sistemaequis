package com.mysteremdot.sistemaequis.enumerations;

public enum NivelCompetencia {
	
	NULO			(0, "Nulo", 		"d4?"),
	APRENDIZ		(1, "Aprendiz", 	"d4"),
	MEDIOCRE		(2, "Mediocre", 	"d6"),
	DESTACADO		(3, "Destacado", 	"d10"),
	EXPERTO			(4, "Experto", 		"d20"),
	MAESTRO			(5, "Maestro", 		"d20!"),
	MILAGROSO		(6, "Milagroso", 	"+d4"),
	PRODIGIOSO		(7, "Prodigioso", 	"+d6"),
	SOBRENATURAL	(8, "Sobrenatural", "+d10"),
	DIVINO			(9, "Divino", 		"+d20");
	
	private final Integer id;
    private final String nombre;
    private final String dado;
	
    NivelCompetencia(Integer id, String nombre, String dado) {
    	this.id = id;
        this.nombre = nombre;
        this.dado = dado;
    }

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDado() {
		return dado;
	}
    
}
