package com.CRHCMedRefill_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRHCMedRefill_pages.PtVerificationScreen_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Basecls;
import utility.Listeners_refill;

@Listeners(Listeners_refill.class)
public class PtVerificationScreen_test extends Basecls {
	
	@Test

	public void Verification() throws Throwable
	{
		ExtentTest test = extent.createTest("PtVerificationScreen_test", "Patient Verification");
		test.log(Status.INFO, "Patient Verification");
		PtVerificationScreen_page Verification = new PtVerificationScreen_page(driver);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 

		Verification.setFIRST_NAME(); 
		Verification.setLAST_NAME(); 
		Verification.setzcode();
		Verification.setcalender();
		Verification.setcellphone();
		String expTitle = "https://crhctestmedrefill.medevantage.com/app/home/otp-verification";		
		Verification.clickNextBtn();
		Thread.sleep(5000);
		String actualTitle = driver.getCurrentUrl();
		Assert.assertEquals(actualTitle, expTitle);
		System.out.println("OTP sent successfully !!! ");
		System.out.println("Patient match successful !!!");
		
	/*	List<WebElement> screen = driver.findElements(By.xpath("//label[normalize-space()='Enter Your OTP']"));
		System.out.println("");
		if (screen.size() > 0) {			 
			System.out.println("Patient match successful !!!");
			System.out.println("OTP sent successfully !!! ");
		} else {
			System.out.println("");
			System.out.println("Patient match unsuccessful !!!");
			Verification.clickGoToPatientForm();  */
		}
	}
//}
