package com.reusablemethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Windowhandles {
	public static WebDriver driver;
	public Windowhandles(WebDriver driver) {
		Windowhandles.driver=driver;
	}
	public static  void handle(WebDriver driver) {
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		
		
	}
	
}
