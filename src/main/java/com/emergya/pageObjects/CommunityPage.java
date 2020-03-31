package com.emergya.pageObjects;

import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.jaxen.NamedAccessNavigator;

import com.emergya.selenium.pageObject.*;

import org.openqa.selenium.By;
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
    private static final String CONTACTMENUITEM = "contactMenuItem";
    private static final String GROUPSMENUITEM = "contactGroupsItem";
    private static final String ADDCONTACTBUTTON = "AddContactButton";
    private static final String CLICKCONTACT = "clickContact";
    private static final String ADDGROUPBUTTON = "AddGroupButton";
    private static final String  CLICKGROUP = "clickGroup";
    private static final String  FROMFILTER = "fromInput";
    private static final String  TOFILTER = "toInput";
    private static final String  ELEMENTINTABLE = "elementsTable";
    private static final String  LOADMOREBUTTON = "loadMoreButton";
    private static final String  ELEMENTDATES = "elementDates";
    private static final String  FILTERWORD = "filterWord";
    private static final String  LOADALLBUTTON = "loadAllButton";
    private static final String  HEADERNAME = "headerName";
    private static final String  NAMEINTABLE = "columnNameInTable";
    private static final String  RADIOUPDATED   = "radioUpdated";
    
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
        
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(LOGINBUTTON);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver, this.getElementByXPath(LOGINBUTTON));
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
        
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element =  this.getElementByXPath(ADDORGANIZATIONBUTTON);
        	if(element!=null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
        
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");
        return new NewOrganization(driver);
        
        
    }
    
    public void clickContactItem() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickContactItem method");

        if ((isContactVisible())) {
            this.getElementByXPath(CONTACTMENUITEM).click();
        }
        
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(CONTACTMENUITEM);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
        
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");   
    }
    
    public void clickGroupItem() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickGroupItem method");

        if (isGroupItemVisible()) {
            this.getElementByXPath(GROUPSMENUITEM).click();
        }
        
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(GROUPSMENUITEM);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickGroupItem method");   
    }
    
    public NewContact clickAddNewContact() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickAddOrganization method");

        if ((isAddContactButtonVisible())) {
            this.getElementByXPath(ADDCONTACTBUTTON).click();
        }
        
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(ADDCONTACTBUTTON);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
        
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnLogin method");
        return new NewContact(driver);
    }
    
    public NewGroup clickGroup() {
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isGroupItemVisible method");
    	if(!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
       	 if (isGroupVisible()) {
    		 this.getElementByXPath(CLICKGROUP).click();
    	 }
    	}else {
    		if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
           	 WebElement element = this.getElementByXPath(CLICKGROUP);
           	 if(element != null) {
           		 WebDriverUtils.clickButtonSafari(driver, this.getElementByXPath(CLICKGROUP)); 
           	 }
            }
    	}
    	log.info("[log-PageObjects] " + this.getClass().getSimpleName()
               + " - End isGroupItemVisible method");
    	return new NewGroup(driver);
    }
    
    public NewGroup clickAddNewGroup() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickAddNewGroup method");

        if (isAddNewGroupVisible()) {
            this.getElementByXPath(ADDGROUPBUTTON).click();
        }
        if(WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
        	WebElement element = this.getElementByXPath(ADDGROUPBUTTON);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickAddNewGroup method");
        return new NewGroup(driver);
    }
    
    public NewContact clickOnContact() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnContact method");
        if(!WebDriverUtils.getBrowserName(driver).toLowerCase().equals("safari")) {
            if(isANewContactVisible()) {
            	this.getElementByXPath(CLICKCONTACT).click();
            }
        }else {
        	WebElement element = this.getElementByXPath(CLICKCONTACT);
        	if(element != null) {
        		WebDriverUtils.clickButtonSafari(driver,element);
        	}
        }
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnContact method");
        return new NewContact(driver);
    	
    }
    
    public void setFromDate(String date) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setFromDate method");
    	if(isFilterFromDateVisible()) {
    		this.getElementByXPath(FROMFILTER).sendKeys(date);
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setFromDate method");
    	
    }
    
    public void setToDate(String date) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setToDate method");
    	if(isFilterFromDateVisible()) {
    		this.getElementByXPath(TOFILTER).sendKeys(date);
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setToDate method");
    	
    }
    
    public void clickElementNinTable(Integer n) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getElementNinTable method");
    	WebDriverUtils.click(driver, this.getElementsByXPath(ELEMENTINTABLE).get(n));
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getElementNinTable method");
    }
    
    public String getNnameInTable(Integer n) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getNnameInTable method");
    	String name = this.getElementsByXPath(NAMEINTABLE).get(n).getText();
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getNnameInTable method");
    	return name;
    }
    
    public Integer getNumberElementsInTable() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getNumberElementsInTable method");
    	Integer n = this.getElementsByXPath(ELEMENTINTABLE).size();
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getNumberElementsInTable method");
    	return n;
    }
    
    public void clickLoadMore() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickLoadMore method");
    	if(isLoadButtonVisible()) {
    		this.getElementByXPath(LOADMOREBUTTON).click();
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickLoadMore method");	
    }
    
    public void clickLoadAll() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickLoadMore method");
    	if(isLoadAllVisible()) {
    		this.getElementByXPath(LOADALLBUTTON).click();
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickLoadMore method");	
    }
    
    public String getCreationDate() {
    	String res = "";
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickLoadMore method");
    	if(isCreationDateVisible()) {
    		res = this.getElementsByXPath(ELEMENTDATES).get(0).getText();
    		res = res.replace("Created: ", "");
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickLoadMore method");
    	return res;
    }
    
    
    public String getUpdateDate() {
    	String res = "";
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickLoadMore method");
    	if(isCreationDateVisible()) {
    		res = this.getElementsByXPath(ELEMENTDATES).get(1).getText();
    		res = res.replace("Last update: ", "");
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickLoadMore method");
    	return res;
    }
    
    public void setWordFilter(String word) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setToDate method");
    	if(isInputWordFilterVisible()) {
    		this.getElementByXPath(FILTERWORD).sendKeys(word);
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setToDate method");
    }
    
    public void clickOnHeaderName() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setToDate method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.moveAndClick(driver, this.getElementsByXPath(HEADERNAME).get(1));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setToDate method");
    }
    
    public void clickOnHeaderName2() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start setToDate method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.moveAndClick2(driver, this.getElementsByXPath(HEADERNAME).get(0));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End setToDate method");
    }
    
    public void clickOnButtonUpdated() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnButtonUpdated method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(RADIOUPDATED));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnButtonUpdated method");
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
    
    public boolean isContactVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isContactVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isContactVisible method");

         return this.isElementVisibleByXPath(CONTACTMENUITEM);
    }
    
    public boolean isAddNewGroupVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isGroupVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isGroupVisible method");

           return this.isElementVisibleByXPath(ADDGROUPBUTTON);
      }
    
    public boolean isGroupVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isGroupVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isGroupVisible method");

        return this.isElementVisibleByXPath(CLICKGROUP);
   }
   
    public boolean isGroupItemVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isGroupItemVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isGroupItemVisible method");

           return this.isElementVisibleByXPath(GROUPSMENUITEM);
      }
    
    public boolean isAddContactButtonVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isContactVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isContactVisible method");

        return this.isElementVisibleByXPath(ADDCONTACTBUTTON);
   }
    
    public boolean isANewContactVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isContactVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isContactVisible method");

           return this.isElementVisibleByXPath(CLICKCONTACT);
      }
    
    public boolean isFilterFromDateVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isFilterFromDateVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isFilterFromDateVisible method");

          return this.isElementVisibleByXPath(FROMFILTER);
     }
    
    public boolean isFilterToDateVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isFilterToDateVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isFilterToDateVisible method");

         return this.isElementVisibleByXPath(TOFILTER);
    } 
    
    public boolean isLoadButtonVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isFilterToDateVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isFilterToDateVisible method");

        return this.isElementVisibleByXPath(LOADMOREBUTTON);
   }
    
    public boolean isLoadAllVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isLoadAllVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isLoadAllVisible method");

           return this.isElementVisibleByXPath(LOADALLBUTTON);
      }
    
    public boolean isCreationDateVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isCreationDateVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isCreationDateVisible method");
           return this.isVisible(this.getElementsByXPath(ELEMENTDATES).get(0));
      }
    
    public boolean isInputWordFilterVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isInputWordFilterVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isInputWordFilterVisible method");
           return this.isElementVisibleByXPath(FILTERWORD);
      }
    
    public boolean isHeaderNameVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isHeaderNameVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isHeaderNameVisible method");
          return this.isElementVisibleByXPath(HEADERNAME);
     }
    
    public boolean isButtonUpdatedVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isButtonUpdatedVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isButtonUpdatedVisible method");
         return this.isElementVisibleByXPath(RADIOUPDATED);
    }
}