package com.emergya.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static final String  DELETEBUTTON = "clickDelete";
    private static final String  WORKLOGENTRY = "worklogEntry";
    private static final String  BUTTONSSAVE = "buttonsSave";
    private static String  MAIL_ADDRESS = "//input[@name='emails[{n}].email']";
    private static String  MAIL_TYPE = "//select[@name='emails[{n}].type']";
    private static String  PHONE_NUMBER = "//input[@name='phones[{n}].phone']";
    private static String  PHONE_TYPE = "//select[@name='phones[{n}].type']";
    private static String  ORGANIZATION_ROLE = "//select[@name='organizations[{n}].role']";
    private static String  ORGANIZATION_ID = "//input[@name='organizations[{n}].organization_id']";
    private static String  ORGANIZATION_NAME = "//select[@name='organizations[{n}].organization']";
    
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
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(BUTTONSADDNEW).get(0);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickAddNewMail method");
    }
    
    public void setEmail(String email) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start setEmail method");
    	if(isInputEmailVisible()) {
    		WebElement element = this.getElementByXPath(INPUTEMAIL);
    		element.sendKeys(email);
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
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(BUTTONSADDNEW).get(1);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
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
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(ADDPROFESSIONALDETAILS);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickAddNewProfessionalDetails method");
    }
    
    public void clickAddNewProfessionalDetailsModal() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickAddNewProfessionalDetails method");
    	this.getElementsByXPath(ADDPROFESSIONALDETAILS).get(1).click();
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(ADDPROFESSIONALDETAILS).get(1);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
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
    		this.getElementsByXPath(SAVEBUTTON).get(0).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(SAVEBUTTON).get(0);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickSave method");
    }
    
    public void clickSaveModal() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickSave method");
    	this.getElementsByXPath(SAVEBUTTON).get(2).click();
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(SAVEBUTTON).get(2);
        	if(element != null) {
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
    		this.getElementsByXPath(EDITBUTTON).get(0).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(EDITBUTTON).get(0);
        	if(element != null) {
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
        	WebElement element = this.getElementByXPath(SENDBUTTON);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End clickSend method");
    }
    
    public void clickDelete() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start clickDelete method");
    	driver.sleep(2);
    	if(isButtonSendVisible()) {
    		this.getElementsByXPath(DELETEBUTTON).get(0).click();
    	}
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementsByXPath(DELETEBUTTON).get(0);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
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
    
    public String getName() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getName method");
    	String name = this.getElementByXPath(NEWCONTACT).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getName method");
        return name;
    }
    
    public String getLastName() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getLastName method");
    	String lastName = this.getElementByXPath(LASTNAMEINPUT).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getLastName method");
        return lastName;
    }
    
    public String getNotes() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getNotes method");
    	String notes = this.getElementByXPath(ADDNOTESTEXT).getText();
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getNotes method");
        return notes;
    }
    
    public String getTypeTitle() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getTypeTitle method");
    	String typeTitle = this.getElementByXPath(TYPETITLE).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getTypeTitle method");
        return typeTitle;
    }
    
    public String getType() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getType method");
    	String type = WebDriverUtils.getSelectCurrentItem(this, SELECTTYPE);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getType method");
        return type;
    }
    
    public String getMailAddressN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getType method");
        String xpath = MAIL_ADDRESS.replace("{n}", n.toString());
        String mailAddress = driver.findElementByXPath(xpath).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getType method");
        return mailAddress;
    }
    
    public String getMailTypeN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getMailTypeN method");
        String xpath = MAIL_TYPE.replace("{n}", n.toString());
        WebElement element_mail_type = driver.findElementByXPath(xpath);
        Select select_mail_type = new Select(element_mail_type);
        String mail_type = select_mail_type.getFirstSelectedOption().getText();
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getMailTypeN method");
        return mail_type;
    }
    
    public List<String> getMailN(Integer n){
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getMailN method");
    	String email_address = this.getMailAddressN(n);
    	String email_type = this.getMailTypeN(n);
    	List<String> mail = Arrays.asList(email_address, email_type);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getMailN method");
        return mail;	
    }
    
    public void setMailAddressN(Integer n, String emailAddress) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setMailAddressN method");
        String xpath = MAIL_ADDRESS.replace("{n}", n.toString());
        driver.findElementByXPath(xpath).sendKeys(emailAddress);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setMailAddressN method");
        }
    
    public void setMailTypeN(Integer n, String emailType) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setMailTypeN method");
        String xpath = MAIL_TYPE.replace("{n}", n.toString());
        WebElement element_mail_type = driver.findElementByXPath(xpath);
        Select select_mail_type = new Select(element_mail_type);
        select_mail_type.selectByVisibleText(emailType);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setMailTypeN method");
    }
    
    public String getPhoneNumberN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getPhoneNumberN method");
        String xpath = PHONE_NUMBER.replace("{n}", n.toString());
        String phoneNumber = driver.findElementByXPath(xpath).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getPhoneNumberN method");
        return phoneNumber;
    }
    
    public void setPhoneTypeN(Integer n, String type) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setPhoneTypeN method");
        String xpath = PHONE_TYPE.replace("{n}", n.toString());
        WebElement element_phone_type = driver.findElementByXPath(xpath);
        Select select_phone_type = new Select(element_phone_type);
        select_phone_type.selectByVisibleText(type);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setPhoneTypeN method");
    }
    
    public void setPhoneNumberN(Integer n, String phone) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setPhoneNumberN method");
        String xpath = PHONE_NUMBER.replace("{n}", n.toString());
        driver.findElementByXPath(xpath).sendKeys(phone);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setPhoneNumberN method");
    }
    
    public String getPhoneTypeN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getPhoneTypeN method");
        String xpath = PHONE_TYPE.replace("{n}", n.toString());
        WebElement element_phone_type = driver.findElementByXPath(xpath);
        Select select_phone_type = new Select(element_phone_type);
        String phone_type = select_phone_type.getFirstSelectedOption().getText();
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getPhoneTypeN method");
        return phone_type;
    }
    
    public List<String> getPhoneN(Integer n){
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getPhoneN method");
    	String phone_number = this.getPhoneNumberN(n);
    	String phone_type = this.getPhoneTypeN(n);
    	List<String> phone = Arrays.asList(phone_number, phone_type);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getPhoneN method");
        return phone;	
    }
    
    public String getFingerprint() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getFingerprint method");
        String fingerprint = this.getElementByXPath(PGPFINGERPRINT).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getFingerprint method");
        return fingerprint;
    }
    
    public String getOrganizationRoleN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getOrganizationRoleN method");
        String xpath = ORGANIZATION_ROLE.replace("{n}", n.toString());
        WebElement element_organization_role = driver.findElementByXPath(xpath);
        Select select_organization_role = new Select(element_organization_role);
        String organization_role = select_organization_role.getFirstSelectedOption().getText();
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getOrganizationRoleN method");
        return organization_role;
    }
    
    public String getOrganizationIdN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getOrganizationIdN method");
        String xpath = ORGANIZATION_ID.replace("{n}", n.toString());
        String organizationID = driver.findElementByXPath(xpath).getAttribute("value");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getOrganizationIdN method");
        return organizationID;
    }
    
    public String getOrganizationNameN(Integer n) {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getPhoneTypeN method");
        String xpath = ORGANIZATION_NAME.replace("{n}", n.toString());
        WebElement element_organization_name = driver.findElementByXPath(xpath);
        Select select_organization_name = new Select(element_organization_name);
        String organization_name = select_organization_name.getFirstSelectedOption().getText();
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getPhoneTypeN method");
        return organization_name;
    }
    
    public List<String> getOrganizationsN(Integer n){
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getPhoneN method");
    	String organization_role = this.getOrganizationRoleN(n);
    	String organization_id = this.getOrganizationIdN(n);
    	String organization_name = this.getOrganizationNameN(n);
    	List<String> organization = Arrays.asList(organization_role, organization_id, organization_name);
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getPhoneN method");
        return organization;	
    }
    
    public List<String> getWorklogs(){
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getWorklogs method");
    	List<WebElement> worklogs = this.getElementsByXPath(WORKLOGENTRY);
    	List<String> logs = new ArrayList<String>();
    	for(WebElement worklog: worklogs){
    		logs.add(worklog.getText());
    	}
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getWorklogs method");
        return logs;
    }
    
    public boolean equals(String name, String lastName, String notes, String typeTitle, String type,
    		List<List<String>> mails, List<List<String>> phones, String fingerprint,
    		List<List<String>> organizations, List<String> worklogs) {
    	driver.sleep(4);
    	boolean result = this.getName().equals(name);
    	if(!result) {
    		return false;
    	}
    	result &= this.getLastName().equals(lastName);
    	if(!result) {
    		return false;
    	}
    	result &= this.getNotes().equals(notes);
    	if(!result) {
    		return false;
    	}
    	result &= this.getTypeTitle().equals(typeTitle);
    	if(!result) {
    		return false;
    	}
    	result &= this.getType().equals(type);
    	if(!result) {
    		return false;
    	}
    	Integer n = 0;
    	Integer n_mails = mails.size();
    	while(true) {
        	try {
        		List<String> v_mail = mails.get(n);
        		List<String> j_mail = this.getMailN(n);
        		result &= v_mail.get(0).equals(j_mail.get(0));
        		if(!result) {
        			return false;
        		}
        		result &= v_mail.get(1).equals(j_mail.get(1));
        		if(!result) {
        			return false;
        		}
        		n++;
        	}catch(Exception e) {
        		break;
        	}
    	}
    	if(n!=n_mails) {
    		return false;
    	}
    	n = 0;
    	Integer n_phones = phones.size();
    	while(true) {
        	try {
        		List<String> v_phones = phones.get(n);
        		List<String> j_phones = this.getPhoneN(n);

        		result &= v_phones.get(0).equals(j_phones.get(0));
        		if(!result) {
        			return false;
        		}
        		result &= v_phones.get(1).equals(j_phones.get(1));
        		if(!result) {
        			return false;
        		}
        		n++;
        	}catch(Exception e) {
        		break;
        	}
    	}
    	if(n!=n_phones) {
    		return false;
    	}
    	
    	result &= this.getFingerprint().equals(fingerprint);
    	if(!result) {
    		return false;
    	}
    	n = 0;
    	Integer n_organizations = organizations.size();
    	while(true) {
        	try {
        		List<String> v_organizations = organizations.get(n);
        		List<String> j_organizations = this.getOrganizationsN(n);
        		result &= v_organizations.get(0).equals(j_organizations.get(0));
        		if(!result) {
        			return false;
        		}
        		result &= v_organizations.get(1).equals(j_organizations.get(1));
        		if(!result) {
        			return false;
        		}
        		result &= v_organizations.get(2).equals(j_organizations.get(2));
        		if(!result) {
        			return false;
        		}
        		n++;
        	}catch(Exception e) {
        		break;
        	}
    	}
    	if(n!=n_organizations) {
    		return false;
    	}
    	if(worklogs.size() != this.getWorklogs().size()) {
    		return false;
    	}
    	for(int i=0;i<worklogs.size();i++) {
    		result &= worklogs.get(i) != this.getWorklogs().get(i);
    		if(!result) {
    			return false;
    		}
    	}
    	return result;
    }
    
 }