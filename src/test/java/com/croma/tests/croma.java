package com.croma.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.croma.pages.cromaPages;

public class croma extends TestBase {
	
	@Test
	public void addToCart() throws IOException, InterruptedException
	{
		cromaPages croma= new cromaPages(driver);
		FileInputStream fis= new FileInputStream("E:\\cromaProject\\inputData.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String mobiles =prop.getProperty("mobiles");
		{
			croma.getcategory().click();
	     	Thread.sleep(3000);
	     	String title =driver.getTitle();
	     	if(title.contains(mobiles))
	     	{
	     		Reporter.log("the mobile phones page is loaded ", true);
	     		Assert.assertTrue(true);
	     		
	     	}
	     	else
	     	{
	     		Reporter.log("the mobile phones page is not loaded ", true);
	     		Assert.assertTrue(false);
	     	}
	     	
			Actions ac = new Actions(driver);
		    ac.sendKeys(Keys.PAGE_DOWN).build().perform();
		    Thread.sleep(2000);
			croma.getaddToCart().click();
			Thread.sleep(3000);
			croma.getCartBtn().click();
			Thread.sleep(4000);
			int item=croma.getcartItem().size();
			if(item>=1)
			{
				Reporter.log("the item is added to cart", true);
				Assert.assertTrue(true);
				try
				{
				croma.getPopUp().click();
				}
				catch(org.openqa.selenium.NoSuchElementException r)
				{
					Reporter.log("no pop up present", true);	
				}
				croma.getDeleteItem().click();
				croma.getYesDelete().click();
			}
			else
			{
				captureScreenShot(driver,"addToCart");
				Reporter.log("the item is not added to cart", true);
				Assert.assertTrue(false);
			}
			}
	}
}
            
	
	

