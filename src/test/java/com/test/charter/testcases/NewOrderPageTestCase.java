package com.test.charter.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.charter.base.Base;
import com.test.charter.pages.ChooseAptPage;
import com.test.charter.pages.LandingPage;
import com.test.charter.pages.NewOrderPage;
import com.test.charter.pages.OfferPage;

public class NewOrderPageTestCase extends Base
{
	
	WebDriver driver;


/*public void skipCartPageTest()
{
	if(driver.getCurrentUrl().equalsIgnoreCase(URL))
	{
		
		new SkipException("Skiping Cart Page");
		
	}
}*/

	@BeforeClass
	public void setUp()
	{
		driver=getDriver();
		
	}	

@Test
public void runNewOrderTest() throws InterruptedException
{
	
	//Given
			LandingPage land= PageFactory.initElements(driver, LandingPage.class);
			Assert.assertEquals(land.enterAddressDetail(), true);
			ChooseAptPage apt= land.clickonLoginButton();
			Thread.sleep(5000);
			NewOrderPage neworder=apt.doChooseAddress();
			
			//Then
			neworder.clickOnNewOrder();
	
	
}
	

}
