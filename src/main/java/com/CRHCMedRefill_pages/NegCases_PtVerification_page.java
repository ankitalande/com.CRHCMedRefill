package com.CRHCMedRefill_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.Basecls;

public class NegCases_PtVerification_page extends Basecls {

	WebDriver driver;

	// Constructor:
	public NegCases_PtVerification_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// NO Contact details found
	By FIRST_NAME = By.xpath("//input[@name='fname']");
	By LAST_NAME = By.xpath("//input[@name='lname']");
	By zcode = By.xpath("//div[@class='col-6']//input[@id='floatingInput']");
	By cellphone = By.xpath("//input[@name='telephone']");
	By calender = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	By NextBtn = By.xpath("//button[text()='Next']");
	By GoToPatientForm = By.xpath("//*[@class='btn btn-primary px-5']");


	public void FIRST_NAME() {
		WebElement name = driver.findElement(FIRST_NAME);
		name.clear();
		name.sendKeys("Abc");
	}

	public void LAST_NAME() {
		WebElement Lname = driver.findElement(LAST_NAME);
		Lname.clear();
		Lname.sendKeys("Test Patient");		
	}

	public void calender() {
		WebElement dob = driver.findElement(calender);
		dob.clear();
		dob.sendKeys("12201974");
	}

	public void zcode() {
		WebElement code = driver.findElement(zcode);
		code.clear();
		code.sendKeys("10940");		
	}

	public void cellphone() {
		WebElement Phone = driver.findElement(cellphone);
		Phone.clear();
		Phone.sendKeys("8458888888");	
		
	}

	public void clickNextBtn() {
		driver.findElement(NextBtn).click();
		System.out.println("Clicked on: " + driver.findElement(NextBtn).getText());
	}

	public void clickGoToPatientForm() {
		driver.findElement(GoToPatientForm).click();
		System.out.println("Clicked on:Go To Patient Form button");
	}

	// NO patient record found
	By FNAME = By.xpath("//input[@name='fname']");
	By LNAME = By.xpath("//input[@name='lname']");
	By Zcode = By.xpath("//div[@class='col-6']//input[@id='floatingInput']");
	By Cellphone = By.xpath("//input[@name='telephone']");
	By Calender = By.xpath("//input[@placeholder='MM/DD/YYYY']");

	public void FNAME(String fName) {
		WebElement name = driver.findElement(FNAME);
		name.clear();
		name.sendKeys(fName);
	}

	public void LNAME(String lName) {
		WebElement name = driver.findElement(LNAME);
		name.clear();
		name.sendKeys(lName);
	}

	public void Calender(String DOB) {
		WebElement name = driver.findElement(Calender);
		name.clear();
		name.sendKeys(DOB);
	}

	public void Zcode(String ZipCode) {
		WebElement name = driver.findElement(Zcode);
		name.clear();
		name.sendKeys(ZipCode);
	}

	public void Cellphone(String PhoneNo) {
		WebElement name = driver.findElement(Cellphone);
		name.clear();
		name.sendKeys(PhoneNo);
	}
}
