package TestApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
static WebDriver driver;
@BeforeClass
public void setup()
{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://demoqa.com/select-menu");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.manage().window().maximize();
}
@Test
public void getdropdown()
{
	JavascriptExecutor js;
	 js = (JavascriptExecutor)driver;
WebElement drop=driver.findElement(By.id("oldSelectMenu"));
Select s=new Select(drop);
s.selectByIndex(1);
WebElement select = driver.findElement(By.xpath("//div[@id='withOptGroup']"));
System.out.println(select.getSize());
WebElement m= driver.findElement(By.xpath("//*[local-name()='svg' and @class='css-19bqh2r']/*[local-name()='path']"));
//WebElement select = driver.findElement(By.xpath("//*[local-name()='svg' @id-close-fixedban='img']"));
js.executeScript("arguments[0].click();", select);
Actions act = new Actions(driver);
act.moveToElement(m).
click().build().perform();
//driver.quit();


}
}
