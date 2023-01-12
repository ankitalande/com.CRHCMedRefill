package com.CRHCMedRefill_test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRHCMedRefill_pages.NoMedListed_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testing.framework.EmailUtils;

import utility.Basecls;

public class NoMedListed_test extends Basecls {
	@Test
	@SuppressWarnings("deprecation")
	public void Medrefill() throws Exception {

		ExtentTest test = extent.createTest("MedRefill_NegTest", "Empty Medication List");
		test.log(Status.INFO, "MedRefill_NegTest");
		NoMedListed_page refill = new NoMedListed_page(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		refill.setFIRST_NAME();
		refill.setLAST_NAME();
		refill.setzcode();
		refill.setcalender();
		refill.setcellphone();
/*		refill.clickNextBtn();
		System.out.println("Patient Details added and Verified Successfully !!!");
		Thread.sleep(5000);

//		String OTP;
		EmailUtils emailUtils = new EmailUtils();
		Properties prop = new Properties();
		prop.setProperty("to", "testellen471@gmail.com");
		prop.setProperty("gmail_from", "support@medevantage.com");
		prop.setProperty("gmail_username", "testellen471@gmail.com");
		prop.setProperty("gmail_password", "jrhvcpwnwatrqyej");
		prop.setProperty("gmail_port", "587");

		@SuppressWarnings("unchecked")
		List<String> emailText = emailUtils.getUnreadMessageByFromEmail(emailUtils.connectToGmail(prop), "Inbox",
				"support@medevantage.com", "Your Medevantage verification code is");

		if (emailText.size() < 1)
			throw new Exception("NO OTP RECEIVED");
		else {
			String otp = emailText.get(0);
			String num = otp.replaceAll("[^\\d]+", ":");
			System.out.println("OTP is: " + num);
			

			for (int i = 1; i <= 6; i++) {
				char n = num.charAt(i);
				driver.findElement(By.xpath(
						"/html/body/app-root/div/app-layout/section/app-patienttask/div/div[2]/div/div/div[2]/app-otpverification/form/div[1]/div[2]/input["
								+ i + "]"))
						.sendKeys(Character.toString(n));
			}
		}
		refill.clickNextBtn();
		System.out.println("Patient details and OTP verified Successfully !!!!");
		driver.findElement(By.xpath("//h5[normalize-space()='What would you like to do?']")).getText();
		String expUrl = "https://crhctestmedrefill.medevantage.com/app/home/med-refill";		
		refill.clickReqRefillBtn();
		refill.MedListPage();
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, expUrl);
		refill.NoMed();    */
	}
}
