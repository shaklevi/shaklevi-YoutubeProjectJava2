package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MoviePage extends BasePage {
	
	@FindBy(xpath= "//*[@id='skip-button:6']/span/button")
	WebElement m_skipButton;
	
	@FindBy(css= "tp-yt-paper-button[id=expand]")
	WebElement m_expandMore;
	
	@FindBy(css="#description-inline-expander > yt-formatted-string")
	WebElement m_videoInfo;
	
	@FindBy(css="#default-metadata > a")
	List<WebElement> m_informationFields; 
	
	public MoviePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void skipAdvertisement() {
		sleep(5000);
		try {
			click(m_skipButton);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void extractVideoInfo() {
	   scrollDownPage(400);
	   WebElement m_expandMore = driver.findElement(By.cssSelector("tp-yt-paper-button[id=expand]"));
       click(m_expandMore);
       //Log Artists's name
       logger.info(m_informationFields.get((int)1).getText());
	}
}
