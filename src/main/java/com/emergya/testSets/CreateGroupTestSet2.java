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

    @Test(description = "CreateContact",dataProvider = "remoteParams")
    public void createContact(String remoteParams) {
       
        //Go to community page
        communityPage = sriHome.clickOnCommunity();    
        driver.sleep(1);

        
        // Click on item contact in the menu
        communityPage.clickContactItem();
        newContact = communityPage.clickAddNewContact();
        driver.sleep(1);
        
        isReady(newContact);
        
        String name="SeleniumTest";
        newContact.setName(name);
        newContact.setLastName("LastName");
        newContact.setAddNotes("NOTES");
        newContact.setTypeTitle("Mr");
        newContact.setSelectType("Person");
        newContact.clickAddNewMail();
        newContact.setEmail("hello@world.com");
        newContact.setEmailType("Personal");
        newContact.clickAddNewPhone();
        newContact.setPhone("555504040404");
        newContact.setPhoneType("Personal");
        newContact.setPGPFingerPrint("1212130303030303");
        newContact.clickAddNewProfessionalDetails();
        newContact.setRole("Account Executive");
        newContact.setOrganization("Abata");
        newContact.setComment("This is an example of a comment, right here");
        newContact.clickSave();
        driver.sleep(3);
        
        communityPage = new CommunityPage(driver);
        communityPage.clickContactItem();
        newContact = communityPage.clickOnContact();
        driver.sleep(3);
        newContact.clickEdit();
        newContact.setLastName("LastName2");
        newContact.setAddNotes("NOTES2");
        newContact.setTypeTitle("Mr");
        newContact.setSelectType("Group");
        newContact.setEmail("hello2@world.com");
        newContact.setEmailType("Work");
        newContact.setPhone("0005050505005");
        newContact.setPhoneType("Work");
        newContact.setPGPFingerPrint("2323232");
        newContact.setRole("Account Executive");
        newContact.setOrganization("Abata");
        newContact.setComment("This is an example of a comment, right here");
        newContact.setComment("New comment comment");
        newContact.clickSend();
        newContact.clickSave();
        
        communityPage = new CommunityPage(driver);
        communityPage.clickContactItem();
        newContact = communityPage.clickOnContact();
        
        newContact.clickDelete();
        
        
        }
    public void isOrganizationVisible(String organizationName) {
        if (newOrganization == null) {
            newOrganization = new NewOrganization(driver);
        }
        assertTrue("Action 'reassign owner' is displayed. It should be displayed",
                newOrganization.isOrganizationVisible(organizationName));
    } 
    
}


        
        
        
        
      
        
  
