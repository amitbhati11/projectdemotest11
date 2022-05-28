package tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.makemytrip;

public class makemytripflghttest {
	
	WebDriver driver;
	makemytrip mmp;
	
	@BeforeTest
	
	public void setup() {
		String cpath="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",cpath);
		//System.setProperty("http.maxRedirects", "100");
		driver=new ChromeDriver();
	}
	
	@Test
	
	public void testexecution() throws InterruptedException, MalformedURLException, IOException {
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		mmp=new makemytrip(driver);
		
		mmp.trip();
		mmp.departure();
		mmp.aarival();
		Thread.sleep(3000);
		mmp.deptdat();
		Thread.sleep(2000);
		mmp.travlerclass();
		mmp.fairtype();
		mmp.search();
		mmp.fastest();
		mmp.selectflight();
		mmp.sidearrow();
		mmp.totallinksandimages();
		
	}

}
