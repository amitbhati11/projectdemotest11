package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exceldatautilsdemo.Exceldatademo;
import pages.Homepage;
import pages.loginpage;

public class Datautilslogindemo {
	Exceldatademo ed;
	WebDriver driver;
	loginpage lp;
	Homepage hp;
	@Parameters("browser")
	@BeforeTest
	
	public void setup(String browser) {
		System.out.println("browser is:"+browser);
		if(browser.contains("chrome{")) {
		String cpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",cpath);
		driver=new ChromeDriver();
	}else if(browser.contains("firefox")) {
		String gpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\Projecttestdemo\\src\\test\\resources\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",gpath);
		driver=new FirefoxDriver();
	}
	}
	
@DataProvider(name="testdata")
	
	public Object [][] getdataprovide() throws Exception {
	String xlpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\Projecttestdemo\\src\\test\\resources\\Exceldata\\loginDataprovider.xlsx";
	String sheetname="Sheet1";
		
		Object data [][]=getdatacell(xlpath, sheetname);
		return data;
	}

@Test(dataProvider="testdata")

public void finaldata(String username,String password,String id) throws  IOException, InterruptedException
{
	System.out.println(username+" | "+password+" | "+id);
	
	driver.get("https://example.testproject.io/web/");
	lp=new loginpage(driver);
	lp.testlog();
	lp.name(username);
	lp.pwd(password);
	lp.hint();
	Thread.sleep(2000);
	lp.submitbtn();
	Thread.sleep(3000);
	   String txt=driver.findElement(By.xpath("//div[text()='Password is invalid']")).getText();   
	if(txt.contains("Password is invalid")) {
		lp.takescrshot();
	   
	}
	else {
		hp=new Homepage(driver);
	hp.freecontent();
	hp.addcountry();
	hp.address();
	hp.emailaddress();
	hp.phonenumber();
	hp.saveDeatils();
	Thread.sleep(2000);
}
}	
	
	
	public Object [][] getdatacell(String xlpath,String sheetname) throws IOException  {
	
		
			ed = new Exceldatademo(xlpath,sheetname );
		
		int Rownum=ed.getrowdata();
		int Colnum=ed.getcoldata();
		 
		
		    Object data [][]=new Object[Rownum-1][Colnum];
			try {
		    for(int i=1;i<Rownum;i++) {
		    	
		    	for(int j=0;j<Colnum;j++) {
		    		
		    		data [i-1][j]=ed.getcelldata(i, j);
		    		
		    	}
		    	}  
		} 
		catch(Exception e) {
			e.getCause();
		}return data;	
		    
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("Success");
	}
		
}
