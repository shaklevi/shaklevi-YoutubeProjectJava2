package tests;

import org.testng.annotations.Test;
import pageobjects.MoviePage;
import pageobjects.YoutubeMainPage;

public class SearchAndPlayVideoItemTest extends BaseTest{
	
	

	@Test(description = "Search for movie and play it.")
	public void tc_01_searchAndPlayVideoContent() {
		YoutubeMainPage youtubePage = new YoutubeMainPage(getDriver());
		youtubePage.searchForCertainVideo("I Will Survive - Alien song");
		youtubePage.selectVideoResultsFilter();
		youtubePage.selectViewCountFilter();
		youtubePage.clickOnVideoResult("https://www.youtube.com/watch?v=ybXrrTX3LuI");
		MoviePage moviePage= new MoviePage(getDriver());
		moviePage.skipAdvertisement();
		moviePage.extractVideoInfo();
		
	}
}
