package com.sdet2practise;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Vtiger.POMClasses.LoginPage;
import com.Vtiger.genericLib.FileUtil;
import com.Vtiger.genericLib.WebDriverUtil;

public class VtigerAssignmentTest {


	public static void main(String[] args) throws IOException {

		WebDriver driver;
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

		LoginPage lp = new LoginPage(driver);
		lp.logintoapp();

		driver.findElement(By.id("qccombo")).click();
		List<WebElement> quicksearch = driver.findElements(By.xpath("//select[@id='qccombo']//option"));
		
		System.out.println(quicksearch.size());

		for(int i=0; i<quicksearch.size(); i++) 
		{
			WebElement add = quicksearch.get(i);
			String text = add.getText();
			System.out.println(add.isDisplayed());
			if(text.equalsIgnoreCase("New Project"))
			{
				add.click();
			}
			else
			{
				System.out.println("Failed");
			}
		}

	}

}
