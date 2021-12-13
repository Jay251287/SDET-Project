 package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.CreateOrg;
import com.Vtiger.POMClasses.Homepage;
import com.Vtiger.POMClasses.OrgInfoPage;
import com.Vtiger.genericLib.BaseTest;
import com.Vtiger.genericLib.ExcelUtil;
import com.Vtiger.genericLib.JavaUtil;
import com.Vtiger.genericLib.WebDriverUtil;

@Listeners(com.Vtiger.genericLib.ListenersImplementation.class)
public class POMTC_001_CreateOraganizationTest extends BaseTest {

//	public static void main(String[] args) throws IOException, InterruptedException {

//		WebDriver driver;
//		String browser = FileUtil.objforFileUtil().readDatafromPropFile("browser");
//
//		if(browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else if(browser.equalsIgnoreCase("safari")) {
//			driver = new SafariDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		} 
//
//		driver.get(FileUtil.objforFileUtil().readDatafromPropFile("url"));
//		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
//		webdriverutil.maximizeWndw(driver);
//		webdriverutil.refresh();
//
//		LoginPage lp = new LoginPage(driver);
//		lp.logintoapp();

	@Test(groups= "Smoke Test", retryAnalyzer = com.Vtiger.genericLib.RetryAnalyser.class)
	public void creteOrg() throws InterruptedException, IOException
	{
		
		Homepage hp = new Homepage(driver);
		hp.getOrginfolink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		CreateOrg createorg = new CreateOrg(driver);
		
		String Orgname = JavaUtil.objforJavaUtil().getFullName() + JavaUtil.objforJavaUtil().generateRandomNumber();
		createorg.getOrgnametb().sendKeys(Orgname);
		System.out.println(Orgname);
		createorg.getSavebtn().click();
		
		Thread.sleep(2000);
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.refresh();

// Validating
		hp.getOrginfolink().click();
		orginfopage.searchfororg(Orgname, ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 2, 1));
		Thread.sleep(2000);
		WebElement add = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));
//		System.out.println(add.isDisplayed());
//		if(add.getText().contentEquals(Orgname))
//		{
//			System.out.println("TC1 passed");
//		}
//		else
//		{
//			System.out.println("TC1 Failed");
//		}
		Assert.assertEquals(add.isDisplayed(), true);
		Assert.assertEquals(add.getText(), Orgname);
		
	//	hp.logoutfromapp();
		 
	}
	
	@Test(groups = "Regression Test", retryAnalyzer = com.Vtiger.genericLib.RetryAnalyser.class)
	public void createorgwithphonenumber() throws InterruptedException, IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getOrginfolink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		CreateOrg createorg = new CreateOrg(driver);
		String Orgname = JavaUtil.objforJavaUtil().getFullName();
		String OrgPhNo = JavaUtil.objforJavaUtil().getphoneNumber();
		createorg.getOrgnametb().sendKeys(Orgname);
		createorg.getPhoneNo().sendKeys(OrgPhNo);
		System.out.println(OrgPhNo);
		createorg.getSavebtn().click();
		
		Thread.sleep(2000);
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.refresh();
		
	// Validating
		hp.getOrginfolink().click();
		orginfopage.searchfororg(Orgname, ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 2, 1));
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));
		Thread.sleep(2000);
//		System.out.println(add.isDisplayed());
//		if(add.getText().contentEquals(Orgname))
//		{
//			System.out.println("TC1phno passed");
//		}
//		else
//		{
//			System.out.println("TC1phno Failed");
//		} 
		
		Assert.assertEquals(add.isDisplayed(), true);
		Assert.assertEquals(add.getText(), Orgname);
		
	}
	
	
}

