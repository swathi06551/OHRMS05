package com.webTableExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver;
	String applicationUrlAddress = "https://www.timeanddate.com/worldclock/";
	public void applicationLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swathi\\Desktop\\SeleniumPractice\\DriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
	}
	public void applicationClose()
	{
		driver.quit();
	}
	
}


