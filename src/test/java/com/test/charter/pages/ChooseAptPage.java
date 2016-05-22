package com.test.charter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseAptPage
{
	private WebDriver driver;
	private String title="Charter Spectrum� Official - Internet, Cable TV, and Phone Service.";
	private String MultipleAddressUrl="https://www.charter.com/buyflow/retrieve-cart-implicit/a3fa7ec4-0159-4880-a7cf-059ee4701ee9";
	private String StoreUrl="https://www.charter.com/buyflow/store-front";
	
	public ChooseAptPage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	@FindBy(how=How.XPATH , using="//*[@id='multiple-addresses']/section/div/section/div/div[2]/form/div/div[2]/div/label/div[2]/span")
	private WebElement AptChoose;
	
	
public NewOrderPage doChooseAddress()
{
	try
	{	
		if(isMultipleAddressPagePresent())
		{
			return PageFactory.initElements(driver, NewOrderPage.class);
		}
		else if(AptChoose.isDisplayed() || AptChoose.isEnabled())
		{
			WebDriverWait wait = new WebDriverWait(driver,30L);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='multiple-addresses']/section/div/section/div/div[2]/form/div/div[2]/div/label/div[2]/span")));
			AptChoose.click();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Issue Detected on Choosing Apartment");		
	}
	return PageFactory.initElements(driver, NewOrderPage.class);
}
	
public boolean isMultipleAddressPagePresent()
{
	try
	{
		Thread.sleep(15000);
		if(driver.getCurrentUrl().contains(MultipleAddressUrl) || driver.getCurrentUrl().equalsIgnoreCase(StoreUrl))
		{		
			return true;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception Found While Skipping Multiple Address Page");
	}
	return false;
}

public boolean VerifyTitleOnApt() throws InterruptedException
{
    
	if(driver.getTitle().equalsIgnoreCase(title))
	{
		return true;
	}
	return false;
}
}
