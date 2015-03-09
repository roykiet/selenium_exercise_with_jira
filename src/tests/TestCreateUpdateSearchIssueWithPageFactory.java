package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagefactory.CreateIssuePage;
import pagefactory.EditIssuePage;
import pagefactory.HomePage;

public class TestCreateUpdateSearchIssueWithPageFactory extends BaseFlowTest{

	HomePage objHomePage;
	CreateIssuePage objCreateIssueForm;
	EditIssuePage objEditIssuePage;
	
	@BeforeClass
	public void setup(){
		//Initialize Home Page object
		objHomePage = new HomePage(driver);
		//Initialize Create issue page
		objCreateIssueForm = new CreateIssuePage(driver);
		//Initialize Edit issue Page
		objEditIssuePage = new EditIssuePage(driver);
		//Login to Jira
		objHomePage.Login("roykiet@yahoo.com", "l0gigear");
	}

	
	@Test(priority=1)
	public void test_User_Can_Create_Issue() throws Exception{
		//Open create issue form
		objHomePage.openCreateIssuePopup();
		//Fill summary and finish creating new issue
		objCreateIssueForm.createIssueWithSummary("Verify that user can CREATE issue successfully.");
		//Verify created issue message appears.
		objHomePage.isMsgCreateIssueExist();
		//Verify issue is created successfully
		objHomePage.openIssueThroughCreateMsg();
		//Get issue summary
		String issueSummary = objEditIssuePage.getIssueSummary();
		//Verify issue summary is the same input.
		Assert.assertEquals(issueSummary, "Verify that user can CREATE issue successfully.");
	}
	
	@Test(priority=2)
	public void test_User_Can_Update_Issue() throws Exception{
		//Edit summary of issue
		objEditIssuePage.updateIssueSummary("Verify that user can EDIT issue successfully.");
		//Refresh page
		driver.navigate().refresh();
		//Get issue summary
		String issueSummary = objEditIssuePage.getIssueSummary();
		//Verify issue summary is the same input.
		Assert.assertEquals(issueSummary, "Verify that user can EDIT issue successfully.");
	}
	
	@Test(priority=3)
	public void test_User_Can_Search_Issue_By_Issue_ID() throws Exception{
		//Get ID of current Issue
		String issueID = objEditIssuePage.getIssueID();
		//Go to home page
		driver.get(objHomePage.getUrl());
		//Search issue by id
		objHomePage.searchIssue(issueID);
		//Verify issue is found successfully
			//Get issue summary
		String issueSummary = objEditIssuePage.getIssueSummary();
			//Verify issue summary is the same input.
		Assert.assertEquals(issueSummary, "Verify that user can EDIT issue successfully.");
			//Get ID of current Issue.
		String actualIssueID = objEditIssuePage.getIssueID();
			// Verify found issue id is correct.
		Assert.assertEquals(actualIssueID, issueID);
	}
}
