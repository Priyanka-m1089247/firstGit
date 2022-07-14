package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.uistore.TVPageUI;
import com.utilities.ExcelData;

public class TVPageObject {
	public static ExcelData Excel;
	public static void Button(WebDriver driver) {
		driver.findElement(TVPageUI.button).click();
		}

	public static void Searchbox(WebDriver driver) {
		Excel=new ExcelData();
		String Text=Excel.getStingData( "Sheet1",  2, 2);
		  driver.findElement(TVPageUI.searchbox).sendKeys(Text);
		  driver.findElement(TVPageUI.searchbox).sendKeys(Keys.ENTER);
		
	}
	public static  String Textvali(WebDriver driver) {
		  return driver.findElement(TVPageUI.textvali).getText();
		
	}
	
	
	
	
}
