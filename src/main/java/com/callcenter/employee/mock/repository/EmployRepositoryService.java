package com.callcenter.employee.mock.repository;

import java.util.ArrayList;
import java.util.List;

public class EmployRepositoryService implements IEmployeeRepository {

	private List<EmployeeDTO> employeeDtoList;

	public EmployRepositoryService()

	{
		//Aqui se mockea los empleados que atenderan las llamadas
		EmployeeDTO a1 = new EmployeeDTO("Operador", "Juan", "Disponible");
		EmployeeDTO a2 = new EmployeeDTO("Operador", "Andres", "Disponible");
		EmployeeDTO a3 = new EmployeeDTO("Operador", "Carlos", "Disponible");
		EmployeeDTO a4 = new EmployeeDTO("Operador", "Daniel", "Disponible");
		// Empleado a5 = employeeFactory.getEmpleado("Operador", "Marimar",
		// "Disponible");
		// Empleado a6 = employeeFactory.getEmpleado("Operador", "Agostina",
		// "Disponible");
		EmployeeDTO a7 = new EmployeeDTO("Operador", "Fernanda", "Disponible");
		//
		EmployeeDTO s1 = new EmployeeDTO("Supervisor", "Camila", "Disponible");
		EmployeeDTO s2 = new EmployeeDTO("Supervisor", "Maria", "Disponible");
		EmployeeDTO s3 = new EmployeeDTO("Supervisor", "Claudia", "Disponible");
		//
		EmployeeDTO d1 = new EmployeeDTO("Director", "Pepe", "Disponible");
		EmployeeDTO d2 = new EmployeeDTO("Director", "Manuel", "Disponible");
		employeeDtoList = new ArrayList<>();

		employeeDtoList.add(a1);
		employeeDtoList.add(a2);
		employeeDtoList.add(a3);
		employeeDtoList.add(a4);
		// listEmpleado.add(a5);
		// listEmpleado.add(a6);
		// employeeDtoList.add(a7);
		// listEmpleado.add(a4);
		employeeDtoList.add(s1);
		// employeeDtoList.add(s2);
		// employeeDtoList.add(s3);
		employeeDtoList.add(d1);
		employeeDtoList.add(d2);

	}

	public List<EmployeeDTO> getEmployeeDtoList() {
		return employeeDtoList;
	}
}
