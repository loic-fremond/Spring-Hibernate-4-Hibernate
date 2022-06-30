package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	
	// Date formatter
	// - dd: day
	// - MM: month
	// - YYYY: year
	
	 private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	
	// read a date String and parse to a date
	public static LocalDate parseDate(String dateStr) throws ParseException {
		
		LocalDate theDate = LocalDate.parse(dateStr, formatter);
		return theDate;
		
	}
	
	// read a date and format to a String
	public static String formatDate(LocalDate theDate) {
		
		String result = null;
		if (theDate != null) {
			result = theDate.toString();
		}
		return result;
		
	}

}
