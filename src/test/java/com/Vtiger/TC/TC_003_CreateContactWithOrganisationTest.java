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

public class TC_003_CreateContactWithOrganisationTest {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {

	// launching the browser
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

	// login to the appl.
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


	// creating an contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
		WebElement firstnamedd = driver.findElement(By.name("salutationtype"));
	// hardcoding
//		Select sel = new Select(firstnamedd);
//		sel.selectByVisibleText("Mr.");
		
	// softcoding
		webdriverutil.selectFromDropdown(ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet3", 1, 1), firstnamedd);
		

	// hardcoding
		//		driver.findElement(By.name("firstname")).sendKeys("RAKESH");
		//		driver.findElement(By.name("lastname")).sendKeys("SHARMA");

		// Softcode from generic lib
		String firstname = JavaUtil.objforJavaUtil().getFirstName();
		String lastname = JavaUtil.objforJavaUtil().getlastName();
		
		driver.findElement(By.name("firstname")).sendKeys(firstname); 
		driver.findElement(By.name("lastname")).sendKeys(lastname);
	
	// clicking on org. name + button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

	// handling the org window
		String wh = driver.getWindowHandle();
//		Set<String> orgwndw = driver.getWindowHandles();
//		for(String mainwndw:orgwndw) {
//			driver.switchTo().window(mainwndw);
//			Thread.sleep(3000);
//		}
	// softcoding windowhandles
		webdriverutil.switchWndwHandle(wh);

	// searching for existing org name from search box  hardcoding
//		driver.findElement(By.id("search_txt")).sendKeys("QSPIDERSGUTTA");
//
//		driver.findElement(By.name("search")).click();
//		driver.findElement(By.xpath("//a[text()='QSPIDERSGUTTA']")).click();

	// softcoding
		String Orgname = ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet2", 15, 0);
		driver.findElement(By.id("search_txt")).sendKeys(Orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		System.out.println(Orgname);

	// switching back to parent wndw
		driver.switchTo().window(wh);

		// saving the contact
		driver.findElement(By.name("button")).click();

		// validating the saved contact using firstname dropdown from search list box
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.name("search_text")).sendKeys(JavaUtil.objforJavaUtil().getFirstName());
		WebElement dd= driver.findElement(By.id("bas_searchfield"));
	//	Select select = new Select(dd);
	//	select.selectByVisibleText("First Name");
		webdriverutil.selectFromDropdown(ExcelUtil.objforExcelUtil().readDatafromExcelFile("sheet3", 2, 0), dd);
		driver.findElement(By.name("submit")).click();

		WebElement addr = driver.findElement(By.xpath("//a[@title='Contacts' and text()='"+firstname+"']"));

		System.out.println(addr.isDisplayed());
		if(addr.getText().equalsIgnoreCase(firstname))
		{
			System.out.println("TC3 passed");
		}
		else
		{
			System.out.println("TC3 Failed");
		}

		// sign out from the appl.
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

	//	Actions ac = new Actions(driver);
	//	ac.moveToElement(signout).perform();
		webdriverutil.mouseHover(signout);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
