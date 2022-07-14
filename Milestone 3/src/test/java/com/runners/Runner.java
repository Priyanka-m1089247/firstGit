package com.runners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.pageobjects.AutoMotivePageObject;
import com.pageobjects.TVPageObject;
import com.pageobjects.TollFreeObject;
import com.reusablemethods.Windowhandles;
import com.utilities.PropertyClass;
import com.utilities.Screenshot;
import com.utilities.baseClass;



public class Runner extends baseClass{
	PropertyClass property;
	public baseClass baseObj=new baseClass();
	public Screenshot ScreObj=new Screenshot();
	
	Logger log=LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void Extent() {
		baseObj.ExtentReport();
	}
	
	@BeforeMethod
public void navigateToLandingPage() throws IOException {
		property=new PropertyClass();
		driver=InitializeDriver();
		driver.manage().window().maximize();
		log.info("initialized driver");
		driver.get(property.geturl());
		
	}
	
	

	@Test
	public void NavigatingTV() throws IOException {
	
		extentTest=extent.createTest("NavigatingTV");
		
		TVPageObject.Button(driver);
		TVPageObject.Searchbox(driver);
		log.info(" keys has sent as TV ");
		String FirstElement=TVPageObject.Textvali(driver);
		Assert.assertTrue(FirstElement.contains("TV"));
		log.info("Text TV matched with FirstElement ");
		
		
		
	}
	@Test
	public void NavigatingAutoMotive() throws IOException {
		
		extentTest=extent.createTest("NavigatingAutoMotive");
		
		AutoMotivePageObject.MouseHover(driver);
		log.info("mouse hovered on Automotive");
		AutoMotivePageObject.Carlights(driver);
		log.info("clicked on carlights");
		
		
		boolean Automotive=driver.getPageSource().contains("Philips Automotive");
		Assert.assertTrue(Automotive);
		log.info("Philips Automotive is validated");
	}
	@Test
	public void NavigatingTollFreeNo() {
		extentTest=extent.createTest("NavigatingTollFreeNo");
		TollFreeObject.Lighting(driver);
		log.info("clicked on lightings");
		Windowhandles.handle(driver);
		
		log.info("switched to chiledwindow");
		
		boolean TollNo=driver.getPageSource().contains("000 800 050 7777");
		Assert.assertTrue(TollNo);
		log.info("TollFree number is validated");
	}
	
	@AfterMethod
	public void Teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "The Test case Failed is"+result.getName());
			
			String temp=Screenshot.getScreenshot(driver);
			extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "The Test case skiped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "The Test case passed is"+result.getName());
		}
		driver.quit();
	}
	@AfterTest
	public void endreport() {
		extent.flush();
		
		
	}
	

}
