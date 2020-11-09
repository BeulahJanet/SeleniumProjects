import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemoTask {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\SeleniumCourse\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		driver.findElement(By.xpath("//a[text()='destination of the week! The Beach!']")).click();
		Boolean displayPic=driver.findElement(By.xpath("//img[@src='assets/vacation.jpg']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println(displayPic);
		driver.navigate().back();
		Thread.sleep(2000);
		
		WebElement dept=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select s1=new Select(dept);
		s1.selectByValue("Philadelphia");
		WebElement dest=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select s2=new Select(dest);
		s2.selectByVisibleText("Rome");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("(//input[@class='btn btn-small'])[3]")).click();
		
		driver.findElement(By.id("inputName")).sendKeys("Celina");
		driver.findElement(By.id("address")).sendKeys("No.7, 3rd street");
		driver.findElement(By.id("city")).sendKeys("Texas");
		driver.findElement(By.id("state")).sendKeys("MaryLand");
		driver.findElement(By.id("zipCode")).sendKeys("24680");
		Thread.sleep(2000);
		
		WebElement cardType=driver.findElement(By.xpath("//select[@id='cardType']"));
		Select s3=new Select(cardType);
		s3.selectByValue("amex");
		
		driver.findElement(By.name("creditCardNumber")).sendKeys("987654321");
		driver.findElement(By.name("creditCardMonth")).sendKeys("6");
		driver.findElement(By.id("creditCardYear")).sendKeys("2015");
		driver.findElement(By.id("nameOnCard")).sendKeys("Celina Grace");
		Thread.sleep(2000);
		
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		Thread.sleep(3000);
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\JavaClass\\Selenium\\ScreenShots\\ticketbooked.png");
		FileUtils.copyFile(sourceFile, destFile);
	}

}
