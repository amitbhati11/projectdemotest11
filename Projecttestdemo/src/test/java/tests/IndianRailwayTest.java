package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pages.IndianRailwaypage;
import pages.Railfarepage;
import pages.ReservedTrainBetweenStationspage;

public class IndianRailwayTest {
	
	WebDriver driver;
	IndianRailwaypage irp;
	ReservedTrainBetweenStationspage rtp;
	Railfarepage rfp;
	
	@BeforeTest
	public void setup() {
		String path="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver",path);
	driver=new ChromeDriver();
	}
	
	@Test(priority=2)
	
	public void railtest() throws InterruptedException, IOException, TesseractException {
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		irp=new IndianRailwaypage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		irp.trainno();
		irp.date();
		
		String Expdate="26-July-2022";
		String eday=Expdate.split("-")[0];
		String emonth=Expdate.split("-")[1];
		String eyer=Expdate.split("-")[2];
		
		System.out.println(eday+"#"+emonth+"#"+eyer);
		
		String cmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		String cyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		System.out.println(cmonth+"@"+cyer);
		while((!cmonth.equals(emonth))||(!cyer.equals(eyer))){
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			cmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
			 cyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		}
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//td//a"));
	    for(int i=0;i<list.size();i++) {
	    	String cday=list.get(i).getText();
	    	if(cday.equals(eday)) {
	    		list.get(i).click();
	    		break;
	    	}
	    }
	    
	    irp.departure();
	    irp.arrival();
	    irp.enterclas();
	    irp.quota();
	    irp.submitbtn();
	    
	/* String text=  driver.findElement(By.id("CaptchaImgID")).getText();
	 System.out.println(text);*/
	    Thread.sleep(4000);
	 File src=   driver.findElement(By.id("CaptchaImgID")).getScreenshotAs(OutputType.FILE);
	 Thread.sleep(2000);
	 String fpath="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\Screenshots\\Image1.png";
	 FileHandler.copy(src, new File(fpath));
	 ITesseract imgx=new Tesseract();
	String imgtext= imgx.doOCR(new File(fpath));
	System.out.println(imgtext);
	String separator="=";
	int sepos=imgtext.lastIndexOf(separator);
	//System.out.println(sepos);
	String S1=imgtext.substring(0,3);
	System.out.println(S1+"val of S1");
	String S2=imgtext.substring(5,sepos).trim();
	System.out.println(S2+"val of S21 Imagepng");
	
	Integer I1=Integer.valueOf(S1);
	Integer I2=Integer.valueOf(S2);
	
	if(imgtext.contains("+")) {
		Integer I=I1+I2;
		String S=String.valueOf(I);
		driver.findElement(By.id("inputCaptcha")).sendKeys(S);
		driver.findElement(By.xpath("//input[@id='test']")).click();
	}else if(imgtext.contains("-")) {
		Integer I=I1-I2;
		String S=String.valueOf(I);
		driver.findElement(By.id("inputCaptcha")).sendKeys(S);
		driver.findElement(By.xpath("//input[@id='test']")).click();                
	}
	}
	@Test(priority=1)
	public void resrvedpage() throws InterruptedException, IOException, TesseractException {
		driver.get("https://www.indianrail.gov.in/enquiry/TBIS/TrainBetweenImportantStations.html?locale=en");
		driver.manage().window().maximize();
	rtp=new ReservedTrainBetweenStationspage(driver);
	rtp.date();
	
	String rtexpdate="8-August-2022";
	String rteday=rtexpdate.split("-")[0];
	String rtemonth=rtexpdate.split("-")[1];
	String rteyr=rtexpdate.split("-")[2];
	
	System.out.println(rteday+"@"+rtemonth+"@"+rteyr);
	
	String rtcmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
	String rtcyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
	
	while((!rtcmonth.equals(rtemonth))||(!rtcyer.equals(rteyr))) {
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		 rtcmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		 rtcyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		}
	
	            List<WebElement> listdt=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//td"));
	            
	            for(int m=0;m<listdt.size();m++) {
	            String rtcday=	listdt.get(m).getText();
	            System.out.println(rtcday);
	            if(rtcday.equals(rteday)) {
	            	listdt.get(m).click();
	            	break;
	            }
	            }
	            Thread.sleep(3000);
	            rtp.sourcest();
	            rtp.arrival();
	            rtp.flexipopup();
	            rtp.gobtn();
	            Thread.sleep(4000);
	            rtp.captchcode();
	            Thread.sleep(5000);
	
	}
	@Test(priority=3)
	
	public void fairenq() throws InterruptedException, IOException, TesseractException {
		
		driver.get("https://www.indianrail.gov.in/enquiry/FARE/FareEnquiry.html?locale=en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		rfp=new Railfarepage(driver);
		rfp.Trainnum();
		rfp.datecalender();
		Thread.sleep(3000);
		rfp.depart();
		rfp.arrival();
		rfp.typecls();
		rfp.quota();
		Thread.sleep(1000);
		rfp.fairbutton();
		Thread.sleep(4000);
		rfp.captchacode();
		Thread.sleep(5000);
	}

	//@AfterTest
	
	public void teardown() {
		driver.close();
		System.out.println("Success");
		
	}
}
