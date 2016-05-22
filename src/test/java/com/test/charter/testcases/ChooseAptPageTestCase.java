package com.test.charter.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.charter.base.Base;
import com.test.charter.pages.ChooseAptPage;
import com.test.charter.pages.LandingPage;

public class ChooseAptPageTestCase extends Base
{

WebDriver driver;

@BeforeClass
public void setUp()
{
driver=getDriver();
}

@Test
public void testAptPage() throws InterruptedException
{
	//Given
	LandingPage land= PageFactory.initElements(driver, LandingPage.class);
	Assert.assertEquals(land.enterAddressDetail(), true);
	ChooseAptPage apt= land.clickonLoginButton();
	
	//When
	//Assert.assertEquals(apt.isAptPagePresent(), true);
	System.out.println(driver.getTitle());
	Assert.assertEquals(apt.VerifyTitleOnApt(), true);
	
	//Then
	apt.doChooseAddress();
	System.out.println("TestCase 2 Choose Apartment is completed");	
}

}
