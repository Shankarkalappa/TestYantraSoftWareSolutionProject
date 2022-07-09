package LandMark;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Script2 {
	
	public void loginpageVerify() throws InterruptedException {
		//public static void main(String[] args) throws InterruptedException {
			
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.homecentre.com/ae/en/");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("standalone-j_username")).sendKeys("lmgsachin0109@gmail.com");
		driver.findElement(By.id("standalone-j_password")).sendKeys("123456");
		driver.findElement(By.id("standalone-signin-form-submit")).click();
		Thread.sleep(10000);
		 //WebElement country = driver.findElement(By.xpath("//div[contains(@class,'MuiBox-root jss72 icon')]"));
		// WebElement country = driver.findElement(By.xpath("//div[@id='langChange']/..//div[@class='MuiBox-root jss72 icon-down-arrow-white ']"));
		// driver.findElement(By.xpath("//div[@id='langChange']/..//div[@class='MuiBox-root jss72 icon-down-arrow-white ']/../..")).click();
		  driver.findElement(By.xpath("//div[@id=\"root-desk-top-wrapper\"]//descendant::div[@class=\"MuiBox-root jss66\"]/div")).click();
			
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//js.executeScript("arguments[0].click();",country);
		
		driver.findElement(By.xpath("//nav[@aria-label=\"Country list\"]/div//div[text()='Saudi Arabia']")).click();
		//driver.findElement(By.xpath("//nav[@aria-label=\"Country list\"]/div//div[text()='Saudi Arabia']")).click();
		
//		String expectedHomepageTextUrl= "homecentre";
//		String actualHomePageTextUrl = driver.getCurrentUrl();
//		Assert.assertTrue(actualHomePageTextUrl.contains(expectedHomepageTextUrl));
		
		Thread.sleep(10000);
		String expectedText="Sign In";
		String actualText = driver.findElement(By.xpath("//button[@id='account-actions-signin']/span")).getText();
		System.out.println("Actual SignText"+actualText);
		Assert.assertEquals(actualText, expectedText);
		
		
	}


}
