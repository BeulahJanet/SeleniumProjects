import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCases {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\SeleniumCourse\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	//TC101
	@Test
	public void userLogin()
	{
		
		//driver.get("http://adactin.com/HotelApp/index.php");
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
	    driver.findElement(By.id("password")).sendKeys("devbeu123");
	    driver.findElement(By.id("login")).click();
	
	}
	
	//TC102
	@Test
	public void checkOutDateAcceptance() throws InterruptedException
	{
		
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
	    driver.findElement(By.id("password")).sendKeys("devbeu123");
	    driver.findElement(By.id("login")).click();
	    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
		
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);
		
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Standard");
		Thread.sleep(1000);
			
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByVisibleText("1 - One");
		Thread.sleep(1000);
		
//		driver.findElement(By.id("datepick_in")).sendKeys("24/10/2020"); unable to send keys like this
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','25/10/2020')", checkInDate);
		Thread.sleep(2000);
		
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','23/10/2020')", checkOutDate);
		Thread.sleep(5000);
		
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
		
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
	
	}
	
	//TC103
	@Test
	public void checkForPastDates() throws InterruptedException
	{
		
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
	    driver.findElement(By.id("password")).sendKeys("devbeu123");
	    driver.findElement(By.id("login")).click();
	    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
		
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);
		
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Standard");
		Thread.sleep(1000);
			
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByVisibleText("1 - One");
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','13/10/2020')", checkInDate);
		Thread.sleep(2000);
		
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','15/10/2020')", checkOutDate);
		Thread.sleep(5000);
		
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
		
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
	
	}
	
	//TC104
	@Test
	public void checkHotelLocation() throws InterruptedException
	{
			
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
			
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
		driver.findElement(By.id("password")).sendKeys("devbeu123");
		driver.findElement(By.id("login")).click();
		    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
			
		System.out.println("===//TC104 checkHotelLocation===");
		String expected=location.getAttribute("value");
		System.out.println(expected);
						
		List<WebElement>locationSelected = s.getAllSelectedOptions();
		for (WebElement locationDisplayed : locationSelected) 
		{
			System.out.println(locationDisplayed.getText());
			String actual=locationDisplayed.getText();
			Assert.assertEquals(actual, expected);
		}
				
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);
			
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Standard");
		Thread.sleep(1000);
				
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','22/10/2020')", checkInDate);
		Thread.sleep(2000);
			
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','23/10/2020')", checkOutDate);
		Thread.sleep(5000);
			
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		WebElement child_room=driver.findElement(By.id("child_room"));
		js.executeScript("arguments[0].setAttribute('value','0')", child_room);
		Thread.sleep(5000);
			
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
	
		}
	
	//TC105
	@Test
	public void checkInoutDates() throws InterruptedException
	{
			
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
			
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
		driver.findElement(By.id("password")).sendKeys("devbeu123");
		driver.findElement(By.id("login")).click();
		    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
			
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);
			
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Standard");
		Thread.sleep(1000);
				
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','22/10/2020')", checkInDate);
		Thread.sleep(2000);		
		System.out.println("===//TC105 checkInOutDates===");
		String expected_1=checkInDate.getAttribute("value");
		System.out.println(expected_1);
		
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','23/10/2020')", checkOutDate);
		Thread.sleep(2000);
		String expected_2=checkOutDate.getAttribute("value");
		System.out.println(expected_2);
			
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		WebElement child_room=driver.findElement(By.id("child_room"));
		js.executeScript("arguments[0].setAttribute('value','0')", child_room);
		Thread.sleep(1000);
			
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
		
