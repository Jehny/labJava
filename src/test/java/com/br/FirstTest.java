package com.br;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	public static WebDriver createChromeDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public Wait<WebDriver> createWebDriverWait(WebDriver driver) {
		return createWait(driver, 10, 100);
	}

	public Wait<WebDriver> createWait(WebDriver driver, long withTimeout, long pollingEvery) {
		return new FluentWait<WebDriver>(driver).withTimeout(withTimeout, TimeUnit.SECONDS)
				.pollingEvery(pollingEvery, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}
}

public class FirstTest {
	protected WebDriver driver;
	public String url = "http://www.globo.com";
	
	//@Test
	public void browserIE() {
		System.setProperty("webdriver.ie.driver",
				"drivers\\IEDriverServer4.0.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void browserChrome(){

		System.setProperty(
		"webdriver.chrome.driver",
		"/usr/bin/chromedrive");
		driver = new ChromeDriver();
		driver.get(url);

	}
	//@Test
	public void browserFirefox(){
		System.setProperty(
				"webdriver.gecko.driver",
				"drivers\\geckodriver");
		driver = new FirefoxDriver();
		driver.get(url);
	}

}
