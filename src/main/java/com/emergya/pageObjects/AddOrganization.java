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
public class AddOrganization extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(AddOrganization.class);

    /**
     * Items keys selectors.
     */
    private static final String ADDORGANIZATIONBUTTON = "AddOrganizationButton";


    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public AddOrganization(EmergyaWebDriver driver) {
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

        boolean status = this.isElementVisibleByXPath(ADDORGANIZATIONBUTTON);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }

    // Page object methods
    /**
     * Check if NO is displayed
     * @return
     */
    public boolean isAddOrganizationButtonDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddOrganizationButtonDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddOrganizationButtonDisplayed method");

        return this.isElementVisibleByXPath(ADDORGANIZATIONBUTTON);
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
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
