package com.emergya.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverUtils {
	public static String getBrowserName(WebDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    return browserName;
	}
	
	public static void clickButtonSafari(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
	}
	
	public static Integer getRandomIntegerBetweenRange(Integer min, Integer max){
	    Integer x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public static void clearFieldSafari(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='';", element);
	}

}
