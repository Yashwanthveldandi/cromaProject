package com.croma.tests;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.croma.pages.cromaPages;

public class VideoCall extends TestBase {

	@Test
	public void VdCall() throws IOException
	{
		cromaPages croma= new cromaPages(driver);
		 SoftAssert sAssertion= new SoftAssert();
		croma.getStartVideoCall().click();
		Actions ac = new Actions(driver);
	    ac.sendKeys(Keys.PAGE_DOWN).build().perform();
	  try{
		String title=croma.getVideoCall().getText();
		Reporter.log(title,true);
		sAssertion.assertTrue(true);
	  }
	  catch(NoSuchElementException e)
	  {
		    captureScreenShot(driver,"VideoCall");
			Reporter.log("the video call is not working try in chrome Browser",true);
			sAssertion.assertTrue(false);
	  }
	}
}
