package UdemyElement;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class redifflogin {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void loginmoney() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By
				.cssSelector("a[title='Live commentary of the Indian stock markets, stock quotes and business news']"))
				.click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("useremail")).sendKeys("anshulc55@rediffmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Test@1234");
		driver.findElement(By.id("loginsubmit")).click();
		String stocktotalcost = driver.findElement(By.id("stocktotalcost")).getText();
		String stocklatesttotal = driver.findElement(By.id("stocklatesttotal")).getText();
		System.out.println(stocktotalcost);
		System.out.println(stocklatesttotal);
		driver.findElement(By.id("createPortfolio")).click();
		driver.findElement(By.id("create")).clear();
		driver.findElement(By.id("create")).sendKeys("TestPortfpolio1");
		driver.findElement(By.id("createPortfolioButton")).click();
		WebElement selectport = driver.findElement(By.id("portfolioid"));
		Select select = new Select(selectport);
		Thread.sleep(5000);
		String value = select.getFirstSelectedOption().getText();
		System.out.println(value);
		js.executeScript("arguments[0].click();", driver.findElement(By.id("deletePortfolio")));
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	@Test
	public void loginmail() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login1")).sendKeys("anshulc55@rediffmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();

	}

	@AfterClass
	public void closeblock() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
