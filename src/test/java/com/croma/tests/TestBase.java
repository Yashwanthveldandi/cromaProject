package com.croma.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	WebDriver driver;
	@Parameters({"Browser","url"})
	@BeforeClass
    public void setUp(String Browser, String url)
	{
	
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\cromaProject\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	else if(Browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver","E:\\cromaProject\\Drivers\\msedgedriver.exe");
		driver= new EdgeDriver();
		
	}
	else if(Browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","E:\\cromaProject\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.get(url);
	}
	@AfterClass
	public void teardown() throws InterruptedException
	{
		
	//driver.close();
	}
	
	public void captureScreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Source =screenshot.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"/ScreenShots/"+ tname +".png";
		FileUtils.copyFile(Source, new File(dest));
	}
}
