package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditIssuePage extends PageObject {
	@FindBy(id = "summary-val")
	WebElement headerSummary;
	@FindBy(id = "summary")
	@CacheLookup
	WebElement txtSummary;
	@FindBy(css = "a.issue-link")
	WebElement linkIssue;

	public EditIssuePage(WebDriver driver) {
		super(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public String getIssueID() throws Exception {
		this.waitingHandler.waitUntilElementPresence(this.linkIssue);
		if (this.linkIssue != null) {
			return this.linkIssue.getText();
		} else {
			throw new Exception("link of id issue does not exist.");
		}
	}

	public String getIssueSummary() throws Exception {
		this.waitingHandler.waitUntilElementPresence(this.headerSummary);
		if (this.headerSummary != null) {
			return this.headerSummary.getText();
		} else {
			throw new Exception("Header summary does not exist.");
		}
	}

	public void updateIssueSummary(String summary) throws Exception {
		this.waitingHandler.waitUntilElementPresence(this.headerSummary);
		if (this.headerSummary != null) {
			this.actions.moveToElement(this.headerSummary);
			this.headerSummary.click();
			this.waitingHandler.waitUntilElementPresence(this.txtSummary);
			this.txtSummary.sendKeys(summary);
			this.txtSummary.submit();
			this.waitingHandler.waitUntilElementNotPresence(this.txtSummary);
		} else {
			throw new Exception("Header summary does not exist.");
		}
	}
}