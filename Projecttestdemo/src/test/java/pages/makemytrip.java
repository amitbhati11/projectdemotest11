package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class makemytrip {
WebDriver driver;

@FindBy(xpath="//li[@data-cy='roundTrip']")
WebElement roundtrip;
@FindBy(xpath="//input[@id='fromCity']")
WebElement dept;
@FindBy(xpath="//input[@placeholder='From']")
WebElement from;

@FindBy(xpath="//input[@id='toCity']")
WebElement arriv;

@FindBy(xpath="//input[@placeholder='To']")
WebElement to;

@FindBy(xpath="//span[text()='DEPARTURE']")
WebElement departdat;

@FindBy(xpath="//input[@id='return']")
WebElement arrivdat;

@FindBy(xpath="//span[@class='lbl_input latoBold appendBottom5']")
WebElement trvlrclss;

@FindBy(xpath="//li[@data-cy='adults-6']")
WebElement adults;

@FindBy(xpath="//li[@data-cy='children-2']")
WebElement children;

@FindBy(xpath="//li[@data-cy='infants-3']")
WebElement infnts;

@FindBy(xpath="//li[text()='Business']")
WebElement bussnss;

@FindBy(xpath="//button[text()='APPLY']")
WebElement aplybtn;

@FindBy(xpath="//li[@class='font12 blackText latoBold wrapFilter activeItem ']")
WebElement stufr;

@FindBy(xpath="//a[text()='Search']")
WebElement 	srchbtn;

@FindBy(xpath="//div[@class='clusterTabHeadList makeFlex active']")
WebElement fast;

@FindBy(xpath="(//button[text()='SELECT'])[7]")
WebElement selt;

@FindBy(xpath="//span[@class='grp-booking--header__arrowicon']")
WebElement arrowbtn;

//constructor

public makemytrip(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void trip() {
	roundtrip.click();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
}

public void departure() throws InterruptedException {
	dept.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(from));
	
	from.sendKeys("New york");
	Thread.sleep(4000);
	from.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(3000);
	from.sendKeys(Keys.TAB);
}
public void aarival() throws InterruptedException {
	//arriv.click();
	Thread.sleep(2000);
	to.sendKeys("Delhi");
	Thread.sleep(2000);
	to.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(3000);
	to.sendKeys(Keys.TAB);
}
public void deptdat() {
	departdat.click();
	
	String exdate="12-August2022";
	String eday=exdate.split("-")[0];
	String emyr=exdate.split("-")[1];
	System.out.println(eday+"@"+emyr);
	WebElement el=driver.findElement(By.xpath("((//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[1]//div//div)[1]"));
	WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(5));
	wt.until(ExpectedConditions.visibilityOf(el));
	String cmyr=driver.findElement(By.xpath("((//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[1]//div//div)[1]")).getText();
	System.out.println(cmyr+"cmyr is:");
	while(!cmyr.equals(emyr)) {
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		cmyr=driver.findElement(By.xpath("((//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[1]//div//div)[1]")).getText();
	}
	       List<WebElement>  list=driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]//div[@class='DayPicker-Day']"));
	       for(int i=0;i<list.size();i++) {
	    	String cday =list.get(i).getText();
	    	if(cday.equals(eday)) {
	    		
	    		list.get(i).click();
	    		break;
	    	
	       }

}
	       
	       String rdate="31-December2022";
	       String rday=rdate.split("-")[0];
	       String ryr=rdate.split("-")[1];
	       
	       System.out.println(rday+"#"+ryr);
	       while(!cmyr.equals(ryr)) {
	    	   driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	    	   cmyr=driver.findElement(By.xpath("((//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[1]//div//div)[1]")).getText();
}
                
	       List<WebElement>  listr=driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]//div[@class='DayPicker-Day']"));
	       for(int k=0;k<listr.size();k++) {
	    	String cday =listr.get(k).getText();
	    	if(cday.equals(rday)) {
	    		
	    		listr.get(k).click();
	    		break;
	    	
	       }
	       }
}

public void travlerclass() {
	trvlrclss.click();
	adults.click();
	children.click();
	infnts.click();
	bussnss.click();
	aplybtn.click();
}
public void fairtype() {
	stufr.click();
}
public void search() {
	srchbtn.click();
}
public void fastest() {
	WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(10));
	wb.until(ExpectedConditions.visibilityOf(fast));
	fast.click();
	
}
public void selectflight() {
	selt.click();
}
public void sidearrow() {
	arrowbtn.click();
}

public void totallinksandimages() throws MalformedURLException, IOException {
	
	List<WebElement>  allist=driver.findElements(By.tagName("a"));
	allist.addAll(driver.findElements(By.tagName("img")));
	System.out.println(allist.size()+"totalsize-->");
	
	List<WebElement> activelink=new ArrayList<WebElement>();
	activelink.size();
	for(int j=0;j<allist.size();j++) {
		System.out.println(allist.get(j).getAttribute("href"));
		if((allist.get(j).getAttribute("href")!=null) && (!allist.get(j).getAttribute("href").contains("javascript") &&(!allist.get(j).getAttribute("href").contains("no protocal")))){
			
			activelink.add(allist.get(j));
		}
	}
	 System.out.println(activelink.size()+"total activelinksize-->");
	 
	 for(int m=0;m<activelink.size();m++) {
		 
		 
		  HttpURLConnection conct=( HttpURLConnection) new URL (activelink.get(m).getAttribute("href")).openConnection();
	           conct.connect();
	     String rmg= conct.getResponseMessage();
	     int rcode=conct.getResponseCode();
	     conct.disconnect();
	     System.out.println("active link are-->"+activelink.get(m).getAttribute("href")+rmg+"msg-->"+rcode);
	 }
}
}
