package com.callcenter.usecase.callinglocator;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.callcenter.callhandling.entrycall.EntryCalling;
import com.callcenter.callhandling.service.CallHandling;
import com.callcenter.callhandling.service.Dispatcher;
import com.callcenter.employee.domain.Employee;

public class CallCenterService {

	private List<EntryCalling> entryCalls;
	private CallHandling callHandling;

	private CopyOnWriteArrayList<Employee> employeeList;
	private Dispatcher dispatcher;
	public CallCenterService(List<EntryCalling> entryCalls, CallHandling callHandling,
			CopyOnWriteArrayList<Employee> employeeList) {
		this.entryCalls = entryCalls;
		this.callHandling = callHandling;
		this.employeeList = employeeList;
	}

	public void runner() {
		List<EntryCalling> llamadas =this.entryCalls;
		for (EntryCalling calls : llamadas) {
			dispatcher =new Dispatcher(calls, employeeList, callHandling);
			dispatcher.start();
			
		}

	}

}
