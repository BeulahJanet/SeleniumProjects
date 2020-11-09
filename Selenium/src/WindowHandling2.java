import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowHandling2 extends BaseClass{

	public static void main(String[] args) throws Throwable  {
		
		BaseClass.browserLaunch("chrome");
		driver.get("https://www.google.com");
		WebElement googleImages = driver.findElement(By.xpath("//a[text()='Images']"));
		
		//To perform right click
		
		Actions ac=new Actions(driver);
		ac.contextClick(googleImages).build().perform();
		
		String fId=driver.getWindowHandle();
		System.out.println(fId);
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		Set<String> pId = driver.getWindowHandles();
		System.out.println(pId);
		
		for (String s : pId) {
			if(!s.equals(fId)) {
				System.out.println(s);
				driver.switchTo().window(s);
				WebElement mob = driver.findElement(By.xpath("//input[@name='q']"));
				mob.sendKeys("Mobiles",Keys.ENTER);
				Thread.sleep(5000);
				driver.quit();
			}
		}

	}

}
