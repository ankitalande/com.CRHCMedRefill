package com.CRHCMedRefill_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRHCMedRefill_pages.MsgToProvider_page;
import com.CRHCMedRefill_pages.PtVerificationScreen_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Basecls;

public class MsgToProvider_test extends Basecls {
	
	@SuppressWarnings("deprecation")
	@Test

	public void MsgRequest() throws Exception {

		ExtentTest test = extent.createTest("MsgtoProvider_test", "Message to Provider");
		test.log(Status.INFO, "Message to Provider");
		MsgToProvider_page Message = new MsgToProvider_page(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Message.setFIRST_NAME();
		Message.setLAST_NAME();
		Message.setzcode();
		Message.setcalender();
		Message.setcellphone();
		Thread.sleep(5000);
		Message.clickNextBtn(); 
		         
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
	
		driver.findElement(By.xpath("//h5[normalize-space()='What would you like to do?']")).getText();
		Message.clickMessagePro();
		Message.setSearchBox();
		Message.clickEric();
		Message.setMsgBody();
		Message.clickSaveBtn();
		String expUrl = "https://crhctestmedrefill.medevantage.com/app/home/task-success";
		Message.clickSaveBtn();
		Thread.sleep(5000);
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, expUrl);
		System.out.println("Message to Provider Sent Successfully !!!");
		Message.clickGoToHomePage();
		
		// Open Yopmail :
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.get("https://yopmail.com/en/");
		Message.clickSearchArrow();
		driver.switchTo().defaultContent(); // go back to main page
		driver.switchTo().frame("ifmail");
		Message.Email_Msg();
	}
}
