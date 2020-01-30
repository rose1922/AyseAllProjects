package com.Deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver dr=new ChromeDriver();
		
		dr.get("https://www.udemy.com/?utm_source=adwords-brand&utm_medium=udemyads&utm_campaign=Brand-Udemy_la.EN_cc.US&utm_term=_._ag_78616515599_._ad_389436697904_._de_c_._dm__._pl__._ti_kwd-310556426868_._li_9027793_._pd__._&utm_term=_._pd__._kw_udemy_._&matchtype=e&gclid=EAIaIQobChMIt5CQi8vh5gIVjIbACh1slwsAEAAYASAAEgKPVPD_BwE");
		System.out.println(dr.getTitle());
		

		
		
		
	}
}
