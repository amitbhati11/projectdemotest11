package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//a[text()='FREE SIGN UP'])[1]")
	WebElement freesignup;
	
	@FindBy(xpath="//select[@class='form-control bfh-countries']")
	WebElement country;
	
	@FindBy(xpath="//input[@placeholder='Enter your address']")
	WebElement add;
	
	@FindBy(xpath="//input[@placeholder='Enter your email']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Enter your phone number']")
	WebElement phone;
	
	@FindBy(xpath="//button[@id='save']")
	WebElement Savebtn;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void freecontent() {
		freesignup.isDisplayed();
	}
	public void addcountry() {
		country.click();
		
		Select st=new Select(country);
		st.selectByVisibleText("Ecuador");
		
		}
	
	public void emailaddress() {
		email.sendKeys("abc@gmail.com");
	}
	public void address() {
		add.sendKeys("Delhi");
	}
	public void phonenumber() {
		phone.sendKeys("121212####");
	}
	
	public void saveDeatils() {
		Savebtn.click();
	}
	
	

}
