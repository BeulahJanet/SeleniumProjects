import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractice {
	
	public static WebDriver driver;
	
	public static void browserLaunch(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browsername.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} 
		else if (browsername.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} 
		else 
		{
			System.out.println("browser name is invalid");
		}

		driver.manage().window().maximize();
	}

	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static void createAccount() throws Throwable {
		
		Thread.sleep(3000);
		WebElement emailId = driver.findElement(By.xpath("//input[@id='email_create']"));
		emailId.sendKeys("beulahdeva@gmail.com");
		
		WebElement button = driver.findElement(By.xpath("//i[@class='icon-user left']"));
		button.click();
		
		Thread.sleep(5000);
		WebElement radioBtn = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
		radioBtn.click();
		
		WebElement fName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		fName.sendKeys("Beulah");
		
		WebElement lName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lName.sendKeys("Deva");
		
		WebElement pasWrd = driver.findElement(By.xpath("//input[@id='passwd']"));
		pasWrd.sendKeys("BeuDev");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
		Select sd=new Select(day);
		sd.selectByIndex(14);
		
		WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
		Select sm=new Select(month);
		sm.selectByValue("1");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		Select sy=new Select(year);
		sy.selectByValue("1992");
		
		List<WebElement> chBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement allChBox : chBox) {
			allChBox.click();
		}
		
		WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
		company.sendKeys("Greens Tech");
		
		WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
		address1.sendKeys("2nd Avenue, AB Block");
		
		WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
		address2.sendKeys("SDV Arcade, 4th floor");
		
		WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
		city.sendKeys("Chennai");
		
		WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select sst=new Select(state);
		sst.selectByValue("14");
		
		WebElement postCode = driver.findElement(By.xpath("//input[@id='postcode']"));
		postCode.sendKeys("00004");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
		Select sc=new Select(country);
		sc.selectByValue("21");
		
		WebElement textArea = driver.findElement(By.xpath("//textarea[@id='other']"));
		textArea.sendKeys("Hello");
		
		WebElement homePhone = driver.findElement(By.xpath("//input[@id='phone']"));
		homePhone.sendKeys("1234567");
		
		WebElement mobPhone = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
		mobPhone.sendKeys("9876543210");
		
		WebElement referAdd = driver.findElement(By.xpath("//input[@value='My address']"));
		referAdd.sendKeys("Ayapakkam");
		
		WebElement registerBtn = driver.findElement(By.xpath("//button[@id='submitAccount']"));
		registerBtn.click();
			
	}

}
