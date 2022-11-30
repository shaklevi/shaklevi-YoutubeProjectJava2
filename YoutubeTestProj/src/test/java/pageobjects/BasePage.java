package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	WebDriver driver;
	Actions action;
	String mainWindow; // keep the main window name
	WebDriverWait wait;
	public Logger logger; 

	public BasePage(WebDriver driver) {
		this.logger = Logger.getLogger(this.getClass());
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	}

	protected void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}
	
	protected void click(WebElement el) {
			sleep(200);
			el.click();
	}

	protected String getText(WebElement el) {
		return el.getText();
	}

	//Overloading
	void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	
	void alertOK() {
		driver.switchTo().alert().accept();
	}
	
	String getAttribute(WebElement el, String key) {
		return el.getAttribute(key);
	}
	
	void moveToElement(WebElement el) {
		action.moveToElement(el).build().perform();
	}
	
	void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		//move to new window
		for (String win : list) {
			driver.switchTo().window(win);
		}
	}
	
	void moveToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}
		
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void scrollDownPage(int scale){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,"+scale+")", "");		
	}
	
	public void waitVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public void waitInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}
}
