package de.ngxa.restaurant.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtil {

	private DateUtil() {}

	public static boolean dayContains(List<Date> dateList, Date dateToContains) {
		final SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

		for(Date date: dateList) {
			if(fmt.format(date).equals(fmt.format(dateToContains))) {
				return true;
			}
		}

		return false;
	}

	public static Date getMaxDate() {
		Calendar calendar = new GregorianCalendar(9999,11,31);
		return calendar.getTime();
	}

	public static Date addDays(Date date, int days) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date minusDays(Date date, int days) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 0 - days);
		return cal.getTime();
	}
}
