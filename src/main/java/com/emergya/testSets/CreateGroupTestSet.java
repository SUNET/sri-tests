package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
        isAddNewGroupVisible();
        newGroup = communityPage.clickAddNewGroup();
        driver.sleep(3);
        
        isReady(newGroup);
        String name = "Test4";
        newGroup.setName(name);
        isDescriptionTexstAreaVisible();
        String description = "This is a great description for a test";
        newGroup.setDescription(description);
        newContact = newGroup.clickAddNewContact();
        String contact_name="SeleniumTest";
        newContact.setName(contact_name);
        String contact_lastName = "LastName";
        newContact.setLastName(contact_lastName);
        String contact_notes = "NOTES";
        newContact.setAddNotes(contact_notes);
        String contact_typeTitle = "Mr";
        newContact.setTypeTitle(contact_typeTitle);
        String contact_type = "Person";
        newContact.setSelectType(contact_type);
        isButtonAddNewVisible();
        newContact.clickAddNewMail();
        String contact_mail_address = "hello@world.com";
        newContact.setEmail(contact_mail_address);
        String contact_mail_type = "Personal";
        newContact.setEmailType(contact_mail_type);
        List<String> contact_email1 = Arrays.asList(contact_mail_address, contact_mail_type);
        List<List<String>> contact_emails = new ArrayList<List<String>>();
        contact_emails.add(contact_email1);
        newContact.clickAddNewPhone();
        String contact_phone_number = "555504040404";
        newContact.setPhone(contact_phone_number);
        String contact_phone_type = "Personal";
        List<String> contact_phones = new ArrayList<String>();
        contact_phones.add(contact_phone_number);
        newContact.setPhoneType(contact_phone_type);
        String fingerprint = "1212130303030303";
        newContact.setPGPFingerPrint(fingerprint);
        newContact.clickAddNewProfessionalDetailsModal();
        String contact_role = "Account Executive";
        newContact.setRole(contact_role);
        String contact_organization = "Agivu"; 
        newContact.setOrganization(contact_organization);
        isCommentAreaVisible();
        String contact_comment = "This is an example of a comment, right here"; 
        newContact.setComment(contact_comment);
        newContact.clickSaveModal();
        List<Object> contact = Arrays.asList(contact_name+" "+contact_lastName,contact_organization,contact_emails,
        		contact_phones);
        List<List<Object>> contacts = new ArrayList<List<Object>>();
        contacts.add(contact);
        driver.sleep(3);
        isInputSearchContactVisible();
        newGroup.setSearchForContact("SeleniumTest");
        String worklog1 = "This is a comment";
        newGroup.setComment(worklog1);
        List<String> worklogs = new ArrayList<String>();
        worklogs.add(worklog1);
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
        boolean res = newGroup.equals(name, description, contacts, worklogs);
        assertTrue("The fields don't display the info which this group was created with", res);
        isReady(newGroup);
        newGroup.setName(name);
        name = name+name;
        isDescriptionTexstAreaVisible();
        newGroup.setDescription(description);
        description = description + description;
        isInputSearchContactVisible();
        String contact_name2 = "Nonnah Bottini";
        newGroup.setSearchForContact(contact_name2);
        String contact_organization2 = "Tave";
        List<String> contact2_mail1 = new ArrayList<String>();
        contact2_mail1.add("nbottinidv@de.vu");
        contact2_mail1.add("Work");
        List<List<String>> contact2_mail = new ArrayList<List<String>>();
        contact2_mail.add(contact2_mail1);
        List<String> contact2_phones = new ArrayList<String>();
        contact2_phones.add("266-755-0405");
        contact2_phones.add("793-796-2217");
        List<Object> contact2 = new ArrayList<Object>();
        contact2.add(contact_name2);
        contact2.add(contact_organization2);
        contact2.add(contact2_mail);
        contact2.add(contact2_phones);
        contacts.set(0, contact2);
        driver.sleep(2);
        isCommentAreaVisible();
        String worklog2 = "This is a new comment";
        newGroup.setComment(worklog2);
        worklogs.add(worklog2);
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
        isButtonEditVisible();
        newGroup.clickEdit();
        res = newGroup.equals(name, description, contacts, worklogs);
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
    
    public void isAddNewGroupVisible() {
        if (communityPage == null) {
        	communityPage = new CommunityPage(driver);
        }
        assertTrue("Button Add New group is not visible",
                communityPage.isAddNewGroupVisible());
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