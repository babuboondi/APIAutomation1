package TestApp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cssSelector {
static WebDriver driver;
@BeforeClass
public void setup()
{
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	driver.get("https://demoqa.com/automation-practice-form");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
}
@Test
public void valiadte()
{
	driver.findElement(By.cssSelector("[id='firstName']")).sendKeys("cssselector");
	driver.findElement(By.cssSelector("[id^='last']")).sendKeys("cssselector");
	driver.findElement(By.cssSelector("[id$='Email']")).sendKeys("cssselector");
	driver.findElement(By.cssSelector("[id='userNumber']")).sendKeys("5677889");
	//driver.findElement(By.cssSelector("div>input[id='gender-radio-1']")).click();
	driver.findElement(By.cssSelector("textarea[id*='Address']")).sendKeys("dfdsg");
	
}
}
