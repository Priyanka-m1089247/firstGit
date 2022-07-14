package com.pageobjects;

import org.openqa.selenium.WebDriver;

import com.uistore.TollFreeUI;

public class TollFreeObject {

	public static void Lighting(WebDriver driver) {
		driver.findElement(TollFreeUI.lighting).click();
	}
	
}
