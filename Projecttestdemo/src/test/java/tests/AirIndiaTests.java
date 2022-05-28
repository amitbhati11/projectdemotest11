package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AirIndiapage;

public class AirIndiaTests {
	
	WebDriver driver;
	AirIndiapage aip;
	
	@BeforeTest
	
	public void setup() {
		String path="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
	}
	
	@Test
	
	public void testairline() throws InterruptedException {
		driver.get("https://www.airindia.in/");
		aip=new AirIndiapage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5000);
		aip.departure();
		aip.arrival();
Thread.sleep(2000);
		aip.departuredate();
		String expdate="20-July-2022";
		String eday=expdate.split("-")[0];
		String emonth=expdate.split("-")[1];
		String eyer=expdate.split("-")[2];
		
		System.out.println(eday+"#"+emonth+"#"+eyer);
		
	 String cmonth= driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
	 String cyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
	 System.out.println(cmonth+"@"+cyer);
	 
	 while((!cmonth.equals(emonth))||(!cyer.equals(eyer))) {
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 cmonth= driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		 cyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		 
	 }
	
	 List<WebElement>  list= driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//td"));
	 for(int i=0;i<list.size();i++) {
		String cday=list.get(i).getText();
		//System.out.println(cday+"currentday-->");
		if(cday.equals(eday)) {
			list.get(i).click();
			break;
		}
		
		
		
	 }
	 aip.arrvaldate();
	 
	 String erdate="14-October-2022";
	 String erday=erdate.split("-")[0];
	 String ermonth=erdate.split("-")[1];
	 String eryer=erdate.split("-")[2];
	 
	 String arrivmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText().trim();
	 String arrivyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[2]")).getText().trim();
	 
	 while((!arrivmonth.equals(ermonth))||(!eryer.equals(arrivyear))) {
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 arrivmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText().trim();
		 arrivyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[2]")).getText().trim();
	 }
	 
	 List<WebElement> datelist=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table//tbody//tr//td"));
		
		for(int j=0;j<datelist.size();j++) {
		String arrivday=datelist.get(j).getText();
		
		if(arrivday.equals(erday)) {
			datelist.get(j).click();
			break;
		}
		}
		aip.domestic();
		aip.Consty();
		aip.adult();
		aip.children();
		aip.INFAINTS();
		aip.zonetype();
		aip.submitbtn();
	}

}
