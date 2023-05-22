package com.demo.StepDefinitions;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.PageObjects.AddNewCustomerPage;
import com.demo.PageObjects.SearchCustomer;
import com.demo.PageObjects.loginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseClass {
	
	@Before
	public void setUp() {
		
		logger=Logger.getLogger("nopCommerce"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");
		
		
		try {
			FileInputStream fi=new FileInputStream(".//configurations//config.properties");
		    pro=new Properties();
			pro.load(fi);
			String br=pro.getProperty("browser");
			
			if(br.equals("chrome"))
				driver=new ChromeDriver();
			if(br.equals("edge"))
				driver=new EdgeDriver();
			if(br.equals("firefox"))
				driver=new FirefoxDriver();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	    logger.info("User launch the browser");
		
	}
	
	@Given("User launch the browser")
	public void user_launch_the_browser() {
		
		lp=new loginPage(driver);
		
	}
	@When("user opens the URL {string}")
	public void user_opens_the_url(String url) {
		logger.info("user opens the URL");
		driver.get(url);
	    
	}
	
	@And("user enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String pwd) {
		//lp=new loginPage(driver);
		
		logger.info("user enters email  and password ");
		lp.setEmail(email);
		lp.setpassword(pwd);
	}
	
	
	@And("user clicks login button")
	public void user_clicks_login_button() {
		logger.info("user clicks login button");
		lp.clickLogin();
	}
	
	
	@Then("user should navigated to home page and title should be {string}")
	public void user_should_navigated_to_home_page_and_title_should_be(String expectedTitle) {
		
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info(" Login was unsuccessful");
			driver.close();
			Assert.assertTrue(false);
			
		}
		else {
		String actualTitle=driver.getTitle();
		System.out.println("************"+actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info("user navigated to home page");
	}
	}
	
	@When("user clicks on Logout button")
	public void user_clicks_on_logout_button() {
		logger.info("user clicks on Logout button");
		lp.clickLogout();
	}
	
	@Then("user navigated to login page and title of the page should be {string}")
	public void user_navigated_to_login_page_and_title_of_the_page_should_be(String expectedLPTitle) {
		
		logger.info("user navigated to login page ");
		String actualLPTitle=driver.getTitle();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@"+actualLPTitle);
		Assert.assertEquals(expectedLPTitle, actualLPTitle);
	}
	
	
	@And("close the browser")
	public void close_the_browser() {
		logger.info("close the browser ");
		driver.close();
	}
	
	// customer feature step definitions
	
	@When("user clicks on Customer menu")
	public void user_clicks_on_customer_menu() {
		logger.info("user clicks on Customer menu ");
		cp=new AddNewCustomerPage(driver);
		cp.clickCustomerMenu();
	    
	}
	
	@When("user clicks on customer menu item")
	public void user_clicks_on_customer_menu_item() {
		logger.info("user clicks on customer menu item ");
	    cp.clickCustomerMenuItem();
	}
	
	@When("user click on Add new button")
	public void user_click_on_add_new_button() {
		logger.info("user click on Add new button ");
	    cp.clickAddNew();
	}
	
	@Then("user shuld view the Add new customer page")
	public void user_shuld_view_the_add_new_customer_page() {
	   if(driver.getPageSource().contains("Add a new customer")) {
		   logger.info("user  view the Add new customer page ");
		   Assert.assertTrue(true);
	   }
	   else {
		   logger.info("user dont view the Add new customer page ");
		   Assert.assertTrue(false);
	   }
	}
	
	@When("user enters customer details")
	public void user_enters_customer_details() throws InterruptedException {
		logger.info("user enters customer details ");
		logger.info("user enters email ID");
	    cp.setEmail(BaseClass.generateEmail()+"@gmail.com");
	    logger.info("user enters passwrd");
	    cp.setPwd("123");
	    logger.info("user enters customer first name");
	    cp.setFirtsName("Anusha");
	    logger.info("user enters customer last name");
	    cp.setLastName("B");
	    logger.info("user enters customer gender");
	    cp.setGender("female");
	    logger.info("user enters customer DOB");
	    cp.setDOB("6/28/1988");
	    logger.info("user enters company name");
	    cp.setCompanyName("ABC");
	    
	    cp.setTax();
	    cp.setNewsLetter("Your store name");
	    String[] cr={"Administrators","Vendors"};
	    cp.setCustomerRoles(cr);
	    logger.info("user selects vender");
	    cp.setVendor("Vendor 1");
	    cp.setActive();
	    logger.info("user enters comment");
	    cp.setAdminComment("Anusha has been added");
	    
	}
	@When("user clicks on Save button")
	public void user_clicks_on_save_button() {
		logger.info("user clicks on Save button");
	    cp.clickSave();
	}
	@Then("user should see the confirmation message {string}")
	public void user_should_see_the_confirmation_message(String string) {
	    if(driver.getPageSource().contains("The new customer has been added successfully.")) {
	    	logger.info("The new customer has been added successfully.");
	    	Assert.assertTrue(true);
		   }
		   else {
			   logger.info("The new customer not added");
			   Assert.assertTrue(false);
		   }
	}

	// steps for searching customer using email id
	
	
	@When("user enters customer email")
	public void user_enters_customer_email() {
		logger.info("user enters customer email to search");
		sc=new SearchCustomer(driver);
		sc.setEmail("SkUfh0X7@gmail.com");
		//sc.setfirstName("Anusha");
		//sc.setlastName("B");
	    
	}
	@When("user clicks on the search button")
	public void user_clicks_on_the_search_button() throws InterruptedException {
		logger.info("user clicks on the search button");
		sc.clickSearch();
		
	    
	}
	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		
	   Assert.assertTrue( sc.getStatus("SkUfh0X7@gmail.com"));
	   logger.info("user  found email in the search table");
		
	}
	
	// steps for searching customer using First name and last name
	
	@When("user enters customer First name and last name")
	public void user_enters_customer_first_name_and_last_name() {
		logger.info("user enters customer First name and last name");
		sc=new SearchCustomer(driver);
		sc.setfirstName("Anusha");
		sc.setlastName("B");
	}
	
	@Then("user should found First name and last name in the search table")
	public void user_should_found_first_name_and_last_name_in_the_search_table() {
		Assert.assertTrue( sc.getStatusFromName("Anusha","B"));
		logger.info("user  found First name and last name in the search table");
	}

}
