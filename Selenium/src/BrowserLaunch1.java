import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch1 {

	public static WebDriver driver;

	public static void chromeLaunch() {
		System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//
		// String currentUrl = driver.getCurrentUrl();
		// System.out.println(currentUrl);
		//
		// String title = driver.getTitle();
		// System.out.println(title);

		//driver.manage().window().maximize();
		//driver.navigate().to(
		//		"https://www.snapdeal.com/?utm_source=earth_brand&utm_medium=search&utm_campaign=BrandCat_CPA_new&utm_source=earth_brand_new&utm_campaign=brandcat_cpa_new&utm_content=64922032306&gclid=EAIaIQobChMI4vOYp5KU5QIVBhOPCh1aqQ6SEAAYASAAEgK2UfD_BwE");
		
		driver.navigate().to("https://www.flipkart.com/offers-list/top-selling-mobiles?gclid=EAIaIQobChMIq8eLtr6Z5QIVRI6PCh0ndwfjEAAYASACEgLsSvD_BwE&screen=dynamic&pk=themeViews%3DTopsellers-Mobiles-March18%3AApp%2CTopsellers-Mobiles-March18%3ADesk~widgetType%3DdealCard~contentType%3Dneo&wid=2.dealCard.OMU&ef_id=EAIaIQobChMIq8eLtr6Z5QIVRI6PCh0ndwfjEAAYASACEgLsSvD_BwE:G:s&s_kwcid=AL!739!3!388909981641!e!!g!!flipkart&semcmpid=sem_8024046704_brand_eta_goog");

		// WebElement email = driver.findElement(By.id("profileIdentifier"));
		// email.sendKeys("beulahjanetpreethi@gmail.com");
		//
		// WebElement pass = driver.findElement(By.("password"));
		// pass.sendKeys("");
		//
		// WebElement btn = driver.findElement(By.linkText("Next"));
		// btn.click();

		// driver.navigate().back();
		// driver.navigate().forward();
		// driver.navigate().refresh();
		//
		// driver.close();
		// driver.quit();
	}

	public static void main(String[] args) {
		chromeLaunch();
	}
}
