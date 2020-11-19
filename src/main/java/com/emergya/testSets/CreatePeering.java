package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.AddOrganization;
import com.emergya.pageObjects.CommunityPage;
import com.emergya.pageObjects.Login;
import com.emergya.pageObjects.NewOrganization;
import com.emergya.pageObjects.SriHome;
import com.emergya.utils.BasicTestSet;
import com.emergya.utils.WebDriverUtils;

public class CreatePeering extends BasicTestSet {

    static Logger log = Logger.getLogger(CreatePeering.class);

    public CreatePeering() {
        super();
    }

    /***
    @AfterMethod(description = "endTest")
    public void afterAllIsSaidAndDone() {
        super.afterAllIsSaidAndDone();
    }**/
    
    @Test(description = "CreateOrganization",dataProvider = "remoteParams")
    public void createOrganization(String remoteParams) {
    	
        // Login
        String username = "admin";
        isReady(login = new Login(driver));
        login.fillUsername(username);
        login.fillPassword("Local.2019");
        sriHome = login.clickOnLogin();
       
        //Go to community page
        communityPage = sriHome.clickOnCommunity();    
        driver.sleep(1);

        
        // Click on Add Organization
        newOrganization = communityPage.clickAddOrganization();
        driver.sleep(1);
       
       //Create organization
       
       //Name
       String organizationName = "seleniumTest4";
       isReady (newOrganization = new NewOrganization(driver));
       newOrganization.organizationName(organizationName);
       driver.sleep(1);

       //Description
       String organizationDescription = "This is a example description for seleniumTest1 Organization";
       isReady (newOrganization = new NewOrganization (driver));
       newOrganization.organizationDescription(organizationDescription);
       driver.sleep(1);

       //Select Type
       newOrganization.selectType();
       driver.sleep(1);

       //Select Affiliation
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.selectAffiliation();
       driver.sleep(1);

       //Organization ID
       String organizationID = WebDriverUtils.getRandomIntegerBetweenRange(1000000, 9999999).toString();
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.organizationID(organizationID);
       driver.sleep(1);
       
       
       String parentOrganizationID = "12121212r";
       newOrganization.setParentOrganization(parentOrganizationID);
       
       String organizationNumber = "A23";
       newOrganization.setOrganizationNumber(organizationNumber);
       
       //Organization Website
       String organizationWebsite = "www.emergya.com/es";
       isReady (newOrganization = new NewOrganization(driver));
       newOrganization.organizationWebsite(organizationWebsite);
       driver.sleep(1);
  
       //Adress
       newOrganization.AddNewAdress();
       driver.sleep(1);

      //Street
       List<String> streets = new ArrayList<String>();
       String Street = "Luis de Morales 32, 5º";
       streets.add(Street);
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.Street(Street,0);       
       driver.sleep(2);

       //Postal Code
       List<String> postalcodes = new ArrayList<String>();
       String postalCode = "41018";
       postalcodes.add(postalCode);
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.PostalCode(postalCode,0);  
       driver.sleep(1);

       //Postal Area
       List<String> postalareas = new ArrayList<String>();
       String postalArea = "Sevilla";
       postalareas.add(postalArea);
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.PostalArea(postalArea,0); 
       driver.sleep(2);

       //Phone
       List<String> phones = new ArrayList<String>();
       String Phone = "954 51 75 77";
       phones.add(Phone);
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.Phone(Phone,0); 
       driver.sleep(1);
       String contact_name = "Nonnah Bottini";
       newOrganization.setContact(contact_name);
       List<Object> contact1 = new ArrayList<Object>();
       contact1.add("Nonnah Bottini");
       contact1.add("Abuse");
       List<String> emails = Arrays.asList("nbottinidv@de.vu","Work");
       contact1.add(emails);
       List<String> contact_phones = Arrays.asList("266-755-0405","793-796-2217");
       contact1.add(contact_phones);
       List<List<Object>> contacts = new ArrayList<List<Object>>();
       contacts.add(contact1);
       String worklog = "Worklog test";
       List<String> worklogs = new ArrayList<String>();
       worklogs.add(worklog);
       isOrganizationFirstWorklogVisible();
       newOrganization.setOrganizationFirstWorklog(worklog);
       String parentOrganization = "Myworks - 12121212r";
       //Save
       isSaveButtonVisible();
       newOrganization.SaveButton();
       driver.sleep(1);

       //Community click
       communityPage = sriHome.clickOnCommunity();
   
       // Check Organization by name 
       isOrganizationVisible(organizationName);
       //driver.sleep(100);
       driver.sleep(1);

       // click on the created test
       newOrganization.ClickOnTest();
       driver.sleep(2);
       
       isEditButtonVisible();
       newOrganization.clickEditButton();
       List<String> affiliation = Arrays.asList("End user");
       boolean res = newOrganization.equals(organizationName, organizationDescription, "Student network", affiliation, 
    		   organizationID, parentOrganization, organizationWebsite, organizationNumber, streets, 
    		   postalcodes, postalareas, phones, contacts, worklogs);
       assertTrue("The details does not display the same fields as when created", res);
       
       String organizationName2 = "44";
       isReady (newOrganization = new NewOrganization(driver));
       newOrganization.organizationName(organizationName2);
       driver.sleep(1);

       //Description
       String organizationDescription2 = "Added more information";
       isReady (newOrganization = new NewOrganization (driver));
       newOrganization.organizationDescription(organizationDescription2);
       driver.sleep(1);

       //Select Type
       newOrganization.selectType();
       driver.sleep(1);

       //Select Affiliation
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.selectAffiliation();
       driver.sleep(1);

       //Organization ID
       String organizationID2 = WebDriverUtils.getRandomIntegerBetweenRange(1000000, 9999999).toString();
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.organizationID(organizationID2);
       driver.sleep(1);

       //Organization Website
       String organizationWebsite2 = "/and";
       isReady (newOrganization = new NewOrganization(driver));
       newOrganization.organizationWebsite(organizationWebsite2);
       driver.sleep(1);

      //Street       
       String Street2 = "Calle";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.Street(Street2,0);       
       driver.sleep(2);
       streets.clear();
       streets.add(Street+Street2);
       //Postal Code
       String postalCode2 = "2";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.PostalCode(postalCode2,0);  
       driver.sleep(1);
       postalcodes.clear();
       postalcodes.add(postalCode+postalCode2);
       //Postal Area
       String postalArea2 = "(SEVILLA)";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.PostalArea(postalArea2,0); 
       driver.sleep(2);
       postalareas.clear();
       postalareas.add(postalArea+postalArea2);
       //Phone
       String Phone2 = "11";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.Phone(Phone2,0); 
       driver.sleep(1);
       phones.clear();
       phones.add(Phone+Phone2);
       newOrganization.AddNewAdress();
       String street3 = "Fake St";
       newOrganization.Street(street3, 1);
       streets.add(street3);
       String postalCode3 = "40303";
       newOrganization.PostalCode(postalCode3, 1);
       postalcodes.add(postalCode3);
       String postalArea3 = "NOWHERE";
       newOrganization.PostalArea(postalArea3, 1);
       postalareas.add(postalArea3);
       String Phone3="954003030";
       newOrganization.Phone(Phone3, 1);
       phones.add(Phone3);
       isProviderAffiliationVisible();
       newOrganization.clickProviderAffiliationButton();
       List<String> affiliation2 = Arrays.asList("Provider");
       List<Object> contact2 = new ArrayList<Object>();
       contact2.add("Arte Pollie");
       contact2.add("Developer III");
       List<String> mail = Arrays.asList("apollie24@blog.com","Work");
       contact2.add(mail);
       contact_phones = Arrays.asList("707-800-5688","924-757-2869");
       contact2.add(contact_phones);
       newOrganization.setEditContact((String) contact2.get(0));
       contacts.clear();
       contacts.add(contact2);
       contacts.add(contact1);
       String worklog2 = "Another Comment";
       newOrganization.setOrganizationWorklog(worklog2);
       newOrganization.clickSendButton();
       worklogs.add(worklog2);
       isSaveButtonVisible();
       newOrganization.SaveButton();
       
       
       communityPage = sriHome.clickOnCommunity();
       
       // Check Organization by name 
       isOrganizationVisible(organizationName);
       newOrganization.ClickOnTest();
       
       newOrganization.clickEditButton();
       res = newOrganization.equals(organizationName + organizationName2, 
    		   organizationDescription + organizationDescription2, "Student network", 
    		   affiliation2, organizationID + organizationID2, parentOrganization, organizationWebsite + organizationWebsite2
    		   , organizationNumber, streets, postalcodes, postalareas, phones, contacts, worklogs);
       assertTrue("The details does not display the same fields after being edited", res);
       //delete the test
       isDeleteButtonVisible();
       newOrganization.DeleteButton();
       driver.sleep(3);
       isOrganizationDeleted(organizationName2);
       
    } 
    public void isOrganizationVisible(String organizationName) {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Action 'reassign owner' is displayed. It should be displayed",
                newOrganization.isOrganizationVisible(organizationName));
    } 
    
    public void isOrganizationDeleted(String organizationName) {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("The organization we created was not deleted",
                !newOrganization.isOrganizationVisible(organizationName));
    } 
        
    //Check if Save Button button is visible
    public void isSaveButtonVisible() {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
    	assertTrue("Button Save is not visible",newOrganization.SaveButtonVisible());
    }    
    
    //Check if Delete Button is visible
    public void isDeleteButtonVisible() {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Button Save is not visible",newOrganization.SaveButtonVisible());
    }
    
    public void isEditButtonVisible() {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Button Edit is not visible",newOrganization.EditButtonVisible());
    }
    
    public void isProviderAffiliationVisible() {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Button Provider in affiliation is not visible",newOrganization.isProviderAffiliationVisible());
    }
    
    public void SendButtonVisible() {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Button Edit in affiliation is not visible",newOrganization.SendButtonVisible());
    }
    
    public void isOrganizationFirstWorklogVisible() {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Worklog is not visible",newOrganization.isOrganizationFirstWorklogVisible());
        }
   }
