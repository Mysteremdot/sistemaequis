package com.mysteremdot.sistemaequis.enumerations;

public enum Casta {

	NINGUNA		( 0, "Ninguna"),
	VARANNI		( 1, "Varanni"),
	NIAVARANNI	( 2, "Niavaranni"),
	KORANNI		( 3, "Koranni"),
	YRANNI		( 4, "Yranni"),
	ULIANNI		( 5, "Ulianni"),
	VULANNI		( 6, "Vulanni"),
	DARANNI		( 7, "Daranni"),
	GHIANNI		( 8, "Ghianni"),
	JUTHYANNI	( 9, "Juthyanni"),
	TOANNI		(10, "Toanni");

	private final Integer id;
    private final String nombre;

    Casta(Integer id, String nombre) {
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
