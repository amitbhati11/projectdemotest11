package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AirIndiapage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='from']")
	WebElement depart;
	
	@FindBy(xpath="//input[@id='to']")
	WebElement arriv;
	
	@FindBy(xpath="//input[@id='_depdateeu1']")
	WebElement deptdate;

	@FindBy(xpath="//input[@name='_retdateeu1']")
	WebElement arrivdate;
	
	@FindBy(xpath="//label[@for='rdrules1']")
	WebElement domco;
	
	@FindBy(xpath="//select[@name='concessionaryType1']")
	WebElement Conseetype;
	
	
	@FindBy(xpath="//select[@name='ddladult1']")
	WebElement adulttype;
	
	@FindBy(xpath="//select[@name='ddlchildren1']")
	WebElement childrentype;
	
	@FindBy(xpath="//select[@name='ddlinfants1']")
	WebElement Infants;
	
	@FindBy(xpath="//select[@name='_classType1']")
	WebElement classtype;
	
	@FindBy(xpath="//input[@id='btnbooking']")
	WebElement booknow;
	
	
	//Constructor
	
	public AirIndiapage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void departure() throws InterruptedException {
		depart.sendKeys("Del");
		Thread.sleep(2000);
		depart.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		depart.sendKeys(Keys.TAB);
		
	}
	
	public void arrival() throws InterruptedException {
		arriv.sendKeys("mum");
		Thread.sleep(2000);
		arriv.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
	arriv.sendKeys(Keys.TAB);
		
	}
	
	public void departuredate() {
		deptdate.click();
	}
	
	public void arrvaldate() {
		arrivdate.click();
	}
	public void domestic() {
		domco.click();
		
	}
	public void   Consty() {
		Conseetype.click();
		Select  st=new Select(Conseetype);
		st.selectByValue("SeniorCitizen");
	}
	public void adult() {
		adulttype.click();
		Select ad=new Select(adulttype);
		ad.selectByIndex(2);
	}
	
	public void children() {
		childrentype.click();
		Select cd=new Select(childrentype);
		cd.selectByVisibleText("3");
	}
	
	public void INFAINTS() {
		Infants.click();
		Select in= new Select(Infants);
		in.selectByVisibleText("2");
		
	}
	public void zonetype() {
		classtype.click();
		Select zn=new Select(classtype);
		zn.selectByVisibleText("Business");
	}
	
	public void submitbtn() {
		booknow.click();
	}
}
