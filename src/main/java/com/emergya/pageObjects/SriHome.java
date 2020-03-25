package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import com.emergya.selenium.pageObject.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.utils.WebDriverUtils;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya main page
 * @author Iker Casado
 */
public class SriHome extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(SriHome.class);

    /**
     * Items keys selectors.
     */
    private static final String COMMUNITY = "communityButton";
    

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public SriHome(EmergyaWebDriver driver) {
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

        boolean status = this.isElementVisibleByXPath(COMMUNITY);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }


    // Page object methods
    
    /**
     * This method click on community button
     */
    
    public CommunityPage clickOnCommunity() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnCommunity method");

        if ((communityButtonVisible())) {
            this.getElementByXPath(COMMUNITY).click();
        }
        
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(COMMUNITY);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");
        return new CommunityPage(driver);
        
    }
    /**
    * Return if the button of contact is visible
    * @return
    */
    public boolean communityButtonVisible() {
       log.info("[log-pageObjects]" + this.getClass().getSimpleName()
               + "]- Start communityButtonVisible method");
       log.info("[log-pageObjects]" + this.getClass().getSimpleName()
               + "]- End communityButtonVisible method");

       return this.isElementVisibleByXPath(COMMUNITY);
    }
    
}




    
   