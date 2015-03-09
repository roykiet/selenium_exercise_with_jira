package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.WaitingHandler;

public class PageObject {

	WebDriver driver;
	Actions actions;
	WaitingHandler waitingHandler;
	public String url;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
		this.actions = new Actions(driver);
		waitingHandler = WaitingHandler.getInstance(driver, 50);
	}
}