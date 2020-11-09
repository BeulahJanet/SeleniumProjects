import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String browsername) {
		
		try {
			
		if (browsername.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\SeleniumCourse\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		} 
		else if (browsername.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "D:\\JavaClass\\SeleniumCourse\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} 
		else if (browsername.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "D:\\JavaClass\\SeleniumCourse\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else 
		{
			System.out.println("browser name is invalid");
		}
		driver.manage().window().maximize();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void launchUrl(String url) {
		
		try {		
			driver.get(url);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void currentUrl() {
		
		try {		
			String c=driver.getCurrentUrl();
			System.out.println(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getTitle() {
	
	try {		
		String t=driver.getTitle();
		System.out.println(t);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public static void enterText(WebElement element, String value)
	{
		try {
			element.sendKeys(value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clickButton(WebElement element)
	{
		try {
			element.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getAttribute(WebElement element, String keysValue)
	{
		try {
			element.sendKeys(keysValue);
			String s=element.getAttribute("value");
			System.out.println(s);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getText(WebElement element)
	{
		try {
			element.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getCssValue(WebElement element)
	{
		try {
		
			String color=element.getCssValue("color");
			System.out.println(color);
			
//			String fs=element.getCssValue("font-size");
//			System.out.println(fs);
//			
//			String ff=element.getCssValue("font-family");
//			System.out.println(ff);
//			
//			String bg=element.getCssValue("background");
//			System.out.println(bg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mouseHover(WebElement element) {
		
		try {
			
			Actions ac=new Actions(driver);
			ac.moveToElement(element).build().perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void dragnDrop(WebElement drag, WebElement drop) {
		
		try {
			
			Actions ac=new Actions(driver);
			ac.dragAndDrop(drag,drop).build().perform();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void sendKeysAndClick(WebElement element, String text, WebElement button) {
		
		try {
			
			Actions ac=new Actions(driver);
			ac.sendKeys(element,text).build().perform();
			ac.click(button).build().perform();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
		
	public static void doubleClick(WebElement element) {

		try {
			
			Actions ac=new Actions(driver);
			ac.doubleClick(element).build().perform();
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rightClick(WebElement element) {

		try {
			
			Actions ac=new Actions(driver);
			ac.contextClick(element).build().perform();
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clicknHold(WebElement drag, WebElement drop) throws Throwable {

		try {
			
			Actions ac=new Actions(driver);
			ac.clickAndHold(drag).build().perform();
			ac.moveToElement(drop).build().perform();
			ac.release(drop).build().perform();
			
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void allCheckBox(List<WebElement> l) {
		
		try {
			
			for(WebElement l1 : l ) {
				l1.click();
			}	
			
//			for(int i=0; i<l.size(); i++) {
//				l.get(i).click();
//			}
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void enabled(WebElement element) {
		
		try {
			
			boolean b=element.isEnabled();
			System.out.println(b);
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void displayed(WebElement element) {
		
		try {
			
			boolean b=element.isDisplayed();
			System.out.println(b);
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selected(WebElement element) {
		
		try {
			
			boolean b=element.isSelected();
			System.out.println(b);
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dropDownOptions(WebElement element,String option,String value) {
		
		try {
			  Select s=new Select(element);
			    
			    if (option.equalsIgnoreCase("Index")) 
			    {
			    	int parseInt = Integer.parseInt(value);
			    	s.selectByIndex(parseInt);
			    }
			    else if (option.equalsIgnoreCase("value")) 
			    {
			    	s.selectByValue(value);
			    }
			    else 
			    {
			    	s.selectByVisibleText(value);
			    }
//			    List<WebElement> l=s.getAllSelectedOptions();
//				for (WebElement l1 : l) {
//					System.out.println(l1.getText());
//				}	
			} 
		  	catch (Exception e) {
		  		e.printStackTrace();
			}
	}
	
	public static void OptionsIndropDown(WebElement element) {
		
		  try {
			  Select s=new Select(element);
			  
			    List<WebElement> l=s.getOptions();
				for (WebElement l1 : l) {
					System.out.println(l1.getText());
				}	
			} 
		  	catch (Exception e) {
		  		e.printStackTrace();
			}
	}
		
	public static void dropDownDeselects(WebElement element,String option,String value) {
		
		 try {
			  Select s=new Select(element);
			    
			    if (option.equalsIgnoreCase("Index")) 
			    {
			    	int parseInt = Integer.parseInt(value);
			    	s.deselectByIndex(parseInt);
			    }
			    else if (option.equalsIgnoreCase("value")) 
			    {
			    	s.deselectByValue(value);
			    }
			    else 
			    {
			    	s.deselectByVisibleText(value);
			    }
			    //s.deselectAll();
			} 
		  	catch (Exception e) {
		  		e.printStackTrace();
			}
	}		
		
	public static void firstSelectedOptions(WebElement element) {
		
		try {
			
			Select sel= new Select(element);
			WebElement firstOption=sel.getFirstSelectedOption();
			System.out.println(firstOption.getText());

		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getAllDropDownOptions(WebElement element) {
		
		try {
			
			Select sel= new Select(element);
			List<WebElement> Options=sel.getOptions();
			for (WebElement allOptions : Options) {
				System.out.println(allOptions.getText());
			}
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void autoSuggestion(WebElement element,String value,List<WebElement> l) throws InterruptedException {
		
		try {
			
			element.sendKeys(value);
			Thread.sleep(3000);
			System.out.println(l.size());
			for(WebElement w : l) {
				System.out.println(w.getText());
			}
			

		}
	    catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	public static void simpleAlert(WebElement alertBox) throws InterruptedException {
	
		try {
			
			alertBox.click();
			Thread.sleep(2000);
			Alert a = driver.switchTo().alert();
			Thread.sleep(2000);
			a.accept();

		}
	    catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void confirmAlertOk(WebElement alertOk) throws InterruptedException {

		try {
			
			alertOk.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void confirmAlertCancel(WebElement alertCancel) throws InterruptedException {

		try {
			
			alertCancel.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			Thread.sleep(2000);
			alert.dismiss();

		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void promptAlert(WebElement promptClick, String value) throws InterruptedException {
		
		try {
			
			promptClick.click();
			Thread.sleep(2000);
			Alert a=driver.switchTo().alert();
			a.sendKeys(value);
			Thread.sleep(3000);
			a.accept();
			//alert.dismiss();
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void screenShot(String name) {

		try {
			
			TakesScreenshot tk = (TakesScreenshot) driver;
			File sourceFile = tk.getScreenshotAs(OutputType.FILE);
			File destFile = new File("D:\\JavaClass\\Selenium\\ScreenShots\\"+name+".png");
			FileUtils.copyFile(sourceFile, destFile);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void javascriptSendkeys(WebElement element, String name) throws InterruptedException{

		try {
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','"+name+"')", element);		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void javascriptClick(WebElement element) throws InterruptedException {

		try {
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void javascriptScrollPixel() throws InterruptedException{

		try {
				
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");	
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,-500)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ScrollViewDown(WebElement element) throws InterruptedException{

		try {
				
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)",element);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ScrollViewUp(WebElement element) throws InterruptedException{

		try {
				
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)",element);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//clear, pagesource, windowhandling, robot
	
	public static void Frames(WebElement element,WebElement element1) throws InterruptedException{

		try {
			
			List<WebElement> l=driver.findElements(By.tagName("iframe"));
			System.out.println(l.size());
			driver.switchTo().frame(element);
			Thread.sleep(2000);
			element1.click();
			driver.switchTo().defaultContent();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void allLinksInPage() throws InterruptedException{

		try {
			
			List<WebElement> l=driver.findElements(By.tagName("a"));
			System.out.println(l.size());
			for(WebElement l1 : l) {
				System.out.println(l1.getAttribute("href"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
