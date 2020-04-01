package com.emergya.utils;
import java.awt.AWTException;
import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.emergya.selenium.utils.Initialization;
import com.sun.media.Log;

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
	
	public static void click(WebDriver driver, WebElement element) {
		if(!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
			element.click();
        }else {
        	WebDriverUtils.clickButtonSafari(driver,element);
        }
	}
	
	public static void moveToElement(WebDriver driver, WebElement element, By locator) {
        if (!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String locatorType = locator.toString().substring(3);
            String elem = "var elem = document;";
            if (locatorType.startsWith("id")) {
                elem = "var elem = document.getElementById(\""+locatorType.substring(4)+"\");";
            }
            else if (locatorType.startsWith("xpath")) {
                String snippet = "document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue, "
                		+ "this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0)"
                		+ "{ return a.snapshotItem(0); } }; ";
                js.executeScript(snippet);
                String loc = locatorType.substring(7);
                elem = "var elem = document.getElementByXPath(\""+locatorType.substring(7)+"\");";
            }
            else if (locatorType.startsWith("className")) {
                elem = "var elem = document.getElementsByClassName(\""+locatorType.substring(14)+"\")[0];";
            }
            String mouseOverScript = elem + " if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',"
            		+ "true, false);" +
                    " elem.dispatchEvent(evObj);} else if(document.createEventObject) { elem.fireEvent('onmouseover');}";
            js.executeScript(mouseOverScript);
        }
    }
	
	public static void moveAndClick(WebDriver driver, WebElement element) {
		if(!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
			Actions builder = new Actions(driver);
			Action mouseOver = builder
                .moveToElement(element).click()
                .build();
			mouseOver.perform();
		}else {
			Actions builder = new Actions(driver);
			Action mouseOver = builder
                .moveToElement(element,-10,-10)
                .build();
			mouseOver.perform();
			WebDriverUtils.click(driver, element);
		}
	}
	
	public static void moveAndClick2(WebDriver driver, WebElement element) {
		if(!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
			Actions builder = new Actions(driver);
			Action mouseOver = builder
                .click(element)
                .build();
			mouseOver.perform();
		}else {
			Actions builder = new Actions(driver);
			Action mouseOver = builder
                .moveToElement(element,-10,-10)
                .build();
			mouseOver.perform();
			WebDriverUtils.click(driver, element);
		}
	}
	
	public static int dateCompareTo(String date1, String format1, String date2, String format2) {
		SimpleDateFormat sdformat = new SimpleDateFormat(format1);
		Date d1 = null;
		try {
			d1 = sdformat.parse(date1);
		} catch (ParseException e) {
			Log.error("Error when parsing date1 in dateCompareTo");
		}
		Date d2 = null;
		SimpleDateFormat sdformat2 = new SimpleDateFormat(format2);
		try {
			d2 = sdformat2.parse(date2);
		} catch (ParseException e) {
			Log.error("Error when parsing date2 in dateCompareTo");
		}
		return d1.compareTo(d2);
	}
	
	public static boolean isRemoteBrowser() {
		Logger log = Logger.getLogger(WebDriverUtils.class);
		log.info("[log-isRemoteBrowser] " + WebDriverUtils.class
                + "- Start isRemoteBrowser method");
		String properties = "test.properties";
        Properties prop = new Properties();
        String browser = "";

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            // Load a properties file
            prop.load(loader.getResourceAsStream(properties));

            // Get the property value
            browser = prop.getProperty("browser");
        }catch(Exception e){
        	log.error("[log-isRemoteBrowser] Error in" + WebDriverUtils.class
                + "- Start isRemoteBrowser method");
        }
        if(browser.equalsIgnoreCase("Remote")) {
        	return true;
        }else {
        	return false;
        }
	}
}
