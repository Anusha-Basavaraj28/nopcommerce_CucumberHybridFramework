package com.demo.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.demo.Utitilies.WaitHelper;

public class SearchCustomer {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	
	public SearchCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
	}

	@FindBy(how=How.ID,using = "SearchEmail")
	WebElement Email;
	@FindBy(how=How.ID,using = "SearchFirstName")
	WebElement firstNmae;
	@FindBy(how=How.ID,using = "SearchLastName")
	WebElement lastName;
	
	
	@FindBy(how=How.ID,using = "SearchMonthOfBirth")
	WebElement monthOfBirth;
	@FindBy(how=How.ID,using = "SearchDayOfBirth")
	WebElement dayOfBirth;
	
	
	
	@FindBy(how=How.ID,using = "SearchRegistrationDateFrom")
	WebElement registrationDateFrom;
	
	@FindBy(how=How.ID,using = "SearchRegistrationDateTo")
	WebElement registrationDateTo;
	
	@FindBy(how=How.ID,using = "SearchLastActivityFrom")
	WebElement lastActivityFrom;
	
	@FindBy(how=How.ID,using = "SearchLastActivityTo")
	WebElement lastActivityTo;
	

	@FindBy(how=How.ID,using = "SearchCompany")
	WebElement companyName;
	
	@FindBy(how=How.ID,using = "SearchIpAddress")
	WebElement IpAddress;
	
	
	
	@FindBy(how=How.ID,using = "search-customers")
	WebElement searchButton;
	
	
	
	@FindBy(how=How.ID,using = "customers-grid")
	WebElement table;
	
	
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']//tbody//tr")
	List<WebElement> rows;
	
	@FindBy(how=How.XPATH,using = "//table[@id='customers-grid']//tbody//tr//td")
	List<WebElement> columns;
	
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void setfirstName(String fname) {
		firstNmae.sendKeys(fname);
	}
	
	public void setlastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	
	public void clickSearch() throws InterruptedException {
		searchButton.click();
		
		Thread.sleep(3000);
	}
	
	public boolean getStatus(String email) {
	    boolean status = false;
		for(int i=0;i<rows.size();i++) {
			for(WebElement c:columns) {
				waitHelper.waitForElement(c, Duration.ofSeconds(30));
				System.out.println("%%%%%%%%%%%%%%%%%%%%"+c.getText());
				if(c.getText().equals(email))
					
				{
					System.out.println("%%%%%%%%%%%%%%%%%%%%"+c.getText());
					status=true;
					break;
					
				}
			}
		}
		return status;
		
	}
	
	
	
	public boolean getStatusFromName(String fname,String lname) {
	    boolean status = false;
		for(int i=0;i<rows.size();i++) {
			for(WebElement c:columns) {
				waitHelper.waitForElement(c, Duration.ofSeconds(30));
				System.out.println("%%%%%%%%%%%%%%%%%%%%"+c.getText());
				if(c.getText().equals(fname+" "+lname))
					
				{
					System.out.println("%%%%%%%%%%%%%%%%%%%%"+c.getText());
					status=true;
					break;
					
				}
			}
		}
		return status;
		
	}
	
	
}
