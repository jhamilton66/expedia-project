package com.sqa.jh;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class BasicTest {
	private static String baseURL = "http://mtv.com";
	private static WebDriver driver;

	/**
	 * @return the baseURL
	 */
	public static String getBaseURL() {
		return baseURL;
	}

	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeClass(enabled = true)
	public static void setupChrome() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(enabled = false)
	public static void setupFirefox() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		// driver.quit();
	}

	/**
	 *
	 */
	public BasicTest(String baseURL) {
		super();
		BasicTest.baseURL = baseURL;
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setupTest() {
		getDriver().manage().deleteAllCookies();
		// Maximize window
		getDriver().manage().window().maximize();
		// Go to base URL
		getDriver().get(getBaseURL());

	}

}
