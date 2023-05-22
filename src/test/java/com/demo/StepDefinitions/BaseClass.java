package com.demo.StepDefinitions;


import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.demo.PageObjects.AddNewCustomerPage;
import com.demo.PageObjects.SearchCustomer;
import com.demo.PageObjects.loginPage;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	
	WebDriver driver;
	loginPage lp;
	AddNewCustomerPage cp;
	SearchCustomer sc;
	
	public static Logger logger;
	public Properties pro;
	
	
	// created for generating random string for unique emailId
	public static String generateEmail() {
		return RandomString.make(8);
	}

}
