package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Railfarepage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Train Number']")
	WebElement trno;
	
	@FindBy(xpath="//img[@alt='Select date']")
	WebElement caldr;
	
	@FindBy(xpath="//input[@id='sourceStation']")
	WebElement entsourc;
	
	@FindBy(xpath="//input[@id='destinationStation']")
	WebElement dest;
	
	@FindBy(xpath="//select[@name='class']")
	WebElement entcl;
	
	@FindBy(xpath="//select[@name='quota']")
	WebElement qut;
	
	@FindBy(xpath="(//input[@value='Get Fare'])[3]")
	WebElement farbtn;
	
	@FindBy(id="CaptchaImgID")
	WebElement capcha;
	
	@FindBy(id="inputCaptcha")
	WebElement ans;
	
	@FindBy(xpath="(//input[@value='Get Fare'])[2]")
	WebElement gfbtn;
	
	//constructor
	public Railfarepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void Trainnum() throws InterruptedException {
		trno.sendKeys("1236");
		Thread.sleep(3000);
		trno.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		trno.sendKeys(Keys.TAB);
	}
	
	public void datecalender() throws InterruptedException {
		caldr.click();
		Thread.sleep(2000);
		String expdate="16-August-2022";
		String eday=expdate.split("-")[0];
		String emonth=expdate.split("-")[1];
		String eyer=expdate.split("-")[2];
		System.out.println(eday+"^"+emonth+"^"+eyer);
		
		String cmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		String cyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		
		while((!cmonth.equals(emonth))||(!cyer.equals(eyer))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			 cmonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
			 cyer=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
			
		}
		
		         List<WebElement> list=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//td"));
		         for(int k=0;k<list.size();k++) {
		        	 String cday=list.get(k).getText();
		        	 if(cday.equals(eday)) {
		        		 list.get(k).click();
		        	 }
		         }
	}
	
	public void depart() throws InterruptedException {
		entsourc.sendKeys("Howrah");
		Thread.sleep(3000);
		entsourc.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		entsourc.sendKeys(Keys.TAB);
	}
	
	public void arrival() throws InterruptedException {
		dest.sendKeys("haridwar");
		Thread.sleep(3000);
		dest.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		dest.sendKeys(Keys.TAB);
	}
	public void typecls() {
		entcl.click();
		Select sc=new Select(entcl);
		sc.selectByIndex(0);
	}
	public void quota() throws InterruptedException {
		qut.click();
		Select sq=new Select(qut);
		sq.selectByValue("PT");
		Thread.sleep(2000);
	}
	
	public void fairbutton() {
		farbtn.click();
	}
	
public void captchacode() throws IOException, TesseractException, InterruptedException {
	File src=capcha.getScreenshotAs(OutputType.FILE);
	String path="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\Screenshots\\capcha.png";
	FileHandler.copy(src, new File(path));
	Thread.sleep(5000);
	ITesseract img=new Tesseract();
	
String Imgtxt=img.doOCR(new File(path));
System.out.println(Imgtxt);
Thread.sleep(3000);
String seprator="=";
           int sepos= Imgtxt.lastIndexOf(seprator);
         
String s1=Imgtxt.substring(0,3);
System.out.println(s1+"value of railfair s1");
String s2=Imgtxt.substring(5, sepos).trim();
System.out.println(s2+"value of railfair s2 capcha match");

Integer i1=Integer.valueOf(s1);
Integer i2=Integer.valueOf(s2);

if(Imgtxt.contains("+")) {
	Integer I=i1+i2;
	String S=String.valueOf(I);
	ans.sendKeys(S);
	gfbtn.click();
	
}else if(Imgtxt.contains("-")) {
	Integer I=i1-i2;
	String S=String.valueOf(I);
	ans.sendKeys(S);
	gfbtn.click();
	
}
}
}
