package com.test.charter.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.charter.base.Base;
import com.test.charter.pages.ChooseAptPage;
import com.test.charter.pages.LandingPage;
import com.test.charter.utilities.ExcelReader;

public class LandingPageTestCase extends Base
{
	
WebDriver driver;	
ExcelReader reader;

@BeforeClass
public void setUp()
{
	driver=getDriver();
	reader=getExcelReader();
}

@Test
public void testLandingPage()
{
	//Given
	LandingPage land= PageFactory.initElements(driver, LandingPage.class);
	
	//When
	Assert.assertEquals(land.userNavigateToCharterPage(), true);
	Assert.assertEquals(land.enterAddressDetail(), true);
	
	//Then
	land.clickonLoginButton();
	System.out.println("Test Case 1 for Landing Page is Completed");
}
	
@DataProvider
public Object[][] getDataProvider()
{
	String [][] data = new String[reader.getRowCount("OrderDetail")][reader.getColumnCount("OrderDetail")];
	for(int i=0;i<reader.getRowCount("OrderDetail");i++)
	{
		for(int j=0;j<reader.getColumnCount("OrderDetail");j++)
		{
			
			data[i][j]=reader.getCellData("OrderDetail", i+1, j);
			System.out.println(data[i][j]);
			
		}
		
	}
	return data;
}

}
