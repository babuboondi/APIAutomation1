package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginfreecrm extends DataProviderTest {
	WebDriver driver;
	WebElement uname;
	WebElement pass;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();

	}

	 
	@Test(dataProvider = "Authentication")
	public void logincrm(String sUsername, String sPassword) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.uname = driver.findElement(By.xpath("//input[@name='email']"));
		this.pass = driver.findElement(By.xpath("//input[@name='password']"));
		uname.sendKeys(sUsername);
        pass.sendKeys(sPassword);
        uname.sendKeys("");
        pass.sendKeys("");
		WebElement btn = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		js.executeScript("arguments[0].click();", btn);
	}
}
