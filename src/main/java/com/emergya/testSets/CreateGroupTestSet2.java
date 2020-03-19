package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
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

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class CreateGroupTestSet2 extends BasicTestSet {

    static Logger log = Logger.getLogger(CreateGroupTestSet2.class);

    public CreateGroupTestSet2() {
        super();
    }

    // **************** TESTS ****************
    // ------ EMERGYA QA SAMPLE TEST ------ //
    // ------ US00001 - Add Contact ------ //
    /**
     * Description: It should be possible to add a contact, with or without 
     * organization and role associated to it. Currently it only allows to add 
     * users with organizations associated.

     *
     * Pre steps:
     * - Open the browser
     * - Login
     *
     * Steps:
     * -Access to the website (https://sri.ed-integrations.com/)
     * - Login as Admin
     * - Click on Community
     * - Click Contacts
     * - Add contact
     * - Complete all the fields including a Role and a Organization
     * - Save

     *
     * Post steps:
     * - Open the contact
     * - Click on the button Click 
     * - Close Browser
     */
    @AfterMethod(description = "endTest")
    public void afterAllIsSaidAndDone() {
        super.afterAllIsSaidAndDone();
    }
    
    @BeforeMethod(description = "login")
    public void login() {
    	// Login
        String username = "admin";
        isReady(login = new Login(driver));
        login.fillUsername(username);
        login.fillPassword("Local.2019");
        sriHome = login.clickOnLogin();
    }

    @Test(description = "CreateOrganization",dataProvider = "remoteParams")
    public void createOrganization(String remoteParams) {
       
        //Go to community page
        communityPage = sriHome.clickOnCommunity();    
        driver.sleep(1);

        
        // Click on item contact in the menu
        communityPage.clickContactItem();
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
       String organizationID = "111111112";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.organizationID(organizationID);
       driver.sleep(1);

       //Organization Website
       String organizationWebsite = "www.emergya.com/es";
       isReady (newOrganization = new NewOrganization(driver));
       newOrganization.organizationWebsite(organizationWebsite);
       driver.sleep(1);
  
       //Adress
       newOrganization.AddNewAdress();
       driver.sleep(1);

      //Street       
       String Street = "Luis de Morales 32, 5º";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.Street(Street);       
       driver.sleep(2);

       //Postal Code
       String postalCode = "41018";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.PostalCode(postalCode);  
       driver.sleep(1);

       //Postal Area
       String postalArea = "Sevilla";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.PostaArea(postalArea); 
       driver.sleep(2);

       //Phone
       String Phone = "954 51 75 77";
       isReady(newOrganization = new NewOrganization(driver));
       newOrganization.Phone(Phone); 
       driver.sleep(1);

       //Save
       newOrganization.SaveButton();
       driver.sleep(1);

       //Community click
       communityPage = sriHome.clickOnCommunity();
   
       // Check Organization by name 
       //isOrganizationVisible(organizationName);
       //driver.sleep(100);
       driver.sleep(1);

       // click on the created test
       newOrganization.ClickOnTest();
       driver.sleep(2);

       //delete the test
       newOrganization.DeleteButton();
       
    }
    public void isOrganizationVisible(String organizationName) {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Action 'reassign owner' is displayed. It should be displayed",
                newOrganization.isOrganizationVisible(organizationName));
    } 
    
}


        
        
        
        
      
        
  
