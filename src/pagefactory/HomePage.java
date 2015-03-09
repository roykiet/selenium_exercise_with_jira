package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	String url = "https://jira.atlassian.com/secure/Dashboard.jspa";
	@FindBy(xpath="//*[@class='issue-created-key issue-link']")
	WebElement msgCreateIssue;
	
	public HomePage(WebDriver driver){
		super(driver);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public boolean isMsgCreateIssueExist(){
		this.waitingHandler.waitUntilElementPresence(msgCreateIssue);
		if (this.msgCreateIssue != null){
			return this.msgCreateIssue.isDisplayed();
		}else{
			return false;
		}
	}
	
	public void openIssueThroughCreateMsg() throws Exception{
		if (this.msgCreateIssue != null){
			this.msgCreateIssue.click();
		}else{
			throw new Exception("Message created issue does not exist.");
		}
	}
	
	//This function is used for get key of issue which was created successfully.
	public String getCreatedIssueKey(){
		return this.msgCreateIssue.getAttribute("data-issue-key");
	}
}