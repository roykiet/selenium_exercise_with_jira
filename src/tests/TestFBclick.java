package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.EditIssuePage;
import pages.HomePage;
import utilities.WaitingHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestFBclick{
    WebDriver driver;
	WaitingHandler waitingHandler;
	Actions actions;
	String[] arr_link = {"SHFrXL", "SHFrXp", "SH7FfK"};

	@BeforeClass
	public void setup(){
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("user-data-dir=C:/Users/kietchau/AppData/Local/Google/Chrome/New User");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		waitingHandler = WaitingHandler.getInstance(driver, 50);
		//Go to JIRA HomePage
		driver.get("https://www.facebook.com/groups/1629713070597181/");
	}

	
	@Test(priority=1)
	public void test_FB_click() throws Exception{
        Thread.sleep(5000);
        if (driver.getTitle().equalsIgnoreCase("Đăng nhập Facebook | Facebook")) {
            driver.findElement(By.id("email")).sendKeys("shockman139@yahoo.com");
            driver.findElement(By.id("pass")).sendKeys("l0gigear");
            driver.findElement(By.id("loginbutton")).click();
			Thread.sleep(10000);
        }
		while(true){
			for(String link : arr_link){
				this.driver.findElement(By.xpath("//a[contains(@href,'" + link + "')]")).click();
                Thread.sleep(1000);
            }
            //Thread.sleep(3000);
            Set<String> setHandles = driver.getWindowHandles();
            String[] arrWindowHandles = setHandles.toArray(new String[setHandles.size()]);
            for(int i = 1; i < arrWindowHandles.length; i++){
                driver.switchTo().window(arrWindowHandles[i]);
                driver.close();
                driver.switchTo().window(arrWindowHandles[0]);
            }
		}
	}
}
