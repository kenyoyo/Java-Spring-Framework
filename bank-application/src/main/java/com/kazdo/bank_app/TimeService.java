package com.kazdo.bank_app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeService {
	public static String getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		Date timeDate = cal.getTime();
		DateFormat timeDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = timeDateFormat.format(timeDate);
		return time;
	}
}
