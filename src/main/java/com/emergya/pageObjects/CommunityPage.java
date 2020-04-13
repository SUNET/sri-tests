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
    private static final String  HEADERORGANIZATIONID = "headerOrganizationID";
    private static final String  HEADERORGANIZATION = "headerOrganization";
    private static final String  HEADERCONTENTTYPE = "headerContentType";
    private static final String  HEADERDESCRIPTION = "headerDescription";
    private static final String  NAMEINTABLE = "columnNameInTable";
    private static final String  COLUMN2INTABLE = "column2InTable";
    private static final String  COLUMN3INTABLE = "column3InTable";
    private static final String  COLUMN4INTABLE = "column4InTable";
    private static final String  RADIOUPDATED   = "radioUpdated";
    private static final String  RESULTSORDER   = "resultsOrder";
    private static final String  ORGANIZATIONSITEM   = "contactOrganizationsItem";
    private static final String  ROLEICON   = "headerRoleIcon";
    private static final String  TYPEORDERAZ   = "typeOrderAZ";
    private static final String  TYPEORDERZA   = "typeOrderZA";
    private static final String  TYPECOMMERCIAL   = "typeCommercial";
    private static final String  TYPEMUSEUM   = "typeMuseum";
    private static final String  TYPERESEARCH   = "typeReseach";
    private static final String  TYPESTUDENT   = "typeStudent";
    private static final String  TYPEUNIVERSITY = "typeUniversity";
    private static final String  TYPEUNIDEP =  "typeUniDep";
    private static final String  TYPEALL   = "typeAll";
    private static final String  ROLEABUSE   = "roleAbuse";
    private static final String  ROLEPRIMARYCONTACT   = "rolePrimaryContact";
    private static final String  ROLESECONDARYCONTACT   = "roleSecondaryContact";
    private static final String  ROLENOCTECHNICAL   = "roleNOCTechnical";
    private static final String  ROLENOCSECURITY   = "roleNOCSecurity";
    private static final String  ROLENOCMANAGER   = "roleNOCManager";
    private static final String  ROLEEMPLOYEE   = "roleEmployee";
    private static final String  BUTTONACCEPT   = "buttonAccept";
    
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
    
    public String getNelementInSecondColumnInTable(Integer n) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getNelementInSecondColumnInTable method");
    	String name = this.getElementsByXPath(COLUMN2INTABLE).get(n).getText();
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getNelementInSecondColumnInTable method");
    	return name;
    }
    
    public String getNelementInThirdColumnInTable(Integer n) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getNelementInSecondColumnInTable method");
    	String name = this.getElementsByXPath(COLUMN3INTABLE).get(n).getText();
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getNelementInSecondColumnInTable method");
    	return name;
    }
    
    public String getNelementInFourthColumnInTable(Integer n) {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start getNelementInFourthColumnInTable method");
    	String name = this.getElementsByXPath(COLUMN4INTABLE).get(n).getText();
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End getNelementInFourthColumnInTable method");
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
                + "]- Start clickOnHeaderName method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(HEADERNAME));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderName method");
    }
    
    public void clickOnHeaderName2() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderName2 method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.moveAndClick2(driver, this.getElementByXPath(HEADERNAME));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderName2 method");
    }
    
    public void clickOnHeaderContentType() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderContentType method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(HEADERCONTENTTYPE).get(0));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderContentType method");
    }
    
    public void clickOnHeaderContentType2() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderContentType2 method");
    	if(isHeaderNameVisible()) {
    		WebDriverUtils.moveAndClick2(driver, this.getElementsByXPath(HEADERCONTENTTYPE).get(0));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderContentType2 method");
    }
    
    public void clickOnHeaderOrganizationID() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderOrganization method");
    	//if(isHeaderOrganizationVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(HEADERORGANIZATIONID));
    	//}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderOrganization method");
    }
    
    public void clickOnHeaderOrganizationID2() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderOrganization2 method");
    	if(isHeaderOrganizationIDVisible()) {
    		WebDriverUtils.moveAndClick2(driver, this.getElementByXPath(HEADERORGANIZATIONID));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderOrganization2 method");
    }
    
    public void clickOnHeaderOrganization() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderOrganization method");
    	if(isHeaderOrganizationVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(HEADERORGANIZATION));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderOrganization method");
    }
    
    public void clickOnHeaderOrganization2() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderOrganization2 method");
    	if(isHeaderOrganizationVisible()) {
    		WebDriverUtils.moveAndClick2(driver, this.getElementByXPath(HEADERORGANIZATION));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderOrganization2 method");
    }
    
    public void clickOnHeaderDescription() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderDescription method");
    	if(isHeaderDescriptionVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(HEADERDESCRIPTION).get(0));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderDescription method");
    }
    
    public void clickOnHeaderDescription2() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderDescription2 method");
    	WebDriverUtils.moveAndClick2(driver, this.getElementsByXPath(HEADERDESCRIPTION).get(0));
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderDescription2 method");
    }
    
    
    public void clickOnHeaderIconSubMenu() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnHeaderRole method");
    	if(isIconSubMenutVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLEICON));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnHeaderRole method");
    }
    
    public void selectTypeOrderAZ() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeOrderAZ method");
    	if(isTypeOrderAZVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPEORDERAZ).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeOrderAZ method");
    }
    
    public void selectTypeOrderZA() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeOrderZA method");
    	if(isTypeOrderZAVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPEORDERAZ).get(1));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeOrderZA method");
    }
    
    public void selectTypeCommercial() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeCommercial method");
    	if(isTypeCommercialVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPECOMMERCIAL).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeCommercial method");
    }
    
    public void selectTypeMuseum() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeMuseum method");
    	if(isTypeMuseumVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPEMUSEUM).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeMuseum method");
    }
    
    public void selectTypeResearch() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeResearch method");
    	if(isTypeResearchVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPERESEARCH).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeResearch method");
    }
    
    
    public void selectTypeStudent() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeStudent method");
    	if(isTypeStudentVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPESTUDENT).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeStudent method");
    }
    
    public void selectTypeUniversityCollege() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeUniversityCollege method");
    	if(isTypeUniversityCollegeVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPEUNIVERSITY).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeUniversityCollege method");
    }
    
    public void selectTypeUniversityDepartment() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectTypeUniversityDepartment method");
    	if(isTypeUniversityDepartmentVisible()) {
    		WebDriverUtils.click(driver, this.getElementsByXPath(TYPEUNIDEP).get(0));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectTypeUniversityDepartment method");
    }
    
    public void selectRoleAbuse() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRoleAbuse method");
    	if(isRoleAbuseVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLEABUSE));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRoleAbuse method");
    }
    
    public void selectRolePrimaryContact() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRolePrimaryContact method");
    	if(isRolePrimaryContactVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLEPRIMARYCONTACT));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRolePrimaryContact method");
    }
    
    public void selectRoleSecondaryContact() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRoleSecondaryContact method");
    	if(isRoleSecondaryContactVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLESECONDARYCONTACT));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRoleSecondaryContact method");
    }
    
    public void selectRoleNOCTechnical() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRoleNOCTechnical method");
    	if(isRoleNOCTechnicaltVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLENOCTECHNICAL));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRoleNOCTechnical method");
    }
    
    public void selectRoleNOCSecurity() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRoleNOCSecurity method");
    	if(isRoleNOCSecuritytVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLENOCSECURITY));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRoleNOCSecurity method");
    }
    
    public void selectRoleNOCManager() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRoleNOCManager method");
    	if(isRoleNOCManagerVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLENOCMANAGER));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRoleNOCManager method");
    }
    
    public void selectRoleEmployee() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start selectRoleEmployee method");
    	if(isRoleEmployeeVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ROLEEMPLOYEE));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End selectRoleEmployee method");
    }
    
    public void clickAcceptFilterRole() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickAcceptFilterRole method");
    	if(isButtonAcceptVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(BUTTONACCEPT));
    	}
    	
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickAcceptFilterRole method");
    }
    
    
    public void clickOnButtonUpdated() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnButtonUpdated method");
    	if(isButtonUpdatedVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(RADIOUPDATED));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnButtonUpdated method");
    }
    
    public void changeResultsOrder() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start changeResultsOrder method");
    	if(isResultsOrderVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(RESULTSORDER));
    	}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End changeResultsOrder method");	
    }
    
    public void clickOrganizationsItems() {
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOrganizationsItems method");
    	//if(isHeaderOrganizationVisible()) {
    		WebDriverUtils.click(driver, this.getElementByXPath(ORGANIZATIONSITEM));
    	//}
    	log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOrganizationsItems method");
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
    
    public boolean isHeaderOrganizationIDVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isHeaderNameVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isHeaderNameVisible method");
         return this.isElementVisibleByXPath(HEADERORGANIZATIONID);
    }
    
    public boolean isHeaderOrganizationVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isHeaderNameVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isHeaderNameVisible method");
        return this.isElementVisibleByXPath(HEADERORGANIZATION);
   }
    
    public boolean isHeaderContentTypeVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isHeaderContentTypeVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isHeaderContentTypeVisible method");
        return this.isElementVisibleByXPath(HEADERCONTENTTYPE);
   }
    
    public boolean isHeaderDescriptionVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isHeaderDescriptionVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isHeaderDescriptionVisible method");
           return this.isElementVisibleByXPath(HEADERDESCRIPTION);
      }
    
    public boolean isButtonUpdatedVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isButtonUpdatedVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isButtonUpdatedVisible method");
         return this.isElementVisibleByXPath(RADIOUPDATED);
    }
    
    public boolean isResultsOrderVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isResultsOrderVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isResultsOrderVisible method");
        return this.isElementVisibleByXPath(RESULTSORDER);
   }
    
    public boolean isOrganizationItemVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isOrganizationItemVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isOrganizationItemVisible method");
           return this.isElementVisibleByXPath(ORGANIZATIONSITEM);
      }
    
    public boolean isTypeOrderAZVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isTypeOrderAZVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isTypeOrderAZVisible method");
          return this.isVisible(this.getElementsByXPath(TYPEORDERAZ).get(0));
     }
    
    public boolean isTypeOrderZAVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isTypeOrderZAVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isTypeOrderZAVisible method");
         return this.isVisible(this.getElementsByXPath(TYPEORDERAZ).get(1));
    }
    
    public boolean isTypeCommercialVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isTypeCommercialVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isTypeCommercialVisible method");
        return this.isElementVisibleByXPath(TYPECOMMERCIAL);
   }
    
    public boolean isTypeMuseumVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isTypeMuseumVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isTypeMuseumVisible method");
           return this.isElementVisibleByXPath(TYPEMUSEUM);
      }
    
    public boolean isTypeResearchVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isTypeResearchVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isTypeResearchVisible method");
          return this.isElementVisibleByXPath(TYPERESEARCH);
     }
    
    public boolean isTypeStudentVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isTypeStudentVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isTypeStudentVisible method");
         return this.isElementVisibleByXPath(TYPESTUDENT);
    }
    
    public boolean isTypeUniversityCollegeVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isTypeUniversityCollegeVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isTypeUniversityCollegeVisible method");
        return this.isElementVisibleByXPath(TYPEUNIVERSITY);
   }
    
    public boolean isTypeUniversityDepartmentVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isTypeUniversityCollegeVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isTypeUniversityCollegeVisible method");
           return this.isElementVisibleByXPath(TYPEUNIDEP);
      }
    
    public boolean isButtonAcceptVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isButtonAcceptVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isButtonAcceptVisible method");
         return this.isElementVisibleByXPath(BUTTONACCEPT);
    }
    
    public boolean isRoleAbuseVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isRoleAbuseVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isRoleAbuseVisible method");
        return this.isElementVisibleByXPath(ROLEABUSE);
   }
    
    public boolean isRolePrimaryContactVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isRolePrimaryContactVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isRolePrimaryContactVisible method");
           return this.isElementVisibleByXPath(ROLEPRIMARYCONTACT);
      }
    
    public boolean isRoleSecondaryContactVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isRoleSecondaryContactVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isRoleSecondaryContactVisible method");
          return this.isElementVisibleByXPath(ROLESECONDARYCONTACT);
     }
    
    public boolean isRoleNOCTechnicaltVisible() {
    	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- Start isRoleNOCTechnicaltVisible method");
         log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                 + "]- End isRoleNOCTechnicaltVisible method");
         return this.isElementVisibleByXPath(ROLENOCTECHNICAL);
    }
    
    public boolean isRoleNOCSecuritytVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isRoleNOCSecuritytVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isRoleNOCSecuritytVisible method");
        return this.isElementVisibleByXPath(ROLENOCSECURITY);
   }
    
    public boolean isRoleNOCManagerVisible() {
      	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- Start isRoleNOCManagerVisible method");
           log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                   + "]- End isRoleNOCManagerVisible method");
           return this.isElementVisibleByXPath(ROLENOCMANAGER);
      }
    
    public boolean isRoleEmployeeVisible() {
     	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- Start isRoleEmployeeVisible method");
          log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                  + "]- End isRoleEmployeeVisible method");
          return this.isElementVisibleByXPath(ROLEEMPLOYEE);
     }
    
    public boolean isIconSubMenutVisible() {
   	 log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isIconSubMenutVisible method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isIconSubMenutVisible method");
        return this.isElementVisibleByXPath(ROLEICON);
   }
}