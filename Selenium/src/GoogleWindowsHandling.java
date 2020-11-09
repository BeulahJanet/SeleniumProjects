
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoogleWindowsHandling extends BaseClass {
	
	public static void main(String[] args) throws Throwable  {
		
		BaseClass.browserLaunch("chrome");
		driver.get("https://www.google.com");
		WebElement googleImages = driver.findElement(By.xpath("//a[text()='Images']"));
		//Right Click
		Actions ac = new Actions(driver);
		ac.contextClick(googleImages).build().perform();
		
		//for Keyboard actions
		//Robot - Class
		
		//to tke first windows id
		String fId = driver.getWindowHandle();
		System.out.println(fId);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		WebElement gMail = driver.findElement(By.xpath("//a[text()='Gmail']"));
		ac.contextClick(gMail).build().perform();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Set<String> pId = driver.getWindowHandles();
		List<String> lPid = new ArrayList<String>();
		lPid.addAll(pId);
		
		System.out.println(pId);
		
//		for (int i = 0; i < lPid.size(); i++) {
//			String x = lPid.get(i);
//			driver.switchTo().window(x);
//			String title = driver.getTitle();
//			System.out.println(" Index "+ i +" and Title "+ title);
//		}
		
		String x = lPid.get(1);
		driver.switchTo().window(x);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[contains(text(),'Sign in')])[2]")).click();
		Thread.sleep(2000);
		driver.close();
		
		String y = lPid.get(2);
		driver.switchTo().window(y);
		System.out.println(title);
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Mobiles" , Keys.ENTER);;
		Thread.sleep(2000);
		driver.close();
		
		driver.quit();
		
	}

}
