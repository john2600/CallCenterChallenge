package com.callcenter.callhandling.entrycall;

import java.util.ArrayList;
import java.util.List;

public class BuildEntryCall {

	private List<EntryCalling> llamadas;

	public BuildEntryCall() {
		
		//Mock Calls
		User customer1 = new User("Carlos Martinez");
		User customer2 = new User("Andre Lopez");
		User customer3 = new User("Daniel Rodrigez");
		User customer4 = new User("Pedro Gomez");
		User customer5 = new User("Maria Lozano");
		User customer6 = new User("Carla Giraldo");
		User customer7 = new User("Daniela Ospina");
		User customer8 = new User("James Cuadrado");
		User customer9 = new User("Augusto Melano");
		User customer10 = new User("Paola Sancez");

		User cliente11 = new User("Margarita Velez");
		User cliente12 = new User("Carolina Perea");
		User cliente13 = new User("Andres Gutierrez");
		User cliente14 = new User("Guillermo Gomez");
		User cliente15 = new User("Diego Ordoñez");
		User cliente16 = new User("Mario Angulo");
		User cliente17 = new User("Pablo Ospina");
		User cliente18 = new User("Juan David Perea");

		long initialTime = System.currentTimeMillis();

		EntryCalling call1 = new EntryCalling(initialTime, 31502312, "Marcando", customer1);
		EntryCalling call2 = new EntryCalling(initialTime, 32592312, "Marcando", customer2);
		EntryCalling call3 = new EntryCalling(initialTime, 31342312, "Marcando", customer3);
		EntryCalling call4 = new EntryCalling(initialTime, 31492312, "Marcando", customer4);
		EntryCalling call5 = new EntryCalling(initialTime, 31552312, "Marcando", customer5);
		EntryCalling call6 = new EntryCalling(initialTime, 33392312, "Marcando", customer6);
		EntryCalling call7 = new EntryCalling(initialTime, 30092312, "Marcando", customer7);
		EntryCalling call8 = new EntryCalling(initialTime, 31390312, "Marcando", customer8);
		EntryCalling call9 = new EntryCalling(initialTime, 31590012, "Marcando", customer9);
		EntryCalling call10 = new EntryCalling(initialTime, 31592331, "Marcando", customer10);

		EntryCalling call11 = new EntryCalling(initialTime, 33315012, "Marcando", cliente11);
		EntryCalling call12 = new EntryCalling(initialTime, 33492312, "Marcando", cliente12);
		EntryCalling call13 = new EntryCalling(initialTime, 33542312, "Marcando", cliente13);
		EntryCalling call14 = new EntryCalling(initialTime, 33692312, "Marcando", cliente14);
		EntryCalling call15 = new EntryCalling(initialTime, 33375217, "Marcando", cliente15);
		EntryCalling call16 = new EntryCalling(initialTime, 30000002, "Marcando", cliente16);
		EntryCalling call17 = new EntryCalling(initialTime, 30191002, "Marcando", cliente17);
		EntryCalling call18 = new EntryCalling(initialTime, 30102012, "Marcando", cliente18);

		llamadas = new ArrayList<EntryCalling>();
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
//
//		llamadas.add(call11);
//		llamadas.add(call12);
//		llamadas.add(call13);
//		llamadas.add(call14);
//		llamadas.add(call15);
//		llamadas.add(call16);
//		llamadas.add(call17);
//		llamadas.add(call18);

	}

	public List<EntryCalling> getEntryCalling() {
		return llamadas;
	}

}
