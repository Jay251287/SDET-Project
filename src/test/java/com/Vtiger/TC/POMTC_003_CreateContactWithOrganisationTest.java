package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.ContactCreate;
import com.Vtiger.POMClasses.ContactInfoPage;
import com.Vtiger.POMClasses.Homepage;
import com.Vtiger.genericLib.BaseTest;
import com.Vtiger.genericLib.ExcelUtil;
import com.Vtiger.genericLib.WebDriverUtil;

public class POMTC_003_CreateContactWithOrganisationTest extends BaseTest {

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

	
	@Test(groups = "Regression Test", retryAnalyzer = com.Vtiger.genericLib.RetryAnalyser.class)
	public void createcontactwithOrg() throws IOException, InterruptedException
	{
		Homepage hp = new Homepage(driver);
		hp.getContactslink().click();

		ContactInfoPage contactinfo = new ContactInfoPage(driver);
		contactinfo.getContactaddimg().click();

		String nametag = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet3", 1, 1);

		ContactCreate contactcreate = new ContactCreate(driver);
		String firstname = contactcreate.enterDetailforcontact(nametag);
		contactcreate.getOrgnameimg().click();
	//	String title = "Accounts&action";
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.switchWndwHandle("Accounts&action");
		String Orgname = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 21, 0);
		String Orgindd = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 2, 1);

		contactcreate.getOrgsearchtb().sendKeys(Orgname);
		contactcreate.getOrgindd().sendKeys(Orgindd);
		contactcreate.getOrgsearchnowbtn().click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		System.out.println(Orgname);
  
		webdriverutil.switchWndwHandle("Contacts&action");
		contactcreate.getSavebtn().click();

		// Validating
		hp.getContactslink().click();
		contactinfo.getSearchfortb().sendKeys(firstname);
		contactinfo.getContactindd().sendKeys(ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet3", 2, 0));
		contactinfo.getSearchnowbtn().click();
		Thread.sleep(4000);
		WebElement addr = driver.findElement(By.xpath("//a[@title='Contacts' and text()='"+firstname+"']"));
//		System.out.println(addr.isDisplayed());
//		if(addr.getText().equalsIgnoreCase(firstname))
//		{
//			System.out.println("TC3 passed");
//		}
//		else
//		{
//			System.out.println("TC3 Failed");
//		}
		Assert.assertEquals(addr.isDisplayed(), true);
		Assert.assertEquals(addr.getText(), firstname);
		
		//hp.logoutfromapp(); 
	}
	
	@Test(groups = "Smoke Test", retryAnalyzer = com.Vtiger.genericLib.RetryAnalyser.class)
	public void createcontact() throws InterruptedException, IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getContactslink().click();
		
		ContactInfoPage contactinfo = new ContactInfoPage(driver);
		contactinfo.getContactaddimg().click();

		String nametag = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet3", 3, 1);

		ContactCreate createcontact = new ContactCreate(driver);
		String firstname = createcontact.enterDetailforcontact(nametag);
		createcontact.getSavebtn().click();
		
		
		Thread.sleep(2000);
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.refresh();

// Validating
		
		hp.getContactslink().click();
		contactinfo .getSearchfortb().sendKeys(firstname);
		contactinfo.getContactindd().sendKeys(ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet3", 2, 0));
		contactinfo.getSearchnowbtn().click();

		Thread.sleep(4000);
		WebElement addr = driver.findElement(By.xpath("//a[@title='Contacts' and text()='"+firstname+"']"));

//		System.out.println(addr.isDisplayed());
//		if(addr.getText().equalsIgnoreCase(firstname))
//			{
//				System.out.println("TC3contact passed");
//			}
//		else
//			{
//				System.out.println("TC3contact Failed");
//			}
		Assert.assertEquals(addr.isDisplayed(), true);
		Assert.assertEquals(addr.getText(), firstname);
	}

}
