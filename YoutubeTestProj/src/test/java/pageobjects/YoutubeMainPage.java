package pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YoutubeMainPage extends BasePage{
	
	@FindBy(css = "input")
	private WebElement m_inputSearchTextbox; 
	
	@FindBy(css = "#search-icon-legacy")
	private WebElement m_searchButton; 
	
	@FindBy(css= "#container > ytd-toggle-button-renderer > yt-button-shape > button" )
	private WebElement m_filterButton;
	
	@FindBy(css= "#collapse-content > :nth-child(2) > ytd-search-filter-renderer >  :first-child")
	private WebElement m_videoResultsOnlyFilter;
	
	@FindBy(css= "#collapse-content > ytd-search-filter-group-renderer:nth-child(5) >:nth-child(6) > a")
	private WebElement m_viewCountFilter;
	
	@FindBy(css= "#contents>ytd-video-renderer")
	private List<WebElement> m_videoResults; 
			
	public YoutubeMainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void searchForCertainVideo(String textToSearch){
		//Click on Input search text box
		 click(m_inputSearchTextbox);
		 
		 //Put Search text in the search text-box 
		 fillText(m_inputSearchTextbox, textToSearch);
		 //Click on search button
		 click(m_searchButton);
	}
	
	public void selectVideoResultsFilter() {
		sleep(1000);
		
        click(m_filterButton);
        sleep(2000);
        click(m_videoResultsOnlyFilter);
	}
	
	public void selectViewCountFilter() {
        sleep(1000);
        click(m_filterButton);
        sleep(2000);
		click(m_viewCountFilter);
	}

	
	public void clickOnVideoResult(String urlToSearch){
		for (WebElement videoItem : m_videoResults)
        {
            WebElement videoLink = videoItem.findElement(By.cssSelector("div>ytd-thumbnail>a"));
            String href = videoLink.getAttribute("href");
            	//Log video channel	
            	logger.info(href);
     
            if (href.equals(urlToSearch))
            {
                String channelName = videoItem.findElement(By.cssSelector("div>div>div>ytd-channel-name>div>div>yt-formatted-string>a")).getText();
                logger.info(channelName);
                videoLink.click();
                break; 
            }	
        }
	}
	
}
