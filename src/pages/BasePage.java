package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject {

	By btnCreate = By.id("create_link");
	By btnLogin = By.xpath("//*[@id='user-options']/a");
	By txtQuickSearch = By.id("quickSearchInput");
	
	public BasePage(WebDriver driver){
		super(driver);
	}
	
	//Get the User name
	public void openCreateIssuePopup(){
		this.waitingHandler.waitUntilElementPresenceWithBy(btnCreate);
		this.driver.findElement(btnCreate).click();
	}
	
	//Login with username and password
	public void Login(String email, String password){
		this.driver.findElement(btnLogin).click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithUsernameAndPassword(email, password);
	}
	
	//Search issue
	public void searchIssue(String searchText){
		this.driver.findElement(txtQuickSearch).sendKeys(searchText);
		this.driver.findElement(txtQuickSearch).sendKeys("\n");
	}
}