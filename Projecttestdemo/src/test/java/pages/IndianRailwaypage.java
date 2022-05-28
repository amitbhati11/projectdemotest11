package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IndianRailwaypage {
	
	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Train Number']")
	WebElement train;
	@FindBy(xpath="//img[@title='Select date']")
	WebElement calander;
	@FindBy(xpath="//input[@placeholder='Enter Source Station']")
	WebElement sorcestation;
	@FindBy(xpath="//input[@placeholder='Enter Destination Station']")
	WebElement destst;
	@FindBy(xpath="//select[@name='class']")
	WebElement cls;
	@FindBy(xpath="//select[@name='quota']")
	WebElement entquot;
	@FindBy(xpath="(//input[@value='Get Availability'])[3]")
	WebElement getavailability;
	
	//constructor
	
	public IndianRailwaypage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void trainno() throws InterruptedException {
		train.sendKeys("1274");
		Thread.sleep(3000);
		train.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		train.sendKeys(Keys.TAB);
	}
	
	public void date() {
		calander.click();
	}
	
	public void departure() throws InterruptedException {
		sorcestation.sendKeys("Secund");
		Thread.sleep(2000);
		sorcestation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		sorcestation.sendKeys(Keys.TAB);
		}
	public void arrival() throws InterruptedException {
		destst.sendKeys("VISAKH");
		Thread.sleep(2000);
		destst.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		destst.sendKeys(Keys.TAB);
	}
	public void enterclas() {
		cls.click();
		Select sc=new Select(cls);
		sc.selectByValue("FC");
		
	}
	public void quota() {
		entquot.click();
		Select sq=new Select(entquot);
		sq.selectByVisibleText(" Premium Tatkal Quota");
		
	}
	public void submitbtn() throws InterruptedException {
		 getavailability.click();
		 Thread.sleep(2000);
	}
	

}
