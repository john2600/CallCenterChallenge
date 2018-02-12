package com.callcenter.employee.domain;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;


public class Operator extends Employee {
	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getTypeName());
	private String name;

	public Operator(String nombre2) {
		this.name = nombre2;
	}

	public Operator(String name, String status, String role) {
		log.info("Operador " + name + " Disponible para antender Llamada ");
		this.name = name;
		this.status = status;
		this.role = role;
	}

	@Override
	public String attendIncommingCall() {
		return "[*EMPLEADO: " + this.name + " CARGO :" + this.role + " ESTADO:" + this.status + "*] ";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
