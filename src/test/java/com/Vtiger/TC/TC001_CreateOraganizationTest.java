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

public class TC001_CreateOraganizationTest {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {

		
	// Launching the browser	hardcoding
	//	WebDriver driver = new ChromeDriver();
		
	// Launching the browser softcoding
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
		
	// get url hardcoding
	//	driver.get("http://localhost:8888/");
		
	// softcoding url
		driver.get(FileUtil.objforFileUtil().readDatafromPropFile("url"));
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.maximizeWndw(driver);
		webdriverutil.refresh();

	// performing login
		driver.findElement(By.name("user_name")).sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(FileUtil.objforFileUtil().readDatafromPropFile("password"));
		driver.findElement(By.id("submitButton")).click();

	// clicking and creating organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
	//	driver.findElement(By.name("accountname")).sendKeys("START"); // hardcoding the name everytime we execute
		
	// Softcoding from generic lib present in src/main/java
		
		String Orgname = JavaUtil.objforJavaUtil().getFullName() + JavaUtil.objforJavaUtil().generateRandomNumber();
		driver.findElement(By.name("accountname")).sendKeys(Orgname );
		System.out.println(Orgname);
		
	// Saving the created org.
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @class='crmbutton small save']")).click();
		Thread.sleep(2000);
		webdriverutil.refresh();

	// Validating the created org
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.name("search_text")).sendKeys(Orgname);

	// hardcoding for validating by select class for dd
		WebElement ddAddr= driver.findElement(By.id("bas_searchfield"));
//		Select sel = new Select(ddAddr);
//		sel.selectByVisibleText("Organization Name");
		
		webdriverutil.selectFromDropdown(ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 2, 1), ddAddr);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);

		WebElement add = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+Orgname+"']"));
	
		System.out.println(add.isDisplayed());
		if(add.getText().contentEquals(Orgname))
		{
			System.out.println("TC1 passed");
		}
		else
		{
			System.out.println("TC1 Failed");
		}

	// Signing out from the application
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

//		Actions ac = new Actions(driver);
//		ac.moveToElement(signout).perform();
		
	// Softcoding from generic lib
		webdriverutil.mouseHover(signout);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
