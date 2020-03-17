package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import com.emergya.selenium.pageObject.*;
import org.openqa.selenium.Keys;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya main page
 * @author Iker Casado
 */
public class CommunityPage extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(CommunityPage.class);

    /**
     * Items keys selectors.
     */
    private static final String NOOCLookLogo = "logo";
    private static final String USERNAME = "usernameField";
    private static final String PASSWORD = "passwordField";
    private static final String LOGINBUTTON= "loginButton";
    private static final String ADDORGANIZATIONBUTTON = "AddOrganizationButton";
    private static final String ISORGANIZATIONVISIBLE = "isOrganizationVisible";

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public CommunityPage(EmergyaWebDriver driver) {
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
     */
    public CommunityPage clickOnLogin() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnLogin method");

        if ((loginButtonvisible())) {
            this.getElementByXPath(LOGINBUTTON).click();
        }

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");
        return new CommunityPage(driver);
        
        
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
    
    
    
    public NewOrganization clickAddOrganization() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickAddOrganization method");

        if ((AddOrganizationButtonvisible())) {
            this.getElementByXPath(ADDORGANIZATIONBUTTON).click();
        }

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");
        return new NewOrganization(driver);
        
        
    }
    /**
     * Return if the button of contact is visible
     * @return
     */
    public boolean AddOrganizationButtonvisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start AddOrganizationButtonvisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End AddOrganizationButtonvisible method");

        return this.isElementVisibleByXPath(ADDORGANIZATIONBUTTON);
    }
    
    public boolean isOrganizationVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isOrganizationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isOrganizationVisible method");

        return this.isElementVisibleByXPath(ISORGANIZATIONVISIBLE);
    }

    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