//		driver.navigate().to("http://adactinhotelapp.com/HotelAppBuild2/SelectHotel.php");
//		
//		WebElement actual_1 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]"));
//		System.out.println(actual_1.getText());
//	
//		WebElement actual_2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[6]"));
//		System.out.println(actual_2.getText());
	
		}
	
	//TC106
	@Test
	public void checkNoOfRooms() throws InterruptedException
	{
			
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
			
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
		driver.findElement(By.id("password")).sendKeys("devbeu123");
		driver.findElement(By.id("login")).click();
		    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
			
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);
			
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Standard");
		Thread.sleep(1000);
				
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByValue("3");
		Thread.sleep(1000);
		
		System.out.println("===//TC106 checkNoOfRooms===");
		
		String expected_room=room_nos.getAttribute("value");
		System.out.println(expected_room);
		List<WebElement>roomNoSelected = s3.getAllSelectedOptions();
		for (WebElement roomNoDisplayed : roomNoSelected) 
		{
			System.out.println(roomNoDisplayed.getText());
			String actual_room=roomNoDisplayed.getText();
			String actual_room_no=actual_room.substring(0, 1);
			System.out.println(actual_room_no);
			Assert.assertEquals(actual_room_no, expected_room);
		}
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','22/10/2020')", checkInDate);
		Thread.sleep(2000);		
		
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','23/10/2020')", checkOutDate);
		Thread.sleep(2000);
				
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		WebElement child_room=driver.findElement(By.id("child_room"));
		js.executeScript("arguments[0].setAttribute('value','0')", child_room);
		Thread.sleep(1000);
			
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
	
		}
	
	//TC107
	@Test
	public void checkRoomType() throws InterruptedException
	{
			
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
			
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
		driver.findElement(By.id("password")).sendKeys("devbeu123");
		driver.findElement(By.id("login")).click();
		    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
				
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);	
		
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Deluxe");
		Thread.sleep(1000);
		
		System.out.println("===//TC107 checkRoomType===");
		String expected_room=room_type.getAttribute("value");
		System.out.println(expected_room);
		
		List<WebElement> RoomTypeSelected = s2.getAllSelectedOptions();
		for (WebElement roomTypeDisplayed : RoomTypeSelected) 
		{
			System.out.println(roomTypeDisplayed.getText());
			String actual_room=roomTypeDisplayed.getText();
			Assert.assertEquals(actual_room, expected_room);
		}
				
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','22/10/2020')", checkInDate);
		Thread.sleep(2000);
			
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','23/10/2020')", checkOutDate);
		Thread.sleep(5000);
			
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		WebElement child_room=driver.findElement(By.id("child_room"));
		js.executeScript("arguments[0].setAttribute('value','0')", child_room);
		Thread.sleep(5000);
			
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
	
		}
	
	//TC108
	@Test
	public void checkTotalPrice() throws InterruptedException
	{
			
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
			
		driver.findElement(By.id("username")).sendKeys("CelinaGrace");
		driver.findElement(By.id("password")).sendKeys("devbeu123");
		driver.findElement(By.id("login")).click();
		    
	    WebElement location=driver.findElement(By.xpath("//select[@name='location']"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		Thread.sleep(1000);
				
		WebElement hotels=driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s1=new Select(hotels);
		s1.selectByVisibleText("Hotel Creek");
		Thread.sleep(1000);	
		
		WebElement room_type=driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2=new Select(room_type);
		s2.selectByVisibleText("Standard");
		Thread.sleep(1000);
		
		WebElement room_nos=driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s3=new Select(room_nos);
		s3.selectByVisibleText("2 - Two");
		Thread.sleep(1000);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement checkInDate=driver.findElement(By.id("datepick_in"));
		js.executeScript("arguments[0].setAttribute('value','22/10/2020')", checkInDate);
		Thread.sleep(2000);
			
		WebElement checkOutDate=driver.findElement(By.id("datepick_out"));
		js.executeScript("arguments[0].setAttribute('value','23/10/2020')", checkOutDate);
		Thread.sleep(5000);
			
		WebElement adult_room=driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4=new Select(adult_room);
		s4.selectByVisibleText("1 - One");
		Thread.sleep(1000);
			
		WebElement child_room=driver.findElement(By.id("child_room"));
		js.executeScript("arguments[0].setAttribute('value','0')", child_room);
		Thread.sleep(5000);
			
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("radiobutton_0")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		
//		int price_per_night=125;
//		String Rooms_Booked=room_nos.getText();
//		String Rooms_With_numbers=Rooms_Booked.substring(0, 1);
//		String  = Rooms_With_numbers;
//		Integer intValue = Integer.parseInt(strValue);
//		float total_price=price_per_night*
	
		}
	
			
}
