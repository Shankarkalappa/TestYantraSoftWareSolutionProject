package LandMark;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LandMarkScript {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.homecentre.com/ae/en/");

		driver.findElement(By.xpath("//span[text()='Furniture']")).click();
		driver.findElement(By.name("q")).sendKeys("cup");

		Thread.sleep(3000);
		// List<WebElement> cup =
		// driver.findElements(By.xpath("//div[text()='Products']/following::*/ul[@id='product-list']/a/div/div"));
		String cup = driver.findElement(By.xpath("//ul[@id='product-list']/a[contains(@href,'G')]")).getText();
		System.out.println(cup);

	}

}
