package com.callcenter.usecase.callinglocator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

import com.callcenter.callhandling.service.CallHandling;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.domain.Operator;

public class CallHandlingTest {
	private CopyOnWriteArrayList<Employee> employeeListempty = new CopyOnWriteArrayList<Employee>();
	private CallHandling callHandling;
	private static final String STATUS_ASIGNED = "ASIGNADO";

	@Test
	public void should_returnNulIfemployeeListEmpty() throws Exception {
		callHandling = new CallHandling(employeeListempty);

		assertNull(callHandling.searchEmployee());
	}

	@Test
	public void shoudl_returnEmployeeAvailable() throws Exception {
		employeeListempty = buildEmployeeList();
		callHandling = new CallHandling(employeeListempty);
		assertNotNull(callHandling);
		assertEquals(buildEmployeeList().get(0).getName(), callHandling.searchEmployee().getName());
		assertEquals(buildEmployeeList().get(0).getRole(), callHandling.searchEmployee().getRole());
	}

	@Test
	public void should_returnNull() throws Exception {
		employeeListempty = buildEmployeeList();
		callHandling = new CallHandling(employeeListempty);
		assertNotNull(callHandling);
		assertEquals(buildEmployeeList().get(4).getStatus(), STATUS_ASIGNED);
	}

	private CopyOnWriteArrayList<Employee> buildEmployeeList() {
		CopyOnWriteArrayList<Employee> emloyeeList = new CopyOnWriteArrayList<>();
		Operator a1 = new Operator("Juan", "Disponible", "Operador");
		Operator a2 = new Operator("Andres", "Disponible", "Operador");
		Operator a3 = new Operator("Carlos", "Disponible", "Operador");
		Operator a4 = new Operator("Daniel", "ASIGNADO", "Operador");
		emloyeeList.add(a1);
		emloyeeList.add(a1);
		emloyeeList.add(a2);
		emloyeeList.add(a3);
		emloyeeList.add(a4);
		return emloyeeList;
	}

}
