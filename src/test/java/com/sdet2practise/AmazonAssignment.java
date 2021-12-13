package com.sdet2practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonAssignment {

	@Test
	public  void main() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles below 15000", Keys.ENTER);

		//		List<WebElement> alloptions = driver.findElements(By.xpath("//input[@name ='field-keywords']"));
		//		System.out.println(alloptions.size());
		//		
		//		for(int i =0; i<alloptions.size(); i++)
		//		{
		//			System.out.println(alloptions.get(i).getText());
		//		}

		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();

	}

}
