package com.callcenter.crosscutting.profile;

public enum Profile {

	OPERATOR("Operador"), SUPERVISOR("Supervisor"), DIRECTOR("Director");

	private String typeEmployee;

	Profile(String profile) {
		this.typeEmployee = profile;
	}

	public String getProfile() {
		return this.typeEmployee;
	}
}
