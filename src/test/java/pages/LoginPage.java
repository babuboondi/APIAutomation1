package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
	    this.driver = driver;
		
	}
	
	By enterUsername = By.id("user-name");
	By enterPassword = By.name("password");
	By clickBtn      = By.xpath("//input[@type='submit']");

	
	public void enterUn() {
		driver.findElement(enterUsername).sendKeys("standard_user");
		
	}
    
	public void enterPw() {
		driver.findElement(enterPassword).sendKeys("secret_sauce");
		
	}
	
	public void clickBtn() throws Exception {
		
		driver.findElement(clickBtn).click();
<<<<<<< HEAD
		Thread.sleep(200);
=======
		Thread.sleep(4000);
>>>>>>> f9a5f1150a48e825c1d9fbded4590658d47e9bba
	}
	
	public void validateHomePage() throws InterruptedException {
		String strUrl = driver.getCurrentUrl();
		Thread.sleep(2000);
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(expected, strUrl);
<<<<<<< HEAD
		Thread.sleep(200);
=======
		Thread.sleep(2000);
>>>>>>> f9a5f1150a48e825c1d9fbded4590658d47e9bba
	}
}
