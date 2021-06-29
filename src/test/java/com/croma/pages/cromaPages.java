package com.croma.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cromaPages {

	WebDriver driver;
	@FindBy(xpath="(//div//label//a[@data-testid='category-adobe'])[1]")
	WebElement category;
	public WebElement getcategory()
	{
		return category ;
	}
	
	@FindBy(xpath="(//div//button[text()='Add to cart'])[1]")
	WebElement addToCart ;
	public WebElement getaddToCart()
	{
		return addToCart;
	}
	
	@FindBy(id="cart_count_notification")
	WebElement CartBtn ;
	public WebElement getCartBtn()
	{
		return CartBtn ;
	}
	
	@FindAll(@FindBy(xpath="//div//h3[@class='product-title']"))
	List<WebElement> cartItem;
	public List<WebElement> getcartItem()
	{
		return cartItem ;
	}
	
	@FindBy(xpath="//div[@class='swiper-button-next Highlights3-button-next']")
	WebElement SlideArrow;
	public WebElement getSlideArrow()
	{
		return SlideArrow;
	}
	
	@FindBy(xpath="//div//a[@title='Delete']")
	WebElement DeleteItem;
	public WebElement getDeleteItem()
	{
		return DeleteItem ;
	}

	
	@FindBy(xpath="//div//button[@id='close']")
	WebElement PopUp;
	public WebElement getPopUp()
	{
		return PopUp ;
	}
	
	@FindBy(xpath="(//div//button[@class='btn btn-default'])[2]")
	WebElement YesDelete;
	public WebElement getYesDelete()
	{
		return YesDelete ;
	}
	
	@FindBy(xpath="//div//a//img[@title='Croma Firetv Edition']")
	WebElement FireTV;
	public WebElement getFireTV()
	{
		return FireTV ;
	}
	
	@FindAll(@FindBy(xpath="//div//p[@class='product-title']"))
	List<WebElement> FireTVTitles;
	public List<WebElement> getFireTVTitles()
	{
		return FireTVTitles ;
	}
	
	@FindAll(@FindBy(xpath="//div//span[@class='new-price']//span[@class='amount']"))
	List<WebElement> FireTVPrice;
	public List<WebElement> getFireTVFireTVPrice()
	{
		return FireTVPrice ;
	}
	
	@FindBy(xpath="//div[@class='swiper-button-next comp_00004MOK-button-next']")
	WebElement FireTVSwipe;
	public WebElement getFireTVSwipe()
	{
		return FireTVSwipe ;
	}
	
	@FindBy(xpath="//div//label//a[@data-testid='category-adobe']")
	List<WebElement> categories;
	public List<WebElement> getcategories()
	{
		return categories ;
	}
	
	@FindBy(xpath="//div[@class='swiper-button-next category-button-next']")
	WebElement categorySlide;
	public WebElement getcategorySlide()
	{
		return categorySlide ;
	}
	
	@FindAll(@FindBy(xpath="//div[@class='viewall-btn-wrap']"))
	List<WebElement> ViewAll;
	public List<WebElement> getViewAll()
	{
		return ViewAll ;
	}
	
	@FindBy(id="shopWithVideoMessage")
	WebElement VideoCall;
	public WebElement getVideoCall()
	{
		return VideoCall ;
	}
	
	@FindBy(xpath="//div//span//a[text()='Start a Video Call']")
	WebElement StartVideoCall;
	public WebElement getStartVideoCall()
	{
		return StartVideoCall ;
	}
	public cromaPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
