import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowsHandling1 extends BaseClass{
	
public static void main(String[] args) throws Throwable  {
		
		BaseClass.browserLaunch("chrome");
		driver.get("https://www.google.com");
		WebElement googleImages = driver.findElement(By.xpath("//a[text()='Images']"));
		
		//To perform right click
		
		Actions ac=new Actions(driver);
		ac.contextClick(googleImages).build().perform();
		
		String fId=driver.getWindowHandle();
		System.out.println(fId);
		
		//Use keyboard actions
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.switchTo().window(fId);
		WebElement mob = driver.findElement(By.name("q"));
		mob.sendKeys("Mobiles", Keys.ENTER);
		
	}

}
