package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactaddimg;
	
	@FindBy(name="search_text")
	private WebElement searchfortb;
	
	@FindBy(id="bas_searchfield")
	private WebElement contactindd;
	
	@FindBy(name="submit")
	private WebElement searchnowbtn;
	
	@FindBy(id="viewname")
	private WebElement filters;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactaddimg() {
		return contactaddimg;
	}

	public WebElement getSearchfortb() {
		return searchfortb;
	}

	public WebElement getContactindd() {
		return contactindd;
	}

	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}

	public WebElement getFilters() {
		return filters;
	}
	
	public ContactInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchcontactwithFN()
	{
		
	}
	
	
	
	
}
