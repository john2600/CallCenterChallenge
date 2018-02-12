package com.callcenter.employee.builder;

import java.util.concurrent.CopyOnWriteArrayList;

import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.factory.EmpleadoFactoryService;
import com.callcenter.employee.mock.repository.EmployRepositoryService;

public class BuilderEmployeeService implements IBuilderEmployee {

	private EmpleadoFactoryService employeeFactory;
	private EmployRepositoryService employRepositoreyService;
	private CopyOnWriteArrayList<Employee> listEmpleado;

	public BuilderEmployeeService(EmpleadoFactoryService employeeFactory,
			EmployRepositoryService employRepositoreyService) {
		this.employeeFactory = employeeFactory;
		this.employRepositoreyService = employRepositoreyService;
	}

	public CopyOnWriteArrayList<Employee> buildEmployeedList() {
		listEmpleado = new CopyOnWriteArrayList<Employee>();
		employRepositoreyService.getEmployeeDtoList().forEach(employeeList -> listEmpleado.add(
				employeeFactory.getEmployee(employeeList.getRole(), employeeList.getName(), employeeList.getStatus())));
		return listEmpleado;
	}

	public void addNewEmploy(String role, String name, String status) {
		Employee a1 = employeeFactory.getEmployee(role, name, status);
		listEmpleado.add(a1);
	}

}
