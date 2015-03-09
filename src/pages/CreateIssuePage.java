package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateIssuePage extends PageObject{

	By txtSummary = By.id("summary");
	By btnCreateIssue = By.id("create-issue-submit");
	
	public CreateIssuePage(WebDriver driver){
		super(driver);
	}
	public void createIssueWithSummary(String summary) throws Exception{
		this.waitingHandler.waitUntilElementPresenceWithBy(txtSummary);
		this.driver.findElement(txtSummary).sendKeys(summary);
		
		this.waitingHandler.waitUntilElementPresenceWithBy(btnCreateIssue);
		this.driver.findElement(btnCreateIssue).click();
		
		this.waitingHandler.waitUntilElementNotPresenceWithBy(btnCreateIssue);
	}
}