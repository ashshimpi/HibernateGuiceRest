package com.org;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeDemo {
	public static void main(String[] args)
	{
		//LocalDate d= LocalDate.now();
		//LocalDate d= LocalDate.of(1997, Month.JANUARY,25);
		//System.out.println(d);
		
//		LocalTime t=LocalTime.now();
//		System.out.println(t);
		
		LocalDateTime dt=LocalDateTime.now();
		System.out.println(dt);
	}

}
