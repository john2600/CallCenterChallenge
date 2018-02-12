package com.callcenter.employee.mock.repository;

public class EmployeeDTO {

	public String status;
	public String name;
	public String role;

	public EmployeeDTO(final String role, final String name, final String status) {
		this.status = status;
		this.name = name;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [status=" + status + ", name=" + name + ", role=" + role + "]";
	}
	
	

}
