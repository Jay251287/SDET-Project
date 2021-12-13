package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericLib.WebDriverUtil;

public class Homepage {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orginfolink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactslink;
	
	@FindBy(id="//a[text()='Leads']")
	private WebElement leadinfolink;
	
		
	public WebElement getOrginfolink() {
		return orginfolink;
	}

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	public WebElement getContactslink() {
		return contactslink;
	}

	public Homepage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	public void logoutfromapp() throws InterruptedException
	{
	
		WebDriverUtil util = new WebDriverUtil(driver);
		util.mouseHover(signoutimg);
		Thread.sleep(2000);
		signoutbtn.click();
	}
}
