package com.callcenter.beans.configuration;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.callcenter.callhandling.entrycall.BuildEntryCall;
import com.callcenter.callhandling.entrycall.EntryCalling;
import com.callcenter.callhandling.service.CallHandling;
import com.callcenter.employee.builder.BuilderEmployeeService;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.factory.EmpleadoFactoryService;
import com.callcenter.employee.mock.repository.EmployRepositoryService;
import com.callcenter.usecase.callinglocator.CallCenterService;

@Configuration
@ComponentScan(basePackages = "com.callcenter")
public class BeansConfig {

	@Bean
	public EmployRepositoryService getIEmployeeRepository() {
		return new EmployRepositoryService();
	}

	@Bean
	public EmpleadoFactoryService getIEmployeeFactory() {
		return new EmpleadoFactoryService();
	}

	@Bean
	public BuilderEmployeeService getIBuilderEmployee() {
		return new BuilderEmployeeService(getIEmployeeFactory(), getIEmployeeRepository());
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CallHandling getCallHandling() {
		return new CallHandling(getCopyOnWriteArrayList());
	}

	@Bean
	public CopyOnWriteArrayList<Employee> getCopyOnWriteArrayList() {
		return new BuilderEmployeeService(getIEmployeeFactory(), getIEmployeeRepository()).buildEmployeedList();
	}

	@Bean
	public List<EntryCalling> getBuildEntryCall() {
		return new BuildEntryCall().getEntryCalling();
	}

	@Bean
	public CallCenterService getCallCenterService() {
		return new CallCenterService(getBuildEntryCall(), getCallHandling(), getCopyOnWriteArrayList());
	}

}
