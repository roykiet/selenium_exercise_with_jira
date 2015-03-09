package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateIssuePage extends PageObject{

	@FindBy(id="summary")
	WebElement txtSummary;
	@FindBy(id="create-issue-submit")
	@CacheLookup
	WebElement btnCreateIssue;
	
	public CreateIssuePage(WebDriver driver){
		super(driver);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	public void createIssueWithSummary(String summary) throws Exception{
		this.waitingHandler.waitUntilElementPresence(this.txtSummary);
		this.txtSummary.sendKeys(summary);
		
		this.waitingHandler.waitUntilElementPresence(this.btnCreateIssue);
		this.btnCreateIssue.click();
	}
}