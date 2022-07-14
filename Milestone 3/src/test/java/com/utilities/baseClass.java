package com.utilities;

import java.io.File;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseClass {

	public static WebDriver driver;
	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public WebDriver InitializeDriver() throws IOException {
		
		
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
		
			driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	public  void ExtentReport() {
		 htmlReporter = new ExtentHtmlReporter(new File("./report/Extent.html"));
		 htmlReporter.config().setEncoding("utf-8");
		 htmlReporter.config().setDocumentTitle("HTML Report");
		 htmlReporter.config().setReportName("TestResult");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 extent=new ExtentReports();
		 extent.setSystemInfo("mindtree", "automation");
		 extent.setSystemInfo("browser", "chrome");
		 extent.attachReporter(htmlReporter);
	}
	
	
}
