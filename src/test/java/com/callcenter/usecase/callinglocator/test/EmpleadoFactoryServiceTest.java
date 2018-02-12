package com.callcenter.usecase.callinglocator.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.callcenter.beans.configuration.BeansConfig;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.domain.Operator;
import com.callcenter.employee.factory.EmpleadoFactoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class })
public class EmpleadoFactoryServiceTest {
	
	private static final String NAME = "Juan";
	private static final String DIRECTOR ="Director";
	private static final String SUPERVISOR ="Supervisor";
	private static final String OPERATOR ="Operador";
	private static final String AVAILABILITY ="Disponible";

	private EmpleadoFactoryService empleadoFactoryService;

	private Employee employee;

	@Test
	public void should_return_Operator() {
		empleadoFactoryService = new EmpleadoFactoryService();
		employee = empleadoFactoryService.getEmployee(OPERATOR , NAME, AVAILABILITY);
		assertEquals(employee.getRole(), newEmployee().getRole());
	}
	
	@Test
	public void should_return_Director() {
		empleadoFactoryService = new EmpleadoFactoryService();
		employee = empleadoFactoryService.getEmployee(DIRECTOR , NAME, AVAILABILITY);
		assertEquals(employee.getRole(), newEmployeeDirector().getRole());
	}
	
	@Test
	public void should_return_supervisor() {
		empleadoFactoryService = new EmpleadoFactoryService();
		employee = empleadoFactoryService.getEmployee(SUPERVISOR , NAME, AVAILABILITY);
		assertEquals(employee.getRole(), newEmployeeSupervisor().getRole());
	}
	

	public Operator newEmployee() {
		Operator employee = new Operator("Juan", "Disponible","Operador");
		return employee;
	}
	
	public Operator newEmployeeDirector() {
		Operator employee = new Operator("Juan", "Disponible","Director");
		return employee;
	}
	
	public Operator newEmployeeSupervisor() {
		Operator employee = new Operator("Juan", "Disponible","Supervisor");
		return employee;
	}

}
