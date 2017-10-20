package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox {

		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			
			   Logger logger = Logger.getLogger("");
			   logger.setLevel(Level.OFF);

	           String driverPath = "";

	           String url = "http://facebook.com/";
	           String email_address = "publicbmuser@smsstam.net";
	           String password = "Buska@2017";
			
			    if (System.getProperty("os.name").toUpperCase().contains("MAC"))
				    driverPath = "./resources/webdrivers/mac/geckodriver.sh";
				else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
					driverPath = "./resources/webdrivers/pc/geckodriver.exe";
				else throw new IllegalArgumentException("Unknown OS");
			
				System.setProperty("webdriver.gecko.driver", driverPath);
			
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				WebDriverWait wait = new WebDriverWait(driver, 15); //Creating of "wait" Object

				driver.get(url);  //navigate to http://facebook.com/
				wait.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up")); // waiting until Login Page loads completely
				
				String title = driver.getTitle();   //assigns <Login> page title to "title" variable

		// assigns <Login> page Copyright footer string to "copyright" variable
		String copyright = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span"))).getText();
		
		String copyright_size = ("Size of Copyright: " + (Dimension) driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span")).getSize());
		String copyright_location = ("Location of Copyright: " + (Point) driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span")).getLocation());
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();   // clears email input field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys(email_address);  // inserts email into email input field
		
		String email_size = ("Size of Email: " + (Dimension) driver.findElement(By.id("email")).getSize()); 
		String email_location = ("Location of Email: " + (Point) driver.findElement(By.id("email")).getLocation());
		
		String password_size = ("Size of Password: " + (Dimension) driver.findElement(By.id("pass")).getSize());
		String password_location = ("Location of password: " + (Point) driver.findElement(By.id("pass")).getLocation());
		
		String loginbutton_size = ("Size of Login button: " + (Dimension) driver.findElement(By.id("loginbutton")).getSize());
		String loginbutton_location = ("Location of Login button: " + (Point) driver.findElement(By.id("loginbutton")).getLocation());
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();  // clears password input field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(password);  // inserts password into password input field

		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbutton"))).click();  // Click on Login button
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span"))).click();  // Click on Profile button
		// //*[@id='u_0_a']/div[1]/div[1]/div/a/span/span
		// //*[@id='u_0_b']/div[1]/div[1]/div/a/span/span
		
		String timeline_size = ("Size of Timeline: " + (Dimension) driver.findElement(By.xpath("//a[@data-tab-key = 'timeline']")).getSize()); 
		String timeline_location = ("Location of Timeline: " + (Point) driver.findElement(By.xpath("//a[@data-tab-key = 'timeline']")).getLocation()); 
		// System.out.println("String of Timeline tab: " + driver.findElement(By.xpath("//a[@data-tab-key = 'timeline']")).getText());
		// //a[@data-tab-key = 'timeline']
		
		String friends_size = ("Size of Friends: " + (Dimension) driver.findElement(By.xpath("//a[@data-tab-key = 'friends']")).getSize()); 
		String friends_location = ("Location of Friends: " + (Point) driver.findElement(By.xpath("//a[@data-tab-key = 'friends']")).getLocation()); 
		// System.out.println("String of Friends tab: " + driver.findElement(By.xpath("//a[@data-tab-key = 'friends']")).getText());
		// //a[@data-tab-key = 'friends']
		
		// assigns number of friends to "friends" variable
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/ul/li[3]/a/span[1]"))).getText();
		
		// if number of friends is zero reassigns 'No' string to "friends" variable
		if (friends.length() == 0){
	    	friends = "NO";}
		
		String accountsettings_size = ("Size of Account Settings: " + (Dimension) driver.findElement(By.id("userNavigationLabel")).getSize()); 
		String accountsettings_location = ("Location of Account Settings: " + (Point) driver.findElement(By.id("userNavigationLabel")).getLocation()); 
		// System.out.println("String of Account Settings icon: " + driver.findElement(By.id("userNavigationLabel")).getText());
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavigationLabel"))).click(); // Click on Account Settings icon button
		
		String logout_size = ("Size of Log Out: " + (Dimension) driver.findElement(By.xpath("//span[text()='Log Out']")).getSize()); 
		String logout_location = ("Location of Log Out: " + (Point) driver.findElement(By.xpath("//span[text()='Log Out']")).getLocation());
		// System.out.println("String of Log Out: " + driver.findElement(By.xpath("//span[text()='Log Out']")).getText());
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Log Out']"))).click(); // Click on Log Out option
			
		driver.quit();
			
		System.out.println("Browser is: Firefox");
		System.out.println("Title of the page: " + title);
		System.out.println(copyright_size);
		System.out.println(copyright_location);
		System.out.println(email_size);
		System.out.println(email_location);
		System.out.println(password_size);
		System.out.println(password_location);
		System.out.println(loginbutton_size);
		System.out.println(loginbutton_location);
		System.out.println(timeline_size);
		System.out.println(timeline_location);
		System.out.println(friends_size);
		System.out.println(friends_location);
		System.out.println(accountsettings_size);
		System.out.println(accountsettings_location);
		System.out.println(logout_size);
		System.out.println(logout_location);		
		System.out.println("Copyright: " + copyright);
		System.out.println("You have " + friends + " friends");
		}
}