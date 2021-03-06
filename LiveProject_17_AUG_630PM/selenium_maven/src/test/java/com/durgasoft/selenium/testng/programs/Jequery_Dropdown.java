package com.durgasoft.selenium.testng.programs;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Jequery_Dropdown {
	public WebDriver driver;
	@Test
	public void f() {
		driver.findElement(By.xpath
						("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		WebElement header = driver.findElement(By.xpath
										("//ul[@class='multiselect-container dropdown-menu']"));
		List<WebElement> ddValues = header.findElements(By.tagName("input"));
		System.out.println("Available values in DD :" + ddValues.size());
		for (int i = 0; i < ddValues.size(); i++) {
			ddValues.get(i).click();
		}
	}
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.manage().window().maximize();
	}

}
