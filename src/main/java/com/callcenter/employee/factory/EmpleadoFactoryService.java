package com.callcenter.employee.factory;

import com.callcenter.crosscutting.profile.Profile;
import com.callcenter.employee.domain.Director;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.domain.Operator;
import com.callcenter.employee.domain.Supervisor;

public class EmpleadoFactoryService implements IEmployeeFactory {
	@Override
	public Employee getEmployee(String type, String name, String status) {
		if (Profile.OPERATOR.getProfile().equals(type)) {
			return new Operator(name, status, Profile.OPERATOR.getProfile());
		} else if (Profile.SUPERVISOR.getProfile().equals(type)) {
			return new Supervisor(name, status, Profile.SUPERVISOR.getProfile());
		} else {
			return new Director(name, status, Profile.DIRECTOR.getProfile());
		}
	}

}
