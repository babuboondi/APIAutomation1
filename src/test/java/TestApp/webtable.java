package TestApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable {
	static WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();

	}

	@Test
	public void validate() {
		String s = driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[1]")).getText();
		System.out.println(s);
		String s1 = driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[last()]")).getText();
		System.out.println(s1);
		String s2 = driver.findElement(By.xpath("//div[@class='rt-tr -odd']/div[position()='2']")).getText();

		System.out.println(s2);
		//driver.findElement(By.xpath("//div[@class='col-md-7']")).click();
		//driver.findElement(By.xpath("//div[@class='addNewRecordButton']")).click();
		//driver.findElement(By.id("addNewRecordButton")).click();
		driver.quit();
	}
}
