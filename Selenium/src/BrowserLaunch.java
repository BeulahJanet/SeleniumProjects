import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserLaunch {
	
	public static WebDriver driver;
	
	public static void chromeLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	public static void firefoxLaunch() {
		
		System.setProperty("webdriver.firefox.marionette", "D:\\JavaClass\\Selenium\\Driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
	
	}
	
	public static void IELaunch() {
		System.setProperty("webdriver.ie.driver", "D:\\JavaClass\\Selenium\\Driver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.navigate().to("http://www.google.com/");
	}
		
	public static void main(String[] args) {
		chromeLaunch();
		//firefoxLaunch();
		//IELaunch();	
	}

}
