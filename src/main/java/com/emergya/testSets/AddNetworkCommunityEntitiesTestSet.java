package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.AddEntityOrganization;
import com.emergya.pageObjects.AddOrganization;
import com.emergya.pageObjects.CommunityPage;
import com.emergya.pageObjects.Login;
import com.emergya.pageObjects.NetworkPage;
import com.emergya.pageObjects.NewContact;
import com.emergya.pageObjects.NewGroup;
import com.emergya.pageObjects.NewOrganization;
import com.emergya.pageObjects.SriHome;
import com.emergya.utils.BasicTestSet;
import com.emergya.utils.WebDriverUtils;

import net.bytebuddy.matcher.IsNamedMatcher;

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class AddNetworkCommunityEntitiesTestSet extends BasicTestSet {

    static Logger log = Logger.getLogger(AddNetworkCommunityEntitiesTestSet.class);

    public AddNetworkCommunityEntitiesTestSet() {
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
     * We'll be able to order the contacts using the header of Contacts page
     * A few contacts created with more than one phone, email and multiple organizations.
     * Access to the website (https://sri.ed-integrations.com/)
     * Login as Admin
     * 
     * Steps
     * TO - DO
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

    @Test(description = "AddCustomers",dataProvider = "remoteParams")
    public void addCustomers(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();    
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        Random r = new Random();
        int low = 0;
        int high = 100;
        Integer result = r.nextInt(high-low) + low;
        String user = "Test" + result;
        addEntityOrganization = networkPage.clickAddButton();
        driver.sleep(3);
        //isFieldNameVisible();
        addEntityOrganization.setName(user);
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("This is a description");
        isFieldURLVisible();
        addEntityOrganization.setURL("http://www.elpais.es");
        isFieldWorklogVisible();
        addEntityOrganization.setWorklog("This is a worklog");
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityOrganization.clickButtonEdit();
        driver.sleep(3);
        String useredit = " EDIT";
        isFieldNameVisible();
        addEntityOrganization.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("EDIT");
        isFieldURLVisible();
        addEntityOrganization.setURL("/com");
        isFieldTextAreaCommentVisible();
        addEntityOrganization.setTextAreaComment("This is a new comment");
        isButtonSendVisible();
        addEntityOrganization.clickButtonSend();
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonDeleteVisible();
        addEntityOrganization.clickButtonDelete();
        driver.sleep(3);
        assertTrue("Customer was not deleted",!networkPage.isUserVisible(user));
     }
    
    @Test(description = "AddCustomers",dataProvider = "remoteParams")
    public void addEndUsers(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();    
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        Random r = new Random();
        int low = 0;
        int high = 100;
        Integer result = r.nextInt(high-low) + low;
        String user = "Test" + result;
        addEntityOrganization = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityOrganization.setName(user);
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("This is a description");
        isFieldURLVisible();
        addEntityOrganization.setURL("http://www.elpais.es");
        isFieldWorklogVisible();
        addEntityOrganization.setWorklog("This is a worklog");
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityOrganization.clickButtonEdit();
        String useredit = " EDIT";
        driver.sleep(3);
        isFieldNameVisible();
        addEntityOrganization.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("EDIT");
        isFieldURLVisible();
        addEntityOrganization.setURL("/com");
        isFieldTextAreaCommentVisible();
        addEntityOrganization.setTextAreaComment("This is a new comment");
        isButtonSendVisible();
        addEntityOrganization.clickButtonSend();
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonDeleteVisible();
        addEntityOrganization.clickButtonDelete();
        driver.sleep(3);
        assertTrue("Customer was not deleted",!networkPage.isUserVisible(user));
     }   
    
    @Test(description = "AddCustomers",dataProvider = "remoteParams")
    public void addProviders(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();    
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        Random r = new Random();
        int low = 0;
        int high = 100;
        Integer result = r.nextInt(high-low) + low;
        String user = "Test" + result;
        addEntityOrganization = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityOrganization.setName(user);
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("This is a description");
        isFieldURLVisible();
        addEntityOrganization.setURL("http://www.elpais.es");
        isFieldWorklogVisible();
        addEntityOrganization.setWorklog("This is a worklog");
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityOrganization.clickButtonEdit();
        String useredit = " EDIT";
        driver.sleep(3);
        isFieldNameVisible();
        addEntityOrganization.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("EDIT");
        isFieldURLVisible();
        addEntityOrganization.setURL("/com");
        isFieldTextAreaCommentVisible();
        addEntityOrganization.setTextAreaComment("This is a new comment");
        isButtonSendVisible();
        addEntityOrganization.clickButtonSend();
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonDeleteVisible();
        addEntityOrganization.clickButtonDelete();
        driver.sleep(3);
        assertTrue("Customer was not deleted",!networkPage.isUserVisible(user));
     }
    
    @Test(description = "AddCustomers",dataProvider = "remoteParams")
    public void addOwners(String remoteParams) {
        //Go to community page
        networkPage = sriHome.clickOnNetwork();    
        driver.sleep(3);
        // Click on item contact in the menu
        isReady();
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        Random r = new Random();
        int low = 0;
        int high = 100;
        Integer result = r.nextInt(high-low) + low;
        String user = "Test" + result;
        addEntityOrganization = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityOrganization.setName(user);
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("This is a description");
        isFieldURLVisible();
        addEntityOrganization.setURL("http://www.elpais.es");
        isFieldWorklogVisible();
        addEntityOrganization.setWorklog("This is a worklog");
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityOrganization.clickButtonEdit();
        String useredit = " EDIT";
        driver.sleep(3);
        isFieldNameVisible();
        addEntityOrganization.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        addEntityOrganization.setDescription("EDIT");
        isFieldURLVisible();
        addEntityOrganization.setURL("/com");
        isFieldTextAreaCommentVisible();
        addEntityOrganization.setTextAreaComment("This is a new comment");
        isButtonSendVisible();
        addEntityOrganization.clickButtonSend();
        isButtonSaveVisible();
        addEntityOrganization.clickButtonSave();
        driver.sleep(3);
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityOrganization = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonDeleteVisible();
        addEntityOrganization.clickButtonDelete();
        driver.sleep(3);
        assertTrue("Customer was not deleted",!networkPage.isUserVisible(user));
     }
    
    public void isReady() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Network is not visible",
                  networkPage.isReady());
          }
    
    public void isMenuItemCustomersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Customers is not visible",
                  networkPage.isMenuItemCustomersVisible());
          }
    
    public void isMenuItemEndUsersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item End Users is not visible",
                  networkPage.isMenuItemEndUsersVisible());
          }
    
    public void isMenuItemProvidersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Providers is not visible",
                  networkPage.isMenuItemProvidersVisible());
          }
    
    public void isMenuItemOwnersVisible() {
    	if (networkPage == null) {
          	networkPage = new NetworkPage(driver);
          }
          assertTrue("Menu item Owners is not visible",
                  networkPage.isMenuItemOwnersVisible());
          }
    
    public void isFieldNameVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Field Name is not visible",
                  addEntityOrganization.isFieldNameVisible());
    }
    
    public void isFieldDescriptionVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Field Description is not visible",
                  addEntityOrganization.isFieldDescriptionVisible());
    }
    
    public void isFieldURLVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Field URL is not visible",
                  addEntityOrganization.isFieldURLVisible());
    }
    
    public void isFieldWorklogVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Field Worklog is not visible",
                  addEntityOrganization.isFieldWorklogVisible());
    }
    
    public void isFieldTextAreaCommentVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Textarea Comment is not visible",
                  addEntityOrganization.isTextAreaCommentVisible());
    }
    
    public void isButtonDeleteVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Button Delete is not visible",
                  addEntityOrganization.isButtonDeleteVisible());
    }
    
    public void isButtonEditVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Button Edit is not visible",
                  addEntityOrganization.isButtonEditVisible());
    }
    
    public void isButtonSaveVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Button Save is not visible",
                  addEntityOrganization.isButtonSaveVisible());
    }
    
    public void isButtonSendVisible() {
    	if (addEntityOrganization == null) {
          	addEntityOrganization = new AddEntityOrganization(driver);
          }
          assertTrue("Button Send is not visible",
                  addEntityOrganization.isButtonSendVisible());
    }
}