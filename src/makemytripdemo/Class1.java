package makemytripdemo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import graphql.PublicApi;

public class Class1 {
	public WebDriver driver;
	public Class1(WebDriver driver) {
		this.driver=driver;
	}

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		Class1 c = new Class1(driver);
		c.radiobuttons();

	}

	public void radiobuttons() throws InterruptedException {
		String[] list = { "One Way", "Round Trip", "Multi City" };
		String xpath = "//*[@class='fswTabs latoRegular darkGreyText ']//li";
		int size = driver.findElements(By.xpath(xpath)).size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			String name = driver.findElements(By.xpath(xpath)).get(i).getText();
			if (name.equals(list[i])) {
				driver.findElements(By.xpath(xpath)).get(i).click();
				Thread.sleep(1000);
//				break;

				String classname = driver.findElement(By.xpath("(//*[@class='specialFareNew']//li[6]//p)[1]"))
						.getAttribute("class");
				if (classname.equals("disabled")) {
					System.out.println("When clicking on "+name+" button the Double Seat Fares button is in disable mode");
				} else {
					System.out.println("When clicking on "+name+" button the Double Seat Fares button is in Enable mode");
				}
			}
		}
	}
}
