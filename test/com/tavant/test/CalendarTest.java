package com.tavant.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalendarTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Calendar calendar = new GregorianCalendar(2011,10,04,12,10,10);
		System.out.println(calendar.get(Calendar.YEAR));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:MM:SS");
		System.out.println(dateFormat.format(calendar.getTime()));
	}

}
