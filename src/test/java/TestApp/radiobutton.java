package TestApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radiobutton {
static WebDriver driver;
@BeforeClass
public void setup()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://demoqa.com/radio-button");
	driver.manage().window().maximize();
}
@Test
public void validate()
{
	//driver.findElement(By.xpath("//div[@class= 'custom-control custom-radio custom-control-inline']/descendant::input/following-sibling::label")).click();
	//driver.findElement(By.xpath("//input[@type='radio' and @name='like']")).isSelected();
	//driver.findElement(By.xpath("//input[@id='yesRadio']/parent::div")).isSelected();
	//driver.findElement(By.xpath(""));
	//driver.findElement(By.xpath(""));
	//driver.findElement(By.xpath(""));
	JavascriptExecutor js;
	 js = (JavascriptExecutor)driver;
	WebElement	element = driver.findElement(By.id("yesRadio"));
	js.executeScript("arguments[0].click();", element);
	
	 
}
}
