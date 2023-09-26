package TestApp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mousemove {
	static WebDriver driver;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		//driver.get("https://demoqa.com/menu/");
		driver.get("http://demo.guru99.com/test/guru99home/" );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
	}
	@Test
	public void getdropdown()
	{JavascriptExecutor js;
	 js = (JavascriptExecutor)driver;
		String eTitle = "Demo Guru99 Page";
		String aTitle = "" ;
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Actions act=new Actions(driver);
//	WebElement menu= 	driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
//	act.moveToElement(menu).perform();
		aTitle=driver.getTitle();
		if (aTitle.contentEquals(eTitle))
		{
		System.out.println( "Test Passed") ;
		 try {
	            FileUtils.copyFile(screen, new File("C:\\Users\\DELL\\OneDrive\\Desktop\\abc.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		}
		else {
		System.out.println( "Test Failed" );
		}
		WebElement icon=driver.findElement(By.cssSelector("a>i[class='icon-usd']"));
		//icon.click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOf(icon));
		js.executeScript("arguments[0].click();", icon);
	}
	
}
