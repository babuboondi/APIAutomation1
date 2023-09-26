package TestApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGoogleSearch {
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--thisismyTest...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void search() {
		driver.findElement(By.name("q")).sendKeys("Elephant image");
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
	}
}
