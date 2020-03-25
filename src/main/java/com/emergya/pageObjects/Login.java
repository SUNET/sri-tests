package com.emergya.pageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.utils.WebDriverUtils;
import com.emergya.selenium.pageObject.*;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya main page
 * @author Iker Casado
 */
public class Login extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(Login.class);

    /**
     * Items keys selectors.
     */
    private static final String NOOCLookLogo = "logo";
    private static final String USERNAME = "usernameField";
    private static final String PASSWORD = "passwordField";
    private static final String LOGINBUTTON= "loginButton";

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public Login(EmergyaWebDriver driver) {
        super(driver);
    }

    /**
     * Checks that the PO is ready
     * @param pageObject page object to be used
     */
    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");

        boolean status = this.isElementVisibleByXPath(NOOCLookLogo);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }

    // Page object methods
    /**
     * Check if NO is displayed
     * @return
     */
    public boolean isNocLookLogoDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isEmergyaLogoDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isEmergyaLogoDisplayed method");

        return this.isElementVisibleByXPath(NOOCLookLogo);
    }
    
    
    /**
     * This method fill username by a string search
     * @param stringSearch
     */
    public void fillUsername(String stringSearch) {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start fillUsername -[" + this.getClass().getSimpleName()
                + "- method]");

        if (userNameVisible()) {
            this.getElementById(USERNAME).sendKeys(stringSearch);
        }

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End fillUsername -["
                        + this.getClass().getSimpleName() + "- method]");
    }
       
    /**
     * Return if the button of work with us
     *  is visible
     * @return
     */
    public boolean userNameVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start userNameVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End userNameVisible method");

        return this.isElementVisibleById(USERNAME);
    }  
    
    /**
     * This method fill password by a string search
     * @param stringSearch
     */
    public void fillPassword(String stringSearch) {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start fillPassword -[" + this.getClass().getSimpleName()
                + "- method]");

        if (passwordVisible()) {
            this.getElementById(PASSWORD).sendKeys(stringSearch);
        }

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End fillUsername -["
                        + this.getClass().getSimpleName() + "- method]");
    }
       
    /**
     * Return if the button of work with us
     *  is visible
     * @return
     */
    public boolean passwordVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start passwordVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End passwordVisible method");

        return this.isElementVisibleById(PASSWORD);
    }  
    
    /**
     * Click on the button login
     * @return 
     * @return
     */
    public SriHome clickOnLogin() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnLogin method");

        if ((loginButtonvisible())) {
            this.getElementByXPath(LOGINBUTTON).click();
        }
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(LOGINBUTTON);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver, this.getElementByXPath(LOGINBUTTON));
        	}
        }
        

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");
        return new SriHome(driver);
        
    }
    /**
     * Return if the button of contact is visible
     * @return
     */
    public boolean loginButtonvisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start loginButtonVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End loginButtonVisible method");

        return this.isElementVisibleByXPath(LOGINBUTTON);
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
