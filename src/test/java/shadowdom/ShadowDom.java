package shadowdom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.Utils;

import com.vtiger.genericUtility.FileUtility;
import com.vtiger.genericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.xpath("//p[contains(text(),'Download vers')]/following::p/a[text()='32 bit Windows IE']")).click();
	
		Thread.sleep(8000);
		
		driver.get("chrome://downloads/");
		
		WebElement shadowhost = driver.findElement(By.tagName("downloads-manager"));
		//SearchContext shadowroot = shadowhost.getShadowRoot();
	//	WebElement shadoeTree1 = shadowroot.findElement(By.id("downloadsList"));
		//WebElement shadoeTree2 = shadoeTree1.findElement(By.id("frb0"));
		//SearchContext targetElement = shadoeTree2.getShadowRoot();
		//targetElement.findElement(By.id("show")).click();
		
	}

}
