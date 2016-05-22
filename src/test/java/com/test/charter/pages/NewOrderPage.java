package com.test.charter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

public class NewOrderPage
{
	private WebDriver driver;
	private String URL="https://www.charter.com/buyflow/store-front";
	
	public NewOrderPage(WebDriver driver)
	{
	this.driver=driver;		
	}
	
	@FindBy(how=How.ID , using="start_new_order proceed_with_order")
	public WebElement newOrder;
	
	public OfferPage clickOnNewOrder()
	{
		
		try
		{
			Thread.sleep(15000);
			if(driver.getCurrentUrl().equalsIgnoreCase(URL))
			{		
				return PageFactory.initElements(driver, OfferPage.class);
			}
			else if(newOrder.isDisplayed() || newOrder.isEnabled())
			{
				newOrder.click();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Issue Detected on Click On New Order");
		}
		return PageFactory.initElements(driver, OfferPage.class);
		
	}
	
	
	

}
