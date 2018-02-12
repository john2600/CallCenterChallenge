package com.callcenter.callhandling.service;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import com.callcenter.crosscutting.status.Status;
import com.callcenter.employee.domain.Director;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.domain.Operator;
import com.callcenter.employee.domain.Supervisor;

public class CallHandling {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getTypeName());
	private CopyOnWriteArrayList<Employee> availableEmployees;

	public CallHandling(CopyOnWriteArrayList<Employee> listEmployee) {
		this.availableEmployees = listEmployee;
	}

	public void run() {
		try {
			searchEmployee();
			Thread.sleep(5000);
		} catch (InterruptedException ie) {

		} catch (Exception e) {

		}
	}

	public synchronized Employee searchEmployee() throws Exception {
		int i = 0;
		for (Employee emp : availableEmployees) {
			if (isOperator(emp)) {
				log.info("buscando operador...");
				return getOperator(i, emp);
			} else if (isSupervisor(emp)) {
				log.info("buscando Supervisor...");
				return getSupervisor(i, emp);
			} else if (isDirector(emp)) {
				log.info("buscando director...");
				return getDirector(i, emp);
			}

			i++;
		}

		return null;
	}

	private boolean isOperator(Employee emp) {
		return emp.getStatus().equals(Status.AVAILABLE.getStatus()) && emp instanceof Operator;
	}

	private boolean isSupervisor(Employee emp) {
		return emp.getStatus().equals(Status.AVAILABLE.getStatus()) && emp instanceof Supervisor;
	}

	private boolean isDirector(Employee emp) {
		return emp.getStatus().equals(Status.AVAILABLE.getStatus()) && emp instanceof Director;
	}

	private Employee getOperator(int i, Employee emp) {
		availableEmployees.get(i).setStatus(Status.ASSIGNED.getStatus());
		return emp;
	}

	private Employee getSupervisor(int i, Employee emp) {
		availableEmployees.get(i).setStatus(Status.ASSIGNED.getStatus());
		return emp;
	}

	private Employee getDirector(int i, Employee emp) {
		availableEmployees.get(i).setStatus(Status.ASSIGNED.getStatus());
		return emp;
	}

}
