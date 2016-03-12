package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseFlowTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setupTest(){
		driver = new ChromeDriver();
		//Go to JIRA HomePage
		driver.get("https://jira.atlassian.com/secure/Dashboard.jspa");
	}
	
	@AfterTest
	public void tearDownTest(){
		//Dispose driver
		if(driver != null){
			driver.close();
			driver.quit();
		}
	}
}
