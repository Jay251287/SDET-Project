package com.Vtiger.POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericLib.FileUtil;

public class LoginPage {	//Rule 1 Declaring
	WebDriver driver;
	
	@FindBy(name="user_name")	//Rule 2 Declaring private to protect code
	private WebElement username; // Rule 3
	
	@FindBy(name="user_password")	
	private WebElement password;
	
	@FindBy(id="submitButton")	
	private WebElement loginbtn;

	
	public WebElement getUsername() { // Rule 4 proving getters
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void logintoapp() throws IOException
	{
		username.sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("username"));
		password.sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("password"));
		loginbtn.click();
	}
	
	public void logintoapp(String newusername, String newpassword) throws IOException
	{
		username.sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("newusername"));
		password.sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("newpassword"));
		loginbtn.click();
	}

}
