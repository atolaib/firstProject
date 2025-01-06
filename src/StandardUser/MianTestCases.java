package StandardUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MianTestCases {
//تعريف البراوزر 
WebDriver driver = new ChromeDriver();
WebDriver driver2 = new EdgeDriver();

//تعريف الموقع بنوع string
String MyWebSite = "https://www.saucedemo.com/v1/";

//تعريف المستخدم والباس 
String UserName = "standard_user";
String Password ="secret_sauce";




	@BeforeTest
	public void MySetup() {
	//driver.get("https://www.google.com");
	//driver2.get("https://www.google.com");
		
		driver.get(MyWebSite);
		driver2.get(MyWebSite);
		
		driver.manage().window().maximize();
		driver2.manage().window().minimize();
		//driver2.manage().window().fullscreen();

	}
	
	@Test(priority = 1)
	public void LogIn() {
		
	driver.findElement(By.id("user-name")).sendKeys(UserName);
	driver.findElement(By.id("password")).sendKeys(Password);
	driver.findElement(By.id("login-button")).click();
	
	
	driver2.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(UserName);
	driver2.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);
	driver2.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}
	
	@Test (priority = 2)
	public void AddItemToTheCartItem() {
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")).click();

		
		driver2.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		
		
	}
	
	
	@Test(priority = 3, enabled = false)
	public void RemoveToCartItem() {
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		
		driver2.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
	}
	
	
/*	@Test(priority = 4)
	public void LogOut() {
		driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		
		
	}
	
	*/
	
	
	@AfterTest
	public void PostTesting() {
		//driver.quit();
		//driver2.quit();
		
		
	}
	
	
}
