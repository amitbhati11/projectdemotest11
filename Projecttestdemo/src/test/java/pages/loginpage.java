package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	@FindBy(xpath="//img[@id='logo']")
	WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Enter your full name']")
	WebElement usrname;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement usrpwd;
	
	@FindBy(xpath="//small[text()='Hint: password is 12345']")
	WebElement hintp;
	
	@FindBy(xpath="//button[@id='login']")
	WebElement lognbtun;
	
	@FindBy(xpath="//div[text()='Password is invalid']")
	WebElement invalidpwd;
	
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		}
	
	public void testlog() {
		logo.isDisplayed();
	}
	public void name(String username) {
		usrname.sendKeys(username);
		
	}
	
	public void pwd(String password) {
		usrpwd.sendKeys(password);
	}
	public void hint() {
		hintp.isDisplayed();
	}
	public void submitbtn() {
		lognbtun.click();
	}
	public void takescrshot() throws IOException {
		String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\Projecttestdemo\\src\\test\\resources\\Screenshots\\img.png";
	File src=invalidpwd.getScreenshotAs(OutputType.FILE);
	       FileHandler.copy(src, new File(path));
	}
	

}
