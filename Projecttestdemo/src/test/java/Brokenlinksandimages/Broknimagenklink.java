package Brokenlinksandimages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Broknimagenklink {
	WebDriver driver;
	
@BeforeTest

public void setup() {
	
	String path="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver",path);
	driver=new ChromeDriver();
}

@Test

public void testbrokenlinkimages() throws MalformedURLException, IOException {
	
	driver.get("http://makemysushi.com/404");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	try {
	List<WebElement> alllist=driver.findElements(By.tagName("a"));
	
	alllist.addAll(driver.findElements(By.tagName("img")));
	
	System.out.println(alllist.size()+"total linksandimages are -->");
	List<WebElement> activelink=new ArrayList<WebElement>();
	
	
	for(int i=0;i<alllist.size();i++) {
		System.out.println(alllist.get(i).getAttribute("href"));
		
		if(alllist.get(i).getAttribute("href")!=null && (!alllist.get(i).getAttribute("href").contains("javascript")));
		{
		activelink.add(alllist.get(i));
		
	}
	
	
}   System.out.println(+activelink.size()+"activelink size are-->");
	
	for(int j=0;j<activelink.size();j++) {
		
		
		            HttpURLConnection connect=    (HttpURLConnection) new URL(activelink.get(j).getAttribute("href")).openConnection();
		             connect.connect();
		           String msg=  connect.getResponseMessage();
		           int rcode=connect.getResponseCode();
		           connect.disconnect();
		           
		           System.out.println(activelink.get(j).getAttribute("href")+msg+"-->"+rcode+"-->");
	}
}catch(StaleElementReferenceException e) {
	e.getCause();
}
	
}
@AfterTest

public void teardown() {
	driver.close();
	System.out.println("Completed");
}
}