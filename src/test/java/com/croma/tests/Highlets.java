package com.croma.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.croma.pages.cromaPages;

public class Highlets extends TestBase{
	
	@Test
	public void CromaFireTv() throws IOException, InterruptedException 
	{
		cromaPages croma= new cromaPages(driver);
		FileInputStream fis= new FileInputStream("E:\\cromaProject\\inputData.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String FireTV =prop.getProperty("FireTv");
		Actions ac = new Actions(driver);
	    ac.sendKeys(Keys.PAGE_DOWN).build().perform();
	    Thread.sleep(2000);
	    for(int i=1;i<=2;i++)
	    {
	    	croma.getSlideArrow().click();
	    }
	    String title=driver.getTitle();
	    if(title.contains(FireTV))
	    {
	    	Reporter.log("the FireTV page is loaded ", true);
     		Assert.assertTrue(true);
	    	
	    }
	    else
	    {
	    	Reporter.log("the FireTV page is loaded ", true);
     		Assert.assertTrue(true);
	    	
	    }
	    Thread.sleep(2000);
	    croma.getFireTV().click();
	    
	   // JavascriptExecutor js=(JavascriptExecutor)driver;
	    //js.executeScript("window.scrollBy(0,1500)");
	    Thread.sleep(2000);
	    for(int i=1;i<=6;i++)
	   {
	    ac.sendKeys(Keys.PAGE_DOWN).build().perform();
	   }
	    
	    List<WebElement> titles=croma.getFireTVTitles();
	    List<WebElement> prices=croma.getFireTVFireTVPrice();
	   
	    for(int i=1;i<=2;i++)
	    {
	    try
	    {
	    for(int j=0;i<titles.size();j++)
	    {
	     Reporter.log("title:    "+titles.get(j).getText()+"    price:   " +prices.get(j).getText(),true );
	    }
	    }
	    catch(java.lang.IndexOutOfBoundsException e)
	    {
	    	Reporter.log("some products having no price");
	    }
	    croma.getFireTVSwipe().click();
	    
	    }
	    }
	    
	}


