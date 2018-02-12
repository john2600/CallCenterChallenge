package com.callcenter.callhandling.service;

import java.util.concurrent.CopyOnWriteArrayList;

import com.callcenter.employee.domain.Employee;

public class EmployeeHandling {
	private CopyOnWriteArrayList<Employee> employeeList;
	{
		employeeList = new CopyOnWriteArrayList<Employee>();
	}

	public EmployeeHandling(CopyOnWriteArrayList<Employee> empleado) {
		this.employeeList = empleado;
	}

	public CopyOnWriteArrayList<Employee> getEmployList() {
		return this.employeeList;
	}

}
