package guru99;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2 {
 static WebDriver driver;
 @BeforeClass
 public void setup()
 {
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	 driver.get("http://live.techpanda.org/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 
 }
 @Test
 public void Addtocart() throws InterruptedException {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click(); 
	driver.findElement(By.xpath("//ul/li/a[@title='Samsung Galaxy']")).click();
	 
	driver.findElement(By.xpath("//button[contains(@title,'Add to Cart')]")).click();

	
	WebElement btn=driver.findElement(By.xpath("//a[contains(@title,'Edit item parameters')]")); 
	js.executeScript("arguments[0].click();", btn);
	driver.findElement(By.xpath("//input[@name='qty']")).click();
	driver.findElement(By.xpath("//input[@name='qty']")).sendKeys("10");
	WebElement btnupdate=driver.findElement(By.xpath("//button[contains(@title,'Update Cart')]")); 
	js.executeScript("arguments[0].click();", btnupdate);
	driver.findElement(By.xpath("//button[contains(@title,'Proceed to Checkout')]")).click();
	String str = driver.findElement(By.id("login:guest")).getAttribute("checked");
	if (str.equalsIgnoreCase("true"))
	{
	    driver.findElement(By.id("onepage-guest-register-button")).click();
	}
 }
 @Test
 public void createAccount() throws InterruptedException
 {
	 driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	 driver.findElement(By.id("firstname")).sendKeys("myname");
	 driver.findElement(By.id("middlename")).sendKeys("myname");
	 driver.findElement(By.id("lastname")).sendKeys("myname");
	 driver.findElement(By.id("email_address")).sendKeys("myname@gmail.com");
	 driver.findElement(By.id("password")).sendKeys("Myname@123");
	 driver.findElement(By.id("confirmation")).sendKeys("Myname@123");
	 driver.findElement(By.xpath("//button[@title='Register']")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'TV')]")).click();
	 driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[1]/a[1]")).click();
 }
}
