package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.AddEntityForNetwork;
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
        //isReady();
        Random r = new Random();
        int low = 0;
        int high = 100;
        Integer result = r.nextInt(high-low) + low;
        String user = "Test" + result;
        addEntityForNetwork = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(user);
        isFieldDescriptionVisible();
        String description = "This is a description";
        addEntityForNetwork.setDescription(description);
        isFieldURLVisible();
        String url = "http://www.elpais.es";
        addEntityForNetwork.setURL(url);
        isFieldWorklogVisible();
        String worklog1 = "This is a worklog";
        addEntityForNetwork.setWorklog(worklog1);
        List<String> worklogs = new ArrayList<String>();
        worklogs.add(worklog1);
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        boolean res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was created with",res);
        driver.sleep(3);
        String useredit = " EDIT";
        isFieldNameVisible();
        addEntityForNetwork.setName(useredit);
        isFieldDescriptionVisible();
        String descriptionedit = "EDIT";
        addEntityForNetwork.setDescription(descriptionedit);
        description = description + descriptionedit;
        isFieldURLVisible();
        String urledit = "/com";
        addEntityForNetwork.setURL(urledit);
        url = url + urledit;
        isFieldTextAreaCommentVisible();
        String worklog2 = "This is a new comment";
        addEntityForNetwork.setTextAreaComment(worklog2);
        worklogs.add(worklog2);
        isButtonSendVisible();
        addEntityForNetwork.clickButtonSend();
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemCustomersVisible();
        networkPage.clickMenuItemCustomers();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        user = user + useredit;
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was created with",res);
        isButtonDeleteVisible();
        addEntityForNetwork.clickButtonDelete();
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
        addEntityForNetwork = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(user);
        isFieldDescriptionVisible();
        String description = "This is a description";
        addEntityForNetwork.setDescription(description);
        isFieldURLVisible();
        String url = "http://www.elpais.es";
        addEntityForNetwork.setURL(url);
        isFieldWorklogVisible();
        String worklog1 = "This is a worklog";
        addEntityForNetwork.setWorklog(worklog1);
        List<String> worklogs = new ArrayList<String>();
        worklogs.add(worklog1);
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        boolean res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was created with",res);
        String useredit = " EDIT";
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        String descriptionedit = "EDIT";
        addEntityForNetwork.setDescription(descriptionedit);
        description = description + descriptionedit;
        isFieldURLVisible();
        String urledit = "/com";
        addEntityForNetwork.setURL(urledit);
        url = url + urledit;
        isFieldTextAreaCommentVisible();
        String worklog2 = "This is a new comment";
        addEntityForNetwork.setTextAreaComment(worklog2);
        worklogs.add(worklog2);
        isButtonSendVisible();
        addEntityForNetwork.clickButtonSend();
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemEndUsersVisible();
        networkPage.clickMenuItemEndUsers();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was edited with",res);
        isButtonDeleteVisible();
        addEntityForNetwork.clickButtonDelete();
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
        addEntityForNetwork = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(user);
        isFieldDescriptionVisible();
        String description = "This is a description";
        addEntityForNetwork.setDescription(description);
        isFieldURLVisible();
        String url = "http://www.elpais.es";
        addEntityForNetwork.setURL(url);
        isFieldWorklogVisible();
        String worklog1 = "This is a worklog";
        addEntityForNetwork.setWorklog(worklog1);
        List<String> worklogs = new ArrayList<String>();
        worklogs.add(worklog1);
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        boolean res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was created with",res);
        String useredit = " EDIT";
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        String descriptionedit = "EDIT";
        addEntityForNetwork.setDescription(descriptionedit);
        description = description + descriptionedit;
        isFieldURLVisible();
        String urledit = "/com";
        addEntityForNetwork.setURL(urledit);
        url = url + urledit;
        isFieldTextAreaCommentVisible();
        String worklog2 = "This is a new comment";
        addEntityForNetwork.setTextAreaComment(worklog2);
        worklogs.add(worklog2);
        isButtonSendVisible();
        addEntityForNetwork.clickButtonSend();
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemProvidersVisible();
        networkPage.clickMenuItemProviders();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was edited with",res);
        isButtonDeleteVisible();
        addEntityForNetwork.clickButtonDelete();
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
        addEntityForNetwork = networkPage.clickAddButton();
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(user);
        isFieldDescriptionVisible();
        String description = "This is a description";
        addEntityForNetwork.setDescription(description);
        isFieldURLVisible();
        String url = "http://www.elpais.es";
        addEntityForNetwork.setURL(url);
        isFieldWorklogVisible();
        String worklog1 = "This is a worklog";
        addEntityForNetwork.setWorklog(worklog1);
        List<String> worklogs = new ArrayList<String>();
        worklogs.add(worklog1);
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        assertTrue("Customer was not created",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        boolean res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was created with",res);
        String useredit = " EDIT";
        driver.sleep(3);
        isFieldNameVisible();
        addEntityForNetwork.setName(useredit);
        user = user + useredit;
        isFieldDescriptionVisible();
        String descriptionedit = "EDIT";
        addEntityForNetwork.setDescription(descriptionedit);
        description = description + descriptionedit;
        isFieldURLVisible();
        String urledit = "/com";
        addEntityForNetwork.setURL(urledit);
        url = url + urledit;
        isFieldTextAreaCommentVisible();
        String worklog2 = "This is a new comment";
        addEntityForNetwork.setTextAreaComment(worklog2);
        worklogs.add(worklog2);
        isButtonSendVisible();
        addEntityForNetwork.clickButtonSend();
        isButtonSaveVisible();
        addEntityForNetwork.clickButtonSave();
        driver.sleep(3);
        isMenuItemOwnersVisible();
        networkPage.clickMenuItemOwners();
        driver.sleep(3);
        assertTrue("Customer was not updated",networkPage.isUserVisible(user));
        addEntityForNetwork = networkPage.clickInUser(user);
        driver.sleep(3);
        isButtonEditVisible();
        addEntityForNetwork.clickButtonEdit();
        res = addEntityForNetwork.equals(user, description, url, worklogs);
        assertTrue("The fields don't display the same info which it was edited with",res);
        isButtonDeleteVisible();
        addEntityForNetwork.clickButtonDelete();
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
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Field Name is not visible",
                  addEntityForNetwork.isFieldNameVisible());
    }
    
    public void isFieldDescriptionVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Field Description is not visible",
                  addEntityForNetwork.isFieldDescriptionVisible());
    }
    
    public void isFieldURLVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Field URL is not visible",
                  addEntityForNetwork.isFieldURLVisible());
    }
    
    public void isFieldWorklogVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Field Worklog is not visible",
                  addEntityForNetwork.isFieldWorklogVisible());
    }
    
    public void isFieldTextAreaCommentVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Textarea Comment is not visible",
                  addEntityForNetwork.isTextAreaCommentVisible());
    }
    
    public void isButtonDeleteVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Button Delete is not visible",
                  addEntityForNetwork.isButtonDeleteVisible());
    }
    
    public void isButtonEditVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Button Edit is not visible",
                  addEntityForNetwork.isButtonEditVisible());
    }
    
    public void isButtonSaveVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Button Save is not visible",
                  addEntityForNetwork.isButtonSaveVisible());
    }
    
    public void isButtonSendVisible() {
    	if (addEntityForNetwork == null) {
          	addEntityForNetwork = new AddEntityForNetwork(driver);
          }
          assertTrue("Button Send is not visible",
                  addEntityForNetwork.isButtonSendVisible());
    }
}