package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditIssuePage extends PageObject{
	By headerSummary = By.id("summary-val");
	By txtSummary = By.id("summary");
	By linkIssue = By.cssSelector("a.issue-link");
	
	public EditIssuePage(WebDriver driver){
		super(driver);
	}
	
	public String getIssueID() throws Exception{
		this.waitingHandler.waitUntilElementPresenceWithBy(linkIssue);
		if(this.driver.findElements(linkIssue).size() > 0){
			return this.driver.findElement(linkIssue).getText();
		}else{
			throw new Exception("link of id issue does not exist.");
		}
	}
	
	public String getIssueSummary() throws Exception{
		this.waitingHandler.waitUntilElementPresenceWithBy(headerSummary);
		if(this.driver.findElements(headerSummary).size() > 0){
			return this.driver.findElement(headerSummary).getText();
		}else{
			throw new Exception("Header summary does not exist.");
		}
	}
	
	public void updateIssueSummary(String summary) throws Exception{
		this.waitingHandler.waitUntilElementPresenceWithBy(headerSummary);
		if(this.driver.findElements(headerSummary).size() > 0){
			WebElement headerSummaryElement = this.driver.findElement(headerSummary); 
			this.actions.moveToElement(headerSummaryElement);
			headerSummaryElement.click();
			this.waitingHandler.waitUntilElementPresenceWithBy(txtSummary);
			this.driver.findElement(txtSummary).sendKeys(summary);
			this.driver.findElement(txtSummary).sendKeys("\n");
			this.waitingHandler.waitUntilElementNotPresenceWithBy(txtSummary);
		}else{
			throw new Exception("Header summary does not exist.");
		}
	}
}