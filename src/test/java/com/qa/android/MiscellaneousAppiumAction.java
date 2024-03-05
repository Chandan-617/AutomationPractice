package com.qa.android;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumAction extends BaseTest{
	
	
	public void miscellaneous() throws MalformedURLException
	{
	
		
		//For Windows:

//adb shell dumpsys window | find "mCurrentFocus"
	Activity act=new Activity("io.appium.android.apis", "io.appium.android.apis.view.DragAndDropDemo");

	driver.startActivity(act);
	
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

	
	driver.findElement(By.id("android:id/checkbox")).click();
	
	DeviceRotation landscape=new DeviceRotation(0,0,90);
	driver.rotate(landscape);
	
	driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	
	String alerttitle=driver.findElement(By.id("android:id/alertTitle")).getText();
	Assert.assertEquals(alerttitle, "WiFi settings");
	
	//copy to clip board --pasted to clip board
	
	driver.setClipboardText("Rahul Wifi");
	
	driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	
	driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	
	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
	}
}
