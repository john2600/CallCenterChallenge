package com.callcenter.employee.domain;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

public class Director extends Employee{
	
	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getTypeName());
	private String name;
	
	public Director(){}

	public Director(String name, String status, String role) {
		log.info("Director "+name+" Disponible para antender Llamada ");
		this.name = name;
		this.status = status;
		this.role = role;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String attendIncommingCall() {
		return "[***EMPLEADO: "+this.name+" CARGO :"+this.role+" ESTADO :"+this.status+"***]" ;
	}
	

}
