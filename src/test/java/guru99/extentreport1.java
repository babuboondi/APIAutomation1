package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class extentreport1 {
	private static WebDriver driver = null;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();

	}

	@Test
	public void reports() {
		String expectedTitleebay = "Eletrônicos, Automóveis, Moda, Colecionáveis, Cupons e muito mais | eBay";
		// create the htmlReporter object
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("ebay Search Test", "test to validate search box ");
		test1.pass("maximize has done");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitleebay);
		test1.pass("title is correct");
		// enter in the TextBox
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Mobile");
		test1.pass("Entered thex in the text box");
		// hit enter
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).sendKeys(Keys.RETURN);
		test1.pass("Press keybopard enter key");
		driver.close();
		test1.pass("closed the browser");
		test1.info("test completed");
		// write results into the file
		extent.flush();
	}
}
