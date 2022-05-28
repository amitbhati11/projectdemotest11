package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReservedTrainBetweenStationspage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Select date']")
	WebElement journdat;
	
	@FindBy(xpath="//input[@placeholder='Enter Source Station']")
	WebElement depart;
	
	@FindBy(xpath="//input[@placeholder='Enter Destination Station']")
	WebElement dest;
	
	@FindBy(xpath="//input[@id='flexiWithDate']")
	WebElement flexidt;
	
	@FindBy(xpath="//input[@id='modal1']")
	WebElement btn;
	
	@FindBy(xpath="//img[@id='CaptchaImgID']")
	WebElement capthcd;
	
	@FindBy(xpath="//input[@id='inputCaptcha']")
	WebElement anscd;
	
	@FindBy(xpath="//input[@id='test']")
	WebElement gobtn;

	//constructor
	
	public ReservedTrainBetweenStationspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void date() {
		journdat.click();
	}
	public void sourcest() throws InterruptedException {
		depart.sendKeys("HOWRAH");
		Thread.sleep(3000);
		for(int i=0;i<2;i++) {
		depart.sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(3000);
		depart.sendKeys(Keys.TAB);
		
	}
	
	public void arrival() throws InterruptedException {
		dest.sendKeys("New del");
		Thread.sleep(2000);
		dest.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		dest.sendKeys(Keys.TAB);
		
	}
	public void flexipopup() {
		flexidt.click();
	}
	
	public void gobtn() {
		btn.click();
	}
	
	public void captchcode() throws IOException, TesseractException, InterruptedException {
	File src=capthcd.getScreenshotAs(OutputType.FILE);
	Thread.sleep(3000);
	String path="C:\\Users\\Admin_SRV\\git\\projectdemotest11\\Projecttestdemo\\src\\test\\resources\\Screenshots\\resrvbtn.png";
	
	FileHandler.copy(src,new File(path));
	ITesseract imgtxt=new Tesseract();
	String text=  imgtxt.doOCR(new File(path));
	System.out.println(text);
	Thread.sleep(3000);
	  String seprator="=";
	 int sepos= text.lastIndexOf(seprator);
	
	  String s1=text.substring(0, 3);
	  System.out.println(s1.length()+"length");
	  System.out.println(s1+"value of reserved s1");
	  String s2=text.substring(5, sepos).trim();
	  System.out.println(s2+"value of reserverd s2 resrvbtnpng");
	  
	  Integer i1=Integer.valueOf(s1);
	  Integer i2=Integer.valueOf(s2);
	  
	  if(text.contains("+")) {
		  Integer I=i1+i2;
		  String S=String.valueOf(I);
		  anscd.sendKeys(S);
		  gobtn.click();
	  }else if(text.contains("-")) {
		  Integer I=i1-i2;
		  String S=String.valueOf(I);
		  anscd.sendKeys(S);
		  gobtn.click();
		 // Thread.sleep(4000);
	  }
	
	  
	
	}

}
