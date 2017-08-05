package com.autobusi.fcalendar;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.autobusi.fcalendar.util.LunarCalendar;

public class JUnitLunarCalendarTest {

	@Test
	public void testGetChinaDayString() {
		Calendar cal = Calendar.getInstance();
		for(int i = 1; i<=31; i++){
			cal.set(Calendar.YEAR, 2049);
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			cal.set(Calendar.DATE, i);
			LunarCalendar lc = new LunarCalendar(cal);
			System.out.println(lc.getChinaMonthDayString());
			System.out.println(lc.animalsYear());
			System.out.println(lc.cyclical());
			System.out.println(lc.toString());
		}
		
	}

}
