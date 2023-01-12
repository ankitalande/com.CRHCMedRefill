package com.CRHCMedRefill_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.Basecls;

public class NoMedListed_page extends Basecls{
	
	public NoMedListed_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	// Enter patient details
	By FIRST_NAME = By.xpath("//input[@name='fname']");
	By LAST_NAME = By.xpath("//input[@name='lname']");
	By zcode = By.xpath("//div[@class='col-6']//input[@id='floatingInput']"); 
	By cellphone = By.xpath("//input[@name='telephone']");
	By calender = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	By NextBtn = By.xpath("//button[text()='Next']");
	
	
	// Med Refill Request
	By ReqRefillBtn = By.xpath("//button[normalize-space()='Request Prescription Refill']");
	By MedListPage = By.xpath("//h5[text()='Prescription Refill'] ");
	By NoMed = By.xpath("//span[@class='text-info font-1_rem']");
	
	// Enter patient details
	public void setFIRST_NAME() {
		driver.findElement(FIRST_NAME).sendKeys("Nicole");
	}

	public void setLAST_NAME() {
		driver.findElement(LAST_NAME).sendKeys("Test Patient");
	}

	public void setcalender() {
		driver.findElement(calender).sendKeys("12292003");
	}

	public void setzcode() {
		driver.findElement(zcode).sendKeys("10940");
	}

	public void setcellphone() {
		driver.findElement(cellphone).sendKeys("8453132700");
	}

	public void clickNextBtn() {
		driver.findElement(NextBtn).click();
		System.out.println("Clicked on Next Button");
	}
	
	public void clickReqRefillBtn() {
		driver.findElement(ReqRefillBtn).click();
	}

	public void MedListPage() {
		System.out.println(driver.findElement(MedListPage).getText() + " page is Displayed");
	}
	
	public void NoMed() {
		System.out.println(driver.findElement(NoMed).getText());
	}
}
