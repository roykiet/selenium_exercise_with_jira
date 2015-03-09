package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageObject {

	@FindBy(id="create_link")
	WebElement btnCreate;
	@FindBy(xpath = "//*[@id='user-options']/a")
	WebElement btnLogin;
	@FindBy(id = "quickSearchInput")
	WebElement txtQuickSearch;
	
	public BasePage(WebDriver driver){
		super(driver);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the User name
	public void openCreateIssuePopup(){
		this.waitingHandler.waitUntilElementPresence(btnCreate);
		btnCreate.click();
	}
	
	//Login with username and password
	public void Login(String email, String password){
		btnLogin.click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithUsernameAndPassword(email, password);
	}
	
	//Search issue
	public void searchIssue(String searchText){
		txtQuickSearch.sendKeys(searchText);
		txtQuickSearch.submit();
	}
}