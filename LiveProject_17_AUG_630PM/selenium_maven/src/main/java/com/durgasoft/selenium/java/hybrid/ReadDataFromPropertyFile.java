package com.durgasoft.selenium.java.hybrid;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFile {

	public static final String path = "./hmslogin.properties";

	public static String getValue(String key) throws Exception {
		File f = new File(path);
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(key);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getValue("browser"));
		WebDriver driver = new FirefoxDriver();
		driver.get(getValue("prodURL"));
		driver.manage().window().maximize();
		driver.findElement(By.name(getValue("usernameLoc"))).sendKeys(getValue("username"));
		driver.findElement(By.name(getValue("pwdLoc"))).sendKeys(getValue("password"));
		driver.findElement(By.name(getValue("loginLoc"))).click();

	}

}
