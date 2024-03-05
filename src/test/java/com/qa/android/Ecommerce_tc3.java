package com.qa.android;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Ecommerce_tc3 extends EcommerceBaseTest{
	
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
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		
		
		Thread.sleep(5000);
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		
		List<WebElement> productprices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productprices.size();
		
		double totalsum=0;
		for(int i=0;i<count;i++)
		{
			
			String amountString=productprices.get(i).getText();
			
			
			Double price=getFormattedAmount(amountString);
			totalsum=totalsum+price;
			
			
		}
		String displaysum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum=getFormattedAmount(displaysum);
		Assert.assertEquals(totalsum, displayFormattedSum);
		
		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		longPressGesture(ele);
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(2000);
	}
	
	
	

}
