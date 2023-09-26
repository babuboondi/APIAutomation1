package TestApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipcart {
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--thisismyTest...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

	}

	@Test
	public void search() {
		driver.findElement(By.name("q")).sendKeys("mobile");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		//driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]"));
		driver.findElement(By.xpath("//div[@title='4 GB']//div[@class='_24_Dny']")).click();
		driver.findElement(By.xpath("//img[@alt='POCO C51 (Royal Blue, 64 GB)']")).click();
		driver.close();
	}
}
