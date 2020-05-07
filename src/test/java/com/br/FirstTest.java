package com.br;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstTest {
	protected WebDriver driver;
	public String url = "http://www.globo.com";
	
	//@Test
	public void browserIE() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\Jehny\\eclipse-workspace\\labJava\\drivers\\IEDriverServer4.0.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	//@Test
	public void browserChrome(){

		System.setProperty(
		"webdriver.chrome.driver",
		"C:\\Users\\Jehny\\eclipse-workspace\\labJava\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);

	}
	
	@Test
	public void browserFirefox(){
		System.setProperty(
				"webdriver.gecko.driver",
				"C:\\Users\\Jehny\\eclipse-workspace\\labJava\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
	}

}
