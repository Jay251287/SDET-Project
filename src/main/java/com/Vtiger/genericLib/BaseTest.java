package com.Vtiger.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Vtiger.POMClasses.Homepage;
import com.Vtiger.POMClasses.LoginPage;
import com.google.common.io.Files;

public class BaseTest {

	public WebDriver driver;
	public LoginPage lp;
	public static WebDriver sdriver;

	@BeforeSuite(groups = {"Smoke Test", "Regression Test"})
	public void connectToDB()
	{
		System.out.println("Connect to the DataBase");
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke Test", "Regression Test"})
	public void launchBrowserAndGetURL() throws IOException
	{
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

		driver.get(FileUtil.objforFileUtil().readDatafromPropFile("url"));
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.maximizeWndw(driver);
		webdriverutil.refresh();

		lp = new LoginPage(driver);
		sdriver = driver;
	}

	@BeforeMethod(groups = {"Smoke Test", "Regression Test"})
	public void logintoApp() throws IOException
	{
		lp.logintoapp();
	}

	@AfterMethod(groups = {"Smoke Test", "Regression Test"})
	public void logoutFromApp() throws InterruptedException
	{
		Homepage hp = new Homepage(driver);
		hp.logoutfromapp();
	}

	@AfterClass(groups = {"Smoke Test", "Regression Test"})
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}

	@AfterSuite(groups = {"Smoke Test", "Regression Test"})
	public void disconnect()
	{
		System.out.println("Disconnect from DataBase");
	}

	public static void takesScreenshot(String name) throws IOException
	{
//		File srcfile = ((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
//		String destfile = "../Screenshots/"+name+".png";
//		File finaldest = new File(destfile);
//		FileUtils.copyDirectory(srcfile, finaldest);
		
		TakesScreenshot ts = (TakesScreenshot)sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+name+".png");
		try {
			Files.copy(src, dest);
		}
		catch(IOException e) {
		e.printStackTrace();
		}
	}


}

