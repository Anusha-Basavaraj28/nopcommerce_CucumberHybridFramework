package com.demo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "Email")
	@CacheLookup
	WebElement Email;

	@FindBy(how = How.ID, using = "Password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(how = How.LINK_TEXT, using = "Logout")
	@CacheLookup
	WebElement logoutButton;

	public void setEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}

	public void setpassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickLogout() {
		logoutButton.click();
	}

}
