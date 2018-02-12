package com.callcenter.employee.factory;

import com.callcenter.employee.domain.Employee;

public interface IEmployeeFactory  {
	public Employee getEmployee(String type, String name, String status);
}
