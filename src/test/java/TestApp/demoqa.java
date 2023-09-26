package TestApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqa {
static  WebDriver driver;
@BeforeTest
public void setup()
{
	//ChromeOptions op=new ChromeOptions();
	//op.addArguments("this is my test");
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://demoqa.com/text-box");
	driver.manage().window().maximize();
}
@Test
public void validate()
{
	boolean b =driver.findElement(By.xpath("//img")).isDisplayed();
	System.out.println(b);
	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("FullName");
	driver.findElement(By.xpath("//input[contains(@id,'userEmail')]")).sendKeys("email@email.com");
	String label=driver.findElement(By.xpath("//input[contains(@id,'userName')]/../../div/label")).getText();
	System.out.println("The label of full text is : " + label);
	driver.findElement(By.xpath("//div[@id='userName-wrapper']/div[2]/*")).sendKeys("this is name");
	driver.findElement(By.xpath("//input[@*='userName']")).sendKeys("by udingh");
	List<WebElement> lst =driver.findElements(By.xpath("//label[@*='userName-label']|//label[@*='userEmail-label']"));
	for(WebElement w:lst)
	{
		System.out.println(w.getText());
	}
	//Using contains() to locate full name and enter data
	driver.findElement(By.xpath("//input[contains(@id,'userN')]")).sendKeys("conatoins functiom");
	//using placeholder
	driver.findElement(By.xpath("//input[contains(@placeholder,'Full')]")).sendKeys("placeholder");
	//using start-with() 
	driver.findElement(By.xpath("//input[starts-with(@placeholder,'Fu')]")).sendKeys("Using start with");
	//using text() to get label
	driver.findElement(By.xpath("//label[text()='Email']")).getText();
	//using AND operator to locate full name
	driver.findElement(By.xpath("//textarea[@placeholder='Current Address' and @class='form-control']")).sendKeys("this is address");
	//using OR operator to locate full name
	driver.findElement(By.xpath("//textarea[@placeholder='Current Address' or @id='currentAddress']")).sendKeys("this is address");
	//using ancestor to locate form tag
	driver.findElement(By.xpath("//label[text()='Full Name']/ancestor::form")).getText();
	driver.findElement(By.xpath("//form[@id='userForm']/child::div[1]//label")).getText();
}
}
