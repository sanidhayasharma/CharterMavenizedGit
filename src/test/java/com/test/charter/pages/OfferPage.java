package com.test.charter.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OfferPage 
{
private WebDriver driver;

private String address="9798 HALE DR SB 63123";
private String phone ="1-855-839-4246";

public OfferPage(WebDriver driver)
{
	this.driver=driver;
}

@FindBy(how=How.XPATH,using="//*[@id='header']/div/div[2]/div[1]/div/section/address/span")
public WebElement VerifyAddress;

@FindBy(how=How.CLASS_NAME , using="ng-binding")
public WebElement phoneNumber;

@FindBy(how=How.ID , using="choose_103211010")
public WebElement selectOffer;

public boolean IsTheSameAddress()
{
	try
	{
	System.out.println(VerifyAddress.getText());
	Assert.assertTrue(VerifyAddress.getText().equalsIgnoreCase(address));
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
}

public boolean isTheSamePhoneNumber()
{
	try
	{
     System.out.println(phoneNumber.getText());
     Assert.assertTrue(phoneNumber.getText().equalsIgnoreCase(phone));
     return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Issue in Verifying Phone Number");
	}
	return false;
}

public CustomizeOfferPage doSelectOffer()
{
	try
	{
	if(selectOffer.isDisplayed() || selectOffer.isEnabled())
	{
		selectOffer.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(5000);
	    selectOffer.click();
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Issue Detected in Selecting Offer");
	}
	return PageFactory.initElements(driver, CustomizeOfferPage.class);
}


}
