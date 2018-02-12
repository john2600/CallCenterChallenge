package com.callcenter.callhandling.service;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import com.callcenter.callhandling.entrycall.EntryCalling;
import com.callcenter.crosscutting.constants.CallMessages;
import com.callcenter.crosscutting.status.Status;
import com.callcenter.crosscutting.utility.DateUtility;
import com.callcenter.employee.domain.Employee;

public class Dispatcher extends Thread {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getTypeName());
	private CopyOnWriteArrayList<Employee> employeeList;
	private CallHandling callHandling;
	private Employee empl;
	private EntryCalling newCall;

	public Dispatcher(EntryCalling call1, CopyOnWriteArrayList<Employee> empleado, CallHandling callHandling) {
		this.newCall = call1;
		this.employeeList = empleado;
		this.callHandling = callHandling;
	}

	@Override
	public void run() {
		dispatchCall();
	}

	public void dispatchCall() {
		Long time = DateUtility.getDurationCallRandom();
		startingCalling(time);
		processCall(time, this.newCall.getNumero());
		callEnding(time);

	}

	private void startingCalling(Long time) {
		log.info(String.format(CallMessages.CALLING_ENTRACE, new Integer(this.newCall.getNumero()).toString(),
				this.newCall.getUsuario().getNombre(), DateUtility.getCurrentTime()));
	}

	private synchronized void callEnding(Long time) {
		if (this.empl != null) {
			log.info(String.format(CallMessages.CALLING_FINISHED, this.newCall.getNumero(),
					this.newCall.getUsuario().getNombre(), time, this.empl.getName()));
			employeeList.get(employeeList.indexOf(empl)).setStatus(Status.AVAILABLE.getStatus());
		}

	}

	private synchronized void processCall(Long segundos, int codLlamada) {
		try {
			Employee asignEmployee = asignEmployeeAvailable();
			if (asignEmployee == null) {
				retryAttendingCall(codLlamada);
			} else {
				attendingCall(segundos, codLlamada, asignEmployee);
			}
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	private void attendingCall(Long segundos, int codLlamada, Employee operador) {
		log.info(
				String.format(CallMessages.CALL_IN_LIVE, codLlamada, operador.attendIncommingCall(), DateUtility.getCurrentTime()));
		Long initialTime = System.currentTimeMillis();
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
		}
		Long finalTime = System.currentTimeMillis();
		log.info(String.format(CallMessages.CALL_OVER, codLlamada, operador.attendIncommingCall(), DateUtility.getCurrentTime(),
				((finalTime - initialTime) / 1000)));
		habilitarEmpleado(operador);
	}

	private void retryAttendingCall(int codLlamada) throws InterruptedException {
		log.warning(String.format(CallMessages.CALL_NOT_RESPONSED, codLlamada));
		Thread.sleep(15000);
		new Dispatcher(this.newCall, this.employeeList, this.callHandling).start();
	}

	public void habilitarEmpleado(Employee empl) {
		if (employeeList.get(employeeList.indexOf(empl)).getStatus().equals(Status.ASSIGNED.getStatus())) {
			employeeList.get(employeeList.indexOf(empl)).setStatus(Status.AVAILABLE.getStatus());
			log.info(String.format(CallMessages.EMPLOYEE_AVAILBE_MSG,
					employeeList.get(employeeList.indexOf(empl)).getName(),
					employeeList.get(employeeList.indexOf(empl)).getStatus()));
		}
	}

	private Employee asignEmployeeAvailable() {
		Employee empp = null;
		try {
			empp = callHandling.searchEmployee();
			if (empp != null && empp.getStatus().equals(Status.ASSIGNED.getStatus())) {
				empl = empp;
				return empl;
			} else {
				return null;
			}
		} catch (Exception e) {
		}
		return empl;
	}
}
