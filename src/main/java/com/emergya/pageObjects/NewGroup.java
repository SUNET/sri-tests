package com.emergya.pageObjects;

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
public class NewGroup extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(NewGroup.class);

    /**
     * Items keys selectors.
     */
    
    private static final String NEWGROUP = "newGroup";
    private static final String  DESCRIPTIONTEXTAREA = "descriptionTextArea";
    private static final String  ADDNEWCONTACT = "buttonAddNew";
    private static final String  INPUTSEARCHCONTACT = "inputSearchContact";
    private static final String  ADDCOMMENT = "addComment";
    private static final String  SAVEBUTTON = "saveButton";
    private static final String  EDITBUTTON = "editGroup";
    private static final String  SENDBUTTON = "clickSend";
    private static final String  DELETEBUTTON = "clickDelete";

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public NewGroup(EmergyaWebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");

        boolean status = this.isElementVisibleByXPath(NEWGROUP);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }
    
    public void setName(String name) {
    	 log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                 + " - Start setName method");
    	this.getElementByXPath(NEWGROUP).sendKeys(name);
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End setName method");
    }
    
    public void setDescription(String description) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setDescription method");
    	if(isDescriptionTexstAreaVisible()) {
    		this.getElementByXPath(DESCRIPTIONTEXTAREA).sendKeys(description);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setDescription method");
    }
    
    public void setSearchForContact(String contact) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setDescription method");
    	if(isInputSearchContactVisible()) {
    		driver.sleep(3);
    		this.getElementByXPath(INPUTSEARCHCONTACT).sendKeys(contact);
    		driver.sleep(3);
    		this.getElementByXPath(INPUTSEARCHCONTACT).sendKeys(Keys.ARROW_DOWN);
    		driver.sleep(3);
    		this.getElementByXPath(INPUTSEARCHCONTACT).sendKeys(Keys.ENTER);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setDescription method");
    }
    
    public NewContact clickAddNewContact() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickAddNewContact method");
    	if(isButtonAddNewVisible()) {
    		this.getElementByXPath(ADDNEWCONTACT).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element =  this.getElementByXPath(ADDNEWCONTACT);
        	if(element!=null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickAddNewContact method");
    	return new NewContact(driver);
    }
    
    public void clickSave() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickSave method");
    	if(isButtonSaveVisible()) {
    		this.getElementsByXPath(SAVEBUTTON).get(0).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element =  this.getElementsByXPath(SAVEBUTTON).get(0);
        	if(element!=null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickSave method");
    }
    
    public void clickEdit() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickEdit method");
    	if(isButtonEditVisible()) {
    		this.getElementByXPath(EDITBUTTON).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element =  this.getElementByXPath(EDITBUTTON);
        	if(element!=null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickEdit method");
    }
    
    public void clickSend() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickSend method");
    	if(isButtonSendVisible()) {
    		this.getElementByXPath(SENDBUTTON).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element =  this.getElementByXPath(SENDBUTTON);
        	if(element!=null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickSend method");
    }
    
    public void clickDelete() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickDelete method");
    	if(isButtonSendVisible()) {
    		this.getElementByXPath(DELETEBUTTON).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element =  this.getElementByXPath(DELETEBUTTON);
        	if(element!=null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickDelete method");
    }
    
    
    public boolean isDescriptionTexstAreaVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isDescriptionTexstAreaVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isDescriptionTexstAreaVisible method");
        return this.isVisible(this.getElementsByXPath(SAVEBUTTON).get(0));
    }
    
    public boolean isCommentAreaVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectOrganizationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectOrganizationVisible method");
        return this.isElementVisibleByXPath(ADDCOMMENT) || this.isElementVisibleById(ADDCOMMENT);
    }
    
    public void setComment(String comment) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setComment method");
    	if(isCommentAreaVisible()) {
    		try {
    			this.getElementByXPath(ADDCOMMENT).sendKeys(comment);
    		}catch(Exception e) {
    			this.getElementById(ADDCOMMENT).sendKeys(comment);
    		}
    		
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setComment method");
    }
    
    public boolean isButtonAddNewVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isDescriptionTexstAreaVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isDescriptionTexstAreaVisible method");
        return this.isElementVisibleByXPath(ADDNEWCONTACT);
    }
    
    public boolean isInputSearchContactVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isInputSearchContactVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isInputSearchContactVisible method");
        return this.isElementVisibleByXPath(INPUTSEARCHCONTACT);
    }
    
    //Check if Delete Button is visible
    public boolean isButtonSaveVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectOrganizationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectOrganizationVisible method");
        return this.isVisible(this.getElementsByXPath(SAVEBUTTON).get(0));
    }
    
    public boolean isButtonEditVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isButtonEditVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isButtonEditVisible method");
        return this.isElementVisibleByXPath(EDITBUTTON);
    }
    
    public boolean isButtonSendVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isButtonSendVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isButtonSendVisible method");
        return this.isElementVisibleByXPath(SENDBUTTON);
    }
    
    public boolean isButtonDeteleVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isButtonDeteleVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isButtonDeteleVisible method");
        return this.isElementVisibleByXPath(DELETEBUTTON);
    }
 }