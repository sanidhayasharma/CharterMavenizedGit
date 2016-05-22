package com.test.charter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomizeOfferPage {

	WebDriver driver;
	
public CustomizeOfferPage(WebDriver driver)
{	
	this.driver=driver;
}
	
@FindBy(how=How.XPATH , using="//*[@id='equipment-anchor']/div/div/div/form/fieldset[1]/div[3]/div[1]/label/span")
public WebElement DVR;

@FindBy(how=How.XPATH , using="//*[@id='equipment-anchor']/div/div/div/form/fieldset[2]/div/div/div[2]/div/div[1]/div[1]/select")
public WebElement HDBOX;

@FindBy(how=How.XPATH , using="//*[@id='autoCust4065210_yes']/span")
public WebElement WIFI;

@FindBy(how=How.XPATH , using="//*[@id='phone_option_port_new_number']/span")
public WebElement NewNumber;

@FindBy(how=How.XPATH , using="//*[@id='autoCust4075252_no']/span")
public WebElement Listed;

@FindBy(how=How.XPATH , using="//*[@id='cust7540_1_no']/span")
public WebElement Batteryback;

@FindBy(how=How.XPATH , using="//*[@id='customize-your-order']/section/section/div/span/div[3]/div/div[4]/div[8]/dl/dd[1]/span")
public WebElement OrderTotal;

@FindBy(how=How.XPATH , using="//*[@id='continue_btn_side_cart']")
public WebElement CartButton;


public boolean testOrderTotal()
{
	try
	{
			double total=0.0;
			String actual_total="";
		    for(int i=1;i<=5;i++)
		    {
		    Thread.sleep(2000);
			String str3=driver.findElement(By.xpath("//*[@id='customize-your-order']/section/section/div/span/div[3]/div/div[4]/div["+i+"]/dl[2]/dd")).getText();
			Thread.sleep(1000);
			str3=str3.substring(1);
			System.out.println(str3);
			double conversion=Double.parseDouble(str3);
			total+=conversion;
		    }
			if(DVR.isEnabled() || DVR.isDisplayed())
			{
				DVR.click();
				Thread.sleep(3000);
				if(HDBOX.isDisplayed() || HDBOX.isEnabled())
				{
					Select select = new Select(HDBOX);
					select.selectByIndex(2);
					total=total+6.99+16.98;
				}
				
			}
			if(WIFI.isDisplayed() || WIFI.isEnabled())
			{
				WIFI.click();
				Thread.sleep(3000);
				total+=5.00;
			}
			if(NewNumber.isSelected() || NewNumber.isDisplayed())
			{
				NewNumber.click();
				Thread.sleep(3000);
				if(Listed.isSelected() || Listed.isDisplayed())
				{
					Listed.click();
				}
			}
			Thread.sleep(3000);
			if(Batteryback.isSelected() || Batteryback.isDisplayed())
			{
				Batteryback.click();
			}
		    System.out.println(total);
		    actual_total=String.valueOf(total);
		    Thread.sleep(5000);
		    Assert.assertTrue("Rate conflict", OrderTotal.getText().substring(1).equals(actual_total));		    
		    return true;
	}
   catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("TV Silver price not retrieved");
	}
	return false;
}

public CustomerInformationPage clickCart()
{
	try
	{
		if(CartButton.isEnabled() || CartButton.isDisplayed())
		{
			((JavascriptExecutor) driver).executeScript("document.getElementById('continue_btn_side_cart').click()");
			 Thread.sleep(5000);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Cart Selection Issue");
	}
	return PageFactory.initElements(driver, CustomerInformationPage.class);
	
}

}
