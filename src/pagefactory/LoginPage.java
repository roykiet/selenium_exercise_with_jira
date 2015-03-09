package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject{

	@FindBy(id="username")
	WebElement txtEmail;
	@FindBy(id="password")
	WebElement txtPassword;
	@FindBy(id="login-submit")
	WebElement btnSignIn;
	
	public LoginPage(WebDriver driver){
		super(driver);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the User name from Home Page
	public void loginWithUsernameAndPassword(String email, String password){
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnSignIn.click();
	}
}