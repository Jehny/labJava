package lab.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.page.EcobeePage;


public class EcobeeTest extends EcobeePage{
	
	EcobeePage ecobeePage;
	
	String optionSignal = "1";
	String optionTelegram = "2";
	String optionThreema = "3";
	String optionSilence = "4";
	String optionViber = "5";
	String optioniMessage = "6";
	String optionSMS = "7";
	String optionOther = "8";
	
	@BeforeClass
	public void setUP() throws IOException {
		ecobeePage = new EcobeePage();
		ecobeePage.goToPage();
		
	}
	
	@Test (priority = -1, description = "Articles")
	public void countHowManyArticles() {
		ecobeePage.howManyArticles();
		
	}
	
	@Test (priority = 1, description = "Icons on Titles")
	public void countIconsOnTitle() {
		ecobeePage.howManyIcons();
	}
	
	@Test (priority = 2, description = "Vote daily Polls")
	public void vote() throws InterruptedException {
		
		voteDailyPoll(optionTelegram);
	}
}
