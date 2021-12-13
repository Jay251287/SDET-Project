package com.Vtiger.POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericLib.WebDriverUtil;

public class OrgInfoPage {
	
	WebDriver driver;
		
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgimg;
	
	@FindBy(name="search_text")
	private WebElement searchorg;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchorgdd;
	
	@FindBy(name="submit")
	private WebElement searchnowbtn;
	
	public WebElement getCreateorgimg() {
		return createorgimg;
	}

	public WebElement getSearchorg() {
		return searchorg;
	}

	public WebElement getSearchorgdd() {
		return searchorgdd;
	}

	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}

	public OrgInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void searchfororg(String CheckOrgname, String text) throws IOException
	{
		searchorg.sendKeys(CheckOrgname);
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectFromDropdown(text, searchorgdd);
		searchnowbtn.click();
	}
	
	public void searchwithphoneno(String CheckPhNo, String text)
	{
		searchorg.sendKeys(CheckPhNo);
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectFromDropdown(text, searchorgdd);
		searchnowbtn.click();
	}
}
