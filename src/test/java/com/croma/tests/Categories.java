package com.croma.tests;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.croma.pages.cromaPages;

public class Categories extends TestBase{

	@Test
	public void category()
	{
		cromaPages croma= new cromaPages(driver);
		List<WebElement> categories=croma.getcategories();
		try{
		for(WebElement category:categories)
		{
			Reporter.log(category.getText(),true);
			croma.getcategorySlide().click();
		}
		}
		catch(NoSuchElementException e)
		{
			Reporter.log("no more sliders",true);
		}
	}
}
