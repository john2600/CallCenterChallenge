package com.callcenter.usecase.callinglocator.test;

import org.mockito.ArgumentCaptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.callcenter.beans.configuration.BeansConfig;
import com.callcenter.usecase.callinglocator.CallCenterService;

public class IntegrationTest {
	ArgumentCaptor<Runnable> runnables = ArgumentCaptor.forClass(Runnable.class);

	public static void main(String[] args) {

		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);

		final CallCenterService runner = applicationContext.getBean(CallCenterService.class);
		runner.runner();

		

		((AnnotationConfigApplicationContext) applicationContext).close();

	}

}
