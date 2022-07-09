package com.broken.links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://www.deadlinkcity.com/");
		driver.get("https://www.hyrtutorials.com/");
		//driver.get("https://www.theworldsworstwebsiteever.com/");
		//driver.get("https://demo.actitime.com/login.do");
		
		Set<String> brokenLinksURLs= new LinkedHashSet<>();
				
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");
			URL url = new URL(linkURL);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection=(HttpURLConnection)urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode()!=200) {
				brokenLinksURLs.add(linkURL);
			}
			
//			if (httpURLConnection.getResponseCode()==200) {
//				System.out.println(linkURL+"-"+httpURLConnection.getResponseMessage());
//			} else {
//				System.err.println(linkURL+"-"+httpURLConnection.getResponseMessage()+"-"+httpURLConnection.getResponseMessage());
//			}
			httpURLConnection.disconnect();
		}
		driver.quit();
		for (String brokenLinksURL :brokenLinksURLs) {
			System.err.println(brokenLinksURL);
		}
	}
}
