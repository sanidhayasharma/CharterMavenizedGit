package com.test.charter.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.charter.base.Base;
import com.test.charter.pages.ChooseAptPage;
import com.test.charter.pages.CustomizeOfferPage;
import com.test.charter.pages.LandingPage;
import com.test.charter.pages.NewOrderPage;
import com.test.charter.pages.OfferPage;

public class CustomizeOfferPageTestCase extends Base
{	
WebDriver driver;

	@BeforeClass
	public void setUp()
	{
	driver=getDriver();
	
	}	
	
	@Test
	public void testCustomizationSelected() throws InterruptedException
	{
		//Given
		LandingPage land= PageFactory.initElements(driver, LandingPage.class);
		Assert.assertEquals(land.enterAddressDetail(), true);
		ChooseAptPage apt= land.clickonLoginButton();
		
		Thread.sleep(10000);
		NewOrderPage neworder =apt.doChooseAddress();
	    OfferPage offer=neworder.clickOnNewOrder();
	    
		//When
		Assert.assertEquals(offer.IsTheSameAddress(), true);
		//Assert.assertEquals(offer.isTheSamePhoneNumber(),true);
		
		//Then
		CustomizeOfferPage customize=offer.doSelectOffer();
        Assert.assertTrue(customize.testOrderTotal());
        customize.clickCart();
		System.out.println("Test Case 2 Select the Offer is Completed");
		
				
	}

	

}
