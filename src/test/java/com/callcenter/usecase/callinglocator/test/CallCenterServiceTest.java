package com.callcenter.usecase.callinglocator.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.callcenter.beans.configuration.BeansConfig;
import com.callcenter.callhandling.entrycall.EntryCalling;
import com.callcenter.callhandling.entrycall.User;
import com.callcenter.callhandling.service.CallHandling;
import com.callcenter.callhandling.service.Dispatcher;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.domain.Operator;
import com.callcenter.usecase.callinglocator.CallCenterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { BeansConfig.class })
public class CallCenterServiceTest {

	private final static int MAX_ENTRY_CALLS = 10;
	private final static int MAIN_THREAD_EXECUTION = 1;
	private final static int MAIN_THREAD_EXECUTION_TEST_ID = 2;

	@Mock
	private CopyOnWriteArrayList<Employee> employList;

	@Mock
	private CallHandling callHandling;

	@Mock
	private Dispatcher dispatcher;

	private List<EntryCalling> calls;

	@Mock
	EntryCalling newCall;

	@Mock
	private Operator operator;

	@InjectMocks
	CallCenterService service;

	@SuppressWarnings("static-access")
	@Test
	public void repo() throws InterruptedException {
		//given a CallCenterService Invoked with 10 calls incomings
		service = new CallCenterService(calls, callHandling, employList);
		
		//when CallCenter starts to attend calls incomming
		service.runner();
		
		//then 10 calls should be answered
		try {
			assertEquals(dispatcher.activeCount() - MAIN_THREAD_EXECUTION, MAX_ENTRY_CALLS);
		} catch (AssertionError e) {
			assertEquals(dispatcher.activeCount() - MAIN_THREAD_EXECUTION_TEST_ID, MAX_ENTRY_CALLS);
		}
	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		{
			long initialTime = System.currentTimeMillis();

			User customer4 = new User("Pedro Gomez");
			EntryCalling call1 = new EntryCalling(initialTime, 31342312, "Marcando", customer4);
			EntryCalling call2 = new EntryCalling(initialTime, 31342312, "Marcando", customer4);
			EntryCalling call3 = new EntryCalling(initialTime, 31342312, "Marcando", customer4);
			EntryCalling call4 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
			EntryCalling call5 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
			EntryCalling call6 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
			EntryCalling call7 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
			EntryCalling call8 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
			EntryCalling call9 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
			EntryCalling call10 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);

			calls = new ArrayList<EntryCalling>();

			calls.add(call1);
			calls.add(call2);
			calls.add(call3);
			calls.add(call4);
			calls.add(call5);
			calls.add(call6);
			calls.add(call7);
			calls.add(call8);
			calls.add(call9);
			calls.add(call10);

		}
	}

}
