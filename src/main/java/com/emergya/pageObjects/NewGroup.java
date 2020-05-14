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
    private static final String  CONTACTROW = "contactRow";
    private static final String  CONTACTROW2 = "contactRow2";
    private static final String  DELETEBUTTON = "clickDelete";
    private static final String  WORKLOGCOMMENT = "worklogComment";
    private static String  CONTACTROWDIV = "div";
    
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
    
    public String getName() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getName method");
    	String name = "";
    	if(this.isElementVisibleByXPath(NEWGROUP)) {
    		name = this.getElementByXPath(NEWGROUP).getAttribute("value");
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getName method");
    	return name;
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
    
    public String getDescription() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getDescription method");
    	String description = "";
    	if(isDescriptionTexstAreaVisible()) {
    		description = this.getElementByXPath(DESCRIPTIONTEXTAREA).getAttribute("value");
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getDescription method");
    	return description;
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
    
    public WebElement getContactRowN(Integer n) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getContactRow method");
    	WebElement contactRow = null;
    	if(this.isElementVisibleByXPath(CONTACTROW)) {
    		contactRow = this.getElementsByXPath(CONTACTROW).get(n);
    	}
    	
    	if(this.isElementVisibleByXPath(CONTACTROW2)) {
    		contactRow = this.getElementsByXPath(CONTACTROW2).get(n);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getContactRow method");
    	return contactRow;
    }
    
    public String getContactNameN(Integer n) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getContactRow method");
    	WebElement contactRow = this.getContactRowN(n);
    	WebElement col = contactRow.findElements(By.xpath(CONTACTROWDIV)).get(0);
    	String name = col.getText();
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getContactRow method");
    	return name;
    }
    
    public String getContactOrganizationN(Integer n) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getContactOrganizationN method");
    	WebElement contactRow = this.getContactRowN(n);
    	WebElement col = contactRow.findElements(By.xpath(CONTACTROWDIV)).get(1);
    	String organization = col.getText();
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getContactOrganizationN method");
    	return organization;
    }
    
    public String getContactWorklogN(Integer n) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getContactWorklogN method");
    	String worklogComment = "";
    	if(this.isElementVisibleByXPath(WORKLOGCOMMENT)) {
    		worklogComment = this.getElementsByXPath(WORKLOGCOMMENT).get(n).getText();
    		
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getContactWorklogN method");
    	return worklogComment;
    }
    
    public List<List<String>> getContactEmailsN(Integer n) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getContactEmailsN method");
    	WebElement contactRow = this.getContactRowN(n);
    	WebElement col = contactRow.findElements(By.xpath(CONTACTROWDIV)).get(2);
    	List<String> mails = Arrays.asList(col.getText().split("\n"));
    	List<List<String>> mails_list = new ArrayList<List<String>>();
    	for(int i=0;i<mails.size()/2;i++) {
    		List<String> mail = Arrays.asList(mails.get(i*2),mails.get((i*2)+1));
    		mails_list.add(mail);
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getContactEmailsN method");
    	return mails_list;
    }
    
    public List<String> getContactPhoneN(Integer n) {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start getContactPhoneN method");
    	WebElement contactRow = this.getContactRowN(n);
    	WebElement col = contactRow.findElements(By.xpath(CONTACTROWDIV)).get(3);
    	List<String> phones = Arrays.asList(col.getText().split("\n"));
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End getContactPhoneN method");
    	return phones;
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
    
    public boolean equals(String name, String description, List<List<Object>> contacts, List<String> worklogs) {
    	boolean result = this.getName().equals(name);
    	if(!result) {
    		return false;
    	}
    	result &= this.getDescription().equals(description);
    	if(!result) {
    		return false;
    	}
    	Integer n = 0;
    	while(true) {
    		try {
        		List<Object> contact = contacts.get(n);
        		result &= this.getContactNameN(n).equals(contact.get(0));
        		if(!result) {
        			return false;
        		}
        		result &= this.getContactOrganizationN(n).equals(contact.get(1));
        		if(!result) {
        			return false;
        		}
        		List<List<String>> j_mails = (List<List<String>>) contact.get(2);
        		List<List<String>> v_mails = this.getContactEmailsN(n);
        		result &= j_mails.size() == v_mails.size();
        		if(!result) {
        			return false;
        		}
        		for(int i = 0;i<j_mails.size();i++) {
        			List<String> j_mail = j_mails.get(i);
        			List<String> v_mail = v_mails.get(i);
        			result &= j_mail.get(0).equals(v_mail.get(0));
        			if(!result) {
        				return false;
        			}
        			result &= j_mail.get(1).equals(v_mail.get(1));
        			if(!result) {
        				return false;
        			}
        		}
        		List<String> j_phones = (List<String>) contact.get(3);
        		List<String> v_phones = this.getContactPhoneN(n);
        		result &= j_phones.size() == v_phones.size();
        		if(!result) {
        			return false;
        		}
        		for(int i=0;i<j_phones.size();i++) {
        			String j_p = j_phones.get(i);
        			String v_p = v_phones.get(i);
        			result &= j_phones.get(i).equals(v_phones.get(i));
        			if(!result) {
        				return false;
        			}
        		}
    			n++;
    		}catch(Exception e) {
    			break;
    		}
    	}
		result &= n.equals(contacts.size());
		if(!result) {
			return false;
		}
		n = 0;
    	while(true) {
    		try {
				result &= this.getContactWorklogN(n).equals(worklogs.get(n));
				if(!result) {
					return false;
				}
				n++;
			}catch(Exception e) {
				break;
			}
		}
		result &= n.equals(worklogs.size());
		if(!result) {
			return false;
		}
    	return result;
    }
 }