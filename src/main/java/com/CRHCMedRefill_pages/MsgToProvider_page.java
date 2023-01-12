package com.CRHCMedRefill_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.Basecls;

public class MsgToProvider_page extends Basecls {
		
	// Enter patient details
	By FIRST_NAME = By.xpath("//input[@name='fname']");
	By LAST_NAME = By.xpath("//input[@name='lname']");
	By zcode = By.xpath("//div[@class='col-6']//input[@id='floatingInput']"); 
	By cellphone = By.xpath("//input[@name='telephone']");
	By calender = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	By NextBtn = By.xpath("//button[text()='Next']");
	
	// Send Message to Provider:
	By MessagePro = By.xpath("//button[text()='Message Your Provider']");
	By SearchBox = By.xpath("//input[@aria-autocomplete='list']");
	By Eric = By.xpath("//p[text()='  Eric Barbanel MD ']");                                  
	By Cross = By.xpath("//i[@class='fa fa-times']");
	By MsgBody = By.xpath("//textarea[contains(@name,'messageBody')]");  
	By SaveBtn = By.xpath("//button[text()='Submit']");
	By GoBack = By.xpath("//button[text()='Go Back']");
	By GoToHomePage = By.xpath("//button[text()='Go To Home Page']");  
	
	//Opening Yopmail:
	By EnterName = By.xpath("//input[@id='login']");
	By SearchArrow = By.xpath("//i[@class='material-icons-outlined f36']");
	By MsgEmail = By.xpath("//span[.='no-reply@crystalrunhealthcare.com']");
	By Email_Msg = By.xpath("//div[@class='ellipsis nw b f18']");
	
	
	
	
	public MsgToProvider_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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
		System.out.println("Patient Details added and Verified Successfully !!!");
	}
		
	
	// Send Message to Provider:
	public void clickMessagePro() {
		driver.findElement(MessagePro).click();
		 System.out.println("Message to Provider option selected");
	}
	
	public void setSearchBox() {
		WebElement text1 = driver.findElement(SearchBox);
		text1.click();
		text1.sendKeys("Eri");
	}
	
	public void clickEric() {
		driver.findElement(Eric).click();
	}
	
	public void clickCross() {
		driver.findElement(Cross).click();
	}
	
	public void setMsgBody() {
		driver.findElement(MsgBody).sendKeys("Test Message to Provider for Testing purpose.!!!");
		System.out.println("Message Added: Test Message to Provider for Testing purpose.!!!");
	}
	
	public void clickSaveBtn() {
		driver.findElement(SaveBtn).click();
		System.out.println("Clicked on: "+driver.findElement(SaveBtn).getText());
	}
	
	public void clickGoBack() {
		driver.findElement(GoBack).click();
	}
	
	public void clickGoToHomePage() {
		driver.findElement(GoToHomePage).click();           
	}	
	
	
	// Open Yopmail	
	public void setEnterName() {
		driver.findElement(EnterName).sendKeys("Aditya");
	}
	
	public void clickSearchArrow() {
		driver.findElement(SearchArrow).click();
	}
	
	public void clickMsgEmail() {
		driver.findElement(MsgEmail).click();
	}
	
	public void Email_Msg() {
		System.out.println(driver.findElement(Email_Msg).getText());
		System.out.println("Email for Message to Provider received Sussessfully!!!");
	}
}
