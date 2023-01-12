
package com.CRHCMedRefill_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.Basecls;

public class PtVerificationScreen_page extends Basecls {

	WebDriver driver;

	// Constructor:
	public PtVerificationScreen_page(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By FIRST_NAME = By.xpath("//input[@name='fname']");
	By LAST_NAME = By.xpath("//input[@name='lname']");
	By zcode = By.xpath("//div[@class='col-6']//input[@id='floatingInput']");  
	By cellphone = By.xpath("//input[@name='telephone']");
	By calender = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	By NextBtn = By.xpath("//button[text()='Next']");
	By Text1 = By.xpath("//label[text()='Enter Your OTP']");
	By GoToPatientForm = By.xpath("//*[@class='btn btn-primary px-5']"); 

	// OTP Page:
	By Crossmark = By.xpath("//i[@class='material-icons-outlined f24 ycptbutgray']");
	By EnterName = By.xpath("//input[@id='login']");
	By SearchArrow = By.xpath("//i[@class='material-icons-outlined f36']");
	By OTPEmail = By.xpath("//span[normalize-space()='Crystal Run Patient Verification OTP']");



	public void setFIRST_NAME() {
		driver.findElement(FIRST_NAME).sendKeys("Nicole");
		System.out.println("First Name: Nicole");
	}

	public void setLAST_NAME() {
		driver.findElement(LAST_NAME).sendKeys("Test Patient");
		System.out.println("Last Name: Test Patient");
	}

	public void setcalender() {
		driver.findElement(calender).sendKeys("12292003");
		System.out.println("DOB: 12/29/2003");
	}

	public void setzcode() {
		driver.findElement(zcode).sendKeys("10940");
		System.out.println("Zip Code: 10940");
	}

	public void setcellphone() {
		driver.findElement(cellphone).sendKeys("8453132700");
		System.out.println("Home Phone: 8453132700");
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
