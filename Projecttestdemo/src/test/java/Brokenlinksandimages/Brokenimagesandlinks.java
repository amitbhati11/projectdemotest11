package Brokenlinksandimages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Brokenimagesandlinks {
	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		String chpath="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chpath);
		
		driver=new ChromeDriver();
			}
	@Test
	
	public void testexecution() throws MalformedURLException, IOException {
		driver.get("http://makemysushi.com/404");
		try {
		List<WebElement> list=driver.findElements(By.tagName("img"));
		
		list.addAll(driver.findElements(By.tagName("a")));
		System.out.println(list.size()+"total links are-->");
		
		List<WebElement>  activelink=new ArrayList<WebElement>();
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getAttribute("href"));
			
			if(list.get(i).getAttribute("href")!=null &&( !list.get(i).getAttribute("href").contains("javascript"))){
					
				activelink.add(list.get(i));
		}
	}
		System.out.println(activelink.size()+"total activelinks are-->");
        for(int j=0;j<activelink.size();j++) {
        	  HttpURLConnection httpcont= (HttpURLConnection)  new URL(activelink.get(j).getAttribute("href")).openConnection();
                       httpcont.connect();
               String response=   httpcont.getResponseMessage();
           int responsecode=    httpcont.getResponseCode();
               httpcont.disconnect();
               
               System.out.println(activelink.get(j).getAttribute("href")+"active link are-->"+response+responsecode);
        }
}catch(StaleElementReferenceException e)
		{
	e.getCause();
		}
}
	@AfterTest
	
	public void teardown() {
		driver.close();
		System.out.println("success");
	}
}