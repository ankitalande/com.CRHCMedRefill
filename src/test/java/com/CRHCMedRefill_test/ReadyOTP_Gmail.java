package com.CRHCMedRefill_test;

import java.util.List;
import java.util.Properties;
import org.testng.annotations.Test;

import com.testing.framework.EmailUtils;

public class ReadyOTP_Gmail {
	@Test

	public void ReadOTP() throws Exception {
		String OTP;

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
			String regex = "[^\\d]+";
			String[] arrOTP = emailText.get(0).split(regex);
			OTP = arrOTP[1];
			System.out.println("OTP is " + OTP); 
		}
	}
}
