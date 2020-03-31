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
import com.emergya.pageObjects.NewContact;
import com.emergya.pageObjects.NewGroup;
import com.emergya.pageObjects.NewOrganization;
import com.emergya.pageObjects.SriHome;
import com.emergya.utils.BasicTestSet;

import net.bytebuddy.matcher.IsNamedMatcher;

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class CreateContactTestSet extends BasicTestSet {

    static Logger log = Logger.getLogger(CreateContactTestSet.class);

    public CreateContactTestSet() {
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
    /**
    @AfterMethod(description = "endTest")
    public void afterAllIsSaidAndDone() {
        super.afterAllIsSaidAndDone();
    }**/
    
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
        isLastNameVisible();
        newContact.setLastName("LastName");
        isAddNotesVisible();
        newContact.setAddNotes("NOTES");
        isTypeTitleVisible();
        newContact.setTypeTitle("Mr");
        isSelectTypeVisible();
        newContact.setSelectType("Person");
        isAddNewMailVisible();
        newContact.clickAddNewMail();
        isInputEmailVisible();
        newContact.setEmail("hello@world.com");
        newContact.setEmailType("Personal");
        isAddNewPhoneVisible();
        newContact.clickAddNewPhone();
        isInputPhoneVisible();
        newContact.setPhone("555504040404");
        isPhoneTypeVisible();
        newContact.setPhoneType("Personal");
        isPGPFingerPrintVisible();
        newContact.setPGPFingerPrint("1212130303030303");
        isAddNewProfessionalDetailsVisible();
        newContact.clickAddNewProfessionalDetails();
        isSelectRoleVisible();
        newContact.setRole("Account Executive");
        isSelectOrganizationVisible();
        newContact.setOrganization("Tavu");
        isCommentAreaVisible();
        newContact.setComment("This is an example of a comment, right here");
        isButtonSaveVisible();
        newContact.clickSave();
        driver.sleep(3);
        
        communityPage = new CommunityPage(driver);
        communityPage.clickContactItem();
        isANewContactVisible();
        newContact = communityPage.clickOnContact();
        driver.sleep(3);
        isButtonEditVisible();
        newContact.clickEdit();
        newContact.setLastName("LastName2");
        newContact.setAddNotes("NOTES2");
        newContact.setTypeTitle("Mr");
        newContact.setSelectType("Group");
        newContact.setEmail(".es");
        newContact.setEmailType("Work");
        newContact.setPhone("0005050505005");
        newContact.setPhoneType("Work");
        newContact.setPGPFingerPrint("2323232");
        newContact.setRole("Account Executive");
        newContact.setOrganization("Aibox");
        newContact.setComment("This is an example of a comment, right here");
        newContact.setComment("New comment comment");
        isButtonSendVisible();
        newContact.clickSend();
        isButtonSaveVisible();
        newContact.clickSave();
        
        communityPage = new CommunityPage(driver);
        communityPage.clickContactItem();
        isANewContactVisible();
        newContact = communityPage.clickOnContact();
        driver.sleep(3);
        isButtonDeteleVisible();
        newContact.clickDelete();
        driver.sleep(3);
        isANewContactDeleted();
        }
    //Check if Delete Button is visible
    public void isLastNameVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Description Text area is not visible",
                newContact.isLastNameVisible());
    }
    
    public void isAddNotesVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Add Notes is not visible",
                newContact.isAddNotesVisible());
    }  
       
    public void isTypeTitleVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Type Title is not visible",
                newContact.isTypeTitleVisible());
    }
   
    public void isSelectTypeVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Select Type is not visible",
                newContact.isSelectTypeVisible());
    } 
    
    public void isAddNewMailVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Add New Mail is not visible",
                newContact.isAddNewMailVisible());
    }
    
    public void isInputEmailVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Input Email is not visible",
                newContact.isInputEmailVisible());
    }
    
    public void isEmailTypeSelectVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Select Email Type is not visible",
                newContact.isEmailTypeSelectVisible());
    }
    
    public void isAddNewPhoneVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Add New Phone button is not visible",
                newContact.isAddNewPhoneVisible());
    }
    
    public void isInputPhoneVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Phone input is not visible",
                newContact.isInputPhoneVisible());
    }
    
    public void isPhoneTypeVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Phone Type select is not visible",
                newContact.isPhoneTypeVisible());
    }
    public void isPGPFingerPrintVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("PGP Finger Print is not visible",
                newContact.isPGPFingerPrintVisible());
    }
    public void isAddNewProfessionalDetailsVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Add New Professional Deailts button is not visible",
                newContact.isAddNewProfessionalDetailsVisible());
    }
    
    public void isSelectRoleVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Role select is not visible",
                newContact.isSelectRoleVisible());
    }
    
    public void isSelectOrganizationVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Organization select is not visible",
                newContact.isSelectOrganizationVisible());
    }
    
    public void isCommentAreaVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Comment area is not visible",
                newContact.isCommentAreaVisible());
    }
    
    public void isButtonSaveVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Button Save is not visible",
                newContact.isButtonSaveVisible());
    }
    
    public void isButtonEditVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Button Edit is not visible",
                newContact.isButtonEditVisible());
    }
    
    public void isButtonSendVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Button Send is not visible",
                newContact.isButtonSendVisible());
    }
    
    public void isButtonDeteleVisible() {
        if (newContact == null) {
            newContact = new NewContact(driver);
        }
        assertTrue("Button Delete is not visible",
                newContact.isButtonDeteleVisible());
    }
    
    public void isContactVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("Contact in menu is not visible",
                communityPage.isContactVisible());
   }
    public void isANewContactVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("New Contact is not visible",
                communityPage.isANewContactVisible());
     }
    public void isANewContactDeleted() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("New Contact is visible",
                !communityPage.isANewContactVisible());
     }
}