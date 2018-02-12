package com.callcenter.callhandling.entrycall;

public class User {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + "]";
	}

	public User(String nombre) {
		super();
		this.nombre = nombre;
	}
	

}
