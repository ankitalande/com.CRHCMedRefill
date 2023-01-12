package com.CRHCMedRefill_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.Basecls;

public class MedRefill_page extends Basecls {
	
	public MedRefill_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Med Refill Request
	By ReqRefillBtn = By.xpath("//button[normalize-space()='Request Prescription Refill']");
	By TEXT = By.xpath("//h5[normalize-space()='What would you like to do?']");
	By MedListPage = By.xpath("//h5[text()='Prescription Refill'] ");
	By Med1Name = By.xpath("//div[@title='MS CONTIN']"); // medicine name
	By Med1 = By.xpath("//input[@id='medicationlbl2']"); // checkbox
	By Med1Comment = By.xpath("//textarea[@auto-grow='false']"); // med comment
	By SaveCommentBtn = By.xpath("//button[text()='Save']"); // save btn
	By CancelBtn = By.xpath("//button[text()='Cancel']"); // cancel btn
	By Med2name = By.xpath("//div[@title='MACROBID']"); // name
	By Med2 = By.xpath("//input[@id='medicationlbl3']"); // checkbox
	By ReqBtn1 = By.xpath("//button[@class='btn btn-primary btn-sm px-5 m-1']"); // req refill btn with 0 refill
	By ReqBtn2 = By.xpath("//button[@class='btn btn-primary btn-sm px-5 m-1']"); // req refill btn with 2 refill
	By ViewMedPage = By.xpath("//h5[text()='Verify Prescription Refill Details']"); // heading for verify pre-refill
	By SentMsg = By.xpath("//h3[text()='Sent Successfully!']");
	By GoToHomePage = By.xpath("//button[text()='Go To Home Page']");
	By HomePage = By.xpath("//p[@class='m-0']"); // patient servies page title

	// Med Email Page:

	By Crossmark = By.xpath("//i[@class='material-icons-outlined f24 ycptbutgray']");
	By EnterName = By.xpath("//input[@id='login']");
	By SearchArrow = By.xpath("//i[@class='material-icons-outlined f36']");
	By RefillEmail = By
			.xpath("//div[@class='lms'][contains(text(),'RE: Your Crystal Run Web Prescription Refill Reque')]");
	By Email_Refill = By.xpath("//div[@class='ellipsis nw b f18']");


	
	
	public void clickReqRefillBtn() {
		driver.findElement(ReqRefillBtn).click();
	}
	
	public void TEXT() {
		System.out.println(driver.findElement(TEXT).getText());
		}

	public void MedListPage() {
		System.out.println(driver.findElement(MedListPage).getText() + " Displayed");
	}

	public void clickMed1Name() {
		driver.findElement(Med1Name).click();
		System.out.println("Med_1: " + driver.findElement(Med1Name).getText());
	}

	public void setMed1Comment() {
		WebElement Btn = driver.findElement(Med1Comment);
		Btn.click();
		Btn.sendKeys("Med1 added for Testing puropse. Please Ignore.");
	}

	public void clickSaveCommentBtn() {
		driver.findElement(SaveCommentBtn).click();
	}

	public void clickMed2() {
		driver.findElement(Med2).click();
		System.out.println("Med_2: " + driver.findElement(Med2name).getText());
	}

	public void clickReqBtn1() {
		driver.findElement(ReqBtn1).click();
	}

	public void ViewMedPage() {
		System.out.println(driver.findElement(ViewMedPage).getText());
	}

	public void clickReqBtn2() {
		driver.findElement(ReqBtn2).click();
	}

	public void SentMsg() {
		System.out.println("Medication refill Request: " + driver.findElement(SentMsg).getText());
	}

	// Med Email
	public void clickCrossmark() {
		driver.findElement(Crossmark).click();
	}

	public void clickSearchArrow() {
		driver.findElement(SearchArrow).click();
	}

	public void clickRefillEmail() {
		driver.findElement(RefillEmail).click();
	}

	public void Email_Refill() {
		System.out.println(driver.findElement(Email_Refill).getText());
		System.out.println("Email for Precription refill received Sussessfully!!!");
	}

}
