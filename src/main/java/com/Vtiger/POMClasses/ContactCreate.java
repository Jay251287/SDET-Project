package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericLib.JavaUtil;
import com.Vtiger.genericLib.WebDriverUtil;

public class ContactCreate {
	
	WebDriver driver;
	
	@FindBy(name="salutationtype")
	private WebElement nametagdd;
	
	@FindBy(name="firstname")
	private WebElement firstnametb;

	@FindBy(name="lastname")
	private WebElement lastnametb;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgnameimg;
	
	@FindBy(id="search_txt")
	private WebElement orgsearchtb;
	
	@FindBy(name="search_field")
	private WebElement orgindd;
	
	@FindBy(name="search")
	private WebElement orgsearchnowbtn;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	
	@FindBy(name="leadsource")
	private WebElement leaddd;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getNametagdd() {
		return nametagdd;
	}

	public WebElement getFirstnametb() {
		return firstnametb;
	}

	public WebElement getLastnametb() {
		return lastnametb;
	}

	public WebElement getOrgnameimg() {
		return orgnameimg;
	}

	public WebElement getOrgsearchtb() {
		return orgsearchtb;
	}

	public WebElement getOrgindd() {
		return orgindd;
	}

	public WebElement getOrgsearchnowbtn() {
		return orgsearchnowbtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
		
	public WebElement getLeaddd() {
		return leaddd;
	}

	public ContactCreate(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param salutation
	 * @return firstname for validating 
	 */
	public String enterDetailforcontact(String salutation)
	{
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectFromDropdown(salutation, nametagdd);
		String firstname = JavaUtil.objforJavaUtil().getFirstName();
		String lastname = JavaUtil.objforJavaUtil().getlastName();
		firstnametb.sendKeys(firstname);
		lastnametb.sendKeys(lastname);
		return firstname;
		
	}
	
	

}
