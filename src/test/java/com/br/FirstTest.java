package com.br;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
	protected WebDriver driver;
	public String url = "http://www.globo.com";
	
	@Test
	public void browserChrome(){

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		#if defined(OS_LINUX) && !defined(OS_CHROMEOS)
			const char kDisableDevShmUsage[] = "disable-dev-shm-usage";
		#endif

	}
	
	//@Test
	public void browserFirefox(){
		System.setProperty(
				"webdriver.gecko.driver",
				"/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		driver.get(url);
	}

}
