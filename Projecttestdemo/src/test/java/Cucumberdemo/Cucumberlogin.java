package Cucumberdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Homepage;
import pages.loginpage;


public class Cucumberlogin {

	WebDriver driver;
	loginpage lp;
	Homepage hp;
	@Before
	
	public void setup() {
		String cpath="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\drivers\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver",cpath);
	  driver=new ChromeDriver();
	  
	  
	}
	@Given("enter the URl")
	public void enter_the_u_rl() {
    driver.get("https://example.testproject.io/web/");
    driver.manage().window().maximize();
	}

	@And("^login with valid (.*) and (.*)$")
	public void login_with_valid_username_and_password(String username,String password) {
        lp=new loginpage(driver);
        lp.testlog();
        lp.name(username);
        lp.pwd(password);
       
	}

	
	@And("^login with invalid (.*) and (.*)$")
	public void login_with_invalid_username_and_password(String username,String password) throws InterruptedException {

		  lp=new loginpage(driver);
	        lp.testlog();
	        lp.name(username);
	        lp.pwd(password);
	       
		Thread.sleep(2000);
	}
	
	@When("click on submit button")
	public void click_on_submit_button() {
		  lp=new loginpage(driver);
		  lp.submitbtn();
	}

	@Then("navigate to home page")
	public void navigate_to_home_page() throws InterruptedException {
hp=new Homepage(driver);
 hp.addcountry();
 hp.address();
 hp.emailaddress();
 hp.phonenumber();
 Thread.sleep(2000);
 hp.saveDeatils();

	}
	
	@After
	
	public void teardown() {
		
		driver.close();
		
		System.out.println("success");
		
	}
}
