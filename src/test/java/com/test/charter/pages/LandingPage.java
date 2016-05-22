package com.test.charter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LandingPage 
{
	
	private WebDriver driver;
	private String title="Charter";
	
	public LandingPage(WebDriver driver)
	{
	this.driver=driver;		
	}
	

	@FindBy(how=How.XPATH , using="//*[@id='address1']")
	public WebElement street;
	
	@FindBy(id="appartment")
	public WebElement apt;
	
	@FindBy(id="zip-code")
	public WebElement zip;
	

	public boolean userNavigateToCharterPage()
	{
		if(driver.getTitle().contains(title))
		{
			return true;
		}
		return false;
	}

	public ChooseAptPage clickonLoginButton()
	{
		try
		{
        WebElement login=driver.findElement(By.id("Loc_GO_PostHol"));	
        if(login.isDisplayed() || login.isEnabled())
        {
        	Thread.sleep(5000);
        	login.click(); 
        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Login button is not clicked");
		}	
		return PageFactory.initElements(driver, ChooseAptPage.class);
	}
	
	public boolean enterAddressDetail()
	{
		try
		{
		if(street.isEnabled() && apt.isEnabled() && zip.isEnabled())
		{
		street.sendKeys("9798 Hale Dr");
		//apt.sendKeys("SB1");
		zip.sendKeys("63123");
		Thread.sleep(5000);
		return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Issue Detected on Passing Value on Landing Page");
		}
	   return false;
	}
	
	
	
	

}
