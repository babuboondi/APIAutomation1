package guru99;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport2 {
	static WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.programsbuzz.com/user/login");
		driver.manage().window().maximize();
		htmlReporter = new ExtentSparkReporter("extentReport2.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test
	public void validate() throws IOException {
		test = extent.createTest("Print URL");
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("login")) {

			test.log(Status.PASS, "Actual Title!");

		} else {
			test.log(Status.FAIL, "Not Actual Title!");

		}
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\DELL\\OneDrive\\Desktop\\extent.png"));

	}

	@AfterClass
	public void finOper() throws IOException {

		test.addScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\extent.png");

		extent.flush();
		driver.quit();
		extent.flush();

	}
}
