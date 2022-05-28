package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spicejetpage {

WebDriver driver;
@FindBy(xpath="//div[text()='round trip']")
WebElement trip;

@FindBy(xpath="//div[text()='From']")
WebElement deprt;

@FindBy(xpath="//div[@data-testid='to-testID-destination']")
WebElement arriv;

@FindBy(xpath="//div[text()='DEL']")

WebElement arrivstat;

@FindBy(xpath="//div[text()='Guwahati']")
WebElement deprtstat;

@FindBy(xpath="//div[text()='Departure Date']")
WebElement depdat;

@FindBy(xpath="(//div[@class='css-1dbjc4n'])[56]")
WebElement arrivdate;

@FindBy(xpath="(//div[text()='11'])[2]")
WebElement returnd;


@FindBy(xpath="//div[text()='1 Adult']")
WebElement passanger;

@FindBy(xpath="//div[@data-testid='Adult-testID-plus-one-cta']")
WebElement adultp;

@FindBy(xpath="//div[@data-testid='Children-testID-plus-one-cta']")
WebElement child;

@FindBy(xpath="//div[@data-testid='Infant-testID-plus-one-cta']")
WebElement infant;

@FindBy(xpath="//div[text()='INR']")
WebElement currency;

@FindBy(xpath="//div[text()='USD']")
WebElement unit;

@FindBy(xpath="//div[text()='Students']")
WebElement senctzn;


@FindBy(xpath="//div[@data-testid='home-page-flight-cta']")
WebElement srchflight;

//constructor

public Spicejetpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void triptype() {
	trip.click();
}

public void from() {
	deprt.click();
	
}
public void deprtstate() {
	deprtstat.click();
}

public void arrival() {
	arriv.click();
}
public void arivstate() {
	WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(3));
	wt.until(ExpectedConditions.visibilityOf(arrivstat));
	arrivstat.click();
}
public void departuredate()  {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
	wait.until(ExpectedConditions.visibilityOf(depdat));
	depdat.click();
}

public void arrivaldate() {
	for(int m=1;m<=2;m++) {
		arrivdate.click();
	}
	
	
}
public void returndate() {
	returnd.click();
}

public void totalpassangers() {
	passanger.click();
	
}
public void adult() {
	for(int i=1; i<=3;i++) {
	adultp.click();
	}
}

public void childpickup() {
	for(int j=1; j<=2;j++) {
		child.click();
	}
}

public void infantR() {
	for(int k=1;k<=3; k++) {
		infant.click();
	}
}

public void currm() {
	currency.click();
}
public void currunit() {
	unit.click();
}

public void paxtype() {
	senctzn.click();
}

public void findflight() {
	srchflight.click();
}

}
