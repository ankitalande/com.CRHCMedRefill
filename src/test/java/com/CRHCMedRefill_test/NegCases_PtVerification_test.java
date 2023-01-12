package com.CRHCMedRefill_test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRHCMedRefill_pages.NegCases_PtVerification_page;
import com.CRHCMedRefill_pages.PtVerificationScreen_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Basecls;
import utility.Utils_excel;

public class NegCases_PtVerification_test extends Basecls {

	@DataProvider(name = "PatientVerification")
	public String[][] getData() throws IOException {

		// Get Data from Excel:

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\Data_Excel\\\\DataSheet.xlsx";
		Utils_excel utils = new Utils_excel(path);
		int totalrows = utils.getRowCount("LoginDetails");
		int totalcols = utils.getCellCount("LoginDetails", 1);
		String loginData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = utils.getCellData("LoginDetails", i, j);
			}
		}
		return loginData;
	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "PatientVerification")

	public void Verification1(String fName, String lName, String DOB, String ZipCode, String PhoneNo, String Result)
			throws Exception {

		ExtentTest test = extent.createTest("Wrong Data Entered", "Patient Verification");
		test.log(Status.INFO, "Patient Verification");
		NegCases_PtVerification_page Verification = new NegCases_PtVerification_page(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Verification.FNAME(fName);
		Verification.LNAME(lName);
		Verification.Calender(DOB);
		Verification.Zcode(ZipCode);
		Verification.Cellphone(PhoneNo);
		String expUrl = "https://medrefill.medevantage.com/app/home/patient-verification";
		Verification.clickNextBtn();
		Thread.sleep(5000);

		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, expUrl);
		System.out.println("Patient record not found !!!");    
		System.out.println("***Patient match unsuccessfull !!!***");
		Verification.clickGoToPatientForm();
	}

	@Test(priority = 1)

	public void Verification2() throws Exception {

		ExtentTest test = extent.createTest("No Contact Details Found", "Patient Verification");
		test.log(Status.INFO, "Patient Verification");

		NegCases_PtVerification_page Verification = new NegCases_PtVerification_page(driver);

		Verification.FIRST_NAME();
		Verification.LAST_NAME();
		Verification.zcode();
		Verification.calender();
		Verification.cellphone();
		String expUrl = "https://medrefill.medevantage.com/app/home/patient-verification";
		Verification.clickNextBtn();
		Thread.sleep(8000);

		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, expUrl);
		System.out.println("Patient contact details not found !!!"); 
		System.out.println("***No Cell phone number and Email is not linked with account !!!***");
		Verification.clickGoToPatientForm();
	}
}
