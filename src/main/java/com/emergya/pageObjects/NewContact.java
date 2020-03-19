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
    
    private static final String NEWCONTACT = "newContact";
    private static final String  LASTNAMEINPUT = "lastName";
    private static final String  ADDNOTESTEXT = "addNotes";
    private static final String  TYPETITLE = "typeTitle";
    private static final String  SELECTTYPE = "selectType";
    private static final String  BUTTONSADDNEW = "buttonsAddNew";
    private static final String  INPUTEMAIL = "inputEmail";
    private static final String  EMAILTYPE = "emailType";
    private static final String  PHONE = "phone";
    private static final String  PHONETYPE = "phoneType";
    private static final String  PGPFINGERPRINT = "PGPFingerprint";
    private static final String  ADDPROFESSIONALDETAILS = "addProfessionalDetails";
    private static final String  SELECTROLE = "selectRole";
    private static final String  SELECTORGANIZATION = "selectOrganization";
    private static final String  ADDCOMMENT = "addComment";
    private static final String  SAVEBUTTON = "saveButton";
    private static final String  EDITBUTTON = "editContant";
    private static final String  SENDBUTTON = "clickSend";
    private static final String  DELETEBUTTON = "clickSend";

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

        boolean status = this.isElementVisibleByXPath(NEWCONTACT);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }
    
    public void setName(String name) {
    	 log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                 + " - Start setName method");
    	this.getElementByXPath(NEWCONTACT).sendKeys(name);
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End setName method");
    }
    
    
    
    public void setLastName(String lastName) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isLastNameVisible()) {
    		this.getElementByXPath(LASTNAMEINPUT).sendKeys(lastName);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
    
    public void setAddNotes(String notes) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setName method");
    	if(isLastNameVisible()) {
    		this.getElementByXPath(ADDNOTESTEXT).sendKeys(notes);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setName method");
    }
    
    public void setTypeTitle(String typeTitle) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setTypeTitle method");
    	if(isLastNameVisible()) {
    		this.getElementByXPath(TYPETITLE).sendKeys(typeTitle);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setTypeTitle method");
    }
    
    public void setSelectType(String type) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setSelectType method");
    	if(isSelectTypeVisible()) {
    		Select select = new Select(this.getElementByXPath(SELECTTYPE));
    		select.selectByVisibleText(type);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setSelectType method");
    }
    
    public void clickAddNewMail() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickAddNewMail method");
    	if(isSelectTypeVisible()) {
    		this.getElementsByXPath(BUTTONSADDNEW).get(0).click();
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickAddNewMail method");
    }
    
    public void setEmail(String email) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setEmail method");
    	if(isInputEmailVisible()) {
    		this.getElementByXPath(INPUTEMAIL).sendKeys(email);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setEmail method");
    }
    
    public void setEmailType(String type) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setSelectType method");
    	if(isEmailTypeSelectVisible()) {
    		Select select = new Select(this.getElementByXPath(EMAILTYPE));
    		select.selectByVisibleText(type);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setSelectType method");
    }
    
    public void clickAddNewPhone() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickAddNewPhone method");
    	if(isAddNewPhoneVisible()) {
    		this.getElementsByXPath(BUTTONSADDNEW).get(1).click();
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickAddNewPhone method");
    }
    
    public void setPhone(String phone) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setPhone method");
    	if(isInputPhoneVisible()) {
    		this.getElementByXPath(PHONE).sendKeys(phone);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setPhone method");
    }
    
    public void setPhoneType(String type) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setPhoneType method");
    	if(isEmailTypeSelectVisible()) {
    		Select select = new Select(this.getElementByXPath(PHONETYPE));
    		select.selectByVisibleText(type);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setPhoneType method");
    }
    
    public void setPGPFingerPrint(String pgpfingerprint) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setPGPFingerPrint method");
    	if(isInputPhoneVisible()) {
    		this.getElementByXPath(PGPFINGERPRINT).sendKeys(pgpfingerprint);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setPGPFingerPrint method");
    }
    
    public void clickAddNewProfessionalDetails() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickAddNewProfessionalDetails method");
    	if(isAddNewProfessionalDetailsVisible()) {
    		this.getElementByXPath(ADDPROFESSIONALDETAILS).click();;
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickAddNewProfessionalDetails method");
    }
    
    public void setRole(String role) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setRole method");
    	if(isEmailTypeSelectVisible()) {
    		Select select = new Select(this.getElementByXPath(SELECTROLE));
    		select.selectByVisibleText(role);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setRole method");
    }
    
    public void setOrganization(String organization) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setRole method");
    	if(isEmailTypeSelectVisible()) {
    		Select select = new Select(this.getElementByXPath(SELECTORGANIZATION));
    		select.selectByVisibleText(organization);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setRole method");
    }
    
    public void setComment(String comment) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setComment method");
    	if(isCommentAreaVisible()) {
    		this.getElementByXPath(ADDCOMMENT).sendKeys(comment);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End setComment method");
    }
    
    public void clickSave() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickSave method");
    	if(isButtonSaveVisible()) {
    		this.getElementByXPath(SAVEBUTTON).click();
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
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickEdit method");
    }
    
    public void clickSend() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickSend method");
    	if(isButtonSendVisible()) {
    		this.getElementByXPath(SENDBUTTON).click();
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
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickDelete method");
    }
    
    //Check if Delete Button is visible
    public boolean isLastNameVisible() {
    log.info("[log-pageObjects]" + this.getClass().getSimpleName()
            + "]- Start DeleteButtonVisible method");
    log.info("[log-pageObjects]" + this.getClass().getSimpleName()
            + "]- End DeleteButtonVisible method");

    return this.isElementVisibleByXPath(LASTNAMEINPUT);
}  
    public boolean isAddNotesVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddNotesVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddNotesVisible method");

        return this.isElementVisibleByXPath(ADDNOTESTEXT);
    }  
       
    public boolean isTypeTitleVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isTypeTitleVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isTypeTitleVisible method");

        return this.isElementVisibleByXPath(TYPETITLE);
    }
   
    public boolean isSelectTypeVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectTypeVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectTypeVisible method");

        return this.isElementVisibleByXPath(SELECTTYPE);
    } 
    
    public boolean isAddNewMailVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddNewMailVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddNewMailVisible method");
        return this.isVisible(this.getElementsByXPath(BUTTONSADDNEW).get(0));
    }
    
    public boolean isInputEmailVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isInputEmailVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isInputEmailVisible method");
        return this.isElementVisibleByXPath(INPUTEMAIL);
    }
    
    public boolean isEmailTypeSelectVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isEmailTypeSelectVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isEmailTypeSelectVisible method");
        return this.isElementVisibleByXPath(EMAILTYPE);
    }
    
    public boolean isAddNewPhoneVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddNewPhoneVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddNewPhoneVisible method");
        return this.isVisible(this.getElementsByXPath(BUTTONSADDNEW).get(1));
    }
    
    public boolean isInputPhoneVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isInputPhoneVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isInputPhoneVisible method");
        return this.isElementVisibleByXPath(PHONE);
    }
    
    public boolean isPhoneTypeVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isPhoneTypeVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isPhoneTypeVisible method");
        return this.isElementVisibleByXPath(PHONETYPE);
    }
    public boolean isPGPFingerPrintVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isPGPFingerPrintVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isPGPFingerPrintVisible method");
        return this.isElementVisibleByXPath(PGPFINGERPRINT);
    }
    public boolean isAddNewProfessionalDetailsVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddNewProfessionalDetailsVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddNewProfessionalDetailsVisible method");
        return this.isElementVisibleByXPath(ADDPROFESSIONALDETAILS);
    }
    
    public boolean isSelectRoleVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectRoleVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectRoleVisible method");
        return this.isElementVisibleByXPath(SELECTROLE);
    }
    
    public boolean isSelectOrganizationVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectOrganizationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectOrganizationVisible method");
        return this.isElementVisibleByXPath(SELECTORGANIZATION);
    }
    
    public boolean isCommentAreaVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectOrganizationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectOrganizationVisible method");
        return this.isElementVisibleByXPath(ADDCOMMENT);
    }
    
    public boolean isButtonSaveVisible() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSelectOrganizationVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSelectOrganizationVisible method");
        return this.isVisible(this.getElementsByXPath(SAVEBUTTON).get(1));
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