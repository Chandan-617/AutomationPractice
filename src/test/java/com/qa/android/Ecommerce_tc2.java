package com.qa.android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_tc2 extends EcommerceBaseTest{
	
	@Test
	public void fillForm() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Lovely");
		driver.hideKeyboard();
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		//driver.findElement(By.xpath("android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		/*
		 * String
		 * toastmessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).
		 * getAttribute("name"); Assert.assertEquals(toastmessage,
		 * "Please enter your name");
		 */
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));

		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<productCount;i++)
		{
			
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
			}
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String lastpageproduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastpageproduct, "Jordan 6 Rings");
		
	}
	
	
	

}
