package com.CRHCMedRefill_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRHCMedRefill_pages.MedRefill_page;
import com.CRHCMedRefill_pages.MsgToProvider_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Basecls;
import utility.Listeners_refill;

@Listeners(Listeners_refill.class)
public class MedRefill_test extends Basecls { 
	
	@SuppressWarnings("deprecation")
	@Test

	public void Refill_Req() throws Exception {

		ExtentTest test = extent.createTest("MedRefill_test", "Medication Reill Request");
		test.log(Status.INFO, "Medication Reill Request");
		MedRefill_page Refill = new MedRefill_page(driver);
		MsgToProvider_page Message = new MsgToProvider_page(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		Message.setFIRST_NAME();
		Message.setLAST_NAME();
		Message.setzcode();
		Message.setcalender();
		Message.setcellphone();
		Thread.sleep(2000);
		Message.clickNextBtn(); 
		Thread.sleep(2000);
		         
		// OTP Verification
		System.out.println("+++++ OTP Verification +++++");
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));  

		// Open Yopmail
		driver.get("https://yopmail.com/en/");
		Message.setEnterName();
		Message.clickSearchArrow();
		driver.switchTo().frame("ifmail");    
		WebElement OTP = driver
				.findElement(By.xpath("//span[contains(text(),'Your Medevantage OTP Service verification code is:')]"));
		System.out.println(OTP.getText());
		String otp = OTP.getText();
		String num = otp.replaceAll("[^\\d]+", " ");
		System.out.println("OTP is: " + num);
		for (int i = 1; i <= 6; i++) {
			char n = num.charAt(i);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath(
					"/html/body/app-root/div/app-layout/section/app-patienttask/div/div[2]/div/div/div[2]/app-otpverification/form/div[1]/div[2]/input["
							+ i + "]"))
					.sendKeys(Character.toString(n));
		}
		Message.clickNextBtn();
		System.out.println("Patient details and OTP verified Successfully !!!!");
		
		Refill.TEXT();
		Refill.clickReqRefillBtn();
		Refill.MedListPage();
		Refill.clickMed1Name();
		Refill.setMed1Comment();
		Refill.clickSaveCommentBtn();
		Refill.clickMed2();
		Refill.clickReqBtn1();
		Refill.ViewMedPage();
		Refill.clickReqBtn2();
		Thread.sleep(2000);
		String acturl = "https://medrefill.medevantage.com/app/home/task-success";
		Refill.SentMsg(); 
		
		String expectedurl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, expectedurl);
                                                                                                                                                            		
		//Open Yopmail : 
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));		  
//		driver.get("https://yopmail.com/en/");
//		Refill.clickSearchArrow();				
		driver.switchTo().defaultContent();     		
		driver.switchTo().frame("ifmail");		
		Refill.Email_Refill();
	}
}
