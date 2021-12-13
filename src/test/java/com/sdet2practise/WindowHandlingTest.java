package com.sdet2practise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.naukri.com/");
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.manage().window().maximize();
		 
		 Set<String> wndwids = driver.getWindowHandles();
				 
		 for(String id : wndwids)
		 {
			 String title =driver.switchTo().window(id).getTitle();
			 System.out.println(title); 
			 if(title.equalsIgnoreCase("Tech Mahindra"))
			{
				driver.manage().window().maximize();
				Thread.sleep(1000);
				driver.close();
			}
			 
		 }
	}

}
