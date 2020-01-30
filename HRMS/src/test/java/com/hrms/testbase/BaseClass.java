package com.hrms.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass{

	public static WebDriver driver;
	
	public static ExtentHtmlReporter html;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest(alwaysRun=true)
	
	public void generateReport() {
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		html=new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		html.config().setTheme(Theme.STANDARD);
		html.config().setDocumentTitle("Syntax HRMS Testing Report");
		html.config().setReportName("HRMS Testing Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("QA Engineer", Constants.USER_NAME);
		report.setSystemInfo("Environment",  Constants.OS_NAME);
		report.setSystemInfo("Browser",  ConfigsReader.getProperty("browser"));
		
	}
	
	@AfterTest(alwaysRun=true)
	public void writeReport() {
		report.flush();
	}
	
	/**
	 * Use this method in need of opening browser and target url
	 * @param browser The desired browser
	 * @param url	 The desired url
	 */

	
	@BeforeMethod (alwaysRun=true)
	public void setUp() {
		
		Properties configs=ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		
		switch(configs.getProperty("browser").toLowerCase()) {
		
		case"chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver=new ChromeDriver();
			break;
		case"firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
			break;
		default:
			System.err.println("Browser is not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME,  TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(configs.getProperty("url"));		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
			driver.quit();		
	}
}
