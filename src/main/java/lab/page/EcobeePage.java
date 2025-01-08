package lab.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import lab.base.BaseTest;

public class EcobeePage extends BaseTest{
	private WebDriverWait wait;
	
	public void goToPage() {
		wait = new WebDriverWait(driver, BaseTest.WAIT_TIME);
		driver.get(BaseTest.currentBaseUrl);
	}
	
	public void howManyArticles() {
		
		List<WebElement> listArticles = driver.findElements(By.cssSelector("#firehoselist > article"));
		report.logInfo("There are " +listArticles.size() +" Articles on the Page");

		System.out.println("Articles = " + listArticles.size());
		
	}
	
	public void howManyIcons() {
		List<WebElement> iconArticles = driver.findElements(By.cssSelector("#firehoselist > article > header > .topic > a > img"));
		ArrayList<String> iconsName = new ArrayList();
//		System.out.println("Imagens nos Headers = " + iconArticles.size());
		for (WebElement webElement : iconArticles) {
			iconsName.add(webElement.getAttribute("title"));
			report.logInfo("Icons Name = " + webElement.getAttribute("title"));
			System.out.println("Atribute Title = " + webElement.getAttribute("title"));
			
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String names : iconsName) {
			
			names.contains(names);
			if(map.keySet().contains(names))
		    {
		        map.put(names, map.get(names)+1);

		    }else
		    {
		        map.put(names, 1);
		    }
		}
		report.logInfo("Count Name Icons = " + map);
		System.out.println("Count Names = " + map);
	}
	
	public void voteDailyPoll(String option) throws InterruptedException {
		String pathForm = "input";
		String optionVote = "Telegram";
		// click on menu Polls
		clickLinkByText("Polls");
		
		// wait until page load
		waitForSomethingByType("id", "pollBooth");
		
		// Vote
		clickRadioButtonByValue(pathForm, option);
		
		// click button
		clickButtonByText("vote now");
		
		// Get the number of votes
		getValueOfVotes(optionVote);
	}
	
	public void getValueOfVotes(String option) {
		List<WebElement>  groups = driver.findElements(By.className("poll-bar-group"));
		report.logInfo("Option voted = " + option);
		for (WebElement group : groups) {
			String name = group.findElement(By.className("poll-bar-label")).getText();
			if(name.equals(option)) {
				String value = group.findElement(By.className("poll-bar-text")).getText();
				report.logInfo("Quantity of Votes = " + value);
				System.out.println("Quantity of Votes = " + value);
			}
		}
	}

}
