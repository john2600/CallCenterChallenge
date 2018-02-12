package com.callcenter.usecase.callinglocator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.callcenter.beans.configuration.BeansConfig;

public class Runner {
	public static void main(String[] args) {
		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);

		final CallCenterService runner = applicationContext.getBean(CallCenterService.class);
		runner.runner();

		((AnnotationConfigApplicationContext) applicationContext).close();

	}
}
