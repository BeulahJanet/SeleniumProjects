import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeTask {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\SeleniumCourse\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("email_create")).sendKeys("preetham@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("id_gender2")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("customer_firstname")).sendKeys("Beulah");
		driver.findElement(By.name("customer_lastname")).sendKeys("Janet");
		driver.findElement(By.id("passwd")).sendKeys("A4b9c1");
		
		WebElement day=driver.findElement(By.xpath("//select[@id='days']"));
		Select s=new Select(day);
		s.selectByIndex(14);
		WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
		Select s1=new Select(month);
		s1.selectByValue("1");
		WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
		Select s2=new Select(year);
		s2.selectByVisibleText("1992  ");
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement all : checkbox) {
			all.click();
		}
		
		driver.findElement(By.id("company")).sendKeys("XYZ Tech");
		driver.findElement(By.id("address1")).sendKeys("8th street, West Avenue Road");
		driver.findElement(By.id("address2")).sendKeys("C.G. Apartment, Building no.4, Floor no.2 ");
		driver.findElement(By.id("city")).sendKeys("MaryLand");
		
		WebElement state=driver.findElement(By.xpath("//select[@id='id_state']"));
		Select s3=new Select(state);
		s3.selectByVisibleText("Georgia");
			
		driver.findElement(By.id("postcode")).sendKeys("00028");
		
		driver.findElement(By.id("other")).sendKeys("Thank you");
		driver.findElement(By.id("phone")).sendKeys("12345");
		driver.findElement(By.id("phone_mobile")).sendKeys("678910");
		driver.findElement(By.id("alias")).sendKeys("Royal Enclave, Texas");
		driver.findElement(By.id("submitAccount")).click();
		
		driver.findElement(By.xpath("(//a[text()='Dresses'])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Summer Dresses')])[3]")).click();
		
		WebElement choose=driver.findElement(By.xpath("(//img[@title='Printed Summer Dress'])[2]"));
		Thread.sleep(2000);
		Actions ac1=new Actions(driver);
		ac1.moveToElement(choose).perform();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		driver.findElement(By.id("cgv")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\JavaClass\\Selenium\\ScreenShots\\confirmationReceipt.png");
		FileUtils.copyFile(sourceFile, destFile);

	}

}
