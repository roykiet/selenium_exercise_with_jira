package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitingHandler{

	private static WaitingHandler instance = null;
	//WebDriverWait webDriverWait;
	FluentWait<WebDriver> fluentWait;
	WebDriver driver;
	long timeout;
	
	//Get waiting handler instance
	public static WaitingHandler getInstance(WebDriver driver, long timeout) {
		if(instance == null) {
			instance = new WaitingHandler(driver, timeout);
		}else if (instance.timeout != timeout){
			instance = new WaitingHandler(driver, timeout);
		}
		return instance;
	}
	
	private WaitingHandler(WebDriver driver, long timeout){
		this.driver = driver;
		this.timeout = timeout;
		//this.webDriverWait = new WebDriverWait(driver, this.timeout);
		fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
	}
	
	//Function to set default timeout
	public void setTimeOut(long timeout){
		this.timeout = timeout;
		this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
	}
	
	public void waitUntilElementNotPresenceWithBy(By locator){
		WebElement element = driver.findElement(locator);
		this.fluentWait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public void waitUntilElementPresenceWithBy(By locator){
		this.fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitUntilElementPresence(WebElement element){
		this.fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementNotPresence(WebElement element){
		this.fluentWait.until(ExpectedConditions.stalenessOf(element));
	}
}