package com.practices;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class TimeStamp {

	@Test
	public void getTime() {
		Date date=new Date();
		System.out.println(date.getTime());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String formattedDate=sdf.format(date.getTime());
		System.out.println(formattedDate);
	}
}
