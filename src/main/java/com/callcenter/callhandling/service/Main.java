package com.callcenter.callhandling.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.callcenter.callhandling.entrycall.EntryCalling;
import com.callcenter.callhandling.entrycall.User;
import com.callcenter.employee.builder.BuilderEmployeeService;
import com.callcenter.employee.domain.Employee;
import com.callcenter.employee.factory.EmpleadoFactoryService;
import com.callcenter.employee.mock.repository.EmployRepositoryService;

public class Main {

	public static void main(String[] args) {
	
	  EmpleadoFactoryService employeeFactory = new EmpleadoFactoryService();

			//@Autowired
			
		EmployRepositoryService employRepositoreyService = new EmployRepositoryService();
		
		BuilderEmployeeService builderEmployee = new BuilderEmployeeService(employeeFactory,employRepositoreyService);
		CopyOnWriteArrayList<Employee> employeeList = builderEmployee.buildEmployeedList();

		User cliente1 = new User("Carlos Martinez");
		User cliente2 = new User("Andre Lopez");
		User cliente3 = new User("Daniel Rodrigez");
		User cliente4 = new User("Pedro Gomez");
		User cliente5 = new User("Maria Lozano");
		User cliente6 = new User("Carla Giraldo");
		User cliente7 = new User("Daniela Ospina");
		User cliente8 = new User("James Cuadrado");
		User cliente9 = new User("Augusto Melano");
		User cliente10 = new User("Paola Sancez");
		
		User cliente11 = new User("Margarita Velez");
		User cliente12 = new User("Carolina Perea");
		User cliente13 = new User("Andres Gutierrez");
		User cliente14 = new User("Guillermo Gomez");
		User cliente15 = new User("Diego Ordoñez");
		User cliente16 = new User("Mario Angulo");
		User cliente17 = new User("Pablo Ospina");
		User cliente18 = new User("Juan David Perea");


		CallHandling callHandling = new CallHandling(employeeList);
		long initialTime = System.currentTimeMillis();

		EntryCalling call1 = new EntryCalling(initialTime, 31502312, "Marcando", cliente1);
		EntryCalling call2 = new EntryCalling(initialTime, 32592312, "Marcando", cliente2);
		EntryCalling call3 = new EntryCalling(initialTime, 31342312, "Marcando", cliente3);
		EntryCalling call4 = new EntryCalling(initialTime, 31492312, "Marcando", cliente4);
		EntryCalling call5 = new EntryCalling(initialTime, 31552312, "Marcando", cliente5);
		EntryCalling call6 = new EntryCalling(initialTime, 33392312, "Marcando", cliente6);
		EntryCalling call7 = new EntryCalling(initialTime, 30092312, "Marcando", cliente7);
		EntryCalling call8 = new EntryCalling(initialTime, 31390312, "Marcando", cliente8);
		EntryCalling call9 = new EntryCalling(initialTime, 31590012, "Marcando", cliente9);
		EntryCalling call10 = new EntryCalling(initialTime, 31592331, "Marcando", cliente10);
		
		
		EntryCalling call11 = new EntryCalling(initialTime, 33315012, "Marcando", cliente11);
		EntryCalling call12 = new EntryCalling(initialTime, 33492312, "Marcando", cliente12);
		EntryCalling call13 = new EntryCalling(initialTime, 33542312, "Marcando", cliente13);
		EntryCalling call14 = new EntryCalling(initialTime, 33692312, "Marcando", cliente14);
		EntryCalling call15 = new EntryCalling(initialTime, 33375217, "Marcando", cliente15);
		EntryCalling call16 = new EntryCalling(initialTime, 30000002, "Marcando", cliente16);
		EntryCalling call17 = new EntryCalling(initialTime, 30191002, "Marcando", cliente17);
		EntryCalling call18 = new EntryCalling(initialTime, 30102012, "Marcando", cliente18);
		

		List<EntryCalling> llamadas = new ArrayList<EntryCalling>();
		llamadas.add(call1);
		llamadas.add(call2);
		llamadas.add(call3);
		llamadas.add(call4);
		llamadas.add(call5);
		llamadas.add(call6);
		llamadas.add(call7);
		llamadas.add(call8);
		llamadas.add(call9);
		llamadas.add(call10);

		llamadas.add(call11);
		llamadas.add(call12);
		llamadas.add(call13);
		llamadas.add(call14);
		llamadas.add(call15);
		llamadas.add(call16);
		llamadas.add(call17);
		llamadas.add(call18);
		

		// hilo1.start();
		if (llamadas.size() > 10) {
			System.out.println("no las puedo procesar");

		}
		for (EntryCalling calls : llamadas) {
			Dispatcher dispatcher = new Dispatcher(calls, employeeList, callHandling);
			dispatcher.start();
		}

	}

}
