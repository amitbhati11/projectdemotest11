package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Spicejetpage;

public class Spicejetlogintest {
	
	WebDriver driver;
	Spicejetpage sjp;
	
	@BeforeTest
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		String cpath="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",cpath);
		
		
		driver=new ChromeDriver(options);
		
	}

	@Test
	public void testexecution() throws InterruptedException {
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		sjp=new Spicejetpage(driver);
		
		sjp.triptype();
		sjp.from();
		sjp.deprtstate();
		sjp.arrival();
		//driver.switchTo().alert().accept();
		
		sjp.arivstate();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;                                                                
		js.executeScript("window.scrollBy(0,130)");
		
		//sjp.departuredate();
		
		
		
		sjp.arrivaldate();
		Thread.sleep(3000);
		sjp.returndate();
		Thread.sleep(3000);
		/*String Expdate="18-September 2022";
		String Eday=Expdate.split("-")[0];
		String Emonthyer=Expdate.split("-")[1];
		
		System.out.println(Eday+"###"+Emonthyer);
		String cmonthyer= driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")).getText().trim();
		System.out.println(cmonthyer+"currentyear");
		while(!cmonthyer.equalsIgnoreCase(Emonthyer)) {
			
			driver.findElement(By.xpath("(//div[@data-focusable='true'])[18]")).click();
			cmonthyer= driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")).getText().trim();
			
		}
		*/
		sjp.totalpassangers();
		sjp.adult();
		sjp.childpickup();
		sjp.infantR();
		
		sjp.currm();
		sjp.currunit();
		sjp.paxtype();
		Thread.sleep(3000);
		sjp.findflight();
		
		Thread.sleep(3000);
		
	WebElement dr=	driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[6]"));
	WebDriverWait wb1=new WebDriverWait(driver,Duration.ofSeconds(10));
	wb1.until(ExpectedConditions.visibilityOf(dr));
	dr.click();
		Thread.sleep(2000);
		
		
		WebElement wq=driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-obd0qt r-1ap4h1l']//div[text()='Continue']"));
		WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(10));
		wb.until(ExpectedConditions.visibilityOf(wq));
		wq.isEnabled();
		
	}
}
