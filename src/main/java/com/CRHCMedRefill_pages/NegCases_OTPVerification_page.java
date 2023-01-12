package com.CRHCMedRefill_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NegCases_OTPVerification_page {

	WebDriver driver;

	By GoBtn = By.xpath("//button[normalize-space()='Go']");
	By FIRST_NAME = By.xpath("//input[@name='fname']");
	By LAST_NAME = By.xpath("//input[@name='lname']");
	By zcode = By.xpath("//div[@class='col-6']//input[@id='floatingInput']");
	By cellphone = By.xpath("//input[@name='telephone']");
	By calender = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	By Text1 = By.xpath("//label[text()='Enter Your OTP']");

	By Crossmark = By.xpath("//i[@class='material-icons-outlined f24 ycptbutgray']");
	By EnterName = By.xpath("//input[@id='login']");
	By SearchArrow = By.xpath("//i[@class='material-icons-outlined f36']");
	By OTPEmail = By.xpath("//span[normalize-space()='Crystal Run Patient Verification OTP']");
	By NextBtn = By.xpath("//button[text()='Next']");
	By GoToPatientForm = By.xpath("//*[@class='btn btn-primary px-5']");
		

	public NegCases_OTPVerification_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void clickGoBtn() {
		driver.findElement(GoBtn).click();
	}	
	
	public void setFIRST_NAME() {
		WebElement name = driver.findElement(FIRST_NAME);
		name.clear();
		name.sendKeys("Nicole");
		System.out.println("Entered first name: Nicole");
	}

	public void setLAST_NAME() {
		driver.findElement(LAST_NAME).sendKeys("Test Patient");
		System.out.println("Entered last name: Test Patient");
	}

	public void setcalender() {
		driver.findElement(calender).sendKeys("12292003");
		System.out.println("Entered DOB: 12/29/2003");
	}

	public void setzcode() {
		driver.findElement(zcode).sendKeys("10940");
		System.out.println("Entered Zip Code: 10940");
	}

	public void setcellphone() {
		driver.findElement(cellphone).sendKeys("8453132700");
		System.out.println("Entered Phone number: 8453132700");
	}
	
	public void clickNextBtn() {
		driver.findElement(NextBtn).click();
		System.out.println("Clicked on Next Button");
	}	
	
	public void clickGoToPatientForm() {
		driver.findElement(GoToPatientForm).click();
	}
	
	// OTP screen

	public void clickCrossmark() {
		driver.findElement(Crossmark).click();
	}

	public void setEnterName() {
		driver.findElement(EnterName).sendKeys("Emma12");
	}

	public void clickSearchArrow() {
		driver.findElement(SearchArrow).click();
	}

	public void clickOTPEmail() {
		driver.findElement(OTPEmail).click();
	}
}
