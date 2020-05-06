package com.emergya.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import com.emergya.selenium.pageObject.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.selenium.utils.StringFormatter;
import com.emergya.utils.WebDriverUtils;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya main page
 * @author Iker Casado
 */
public class NewOrganization extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(NewOrganization.class);

    /**
     * Items keys selectors.
     */
    
    private static final String NEWORGANIZATION = "NewOrganization";
    private static final String ORGANIZATIONAME = "OrganizationName";
    private static final String ORGANIZATIONNUMBER =  "OrganizationNumber";
    private static final String ORGANIZATIONTYPE = "OrganizationType";
    private static final String ORGANIZATIONTYPE1 = "OrganizationType1";
    private static final String AFFILIATION = "Affiation";
    private static final String ORGANIZATIONID = "OrganizationID";
    private static final String PARENTORGANIZATIONID = "parentOrganizationID";
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
    private static final String EDITBUTTON = "EditButton";
    private static final String PROVIDERAFFILICATION = "providerAffiliation";
    private static final String AFFILIATIONCHECKED = "AffiliationSelected";
    private static String STREET_N = "//input[@name='addresses[{n}].street']";
    private static String POSTALCODE_N = "//input[@name='addresses[{n}].postal_code']";
    private static String POSTALAREA_N = "//input[@name='addresses[{n}].postal_area']";
    private static String PHONEADDRESS_N = "//input[@name='addresses[{n}].phone']";
    private static final String CONTACTSROWS = "contactsRow";
    private static String CONTACTSFIELD = "div";
    private static final String WORKLOG = "worklog";
    
    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public NewOrganization(EmergyaWebDriver driver) {
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
    
    public String getOrganizationName() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getOrganizationName method");
    	String name = "";
    	if(this.organizationNameVisible()) {
    		name = this.getElementByXPath(ORGANIZATIONAME).getAttribute("value");
    	}else {
    		log.error("Field Name is not visible");
    		throw new NoSuchElementException();
    	}
    	
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getOrganizationName method");
        return name;
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
    
    
    public String getOrganizationDescription() {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start getOrganizationDescription -[" + this.getClass().getSimpleName()
                + "- method]");
        String description = "";
        if ((organizationDescriptionVisible())) {
            description = this.getElementByXPath(ORGANIZATIONDESCRIPTION).getText();
        }else {
    		log.error("Field Description is not visible");
    		throw new NoSuchElementException();
    	}

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End getOrganizationDescription -["
                        + this.getClass().getSimpleName() + "- method]");
        return description;
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
            if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
            	WebElement element = this.getElementByXPath(ORGANIZATIONTYPE);
            	if(element != null) {
            		WebDriverUtils.clickButtonSafari(driver,element);
            	}
            	WebElement element1 = this.getElementByXPath(ORGANIZATIONTYPE1);
            	if(element != null) {
            		WebDriverUtils.clickButtonSafari(driver,element1);
            	}
            }

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End organizationName -["
                        + this.getClass().getSimpleName() + "- method]");
    }
    
    public String getOrganizationType() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start organizationTypeVisible method");
    	String type = "";
    	if(this.organizationTypeVisible()) {
    		type = WebDriverUtils.getSelectCurrentItem(this, ORGANIZATIONTYPE);
    	}else {
    		log.error("Field Type is not visible");
    		throw new NoSuchElementException();
    	}
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End organizationTypeVisible method");

        return type;

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
                if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
                	WebElement element = this.getElementByXPath(AFFILIATION);
                	if(element != null) {
                		WebDriverUtils.clickButtonSafari(driver,element);
                	}
                }
                driver.sleep(2);
        }
        
        public List<String> getAffiliationChecked(){
        	List<String> listItems = new ArrayList<String>();
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getAffiliationChecked method");
            List<WebElement> items = this.getElementsByXPath(AFFILIATIONCHECKED);
            for(WebElement item: items){
            	String textItem = item.getText();
            	listItems.add(textItem);
            }
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getAffiliationChecked method");
            return listItems;
        			
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
        
        // Organization ID field
        public String getOrganizationID() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start organizationID -[" + this.getClass().getSimpleName()
                    + "- method]");
            String organizationID = "";
            if (organizationIDVisible()) {
                organizationID = this.getElementByXPath(ORGANIZATIONID).getAttribute("value");
            }else{
        		log.error("Field Organization ID is not visible");
        		throw new NoSuchElementException();
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End organizationID -["
                            + this.getClass().getSimpleName() + "- method]");
            return organizationID;
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
        
        
        // Website field
        public String getOrganizationWebsite() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationWebsite -[" + this.getClass().getSimpleName()
                    + "- method]");
            String website = "";
            if ((organizationWebsiteVisible())) {
                website = this.getElementByXPath(ORGANIZATIONWEBSITE).getAttribute("value");
            }else {
            	log.error("Field Website is not available");
            	throw new NoSuchElementException();
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End getOrganizationWebsite -["
                            + this.getClass().getSimpleName() + "- method]");
            return website;
        }
        
        public String getParentOrganizationID() {
        	log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start getParentOrganizationID -[" + this.getClass().getSimpleName()
                    + "- method]");
            String parentOrganizationID = "";
            if (this.isElementVisibleByXPath(PARENTORGANIZATIONID)) {
                parentOrganizationID = this.getElementByXPath(PARENTORGANIZATIONID).getAttribute("value");;
            }else {
            	log.error("Field Website is not available");
            	throw new NoSuchElementException();
            }

            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End getParentOrganizationID -["
                            + this.getClass().getSimpleName() + "- method]");
            return parentOrganizationID;
        }

        //Add new Adress
        public void AddNewAdress() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start AddNewAdress -[" + this.getClass().getSimpleName()
                    + "- method]");

                this.getElementByXPath(ADDNEWADDRESS).click();
                if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
                	WebElement element = this.getElementByXPath(ADDNEWADDRESS);
                	if(element != null) {
                		WebDriverUtils.clickButtonSafari(driver,element);
                	}
                }
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
        
        public String getOrganizationStreetN(Integer n) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationStreet -[" + this.getClass().getSimpleName()
                    + "- method]");
            String xpath = STREET_N.replace("{n}", n.toString());
        	String organizationStreet = driver.findElementByXPath(xpath).getAttribute("value");
            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End getOrganizationStreet -["
                            + this.getClass().getSimpleName() + "- method]");
            return organizationStreet;
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
        
        public String getOrganizationPostalCodeN(Integer n) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationPostalCodeN -[" + this.getClass().getSimpleName()
                    + "- method]");
            String xpath = POSTALCODE_N.replace("{n}", n.toString());
            String postalCode = driver.findElementByXPath(xpath).getAttribute("value");
            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End getOrganizationPostalCodeN -["
                            + this.getClass().getSimpleName() + "- method]");
            return postalCode;
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
        
        public String getOrganizationPostalAreaN(Integer n) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationPostalAreaN -[" + this.getClass().getSimpleName()
                    + "- method]");
            String xpath = POSTALAREA_N.replace("{n}", n.toString());
            String postalArea = driver.findElementByXPath(xpath).getAttribute("value");
            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End getOrganizationPostalAreaN -["
                            + this.getClass().getSimpleName() + "- method]");
            return postalArea;
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
        
        public String getOrganizationAddressPhoneN(Integer n) {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start Phone -[" + this.getClass().getSimpleName()
                    + "- method]");
        	String xpath = PHONEADDRESS_N.replace("{n}", n.toString());
            String addressPhone = driver.findElementByXPath(xpath).getAttribute("value");
            log.info(
                    "[log-" + this.getClass().getSimpleName() + "]- End PostalArea -["
                            + this.getClass().getSimpleName() + "- method]");
            return addressPhone;
        }
        
     // Check Phone Field
        public boolean PhoneVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start PhoneVisible method");
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End PhoneVisible method");
            return this.isElementVisibleByXPath(PHONE);
        }  
        
        
        public Integer getOrganizationNumbersContact() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationContactN method");
            Integer n = this.getElementsByXPath(CONTACTSROWS).size();
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getOrganizationContactN method");
            return n;
        }
        
        public WebElement getOrganizationContactN(Integer n) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationContactN method");
            WebElement row = this.getElementsByXPath(CONTACTSROWS).get(n);
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getOrganizationContactN method");
            return row;
        }
        
        public String getContactNameRowN(Integer n) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getContactNameRowN method");
            WebElement row = getOrganizationContactN(n);
            String name = row.findElements(By.xpath(CONTACTSFIELD)).get(0).getText();
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getContactNameRowN method");
            return name;
        }
        
        public String getContactRoleRowN(Integer n) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getContactNameRowN method");
            WebElement row = getOrganizationContactN(n);
            String role = row.findElements(By.xpath(CONTACTSFIELD)).get(1).getText();
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getContactNameRowN method");
            return role;
        }
        
        public List<String> getContactEmailsRowN(Integer n) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getContactNameRowN method");
            WebElement row = getOrganizationContactN(n);
            String data = row.findElements(By.xpath(CONTACTSFIELD)).get(2).getText();
            List<String> mail = Arrays.asList(data.split("\n"));
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getContactNameRowN method");
            return mail;
        }
        
        public List<String> getContactPhoneRowN(Integer n) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getContactNameRowN method");
            WebElement row = getOrganizationContactN(n);
            String phones = row.findElements(By.xpath(CONTACTSFIELD)).get(3).getText();
            List<String> lphones= Arrays.asList(phones.split("\n"));
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getContactNameRowN method");
            return lphones;
        }
        //Save
        public void SaveButton() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start SaveButton -[" + this.getClass().getSimpleName()
                    + "- method]");

                this.getElementByXPath(SAVEBUTTON).click();
                if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
                	WebElement element = this.getElementByXPath(SAVEBUTTON);
                	if(element != null) {
                		WebDriverUtils.clickButtonSafari(driver,element);
                	}
                }
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
            if(!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")){
            	this.getElementByXPath(ORGANIZATIONVISIBLE).click();
            }else {
            	if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
                	WebElement element = this.getElementByXPath(ORGANIZATIONVISIBLE);
                	if(element != null) {
                		WebDriverUtils.clickButtonSafari(driver,element);
                	}
                }
            }    
       }
        
        //Delete Button
        public void DeleteButton() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start DeleteButton -[" + this.getClass().getSimpleName()
                    + "- method]");
            this.getElementsByXPath(DELETEBUTTON).get(0).click();
            if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
            	WebElement element = this.getElementsByXPath(DELETEBUTTON).get(0);
            	if(element != null) {
            		WebDriverUtils.clickButtonSafari(driver,element);
            	}
            }
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
        
        //Check if Delete Button is visible
        public boolean EditButtonVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start EditButtonVisisble method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End EditButtonVisisble method");

        return this.isElementVisibleByXPath(EDITBUTTON);
        }
        
        //Delete Button
        public void clickEditButton() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start DeleteButton -[" + this.getClass().getSimpleName()
                    + "- method]");
            if(EditButtonVisible()) {
            	this.getElementByXPath(EDITBUTTON).click();
            }
            if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
            	WebElement element = this.getElementByXPath(EDITBUTTON);
            	if(element != null) {
            		WebDriverUtils.clickButtonSafari(driver,element);
            	}
            }
            driver.sleep(2);
        }
        
        public boolean isProviderAffiliationVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isProviderAffiliationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isProviderAffiliationVisible method");

        return this.isElementVisibleByXPath(PROVIDERAFFILICATION);
        }
        
        
        public void clickProviderAffiliationButton() {
            log.info("[log-" + this.getClass().getSimpleName()
                    + "]- Start clickProviderAffiliationButton -[" + this.getClass().getSimpleName()
                    + "- method]");
            if(isProviderAffiliationVisible()) {
            	this.getElementByXPath(PROVIDERAFFILICATION).click();
            }
            if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
            	WebElement element = this.getElementByXPath(PROVIDERAFFILICATION);
            	if(element != null) {
            		WebDriverUtils.clickButtonSafari(driver,element);
            	}
            }
            driver.sleep(2);
        }
        
        public boolean isOrganizationNumberVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isOrganizationNumberVisible method");
        
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isOrganizationNumberVisible method");

        return this.isElementVisibleByXPath(ORGANIZATIONNUMBER);
        }
        
        public String getOrganizationNumber() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isOrganizationNumberVisible method");
        String organizationNumber = "";
        if(this.isOrganizationNumberVisible()) {
        	organizationNumber = this.getElementByXPath(ORGANIZATIONNUMBER).getAttribute("value");
        }else {
        	log.error("Field Organization Number is not visible");
        	throw new NoSuchElementException();
        }
        
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isOrganizationNumberVisible method");

        return organizationNumber;
        }
        
        public void setOrganizationNumber(String organizationNumber) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setOrganizationNumber method");
        if(this.isOrganizationNumberVisible()) {
        	this.getElementByXPath(ORGANIZATIONNUMBER).sendKeys(organizationNumber);
        }
        
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setOrganizationNumber method");
        }
       
        public boolean isOrganizationWorklogVisible() {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start isOrganizationWorklogVisible method");
            
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End isOrganizationWorklogVisible method");

            return this.isElementVisibleById(WORKLOG);
            }
            
            public String getOrganizationWorklogN(Integer n) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start getOrganizationWorklog method");
            String organizationNumber = "";
            if(this.isOrganizationWorklogVisible()) {
            	organizationNumber = this.getElementsByXPath(WORKLOG).get(n).getText();
            }else {
            	log.error("Field worklog is not visible");
            	throw new NoSuchElementException();
            }
            
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End getOrganizationWorklog method");

            return organizationNumber;
            }
            
            public Integer getNumberOfWorklogsSaved() {
                log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                        + "]- Start getNumberOfWorklogsSaved method");
                Integer n = 0;
                if(this.isOrganizationWorklogVisible()) {
                	n = this.getElementsByXPath(WORKLOG).size();
                }else {
                	log.error("Field worklog is not visible");
                	throw new NoSuchElementException();
                }
                
                log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                        + "]- End getNumberOfWorklogsSaved method");

                return n;
            }
            
            public void setOrganizationWorklog(String worklog) {
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- Start setOrganizationWorklog method");
            if(this.isOrganizationWorklogVisible()) {
            	this.getElementById(WORKLOG).sendKeys(worklog);
            }
            
            log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                    + "]- End setOrganizationWorklog method");
            }
            
            public boolean equals(String name, String description, String type, List<String> affiliation,
            		String organizationID, String parentOrganizationID, String website, String organizationNumber,
            		List<String> streets, List<String> postalcodes, List<String> postalareas, List<String> phones,
            		List<List<String>> contacts, List<String> worklog) {
            	boolean result = this.getOrganizationName().equals(name);
            	if(!result) {
            		return false;
            	}
            	result &= this.getOrganizationDescription().equals(description);
            	if(!result) {
            		return false;
            	}
            	result &= this.getOrganizationType().contentEquals(type);
            	if(!result) {
            		return false;
            	}
            	result &= this.getAffiliationChecked().containsAll(affiliation);
            	if(!result) {
            		return false;
            	}
            	result &= this.getOrganizationID().equals(organizationID);
            	if(!result) {
            		return false;
            	}
            	result &= this.getParentOrganizationID().equals(parentOrganizationID);
            	if(!result) {
            		return false;
            	}
            	result &= this.getOrganizationWebsite().equals(website);
            	if(!result) {
            		return false;
            	}
            	result &= this.getOrganizationNumber().equals(organizationNumber);
            	if(!result) {
            		return false;
            	}
            	boolean explore = true;
            	Integer n = 0;
            	Integer nStreets = streets.size();
            	while(explore) {
            		try {
            			String street = this.getOrganizationStreetN(n);
            			result &= streets.get(n).contentEquals(street);
            			if(!result) {
            				return false;
            			}
            			n++;
            		}catch(org.openqa.selenium.NoSuchElementException e) {
            			explore = false;
            		}
            	}
            	if(n!=nStreets) {
            		return false;
            	}
            	
            	explore = true;
            	n = 0;
            	Integer nPostalCodes = postalcodes.size();
            	while(explore) {
            		try {
            			String postalcode = this.getOrganizationPostalCodeN(n);
            			result &= postalcodes.get(n).contentEquals(postalcode);
            			if(!result) {
            				return false;
            			}
            			n++;
            		}catch(org.openqa.selenium.NoSuchElementException e) {
            			explore = false;
            		}
            	}
            	if(n!=nPostalCodes) {
            		return false;
            	}
            	
            	explore = true;
            	n = 0;
            	Integer nPostalAreas = postalareas.size();
            	while(explore) {
            		try {
            			String postalarea = this.getOrganizationPostalAreaN(n);
            			result &= postalareas.get(n).contentEquals(postalarea);
            			if(!result) {
            				return false;
            			}
            			n++;
            		}catch(org.openqa.selenium.NoSuchElementException e) {
            			explore = false;
            		}
            	}
            	if(n!=nPostalAreas) {
            		return false;
            	}
            	
            	explore = true;
            	n = 0;
            	Integer nPhones = phones.size();
            	while(explore) {
            		try {
            			String phone = this.getOrganizationAddressPhoneN(n);
            			result &= phones.get(n).contentEquals(phone);
            			if(!result) {
            				return false;
            			}
            			n++;
            		}catch(org.openqa.selenium.NoSuchElementException e) {
            			explore = false;
            		}
            	}
            	if(n!=nPhones) {
            		return false;
            	}
            	return result;
            }
   }   
