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
        String lastName = "LastName";
        newContact.setLastName(lastName);
        isAddNotesVisible();
        String notes = "NOTES";
        newContact.setAddNotes(notes);
        isTypeTitleVisible();
        String typeTitle = "Mr";
        newContact.setTypeTitle(typeTitle);
        isSelectTypeVisible();
        String type = "Person";
        newContact.setSelectType(type);
        isAddNewMailVisible();
        newContact.clickAddNewMail();
        isInputEmailVisible();
        String emailAddress1 = "hello@world.com";
        newContact.setEmail(emailAddress1);
        String emailType1 = "Personal";
        newContact.setEmailType(emailType1);
        List<String> email1 = Arrays.asList(emailAddress1,emailType1);
        List<List<String>> emails = new ArrayList<List<String>>();
        emails.add(email1);
        isAddNewPhoneVisible();
        newContact.clickAddNewPhone();
        List<List<String>> phones = new ArrayList<List<String>>();
        isInputPhoneVisible();
        String phone_number = "555504040404";
        newContact.setPhone(phone_number);
        isPhoneTypeVisible();
        String phone_type = "Personal";
        newContact.setPhoneType(phone_type);
        List<String> phone1 = Arrays.asList(phone_number,phone_type);
        phones.add(phone1);
        isPGPFingerPrintVisible();
        String fingerprint = "1212130303030303";
        newContact.setPGPFingerPrint(fingerprint);
        isAddNewProfessionalDetailsVisible();
        newContact.clickAddNewProfessionalDetails();
        List<List<String>> organizations = new ArrayList<List<String>>();
        isSelectRoleVisible();
        String organization_role1 = "Account Executive";
        newContact.setRole(organization_role1);
        String organization_id1 = "12121212";
        isSelectOrganizationVisible();
        String organization_name1 = "Tavu";
        newContact.setOrganization(organization_name1);
        List<String> organization1 = Arrays.asList(organization_role1,organization_id1,organization_name1);
        organizations.add(organization1);
        isCommentAreaVisible();
        String worklog1 = "This is an example of a comment, right here";
        newContact.setComment(worklog1);
        List<String> worklogs = Arrays.asList(worklog1);
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
        boolean res = newContact.equals(name, lastName, notes, typeTitle, type, emails, phones,
        		fingerprint, organizations,worklogs);
        assertTrue("For this contact fields displayed don't match how it was created ", res);
        String lastName2 = "LastName2";
        lastName = lastName + lastName2;
        newContact.setLastName(lastName2);
        String notes2 = "NOTES2";
        notes = notes + notes2;
        newContact.setAddNotes(notes2);
        String typeTitle2 = "Mr";
        typeTitle = typeTitle + typeTitle2;
        newContact.setTypeTitle(typeTitle2);
        type = "Group";
        newContact.setSelectType(type);
        String emailAddress2 = ".es";
        emailAddress1 = emailAddress1 + emailAddress2;
        newContact.setEmail(emailAddress2);
        String emailType2 = "Work";
        newContact.setEmailType(emailType2);
        newContact.clickAddNewMail();
        List<String> email11 = Arrays.asList(emailAddress1,emailType2);
        emails.clear();
        emails.add(email11);
        String email20 = "test@test.com";
        newContact.setMailAddressN(1, email20);
        String email21 = "Personal";
        newContact.setMailTypeN(1, email21);
        List<String> email22 = Arrays.asList(email20,email21);
        emails.add(email22);
        String phone10 = "0005050505005";
        newContact.setPhone(phone10);
        phone10 = phone_number + phone10;
        String phone11 = "Work";
        newContact.setPhoneType(phone11);
        List<String> phone12 = new ArrayList<String>();
        phone12.add(phone10);
        phone12.add(phone11);
        List<List<String>> phones2 = new ArrayList<List<String>>();
        phones2.add(phone12);
        String phone20 = "102120101";
        String phone21 = "Personal";
        List<String> phone22 = Arrays.asList(phone20,phone21);
        phones2.add(phone22);
        newContact.clickAddNewPhone();
        newContact.setPhoneNumberN(1, phone20);
        newContact.setPhoneTypeN(1, phone21);
        String fingerprints2 = "2323232";
        newContact.setPGPFingerPrint(fingerprints2);
        fingerprint = fingerprint + fingerprints2;
        List<List<String>> organizations2 = new ArrayList<List<String>>();
        List<String> organization10 = new ArrayList<String>();
        String organization11 = "Account Executive";
        String organization12 = "AIBOX";
        String organization13 = "Aibox";
        organization10.add(organization11);
        organization10.add(organization12);
        organization10.add(organization13);
        organizations2.add(organization10);
        newContact.setRole(organization11);
        newContact.setOrganization(organization13);
        String worklog2 = "This is an example of a comment, right here";
        newContact.setComment(worklog2);
        String worklog3 = "New comment comment";
        newContact.setComment(worklog3);
        worklog2 = worklog2 + worklog3;
        worklogs = new ArrayList<String>();
        worklogs.add(worklog1);
        worklogs.add(worklog2);
        isButtonSendVisible();
        newContact.clickSend();
        isButtonSaveVisible();
        newContact.clickSave();
        
        communityPage = new CommunityPage(driver);
        communityPage.clickContactItem();
        isANewContactVisible();
        newContact = communityPage.clickOnContact();
        driver.sleep(3);
        isButtonEditVisible();
        newContact.clickEdit();
        res = newContact.equals(name, lastName, notes, typeTitle, type, emails, phones2, 
        		fingerprint, organizations2, worklogs);
        assertTrue("For this contact fields displayed don't match how it was edited ", res);
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