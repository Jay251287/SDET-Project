package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericLib.WebDriverUtil;

public class CreateOrg {
	WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement orgnametb;
	
	@FindBy(name="industry")
	private WebElement ddforindustry;
	
	@FindBy(name="rating")
	private WebElement ddforrating;
	
	@FindBy(name="accounttype")
	private WebElement ddfortype;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(id="phone")
	private WebElement phoneno;
	
	public WebElement getOrgnametb() {
		return orgnametb;
	}

	public WebElement getDdforindustry() {
		return ddforindustry;
	}

	public WebElement getDdforrating() {
		return ddforrating;
	}

	public WebElement getDdfortype() {
		return ddfortype;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getPhoneNo() {
		return phoneno;
	}
	
	public CreateOrg(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createorgaccount(String Orgname)
	{
		orgnametb.sendKeys(Orgname);
		savebtn.click();
	}
	public void createorgwithdd(String ind, String rating, String type)
	{
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.selectFromDropdown(ddforindustry, ind);
		webdriverutil.selectFromDropdown(ddforrating, rating);
		webdriverutil.selectFromDropdown(type, ddfortype);
	}
}
