package com.CRHCMedRefill_test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CRHCMedRefill_pages.PtVerificationScreen_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testing.framework.EmailUtils;

import utility.Basecls;
import utility.Listeners_refill;

@Listeners(Listeners_refill.class)
public class OTP_test extends Basecls {

	@SuppressWarnings("deprecation")
	
	@Test
	@Parameters("browser")
	public void Verify_OTP() throws Exception {

		ExtentTest test = extent.createTest("PtVerificationScreen_test", "Patient Verification");
		test.log(Status.INFO, "Patient Verification");
		PtVerificationScreen_page Verification = new PtVerificationScreen_page(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Verification.setFIRST_NAME();
		Verification.setLAST_NAME();
		Verification.setzcode();
		Verification.setcalender();
		Verification.setcellphone();
/*		Verification.clickNextBtn();
		Thread.sleep(5000);

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
		Thread.sleep(2000);
		String ExpUrl = "https://crhctestmedrefill.medevantage.com/app/home/otp-verification";
		Verification.clickNextBtn();
		
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpUrl);
		System.out.println("OTP Verification is successfull !!! ");
		
/*		List<WebElement> text = driver.findElements(By.xpath("//h5[normalize-space()='What would you like to do?']"));
		System.out.println("");
		if (text.size() > 0) {
			System.out.println("OTP Verification is successfull !!! ");
		} else {
			System.out.println("OTP Verification is unsuccessfull !!!");
		}     */
	}
}
