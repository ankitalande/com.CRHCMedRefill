package com.CRHCMedRefill_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsing {
	
	public static WebDriver driver;
	@Test
	@Parameters("browser")
	public void LaunchUrl(String browserName) {
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\eclipse-workspace\\com.CRHCMedRefill\\src\\main\\resources\\Drivers\\chromedriver.exe");		
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\lenovo\\eclipse-workspace\\com.CRHCMedRefill\\src\\main\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\lenovo\\eclipse-workspace\\com.CRHCMedRefill\\src\\main\\resources\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		
		driver.get("https://crhctestmedrefill.medevantage.com/");    //("https://crhctestmedrefill.medevantage.com/");
		driver.manage().window().maximize();
		driver.quit();	
	}

}
