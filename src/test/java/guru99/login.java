package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
WebDriver driver;
@BeforeClass
public void setup()
{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("http://www.demo.guru99.com/V4/");
	driver.manage().window().maximize();
	
}
@Test
public void loginguru()
{
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr525675");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rynAnYz");
	WebElement btn= driver.findElement(By.xpath("//input[@name='btnLogin']"));
	js.executeScript("arguments[0].click();", btn);
}
@AfterClass
public void closeblock()
{
	driver.close();
}

}
