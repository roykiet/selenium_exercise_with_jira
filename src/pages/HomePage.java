package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	String url = "https://jira.atlassian.com/secure/Dashboard.jspa";
	By msgCreateIssue = By.xpath("//*[@class='issue-created-key issue-link']");
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public boolean isMsgCreateIssueExist(){
		this.waitingHandler.waitUntilElementPresenceWithBy(msgCreateIssue);
		WebElement element  = this.driver.findElement(msgCreateIssue);
		if (element != null){
			return element.isDisplayed();
		}else{
			return false;
		}
	}
	
	public void openIssueThroughCreateMsg() throws Exception{
		if (this.driver.findElements(msgCreateIssue).size() > 0){
			this.driver.findElement(msgCreateIssue).click();
		}else{
			throw new Exception("Message created issue does not exist.");
		}
	}
	
	//This function is used for get key of issue which was created successfully.
	public String getCreatedIssueKey(){
		return this.driver.findElement(msgCreateIssue).getAttribute("data-issue-key");
	}
}