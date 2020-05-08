package com.br;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {
	protected WebDriver driver;
	public String url = "http://www.globo.com";
	
	@Test
	public void browserChrome(){

		System.setProperty(
				"webdriver.chrome.driver",
				"/usr/bin/chromium-browser");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--test-type");
				options.addArguments("test-type");
				options.addArguments("start-maximized");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--enable-precise-memory-info");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("test-type=browser");
				options.addArguments("--incognito");
				options.addArguments("--no-sandbox");
				driver = new ChromeDriver(options);
				driver.get(url);
	}
}
