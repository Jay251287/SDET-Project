package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.CreateOrg;
import com.Vtiger.POMClasses.Homepage;
import com.Vtiger.POMClasses.OrgInfoPage;
import com.Vtiger.genericLib.BaseTest;
import com.Vtiger.genericLib.ExcelUtil;
import com.Vtiger.genericLib.JavaUtil;
import com.Vtiger.genericLib.WebDriverUtil;

public class POMTC_002_CreateOrganizationDropdownTest extends BaseTest {
//	public static void main(String[] args) throws IOException, InterruptedException {
//
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
	
	@Test(groups ="Regression Test", retryAnalyzer = com.Vtiger.genericLib.RetryAnalyser.class)
	public void createorgwithdd() throws IOException, InterruptedException
	{
		Homepage hp = new Homepage(driver);
		hp.getOrginfolink().click();
		
		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();
		
		String Orgname = JavaUtil.objforJavaUtil().getFullName() + JavaUtil.objforJavaUtil().generateRandomNumber();
		CreateOrg createorg = new CreateOrg(driver);
		createorg.getOrgnametb().sendKeys(Orgname);
		
		String s = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet1", 2, 0);
		String s1 = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet1", 1, 1);
		String s2 = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet1", 4, 2);
		
		createorg.createorgwithdd(s, s1, s2);
		createorg.getSavebtn().click();
		System.out.println(Orgname);
		
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
//			System.out.println("TC2 passed");
//		}
//		else
//		{
//			System.out.println("TC2 Failed");
//		}
		
		Assert.assertEquals(add.isDisplayed(), true);
		Assert.assertEquals(add.getText(), Orgname);
		//hp.logoutfromapp();
	}
}
