package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
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

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class CreateGroupTestSet extends BasicTestSet {

    static Logger log = Logger.getLogger(CreateGroupTestSet.class);

    public CreateGroupTestSet() {
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
     * - Click on Community
     *
     * Steps:
     * - Click on groups
     * - Add group 
     * - Set a name and description
     * - The group will be created successfully
     * - Select one group previously created
     * - Edit changing all the fields
     * - Save
     * - The groups will update accord with the edit
     * - Select the group
     * - Click on the button Delete


     *
     * Post steps:
     * - Open the contact
     * - Click on the button Click 
     * - Close Browser
     */
    /***
    @AfterMethod(description = "endTest")
    public void afterAllIsSaidAndDone() {
        super.afterAllIsSaidAndDone();
        }
    */
    @BeforeMethod(description = "login")
    public void login() {
    	// Login
        String username = "admin";
        isReady(login = new Login(driver));
        login.fillUsername(username);
        login.fillPassword("Local.2019");
        sriHome = login.clickOnLogin();
    }

    @Test(description = "CreateGroup",dataProvider = "remoteParams")
    public void createGroup(String remoteParams) {
       
        //Go to community page
        communityPage = sriHome.clickOnCommunity();
        driver.sleep(1);

        
        // Click on item contact in the menu
        communityPage.clickGroupItem();
        newGroup = communityPage.clickAddNewGroup();
        driver.sleep(3);
        
        isReady(newGroup);
        newGroup.setName("Test4");
        isDescriptionTexstAreaVisible();
        newGroup.setDescription("This is a great description for a test");
        newContact = newGroup.clickAddNewContact();
        String name="SeleniumTest";
        newContact.setName(name);
        newContact.setLastName("LastName");
        newContact.setAddNotes("NOTES");
        newContact.setTypeTitle("Mr");
        newContact.setSelectType("Person");
        isButtonAddNewVisible();
        newContact.clickAddNewMail();
        newContact.setEmail("hello@world.com");
        newContact.setEmailType("Personal");
        newContact.clickAddNewPhone();
        newContact.setPhone("555504040404");
        newContact.setPhoneType("Personal");
        newContact.setPGPFingerPrint("1212130303030303");
        newContact.clickAddNewProfessionalDetailsModal();
        newContact.setRole("Account Executive");
        newContact.setOrganization("Abata");
        isCommentAreaVisible();
        newContact.setComment("This is an example of a comment, right here");
        newContact.clickSaveModal();
        driver.sleep(3);
        isInputSearchContactVisible();
        newGroup.setSearchForContact("SeleniumTest");
        newGroup.setComment("This is a comment");
        isButtonSaveVisible();
        newGroup.clickSave();
        driver.sleep(3);
        isGroupItemVisible();
        communityPage.clickGroupItem();
        driver.sleep(3);
        isGroupVisible();
        newGroup = communityPage.clickGroup();
        driver.sleep(3);
        isButtonEditVisible();
        newGroup.clickEdit();
        isReady(newGroup);
        newGroup.setName("Test4");
        isDescriptionTexstAreaVisible();
        newGroup.setDescription("This is a great description for a test");
        isInputSearchContactVisible();
        newGroup.setSearchForContact("John");
        driver.sleep(2);
        isCommentAreaVisible();
        newGroup.setComment("This is a new comment");
        driver.sleep(2);
        isButtonSendVisible();
        newGroup.clickSend();
        driver.sleep(2);
        isButtonSaveVisible();
        newGroup.clickSave();
        driver.sleep(2);
        isGroupItemVisible();
        communityPage.clickGroupItem();
        driver.sleep(3);
        isGroupVisible();
        newGroup = communityPage.clickGroup();
        isButtonDeteleVisible();
        newGroup.clickDelete();
        driver.sleep(3);
        isGroupDeleted();
        driver.sleep(2);
        communityPage = new CommunityPage(driver);
        communityPage.clickContactItem();
        driver.sleep(3);
        newContact = communityPage.clickOnContact();
        driver.sleep(2);
        newContact.clickDelete();
      }
    
    public void isDescriptionTexstAreaVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Description Text area is not visible",
                newGroup.isDescriptionTexstAreaVisible());
    }
    
    public void isCommentAreaVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Comment area is not visible",
                newGroup.isCommentAreaVisible());
    }
    
    public void isButtonAddNewVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Button Add New is not visible",
                newGroup.isButtonAddNewVisible());
    }
    
    public void isInputSearchContactVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Input Search is not visible",
                newGroup.isInputSearchContactVisible());
    }
    
    //Check if Delete Button is visible
    public void isButtonSaveVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Button Save is not visible",
                newGroup.isButtonSaveVisible());
    }
    
    public void isButtonEditVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Button Edit is not visible",
                newGroup.isButtonEditVisible());
    }
    
    public void isButtonSendVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Button Send is not visible",
                newGroup.isButtonSendVisible());
    }
    
    public void isButtonDeteleVisible() {
        if (newGroup == null) {
            newGroup = new NewGroup(driver);
        }
        assertTrue("Button Delete is not visible",
                newGroup.isButtonDeteleVisible());
    }
    
    public void isGroupVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("New group is not visible",
                communityPage.isGroupVisible());
      }
    
    public void isGroupDeleted() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("New Group has not been deleted",
                !communityPage.isGroupVisible());
      }
      
    
    public void isGroupItemVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("Group is not visible in the menu",
                communityPage.isGroupItemVisible());
     }
    
}