package org.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
 
	public static WebDriver driver;
    	
	public static WebDriver browserLaunch(String web) {
		
		if(web.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (web.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(web.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		return driver;
	}
	
	public static WebDriver browserLaunch2(String web) {
		switch (web) {
		case"chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case"edge":
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 break;
		}
		return driver;
	}
		public static void urlLaunch(String url) {
			driver.get(url);
			driver.manage().window().maximize();

	}
	public static void implicitWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	public static void maximise() {
		driver.manage().window().maximize();
	}
	public static void quit() {
		driver.quit();
	}
	
	// DRIVER
	public static void getUrl(String url) {
		 driver.get(url);
	}
	public static String getCurrentUrl() {
		 return driver.getCurrentUrl();
	}
	public static String getTittle() {
		return driver.getTitle();
	}
	public static String getHandle() {
		return driver.getWindowHandle();
	}
	public static Set<String> getHandles() {
		return driver.getWindowHandles();
	}
	
	//WEBELEMNT
	public static void sendKeys(WebElement ele, String a) {
		ele.sendKeys(a);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static String getText(WebElement e) {
		return e.getText();
	}
	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
	}
	public static String getCSSValue(WebElement e) {
		return e.getCssValue("value");
	}
	public static String getTagName(WebElement e) {
		return e.getTagName();
	}
	public static boolean isEnabled(WebElement e) {
		return e.isEnabled();
	}
	public static boolean isSelected(WebElement e) {
		return e.isSelected();
	}
	public static boolean is(WebElement e) {
        return e.isDisplayed();
	}
	
	//NAVIGATION
	public static void to(String url) {
		driver.navigate().to(url);
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	//SCREENSHOT
	
	public static void screenShot() throws IOException {
		TakesScreenshot s = (TakesScreenshot)driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		File dst = new File("C:\\Users\\HP\\Downloads\\eclipse-java-oxygen-3a-win32-x86_64\\eclipse\\BaseClass\\target\\screenshot"+time+".png");
        FileUtils.copyFile(src, dst);
	}
	private void screenShotWebElement(WebElement e) throws IOException {
		File src = e.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		File dst = new File("C:\\Users\\HP\\Downloads\\eclipse-java-oxygen-3a-win32-x86_64\\eclipse\\BaseClass\\target\\screenshot"+time+".png");
        FileUtils.copyFile(src, dst);
	}
	
	//ACTIONS
	
	public static void moveToElement (WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void dragAndDrop(WebElement src, WebElement dst) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dst);
	}
	public static void rightClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e);
	}
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e);
	}
	public static void click() {
		Actions a = new Actions(driver);
		a.click();
	}
	
	//ALERT
	
	public static void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public static  void confirmAlert(String a) {
		if(a.equalsIgnoreCase("accept")) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		else {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();;
		}
	}
	public static  void promptAlert(String a,String acc) {
		Alert alert = driver.switchTo().alert();
		sendKeys( (WebElement) alert, a);
		if(acc.equalsIgnoreCase("accept")) {
			alert.accept();
		}
		else {
			alert.dismiss();
		}
	}
	
	//SELECT
	
	public static boolean isMUltipe(WebElement e) {
		Select s= new Select(e);
		return s.isMultiple();
	}
	public static List getOptions(WebElement e) {
		Select s= new Select(e);
		return s.getOptions();
	}
	public static void byIndex(WebElement e,int a) {
		Select s= new Select(e);
		s.selectByIndex(a);
	}
	public static void deselectByIndex(WebElement e,int a) {
		Select s= new Select(e);
		s.deselectByIndex(a);
	}
	public static void byValue(WebElement e,int a) {
		Select s= new Select(e);
		s.selectByIndex(a);
	}
	public static void deselectByValue(WebElement e,String a) {
		Select s= new Select(e);
		s.deselectByValue(a);
	}
	public static void byText(WebElement e,String a) {
		Select s= new Select(e);
		s.selectByVisibleText(a);
	}
	public static void deselectBy(WebElement e,String a) {
		Select s= new Select(e);
		s.deselectByVisibleText(a);
	}
	public static void deselectAll(WebElement e) {
		Select s= new Select(e);
		s.deselectAll();
	}
	public static List allSelectedOptions(WebElement e) {
		Select s= new Select(e);
		return s.getAllSelectedOptions();
	}
	public static String getFirstSelectedOption(WebElement e) {
		Select s= new Select(e);
		 String fs = s.getFirstSelectedOption().toString();
		return fs;
	}
	public static String getLastSelectedOption(WebElement e) {
		Select s= new Select(e);
		List<WebElement> a = s.getAllSelectedOptions();
		String text = null;
		for(int i=a.size();i<0;i++) {
			if(i==a.size()) {
				 text = s.getFirstSelectedOption().toString();
			}
		}
		return text;
	}
	
	//JAVA SCRIPT
	
	public static void scrollUp(WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0], scrollIntoView(true)",e);
	}
	public static void scrollDown(WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0], scrollIntoView(false)",e);
	}
	
	// WINDOW HANDLING
	
	public static void toWindowByVlaue(int value) {
		String handle = BaseClass.getHandle();
		Set<String> handles = BaseClass.getHandles();
		int count=1;
		for(String eachId:handles) {
			if(count==value) {
				driver.switchTo().window(eachId);
			}
			count++;
		}		
	}
	public static void toWindowByIndex(int index) {
		Set<String> handles = BaseClass.getHandles();
		List<String> l = new ArrayList();
		l.addAll(handles);
		String eachId = l.get(index);
		driver.switchTo().window(eachId);
	}	
	// WEB TABLE
	public static List<WebElement> totalTable(String tagname) {
		return driver.findElements(By.tagName(tagname));
	}
	
	static WebElement tableElement = null;
	public static WebElement tableLocator(String tagname,String value) {
		
		if(tagname.equalsIgnoreCase("id")) {
		    tableElement = driver.findElement(By.id(value));
		}
		else if(tagname.equalsIgnoreCase("name")){
			 tableElement = driver.findElement(By.name(value));
		}
		else if(tagname.equalsIgnoreCase("class")) {
		      tableElement = driver.findElement(By.className(value));
		}
		return tableElement;
	}
	public static List row( String tagname) {
		return tableElement.findElements(By.tagName(tagname));
	}
	public static List heading(String tagname) {
		return tableElement.findElements(By.tagName(tagname));
	}
	public static List data(String tagname) {
		return tableElement.findElements(By.tagName(tagname));
	}	
}
