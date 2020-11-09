import java.io.IOException;

import org.openqa.selenium.By;

public class CheckBaseClass extends BaseClass{

	public static void main(String[] args) throws InterruptedException, IOException {
		browserLaunch("Chrome");
		launchUrl("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		promptAlert(driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")), "Hi");
		
		
	}

}
