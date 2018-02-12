package com.callcenter.employee.builder;

import java.util.concurrent.CopyOnWriteArrayList;

import com.callcenter.employee.domain.Employee;

public interface IBuilderEmployee {
	public CopyOnWriteArrayList<Employee> buildEmployeedList();
}
