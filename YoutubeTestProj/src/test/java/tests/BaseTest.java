package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import utils.Utils;

public class BaseTest {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String urlStr = Utils.readProperty("url");
		driver.get(Utils.readProperty("url"));
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public void tearDown() {
//		driver.quit();
	}
}
