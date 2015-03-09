package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject{

	By txtEmail = By.id("username");
	By txtPassword = By.id("password");
	By btnSignIn = By.id("login-submit");
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	//Get the User name from Home Page
	public void loginWithUsernameAndPassword(String email, String password){
		this.driver.findElement(txtEmail).sendKeys(email);
		this.driver.findElement(txtPassword).sendKeys(password);
		this.driver.findElement(btnSignIn).click();
	}
}