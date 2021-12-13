 package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Vtiger.genericLib.ExcelUtil;
import com.Vtiger.genericLib.FileUtil;
import com.Vtiger.genericLib.JavaUtil;
import com.Vtiger.genericLib.WebDriverUtil;

public class TC_002_CreateOrganizationDropdownTest {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {

	// Launching the appl.
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:8888/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String browser = FileUtil.objforFileUtil().readDatafromPropFile("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else {
			driver = new ChromeDriver();
		} 

		
	// login to the appl
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("12345");
//		driver.findElement(By.id("submitButton")).click();
	
	// softcoding url
		driver.get(FileUtil.objforFileUtil().readDatafromPropFile("url"));
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.maximizeWndw(driver);
		webdriverutil.pageloadWait(driver);
			
	// performing login
		driver.findElement(By.name("user_name")).sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("password"));
		driver.findElement(By.id("submitButton")).click();


	// clicking org and creating org.
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

	//	driver.findElement(By.name("accountname")).sendKeys("SECONDTC"); //its hardcoding
		
	// softcode by using genericlib
		String Orgname = JavaUtil.objforJavaUtil().getFirstName() + JavaUtil.objforJavaUtil().generateRandomNumber();
		driver.findElement(By.name("accountname")).sendKeys(Orgname);
		
	// giving the dropdown details in create orgName page using select class
		WebElement industry = driver.findElement(By.name("industry"));
//		Select industrydd = new Select(industry);
		String s = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet1", 2, 0);
//		industrydd.selectByVisibleText(s);
		System.out.println(s);
		Thread.sleep(1000);
//		
		WebElement rating = driver.findElement(By.name("rating"));
//		Select ratingdd = new Select(rating);
		String s1 = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet1", 1, 1);
//		ratingdd.selectByVisibleText(s1);
		System.out.println(s1);
		Thread.sleep(2000);
//		
		WebElement type = driver.findElement(By.name("accounttype"));
//		Select typedd = new Select(type);
		String s2 = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet1", 4, 2);
		System.out.println(s2);
//		typedd.selectByVisibleText(s2);

		webdriverutil.selectFromDropdown(industry, s);
		webdriverutil.selectFromDropdown(s1, rating);
		webdriverutil.selectFromDropdown(type, s2);
		
	// saving the orgname
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @class='crmbutton small save']")).click();
		Thread.sleep(2000);
		webdriverutil.refresh();

	// validating the created org
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.name("search_text")).sendKeys(Orgname);

		WebElement ddAddr= driver.findElement(By.id("bas_searchfield"));
	//	Select sel = new Select(ddAddr);
	//	sel.selectByVisibleText("Organization Name");
		webdriverutil.selectFromDropdown(ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 2, 1), ddAddr);
		driver.findElement(By.name("submit")).click();

		WebElement add = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));

		System.out.println(add.isDisplayed());
		if(add.getText().contentEquals(Orgname))
		{
			System.out.println("TC2 passed");
		}
		else
		{
			System.out.println("TC2 Failed");
		}

	// sign out the appl
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

	//	Actions ac = new Actions(driver);
	//	ac.moveToElement(signout).perform();

		webdriverutil.mouseHover(signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
