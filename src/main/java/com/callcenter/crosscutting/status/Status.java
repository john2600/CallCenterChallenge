package com.callcenter.crosscutting.status;

public enum Status {
	Bussy("Ocupado"), AVAILABLE("Disponible"), ASSIGNED("ASIGNADO");

	private String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}
