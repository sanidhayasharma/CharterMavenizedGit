package com.test.charter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerInformationPage
{

private WebDriver driver;	
	
public CustomerInformationPage(WebDriver driver)
{
	this.driver=driver;
}
		
@FindBy(how=How.XPATH , using="//*[@id='firstname']")	
public WebElement FirstName;

@FindBy(how=How.XPATH , using="//*[@id='lastname']")	
public WebElement LastName;

@FindBy(how=How.XPATH , using="//*[@id='phone-type-home-label']/span")	
public WebElement HomeNumber;

@FindBy(how=How.XPATH , using="//*[@id='phoneNumber']")	
public WebElement PhoneNumber;

@FindBy(how=How.XPATH , using="//*[@id='email']")	
public WebElement Email;

@FindBy(how=How.XPATH , using="//*[@id='confirm-email']")	
public WebElement ConfirmEmail;

@FindBy(how=How.XPATH , using="//*[@id='over_a_year_over_1_year']/span")	
public WebElement ResiInformation;

@FindBy(how=How.XPATH , using="//*[@id='e911_agree']/span[2]")	
public WebElement E911;	
	
@FindBy(how=How.XPATH , using="//*[@id='terms_agree']/span[2]")	
public WebElement Agreement;	
		

public void EnteredInformation()
{
	try
	{
		
	if(FirstName.isDisplayed() || FirstName.isEnabled() && LastName.isDisplayed() || LastName.isEnabled() && PhoneNumber.isDisplayed() || PhoneNumber.isEnabled() && Email.isDisplayed() || Email.isEnabled() && ConfirmEmail.isDisplayed() || ConfirmEmail.isEnabled())
	{
		FirstName.sendKeys("Sanidhaya");
		Thread.sleep(1000);
		LastName.sendKeys("Sharma");
		Thread.sleep(1000);
		if(HomeNumber.isDisplayed() || HomeNumber.isEnabled() && HomeNumber.isSelected())
		{
			HomeNumber.click();
		}
		Thread.sleep(1000);
		PhoneNumber.sendKeys("8586965562");
		Email.sendKeys("sanidhaya.sharma@charter.com");
		ConfirmEmail.sendKeys("sanidhaya.sharma@charter.com");
		Thread.sleep(1000);
		if(ResiInformation.isEnabled() || ResiInformation.isDisplayed() && ResiInformation.isSelected())
		{
			ResiInformation.click();
		}
		Thread.sleep(1000);
		if(E911.isDisplayed() || E911.isEnabled() && Agreement.isDisplayed() || Agreement.isEnabled() && E911.isSelected() && Agreement.isSelected())
		{
			E911.click();
			Agreement.click();
		}
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Customer Information detail Page Issue");
	}
}



}
