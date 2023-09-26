package UdemyElement;

import java.util.Date;
import java.util.List;
import java.text.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectdatetimepicker {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void gotoprofile() throws InterruptedException, ParseException {
		driver.findElement(By.xpath("//a[contains(text(),'Money')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("useremail")).sendKeys("anshulc55@rediffmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Test@1234");
		driver.findElement(By.id("loginsubmit")).click();
		WebElement selectport = driver.findElement(By.id("portfolioid"));
		Select select = new Select(selectport);
		select.selectByVisibleText("AnsuTestPortfolio");

	}

	@Test(priority = 2)
	public void addstock() {
		driver.findElement(By.xpath("//a[contains(text(),'Money')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("useremail")).sendKeys("anshulc55@rediffmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Test@1234");
		driver.findElement(By.id("loginsubmit")).click();
		WebElement selectport = driver.findElement(By.id("portfolioid"));
		Select select = new Select(selectport);
		select.selectByVisibleText("AnsuTestPortfolio");

		driver.findElement(By.id("addStock")).click();
		WebElement mif = driver.findElement(By.id("addstockname"));
		mif.sendKeys("Nestle");
		driver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[1]")).click();
		driver.findElement(By.id("stockPurchaseDate")).click();
		waitPageload();
		try {
			selectdate("12/07/2019");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("addstockqty")).sendKeys("34");
		driver.findElement(By.id("addstockprice")).sendKeys("234");
		driver.findElement(By.id("addStockButton")).click();
		waitPageload();
		getstockrownumber("Nestle");
	}

	public int getstockrownumber(String stockname) {
		int row = 1;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		for (WebElement ele : rows) {
			List<WebElement> rowscell = ele.findElements(By.tagName("td"));
			row++;
			for (WebElement cell : rowscell) {
				String stock = cell.getText();
				System.out.println(stock);
				if (!stock.isEmpty() && stock.contains(stockname)) {
					return row;
				}
			}

		}
		return -1;
	}

	@Test(priority = 3)
	public void addMF()  {

		driver.findElement(By.xpath("//a[contains(text(),'Money')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("useremail")).sendKeys("anshulc55@rediffmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Test@1234");
		driver.findElement(By.id("loginsubmit")).click();
		WebElement selectport = driver.findElement(By.id("portfolioid"));
		Select select = new Select(selectport);
		select.selectByVisibleText("AnsuTestPortfolio");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement miftext = driver.findElement(By.id("addmf"));
		js.executeScript("arguments[0].click();", miftext);
		WebElement mif = driver.findElement(By.id("mfname"));
		mif.sendKeys("tr");
		driver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[1]")).click();
		driver.findElement(By.xpath("//a[@id='mfPurchaseDate']")).click();
		waitPageload();
		try {
			selectdate("12/07/2018");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("mfinitialAmt")).sendKeys("34");
		driver.findElement(By.id("mfprice")).sendKeys("234");
		driver.findElement(By.id("addMFButton")).click();
	}

// this is wait function
	public void waitPageload() {
		int t = 0;
		while (t != 120) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = (String) js.executeScript("return document.readyState");
			Boolean b = (Boolean) js.executeScript("return window.jQuery !=undefined && jQuery.active ==0");
			System.out.println(state);
			System.out.println(b);
			if (state.equals("complete") && b) {
				break;
			} else {
				wait(1);
				t = t + 1;
			}
		}
	}

	public void wait(int t) {
		try {
			Thread.sleep(t * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// this is select date time picker
	public void selectdate(String date) throws InterruptedException, ParseException {

		Date currentdate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		// String curdate = formatter.format(currentdate);
		Date expdate = formatter.parse(date);
		String day = new SimpleDateFormat("dd").format(expdate);
		String month = new SimpleDateFormat("MMMM").format(expdate);
		String year = new SimpleDateFormat("yyyy").format(expdate);
//		String splitter[] = curdate.split("-");
//		String month_year = splitter[1];
//		String daysplit = splitter[0];
		System.out.println(month);
		System.out.println(day);
		String expextedMonthYear = month + " " + year;
		while (true) {
			String disdate = driver.findElement(By.className("dpTitleText")).getText();
			if (expextedMonthYear.equals(disdate)) {
				driver.findElement(By.xpath("//td[text()='" + day + "']")).click();
				break;
			} else if (expdate.compareTo(currentdate) > 0) {
				driver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]")).click();
			} else {
				driver.findElement(By.xpath("//tbody/tr[1]/td[2]/button[1]")).click();
			}

		}
	}
}
