package com.Vtiger.genericLib;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	public WebDriver driver;

	public WebDriverUtil(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * @author SWATHI
	 * Description: This generic method maximizes the window
	 */
	public void maximizeWndw(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * @author SWATHI
	 * Description: This generic method refreshes the window
	 */
	public void refresh()
	{
		driver.navigate().refresh();
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will wait till the page is loaded
	 * @param driver
	 */
	public void pageloadWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 *  @author SWATHI
	 * Description: This generic method will select from dropdown using value
	 * @param element
	 * @param value
	 */
	public void selectFromDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 *  @author SWATHI
	 * Description: This generic method will select from dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectFromDropdown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will select from dropdown using visible text
	 * @param text
	 * @param element
	 */
	public void selectFromDropdown( String text, WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will move to a particular element on webpage and perform action
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will perform right clicking the element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick();
	}
	
	/**
	 * @author SWATHI
	 * Description: This generic method will click a particular element by width and height
	 * @param element
	 * @param Xoofset
	 * @param Yoffset
	 */
	public void clickByOffset(WebElement element, int Xoofset, int Yoffset)
	{
		Actions actions = new Actions(driver);
		actions.moveByOffset(Xoofset, Yoffset).click();
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will switch into frame using index of the frame
	 * @param index
	 */
	public void switchToWndw(int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will switch into frame using id of the frame
	 * @param id
	 */
	public void switchToWndwByID(int id)
	{
		driver.switchTo().frame(id);
	}

	/**
	 * @author SWATHI
	 * Description: This generic method will switch into frame using name of the frame
	 * @param name
	 */
	public void switchToWndw(String name)
	{
		driver.switchTo().frame(name);
	}

	/**
	 * @author SWATHI
	 * Description : This generic method will accept the alert popup
	 */
	public void acceptAlertPopups()
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * @author SWATHI
	 * Description : This generic method will dismiss the alert popup
	 */
	public void dismissAlertPopups()
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @author SWATHI
	 * Description : This generic method will help to sendkeys to a particular element
	 * @param element
	 * @param keysToSend
	 */
	public void sendKeys(WebElement element, String keysToSend)
	{
		element.sendKeys(keysToSend);
	}

	/**
	 * @author SWATHI
	 * Description : This generic method will scroll to an element
	 * @param element
	 */
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor jse =  (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * @author SWATHI
	 * Description : This generic method will scroll using position
	 * @param x
	 * @param y
	 */
	public void scrollByPosition(int x, int y)
	{
		JavascriptExecutor jse =  (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}

	/**
	 * @author SWATHI
	 * Description : This generic method will switch the handle from one window to other window
	 * @param title
	 */
	public void switchWndwHandle(String title)
	{
		Set<String> allwndws = driver.getWindowHandles();
		for(String id: allwndws)
			{
			String currenttitle = driver.switchTo().window(id).getTitle();
			System.out.println(currenttitle);
			if(currenttitle.contains(title)) 
			{
				break;
			}
		}
	}


}
