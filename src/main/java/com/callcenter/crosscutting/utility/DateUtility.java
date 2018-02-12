package com.callcenter.crosscutting.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtility {

	public static String getTime(final long initialTime) {
		final Long time = (System.currentTimeMillis() - initialTime) / 1000000;
		return time.toString();
	}

	public static String getCurrentTime() {
		final Date ahora = new Date();
		final SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
		return formateador.format(ahora);
	}

	public static Long getDurationCallRandom() {
		Random r = new Random();
		int minCallDuration = 5;
		int maxCallDuracion = 10;
		Long time = (long) (r.nextInt(maxCallDuracion - minCallDuration) + minCallDuration);
		return time;
	}

}
