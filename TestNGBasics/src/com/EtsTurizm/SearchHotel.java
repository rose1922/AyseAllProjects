package com.EtsTurizm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;

public class SearchHotel extends CommonMethods{
	
	/* Open ETS tur web page "https://www.etstur.com/"
	 * search for an Hotel in izmir for the dates 10 Haziran 2020 and 30 Haziran 2020 for 2 adult and 2 children
	 * 
	 */
	
	String city="izmir";
	String[] checkInAndOutDay= {"10", "3"};
	String[] checkInAndOutMounthYear= {"Haziran 2020", "Temmuz 2020"};
	int adults=2;
	int children=2;
	int [] childAges= {6, 8};
	

	@BeforeClass
	public void openBroeser() {
		setUp("chrome", "https://www.etstur.com/");
	}
	
	@Test
	public void hotelSearch() {
		driver.findElement(By.xpath("//span[text()='OTEL']")).click();
		driver.findElement(By.id("asKeyword")).sendKeys(city);
		
		for(int i=0; i<2; i++) {
			driver.findElement(By.id("asCheckIn")).click();
			WebElement monthAndYear=driver.findElement(By.xpath("//div[@class='datepick-month-header']"));
			String mY=monthAndYear.getText();
			if(checkInAndOutMounthYear[i].equals(mY)) {
				List<WebElement> days=driver.findElements(By.xpath("//div[@class='datepick-month first']/table/tbody/tr/td"));
				for(WebElement day:days) {
					String dayValue=day.getText();
					if(dayValue.equals(checkInAndOutDay[i])) {
						day.click();
						break;
					}
				}
				break;
			}else {
				driver.findElement(By.xpath("//a[@title='Sonraki ayı göster']")).click();
			}
		}
		
		// enter the numbers of adults and children
		driver.findElement(By.xpath("")).click();
		
		String defValAdult=driver.findElement(By.id("asAdults")).getAttribute("value");
		int numberOFAdult=Integer.parseInt(defValAdult);
		if(adults<numberOFAdult) {
			while(adults<numberOFAdult) {
				driver.findElement(By.xpath("//div[@id='addGuests']/div/button[2]")).click();
				adults++;
			}
		}else if (adults>numberOFAdult) {
			while(adults>numberOFAdult) {
				driver.findElement(By.xpath("//div[@id='addGuests']/div/button[1]")).click();
				adults--;
			}
		}
		
		
		String defValChildren=driver.findElement(By.id("asChildren")).getAttribute("value");
		int numberOfChildren=Integer.parseInt(defValChildren);
		if(children<numberOfChildren) {
			while(children<numberOfChildren) {
				driver.findElement(By.xpath("//div[@id='addGuests']/div[2]/button[2]")).click();
				children++;
				if(children==1) {
					WebElement childAge=driver.findElement(By.id("sChildAge0"));
				}
			}
		}else if (children>numberOfChildren) {
			while(children>numberOfChildren) {
				driver.findElement(By.xpath("//div[@id='addGuests']/div[2]/button[1]")).click();
				children--;
			}
		}
		
		
		
		
		
		
		
	}
}
