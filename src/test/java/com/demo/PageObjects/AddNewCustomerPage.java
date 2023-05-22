package com.demo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
	WebDriver driver;
	
	public AddNewCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By customer_menu=By.xpath("(//li[@class='nav-item has-treeview'])[4]");
	By customer_item=By.xpath("(//li[@class='nav-item has-treeview menu-is-opening menu-open']//ul//li)[1]");
	By addNew=By.xpath("//div[@class='float-right']//a");
	
	By Email=By.id("Email");
	By password=By.id("Password");
	By first_name=By.id("FirstName");
	By last_name=By.id("LastName");
	By male=By.id("Gender_Male");
	By female=By.id("Gender_Female");
	By dob=By.id("DateOfBirth");
	By company_name=By.id("Company");
	By tax=By.id("IsTaxExempt");
	
	By newsletter=By.xpath("//input[@class='k-input k-readonly']");
	
	//By newsLetter=By.xpath("(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[1]");
	//By newsLetter1=By.xpath("//li[normalize-space()='Your store name']");
	//By newsLetter2=By.xpath("//li[normalize-space()='Test store 2']");
	//By costumerRoles=By.id("SelectedCustomerRoleIds");
	By costumerRoles=By.xpath("(//input[@role='listbox'])[2]");
	By managerOfVender=By.id("VendorId");
	By active=By.id("Active");
	By adminComment=By.id("AdminComment");
	By saveButton=By.xpath("//button[@name='save']");
	
	// Action methods
	
	public void clickCustomerMenu() {
		driver.findElement(customer_menu).click();
	}
	
	public void clickCustomerMenuItem() {
		driver.findElement(customer_item).click();
	}
	
	public void clickAddNew() {
		driver.findElement(addNew).click();
	}
	
	public void setEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void setFirtsName(String fn) {
		driver.findElement(first_name).sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		driver.findElement(last_name).sendKeys(ln);
	}
	
	public void setGender(String gender) {
		if(gender.equals("male")) {
			driver.findElement(male).click();
		}
		if(gender.equals("female")) {
			driver.findElement(female).click();
		}
	}
	
	public void setDOB(String date) {
		driver.findElement(dob).sendKeys(date);
	}
	
	public void setCompanyName(String cmp) {
		driver.findElement(company_name).sendKeys(cmp);
	}
	
	public void setTax() {
		driver.findElement(tax).click();
	}
	
	public void setNewsLetter(String nl) throws InterruptedException {
		
		driver.findElement(newsletter).sendKeys(nl);
		
		
		/*
		 * driver.findElement(newsLetter).click(); Thread.sleep(3000);
		 * if(nl.equals("Your store name")) driver.findElement(newsLetter1).click();
		 * if(nl.equals("Test store 2")) driver.findElement(newsLetter2).click();
		 */
	}

	public void setCustomerRoles(String[] cr) throws InterruptedException {
		
		driver.findElement(costumerRoles).clear();
		for(int i=0;i<cr.length;i++) {
		driver.findElement(costumerRoles).sendKeys(cr[i]+"  ");
		
		Thread.sleep(3000);
		}
		/*
		 * WebElement ele=driver.findElement(costumerRoles); Select s=new Select(ele);
		 * for(int i=0;i<cr.length;i++) { s.selectByVisibleText(cr[i]); }
		 */
	}
	
	public void setVendor(String vendor) {
		WebElement ele=driver.findElement(managerOfVender);
		Select s=new Select(ele);
		s.selectByVisibleText(vendor);
	}
	
	public void setActive() {
		if(!driver.findElement(active).isSelected())
		    driver.findElement(active).click();
	}
	
	public void setAdminComment(String comment) {
		driver.findElement(adminComment).sendKeys(comment);
	}
	
	public void clickSave() {
		driver.findElement(saveButton).click();
	}
}
