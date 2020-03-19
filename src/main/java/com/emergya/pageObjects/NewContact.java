package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import com.emergya.selenium.pageObject.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.selenium.utils.StringFormatter;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya main page
 * @author Iker Casado
 */
public class NewContact extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(NewContact.class);

    /**
     * Items keys selectors.
     */
    
    private static final String NEWORGANIZATION = "NewOrganization";
    private static final String ORGANIZATIONAME = "OrganizationName";
    private static final String ORGANIZATIONTYPE = "OrganizationType";
    private static final String ORGANIZATIONTYPE1 = "OrganizationType1";
    private static final String AFFILIATION = "Affiation";
    private static final String ORGANIZATIONID = "OrganizationID";
    private static final String ORGANIZATIONDESCRIPTION = "Description";
    private static final String ORGANIZATIONWEBSITE = "OrganizationWebsite";
    private static final String ADDNEWADDRESS = "AddNewAdress";
    private static final String STREET = "Street";
    private static final String POSTALCODE = "PostalCode";
    private static final String POSTALAREA = "PostalArea";
    private static final String PHONE = "Phone";
    private static final String SAVEBUTTON = "SaveButton";
    private static final String ORGANIZATIONVISIBLE = "TestVisible";
    private static final String DELETEBUTTON = "DeleteButton";


    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public NewContact(EmergyaWebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");

        boolean status = this.isElementVisibleByXPath(NEWORGANIZATION);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }
    
    // Organization name field
    public void organizationName(String stringSearch) {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start organizationName -[" + this.getClass().getSimpleName()
                + "- method]");

        if (organizationNameVisible()) {
            this.getElementByXPath(ORGANIZATIONAME).sendKeys(stringSearch);
        }

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End organizationName -["
                        + this.getClass().getSimpleName() + "- method]");
    }
       
  // Check if organizationName is visible
    public boolean organizationNameVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start organizationNameVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End organizationNameVisible method");

        return this.isElementVisibleByXPath(ORGANIZATIONAME);
    }  
    
 // Description name field
    public void organizationDescription(String stringSearch) {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start organizationDescription -[" + this.getClass().getSimpleName()
                + "- method]");

        if ((organizationDescriptionVisible())) {
            this.getElementByXPath(ORGANIZATIONDESCRIPTION).sendKeys(stringSearch);
        }

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End organizationName -["
                        + this.getClass().getSimpleName() + "- method]");
    }

    
 // Check if Description is visible
    public boolean organizationDescriptionVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start organizationDescriptionVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End organizationDescriptionVisible method");

        return this.isElementVisibleByXPath(ORGANIZATIONDESCRIPTION);
    }  
    
   
    //Organization affiliation type
    public void selectType() {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start organizationName -[" + this.getClass().getSimpleName()
                + "- method]");

            this.getElementByXPath(ORGANIZATIONTYPE).click();
            driver.sleep(2);
            this.getElementByXPath(ORGANIZATIONTYPE1).click();
           // this.getElementByXPath(ORGANIZATIONTYPE).sendKeys(stringSearch);
      

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End organizationName -["
                        + this.getClass().getSimpleName() + "- method]");
    }
 // Check if OrganizationType is visible
    public boolean organizationTypeVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start organizationTypeVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End organizationTypeVisible method");

        return this.isElementVisibleByXPath(ORGANIZATIONTYPE);
    }  
    
    //Check if affiliation is visible
        public boolean affiliationVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start affiliationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End affiliationVisible method");

        return this.isElementVisibleByXPath(AFFILIATION);
    }  
    
        //Select Affiliation
        public void selectAffiliation() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start selectAffiliation -[" + this.getClass().getSimpleName()
                    + "- method]");

                this.getElementByXPath(AFFILIATION).click();
                driver.sleep(2);
       
        }     
        
        //Check if organization ID is visible
        public boolean organizationIDVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start organizationIDVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End organizationIDVisible method");

        return this.isElementVisibleByXPath(ORGANIZATIONID);
    }  
        
       // Organization ID field
        public void organizationID(String stringSearch) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start organizationID -[" + this.getClass().getSimpleName()
                    + "- method]");

            if (organizationIDVisible()) {
                this.getElementByXPath(ORGANIZATIONID).sendKeys(stringSearch);
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End organizationID -["
                            + this.getClass().getSimpleName() + "- method]");
        }
        
     // Website field
        public void organizationWebsite(String stringSearch) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start organizationWebsite -[" + this.getClass().getSimpleName()
                    + "- method]");

            if ((organizationWebsiteVisible())) {
                this.getElementByXPath(ORGANIZATIONWEBSITE).sendKeys(stringSearch);
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End organizationWebsite -["
                            + this.getClass().getSimpleName() + "- method]");
        }
        
     // Check Website field is visible
        public boolean organizationWebsiteVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start organizationWebsiteVisible method");
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End organizationWebsiteVisible method");

            return this.isElementVisibleByXPath(ORGANIZATIONWEBSITE);
        }  

        //Add new Adress
        public void AddNewAdress() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start AddNewAdress -[" + this.getClass().getSimpleName()
                    + "- method]");

                this.getElementByXPath(ADDNEWADDRESS).click();
                driver.sleep(2);
       
        }     
        
        //Check if New Address button is visible
        public boolean NewAddressButtonVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start NewAddressButtonVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End NewAddressButtonVisible method");

        return this.isElementVisibleByXPath(ADDNEWADDRESS);
    }  
        
        
     // Street Field
        public void Street(String stringSearch) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start Street -[" + this.getClass().getSimpleName()
                    + "- method]");

            if ((StreetVisible())) {
                this.getElementByXPath(STREET).sendKeys(stringSearch);
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End organizationWebsite -["
                            + this.getClass().getSimpleName() + "- method]");
        }
        
     // Check Street Field
        public boolean StreetVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start StreetVisible method");
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End StreetVisible method");

            return this.isElementVisibleByXPath(STREET);
        }  

        // Postal Code Field
        public void PostalCode(String stringSearch) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start PostalCode -[" + this.getClass().getSimpleName()
                    + "- method]");

            if ((PostalCodeVisible())) {
                this.getElementByXPath(POSTALCODE).sendKeys(stringSearch);
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End PostalCode -["
                            + this.getClass().getSimpleName() + "- method]");
        }
        
     // Check Postal Code
        public boolean PostalCodeVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start PostalCodeVisible method");
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End PostalCodeVisible method");

            return this.isElementVisibleByXPath(POSTALCODE);
        }  
        
        // Postal Area Field
        public void PostaArea(String stringSearch) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start PostaArea -[" + this.getClass().getSimpleName()
                    + "- method]");

            if ((PostalAreaVisible())) {
                this.getElementByXPath(POSTALAREA).sendKeys(stringSearch);
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End PostalArea -["
                            + this.getClass().getSimpleName() + "- method]");
        }
        
     // Check Area Code
        public boolean PostalAreaVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start PostalAreaVisible method");
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End PostalAreaVisible method");

            return this.isElementVisibleByXPath(POSTALAREA);
        }  
        
        // Phone Field
        public void Phone(String stringSearch) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start Phone -[" + this.getClass().getSimpleName()
                    + "- method]");

            if ((PhoneVisible())) {
                this.getElementByXPath(PHONE).sendKeys(stringSearch);
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End PostalArea -["
                            + this.getClass().getSimpleName() + "- method]");
        }
        
     // Check Phone Field
        public boolean PhoneVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start PhoneVisible method");
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End PhoneVisible method");

            return this.isElementVisibleByXPath(PHONE);
        }  
        
      
        //Save
        public void SaveButton() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start SaveButton -[" + this.getClass().getSimpleName()
                    + "- method]");

                this.getElementByXPath(SAVEBUTTON).click();
                driver.sleep(2);
       
        }     
        
        //Check if Save Button button is visible
        public boolean SaveButtonVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start SaveButtonVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End SaveButtonVisible method");

        return this.isElementVisibleByXPath(SAVEBUTTON);
    }  
        
        /**
         * This method checks if view key button is displayed
         */
        public boolean isOrganizationVisible(String organizationName) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start isDescriptonNotDisplayed method");
           // String xpathExpression = "//div[contains(text(),"
            //        + StringFormatter.escapeSimpleQuotesForXpath(organizationName)
            //        + ")]";
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End isDescriptonNotDisplayed method");
            //return true;
            return this.isElementVisibleByXPath(ORGANIZATIONVISIBLE);
        }
        
      //Click on the created test
        public void ClickOnTest() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start ClickOnTest -[" + this.getClass().getSimpleName()
                    + "- method]");

                this.getElementByXPath(ORGANIZATIONVISIBLE).click();
                
        
}
        
        //Delete Button
        public void DeleteButton() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start DeleteButton -[" + this.getClass().getSimpleName()
                    + "- method]");
            this.getElementsByXPath(DELETEBUTTON).get(0).click();
                //this.getElementByXPath(DELETEBUTTON).click();
                driver.sleep(2);
       
        }     
        
        //Check if Delete Button is visible
        public boolean DeleteButtonVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start DeleteButtonVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End DeleteButtonVisible method");

        return this.isElementVisibleByXPath(DELETEBUTTON);
    }  

            
        }

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
