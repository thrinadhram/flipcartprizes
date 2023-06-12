package makemytripdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class flipcart {
	public WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver();
		  driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("iphone");
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	       
	        List<WebElement> items = driver.findElements(By.xpath("//*[@class='_4rR01T']"));
	        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='_30jeq3 _1_WHN1']"));

	       
	        Map<String, String> itemPriceMap = new HashMap<>();

//	       PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue(new MapValueComparator());
	        for (int i = 0; i < items.size(); i++) {
	            String item = items.get(i).getText();
	            String price = prices.get(i).getText();
	            itemPriceMap.put(item, price);
	        }
	        
	        LinkedHashMap<String,String> sortedByPrice = itemPriceMap.entrySet()
	        		.stream()
	        		.sorted(Map.Entry.comparingByValue())
	        		.collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue,
	        				(oldValue, newValue) -> oldValue , LinkedHashMap :: new));
//	        sortedByPrice.forEach(System.out :: println);
//		       pq.addAll(itemPriceMap.entrySet());
//		       System.out.println("pq "+pq.toString());
	        System.out.println(sortedByPrice);
	        
	      
	        driver.quit();
	}
//	public static class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {
//
//	    @Override
//	    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
//	        // Comparing the values of the entries
//	        return entry1.getValue().compareTo(entry2.getValue());
//	    }
//	    }
}
