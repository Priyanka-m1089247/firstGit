package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uistore.AutoMotivePageUI;

public class AutoMotivePageObject {
	
	public static void MouseHover(WebDriver driver) {
		WebElement ele=driver.findElement(AutoMotivePageUI.mousehover);
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		}
	public static void  Carlights(WebDriver driver) {
		 driver.findElement(AutoMotivePageUI.carlights).click();
		}
	
	public static String AutomotiveText(WebDriver driver) {
		 return driver.findElement(AutoMotivePageUI.automotivetext).getText();
		}
	
	
	
}
