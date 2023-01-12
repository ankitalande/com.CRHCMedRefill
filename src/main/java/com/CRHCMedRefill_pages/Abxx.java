package com.CRHCMedRefill_pages;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


import org.json.JSONML;
import org.testng.annotations.Test;

import com.testing.framework.EmailUtils;

public class Abxx {
	@Test
	public void getGmailData(String query)throws Exception {
		
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
			JSONML jp = new JSONML();
			String subject = jp.toString();
			String body = new String(Base64.getDecoder().decode(jp.toString()));
			String link = null;
			String arr[] = body.split("\n");
			for (String s : arr) {
				s = s.trim();
				if (s.startsWith("http")) {
					link = s.trim();
				}
				
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("subject", subject);
				hm.put("body", body);
				hm.put("link", link);
				return;
			}
			
			
			String num = otp.replaceAll("[^\\d]+", ":");
			System.out.println("OTP is: " + num);
		}
		}
	}
